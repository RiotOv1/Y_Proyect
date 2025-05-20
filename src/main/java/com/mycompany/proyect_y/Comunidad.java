
package com.mycompany.proyect_y;

import Conection.DB_Conection;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;


public class Comunidad extends javax.swing.JFrame {

    public Comunidad() {
        initComponents();
        this.setLocationRelativeTo(null);
        mostrarUsuariosAleatorios();
        Img();
        cargarFotoPerfil(); 
        Connection con =  DB_Conection.conectar(); // tu clase de conexión
        String Id =SesionUsuario.idUsuario;
        if (Id != null) {
            String nom = obtenerNombreUsuario();
            NombreUsuario.setText(nom);
            IdUsuario2.setText( "@" + Id);
            
    }

    }
        public String obtenerNombreUsuario() {
            String nombre = "";
            String apellido = "";
            Connection con =  DB_Conection.conectar(); // tu clase de conexión
            if (con != null) {
                try {
                    String sql = "SELECT nombre, apellido FROM usuario WHERE id_usuario = ?";
                    PreparedStatement ps = con.prepareStatement(sql);
                    ps.setString(1, SesionUsuario.idUsuario); // usamos el ID guardado en la sesión
                    ResultSet rs = ps.executeQuery();
                        
                    if (rs.next()) {
                        nombre = rs.getString("nombre");
                        apellido = rs.getString("apellido");
                    }

                    rs.close();
                    ps.close();

                } catch (SQLException e) {
            }
        }

        return (nombre + " " + apellido);
    }
       
    public void cargarFotoPerfil() {
        Connection con = DB_Conection.conectar();
        
        if (con != null) {
            try {
                String sql = "SELECT foto_perfil FROM usuario WHERE id_usuario = ?";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, SesionUsuario.idUsuario);
                ResultSet rs = ps.executeQuery();
                
                if (rs.next()) {
                    byte[] imagenBytes = rs.getBytes("foto_perfil");
                    
                    if (imagenBytes != null) {
                        ImageIcon icon = new ImageIcon(imagenBytes);
                        Image img = icon.getImage().getScaledInstance(Perfil_Img.getWidth(), Perfil_Img.getHeight(), Image.SCALE_SMOOTH);
                        Perfil_Img.setIcon(new ImageIcon(img));
                        
                    } else {
                        Perfil_Img.setText("Sin imagen");
                    }
                }
                
                rs.close();
                ps.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

        public void Img() {

        //Creamos el objeto UIManager.setLookAndFeel();
        //Definimos la ruta de la imagen
        String url = "src\\main\\java\\Multimedia\\Img-Perfil.png";
        //Importamos la libreria de ImageIcon y creamos un objeto Ademas añadimos la ruta de la imagen
        ImageIcon image = new ImageIcon(url);
        //Importamos la libreria Image, Creamos un objeto, obtenemos la imagen, y la escalamos (Width, Heigh, Escala)
        Image img = image.getImage().getScaledInstance(48, 48, 0);
        //Creamos el Objeto de el icono y añadimos la imagen con las instancias
        ImageIcon Icono = new ImageIcon(img);
        //Ponemos la imagen la etiqueta que querramos
        Perfil_Img.setIcon(Icono);

        //IconoInicio
        String url1 = "src\\main\\java\\Multimedia\\Icon-Inicio.png";
        ImageIcon image1 = new ImageIcon(url1);
        Image img1 = image1.getImage().getScaledInstance(32, 32, 0);
        ImageIcon Icono1 = new ImageIcon(img1);
        InicioBtn1.setIcon(Icono1);

        //IconoExplorar
        String url2 = "src\\main\\java\\Multimedia\\Icon-Explorar.png";
        ImageIcon image2 = new ImageIcon(url2);
        Image img2 = image2.getImage().getScaledInstance(32, 32, 0);
        ImageIcon Icono2 = new ImageIcon(img2);
        ExplorarBtn1.setIcon(Icono2);
        //BuscadorImagen.setIcon(Icono2);

        //IconoNotificaciones
        String url3 = "src\\main\\java\\Multimedia\\Icon-Notificaciones.png";
        ImageIcon image3 = new ImageIcon(url3);
        Image img3 = image3.getImage().getScaledInstance(32, 32, 0);
        ImageIcon Icono3 = new ImageIcon(img3);
        NotificacionesBtn.setIcon(Icono3);

        //IconoComunidades
        String url4 = "src\\main\\java\\Multimedia\\Icon-Comunidades.png";
        ImageIcon image4 = new ImageIcon(url4);
        Image img4 = image4.getImage().getScaledInstance(32, 32, 0);
        ImageIcon Icono4 = new ImageIcon(img4);
        ComunidadesBtn.setIcon(Icono4);
        
                //IconoComunidades
        String url43 = "src\\main\\java\\Multimedia\\Icon-Comunidades.png";
        ImageIcon image43 = new ImageIcon(url43);
        Image img43 = image43.getImage().getScaledInstance(32, 32, 0);
        ImageIcon Icono43 = new ImageIcon(img43);
        FotodeComunidadBtn.setIcon(Icono43);

        //IconoGuardados
        String url5 = "src\\main\\java\\Multimedia\\Icon-Guardado.png";
        ImageIcon image5 = new ImageIcon(url5);
        Image img5 = image5.getImage().getScaledInstance(32, 32, 0);
        ImageIcon Icono5 = new ImageIcon(img5);
        GuardadoBtn.setIcon(Icono5);

        //IconoPerfil
        String url6 = "src\\main\\java\\Multimedia\\Icon-Usuario.png";
        ImageIcon image6 = new ImageIcon(url6);
        Image img6 = image6.getImage().getScaledInstance(32, 32, 0);
        ImageIcon Icono6 = new ImageIcon(img6);
        PerfilBtn.setIcon(Icono6);

        //Icono Y Logo
        String url13 = "src\\main\\java\\Multimedia\\YSinfondo.png";
        ImageIcon image13 = new ImageIcon(url13);
        Image img13 = image13.getImage().getScaledInstance(90, 90, 0);
        ImageIcon Icono13 = new ImageIcon(img13);
        Y_logo.setIcon(Icono13);

        //Icono Configuracion
        String url14 = "src\\main\\java\\Multimedia\\Icono-Configuracion.png";
        ImageIcon image14 = new ImageIcon(url14);
        Image img14 = image14.getImage().getScaledInstance(34, 34, 0);
        ImageIcon Icono14 = new ImageIcon(img14);
        ConfiBtn.setIcon(Icono14);

    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelTotalComunidad = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        BarraBusquedaBtn = new javax.swing.JButton();
        SeguirComunidadBtn = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        FiltrarReYaps = new javax.swing.JButton();
        FiltrarDestacados = new javax.swing.JButton();
        FiltrarMultimedia = new javax.swing.JButton();
        FiltrarYaps = new javax.swing.JButton();
        FiltrarEventos = new javax.swing.JButton();
        FiltrarSeguidores = new javax.swing.JButton();
        PortadaPanel = new javax.swing.JPanel();
        SeguidoresBtn = new javax.swing.JButton();
        NoSeguidoresBtn = new javax.swing.JButton();
        CuentaBtn1 = new javax.swing.JButton();
        UsuarioComunidad = new javax.swing.JButton();
        NombreComunidad = new javax.swing.JLabel();
        YapsBtn = new javax.swing.JButton();
        ContadorYaps = new javax.swing.JButton();
        DescripcionComunidadBtn = new javax.swing.JButton();
        PublicacionesBtn2 = new javax.swing.JButton();
        QuePasa = new javax.swing.JLabel();
        SeguirCuentaBtn3 = new javax.swing.JButton();
        SeguirCuentaBtn1 = new javax.swing.JButton();
        SeguirCuentaBtn2 = new javax.swing.JButton();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        jLabel40 = new javax.swing.JLabel();
        TendenciaYapBtn2 = new javax.swing.JButton();
        MostrarMasTendenciaBtn = new javax.swing.JButton();
        CuentaBtn20 = new javax.swing.JButton();
        TendenciaYapBtn1 = new javax.swing.JButton();
        PublicacionesBtn1 = new javax.swing.JButton();
        MostrarMasInteresBtn = new javax.swing.JButton();
        ImgInt3 = new javax.swing.JLabel();
        ImgInt1 = new javax.swing.JLabel();
        ImgInt2 = new javax.swing.JLabel();
        UserInt3 = new javax.swing.JButton();
        UserInt1 = new javax.swing.JButton();
        UserInt2 = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        PanelNot1 = new javax.swing.JPanel();
        UsuarioPub1 = new javax.swing.JButton();
        NombrePub1 = new javax.swing.JLabel();
        DescripcionPub1 = new javax.swing.JLabel();
        ImgPub1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        PanelNot2 = new javax.swing.JPanel();
        UsuarioPub2 = new javax.swing.JButton();
        NombrePub2 = new javax.swing.JLabel();
        DescripcionPub2 = new javax.swing.JLabel();
        ImgPub2 = new javax.swing.JLabel();
        PanelNot3 = new javax.swing.JPanel();
        UsuarioPub3 = new javax.swing.JButton();
        NombrePub3 = new javax.swing.JLabel();
        DescripcionPub3 = new javax.swing.JLabel();
        ImgPub3 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        PerfilPanel = new javax.swing.JPanel();
        NombreUsuario = new javax.swing.JLabel();
        IdUsuario2 = new javax.swing.JLabel();
        Perfil_Img = new javax.swing.JLabel();
        PostearBtn = new javax.swing.JButton();
        FotodeComunidadBtn = new javax.swing.JButton();
        ConfiBtn = new javax.swing.JButton();
        InicioBtn1 = new javax.swing.JButton();
        ComunidadesBtn = new javax.swing.JButton();
        NotificacionesBtn = new javax.swing.JButton();
        GuardadoBtn = new javax.swing.JButton();
        PerfilBtn = new javax.swing.JButton();
        ExplorarBtn1 = new javax.swing.JButton();
        Y_logo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setLocationByPlatform(true);
        setMaximumSize(new java.awt.Dimension(1550, 820));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1550, 820));
        setResizable(false);

        PanelTotalComunidad.setBackground(new java.awt.Color(0, 0, 0));
        PanelTotalComunidad.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator1.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator1.setForeground(new java.awt.Color(153, 153, 153));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        PanelTotalComunidad.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(427, 0, -1, 1040));

