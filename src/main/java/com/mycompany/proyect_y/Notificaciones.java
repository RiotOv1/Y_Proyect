
package com.mycompany.proyect_y;

import Conection.DB_Conection;
import java.awt.Color;
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Notificaciones extends javax.swing.JFrame {
    int xMouse;
    int yMouse;
    private Publicacion publicacionId;
    private PublicacionDAO publicacionDAO;
    //private List<Publicacion> publicaciones, publicacionesSeguidos;
    private int publicacionActual = 0,publicacionSeguidoActual = 0, publicacionTrend1 = 0, publicacionTrend2 = 0, publicacionTrend3 = 0;
    private String Interes1,Interes2,Interes3;
    public Notificaciones() {
        initComponents();
        this.setLocationRelativeTo(null);
        Img();
        cargarFotoPerfil(); 
        SeccionTePuedeInteresar();
        SeccionTendencias();
        Connection con =  DB_Conection.conectar(); // tu clase de conexión
        String Id =SesionUsuario.idUsuario;
        if (Id != null) {
            String nom = obtenerNombreUsuario();
            NombreUsuario.setText(nom);
            IdUsuario.setText( "@" + Id);
            
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
    
    private void SeccionTendencias(){
        publicacionDAO = new PublicacionDAO();
        List<Object[]> lista = publicacionDAO.obtenerTop3Publicaciones();
        
        if (lista.size() >= 3) {
        Object[] pub0 = lista.get(0);
        TendenciaYapBtn.setText((String) pub0[1]);
        Num_Reacciones.setText(String.valueOf(pub0[2]));
        publicacionTrend1=(int) lista.get(0)[0];

        Object[] pub1 = lista.get(1);
        TendenciaYapBtn1.setText((String) pub1[1]);
        Num_Reacciones1.setText(String.valueOf(pub1[2]));
        publicacionTrend2=(int) lista.get(1)[0];


        Object[] pub2 = lista.get(2);
        TendenciaYapBtn2.setText((String) pub2[1]);
        Num_Reacciones2.setText(String.valueOf(pub2[2]));
        publicacionTrend3=(int) lista.get(2)[0];       
}
    }
    
    private void SeccionTePuedeInteresar(){
        UsuariosDAO dao = new UsuariosDAO();
        List<Object[]> lista = dao.obtenerTodosIdsYFotos();

        if (lista.size() < 3) {
        System.out.println("No hay suficientes usuarios para mostrar.");
        return;
        }

        // Barajar la lista para obtener elementos aleatorios
        Collections.shuffle(lista);

        // Tomar los 3 primeros usuarios aleatorios
        Object[][] usuarios = {lista.get(0), lista.get(1), lista.get(2)};

        // Lista de labels y textfields a llenar
        JLabel[] imagenes = {ImgInt1, ImgInt2, ImgInt3};
        JButton[] usuariosTextos = {UserInt1, UserInt2, UserInt3};

        for (int i = 0; i < 3; i++) {
        Object[] usuario = usuarios[i];
        String id = (String) usuario[0];
        byte[] imagenBytes = (byte[]) usuario[1];

        usuariosTextos[i].setText(id);
    
        if (imagenBytes != null) {
            ImageIcon icon = new ImageIcon(imagenBytes);
            Image img = icon.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
            ImageIcon iconoEscalado = new ImageIcon(img);
            imagenes[i].setIcon(iconoEscalado);
            imagenes[i].setText(""); // Borra texto si lo hubiera
        } else {
            imagenes[i].setIcon(null);
            imagenes[i].setText("Sin imagen");
        }
}
        
        Interes1=UserInt1.getText();
        Interes2=UserInt2.getText();
        Interes3=UserInt3.getText();
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
        
        String url89 = "src\\main\\java\\Multimedia\\Icon-Notificaciones.png";
        ImageIcon image389 = new ImageIcon(url89);
        Image img389 = image389.getImage().getScaledInstance(32, 32, 0);
        ImageIcon Icono389 = new ImageIcon(img389);
        IconoNotificaciones.setIcon(Icono389);

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

        PanelTotalNotificaciones = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        CuentaBtn1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        FiltroSeguidores = new javax.swing.JButton();
        FiltroYaps = new javax.swing.JButton();
        FiltroTodo = new javax.swing.JButton();
        PanelNot4 = new javax.swing.JPanel();
        UsuarioNot4 = new javax.swing.JButton();
        NombreNot4 = new javax.swing.JLabel();
        DescripcionNot4 = new javax.swing.JLabel();
        ImgNot4 = new javax.swing.JLabel();
        IconoNotificaciones = new javax.swing.JButton();
        NotificacionesTitulo = new javax.swing.JLabel();
        IdUsuario = new javax.swing.JLabel();
        UsuarioBtn = new javax.swing.JButton();
        PanelNot2 = new javax.swing.JPanel();
        UsuarioNot2 = new javax.swing.JButton();
        NombreNot2 = new javax.swing.JLabel();
        DescripcionNot2 = new javax.swing.JLabel();
        ImgNot2 = new javax.swing.JLabel();
        PanelNot1 = new javax.swing.JPanel();
        UsuarioNot1 = new javax.swing.JButton();
        NombreNot1 = new javax.swing.JLabel();
        DescripcionNot1 = new javax.swing.JLabel();
        ImgNot1 = new javax.swing.JLabel();
        PanelNot3 = new javax.swing.JPanel();
        UsuarioNot3 = new javax.swing.JButton();
        NombreNot3 = new javax.swing.JLabel();
        DescripcionNot3 = new javax.swing.JLabel();
        ImgNot3 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        PerfilPanel = new javax.swing.JPanel();
        NombreUsuario = new javax.swing.JLabel();
        IdUsuario2 = new javax.swing.JLabel();
        Perfil_Img = new javax.swing.JLabel();
        ConfiBtn = new javax.swing.JButton();
        InicioBtn1 = new javax.swing.JButton();
        NotificacionesBtn = new javax.swing.JButton();
        PerfilBtn = new javax.swing.JButton();
        ExplorarBtn1 = new javax.swing.JButton();
        Y_logo = new javax.swing.JLabel();
        Header = new javax.swing.JPanel();
        ExitPane = new javax.swing.JPanel();
        ExitBtn = new javax.swing.JLabel();
        QuePasa = new javax.swing.JLabel();
        SeguirCuentaBtn3 = new javax.swing.JButton();
        SeguirCuentaBtn1 = new javax.swing.JButton();
        SeguirCuentaBtn2 = new javax.swing.JButton();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jLabel40 = new javax.swing.JLabel();
        CuentaBtn20 = new javax.swing.JButton();
        TendenciaYapBtn = new javax.swing.JButton();
        numreacciones = new javax.swing.JButton();
        MostrarMasInteresBtn = new javax.swing.JButton();
        ImgInt3 = new javax.swing.JLabel();
        ImgInt1 = new javax.swing.JLabel();
        ImgInt2 = new javax.swing.JLabel();
        UserInt3 = new javax.swing.JButton();
        UserInt1 = new javax.swing.JButton();
        UserInt2 = new javax.swing.JButton();
        jSeparator10 = new javax.swing.JSeparator();
        LabelAviso2 = new javax.swing.JLabel();
        Num_Reacciones = new javax.swing.JLabel();
        TendenciaYapBtn1 = new javax.swing.JButton();
        numreacciones1 = new javax.swing.JButton();
        Num_Reacciones1 = new javax.swing.JLabel();
        TendenciaYapBtn2 = new javax.swing.JButton();
        numreacciones2 = new javax.swing.JButton();
        Num_Reacciones2 = new javax.swing.JLabel();
        jSeparator12 = new javax.swing.JSeparator();
        jSeparator13 = new javax.swing.JSeparator();
        jSeparator14 = new javax.swing.JSeparator();
        jSeparator15 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setLocationByPlatform(true);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1550, 890));
        setResizable(false);

        PanelTotalNotificaciones.setBackground(new java.awt.Color(0, 0, 0));
        PanelTotalNotificaciones.setPreferredSize(new java.awt.Dimension(1550, 890));
        PanelTotalNotificaciones.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator1.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator1.setForeground(new java.awt.Color(153, 153, 153));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        PanelTotalNotificaciones.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 50, -1, 1040));

        CuentaBtn1.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        CuentaBtn1.setForeground(new java.awt.Color(204, 204, 204));
        CuentaBtn1.setText("Ver todo");
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
        PanelTotalNotificaciones.add(CuentaBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 990, 70, 40));

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        FiltroSeguidores.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        FiltroSeguidores.setForeground(new java.awt.Color(204, 204, 204));
        FiltroSeguidores.setText("Seguidores");
        FiltroSeguidores.setToolTipText("");
        FiltroSeguidores.setBorder(null);
        FiltroSeguidores.setBorderPainted(false);
        FiltroSeguidores.setContentAreaFilled(false);
        FiltroSeguidores.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        FiltroSeguidores.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        FiltroSeguidores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FiltroSeguidoresActionPerformed(evt);
            }
        });

        FiltroYaps.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        FiltroYaps.setForeground(new java.awt.Color(204, 204, 204));
        FiltroYaps.setText("Yap's");
        FiltroYaps.setToolTipText("");
        FiltroYaps.setBorder(null);
        FiltroYaps.setBorderPainted(false);
        FiltroYaps.setContentAreaFilled(false);
        FiltroYaps.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        FiltroYaps.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        FiltroYaps.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FiltroYapsActionPerformed(evt);
            }
        });

        FiltroTodo.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        FiltroTodo.setForeground(new java.awt.Color(204, 204, 204));
        FiltroTodo.setText("Todo");
        FiltroTodo.setToolTipText("");
        FiltroTodo.setBorder(null);
        FiltroTodo.setBorderPainted(false);
        FiltroTodo.setContentAreaFilled(false);
        FiltroTodo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        FiltroTodo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        FiltroTodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FiltroTodoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(FiltroTodo)
                .addGap(206, 206, 206)
                .addComponent(FiltroSeguidores)
                .addGap(200, 200, 200)
                .addComponent(FiltroYaps, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(92, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(FiltroTodo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(FiltroYaps, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(FiltroSeguidores, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        PanelTotalNotificaciones.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 140, 750, 40));

        PanelNot4.setBackground(new java.awt.Color(59, 28, 50));
        PanelNot4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        PanelNot4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        UsuarioNot4.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        UsuarioNot4.setForeground(new java.awt.Color(204, 204, 204));
        UsuarioNot4.setText("@Usuario");
        UsuarioNot4.setToolTipText("");
        UsuarioNot4.setBorder(null);
        UsuarioNot4.setBorderPainted(false);
        UsuarioNot4.setContentAreaFilled(false);
        UsuarioNot4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        UsuarioNot4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        UsuarioNot4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsuarioNot4ActionPerformed(evt);
            }
        });

        NombreNot4.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        NombreNot4.setForeground(new java.awt.Color(204, 204, 204));
        NombreNot4.setText("Usuario");

        DescripcionNot4.setFont(new java.awt.Font("Roboto Black", 0, 12)); // NOI18N
        DescripcionNot4.setForeground(new java.awt.Color(204, 204, 204));
        DescripcionNot4.setText("Descripcion...");

        ImgNot4.setForeground(new java.awt.Color(255, 255, 255));
        ImgNot4.setText("ImgNot");

        javax.swing.GroupLayout PanelNot4Layout = new javax.swing.GroupLayout(PanelNot4);
        PanelNot4.setLayout(PanelNot4Layout);
        PanelNot4Layout.setHorizontalGroup(
            PanelNot4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelNot4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelNot4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DescripcionNot4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(PanelNot4Layout.createSequentialGroup()
                        .addComponent(ImgNot4, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(NombreNot4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(UsuarioNot4)
                        .addGap(0, 510, Short.MAX_VALUE)))
                .addContainerGap())
        );
        PanelNot4Layout.setVerticalGroup(
            PanelNot4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelNot4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelNot4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ImgNot4, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NombreNot4)
                    .addComponent(UsuarioNot4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DescripcionNot4, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PanelTotalNotificaciones.add(PanelNot4, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 650, 730, 130));

        IconoNotificaciones.setBackground(new java.awt.Color(166, 77, 121));
        IconoNotificaciones.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        IconoNotificaciones.setForeground(new java.awt.Color(204, 204, 204));
        IconoNotificaciones.setToolTipText("");
        IconoNotificaciones.setAlignmentY(0.0F);
        IconoNotificaciones.setBorderPainted(false);
        IconoNotificaciones.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        IconoNotificaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IconoNotificacionesActionPerformed(evt);
            }
        });
        PanelTotalNotificaciones.add(IconoNotificaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 60, 60, 60));

        NotificacionesTitulo.setFont(new java.awt.Font("Roboto Black", 1, 30)); // NOI18N
        NotificacionesTitulo.setForeground(new java.awt.Color(204, 204, 204));
        NotificacionesTitulo.setText("Notificaciones");
        PanelTotalNotificaciones.add(NotificacionesTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 70, 250, 40));

        IdUsuario.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        IdUsuario.setForeground(new java.awt.Color(166, 77, 121));
        IdUsuario.setText("@Usuario");
        PanelTotalNotificaciones.add(IdUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 980, -1, -1));

        UsuarioBtn.setBackground(new java.awt.Color(26, 26, 29));
        UsuarioBtn.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        UsuarioBtn.setForeground(new java.awt.Color(204, 204, 204));
        UsuarioBtn.setText("Usuario");
        UsuarioBtn.setToolTipText("");
        UsuarioBtn.setAlignmentY(0.0F);
        UsuarioBtn.setBorderPainted(false);
        UsuarioBtn.setContentAreaFilled(false);
        UsuarioBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        UsuarioBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsuarioBtnActionPerformed(evt);
            }
        });
        PanelTotalNotificaciones.add(UsuarioBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 950, 120, 40));

        PanelNot2.setBackground(new java.awt.Color(106, 30, 85));
        PanelNot2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        PanelNot2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        UsuarioNot2.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        UsuarioNot2.setForeground(new java.awt.Color(204, 204, 204));
        UsuarioNot2.setText("@Usuario");
        UsuarioNot2.setToolTipText("");
        UsuarioNot2.setBorder(null);
        UsuarioNot2.setBorderPainted(false);
        UsuarioNot2.setContentAreaFilled(false);
        UsuarioNot2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        UsuarioNot2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        UsuarioNot2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsuarioNot2ActionPerformed(evt);
            }
        });

        NombreNot2.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        NombreNot2.setForeground(new java.awt.Color(204, 204, 204));
        NombreNot2.setText("Usuario");

        DescripcionNot2.setFont(new java.awt.Font("Roboto Black", 0, 12)); // NOI18N
        DescripcionNot2.setForeground(new java.awt.Color(204, 204, 204));
        DescripcionNot2.setText("Descripcion...");

        ImgNot2.setForeground(new java.awt.Color(255, 255, 255));
        ImgNot2.setText("ImgNot");

        javax.swing.GroupLayout PanelNot2Layout = new javax.swing.GroupLayout(PanelNot2);
        PanelNot2.setLayout(PanelNot2Layout);
        PanelNot2Layout.setHorizontalGroup(
            PanelNot2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelNot2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelNot2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DescripcionNot2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(PanelNot2Layout.createSequentialGroup()
                        .addComponent(ImgNot2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(NombreNot2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(UsuarioNot2)
                        .addGap(0, 510, Short.MAX_VALUE)))
                .addContainerGap())
        );
        PanelNot2Layout.setVerticalGroup(
            PanelNot2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelNot2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelNot2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ImgNot2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NombreNot2)
                    .addComponent(UsuarioNot2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DescripcionNot2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PanelTotalNotificaciones.add(PanelNot2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 340, 730, 140));

        PanelNot1.setBackground(new java.awt.Color(59, 28, 50));
        PanelNot1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        PanelNot1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        UsuarioNot1.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        UsuarioNot1.setForeground(new java.awt.Color(204, 204, 204));
        UsuarioNot1.setText("@Usuario");
        UsuarioNot1.setToolTipText("");
        UsuarioNot1.setBorder(null);
        UsuarioNot1.setBorderPainted(false);
        UsuarioNot1.setContentAreaFilled(false);
        UsuarioNot1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        UsuarioNot1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        UsuarioNot1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsuarioNot1ActionPerformed(evt);
            }
        });

        NombreNot1.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        NombreNot1.setForeground(new java.awt.Color(204, 204, 204));
        NombreNot1.setText("Usuario");

        DescripcionNot1.setFont(new java.awt.Font("Roboto Black", 0, 12)); // NOI18N
        DescripcionNot1.setForeground(new java.awt.Color(204, 204, 204));
        DescripcionNot1.setText("Descripcion...");

        ImgNot1.setForeground(new java.awt.Color(255, 255, 255));
        ImgNot1.setText("ImgNot");

        javax.swing.GroupLayout PanelNot1Layout = new javax.swing.GroupLayout(PanelNot1);
        PanelNot1.setLayout(PanelNot1Layout);
        PanelNot1Layout.setHorizontalGroup(
            PanelNot1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelNot1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelNot1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DescripcionNot1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(PanelNot1Layout.createSequentialGroup()
                        .addComponent(ImgNot1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(NombreNot1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(UsuarioNot1)
                        .addGap(0, 510, Short.MAX_VALUE)))
                .addContainerGap())
        );
        PanelNot1Layout.setVerticalGroup(
            PanelNot1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelNot1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelNot1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ImgNot1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NombreNot1)
                    .addComponent(UsuarioNot1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DescripcionNot1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PanelTotalNotificaciones.add(PanelNot1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 190, 730, 130));

        PanelNot3.setBackground(new java.awt.Color(166, 77, 121));
        PanelNot3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        PanelNot3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        UsuarioNot3.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        UsuarioNot3.setForeground(new java.awt.Color(204, 204, 204));
        UsuarioNot3.setText("@Usuario");
        UsuarioNot3.setToolTipText("");
        UsuarioNot3.setBorder(null);
        UsuarioNot3.setBorderPainted(false);
        UsuarioNot3.setContentAreaFilled(false);
        UsuarioNot3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        UsuarioNot3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        UsuarioNot3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsuarioNot3ActionPerformed(evt);
            }
        });

        NombreNot3.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        NombreNot3.setForeground(new java.awt.Color(204, 204, 204));
        NombreNot3.setText("Usuario");

        DescripcionNot3.setFont(new java.awt.Font("Roboto Black", 0, 12)); // NOI18N
        DescripcionNot3.setForeground(new java.awt.Color(204, 204, 204));
        DescripcionNot3.setText("Descripcion...");

        ImgNot3.setForeground(new java.awt.Color(255, 255, 255));
        ImgNot3.setText("ImgNot");

        javax.swing.GroupLayout PanelNot3Layout = new javax.swing.GroupLayout(PanelNot3);
        PanelNot3.setLayout(PanelNot3Layout);
        PanelNot3Layout.setHorizontalGroup(
            PanelNot3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelNot3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelNot3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DescripcionNot3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(PanelNot3Layout.createSequentialGroup()
                        .addComponent(ImgNot3, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(NombreNot3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(UsuarioNot3)
                        .addGap(0, 510, Short.MAX_VALUE)))
                .addContainerGap())
        );
        PanelNot3Layout.setVerticalGroup(
            PanelNot3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelNot3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelNot3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ImgNot3, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NombreNot3)
                    .addComponent(UsuarioNot3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DescripcionNot3, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PanelTotalNotificaciones.add(PanelNot3, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 500, 730, 130));

        jSeparator4.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator4.setForeground(new java.awt.Color(153, 153, 153));
        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);
        PanelTotalNotificaciones.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 50, 10, 1040));

        PerfilPanel.setBackground(new java.awt.Color(0, 0, 0));
        PerfilPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        NombreUsuario.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        NombreUsuario.setForeground(new java.awt.Color(204, 204, 204));
        NombreUsuario.setText("Usuario");
        NombreUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        NombreUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                NombreUsuarioMousePressed(evt);
            }
        });
        PerfilPanel.add(NombreUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, -1, -1));

        IdUsuario2.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        IdUsuario2.setForeground(new java.awt.Color(166, 77, 121));
        IdUsuario2.setText("@Usuario1");
        PerfilPanel.add(IdUsuario2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, -1, -1));

        Perfil_Img.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Perfil_Img.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Perfil_Img.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Perfil_ImgMousePressed(evt);
            }
        });
        PerfilPanel.add(Perfil_Img, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 60, 60));

        PanelTotalNotificaciones.add(PerfilPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 750, 320, 80));

        ConfiBtn.setBackground(new java.awt.Color(26, 26, 29));
        ConfiBtn.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        ConfiBtn.setForeground(new java.awt.Color(204, 204, 204));
        ConfiBtn.setText("  Configuracion");
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
        PanelTotalNotificaciones.add(ConfiBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 430, 260, 40));

        InicioBtn1.setBackground(new java.awt.Color(26, 26, 29));
        InicioBtn1.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        InicioBtn1.setForeground(new java.awt.Color(204, 204, 204));
        InicioBtn1.setText("  Inicio");
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
        PanelTotalNotificaciones.add(InicioBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 250, 40));

        NotificacionesBtn.setBackground(new java.awt.Color(26, 26, 29));
        NotificacionesBtn.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
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
        PanelTotalNotificaciones.add(NotificacionesBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 310, 250, 40));

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
        PanelTotalNotificaciones.add(PerfilBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 370, 250, 40));

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
        PanelTotalNotificaciones.add(ExplorarBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, 250, 40));
        PanelTotalNotificaciones.add(Y_logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 90, 80));

        Header.setBackground(new java.awt.Color(0, 0, 0));
        Header.setPreferredSize(new java.awt.Dimension(1550, 60));
        Header.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                HeaderMouseDragged(evt);
            }
        });
        Header.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                HeaderMousePressed(evt);
            }
        });

        ExitPane.setBackground(new java.awt.Color(166, 77, 121));
        ExitPane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ExitPaneMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ExitPaneMouseExited(evt);
            }
        });

        ExitBtn.setFont(new java.awt.Font("Source Code Pro Black", 1, 36)); // NOI18N
        ExitBtn.setForeground(new java.awt.Color(106, 30, 85));
        ExitBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ExitBtn.setText("X");
        ExitBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ExitBtn.setPreferredSize(new java.awt.Dimension(50, 50));
        ExitBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ExitBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ExitBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ExitBtnMouseExited(evt);
            }
        });

        javax.swing.GroupLayout ExitPaneLayout = new javax.swing.GroupLayout(ExitPane);
        ExitPane.setLayout(ExitPaneLayout);
        ExitPaneLayout.setHorizontalGroup(
            ExitPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
            .addGroup(ExitPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(ExitBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
        );
        ExitPaneLayout.setVerticalGroup(
            ExitPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 52, Short.MAX_VALUE)
            .addGroup(ExitPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(ExitPaneLayout.createSequentialGroup()
                    .addComponent(ExitBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout HeaderLayout = new javax.swing.GroupLayout(Header);
        Header.setLayout(HeaderLayout);
        HeaderLayout.setHorizontalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1550, Short.MAX_VALUE)
            .addGroup(HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HeaderLayout.createSequentialGroup()
                    .addGap(0, 1490, Short.MAX_VALUE)
                    .addComponent(ExitPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        HeaderLayout.setVerticalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(HeaderLayout.createSequentialGroup()
                    .addGap(2, 2, 2)
                    .addComponent(ExitPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        PanelTotalNotificaciones.add(Header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1550, 50));

        QuePasa.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        QuePasa.setForeground(new java.awt.Color(204, 204, 204));
        QuePasa.setText("Qué pasa");
        PanelTotalNotificaciones.add(QuePasa, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 460, 90, 30));

        SeguirCuentaBtn3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        SeguirCuentaBtn3.setText("Seguir");
        SeguirCuentaBtn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SeguirCuentaBtn3ActionPerformed(evt);
            }
        });
        PanelTotalNotificaciones.add(SeguirCuentaBtn3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1400, 320, -1, 30));

        SeguirCuentaBtn1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        SeguirCuentaBtn1.setText("Seguir");
        SeguirCuentaBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SeguirCuentaBtn1ActionPerformed(evt);
            }
        });
        PanelTotalNotificaciones.add(SeguirCuentaBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1400, 200, -1, 30));

        SeguirCuentaBtn2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        SeguirCuentaBtn2.setText("Seguir");
        SeguirCuentaBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SeguirCuentaBtn2ActionPerformed(evt);
            }
        });
        PanelTotalNotificaciones.add(SeguirCuentaBtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1400, 260, -1, 30));

        jSeparator6.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator6.setForeground(new java.awt.Color(153, 153, 153));
        jSeparator6.setOrientation(javax.swing.SwingConstants.VERTICAL);
        PanelTotalNotificaciones.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 130, 30, 250));

        jSeparator7.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator7.setForeground(new java.awt.Color(153, 153, 153));
        jSeparator7.setOrientation(javax.swing.SwingConstants.VERTICAL);
        PanelTotalNotificaciones.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 430, 10, 340));
        PanelTotalNotificaciones.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 430, 330, 20));

        jLabel40.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(204, 204, 204));
        jLabel40.setText("Te puede interesar");
        PanelTotalNotificaciones.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 130, 210, 30));

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
        PanelTotalNotificaciones.add(CuentaBtn20, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 440, 80, 20));

        TendenciaYapBtn.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        TendenciaYapBtn.setForeground(new java.awt.Color(204, 204, 204));
        TendenciaYapBtn.setBorder(null);
        TendenciaYapBtn.setBorderPainted(false);
        TendenciaYapBtn.setContentAreaFilled(false);
        TendenciaYapBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TendenciaYapBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        TendenciaYapBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TendenciaYapBtnMousePressed(evt);
            }
        });
        TendenciaYapBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TendenciaYapBtnActionPerformed(evt);
            }
        });
        PanelTotalNotificaciones.add(TendenciaYapBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 500, 310, 60));

        numreacciones.setFont(new java.awt.Font("Roboto Black", 0, 12)); // NOI18N
        numreacciones.setForeground(new java.awt.Color(204, 204, 204));
        numreacciones.setText("reacciones");
        numreacciones.setBorder(null);
        numreacciones.setBorderPainted(false);
        numreacciones.setContentAreaFilled(false);
        numreacciones.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        numreacciones.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        numreacciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numreaccionesActionPerformed(evt);
            }
        });
        PanelTotalNotificaciones.add(numreacciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 560, 70, 30));

        MostrarMasInteresBtn.setFont(new java.awt.Font("Roboto Black", 0, 10)); // NOI18N
        MostrarMasInteresBtn.setForeground(new java.awt.Color(204, 204, 204));
        MostrarMasInteresBtn.setText("Mostrar mas");
        MostrarMasInteresBtn.setBorder(null);
        MostrarMasInteresBtn.setBorderPainted(false);
        MostrarMasInteresBtn.setContentAreaFilled(false);
        MostrarMasInteresBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MostrarMasInteresBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        MostrarMasInteresBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MostrarMasInteresBtnMousePressed(evt);
            }
        });
        MostrarMasInteresBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MostrarMasInteresBtnActionPerformed(evt);
            }
        });
        PanelTotalNotificaciones.add(MostrarMasInteresBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1430, 360, 60, 20));

        ImgInt3.setForeground(new java.awt.Color(255, 255, 255));
        ImgInt3.setText("ImgInteres2");
        PanelTotalNotificaciones.add(ImgInt3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 310, 60, 60));

        ImgInt1.setForeground(new java.awt.Color(255, 255, 255));
        ImgInt1.setText("ImgInteres1");
        PanelTotalNotificaciones.add(ImgInt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 170, 60, 60));

        ImgInt2.setForeground(new java.awt.Color(255, 255, 255));
        ImgInt2.setText("ImgInteres2");
        PanelTotalNotificaciones.add(ImgInt2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 240, 60, 60));

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
        PanelTotalNotificaciones.add(UserInt3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 320, -1, 30));

        UserInt1.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        UserInt1.setForeground(new java.awt.Color(204, 204, 204));
        UserInt1.setText("@Usuario");
        UserInt1.setToolTipText("");
        UserInt1.setBorder(null);
        UserInt1.setBorderPainted(false);
        UserInt1.setContentAreaFilled(false);
        UserInt1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        UserInt1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        UserInt1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                UserInt1MousePressed(evt);
            }
        });
        UserInt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserInt1ActionPerformed(evt);
            }
        });
        PanelTotalNotificaciones.add(UserInt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 200, -1, 30));

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
        PanelTotalNotificaciones.add(UserInt2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 260, -1, 30));
        PanelTotalNotificaciones.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 130, 280, 10));

        LabelAviso2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LabelAviso2.setForeground(new java.awt.Color(166, 77, 121));
        PanelTotalNotificaciones.add(LabelAviso2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 380, 250, 40));

        Num_Reacciones.setForeground(new java.awt.Color(204, 204, 204));
        Num_Reacciones.setText("10");
        PanelTotalNotificaciones.add(Num_Reacciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 560, 30, 30));

        TendenciaYapBtn1.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        TendenciaYapBtn1.setForeground(new java.awt.Color(204, 204, 204));
        TendenciaYapBtn1.setBorder(null);
        TendenciaYapBtn1.setBorderPainted(false);
        TendenciaYapBtn1.setContentAreaFilled(false);
        TendenciaYapBtn1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TendenciaYapBtn1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        TendenciaYapBtn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TendenciaYapBtn1MousePressed(evt);
            }
        });
        TendenciaYapBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TendenciaYapBtn1ActionPerformed(evt);
            }
        });
        PanelTotalNotificaciones.add(TendenciaYapBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 590, 310, 60));

        numreacciones1.setFont(new java.awt.Font("Roboto Black", 0, 12)); // NOI18N
        numreacciones1.setForeground(new java.awt.Color(204, 204, 204));
        numreacciones1.setText("reacciones");
        numreacciones1.setBorder(null);
        numreacciones1.setBorderPainted(false);
        numreacciones1.setContentAreaFilled(false);
        numreacciones1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        numreacciones1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        numreacciones1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numreacciones1ActionPerformed(evt);
            }
        });
        PanelTotalNotificaciones.add(numreacciones1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 650, 70, 30));

        Num_Reacciones1.setForeground(new java.awt.Color(204, 204, 204));
        Num_Reacciones1.setText("10");
        PanelTotalNotificaciones.add(Num_Reacciones1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 650, 30, 30));

        TendenciaYapBtn2.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        TendenciaYapBtn2.setForeground(new java.awt.Color(204, 204, 204));
        TendenciaYapBtn2.setBorder(null);
        TendenciaYapBtn2.setBorderPainted(false);
        TendenciaYapBtn2.setContentAreaFilled(false);
        TendenciaYapBtn2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TendenciaYapBtn2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        TendenciaYapBtn2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TendenciaYapBtn2MousePressed(evt);
            }
        });
        TendenciaYapBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TendenciaYapBtn2ActionPerformed(evt);
            }
        });
        PanelTotalNotificaciones.add(TendenciaYapBtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 680, 310, 60));

        numreacciones2.setFont(new java.awt.Font("Roboto Black", 0, 12)); // NOI18N
        numreacciones2.setForeground(new java.awt.Color(204, 204, 204));
        numreacciones2.setText("reacciones");
        numreacciones2.setBorder(null);
        numreacciones2.setBorderPainted(false);
        numreacciones2.setContentAreaFilled(false);
        numreacciones2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        numreacciones2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        numreacciones2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numreacciones2ActionPerformed(evt);
            }
        });
        PanelTotalNotificaciones.add(numreacciones2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 740, 70, 30));

        Num_Reacciones2.setForeground(new java.awt.Color(204, 204, 204));
        Num_Reacciones2.setText("10");
        PanelTotalNotificaciones.add(Num_Reacciones2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 740, 30, 30));
        PanelTotalNotificaciones.add(jSeparator12, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 380, 280, 20));

        jSeparator13.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator13.setForeground(new java.awt.Color(153, 153, 153));
        jSeparator13.setOrientation(javax.swing.SwingConstants.VERTICAL);
        PanelTotalNotificaciones.add(jSeparator13, new org.netbeans.lib.awtextra.AbsoluteConstraints(1490, 130, 20, 250));
        PanelTotalNotificaciones.add(jSeparator14, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 770, 330, 20));

        jSeparator15.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator15.setForeground(new java.awt.Color(153, 153, 153));
        jSeparator15.setOrientation(javax.swing.SwingConstants.VERTICAL);
        PanelTotalNotificaciones.add(jSeparator15, new org.netbeans.lib.awtextra.AbsoluteConstraints(1530, 430, 10, 340));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PanelTotalNotificaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 1550, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PanelTotalNotificaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 890, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CuentaBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CuentaBtn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CuentaBtn1ActionPerformed

    private void UsuarioNot4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsuarioNot4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UsuarioNot4ActionPerformed

    private void FiltroSeguidoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FiltroSeguidoresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FiltroSeguidoresActionPerformed

    private void FiltroYapsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FiltroYapsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FiltroYapsActionPerformed

    private void FiltroTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FiltroTodoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FiltroTodoActionPerformed

    private void IconoNotificacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IconoNotificacionesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IconoNotificacionesActionPerformed

    private void UsuarioBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsuarioBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UsuarioBtnActionPerformed

    private void UsuarioNot2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsuarioNot2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UsuarioNot2ActionPerformed

    private void UsuarioNot1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsuarioNot1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UsuarioNot1ActionPerformed

    private void UsuarioNot3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsuarioNot3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UsuarioNot3ActionPerformed

    private void NombreUsuarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NombreUsuarioMousePressed
        this.dispose();
        new Perfil().setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_NombreUsuarioMousePressed

    private void Perfil_ImgMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Perfil_ImgMousePressed
        this.dispose();
        new Perfil().setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_Perfil_ImgMousePressed

    private void ConfiBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfiBtnActionPerformed
        this.dispose();
        new Configuracion().setVisible(true);
    }//GEN-LAST:event_ConfiBtnActionPerformed

    private void InicioBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InicioBtn1ActionPerformed
        this.dispose();
        new Menu_Principal().setVisible(true);
    }//GEN-LAST:event_InicioBtn1ActionPerformed

    private void NotificacionesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NotificacionesBtnActionPerformed
        this.dispose();
        new Notificaciones().setVisible(true);
    }//GEN-LAST:event_NotificacionesBtnActionPerformed

    private void PerfilBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PerfilBtnActionPerformed
        this.dispose();
        new Perfil().setVisible(true);
    }//GEN-LAST:event_PerfilBtnActionPerformed

    private void ExplorarBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExplorarBtn1ActionPerformed
        this.dispose();
        new Explorar().setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_ExplorarBtn1ActionPerformed

    private void ExitBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExitBtnMouseClicked
        System.exit(0);
        // TODO add your handling code here:
    }//GEN-LAST:event_ExitBtnMouseClicked

    private void ExitBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExitBtnMouseEntered
        ExitPane.setBackground(Color.LIGHT_GRAY);
        // TODO add your handling code here:
    }//GEN-LAST:event_ExitBtnMouseEntered

    private void ExitBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExitBtnMouseExited
        ExitPane.setBackground(new java.awt.Color(166,77,121));
        // TODO add your handling code here:
    }//GEN-LAST:event_ExitBtnMouseExited

    private void ExitPaneMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExitPaneMouseEntered
        ExitPane.setBackground(Color.LIGHT_GRAY);
        // TODO add your handling code here:
    }//GEN-LAST:event_ExitPaneMouseEntered

    private void ExitPaneMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExitPaneMouseExited
        ExitPane.setBackground(new java.awt.Color(166,77,121));
        // TODO add your handling code here:
    }//GEN-LAST:event_ExitPaneMouseExited

    private void HeaderMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HeaderMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
        // TODO add your handling code here:
    }//GEN-LAST:event_HeaderMouseDragged

    private void HeaderMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HeaderMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
        // TODO add your handling code here:
    }//GEN-LAST:event_HeaderMousePressed

    private void SeguirCuentaBtn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeguirCuentaBtn3ActionPerformed
        String idSeguidor = SesionUsuario.idUsuario; // ID del usuario logueado
        String idSeguido = UserInt3.getText(); // ID del perfil que se está viendo

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/y_bd", "root", "");

            String sql = "INSERT IGNORE INTO seguidores (id_seguidor, id_seguido) VALUES (?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, idSeguidor);
            ps.setString(2, idSeguido);

            int filas = ps.executeUpdate();

            if (filas > 0) {
                // Éxito: se insertó un nuevo seguidor
                LabelAviso2.setText("Ahora estás siguiendo a " + idSeguido);

                // Cambiar texto y colores del botón
                SeguirCuentaBtn3.setText("Siguiendo");
                SeguirCuentaBtn3.setEnabled(false); // Desactiva el botón para evitar múltiples clics
            } else {
                LabelAviso2.setText("Ya lo estás siguiendo");
            }

            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_SeguirCuentaBtn3ActionPerformed

    private void SeguirCuentaBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeguirCuentaBtn1ActionPerformed
        String idSeguidor = SesionUsuario.idUsuario; // ID del usuario logueado
        String idSeguido = UserInt1.getText(); // ID del perfil que se está viendo

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/y_bd", "root", "");

            String sql = "INSERT IGNORE INTO seguidores (id_seguidor, id_seguido) VALUES (?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, idSeguidor);
            ps.setString(2, idSeguido);

            int filas = ps.executeUpdate();

            if (filas > 0) {
                // Éxito: se insertó un nuevo seguidor
                LabelAviso2.setText("Ahora estás siguiendo a " + idSeguido);

                // Cambiar texto y colores del botón
                SeguirCuentaBtn1.setText("Siguiendo");
                SeguirCuentaBtn1.setEnabled(false); // Desactiva el botón para evitar múltiples clics
            } else {
                LabelAviso2.setText("Ya lo estás siguiendo");
            }

            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_SeguirCuentaBtn1ActionPerformed

    private void SeguirCuentaBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeguirCuentaBtn2ActionPerformed
        String idSeguidor = SesionUsuario.idUsuario; // ID del usuario logueado
        String idSeguido = UserInt2.getText(); // ID del perfil que se está viendo

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/y_bd", "root", "");

            String sql = "INSERT IGNORE INTO seguidores (id_seguidor, id_seguido) VALUES (?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, idSeguidor);
            ps.setString(2, idSeguido);

            int filas = ps.executeUpdate();

            if (filas > 0) {
                // Éxito: se insertó un nuevo seguidor
                LabelAviso2.setText("Ahora estás siguiendo a " + idSeguido);

                // Cambiar texto y colores del botón
                SeguirCuentaBtn2.setText("Siguiendo");
                SeguirCuentaBtn2.setEnabled(false); // Desactiva el botón para evitar múltiples clics
            } else {
                LabelAviso2.setText("Ya lo estás siguiendo");
            }

            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_SeguirCuentaBtn2ActionPerformed

    private void CuentaBtn20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CuentaBtn20ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CuentaBtn20ActionPerformed

    private void TendenciaYapBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TendenciaYapBtnMousePressed
        this.dispose();
        new Menu_Principal().setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_TendenciaYapBtnMousePressed

    private void TendenciaYapBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TendenciaYapBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TendenciaYapBtnActionPerformed

    private void numreaccionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numreaccionesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numreaccionesActionPerformed

    private void MostrarMasInteresBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MostrarMasInteresBtnMousePressed
        SeccionTePuedeInteresar();
        // TODO add your handling code here:
    }//GEN-LAST:event_MostrarMasInteresBtnMousePressed

    private void MostrarMasInteresBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MostrarMasInteresBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MostrarMasInteresBtnActionPerformed

    private void UserInt3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserInt3ActionPerformed
        this.dispose();
        try {
            new PerfilPersona(Interes3).setVisible(true);
            // TODO add your handling code here:
        } catch (SQLException ex) {
            Logger.getLogger(Menu_Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_UserInt3ActionPerformed

    private void UserInt1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UserInt1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_UserInt1MousePressed

    private void UserInt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserInt1ActionPerformed
        this.dispose();
        try {
            new PerfilPersona(Interes1).setVisible(true);
            // TODO add your handling code here:
        } catch (SQLException ex) {
            Logger.getLogger(Menu_Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_UserInt1ActionPerformed

    private void UserInt2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserInt2ActionPerformed
        this.dispose();
        try {
            new PerfilPersona(Interes2).setVisible(true);
            // TODO add your handling code here:
        } catch (SQLException ex) {
            Logger.getLogger(Menu_Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_UserInt2ActionPerformed

    private void TendenciaYapBtn1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TendenciaYapBtn1MousePressed
        this.dispose();
        new Menu_Principal().setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_TendenciaYapBtn1MousePressed

    private void TendenciaYapBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TendenciaYapBtn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TendenciaYapBtn1ActionPerformed

    private void numreacciones1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numreacciones1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numreacciones1ActionPerformed

    private void TendenciaYapBtn2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TendenciaYapBtn2MousePressed
        this.dispose();
        new Menu_Principal().setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_TendenciaYapBtn2MousePressed

    private void TendenciaYapBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TendenciaYapBtn2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TendenciaYapBtn2ActionPerformed

    private void numreacciones2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numreacciones2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numreacciones2ActionPerformed

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
            java.util.logging.Logger.getLogger(Notificaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Notificaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Notificaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Notificaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Notificaciones().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ConfiBtn;
    private javax.swing.JButton CuentaBtn1;
    private javax.swing.JButton CuentaBtn20;
    private javax.swing.JLabel DescripcionNot1;
    private javax.swing.JLabel DescripcionNot2;
    private javax.swing.JLabel DescripcionNot3;
    private javax.swing.JLabel DescripcionNot4;
    private javax.swing.JLabel ExitBtn;
    private javax.swing.JPanel ExitPane;
    private javax.swing.JButton ExplorarBtn1;
    private javax.swing.JButton FiltroSeguidores;
    private javax.swing.JButton FiltroTodo;
    private javax.swing.JButton FiltroYaps;
    private javax.swing.JPanel Header;
    private javax.swing.JButton IconoNotificaciones;
    private javax.swing.JLabel IdUsuario;
    private javax.swing.JLabel IdUsuario2;
    private javax.swing.JLabel ImgInt1;
    private javax.swing.JLabel ImgInt2;
    private javax.swing.JLabel ImgInt3;
    private javax.swing.JLabel ImgNot1;
    private javax.swing.JLabel ImgNot2;
    private javax.swing.JLabel ImgNot3;
    private javax.swing.JLabel ImgNot4;
    private javax.swing.JButton InicioBtn1;
    private javax.swing.JLabel LabelAviso2;
    private javax.swing.JButton MostrarMasInteresBtn;
    private javax.swing.JLabel NombreNot1;
    private javax.swing.JLabel NombreNot2;
    private javax.swing.JLabel NombreNot3;
    private javax.swing.JLabel NombreNot4;
    private javax.swing.JLabel NombreUsuario;
    private javax.swing.JButton NotificacionesBtn;
    private javax.swing.JLabel NotificacionesTitulo;
    private javax.swing.JLabel Num_Reacciones;
    private javax.swing.JLabel Num_Reacciones1;
    private javax.swing.JLabel Num_Reacciones2;
    private javax.swing.JPanel PanelNot1;
    private javax.swing.JPanel PanelNot2;
    private javax.swing.JPanel PanelNot3;
    private javax.swing.JPanel PanelNot4;
    private javax.swing.JPanel PanelTotalNotificaciones;
    private javax.swing.JButton PerfilBtn;
    private javax.swing.JPanel PerfilPanel;
    private javax.swing.JLabel Perfil_Img;
    private javax.swing.JLabel QuePasa;
    private javax.swing.JButton SeguirCuentaBtn1;
    private javax.swing.JButton SeguirCuentaBtn2;
    private javax.swing.JButton SeguirCuentaBtn3;
    private javax.swing.JButton TendenciaYapBtn;
    private javax.swing.JButton TendenciaYapBtn1;
    private javax.swing.JButton TendenciaYapBtn2;
    private javax.swing.JButton UserInt1;
    private javax.swing.JButton UserInt2;
    private javax.swing.JButton UserInt3;
    private javax.swing.JButton UsuarioBtn;
    private javax.swing.JButton UsuarioNot1;
    private javax.swing.JButton UsuarioNot2;
    private javax.swing.JButton UsuarioNot3;
    private javax.swing.JButton UsuarioNot4;
    private javax.swing.JLabel Y_logo;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator15;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JButton numreacciones;
    private javax.swing.JButton numreacciones1;
    private javax.swing.JButton numreacciones2;
    // End of variables declaration//GEN-END:variables
}
