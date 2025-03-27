
package com.mycompany.proyect_y;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Notificaciones extends javax.swing.JFrame {

    public Notificaciones() {
        initComponents();
        this.setLocationRelativeTo(null);
        Img();
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
        ExplorarBtn.setIcon(Icono2);
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

        jPanel1 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        CuentaBtn1 = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        FiltroSeguidores = new javax.swing.JButton();
        FiltroYaps = new javax.swing.JButton();
        SeguridadYAccesoBtn8 = new javax.swing.JButton();
        SeguridadYAccesoBtn = new javax.swing.JButton();
        FiltroTodo = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        UsuarioNot1 = new javax.swing.JButton();
        NombreNot1 = new javax.swing.JLabel();
        DescripcionNot1 = new javax.swing.JLabel();
        IconoNotificaciones = new javax.swing.JButton();
        Seccion = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        UsuarioNot2 = new javax.swing.JButton();
        NombreNot2 = new javax.swing.JLabel();
        DescripcionNot2 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        UsuarioNot3 = new javax.swing.JButton();
        NombreNot3 = new javax.swing.JLabel();
        DescripcionNot3 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        UsuarioNot4 = new javax.swing.JButton();
        NombreNot4 = new javax.swing.JLabel();
        DescripcionNot4 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        UsuarioNot5 = new javax.swing.JButton();
        NombreNot5 = new javax.swing.JLabel();
        DecripcionNot5 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        UsuarioNot6 = new javax.swing.JButton();
        NombreNot6 = new javax.swing.JLabel();
        DescripcionNot6 = new javax.swing.JLabel();
        CuentaBtn = new javax.swing.JButton();
        jLabel38 = new javax.swing.JLabel();
        CuentaBtn7 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        CuentaBtn13 = new javax.swing.JButton();
        CuentaBtn14 = new javax.swing.JButton();
        SeguirCuentaBtn13 = new javax.swing.JButton();
        CuentaBtn15 = new javax.swing.JButton();
        CuentaBtn16 = new javax.swing.JButton();
        SeguirCuentaBtn15 = new javax.swing.JButton();
        CuentaBtn17 = new javax.swing.JButton();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        jLabel40 = new javax.swing.JLabel();
        CuentaBtn6 = new javax.swing.JButton();
        TendenciaYapBtn2 = new javax.swing.JButton();
        MostrarMasTendenciaBtn = new javax.swing.JButton();
        CuentaBtn20 = new javax.swing.JButton();
        TendenciaYapBtn1 = new javax.swing.JButton();
        CuentaBtn23 = new javax.swing.JButton();
        MostrarMasTePuedeInteresarBtn = new javax.swing.JButton();
        IdUsuario = new javax.swing.JLabel();
        UsuarioBtn = new javax.swing.JButton();
        ConfiBtn = new javax.swing.JButton();
        InicioBtn1 = new javax.swing.JButton();
        ExplorarBtn = new javax.swing.JButton();
        ComunidadesBtn = new javax.swing.JButton();
        NotificacionesBtn = new javax.swing.JButton();
        GuardadoBtn = new javax.swing.JButton();
        PerfilBtn = new javax.swing.JButton();
        jPanel21 = new javax.swing.JPanel();
        Y_logo = new javax.swing.JLabel();
        PostearBtn = new javax.swing.JButton();
        PerfilPanel = new javax.swing.JPanel();
        Perfil_Img1 = new javax.swing.JLabel();
        NombreUsuario = new javax.swing.JLabel();
        IdUsuario2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        Perfil_Img = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setPreferredSize(new java.awt.Dimension(1550, 810));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator1.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator1.setForeground(new java.awt.Color(153, 153, 153));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(427, 0, -1, 1040));

        jSeparator4.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator4.setForeground(new java.awt.Color(153, 153, 153));
        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 0, 10, 1040));

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
        jPanel1.add(CuentaBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 990, 70, 40));

        jSeparator5.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator5.setForeground(new java.awt.Color(153, 153, 153));
        jSeparator5.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 0, 10, 1040));

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

        SeguridadYAccesoBtn8.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        SeguridadYAccesoBtn8.setForeground(new java.awt.Color(204, 204, 204));
        SeguridadYAccesoBtn8.setToolTipText("");
        SeguridadYAccesoBtn8.setBorder(null);
        SeguridadYAccesoBtn8.setBorderPainted(false);
        SeguridadYAccesoBtn8.setContentAreaFilled(false);
        SeguridadYAccesoBtn8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SeguridadYAccesoBtn8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        SeguridadYAccesoBtn8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SeguridadYAccesoBtn8ActionPerformed(evt);
            }
        });

        SeguridadYAccesoBtn.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        SeguridadYAccesoBtn.setForeground(new java.awt.Color(204, 204, 204));
        SeguridadYAccesoBtn.setText("Le gusta");
        SeguridadYAccesoBtn.setToolTipText("");
        SeguridadYAccesoBtn.setBorder(null);
        SeguridadYAccesoBtn.setBorderPainted(false);
        SeguridadYAccesoBtn.setContentAreaFilled(false);
        SeguridadYAccesoBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SeguridadYAccesoBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        SeguridadYAccesoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SeguridadYAccesoBtnActionPerformed(evt);
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
                .addGap(72, 72, 72)
                .addComponent(FiltroTodo)
                .addGap(96, 96, 96)
                .addComponent(FiltroSeguidores)
                .addGap(90, 90, 90)
                .addComponent(FiltroYaps, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(SeguridadYAccesoBtn8, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(126, 126, 126)
                .addComponent(SeguridadYAccesoBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FiltroSeguidores, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FiltroYaps, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SeguridadYAccesoBtn8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SeguridadYAccesoBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FiltroTodo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 90, 490, 40));

        jPanel4.setBackground(new java.awt.Color(59, 28, 50));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

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

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(NombreNot1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(UsuarioNot1))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(DescripcionNot1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(272, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UsuarioNot1)
                    .addComponent(NombreNot1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DescripcionNot1)
                .addGap(0, 22, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 140, 470, 70));

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
        jPanel1.add(IconoNotificaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 30, 40, 40));

        Seccion.setFont(new java.awt.Font("Roboto Black", 1, 36)); // NOI18N
        Seccion.setForeground(new java.awt.Color(204, 204, 204));
        Seccion.setText("Notificaciones");
        jPanel1.add(Seccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 30, 250, 40));

        jPanel6.setBackground(new java.awt.Color(106, 30, 85));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

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

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(NombreNot2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(UsuarioNot2))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(DescripcionNot2, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(274, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UsuarioNot2)
                    .addComponent(NombreNot2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DescripcionNot2)
                .addGap(0, 24, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 220, -1, -1));

        jPanel7.setBackground(new java.awt.Color(166, 77, 121));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

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

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(NombreNot3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(UsuarioNot3))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(DescripcionNot3, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(276, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UsuarioNot3)
                    .addComponent(NombreNot3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DescripcionNot3)
                .addGap(0, 26, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 300, -1, -1));

        jPanel8.setBackground(new java.awt.Color(59, 28, 50));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

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

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(NombreNot4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(UsuarioNot4))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(DescripcionNot4, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(274, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UsuarioNot4)
                    .addComponent(NombreNot4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DescripcionNot4)
                .addGap(0, 24, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 380, -1, -1));

        jPanel9.setBackground(new java.awt.Color(106, 30, 85));
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        UsuarioNot5.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        UsuarioNot5.setForeground(new java.awt.Color(204, 204, 204));
        UsuarioNot5.setText("@Usuario");
        UsuarioNot5.setToolTipText("");
        UsuarioNot5.setBorder(null);
        UsuarioNot5.setBorderPainted(false);
        UsuarioNot5.setContentAreaFilled(false);
        UsuarioNot5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        UsuarioNot5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        UsuarioNot5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsuarioNot5ActionPerformed(evt);
            }
        });

        NombreNot5.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        NombreNot5.setForeground(new java.awt.Color(204, 204, 204));
        NombreNot5.setText("Usuario");

        DecripcionNot5.setFont(new java.awt.Font("Roboto Black", 0, 12)); // NOI18N
        DecripcionNot5.setForeground(new java.awt.Color(204, 204, 204));
        DecripcionNot5.setText("Descripcion...");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(NombreNot5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(UsuarioNot5))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(DecripcionNot5, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(272, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UsuarioNot5)
                    .addComponent(NombreNot5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DecripcionNot5)
                .addGap(0, 22, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 460, -1, -1));

        jPanel10.setBackground(new java.awt.Color(166, 77, 121));
        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        UsuarioNot6.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        UsuarioNot6.setForeground(new java.awt.Color(204, 204, 204));
        UsuarioNot6.setText("@Usuario");
        UsuarioNot6.setToolTipText("");
        UsuarioNot6.setBorder(null);
        UsuarioNot6.setBorderPainted(false);
        UsuarioNot6.setContentAreaFilled(false);
        UsuarioNot6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        UsuarioNot6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        UsuarioNot6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsuarioNot6ActionPerformed(evt);
            }
        });

        NombreNot6.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        NombreNot6.setForeground(new java.awt.Color(204, 204, 204));
        NombreNot6.setText("Usuario");

        DescripcionNot6.setFont(new java.awt.Font("Roboto Black", 0, 12)); // NOI18N
        DescripcionNot6.setForeground(new java.awt.Color(204, 204, 204));
        DescripcionNot6.setText("Descripcion...");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(NombreNot6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(UsuarioNot6))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(DescripcionNot6, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(274, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UsuarioNot6)
                    .addComponent(NombreNot6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DescripcionNot6)
                .addGap(0, 24, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 540, -1, -1));

        CuentaBtn.setFont(new java.awt.Font("Roboto Black", 0, 10)); // NOI18N
        CuentaBtn.setForeground(new java.awt.Color(204, 204, 204));
        CuentaBtn.setText("1000 publicaciones");
        CuentaBtn.setBorder(null);
        CuentaBtn.setBorderPainted(false);
        CuentaBtn.setContentAreaFilled(false);
        CuentaBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CuentaBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        CuentaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CuentaBtnActionPerformed(evt);
            }
        });
        jPanel1.add(CuentaBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 490, 100, 30));

        jLabel38.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(204, 204, 204));
        jLabel38.setText("Qué pasa");
        jPanel1.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 350, 210, 30));

        CuentaBtn7.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        CuentaBtn7.setForeground(new java.awt.Color(204, 204, 204));
        CuentaBtn7.setText("00000");
        CuentaBtn7.setBorder(null);
        CuentaBtn7.setBorderPainted(false);
        CuentaBtn7.setContentAreaFilled(false);
        CuentaBtn7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CuentaBtn7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        CuentaBtn7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CuentaBtn7ActionPerformed(evt);
            }
        });
        jPanel1.add(CuentaBtn7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 220, 80, 50));

        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton5.setText("Seguir");
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 230, -1, -1));

        CuentaBtn13.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        CuentaBtn13.setForeground(new java.awt.Color(204, 204, 204));
        CuentaBtn13.setText("''''''''");
        CuentaBtn13.setBorder(null);
        CuentaBtn13.setBorderPainted(false);
        CuentaBtn13.setContentAreaFilled(false);
        CuentaBtn13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CuentaBtn13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        CuentaBtn13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CuentaBtn13ActionPerformed(evt);
            }
        });
        jPanel1.add(CuentaBtn13, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 110, 80, 50));

        CuentaBtn14.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        CuentaBtn14.setForeground(new java.awt.Color(204, 204, 204));
        CuentaBtn14.setText("00000");
        CuentaBtn14.setBorder(null);
        CuentaBtn14.setBorderPainted(false);
        CuentaBtn14.setContentAreaFilled(false);
        CuentaBtn14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CuentaBtn14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        CuentaBtn14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CuentaBtn14ActionPerformed(evt);
            }
        });
        jPanel1.add(CuentaBtn14, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 120, 80, 50));

        SeguirCuentaBtn13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        SeguirCuentaBtn13.setText("Seguir");
        jPanel1.add(SeguirCuentaBtn13, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 130, -1, -1));

        CuentaBtn15.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        CuentaBtn15.setForeground(new java.awt.Color(204, 204, 204));
        CuentaBtn15.setText("''''''''");
        CuentaBtn15.setBorder(null);
        CuentaBtn15.setBorderPainted(false);
        CuentaBtn15.setContentAreaFilled(false);
        CuentaBtn15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CuentaBtn15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        CuentaBtn15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CuentaBtn15ActionPerformed(evt);
            }
        });
        jPanel1.add(CuentaBtn15, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 160, 80, 50));

        CuentaBtn16.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        CuentaBtn16.setForeground(new java.awt.Color(204, 204, 204));
        CuentaBtn16.setText("00000");
        CuentaBtn16.setBorder(null);
        CuentaBtn16.setBorderPainted(false);
        CuentaBtn16.setContentAreaFilled(false);
        CuentaBtn16.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CuentaBtn16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        CuentaBtn16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CuentaBtn16ActionPerformed(evt);
            }
        });
        jPanel1.add(CuentaBtn16, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 170, 80, 50));

        SeguirCuentaBtn15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        SeguirCuentaBtn15.setText("Seguir");
        jPanel1.add(SeguirCuentaBtn15, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 180, -1, -1));

        CuentaBtn17.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        CuentaBtn17.setForeground(new java.awt.Color(204, 204, 204));
        CuentaBtn17.setText("''''''''");
        CuentaBtn17.setBorder(null);
        CuentaBtn17.setBorderPainted(false);
        CuentaBtn17.setContentAreaFilled(false);
        CuentaBtn17.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CuentaBtn17.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        CuentaBtn17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CuentaBtn17ActionPerformed(evt);
            }
        });
        jPanel1.add(CuentaBtn17, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 210, 80, 50));

        jSeparator6.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator6.setForeground(new java.awt.Color(153, 153, 153));
        jSeparator6.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 80, 80, 220));

        jSeparator7.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator7.setForeground(new java.awt.Color(153, 153, 153));
        jSeparator7.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 80, 20, 220));
        jPanel1.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 300, 280, 20));
        jPanel1.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 80, 280, 10));

        jLabel40.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(204, 204, 204));
        jLabel40.setText("Te puede interesar");
        jPanel1.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 80, 210, 30));

        CuentaBtn6.setFont(new java.awt.Font("Roboto Black", 0, 10)); // NOI18N
        CuentaBtn6.setForeground(new java.awt.Color(204, 204, 204));
        CuentaBtn6.setText("Tendencia");
        CuentaBtn6.setBorder(null);
        CuentaBtn6.setBorderPainted(false);
        CuentaBtn6.setContentAreaFilled(false);
        CuentaBtn6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CuentaBtn6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        CuentaBtn6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CuentaBtn6ActionPerformed(evt);
            }
        });
        jPanel1.add(CuentaBtn6, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 450, 80, 30));

        TendenciaYapBtn2.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        TendenciaYapBtn2.setForeground(new java.awt.Color(204, 204, 204));
        TendenciaYapBtn2.setText("#0000");
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
        jPanel1.add(TendenciaYapBtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 460, 80, 50));

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
        jPanel1.add(MostrarMasTendenciaBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 510, 80, 50));

        CuentaBtn20.setFont(new java.awt.Font("Roboto Black", 0, 10)); // NOI18N
        CuentaBtn20.setForeground(new java.awt.Color(204, 204, 204));
        CuentaBtn20.setText("Tendencia");
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
        jPanel1.add(CuentaBtn20, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 380, 80, 30));

        TendenciaYapBtn1.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        TendenciaYapBtn1.setForeground(new java.awt.Color(204, 204, 204));
        TendenciaYapBtn1.setText("#0000");
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
        jPanel1.add(TendenciaYapBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 390, 80, 50));

        CuentaBtn23.setFont(new java.awt.Font("Roboto Black", 0, 10)); // NOI18N
        CuentaBtn23.setForeground(new java.awt.Color(204, 204, 204));
        CuentaBtn23.setText("1000 publicaciones");
        CuentaBtn23.setBorder(null);
        CuentaBtn23.setBorderPainted(false);
        CuentaBtn23.setContentAreaFilled(false);
        CuentaBtn23.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CuentaBtn23.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        CuentaBtn23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CuentaBtn23ActionPerformed(evt);
            }
        });
        jPanel1.add(CuentaBtn23, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 410, 100, 50));

        MostrarMasTePuedeInteresarBtn.setFont(new java.awt.Font("Roboto Black", 0, 10)); // NOI18N
        MostrarMasTePuedeInteresarBtn.setForeground(new java.awt.Color(204, 204, 204));
        MostrarMasTePuedeInteresarBtn.setText("Mostrar mas");
        MostrarMasTePuedeInteresarBtn.setBorder(null);
        MostrarMasTePuedeInteresarBtn.setBorderPainted(false);
        MostrarMasTePuedeInteresarBtn.setContentAreaFilled(false);
        MostrarMasTePuedeInteresarBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MostrarMasTePuedeInteresarBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        MostrarMasTePuedeInteresarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MostrarMasTePuedeInteresarBtnActionPerformed(evt);
            }
        });
        jPanel1.add(MostrarMasTePuedeInteresarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 260, 80, 50));

        IdUsuario.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        IdUsuario.setForeground(new java.awt.Color(166, 77, 121));
        IdUsuario.setText("@Usuario");
        jPanel1.add(IdUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 980, -1, -1));

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
        jPanel1.add(UsuarioBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 950, 120, 40));

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
        jPanel1.add(ConfiBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 420, 200, 40));

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
        jPanel1.add(InicioBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, 250, 40));

        ExplorarBtn.setBackground(new java.awt.Color(26, 26, 29));
        ExplorarBtn.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        ExplorarBtn.setForeground(new java.awt.Color(204, 204, 204));
        ExplorarBtn.setText("  Explorar");
        ExplorarBtn.setToolTipText("");
        ExplorarBtn.setAlignmentY(0.0F);
        ExplorarBtn.setBorderPainted(false);
        ExplorarBtn.setContentAreaFilled(false);
        ExplorarBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ExplorarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExplorarBtnActionPerformed(evt);
            }
        });
        jPanel1.add(ExplorarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 250, 40));

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
        jPanel1.add(ComunidadesBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 240, 250, 40));

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
        jPanel1.add(NotificacionesBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, 250, 40));

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
        jPanel1.add(GuardadoBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 300, 250, 40));

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
        jPanel1.add(PerfilBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 360, 260, 40));

        jPanel21.setOpaque(false);
        jPanel21.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel21.add(Y_logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 60, 40));

        jPanel1.add(jPanel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, 70, 50));

        PostearBtn.setBackground(new java.awt.Color(166, 77, 121));
        PostearBtn.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        PostearBtn.setForeground(new java.awt.Color(204, 204, 204));
        PostearBtn.setText("Publicacion");
        PostearBtn.setToolTipText("");
        PostearBtn.setAlignmentY(0.0F);
        PostearBtn.setBorderPainted(false);
        PostearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PostearBtnActionPerformed(evt);
            }
        });
        jPanel1.add(PostearBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 650, 200, 40));

        PerfilPanel.setBackground(new java.awt.Color(0, 0, 0));
        PerfilPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        PerfilPanel.add(Perfil_Img1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 50, 40));

        NombreUsuario.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        NombreUsuario.setForeground(new java.awt.Color(204, 204, 204));
        NombreUsuario.setText("Usuario Ejemplo");
        PerfilPanel.add(NombreUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, -1));

        IdUsuario2.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        IdUsuario2.setForeground(new java.awt.Color(106, 30, 85));
        IdUsuario2.setText("@Usuario1");
        PerfilPanel.add(IdUsuario2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, -1, -1));

        jButton1.setBackground(new java.awt.Color(106, 30, 85));
        jButton1.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(106, 30, 85));
        jButton1.setText("...");
        jButton1.setAlignmentY(0.0F);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        PerfilPanel.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, 50, 40));

        jPanel1.add(PerfilPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 720, 270, 60));
        jPanel1.add(Perfil_Img, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 50, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1550, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 810, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SeguridadYAccesoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeguridadYAccesoBtnActionPerformed
        
    }//GEN-LAST:event_SeguridadYAccesoBtnActionPerformed

    private void CuentaBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CuentaBtn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CuentaBtn1ActionPerformed

    private void UsuarioNot1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsuarioNot1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UsuarioNot1ActionPerformed

    private void FiltroSeguidoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FiltroSeguidoresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FiltroSeguidoresActionPerformed

    private void FiltroYapsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FiltroYapsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FiltroYapsActionPerformed

    private void FiltroTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FiltroTodoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FiltroTodoActionPerformed

    private void SeguridadYAccesoBtn8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeguridadYAccesoBtn8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SeguridadYAccesoBtn8ActionPerformed

    private void IconoNotificacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IconoNotificacionesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IconoNotificacionesActionPerformed

    private void UsuarioNot2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsuarioNot2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UsuarioNot2ActionPerformed

    private void UsuarioNot3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsuarioNot3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UsuarioNot3ActionPerformed

    private void UsuarioNot4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsuarioNot4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UsuarioNot4ActionPerformed

    private void UsuarioNot5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsuarioNot5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UsuarioNot5ActionPerformed

    private void UsuarioNot6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsuarioNot6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UsuarioNot6ActionPerformed

    private void CuentaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CuentaBtnActionPerformed

    }//GEN-LAST:event_CuentaBtnActionPerformed

    private void CuentaBtn7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CuentaBtn7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CuentaBtn7ActionPerformed

    private void CuentaBtn13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CuentaBtn13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CuentaBtn13ActionPerformed

    private void CuentaBtn14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CuentaBtn14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CuentaBtn14ActionPerformed

    private void CuentaBtn15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CuentaBtn15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CuentaBtn15ActionPerformed

    private void CuentaBtn16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CuentaBtn16ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CuentaBtn16ActionPerformed

    private void CuentaBtn17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CuentaBtn17ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CuentaBtn17ActionPerformed

    private void CuentaBtn6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CuentaBtn6ActionPerformed
        // TODO add your handling code here:coment
        //ola
    }//GEN-LAST:event_CuentaBtn6ActionPerformed

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

    private void CuentaBtn23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CuentaBtn23ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CuentaBtn23ActionPerformed

    private void MostrarMasTePuedeInteresarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MostrarMasTePuedeInteresarBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MostrarMasTePuedeInteresarBtnActionPerformed

    private void UsuarioBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsuarioBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UsuarioBtnActionPerformed

    private void ConfiBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfiBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ConfiBtnActionPerformed

    private void InicioBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InicioBtn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InicioBtn1ActionPerformed

    private void ExplorarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExplorarBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ExplorarBtnActionPerformed

    private void ComunidadesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComunidadesBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComunidadesBtnActionPerformed

    private void NotificacionesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NotificacionesBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NotificacionesBtnActionPerformed

    private void GuardadoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardadoBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GuardadoBtnActionPerformed

    private void PerfilBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PerfilBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PerfilBtnActionPerformed

    private void PostearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PostearBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PostearBtnActionPerformed

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
    private javax.swing.JButton ComunidadesBtn;
    private javax.swing.JButton ConfiBtn;
    private javax.swing.JButton CuentaBtn;
    private javax.swing.JButton CuentaBtn1;
    private javax.swing.JButton CuentaBtn13;
    private javax.swing.JButton CuentaBtn14;
    private javax.swing.JButton CuentaBtn15;
    private javax.swing.JButton CuentaBtn16;
    private javax.swing.JButton CuentaBtn17;
    private javax.swing.JButton CuentaBtn20;
    private javax.swing.JButton CuentaBtn23;
    private javax.swing.JButton CuentaBtn6;
    private javax.swing.JButton CuentaBtn7;
    private javax.swing.JLabel DecripcionNot5;
    private javax.swing.JLabel DescripcionNot1;
    private javax.swing.JLabel DescripcionNot2;
    private javax.swing.JLabel DescripcionNot3;
    private javax.swing.JLabel DescripcionNot4;
    private javax.swing.JLabel DescripcionNot6;
    private javax.swing.JButton ExplorarBtn;
    private javax.swing.JButton FiltroSeguidores;
    private javax.swing.JButton FiltroTodo;
    private javax.swing.JButton FiltroYaps;
    private javax.swing.JButton GuardadoBtn;
    private javax.swing.JButton IconoNotificaciones;
    private javax.swing.JLabel IdUsuario;
    private javax.swing.JLabel IdUsuario2;
    private javax.swing.JButton InicioBtn1;
    private javax.swing.JButton MostrarMasTePuedeInteresarBtn;
    private javax.swing.JButton MostrarMasTendenciaBtn;
    private javax.swing.JLabel NombreNot1;
    private javax.swing.JLabel NombreNot2;
    private javax.swing.JLabel NombreNot3;
    private javax.swing.JLabel NombreNot4;
    private javax.swing.JLabel NombreNot5;
    private javax.swing.JLabel NombreNot6;
    private javax.swing.JLabel NombreUsuario;
    private javax.swing.JButton NotificacionesBtn;
    private javax.swing.JButton PerfilBtn;
    private javax.swing.JPanel PerfilPanel;
    private javax.swing.JLabel Perfil_Img;
    private javax.swing.JLabel Perfil_Img1;
    private javax.swing.JButton PostearBtn;
    private javax.swing.JLabel Seccion;
    private javax.swing.JButton SeguirCuentaBtn13;
    private javax.swing.JButton SeguirCuentaBtn15;
    private javax.swing.JButton SeguridadYAccesoBtn;
    private javax.swing.JButton SeguridadYAccesoBtn8;
    private javax.swing.JButton TendenciaYapBtn1;
    private javax.swing.JButton TendenciaYapBtn2;
    private javax.swing.JButton UsuarioBtn;
    private javax.swing.JButton UsuarioNot1;
    private javax.swing.JButton UsuarioNot2;
    private javax.swing.JButton UsuarioNot3;
    private javax.swing.JButton UsuarioNot4;
    private javax.swing.JButton UsuarioNot5;
    private javax.swing.JButton UsuarioNot6;
    private javax.swing.JLabel Y_logo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    // End of variables declaration//GEN-END:variables
}