        BarraBusquedaBtn.setBackground(new java.awt.Color(0, 0, 0));
        BarraBusquedaBtn.setForeground(new java.awt.Color(255, 255, 255));
        BarraBusquedaBtn.setText("🔍Buscar");
        BarraBusquedaBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        PanelTotalComunidad.add(BarraBusquedaBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 140, 190, 30));

        SeguirComunidadBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        SeguirComunidadBtn.setText("Seguir");
        PanelTotalComunidad.add(SeguirComunidadBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 140, -1, -1));

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        FiltrarReYaps.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        FiltrarReYaps.setForeground(new java.awt.Color(204, 204, 204));
        FiltrarReYaps.setText("Re-Yap's");
        FiltrarReYaps.setToolTipText("");
        FiltrarReYaps.setBorder(null);
        FiltrarReYaps.setBorderPainted(false);
        FiltrarReYaps.setContentAreaFilled(false);
        FiltrarReYaps.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        FiltrarReYaps.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        FiltrarReYaps.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FiltrarReYapsActionPerformed(evt);
            }
        });

        FiltrarDestacados.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        FiltrarDestacados.setForeground(new java.awt.Color(204, 204, 204));
        FiltrarDestacados.setText("Destacados");
        FiltrarDestacados.setToolTipText("");
        FiltrarDestacados.setBorder(null);
        FiltrarDestacados.setBorderPainted(false);
        FiltrarDestacados.setContentAreaFilled(false);
        FiltrarDestacados.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        FiltrarDestacados.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        FiltrarDestacados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FiltrarDestacadosActionPerformed(evt);
            }
        });

        FiltrarMultimedia.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        FiltrarMultimedia.setForeground(new java.awt.Color(204, 204, 204));
        FiltrarMultimedia.setText("Multimedia");
        FiltrarMultimedia.setToolTipText("");
        FiltrarMultimedia.setBorder(null);
        FiltrarMultimedia.setBorderPainted(false);
        FiltrarMultimedia.setContentAreaFilled(false);
        FiltrarMultimedia.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        FiltrarMultimedia.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        FiltrarMultimedia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FiltrarMultimediaActionPerformed(evt);
            }
        });

        FiltrarYaps.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        FiltrarYaps.setForeground(new java.awt.Color(204, 204, 204));
        FiltrarYaps.setText("Yap's");
        FiltrarYaps.setToolTipText("");
        FiltrarYaps.setBorder(null);
        FiltrarYaps.setBorderPainted(false);
        FiltrarYaps.setContentAreaFilled(false);
        FiltrarYaps.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        FiltrarYaps.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        FiltrarYaps.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FiltrarYapsActionPerformed(evt);
            }
        });

        FiltrarEventos.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        FiltrarEventos.setForeground(new java.awt.Color(204, 204, 204));
        FiltrarEventos.setText("Eventos");
        FiltrarEventos.setToolTipText("");
        FiltrarEventos.setBorder(null);
        FiltrarEventos.setBorderPainted(false);
        FiltrarEventos.setContentAreaFilled(false);
        FiltrarEventos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        FiltrarEventos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        FiltrarEventos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FiltrarEventosActionPerformed(evt);
            }
        });

        FiltrarSeguidores.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        FiltrarSeguidores.setForeground(new java.awt.Color(204, 204, 204));
        FiltrarSeguidores.setText("Seguidores");
        FiltrarSeguidores.setToolTipText("");
        FiltrarSeguidores.setBorder(null);
        FiltrarSeguidores.setBorderPainted(false);
        FiltrarSeguidores.setContentAreaFilled(false);
        FiltrarSeguidores.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        FiltrarSeguidores.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        FiltrarSeguidores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FiltrarSeguidoresActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(FiltrarYaps)
                .addGap(51, 51, 51)
                .addComponent(FiltrarReYaps, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(FiltrarDestacados)
                .addGap(50, 50, 50)
                .addComponent(FiltrarMultimedia)
                .addGap(51, 51, 51)
                .addComponent(FiltrarEventos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(FiltrarSeguidores)
                .addGap(36, 36, 36))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FiltrarReYaps, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FiltrarDestacados, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FiltrarMultimedia, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FiltrarYaps, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FiltrarEventos, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FiltrarSeguidores, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        PanelTotalComunidad.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 220, 750, 40));

        PortadaPanel.setBackground(new java.awt.Color(59, 28, 50));
        PortadaPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        PortadaPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        SeguidoresBtn.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        SeguidoresBtn.setForeground(new java.awt.Color(204, 204, 204));
        SeguidoresBtn.setText("Seguidores");
        SeguidoresBtn.setBorder(null);
        SeguidoresBtn.setBorderPainted(false);
        SeguidoresBtn.setContentAreaFilled(false);
        SeguidoresBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SeguidoresBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        SeguidoresBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SeguidoresBtnActionPerformed(evt);
            }
        });

        NoSeguidoresBtn.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        NoSeguidoresBtn.setForeground(new java.awt.Color(204, 204, 204));
        NoSeguidoresBtn.setText("0");
        NoSeguidoresBtn.setBorder(null);
        NoSeguidoresBtn.setBorderPainted(false);
        NoSeguidoresBtn.setContentAreaFilled(false);
        NoSeguidoresBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        NoSeguidoresBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        NoSeguidoresBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NoSeguidoresBtnActionPerformed(evt);
            }
        });

        CuentaBtn1.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        CuentaBtn1.setForeground(new java.awt.Color(204, 204, 204));
        CuentaBtn1.setText("<agregar fondo>");
        CuentaBtn1.setBorder(null);
        CuentaBtn1.setBorderPainted(false);
        CuentaBtn1.setContentAreaFilled(false);
        CuentaBtn1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CuentaBtn1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        CuentaBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CuentaBtn1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PortadaPanelLayout = new javax.swing.GroupLayout(PortadaPanel);
        PortadaPanel.setLayout(PortadaPanelLayout);
        PortadaPanelLayout.setHorizontalGroup(
            PortadaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PortadaPanelLayout.createSequentialGroup()
                .addContainerGap(636, Short.MAX_VALUE)
                .addComponent(NoSeguidoresBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SeguidoresBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
            .addGroup(PortadaPanelLayout.createSequentialGroup()
                .addGap(162, 162, 162)
                .addComponent(CuentaBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(456, Short.MAX_VALUE))
        );
        PortadaPanelLayout.setVerticalGroup(
            PortadaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PortadaPanelLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(CuentaBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(PortadaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SeguidoresBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NoSeguidoresBtn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PanelTotalComunidad.add(PortadaPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 0, 750, 130));

        UsuarioComunidad.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        UsuarioComunidad.setForeground(new java.awt.Color(204, 204, 204));
        UsuarioComunidad.setText("@Usuario");
        UsuarioComunidad.setToolTipText("");
        UsuarioComunidad.setBorder(null);
        UsuarioComunidad.setBorderPainted(false);
        UsuarioComunidad.setContentAreaFilled(false);
        UsuarioComunidad.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        UsuarioComunidad.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        UsuarioComunidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsuarioComunidadActionPerformed(evt);
            }
        });
        PanelTotalComunidad.add(UsuarioComunidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 150, -1, -1));

        NombreComunidad.setFont(new java.awt.Font("Roboto Black", 1, 22)); // NOI18N
        NombreComunidad.setForeground(new java.awt.Color(204, 204, 204));
        NombreComunidad.setText("Comunidad");
        PanelTotalComunidad.add(NombreComunidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 150, -1, 19));

        YapsBtn.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        YapsBtn.setForeground(new java.awt.Color(204, 204, 204));
        YapsBtn.setText("Yap's");
        YapsBtn.setBorder(null);
        YapsBtn.setBorderPainted(false);
        YapsBtn.setContentAreaFilled(false);
        YapsBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        YapsBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        YapsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                YapsBtnActionPerformed(evt);
            }
        });
        PanelTotalComunidad.add(YapsBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 190, 50, 20));

        ContadorYaps.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        ContadorYaps.setForeground(new java.awt.Color(204, 204, 204));
        ContadorYaps.setText("0");
        ContadorYaps.setBorder(null);
        ContadorYaps.setBorderPainted(false);
        ContadorYaps.setContentAreaFilled(false);
        ContadorYaps.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ContadorYaps.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ContadorYaps.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContadorYapsActionPerformed(evt);
            }
        });
        PanelTotalComunidad.add(ContadorYaps, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 190, 10, 20));

        DescripcionComunidadBtn.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        DescripcionComunidadBtn.setForeground(new java.awt.Color(204, 204, 204));
        DescripcionComunidadBtn.setText("Descripcion...");
        DescripcionComunidadBtn.setBorder(null);
        DescripcionComunidadBtn.setBorderPainted(false);
        DescripcionComunidadBtn.setContentAreaFilled(false);
        DescripcionComunidadBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DescripcionComunidadBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        DescripcionComunidadBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DescripcionComunidadBtnActionPerformed(evt);
            }
        });
        PanelTotalComunidad.add(DescripcionComunidadBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 170, 570, 50));

        PublicacionesBtn2.setFont(new java.awt.Font("Roboto Black", 0, 10)); // NOI18N
        PublicacionesBtn2.setForeground(new java.awt.Color(204, 204, 204));
        PublicacionesBtn2.setText("1000 publicaciones");
        PublicacionesBtn2.setBorder(null);
        PublicacionesBtn2.setBorderPainted(false);
        PublicacionesBtn2.setContentAreaFilled(false);
        PublicacionesBtn2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PublicacionesBtn2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        PublicacionesBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PublicacionesBtn2ActionPerformed(evt);
            }
        });
        PanelTotalComunidad.add(PublicacionesBtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 560, 100, 30));

        QuePasa.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        QuePasa.setForeground(new java.awt.Color(204, 204, 204));
        QuePasa.setText("Qué pasa");
        PanelTotalComunidad.add(QuePasa, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 370, 210, 30));

        SeguirCuentaBtn3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        SeguirCuentaBtn3.setText("Seguir");
        PanelTotalComunidad.add(SeguirCuentaBtn3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1400, 230, -1, 30));

        SeguirCuentaBtn1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        SeguirCuentaBtn1.setText("Seguir");
        PanelTotalComunidad.add(SeguirCuentaBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1400, 130, -1, 30));

        SeguirCuentaBtn2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        SeguirCuentaBtn2.setText("Seguir");
        PanelTotalComunidad.add(SeguirCuentaBtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1400, 180, -1, 30));

        jSeparator6.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator6.setForeground(new java.awt.Color(153, 153, 153));
        jSeparator6.setOrientation(javax.swing.SwingConstants.VERTICAL);
        PanelTotalComunidad.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 80, 30, 220));

        jSeparator7.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator7.setForeground(new java.awt.Color(153, 153, 153));
        jSeparator7.setOrientation(javax.swing.SwingConstants.VERTICAL);
        PanelTotalComunidad.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1490, 80, 20, 220));
        PanelTotalComunidad.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 300, 280, 20));
        PanelTotalComunidad.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 80, 280, 10));

        jLabel40.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(204, 204, 204));
        jLabel40.setText("Te puede interesar");
        PanelTotalComunidad.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 80, 210, 30));

        TendenciaYapBtn2.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        TendenciaYapBtn2.setForeground(new java.awt.Color(204, 204, 204));
        TendenciaYapBtn2.setText("Descripción");
        TendenciaYapBtn2.setBorder(null);
        TendenciaYapBtn2.setBorderPainted(false);
        TendenciaYapBtn2.setContentAreaFilled(false);
        TendenciaYapBtn2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TendenciaYapBtn2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        TendenciaYapBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TendenciaYapBtn2ActionPerformed(evt);
            }
        });
        PanelTotalComunidad.add(TendenciaYapBtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 490, 130, 50));

        MostrarMasTendenciaBtn.setFont(new java.awt.Font("Roboto Black", 0, 10)); // NOI18N
        MostrarMasTendenciaBtn.setForeground(new java.awt.Color(204, 204, 204));
        MostrarMasTendenciaBtn.setText("Mostrar mas");
        MostrarMasTendenciaBtn.setBorder(null);
        MostrarMasTendenciaBtn.setBorderPainted(false);
        MostrarMasTendenciaBtn.setContentAreaFilled(false);
        MostrarMasTendenciaBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MostrarMasTendenciaBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        MostrarMasTendenciaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MostrarMasTendenciaBtnActionPerformed(evt);
            }
        });
        PanelTotalComunidad.add(MostrarMasTendenciaBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 580, 80, 50));

        CuentaBtn20.setFont(new java.awt.Font("Roboto Black", 0, 10)); // NOI18N
        CuentaBtn20.setForeground(new java.awt.Color(204, 204, 204));
        CuentaBtn20.setText("Tendencias");
        CuentaBtn20.setBorder(null);
        CuentaBtn20.setBorderPainted(false);
        CuentaBtn20.setContentAreaFilled(false);
        CuentaBtn20.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CuentaBtn20.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        CuentaBtn20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CuentaBtn20ActionPerformed(evt);
            }
        });
        PanelTotalComunidad.add(CuentaBtn20, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 390, 80, 30));

        TendenciaYapBtn1.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        TendenciaYapBtn1.setForeground(new java.awt.Color(204, 204, 204));
        TendenciaYapBtn1.setText("Descripción");
        TendenciaYapBtn1.setBorder(null);
        TendenciaYapBtn1.setBorderPainted(false);
        TendenciaYapBtn1.setContentAreaFilled(false);
        TendenciaYapBtn1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TendenciaYapBtn1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        TendenciaYapBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TendenciaYapBtn1ActionPerformed(evt);
            }
        });
        PanelTotalComunidad.add(TendenciaYapBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 410, 130, 50));

        PublicacionesBtn1.setFont(new java.awt.Font("Roboto Black", 0, 10)); // NOI18N
        PublicacionesBtn1.setForeground(new java.awt.Color(204, 204, 204));
        PublicacionesBtn1.setText("1000 publicaciones");
        PublicacionesBtn1.setBorder(null);
        PublicacionesBtn1.setBorderPainted(false);
        PublicacionesBtn1.setContentAreaFilled(false);
        PublicacionesBtn1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PublicacionesBtn1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        PublicacionesBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PublicacionesBtn1ActionPerformed(evt);
            }
        });
        PanelTotalComunidad.add(PublicacionesBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 460, 100, 50));

        MostrarMasInteresBtn.setFont(new java.awt.Font("Roboto Black", 0, 10)); // NOI18N
        MostrarMasInteresBtn.setForeground(new java.awt.Color(204, 204, 204));
        MostrarMasInteresBtn.setText("Mostrar mas");
        MostrarMasInteresBtn.setBorder(null);
        MostrarMasInteresBtn.setBorderPainted(false);
        MostrarMasInteresBtn.setContentAreaFilled(false);
        MostrarMasInteresBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MostrarMasInteresBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        MostrarMasInteresBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MostrarMasInteresBtnActionPerformed(evt);
            }
        });
        PanelTotalComunidad.add(MostrarMasInteresBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 260, 80, 50));

        ImgInt3.setForeground(new java.awt.Color(255, 255, 255));
        ImgInt3.setText("ImgInteres2");
        PanelTotalComunidad.add(ImgInt3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 220, 60, 50));

        ImgInt1.setForeground(new java.awt.Color(255, 255, 255));
        ImgInt1.setText("ImgInteres1");
        PanelTotalComunidad.add(ImgInt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 120, 60, 50));

        ImgInt2.setForeground(new java.awt.Color(255, 255, 255));
        ImgInt2.setText("ImgInteres2");
        PanelTotalComunidad.add(ImgInt2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 170, 60, 50));

        UserInt3.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        UserInt3.setForeground(new java.awt.Color(204, 204, 204));
        UserInt3.setText("@Usuario");
        UserInt3.setToolTipText("");
        UserInt3.setBorder(null);
        UserInt3.setBorderPainted(false);
        UserInt3.setContentAreaFilled(false);
        UserInt3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        UserInt3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        UserInt3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserInt3ActionPerformed(evt);
            }
        });
        PanelTotalComunidad.add(UserInt3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 230, -1, 30));

        UserInt1.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        UserInt1.setForeground(new java.awt.Color(204, 204, 204));
        UserInt1.setText("@Usuario");
        UserInt1.setToolTipText("");
        UserInt1.setBorder(null);
        UserInt1.setBorderPainted(false);
        UserInt1.setContentAreaFilled(false);
        UserInt1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        UserInt1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        UserInt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserInt1ActionPerformed(evt);
            }
        });
        PanelTotalComunidad.add(UserInt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 130, -1, 30));

        UserInt2.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        UserInt2.setForeground(new java.awt.Color(204, 204, 204));
        UserInt2.setText("@Usuario");
        UserInt2.setToolTipText("");
        UserInt2.setBorder(null);
        UserInt2.setBorderPainted(false);
        UserInt2.setContentAreaFilled(false);
        UserInt2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        UserInt2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        UserInt2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserInt2ActionPerformed(evt);
            }
        });
        PanelTotalComunidad.add(UserInt2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 180, -1, 30));

        jSeparator4.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator4.setForeground(new java.awt.Color(153, 153, 153));
        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);
        PanelTotalComunidad.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 0, 10, 1040));

        PanelNot1.setBackground(new java.awt.Color(59, 28, 50));
        PanelNot1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        PanelNot1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        UsuarioPub1.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        UsuarioPub1.setForeground(new java.awt.Color(204, 204, 204));
        UsuarioPub1.setText("@Usuario");
        UsuarioPub1.setToolTipText("");
        UsuarioPub1.setBorder(null);
        UsuarioPub1.setBorderPainted(false);
        UsuarioPub1.setContentAreaFilled(false);
        UsuarioPub1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        UsuarioPub1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        UsuarioPub1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsuarioPub1ActionPerformed(evt);
            }
        });

        NombrePub1.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        NombrePub1.setForeground(new java.awt.Color(204, 204, 204));
        NombrePub1.setText("Usuario");

        DescripcionPub1.setFont(new java.awt.Font("Roboto Black", 0, 12)); // NOI18N
        DescripcionPub1.setForeground(new java.awt.Color(204, 204, 204));
        DescripcionPub1.setText("Descripcion...");

        ImgPub1.setForeground(new java.awt.Color(255, 255, 255));
        ImgPub1.setText("ImgNot");

        javax.swing.GroupLayout PanelNot1Layout = new javax.swing.GroupLayout(PanelNot1);
        PanelNot1.setLayout(PanelNot1Layout);
        PanelNot1Layout.setHorizontalGroup(
            PanelNot1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelNot1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelNot1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DescripcionPub1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(PanelNot1Layout.createSequentialGroup()
                        .addComponent(ImgPub1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(NombrePub1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(UsuarioPub1)
                        .addGap(0, 230, Short.MAX_VALUE)))
                .addContainerGap())
        );
        PanelNot1Layout.setVerticalGroup(
            PanelNot1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelNot1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelNot1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ImgPub1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NombrePub1)
                    .addComponent(UsuarioPub1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DescripcionPub1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PanelTotalComunidad.add(PanelNot1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 270, 450, 150));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ImagenPublicacion1");
        PanelTotalComunidad.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 270, 280, 150));

        PanelNot2.setBackground(new java.awt.Color(106, 30, 85));
        PanelNot2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        PanelNot2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        UsuarioPub2.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        UsuarioPub2.setForeground(new java.awt.Color(204, 204, 204));
        UsuarioPub2.setText("@Usuario");
        UsuarioPub2.setToolTipText("");
        UsuarioPub2.setBorder(null);
        UsuarioPub2.setBorderPainted(false);
        UsuarioPub2.setContentAreaFilled(false);
        UsuarioPub2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        UsuarioPub2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        UsuarioPub2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsuarioPub2ActionPerformed(evt);
            }
        });

        NombrePub2.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        NombrePub2.setForeground(new java.awt.Color(204, 204, 204));
        NombrePub2.setText("Usuario");

        DescripcionPub2.setFont(new java.awt.Font("Roboto Black", 0, 12)); // NOI18N
        DescripcionPub2.setForeground(new java.awt.Color(204, 204, 204));
        DescripcionPub2.setText("Descripcion...");

        ImgPub2.setForeground(new java.awt.Color(255, 255, 255));
        ImgPub2.setText("ImgNot");

        javax.swing.GroupLayout PanelNot2Layout = new javax.swing.GroupLayout(PanelNot2);
        PanelNot2.setLayout(PanelNot2Layout);
        PanelNot2Layout.setHorizontalGroup(
            PanelNot2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelNot2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelNot2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DescripcionPub2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(PanelNot2Layout.createSequentialGroup()
                        .addComponent(ImgPub2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(NombrePub2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(UsuarioPub2)
                        .addGap(0, 230, Short.MAX_VALUE)))
                .addContainerGap())
        );
        PanelNot2Layout.setVerticalGroup(
            PanelNot2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelNot2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelNot2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ImgPub2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NombrePub2)
                    .addComponent(UsuarioPub2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DescripcionPub2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PanelTotalComunidad.add(PanelNot2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 440, 450, 150));

        PanelNot3.setBackground(new java.awt.Color(166, 77, 121));
        PanelNot3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        PanelNot3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        UsuarioPub3.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        UsuarioPub3.setForeground(new java.awt.Color(204, 204, 204));
        UsuarioPub3.setText("@Usuario");
        UsuarioPub3.setToolTipText("");
        UsuarioPub3.setBorder(null);
        UsuarioPub3.setBorderPainted(false);
        UsuarioPub3.setContentAreaFilled(false);
        UsuarioPub3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        UsuarioPub3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        UsuarioPub3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsuarioPub3ActionPerformed(evt);
            }
        });

        NombrePub3.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        NombrePub3.setForeground(new java.awt.Color(204, 204, 204));
        NombrePub3.setText("Usuario");

        DescripcionPub3.setFont(new java.awt.Font("Roboto Black", 0, 12)); // NOI18N
        DescripcionPub3.setForeground(new java.awt.Color(204, 204, 204));
        DescripcionPub3.setText("Descripcion...");

        ImgPub3.setForeground(new java.awt.Color(255, 255, 255));
        ImgPub3.setText("ImgNot");

        javax.swing.GroupLayout PanelNot3Layout = new javax.swing.GroupLayout(PanelNot3);
        PanelNot3.setLayout(PanelNot3Layout);
        PanelNot3Layout.setHorizontalGroup(
            PanelNot3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelNot3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelNot3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DescripcionPub3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(PanelNot3Layout.createSequentialGroup()
                        .addComponent(ImgPub3, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(NombrePub3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(UsuarioPub3)
                        .addGap(0, 230, Short.MAX_VALUE)))
                .addContainerGap())
        );
        PanelNot3Layout.setVerticalGroup(
            PanelNot3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelNot3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelNot3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ImgPub3, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NombrePub3)
                    .addComponent(UsuarioPub3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DescripcionPub3, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PanelTotalComunidad.add(PanelNot3, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 610, 450, 150));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("ImagenPublicacion2");
        PanelTotalComunidad.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 440, 280, 150));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("ImagenPublicacion3");
        PanelTotalComunidad.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 610, 280, 150));

        PerfilPanel.setBackground(new java.awt.Color(0, 0, 0));
        PerfilPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        NombreUsuario.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        NombreUsuario.setForeground(new java.awt.Color(204, 204, 204));
        NombreUsuario.setText("Usuario");
        PerfilPanel.add(NombreUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, -1));

        IdUsuario2.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        IdUsuario2.setForeground(new java.awt.Color(106, 30, 85));
        IdUsuario2.setText("@Usuario1");
        PerfilPanel.add(IdUsuario2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, -1, -1));
        PerfilPanel.add(Perfil_Img, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 50, 50));

        PanelTotalComunidad.add(PerfilPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 720, 270, 60));

        PostearBtn.setBackground(new java.awt.Color(166, 77, 121));
        PostearBtn.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        PostearBtn.setForeground(new java.awt.Color(204, 204, 204));
        PostearBtn.setText("Publicación");
        PostearBtn.setToolTipText("");
        PostearBtn.setAlignmentY(0.0F);
        PostearBtn.setBorderPainted(false);
        PostearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PostearBtnActionPerformed(evt);
            }
        });
        PanelTotalComunidad.add(PostearBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 680, 200, 40));

        FotodeComunidadBtn.setBackground(new java.awt.Color(166, 77, 121));
        FotodeComunidadBtn.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        FotodeComunidadBtn.setForeground(new java.awt.Color(204, 204, 204));
        FotodeComunidadBtn.setToolTipText("");
        FotodeComunidadBtn.setAlignmentY(0.0F);
        FotodeComunidadBtn.setBorderPainted(false);
        FotodeComunidadBtn.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        FotodeComunidadBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FotodeComunidadBtnActionPerformed(evt);
            }
        });
        PanelTotalComunidad.add(FotodeComunidadBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 150, 60, 60));

        ConfiBtn.setBackground(new java.awt.Color(26, 26, 29));
        ConfiBtn.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        ConfiBtn.setForeground(new java.awt.Color(204, 204, 204));
        ConfiBtn.setText("Configuracion");
        ConfiBtn.setToolTipText("");
        ConfiBtn.setAlignmentY(0.0F);
        ConfiBtn.setBorderPainted(false);
        ConfiBtn.setContentAreaFilled(false);
        ConfiBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ConfiBtn.setVerifyInputWhenFocusTarget(false);
        ConfiBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfiBtnActionPerformed(evt);
            }
        });
        PanelTotalComunidad.add(ConfiBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 500, 260, 40));

        InicioBtn1.setBackground(new java.awt.Color(26, 26, 29));
        InicioBtn1.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        InicioBtn1.setForeground(new java.awt.Color(204, 204, 204));
        InicioBtn1.setText("   Inicio");
        InicioBtn1.setToolTipText("");
        InicioBtn1.setAlignmentY(0.0F);
        InicioBtn1.setBorderPainted(false);
        InicioBtn1.setContentAreaFilled(false);
        InicioBtn1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        InicioBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InicioBtn1ActionPerformed(evt);
            }
        });
        PanelTotalComunidad.add(InicioBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 250, 40));

        ComunidadesBtn.setBackground(new java.awt.Color(26, 26, 29));
        ComunidadesBtn.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        ComunidadesBtn.setForeground(new java.awt.Color(204, 204, 204));
        ComunidadesBtn.setText("  Comunidades");
        ComunidadesBtn.setToolTipText("");
        ComunidadesBtn.setAlignmentY(0.0F);
        ComunidadesBtn.setBorderPainted(false);
        ComunidadesBtn.setContentAreaFilled(false);
        ComunidadesBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ComunidadesBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComunidadesBtnActionPerformed(evt);
            }
        });
        PanelTotalComunidad.add(ComunidadesBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 320, 250, 40));

        NotificacionesBtn.setBackground(new java.awt.Color(26, 26, 29));
        NotificacionesBtn.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        NotificacionesBtn.setForeground(new java.awt.Color(204, 204, 204));
        NotificacionesBtn.setText("  Notificaciones");
        NotificacionesBtn.setToolTipText("");
        NotificacionesBtn.setAlignmentY(0.0F);
        NotificacionesBtn.setBorderPainted(false);
        NotificacionesBtn.setContentAreaFilled(false);
        NotificacionesBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        NotificacionesBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NotificacionesBtnActionPerformed(evt);
            }
        });
        PanelTotalComunidad.add(NotificacionesBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 260, 250, 40));

        GuardadoBtn.setBackground(new java.awt.Color(26, 26, 29));
        GuardadoBtn.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        GuardadoBtn.setForeground(new java.awt.Color(204, 204, 204));
        GuardadoBtn.setText("  Guardados");
        GuardadoBtn.setToolTipText("");
        GuardadoBtn.setAlignmentY(0.0F);
        GuardadoBtn.setBorderPainted(false);
        GuardadoBtn.setContentAreaFilled(false);
        GuardadoBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        GuardadoBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        GuardadoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardadoBtnActionPerformed(evt);
            }
        });
        PanelTotalComunidad.add(GuardadoBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 380, 250, 40));

        PerfilBtn.setBackground(new java.awt.Color(26, 26, 29));
        PerfilBtn.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        PerfilBtn.setForeground(new java.awt.Color(204, 204, 204));
        PerfilBtn.setText("  Perfil");
        PerfilBtn.setToolTipText("");
        PerfilBtn.setAlignmentY(0.0F);
        PerfilBtn.setBorderPainted(false);
        PerfilBtn.setContentAreaFilled(false);
        PerfilBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        PerfilBtn.setVerifyInputWhenFocusTarget(false);
        PerfilBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PerfilBtnActionPerformed(evt);
            }
        });
        PanelTotalComunidad.add(PerfilBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 440, 250, 40));

        ExplorarBtn1.setBackground(new java.awt.Color(26, 26, 29));
        ExplorarBtn1.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        ExplorarBtn1.setForeground(new java.awt.Color(204, 204, 204));
        ExplorarBtn1.setText("  Explorar");
        ExplorarBtn1.setToolTipText("");
        ExplorarBtn1.setAlignmentY(0.0F);
        ExplorarBtn1.setBorderPainted(false);
        ExplorarBtn1.setContentAreaFilled(false);
        ExplorarBtn1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ExplorarBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExplorarBtn1ActionPerformed(evt);
            }
        });
        PanelTotalComunidad.add(ExplorarBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, 250, 40));
        PanelTotalComunidad.add(Y_logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, 90, 80));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PanelTotalComunidad, javax.swing.GroupLayout.PREFERRED_SIZE, 1550, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PanelTotalComunidad, javax.swing.GroupLayout.PREFERRED_SIZE, 820, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CuentaBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CuentaBtn1ActionPerformed
     // TODO add your handling code here:
    }//GEN-LAST:event_CuentaBtn1ActionPerformed

    private void NoSeguidoresBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NoSeguidoresBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NoSeguidoresBtnActionPerformed

    private void FiltrarReYapsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FiltrarReYapsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FiltrarReYapsActionPerformed

    private void FiltrarDestacadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FiltrarDestacadosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FiltrarDestacadosActionPerformed

    private void FiltrarMultimediaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FiltrarMultimediaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FiltrarMultimediaActionPerformed

    private void FiltrarYapsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FiltrarYapsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FiltrarYapsActionPerformed

    private void SeguidoresBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeguidoresBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SeguidoresBtnActionPerformed

    private void FiltrarEventosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FiltrarEventosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FiltrarEventosActionPerformed

    private void FiltrarSeguidoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FiltrarSeguidoresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FiltrarSeguidoresActionPerformed

    private void UsuarioComunidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsuarioComunidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UsuarioComunidadActionPerformed

    private void YapsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_YapsBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_YapsBtnActionPerformed

    private void ContadorYapsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContadorYapsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ContadorYapsActionPerformed

    private void DescripcionComunidadBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DescripcionComunidadBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DescripcionComunidadBtnActionPerformed

    private void FotodeComunidadBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FotodeComunidadBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FotodeComunidadBtnActionPerformed

    private void PublicacionesBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PublicacionesBtn2ActionPerformed
        this.dispose();
        new Menu_Principal().setVisible(true);
    }//GEN-LAST:event_PublicacionesBtn2ActionPerformed

    private void TendenciaYapBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TendenciaYapBtn2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TendenciaYapBtn2ActionPerformed

    private void MostrarMasTendenciaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MostrarMasTendenciaBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MostrarMasTendenciaBtnActionPerformed

    private void CuentaBtn20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CuentaBtn20ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CuentaBtn20ActionPerformed

    private void TendenciaYapBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TendenciaYapBtn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TendenciaYapBtn1ActionPerformed

    private void PublicacionesBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PublicacionesBtn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PublicacionesBtn1ActionPerformed

    private void MostrarMasInteresBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MostrarMasInteresBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MostrarMasInteresBtnActionPerformed

    private void UserInt3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserInt3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UserInt3ActionPerformed

    private void UserInt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserInt1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UserInt1ActionPerformed

    private void UserInt2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserInt2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UserInt2ActionPerformed

    private void UsuarioPub1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsuarioPub1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UsuarioPub1ActionPerformed

    private void UsuarioPub2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsuarioPub2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UsuarioPub2ActionPerformed

    private void UsuarioPub3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsuarioPub3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UsuarioPub3ActionPerformed

    private void PostearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PostearBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PostearBtnActionPerformed

    private void ConfiBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfiBtnActionPerformed
        this.dispose();
        new Configuracion().setVisible(true);
    }//GEN-LAST:event_ConfiBtnActionPerformed

    private void InicioBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InicioBtn1ActionPerformed
        this.dispose();
        new Menu_Principal().setVisible(true);
    }//GEN-LAST:event_InicioBtn1ActionPerformed

    private void ComunidadesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComunidadesBtnActionPerformed
        this.dispose();
        new Comunidad().setVisible(true);
    }//GEN-LAST:event_ComunidadesBtnActionPerformed

    private void NotificacionesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NotificacionesBtnActionPerformed
        this.dispose();
        new Notificaciones().setVisible(true);
    }//GEN-LAST:event_NotificacionesBtnActionPerformed

    private void GuardadoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardadoBtnActionPerformed
        this.dispose();
        new Guardados().setVisible(true);
    }//GEN-LAST:event_GuardadoBtnActionPerformed

    private void PerfilBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PerfilBtnActionPerformed
        this.dispose();
        new Perfil().setVisible(true);
    }//GEN-LAST:event_PerfilBtnActionPerformed

    private void ExplorarBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExplorarBtn1ActionPerformed
        this.dispose();
        new Explorar().setVisible(true);
    }//GEN-LAST:event_ExplorarBtn1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Comunidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Comunidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Comunidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Comunidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>comenttt555

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Comunidad().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BarraBusquedaBtn;
    private javax.swing.JButton ComunidadesBtn;
    private javax.swing.JButton ConfiBtn;
    private javax.swing.JButton ContadorYaps;
    private javax.swing.JButton CuentaBtn1;
    private javax.swing.JButton CuentaBtn20;
    private javax.swing.JButton DescripcionComunidadBtn;
    private javax.swing.JLabel DescripcionPub1;
    private javax.swing.JLabel DescripcionPub2;
    private javax.swing.JLabel DescripcionPub3;
    private javax.swing.JButton ExplorarBtn1;
    private javax.swing.JButton FiltrarDestacados;
    private javax.swing.JButton FiltrarEventos;
    private javax.swing.JButton FiltrarMultimedia;
    private javax.swing.JButton FiltrarReYaps;
    private javax.swing.JButton FiltrarSeguidores;
    private javax.swing.JButton FiltrarYaps;
    private javax.swing.JButton FotodeComunidadBtn;
    private javax.swing.JButton GuardadoBtn;
    private javax.swing.JLabel IdUsuario2;
    private javax.swing.JLabel ImgInt1;
    private javax.swing.JLabel ImgInt2;
    private javax.swing.JLabel ImgInt3;
    private javax.swing.JLabel ImgPub1;
    private javax.swing.JLabel ImgPub2;
    private javax.swing.JLabel ImgPub3;
    private javax.swing.JButton InicioBtn1;
    private javax.swing.JButton MostrarMasInteresBtn;
    private javax.swing.JButton MostrarMasTendenciaBtn;
    private javax.swing.JButton NoSeguidoresBtn;
    private javax.swing.JLabel NombreComunidad;
    private javax.swing.JLabel NombrePub1;
    private javax.swing.JLabel NombrePub2;
    private javax.swing.JLabel NombrePub3;
    private javax.swing.JLabel NombreUsuario;
    private javax.swing.JButton NotificacionesBtn;
    private javax.swing.JPanel PanelNot1;
    private javax.swing.JPanel PanelNot2;
    private javax.swing.JPanel PanelNot3;
    private javax.swing.JPanel PanelTotalComunidad;
    private javax.swing.JButton PerfilBtn;
    private javax.swing.JPanel PerfilPanel;
    private javax.swing.JLabel Perfil_Img;
    private javax.swing.JPanel PortadaPanel;
    private javax.swing.JButton PostearBtn;
    private javax.swing.JButton PublicacionesBtn1;
    private javax.swing.JButton PublicacionesBtn2;
    private javax.swing.JLabel QuePasa;
    private javax.swing.JButton SeguidoresBtn;
    private javax.swing.JButton SeguirComunidadBtn;
    private javax.swing.JButton SeguirCuentaBtn1;
    private javax.swing.JButton SeguirCuentaBtn2;
    private javax.swing.JButton SeguirCuentaBtn3;
    private javax.swing.JButton TendenciaYapBtn1;
    private javax.swing.JButton TendenciaYapBtn2;
    private javax.swing.JButton UserInt1;
    private javax.swing.JButton UserInt2;
    private javax.swing.JButton UserInt3;
    private javax.swing.JButton UsuarioComunidad;
    private javax.swing.JButton UsuarioPub1;
    private javax.swing.JButton UsuarioPub2;
    private javax.swing.JButton UsuarioPub3;
    private javax.swing.JLabel Y_logo;
    private javax.swing.JButton YapsBtn;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    // End of variables declaration//GEN-END:variables
    private void mostrarUsuariosAleatorios() {
        Connection con = DB_Conection.conectar();
        if (con != null) {
            try {
                String sql = "SELECT id_usuario, nombre, apellido, foto_perfil FROM usuario WHERE id_usuario != ? ORDER BY RAND() LIMIT 3";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, SesionUsuario.idUsuario);
                ResultSet rs = ps.executeQuery();

                int index = 0;
                while (rs.next()) {
                    String id = rs.getString("id_usuario");
                    String nombre = rs.getString("nombre") + " " + rs.getString("apellido");
                    byte[] imgBytes = rs.getBytes("foto_perfil");

                    ImageIcon icono = null;
                    if (imgBytes != null) {
                        ImageIcon rawIcon = new ImageIcon(imgBytes);
                        Image escalar = rawIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
                        icono = new ImageIcon(escalar);
                    }

                    switch (index) {
                        case 0:
                            UserInt1.setText("@" + id);
                            if (icono != null) ImgInt1.setIcon(icono);
                            else ImgInt1.setText("Sin imagen");
                            break;
                        case 1:
                            UserInt2.setText("@" + id);
                            if (icono != null) ImgInt2.setIcon(icono);
                            else ImgInt2.setText("Sin imagen");
                            break;
                        case 2:
                            UserInt3.setText("@" + id);
                            if (icono != null) ImgInt3.setIcon(icono);
                            else ImgInt3.setText("Sin imagen");
                            break;
                    }
                    index++;
                }

                rs.close();
                ps.close();
                con.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}