
package com.mycompany.proyect_y;

import Conection.DB_Conection;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;

public class Explorar extends javax.swing.JFrame {

    public Explorar() {
        initComponents();
        this.setLocationRelativeTo(null);
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
                        Image img = icon.getImage().getScaledInstance(Perfil_Img2.getWidth(), Perfil_Img2.getHeight(), Image.SCALE_SMOOTH);
                        Perfil_Img2.setIcon(new ImageIcon(img));
                        
                    } else {
                        Perfil_Img2.setText("Sin imagen");
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
        Image img2 = image2.getImage().getScaledInstance(40, 40, 0);
        ImageIcon Icono2 = new ImageIcon(img2);
        ExplorarBtn2.setIcon(Icono2);
        
        //IconoExplorar
        String url21 = "src\\main\\java\\Multimedia\\Icon-Explorar.png";
        ImageIcon image23 = new ImageIcon(url21);
        Image img23 = image23.getImage().getScaledInstance(32, 32, 0);
        ImageIcon Icono23 = new ImageIcon(img23);
        ExplorarBtn1.setIcon(Icono23);
        
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
        Image img13 = image13.getImage().getScaledInstance(50, 50, 0);
        ImageIcon Icono13 = new ImageIcon(img13);
        Y_logo.setIcon(Icono13);
        
        //Icono Tus Yaps
        String url132 = "src\\main\\java\\Multimedia\\Yap-Icon.png";
        ImageIcon image132 = new ImageIcon(url132);
        Image img132 = image132.getImage().getScaledInstance(34, 34, 0);
        ImageIcon Icono132 = new ImageIcon(img132);
        TusYapsImg.setIcon(Icono132);

        //Icono Configuracion
        String url14 = "src\\main\\java\\Multimedia\\Icono-Configuracion.png";
        ImageIcon image14 = new ImageIcon(url14);
        Image img14 = image14.getImage().getScaledInstance(34, 34, 0);
        ImageIcon Icono14 = new ImageIcon(img14);
        ConfiBtn.setIcon(Icono14);
        
        //Icono Menciones
        String url147 = "src\\main\\java\\Multimedia\\Mencion-Icon.png";
        ImageIcon image147 = new ImageIcon(url147);
        Image img147 = image147.getImage().getScaledInstance(34, 34, 0);
        ImageIcon Icono147 = new ImageIcon(img147);
        MencionesImg.setIcon(Icono147);
        
        //Icono Cumple
        String url143 = "src\\main\\java\\Multimedia\\Cump-Icon.png";
        ImageIcon image143 = new ImageIcon(url143);
        Image img143= image143.getImage().getScaledInstance(34, 34, 0);
        ImageIcon Icono143= new ImageIcon(img143);
        CumpImg.setIcon(Icono143);

        //Icono Amigos
        String url141 = "src\\main\\java\\Multimedia\\Amigo-Icon.png";
        ImageIcon image141 = new ImageIcon(url141);
        Image img141= image141.getImage().getScaledInstance(34, 34, 0);
        ImageIcon Icono141= new ImageIcon(img141);
        AmigosImg1.setIcon(Icono141);
        
        //Icono Tendencias
        String url149 = "src\\main\\java\\Multimedia\\Tend-Icon.png";
        ImageIcon image149 = new ImageIcon(url149);
        Image img149= image149.getImage().getScaledInstance(34, 34, 0);
        ImageIcon Icono149= new ImageIcon(img149);
        TendenciaImg.setIcon(Icono149);
        
        //Icono Recientes
        String url144 = "src\\main\\java\\Multimedia\\Reciente-Icon.png";
        ImageIcon image144 = new ImageIcon(url144);
        Image img144= image144.getImage().getScaledInstance(34, 34, 0);
        ImageIcon Icono144= new ImageIcon(img144);
        RecientesImg.setIcon(Icono144);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelTotalExplorar = new javax.swing.JPanel();
        AmigosImg1 = new javax.swing.JLabel();
        CumpImg = new javax.swing.JLabel();
        TusYapsImg = new javax.swing.JLabel();
        MencionesImg = new javax.swing.JLabel();
        MencionesBtn = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        EliminarBusquedasBtn = new javax.swing.JButton();
        BarraBusquedaBtn = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        BusquedaPersonasBtn = new javax.swing.JButton();
        BusquedaComunidadesBtn = new javax.swing.JButton();
        BusquedaYapsBtn = new javax.swing.JButton();
        BusquedaTodoBtn = new javax.swing.JButton();
        BusquedaEventosBtn = new javax.swing.JButton();
        BusquedaMultimediaBtn = new javax.swing.JButton();
        EjemploBusqueda1 = new javax.swing.JPanel();
        UserResu4 = new javax.swing.JButton();
        NombreResu4 = new javax.swing.JLabel();
        SeguidoresResu4 = new javax.swing.JButton();
        NoSeguidoresResu4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        ImgResu4 = new javax.swing.JLabel();
        CumpleBtn = new javax.swing.JButton();
        AmigosBtn = new javax.swing.JButton();
        ConfiBtn = new javax.swing.JButton();
        InicioBtn1 = new javax.swing.JButton();
        ExplorarBtn2 = new javax.swing.JButton();
        ComunidadesBtn = new javax.swing.JButton();
        TusYapsBtn = new javax.swing.JButton();
        NotificacionesBtn = new javax.swing.JButton();
        GuardadoBtn = new javax.swing.JButton();
        PerfilBtn = new javax.swing.JButton();
        jPanel21 = new javax.swing.JPanel();
        Y_logo = new javax.swing.JLabel();
        EjemploBusquedas1 = new javax.swing.JPanel();
        UserResu1 = new javax.swing.JButton();
        NombreResu1 = new javax.swing.JLabel();
        SeguidoresResu1 = new javax.swing.JButton();
        NoSeguidoresResu1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        ImgRes1 = new javax.swing.JLabel();
        EjemploBusquedas2 = new javax.swing.JPanel();
        UserResu2 = new javax.swing.JButton();
        NombreResu2 = new javax.swing.JLabel();
        SeguidoresResu2 = new javax.swing.JButton();
        NoSeguidoresResu2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        ImgResu2 = new javax.swing.JLabel();
        EjemploBusqueda6 = new javax.swing.JPanel();
        UserResu3 = new javax.swing.JButton();
        NombreResu3 = new javax.swing.JLabel();
        SeguidoresResu3 = new javax.swing.JButton();
        NoSeguidoresResu3 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        ImgResu3 = new javax.swing.JLabel();
        PublicacionesBtn2 = new javax.swing.JButton();
        QuePasa = new javax.swing.JLabel();
        SeguirCuentaBtn3 = new javax.swing.JButton();
        SeguirCuentaBtn1 = new javax.swing.JButton();
        SeguirCuentaBtn2 = new javax.swing.JButton();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        TePuedeInteresarLbl = new javax.swing.JLabel();
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
        PerfilPanel = new javax.swing.JPanel();
        NombreUsuario = new javax.swing.JLabel();
        IdUsuario2 = new javax.swing.JLabel();
        Perfil_Img2 = new javax.swing.JLabel();
        Perfil_Img = new javax.swing.JLabel();
        PostearBtn = new javax.swing.JButton();
        jSeparator7 = new javax.swing.JSeparator();
        ExplorarBtn1 = new javax.swing.JButton();
        TendenciaImg = new javax.swing.JLabel();
        TendenciaBtn = new javax.swing.JButton();
        RecientesImg = new javax.swing.JLabel();
        RecienteBtn = new javax.swing.JButton();
        BusquedaVerTodoBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));

        PanelTotalExplorar.setBackground(new java.awt.Color(0, 0, 0));
        PanelTotalExplorar.setPreferredSize(new java.awt.Dimension(1550, 820));
        PanelTotalExplorar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        AmigosImg1.setForeground(new java.awt.Color(255, 255, 255));
        AmigosImg1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PanelTotalExplorar.add(AmigosImg1, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 620, 70, 70));

        CumpImg.setForeground(new java.awt.Color(255, 255, 255));
        CumpImg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PanelTotalExplorar.add(CumpImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 710, 70, 70));

        TusYapsImg.setForeground(new java.awt.Color(255, 255, 255));
        TusYapsImg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PanelTotalExplorar.add(TusYapsImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 620, 70, 70));

        MencionesImg.setForeground(new java.awt.Color(255, 255, 255));
        MencionesImg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PanelTotalExplorar.add(MencionesImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 710, 70, 70));

        MencionesBtn.setBackground(new java.awt.Color(166, 77, 121));
        MencionesBtn.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        MencionesBtn.setForeground(new java.awt.Color(204, 204, 204));
        MencionesBtn.setText("Menciones");
        MencionesBtn.setToolTipText("");
        MencionesBtn.setAlignmentY(0.0F);
        MencionesBtn.setBorderPainted(false);
        MencionesBtn.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        MencionesBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MencionesBtnActionPerformed(evt);
            }
        });
        PanelTotalExplorar.add(MencionesBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 710, 180, 70));

        jSeparator1.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator1.setForeground(new java.awt.Color(153, 153, 153));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        PanelTotalExplorar.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(427, 0, -1, 1040));
        PanelTotalExplorar.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 600, 751, -1));

        EliminarBusquedasBtn.setBackground(new java.awt.Color(166, 77, 121));
        EliminarBusquedasBtn.setText("Eliminar busquedas");
        PanelTotalExplorar.add(EliminarBusquedasBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 20, 140, 30));

        BarraBusquedaBtn.setBackground(new java.awt.Color(0, 0, 0));
        BarraBusquedaBtn.setForeground(new java.awt.Color(255, 255, 255));
        BarraBusquedaBtn.setText("🔍Buscar");
        BarraBusquedaBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        PanelTotalExplorar.add(BarraBusquedaBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 20, 450, 30));

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        BusquedaPersonasBtn.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        BusquedaPersonasBtn.setForeground(new java.awt.Color(204, 204, 204));
        BusquedaPersonasBtn.setText("Personas");
        BusquedaPersonasBtn.setToolTipText("");
        BusquedaPersonasBtn.setBorder(null);
        BusquedaPersonasBtn.setBorderPainted(false);
        BusquedaPersonasBtn.setContentAreaFilled(false);
        BusquedaPersonasBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BusquedaPersonasBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BusquedaPersonasBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BusquedaPersonasBtnActionPerformed(evt);
            }
        });

        BusquedaComunidadesBtn.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        BusquedaComunidadesBtn.setForeground(new java.awt.Color(204, 204, 204));
        BusquedaComunidadesBtn.setText("Comunidades");
        BusquedaComunidadesBtn.setToolTipText("");
        BusquedaComunidadesBtn.setBorder(null);
        BusquedaComunidadesBtn.setBorderPainted(false);
        BusquedaComunidadesBtn.setContentAreaFilled(false);
        BusquedaComunidadesBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BusquedaComunidadesBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BusquedaComunidadesBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BusquedaComunidadesBtnActionPerformed(evt);
            }
        });

        BusquedaYapsBtn.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        BusquedaYapsBtn.setForeground(new java.awt.Color(204, 204, 204));
        BusquedaYapsBtn.setText("Yap's");
        BusquedaYapsBtn.setToolTipText("");
        BusquedaYapsBtn.setBorder(null);
        BusquedaYapsBtn.setBorderPainted(false);
        BusquedaYapsBtn.setContentAreaFilled(false);
        BusquedaYapsBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BusquedaYapsBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BusquedaYapsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BusquedaYapsBtnActionPerformed(evt);
            }
        });

        BusquedaTodoBtn.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        BusquedaTodoBtn.setForeground(new java.awt.Color(204, 204, 204));
        BusquedaTodoBtn.setText("Todo");
        BusquedaTodoBtn.setToolTipText("");
        BusquedaTodoBtn.setBorder(null);
        BusquedaTodoBtn.setBorderPainted(false);
        BusquedaTodoBtn.setContentAreaFilled(false);
        BusquedaTodoBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BusquedaTodoBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BusquedaTodoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BusquedaTodoBtnActionPerformed(evt);
            }
        });

        BusquedaEventosBtn.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        BusquedaEventosBtn.setForeground(new java.awt.Color(204, 204, 204));
        BusquedaEventosBtn.setText("Eventos");
        BusquedaEventosBtn.setToolTipText("");
        BusquedaEventosBtn.setBorder(null);
        BusquedaEventosBtn.setBorderPainted(false);
        BusquedaEventosBtn.setContentAreaFilled(false);
        BusquedaEventosBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BusquedaEventosBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BusquedaEventosBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BusquedaEventosBtnActionPerformed(evt);
            }
        });

        BusquedaMultimediaBtn.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        BusquedaMultimediaBtn.setForeground(new java.awt.Color(204, 204, 204));
        BusquedaMultimediaBtn.setText("Multimedia");
        BusquedaMultimediaBtn.setToolTipText("");
        BusquedaMultimediaBtn.setBorder(null);
        BusquedaMultimediaBtn.setBorderPainted(false);
        BusquedaMultimediaBtn.setContentAreaFilled(false);
        BusquedaMultimediaBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BusquedaMultimediaBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BusquedaMultimediaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BusquedaMultimediaBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(BusquedaTodoBtn)
                .addGap(50, 50, 50)
                .addComponent(BusquedaPersonasBtn)
                .addGap(50, 50, 50)
                .addComponent(BusquedaComunidadesBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(BusquedaYapsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(BusquedaEventosBtn)
                .addGap(50, 50, 50)
                .addComponent(BusquedaMultimediaBtn)
                .addGap(77, 77, 77))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(BusquedaPersonasBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BusquedaComunidadesBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BusquedaYapsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BusquedaTodoBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(BusquedaMultimediaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BusquedaEventosBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        PanelTotalExplorar.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 60, 750, 40));

        EjemploBusqueda1.setBackground(new java.awt.Color(59, 28, 50));
        EjemploBusqueda1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        EjemploBusqueda1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        UserResu4.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        UserResu4.setForeground(new java.awt.Color(204, 204, 204));
        UserResu4.setText("@Usuario");
        UserResu4.setToolTipText("");
        UserResu4.setBorder(null);
        UserResu4.setBorderPainted(false);
        UserResu4.setContentAreaFilled(false);
        UserResu4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        UserResu4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        UserResu4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserResu4ActionPerformed(evt);
            }
        });

        NombreResu4.setFont(new java.awt.Font("Roboto Black", 1, 22)); // NOI18N
        NombreResu4.setForeground(new java.awt.Color(204, 204, 204));
        NombreResu4.setText("Resultado 4");

        SeguidoresResu4.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        SeguidoresResu4.setForeground(new java.awt.Color(204, 204, 204));
        SeguidoresResu4.setText("Seguidores");
        SeguidoresResu4.setBorder(null);
        SeguidoresResu4.setBorderPainted(false);
        SeguidoresResu4.setContentAreaFilled(false);
        SeguidoresResu4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SeguidoresResu4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        SeguidoresResu4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SeguidoresResu4ActionPerformed(evt);
            }
        });

        NoSeguidoresResu4.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        NoSeguidoresResu4.setForeground(new java.awt.Color(204, 204, 204));
        NoSeguidoresResu4.setText("0");
        NoSeguidoresResu4.setBorder(null);
        NoSeguidoresResu4.setBorderPainted(false);
        NoSeguidoresResu4.setContentAreaFilled(false);
        NoSeguidoresResu4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        NoSeguidoresResu4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        NoSeguidoresResu4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NoSeguidoresResu4ActionPerformed(evt);
            }
        });

        ImgResu4.setText("img_resultado1");

        javax.swing.GroupLayout EjemploBusqueda1Layout = new javax.swing.GroupLayout(EjemploBusqueda1);
        EjemploBusqueda1.setLayout(EjemploBusqueda1Layout);
        EjemploBusqueda1Layout.setHorizontalGroup(
            EjemploBusqueda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EjemploBusqueda1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ImgResu4, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(EjemploBusqueda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EjemploBusqueda1Layout.createSequentialGroup()
                        .addGroup(EjemploBusqueda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(EjemploBusqueda1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(UserResu4))
                            .addComponent(NombreResu4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 344, Short.MAX_VALUE)
                        .addComponent(NoSeguidoresResu4, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68))
                    .addGroup(EjemploBusqueda1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(SeguidoresResu4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        EjemploBusqueda1Layout.setVerticalGroup(
            EjemploBusqueda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EjemploBusqueda1Layout.createSequentialGroup()
                .addGroup(EjemploBusqueda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EjemploBusqueda1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(NombreResu4, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(UserResu4)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel1)
                        .addGap(0, 14, Short.MAX_VALUE))
                    .addGroup(EjemploBusqueda1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(ImgResu4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EjemploBusqueda1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(EjemploBusqueda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SeguidoresResu4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NoSeguidoresResu4)))
        );

        PanelTotalExplorar.add(EjemploBusqueda1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 470, 730, 90));

        CumpleBtn.setBackground(new java.awt.Color(166, 77, 121));
        CumpleBtn.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        CumpleBtn.setForeground(new java.awt.Color(204, 204, 204));
        CumpleBtn.setText(" Cumpleaños");
        CumpleBtn.setToolTipText("");
        CumpleBtn.setAlignmentY(0.0F);
        CumpleBtn.setBorderPainted(false);
        CumpleBtn.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        CumpleBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CumpleBtnActionPerformed(evt);
            }
        });
        PanelTotalExplorar.add(CumpleBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 710, 180, 70));

        AmigosBtn.setBackground(new java.awt.Color(166, 77, 121));
        AmigosBtn.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        AmigosBtn.setForeground(new java.awt.Color(204, 204, 204));
        AmigosBtn.setText("Amigos");
        AmigosBtn.setToolTipText("");
        AmigosBtn.setAlignmentY(0.0F);
        AmigosBtn.setBorderPainted(false);
        AmigosBtn.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        AmigosBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AmigosBtnActionPerformed(evt);
            }
        });
        PanelTotalExplorar.add(AmigosBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 620, 180, 70));

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
        PanelTotalExplorar.add(ConfiBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 420, 260, 40));

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
        PanelTotalExplorar.add(InicioBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, 250, 40));

        ExplorarBtn2.setBackground(new java.awt.Color(26, 26, 29));
        ExplorarBtn2.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        ExplorarBtn2.setForeground(new java.awt.Color(204, 204, 204));
        ExplorarBtn2.setText("  Explorar");
        ExplorarBtn2.setToolTipText("");
        ExplorarBtn2.setAlignmentY(0.0F);
        ExplorarBtn2.setBorderPainted(false);
        ExplorarBtn2.setContentAreaFilled(false);
        ExplorarBtn2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ExplorarBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExplorarBtn2ActionPerformed(evt);
            }
        });
        PanelTotalExplorar.add(ExplorarBtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 10, 250, 40));

        ComunidadesBtn.setBackground(new java.awt.Color(26, 26, 29));
        ComunidadesBtn.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
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
        PanelTotalExplorar.add(ComunidadesBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 240, 250, 40));

        TusYapsBtn.setBackground(new java.awt.Color(166, 77, 121));
        TusYapsBtn.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        TusYapsBtn.setForeground(new java.awt.Color(204, 204, 204));
        TusYapsBtn.setText("Tus Yap's");
        TusYapsBtn.setToolTipText("");
        TusYapsBtn.setAlignmentY(0.0F);
        TusYapsBtn.setBorderPainted(false);
        TusYapsBtn.setDisplayedMnemonicIndex(2);
        TusYapsBtn.setHideActionText(true);
        TusYapsBtn.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        TusYapsBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        TusYapsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TusYapsBtnActionPerformed(evt);
            }
        });
        PanelTotalExplorar.add(TusYapsBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 620, 180, 70));

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
        PanelTotalExplorar.add(NotificacionesBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 250, 40));

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
        PanelTotalExplorar.add(GuardadoBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 300, 250, 40));

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
        PanelTotalExplorar.add(PerfilBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 360, 250, 40));

        jPanel21.setOpaque(false);
        jPanel21.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel21.add(Y_logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 60, 40));

        PanelTotalExplorar.add(jPanel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, 70, 50));

        EjemploBusquedas1.setBackground(new java.awt.Color(59, 28, 50));
        EjemploBusquedas1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        EjemploBusquedas1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        UserResu1.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        UserResu1.setForeground(new java.awt.Color(204, 204, 204));
        UserResu1.setText("@Usuario");
        UserResu1.setToolTipText("");
        UserResu1.setBorder(null);
        UserResu1.setBorderPainted(false);
        UserResu1.setContentAreaFilled(false);
        UserResu1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        UserResu1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        UserResu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserResu1ActionPerformed(evt);
            }
        });

        NombreResu1.setFont(new java.awt.Font("Roboto Black", 1, 22)); // NOI18N
        NombreResu1.setForeground(new java.awt.Color(204, 204, 204));
        NombreResu1.setText("Resultado 1");

        SeguidoresResu1.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        SeguidoresResu1.setForeground(new java.awt.Color(204, 204, 204));
        SeguidoresResu1.setText("Seguidores");
        SeguidoresResu1.setBorder(null);
        SeguidoresResu1.setBorderPainted(false);
        SeguidoresResu1.setContentAreaFilled(false);
        SeguidoresResu1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SeguidoresResu1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        SeguidoresResu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SeguidoresResu1ActionPerformed(evt);
            }
        });

        NoSeguidoresResu1.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        NoSeguidoresResu1.setForeground(new java.awt.Color(204, 204, 204));
        NoSeguidoresResu1.setText("0");
        NoSeguidoresResu1.setBorder(null);
        NoSeguidoresResu1.setBorderPainted(false);
        NoSeguidoresResu1.setContentAreaFilled(false);
        NoSeguidoresResu1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        NoSeguidoresResu1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        NoSeguidoresResu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NoSeguidoresResu1ActionPerformed(evt);
            }
        });

        ImgRes1.setText("img_resultado1");

        javax.swing.GroupLayout EjemploBusquedas1Layout = new javax.swing.GroupLayout(EjemploBusquedas1);
        EjemploBusquedas1.setLayout(EjemploBusquedas1Layout);
        EjemploBusquedas1Layout.setHorizontalGroup(
            EjemploBusquedas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EjemploBusquedas1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ImgRes1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(EjemploBusquedas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(EjemploBusquedas1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(UserResu1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 463, Short.MAX_VALUE)
                        .addComponent(NoSeguidoresResu1, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NombreResu1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SeguidoresResu1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        EjemploBusquedas1Layout.setVerticalGroup(
            EjemploBusquedas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EjemploBusquedas1Layout.createSequentialGroup()
                .addGroup(EjemploBusquedas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EjemploBusquedas1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(NombreResu1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(UserResu1)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel4)
                        .addGap(0, 14, Short.MAX_VALUE))
                    .addGroup(EjemploBusquedas1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(ImgRes1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EjemploBusquedas1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(EjemploBusquedas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SeguidoresResu1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NoSeguidoresResu1)))
        );

        PanelTotalExplorar.add(EjemploBusquedas1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 140, 730, 90));

        EjemploBusquedas2.setBackground(new java.awt.Color(106, 30, 85));
        EjemploBusquedas2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        EjemploBusquedas2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        UserResu2.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        UserResu2.setForeground(new java.awt.Color(204, 204, 204));
        UserResu2.setText("@Usuario");
        UserResu2.setToolTipText("");
        UserResu2.setBorder(null);
        UserResu2.setBorderPainted(false);
        UserResu2.setContentAreaFilled(false);
        UserResu2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        UserResu2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        UserResu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserResu2ActionPerformed(evt);
            }
        });

        NombreResu2.setFont(new java.awt.Font("Roboto Black", 1, 22)); // NOI18N
        NombreResu2.setForeground(new java.awt.Color(204, 204, 204));
        NombreResu2.setText("Resultado 2");

        SeguidoresResu2.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        SeguidoresResu2.setForeground(new java.awt.Color(204, 204, 204));
        SeguidoresResu2.setText("Seguidores");
        SeguidoresResu2.setBorder(null);
        SeguidoresResu2.setBorderPainted(false);
        SeguidoresResu2.setContentAreaFilled(false);
        SeguidoresResu2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SeguidoresResu2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        SeguidoresResu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SeguidoresResu2ActionPerformed(evt);
            }
        });

        NoSeguidoresResu2.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        NoSeguidoresResu2.setForeground(new java.awt.Color(204, 204, 204));
        NoSeguidoresResu2.setText("0");
        NoSeguidoresResu2.setBorder(null);
        NoSeguidoresResu2.setBorderPainted(false);
        NoSeguidoresResu2.setContentAreaFilled(false);
        NoSeguidoresResu2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        NoSeguidoresResu2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        NoSeguidoresResu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NoSeguidoresResu2ActionPerformed(evt);
            }
        });

        ImgResu2.setText("img_resultado1");

        javax.swing.GroupLayout EjemploBusquedas2Layout = new javax.swing.GroupLayout(EjemploBusquedas2);
        EjemploBusquedas2.setLayout(EjemploBusquedas2Layout);
        EjemploBusquedas2Layout.setHorizontalGroup(
            EjemploBusquedas2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EjemploBusquedas2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ImgResu2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(EjemploBusquedas2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(EjemploBusquedas2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(UserResu2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 463, Short.MAX_VALUE)
                        .addComponent(NoSeguidoresResu2, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NombreResu2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SeguidoresResu2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        EjemploBusquedas2Layout.setVerticalGroup(
            EjemploBusquedas2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EjemploBusquedas2Layout.createSequentialGroup()
                .addGroup(EjemploBusquedas2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EjemploBusquedas2Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(NombreResu2, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(UserResu2)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel5)
                        .addGap(0, 14, Short.MAX_VALUE))
                    .addGroup(EjemploBusquedas2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(ImgResu2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EjemploBusquedas2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(EjemploBusquedas2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SeguidoresResu2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NoSeguidoresResu2)))
        );

        PanelTotalExplorar.add(EjemploBusquedas2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 250, 730, 90));

        EjemploBusqueda6.setBackground(new java.awt.Color(166, 77, 121));
        EjemploBusqueda6.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        EjemploBusqueda6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        UserResu3.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        UserResu3.setForeground(new java.awt.Color(204, 204, 204));
        UserResu3.setText("@Usuario");
        UserResu3.setToolTipText("");
        UserResu3.setBorder(null);
        UserResu3.setBorderPainted(false);
        UserResu3.setContentAreaFilled(false);
        UserResu3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        UserResu3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        UserResu3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserResu3ActionPerformed(evt);
            }
        });

        NombreResu3.setFont(new java.awt.Font("Roboto Black", 1, 22)); // NOI18N
        NombreResu3.setForeground(new java.awt.Color(204, 204, 204));
        NombreResu3.setText("Resultado 3");

        SeguidoresResu3.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        SeguidoresResu3.setForeground(new java.awt.Color(204, 204, 204));
        SeguidoresResu3.setText("Seguidores");
        SeguidoresResu3.setBorder(null);
        SeguidoresResu3.setBorderPainted(false);
        SeguidoresResu3.setContentAreaFilled(false);
        SeguidoresResu3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SeguidoresResu3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        SeguidoresResu3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SeguidoresResu3ActionPerformed(evt);
            }
        });

        NoSeguidoresResu3.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        NoSeguidoresResu3.setForeground(new java.awt.Color(204, 204, 204));
        NoSeguidoresResu3.setText("0");
        NoSeguidoresResu3.setBorder(null);
        NoSeguidoresResu3.setBorderPainted(false);
        NoSeguidoresResu3.setContentAreaFilled(false);
        NoSeguidoresResu3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        NoSeguidoresResu3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        NoSeguidoresResu3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NoSeguidoresResu3ActionPerformed(evt);
            }
        });

        ImgResu3.setText("img_resultado1");

        javax.swing.GroupLayout EjemploBusqueda6Layout = new javax.swing.GroupLayout(EjemploBusqueda6);
        EjemploBusqueda6.setLayout(EjemploBusqueda6Layout);
        EjemploBusqueda6Layout.setHorizontalGroup(
            EjemploBusqueda6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EjemploBusqueda6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ImgResu3, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(EjemploBusqueda6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(EjemploBusqueda6Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(UserResu3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 460, Short.MAX_VALUE)
                        .addComponent(NoSeguidoresResu3, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NombreResu3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SeguidoresResu3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        EjemploBusqueda6Layout.setVerticalGroup(
            EjemploBusqueda6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EjemploBusqueda6Layout.createSequentialGroup()
                .addGroup(EjemploBusqueda6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EjemploBusqueda6Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(NombreResu3, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(UserResu3)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel6)
                        .addGap(0, 14, Short.MAX_VALUE))
                    .addGroup(EjemploBusqueda6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(ImgResu3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EjemploBusqueda6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(EjemploBusqueda6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SeguidoresResu3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NoSeguidoresResu3)))
        );

        PanelTotalExplorar.add(EjemploBusqueda6, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 360, 730, 90));

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
        PanelTotalExplorar.add(PublicacionesBtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 560, 100, 30));

        QuePasa.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        QuePasa.setForeground(new java.awt.Color(204, 204, 204));
        QuePasa.setText("Qué pasa");
        PanelTotalExplorar.add(QuePasa, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 370, 210, 30));

        SeguirCuentaBtn3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        SeguirCuentaBtn3.setText("Seguir");
        PanelTotalExplorar.add(SeguirCuentaBtn3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1400, 230, -1, 30));

        SeguirCuentaBtn1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        SeguirCuentaBtn1.setText("Seguir");
        PanelTotalExplorar.add(SeguirCuentaBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1400, 130, -1, 30));

        SeguirCuentaBtn2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        SeguirCuentaBtn2.setText("Seguir");
        PanelTotalExplorar.add(SeguirCuentaBtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1400, 180, -1, 30));

        jSeparator6.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator6.setForeground(new java.awt.Color(153, 153, 153));
        jSeparator6.setOrientation(javax.swing.SwingConstants.VERTICAL);
        PanelTotalExplorar.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 80, 30, 220));
        PanelTotalExplorar.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 300, 280, 20));
        PanelTotalExplorar.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 80, 280, 10));

        TePuedeInteresarLbl.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        TePuedeInteresarLbl.setForeground(new java.awt.Color(204, 204, 204));
        TePuedeInteresarLbl.setText("Te puede interesar");
        PanelTotalExplorar.add(TePuedeInteresarLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 80, 210, 30));

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
        PanelTotalExplorar.add(TendenciaYapBtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 490, 130, 50));

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
        PanelTotalExplorar.add(MostrarMasTendenciaBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 580, 80, 50));

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
        PanelTotalExplorar.add(CuentaBtn20, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 390, 80, 30));

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
        PanelTotalExplorar.add(TendenciaYapBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 410, 130, 50));

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
        PanelTotalExplorar.add(PublicacionesBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 460, 100, 50));

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
        PanelTotalExplorar.add(MostrarMasInteresBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 260, 80, 50));

        ImgInt3.setForeground(new java.awt.Color(255, 255, 255));
        ImgInt3.setText("ImgInteres2");
        PanelTotalExplorar.add(ImgInt3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 220, 60, 50));

        ImgInt1.setForeground(new java.awt.Color(255, 255, 255));
        ImgInt1.setText("ImgInteres1");
        PanelTotalExplorar.add(ImgInt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 120, 60, 50));

        ImgInt2.setForeground(new java.awt.Color(255, 255, 255));
        ImgInt2.setText("ImgInteres2");
        PanelTotalExplorar.add(ImgInt2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 170, 60, 50));

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
        PanelTotalExplorar.add(UserInt3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 230, -1, 30));

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
        PanelTotalExplorar.add(UserInt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 130, -1, 30));

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
        PanelTotalExplorar.add(UserInt2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 180, -1, 30));

        jSeparator4.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator4.setForeground(new java.awt.Color(153, 153, 153));
        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);
        PanelTotalExplorar.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 0, 10, 1040));

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
        PerfilPanel.add(Perfil_Img2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 50, 50));
        PerfilPanel.add(Perfil_Img, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 50, 40));

        PanelTotalExplorar.add(PerfilPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 720, 270, 60));

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
        PanelTotalExplorar.add(PostearBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 680, 200, 40));

        jSeparator7.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator7.setForeground(new java.awt.Color(153, 153, 153));
        jSeparator7.setOrientation(javax.swing.SwingConstants.VERTICAL);
        PanelTotalExplorar.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1490, 80, 20, 220));

        ExplorarBtn1.setBackground(new java.awt.Color(26, 26, 29));
        ExplorarBtn1.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
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
        PanelTotalExplorar.add(ExplorarBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, 250, 40));

        TendenciaImg.setForeground(new java.awt.Color(255, 255, 255));
        TendenciaImg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PanelTotalExplorar.add(TendenciaImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 620, 70, 70));

        TendenciaBtn.setBackground(new java.awt.Color(166, 77, 121));
        TendenciaBtn.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        TendenciaBtn.setForeground(new java.awt.Color(204, 204, 204));
        TendenciaBtn.setText("Tendencia");
        TendenciaBtn.setToolTipText("");
        TendenciaBtn.setAlignmentY(0.0F);
        TendenciaBtn.setBorderPainted(false);
        TendenciaBtn.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        TendenciaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TendenciaBtnActionPerformed(evt);
            }
        });
        PanelTotalExplorar.add(TendenciaBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 620, 180, 70));

        RecientesImg.setForeground(new java.awt.Color(255, 255, 255));
        RecientesImg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PanelTotalExplorar.add(RecientesImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 710, 70, 70));

        RecienteBtn.setBackground(new java.awt.Color(166, 77, 121));
        RecienteBtn.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        RecienteBtn.setForeground(new java.awt.Color(204, 204, 204));
        RecienteBtn.setText("Recientes");
        RecienteBtn.setToolTipText("");
        RecienteBtn.setAlignmentY(0.0F);
        RecienteBtn.setBorderPainted(false);
        RecienteBtn.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        RecienteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RecienteBtnActionPerformed(evt);
            }
        });
        PanelTotalExplorar.add(RecienteBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 710, 180, 70));

        BusquedaVerTodoBtn.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        BusquedaVerTodoBtn.setForeground(new java.awt.Color(204, 204, 204));
        BusquedaVerTodoBtn.setText("Ver todo");
        BusquedaVerTodoBtn.setBorder(null);
        BusquedaVerTodoBtn.setBorderPainted(false);
        BusquedaVerTodoBtn.setContentAreaFilled(false);
        BusquedaVerTodoBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BusquedaVerTodoBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BusquedaVerTodoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BusquedaVerTodoBtnActionPerformed(evt);
            }
        });
        PanelTotalExplorar.add(BusquedaVerTodoBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 560, 70, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelTotalExplorar, javax.swing.GroupLayout.PREFERRED_SIZE, 1550, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelTotalExplorar, javax.swing.GroupLayout.PREFERRED_SIZE, 820, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MencionesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MencionesBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MencionesBtnActionPerformed

    private void BusquedaVerTodoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BusquedaVerTodoBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BusquedaVerTodoBtnActionPerformed

    private void NoSeguidoresResu4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NoSeguidoresResu4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NoSeguidoresResu4ActionPerformed

    private void BusquedaPersonasBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BusquedaPersonasBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BusquedaPersonasBtnActionPerformed

    private void BusquedaComunidadesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BusquedaComunidadesBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BusquedaComunidadesBtnActionPerformed

    private void BusquedaYapsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BusquedaYapsBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BusquedaYapsBtnActionPerformed

    private void BusquedaTodoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BusquedaTodoBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BusquedaTodoBtnActionPerformed

    private void SeguidoresResu4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeguidoresResu4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SeguidoresResu4ActionPerformed

    private void BusquedaEventosBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BusquedaEventosBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BusquedaEventosBtnActionPerformed

    private void BusquedaMultimediaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BusquedaMultimediaBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BusquedaMultimediaBtnActionPerformed

    private void UserResu4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserResu4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UserResu4ActionPerformed

    private void CumpleBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CumpleBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CumpleBtnActionPerformed

    private void TusYapsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TusYapsBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TusYapsBtnActionPerformed

    private void AmigosBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AmigosBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AmigosBtnActionPerformed

    private void ConfiBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfiBtnActionPerformed
       this.dispose();
        new Configuracion().setVisible(true);
    }//GEN-LAST:event_ConfiBtnActionPerformed

    private void InicioBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InicioBtn1ActionPerformed
        this.dispose();
        new Menu_Principal().setVisible(true);
    }//GEN-LAST:event_InicioBtn1ActionPerformed

    private void ExplorarBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExplorarBtn2ActionPerformed
        this.dispose();
        new Explorar().setVisible(true);
    }//GEN-LAST:event_ExplorarBtn2ActionPerformed

    private void ComunidadesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComunidadesBtnActionPerformed
        this.dispose();
        new Comunidad().setVisible(true);
    }//GEN-LAST:event_ComunidadesBtnActionPerformed

    private void NotificacionesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NotificacionesBtnActionPerformed
       this.dispose();
        new Notificaciones().setVisible(true);
    }//GEN-LAST:event_NotificacionesBtnActionPerformed

    private void GuardadoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardadoBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GuardadoBtnActionPerformed

    private void PerfilBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PerfilBtnActionPerformed
        this.dispose();
        new Perfil().setVisible(true);
    }//GEN-LAST:event_PerfilBtnActionPerformed

    private void UserResu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserResu1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UserResu1ActionPerformed

    private void SeguidoresResu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeguidoresResu1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SeguidoresResu1ActionPerformed

    private void NoSeguidoresResu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NoSeguidoresResu1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NoSeguidoresResu1ActionPerformed

    private void UserResu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserResu2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UserResu2ActionPerformed

    private void SeguidoresResu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeguidoresResu2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SeguidoresResu2ActionPerformed

    private void NoSeguidoresResu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NoSeguidoresResu2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NoSeguidoresResu2ActionPerformed

    private void UserResu3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserResu3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UserResu3ActionPerformed

    private void SeguidoresResu3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeguidoresResu3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SeguidoresResu3ActionPerformed

    private void NoSeguidoresResu3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NoSeguidoresResu3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NoSeguidoresResu3ActionPerformed

    private void PublicacionesBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PublicacionesBtn2ActionPerformed

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

    private void PostearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PostearBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PostearBtnActionPerformed

    private void ExplorarBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExplorarBtn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ExplorarBtn1ActionPerformed

    private void TendenciaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TendenciaBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TendenciaBtnActionPerformed

    private void RecienteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RecienteBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RecienteBtnActionPerformed

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
            java.util.logging.Logger.getLogger(Explorar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Explorar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Explorar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Explorar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Explorar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AmigosBtn;
    private javax.swing.JLabel AmigosImg1;
    private javax.swing.JButton BarraBusquedaBtn;
    private javax.swing.JButton BusquedaComunidadesBtn;
    private javax.swing.JButton BusquedaEventosBtn;
    private javax.swing.JButton BusquedaMultimediaBtn;
    private javax.swing.JButton BusquedaPersonasBtn;
    private javax.swing.JButton BusquedaTodoBtn;
    private javax.swing.JButton BusquedaVerTodoBtn;
    private javax.swing.JButton BusquedaYapsBtn;
    private javax.swing.JButton ComunidadesBtn;
    private javax.swing.JButton ConfiBtn;
    private javax.swing.JButton CuentaBtn20;
    private javax.swing.JLabel CumpImg;
    private javax.swing.JButton CumpleBtn;
    private javax.swing.JPanel EjemploBusqueda1;
    private javax.swing.JPanel EjemploBusqueda6;
    private javax.swing.JPanel EjemploBusquedas1;
    private javax.swing.JPanel EjemploBusquedas2;
    private javax.swing.JButton EliminarBusquedasBtn;
    private javax.swing.JButton ExplorarBtn1;
    private javax.swing.JButton ExplorarBtn2;
    private javax.swing.JButton GuardadoBtn;
    private javax.swing.JLabel IdUsuario2;
    private javax.swing.JLabel ImgInt1;
    private javax.swing.JLabel ImgInt2;
    private javax.swing.JLabel ImgInt3;
    private javax.swing.JLabel ImgRes1;
    private javax.swing.JLabel ImgResu2;
    private javax.swing.JLabel ImgResu3;
    private javax.swing.JLabel ImgResu4;
    private javax.swing.JButton InicioBtn1;
    private javax.swing.JButton MencionesBtn;
    private javax.swing.JLabel MencionesImg;
    private javax.swing.JButton MostrarMasInteresBtn;
    private javax.swing.JButton MostrarMasTendenciaBtn;
    private javax.swing.JButton NoSeguidoresResu1;
    private javax.swing.JButton NoSeguidoresResu2;
    private javax.swing.JButton NoSeguidoresResu3;
    private javax.swing.JButton NoSeguidoresResu4;
    private javax.swing.JLabel NombreResu1;
    private javax.swing.JLabel NombreResu2;
    private javax.swing.JLabel NombreResu3;
    private javax.swing.JLabel NombreResu4;
    private javax.swing.JLabel NombreUsuario;
    private javax.swing.JButton NotificacionesBtn;
    private javax.swing.JPanel PanelTotalExplorar;
    private javax.swing.JButton PerfilBtn;
    private javax.swing.JPanel PerfilPanel;
    private javax.swing.JLabel Perfil_Img;
    private javax.swing.JLabel Perfil_Img2;
    private javax.swing.JButton PostearBtn;
    private javax.swing.JButton PublicacionesBtn1;
    private javax.swing.JButton PublicacionesBtn2;
    private javax.swing.JLabel QuePasa;
    private javax.swing.JButton RecienteBtn;
    private javax.swing.JLabel RecientesImg;
    private javax.swing.JButton SeguidoresResu1;
    private javax.swing.JButton SeguidoresResu2;
    private javax.swing.JButton SeguidoresResu3;
    private javax.swing.JButton SeguidoresResu4;
    private javax.swing.JButton SeguirCuentaBtn1;
    private javax.swing.JButton SeguirCuentaBtn2;
    private javax.swing.JButton SeguirCuentaBtn3;
    private javax.swing.JLabel TePuedeInteresarLbl;
    private javax.swing.JButton TendenciaBtn;
    private javax.swing.JLabel TendenciaImg;
    private javax.swing.JButton TendenciaYapBtn1;
    private javax.swing.JButton TendenciaYapBtn2;
    private javax.swing.JButton TusYapsBtn;
    private javax.swing.JLabel TusYapsImg;
    private javax.swing.JButton UserInt1;
    private javax.swing.JButton UserInt2;
    private javax.swing.JButton UserInt3;
    private javax.swing.JButton UserResu1;
    private javax.swing.JButton UserResu2;
    private javax.swing.JButton UserResu3;
    private javax.swing.JButton UserResu4;
    private javax.swing.JLabel Y_logo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    // End of variables declaration//GEN-END:variables
}
