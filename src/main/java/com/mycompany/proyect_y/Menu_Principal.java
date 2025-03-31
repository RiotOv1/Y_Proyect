
package com.mycompany.proyect_y;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Menu_Principal extends javax.swing.JFrame {

    public Menu_Principal() {
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
        InicioBtn2.setIcon(Icono1);
        
        String url15 = "src\\main\\java\\Multimedia\\Icon-Inicio.png";
        ImageIcon image15 = new ImageIcon(url15);
        Image img15 = image15.getImage().getScaledInstance(32, 32, 0);
        ImageIcon Icono15 = new ImageIcon(img15);
        IconoParaTi.setIcon(Icono15);

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
        jPanel2 = new javax.swing.JPanel();
        FiltroSeguidores = new javax.swing.JButton();
        FiltroYaps = new javax.swing.JButton();
        SeguridadYAccesoBtn = new javax.swing.JButton();
        FiltroTodo = new javax.swing.JButton();
        PanelNot4 = new javax.swing.JPanel();
        UsuarioPub4 = new javax.swing.JButton();
        NombrePub4 = new javax.swing.JLabel();
        DescripcionPub4 = new javax.swing.JLabel();
        ImgPub4 = new javax.swing.JLabel();
        PanelNot2 = new javax.swing.JPanel();
        UsuarioPub2 = new javax.swing.JButton();
        NombrePub2 = new javax.swing.JLabel();
        DescripcionPub2 = new javax.swing.JLabel();
        ImgPub2 = new javax.swing.JLabel();
        PanelNot1 = new javax.swing.JPanel();
        UsuarioPub1 = new javax.swing.JButton();
        NombrePub1 = new javax.swing.JLabel();
        DescripcionPub1 = new javax.swing.JLabel();
        ImgPub1 = new javax.swing.JLabel();
        PanelNot3 = new javax.swing.JPanel();
        UsuarioPub3 = new javax.swing.JButton();
        NombrePub3 = new javax.swing.JLabel();
        DescripcionPub3 = new javax.swing.JLabel();
        ImgPub3 = new javax.swing.JLabel();
        ConfiBtn = new javax.swing.JButton();
        InicioBtn1 = new javax.swing.JButton();
        ExplorarBtn = new javax.swing.JButton();
        ComunidadesBtn = new javax.swing.JButton();
        NotificacionesBtn = new javax.swing.JButton();
        GuardadoBtn = new javax.swing.JButton();
        PerfilBtn = new javax.swing.JButton();
        jPanel21 = new javax.swing.JPanel();
        Y_logo = new javax.swing.JLabel();
        PerfilPanel = new javax.swing.JPanel();
        NombreUsuario = new javax.swing.JLabel();
        IdUsuario2 = new javax.swing.JLabel();
        Perfil_Img = new javax.swing.JLabel();
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        PostearBtn = new javax.swing.JButton();
        InicioBtn2 = new javax.swing.JButton();
        IconoParaTi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setMinimumSize(new java.awt.Dimension(1550, 820));
        jPanel1.setPreferredSize(new java.awt.Dimension(1550, 820));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator1.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator1.setForeground(new java.awt.Color(153, 153, 153));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(427, 0, -1, 1040));

        jSeparator4.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator4.setForeground(new java.awt.Color(153, 153, 153));
        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 0, 10, 1040));

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

        SeguridadYAccesoBtn.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        SeguridadYAccesoBtn.setForeground(new java.awt.Color(204, 204, 204));
        SeguridadYAccesoBtn.setText("Te Yusta");
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
                .addGap(130, 130, 130)
                .addComponent(FiltroSeguidores)
                .addGap(132, 132, 132)
                .addComponent(FiltroYaps, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
                .addComponent(SeguridadYAccesoBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FiltroSeguidores, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FiltroYaps, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FiltroTodo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SeguridadYAccesoBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 90, 750, 40));

        PanelNot4.setBackground(new java.awt.Color(59, 28, 50));
        PanelNot4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        PanelNot4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        UsuarioPub4.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        UsuarioPub4.setForeground(new java.awt.Color(204, 204, 204));
        UsuarioPub4.setText("@Usuario");
        UsuarioPub4.setToolTipText("");
        UsuarioPub4.setBorder(null);
        UsuarioPub4.setBorderPainted(false);
        UsuarioPub4.setContentAreaFilled(false);
        UsuarioPub4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        UsuarioPub4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        UsuarioPub4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsuarioPub4ActionPerformed(evt);
            }
        });

        NombrePub4.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        NombrePub4.setForeground(new java.awt.Color(204, 204, 204));
        NombrePub4.setText("Usuario");

        DescripcionPub4.setFont(new java.awt.Font("Roboto Black", 0, 12)); // NOI18N
        DescripcionPub4.setForeground(new java.awt.Color(204, 204, 204));
        DescripcionPub4.setText("Descripcion...");

        ImgPub4.setForeground(new java.awt.Color(255, 255, 255));
        ImgPub4.setText("ImgNot");

        javax.swing.GroupLayout PanelNot4Layout = new javax.swing.GroupLayout(PanelNot4);
        PanelNot4.setLayout(PanelNot4Layout);
        PanelNot4Layout.setHorizontalGroup(
            PanelNot4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelNot4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelNot4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DescripcionPub4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(PanelNot4Layout.createSequentialGroup()
                        .addComponent(ImgPub4, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(NombrePub4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(UsuarioPub4)
                        .addGap(0, 230, Short.MAX_VALUE)))
                .addContainerGap())
        );
        PanelNot4Layout.setVerticalGroup(
            PanelNot4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelNot4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelNot4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ImgPub4, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NombrePub4)
                    .addComponent(UsuarioPub4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DescripcionPub4, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(PanelNot4, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 650, 450, 150));

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

        jPanel1.add(PanelNot2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 310, 450, 150));

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

        jPanel1.add(PanelNot1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 140, 450, 150));

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

        jPanel1.add(PanelNot3, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 480, 450, 150));

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
        jPanel1.add(ConfiBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 420, 250, 40));

        InicioBtn1.setBackground(new java.awt.Color(26, 26, 29));
        InicioBtn1.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        InicioBtn1.setForeground(new java.awt.Color(204, 204, 204));
        InicioBtn1.setText("Para tí");
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
        jPanel1.add(InicioBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 30, 250, 40));

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
        jPanel1.add(NotificacionesBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 250, 40));

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
        PerfilPanel.add(Perfil_Img, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 50, 40));

        jPanel1.add(PerfilPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 720, 270, 60));

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
        jPanel1.add(PublicacionesBtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 560, 100, 30));

        QuePasa.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        QuePasa.setForeground(new java.awt.Color(204, 204, 204));
        QuePasa.setText("Qué pasa");
        jPanel1.add(QuePasa, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 370, 210, 30));

        SeguirCuentaBtn3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        SeguirCuentaBtn3.setText("Seguir");
        jPanel1.add(SeguirCuentaBtn3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1400, 230, -1, 30));

        SeguirCuentaBtn1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        SeguirCuentaBtn1.setText("Seguir");
        jPanel1.add(SeguirCuentaBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1400, 130, -1, 30));

        SeguirCuentaBtn2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        SeguirCuentaBtn2.setText("Seguir");
        jPanel1.add(SeguirCuentaBtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1400, 180, -1, 30));

        jSeparator6.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator6.setForeground(new java.awt.Color(153, 153, 153));
        jSeparator6.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 80, 30, 220));

        jSeparator7.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator7.setForeground(new java.awt.Color(153, 153, 153));
        jSeparator7.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1490, 80, 20, 220));
        jPanel1.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 300, 280, 20));
        jPanel1.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 80, 280, 10));

        jLabel40.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(204, 204, 204));
        jLabel40.setText("Te puede interesar");
        jPanel1.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 80, 210, 30));

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
        jPanel1.add(TendenciaYapBtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 490, 130, 50));

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
        jPanel1.add(MostrarMasTendenciaBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 580, 80, 50));

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
        jPanel1.add(CuentaBtn20, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 390, 80, 30));

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
        jPanel1.add(TendenciaYapBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 410, 130, 50));

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
        jPanel1.add(PublicacionesBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 460, 100, 50));

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
        jPanel1.add(MostrarMasInteresBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 260, 80, 50));

        ImgInt3.setForeground(new java.awt.Color(255, 255, 255));
        ImgInt3.setText("ImgInteres2");
        jPanel1.add(ImgInt3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 220, 60, 50));

        ImgInt1.setForeground(new java.awt.Color(255, 255, 255));
        ImgInt1.setText("ImgInteres1");
        jPanel1.add(ImgInt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 120, 60, 50));

        ImgInt2.setForeground(new java.awt.Color(255, 255, 255));
        ImgInt2.setText("ImgInteres2");
        jPanel1.add(ImgInt2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 170, 60, 50));

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
        jPanel1.add(UserInt3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 230, -1, 30));

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
        jPanel1.add(UserInt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 130, -1, 30));

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
        jPanel1.add(UserInt2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 180, -1, 30));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ImagenPublicacion4");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 650, 280, 150));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ImagenPublicacion1");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 140, 280, 150));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("ImagenPublicacion2");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 310, 280, 150));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("ImagenPublicacion3");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 480, 280, 150));

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
        jPanel1.add(PostearBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 680, 200, 40));

        InicioBtn2.setBackground(new java.awt.Color(26, 26, 29));
        InicioBtn2.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        InicioBtn2.setForeground(new java.awt.Color(204, 204, 204));
        InicioBtn2.setText("   Inicio");
        InicioBtn2.setToolTipText("");
        InicioBtn2.setAlignmentY(0.0F);
        InicioBtn2.setBorderPainted(false);
        InicioBtn2.setContentAreaFilled(false);
        InicioBtn2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        InicioBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InicioBtn2ActionPerformed(evt);
            }
        });
        jPanel1.add(InicioBtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 250, 40));

        IconoParaTi.setBackground(new java.awt.Color(166, 77, 121));
        IconoParaTi.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        IconoParaTi.setForeground(new java.awt.Color(204, 204, 204));
        IconoParaTi.setToolTipText("");
        IconoParaTi.setAlignmentY(0.0F);
        IconoParaTi.setBorderPainted(false);
        IconoParaTi.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        IconoParaTi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IconoParaTiActionPerformed(evt);
            }
        });
        jPanel1.add(IconoParaTi, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 20, 60, 60));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 12, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1550, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 820, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void FiltroSeguidoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FiltroSeguidoresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FiltroSeguidoresActionPerformed

    private void FiltroYapsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FiltroYapsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FiltroYapsActionPerformed

    private void SeguridadYAccesoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeguridadYAccesoBtnActionPerformed

    }//GEN-LAST:event_SeguridadYAccesoBtnActionPerformed

    private void FiltroTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FiltroTodoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FiltroTodoActionPerformed

    private void UsuarioPub4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsuarioPub4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UsuarioPub4ActionPerformed

    private void UsuarioPub2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsuarioPub2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UsuarioPub2ActionPerformed

    private void UsuarioPub1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsuarioPub1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UsuarioPub1ActionPerformed

    private void UsuarioPub3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsuarioPub3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UsuarioPub3ActionPerformed

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

    private void InicioBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InicioBtn2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InicioBtn2ActionPerformed

    private void IconoParaTiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IconoParaTiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IconoParaTiActionPerformed

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
            java.util.logging.Logger.getLogger(Menu_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu_Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ComunidadesBtn;
    private javax.swing.JButton ConfiBtn;
    private javax.swing.JButton CuentaBtn20;
    private javax.swing.JLabel DescripcionPub1;
    private javax.swing.JLabel DescripcionPub2;
    private javax.swing.JLabel DescripcionPub3;
    private javax.swing.JLabel DescripcionPub4;
    private javax.swing.JButton ExplorarBtn;
    private javax.swing.JButton FiltroSeguidores;
    private javax.swing.JButton FiltroTodo;
    private javax.swing.JButton FiltroYaps;
    private javax.swing.JButton GuardadoBtn;
    private javax.swing.JButton IconoParaTi;
    private javax.swing.JLabel IdUsuario2;
    private javax.swing.JLabel ImgInt1;
    private javax.swing.JLabel ImgInt2;
    private javax.swing.JLabel ImgInt3;
    private javax.swing.JLabel ImgPub1;
    private javax.swing.JLabel ImgPub2;
    private javax.swing.JLabel ImgPub3;
    private javax.swing.JLabel ImgPub4;
    private javax.swing.JButton InicioBtn1;
    private javax.swing.JButton InicioBtn2;
    private javax.swing.JButton MostrarMasInteresBtn;
    private javax.swing.JButton MostrarMasTendenciaBtn;
    private javax.swing.JLabel NombrePub1;
    private javax.swing.JLabel NombrePub2;
    private javax.swing.JLabel NombrePub3;
    private javax.swing.JLabel NombrePub4;
    private javax.swing.JLabel NombreUsuario;
    private javax.swing.JButton NotificacionesBtn;
    private javax.swing.JPanel PanelNot1;
    private javax.swing.JPanel PanelNot2;
    private javax.swing.JPanel PanelNot3;
    private javax.swing.JPanel PanelNot4;
    private javax.swing.JButton PerfilBtn;
    private javax.swing.JPanel PerfilPanel;
    private javax.swing.JLabel Perfil_Img;
    private javax.swing.JButton PostearBtn;
    private javax.swing.JButton PublicacionesBtn1;
    private javax.swing.JButton PublicacionesBtn2;
    private javax.swing.JLabel QuePasa;
    private javax.swing.JButton SeguirCuentaBtn1;
    private javax.swing.JButton SeguirCuentaBtn2;
    private javax.swing.JButton SeguirCuentaBtn3;
    private javax.swing.JButton SeguridadYAccesoBtn;
    private javax.swing.JButton TendenciaYapBtn1;
    private javax.swing.JButton TendenciaYapBtn2;
    private javax.swing.JButton UserInt1;
    private javax.swing.JButton UserInt2;
    private javax.swing.JButton UserInt3;
    private javax.swing.JButton UsuarioPub1;
    private javax.swing.JButton UsuarioPub2;
    private javax.swing.JButton UsuarioPub3;
    private javax.swing.JButton UsuarioPub4;
    private javax.swing.JLabel Y_logo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    // End of variables declaration//GEN-END:variables
}
