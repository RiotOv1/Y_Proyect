
package com.mycompany.proyect_y;

import java.awt.Image;
import javax.swing.ImageIcon;


public class Comunidad extends javax.swing.JFrame {

    public Comunidad() {
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

        PanelTotalComunidad = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        BarraBusquedaBtn = new javax.swing.JButton();
        SeguirComunidadBtn = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        FiltrarReYaps = new javax.swing.JButton();
        FiltrarDestacados = new javax.swing.JButton();
        FiltrarMultimedia = new javax.swing.JButton();
        SeguridadYAccesoBtn8 = new javax.swing.JButton();
        SeguridadYAccesoBtn = new javax.swing.JButton();
        FiltrarYaps = new javax.swing.JButton();
        FiltrarEventos = new javax.swing.JButton();
        FiltrarSeguidores = new javax.swing.JButton();
        PortadaPanel = new javax.swing.JPanel();
        SeguidoresBtn = new javax.swing.JButton();
        NoSeguidoresBtn = new javax.swing.JButton();
        CuentaBtn1 = new javax.swing.JButton();
        FotodeComunidadBtn = new javax.swing.JButton();
        EjemploYap1 = new javax.swing.JPanel();
        UsuarioYap1 = new javax.swing.JButton();
        jLabel42 = new javax.swing.JLabel();
        TiempoYap1 = new javax.swing.JButton();
        ContadorYaps1 = new javax.swing.JButton();
        FotodeComunidadBtn2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        CuentaBtn26 = new javax.swing.JButton();
        DescripcionYap1 = new javax.swing.JButton();
        ContadorReYaps1 = new javax.swing.JButton();
        ContadorYustas1 = new javax.swing.JButton();
        ContadorRep1 = new javax.swing.JButton();
        UsuarioComunidad = new javax.swing.JButton();
        NombreComunidad = new javax.swing.JLabel();
        YapsBtn = new javax.swing.JButton();
        ContadorYaps = new javax.swing.JButton();
        DescripcionComunidadBtn = new javax.swing.JButton();
        EjemploYap2 = new javax.swing.JPanel();
        UsuarioYap2 = new javax.swing.JButton();
        jLabel44 = new javax.swing.JLabel();
        TiempoYap2 = new javax.swing.JButton();
        ContadorYaps2 = new javax.swing.JButton();
        FotodeComunidadBtn3 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        CuentaBtn29 = new javax.swing.JButton();
        DecripcionYap2 = new javax.swing.JButton();
        ContadorReYaps2 = new javax.swing.JButton();
        ContadorYustas2 = new javax.swing.JButton();
        ContadorRep2 = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        SiguientePagBtn = new javax.swing.JButton();
        ConfiBtn = new javax.swing.JButton();
        InicioBtn1 = new javax.swing.JButton();
        ExplorarBtn = new javax.swing.JButton();
        ComunidadesBtn = new javax.swing.JButton();
        NotificacionesBtn = new javax.swing.JButton();
        GuardadoBtn = new javax.swing.JButton();
        PerfilBtn = new javax.swing.JButton();
        jPanel21 = new javax.swing.JPanel();
        Y_logo = new javax.swing.JLabel();
        Perfil_Img = new javax.swing.JLabel();
        PostearBtn = new javax.swing.JButton();
        PerfilPanel = new javax.swing.JPanel();
        Perfil_Img1 = new javax.swing.JLabel();
        NombreUsuario = new javax.swing.JLabel();
        IdUsuario = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));

        PanelTotalComunidad.setBackground(new java.awt.Color(0, 0, 0));
        PanelTotalComunidad.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator1.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator1.setForeground(new java.awt.Color(153, 153, 153));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        PanelTotalComunidad.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(427, 0, -1, 1040));

        jSeparator4.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator4.setForeground(new java.awt.Color(153, 153, 153));
        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);
        PanelTotalComunidad.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 0, 10, 1040));

        BarraBusquedaBtn.setBackground(new java.awt.Color(0, 0, 0));
        BarraBusquedaBtn.setForeground(new java.awt.Color(255, 255, 255));
        BarraBusquedaBtn.setText("🔍Buscar");
        BarraBusquedaBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        PanelTotalComunidad.add(BarraBusquedaBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 180, 110, 30));

        SeguirComunidadBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        SeguirComunidadBtn.setText("Seguir");
        PanelTotalComunidad.add(SeguirComunidadBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 140, -1, -1));

        jSeparator5.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator5.setForeground(new java.awt.Color(153, 153, 153));
        jSeparator5.setOrientation(javax.swing.SwingConstants.VERTICAL);
        PanelTotalComunidad.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 0, 10, 1040));

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
                .addContainerGap()
                .addComponent(FiltrarYaps)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(FiltrarReYaps, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(FiltrarDestacados)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(FiltrarMultimedia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(FiltrarEventos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(FiltrarSeguidores)
                .addGap(40, 40, 40)
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
                    .addComponent(FiltrarReYaps, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FiltrarDestacados, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FiltrarMultimedia, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SeguridadYAccesoBtn8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SeguridadYAccesoBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FiltrarYaps, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FiltrarEventos, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FiltrarSeguidores, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        PanelTotalComunidad.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 220, 490, 40));

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

        javax.swing.GroupLayout PortadaPanelLayout = new javax.swing.GroupLayout(PortadaPanel);
        PortadaPanel.setLayout(PortadaPanelLayout);
        PortadaPanelLayout.setHorizontalGroup(
            PortadaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PortadaPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(FotodeComunidadBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(PortadaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PortadaPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(NoSeguidoresBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SeguidoresBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(PortadaPanelLayout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(CuentaBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(181, Short.MAX_VALUE))))
        );
        PortadaPanelLayout.setVerticalGroup(
            PortadaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PortadaPanelLayout.createSequentialGroup()
                .addGroup(PortadaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PortadaPanelLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(CuentaBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addGroup(PortadaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SeguidoresBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NoSeguidoresBtn)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PortadaPanelLayout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(FotodeComunidadBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PanelTotalComunidad.add(PortadaPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 0, 490, 130));

        EjemploYap1.setBackground(new java.awt.Color(102, 102, 102));
        EjemploYap1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        EjemploYap1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        UsuarioYap1.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        UsuarioYap1.setForeground(new java.awt.Color(204, 204, 204));
        UsuarioYap1.setText("@Usuario");
        UsuarioYap1.setBorder(null);
        UsuarioYap1.setBorderPainted(false);
        UsuarioYap1.setContentAreaFilled(false);
        UsuarioYap1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        UsuarioYap1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        UsuarioYap1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsuarioYap1ActionPerformed(evt);
            }
        });

        jLabel42.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(204, 204, 204));
        jLabel42.setText("Usuario");

        TiempoYap1.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        TiempoYap1.setForeground(new java.awt.Color(204, 204, 204));
        TiempoYap1.setText("0h");
        TiempoYap1.setBorder(null);
        TiempoYap1.setBorderPainted(false);
        TiempoYap1.setContentAreaFilled(false);
        TiempoYap1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TiempoYap1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        TiempoYap1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TiempoYap1ActionPerformed(evt);
            }
        });

        ContadorYaps1.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        ContadorYaps1.setForeground(new java.awt.Color(204, 204, 204));
        ContadorYaps1.setText("Yap's 0");
        ContadorYaps1.setBorder(null);
        ContadorYaps1.setBorderPainted(false);
        ContadorYaps1.setContentAreaFilled(false);
        ContadorYaps1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ContadorYaps1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        ContadorYaps1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContadorYaps1ActionPerformed(evt);
            }
        });

        FotodeComunidadBtn2.setBackground(new java.awt.Color(166, 77, 121));
        FotodeComunidadBtn2.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        FotodeComunidadBtn2.setForeground(new java.awt.Color(204, 204, 204));
        FotodeComunidadBtn2.setToolTipText("");
        FotodeComunidadBtn2.setAlignmentY(0.0F);
        FotodeComunidadBtn2.setBorderPainted(false);
        FotodeComunidadBtn2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        FotodeComunidadBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FotodeComunidadBtn2ActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(106, 30, 85));
        jPanel3.setToolTipText("");
        jPanel3.setName(""); // NOI18N

        CuentaBtn26.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        CuentaBtn26.setForeground(new java.awt.Color(204, 204, 204));
        CuentaBtn26.setText("<Multimedia>");
        CuentaBtn26.setBorder(null);
        CuentaBtn26.setBorderPainted(false);
        CuentaBtn26.setContentAreaFilled(false);
        CuentaBtn26.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CuentaBtn26.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        CuentaBtn26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CuentaBtn26ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addComponent(CuentaBtn26, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(150, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(CuentaBtn26, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(68, Short.MAX_VALUE))
        );

        DescripcionYap1.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        DescripcionYap1.setForeground(new java.awt.Color(204, 204, 204));
        DescripcionYap1.setText("Descripcion...");
        DescripcionYap1.setBorder(null);
        DescripcionYap1.setBorderPainted(false);
        DescripcionYap1.setContentAreaFilled(false);
        DescripcionYap1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DescripcionYap1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        DescripcionYap1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DescripcionYap1ActionPerformed(evt);
            }
        });

        ContadorReYaps1.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        ContadorReYaps1.setForeground(new java.awt.Color(204, 204, 204));
        ContadorReYaps1.setText("Re- Yap's 0");
        ContadorReYaps1.setBorder(null);
        ContadorReYaps1.setBorderPainted(false);
        ContadorReYaps1.setContentAreaFilled(false);
        ContadorReYaps1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ContadorReYaps1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        ContadorReYaps1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContadorReYaps1ActionPerformed(evt);
            }
        });

        ContadorYustas1.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        ContadorYustas1.setForeground(new java.awt.Color(204, 204, 204));
        ContadorYustas1.setText("Yusta's 0");
        ContadorYustas1.setBorder(null);
        ContadorYustas1.setBorderPainted(false);
        ContadorYustas1.setContentAreaFilled(false);
        ContadorYustas1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ContadorYustas1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        ContadorYustas1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContadorYustas1ActionPerformed(evt);
            }
        });

        ContadorRep1.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        ContadorRep1.setForeground(new java.awt.Color(204, 204, 204));
        ContadorRep1.setText("Reproducciones 0");
        ContadorRep1.setBorder(null);
        ContadorRep1.setBorderPainted(false);
        ContadorRep1.setContentAreaFilled(false);
        ContadorRep1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ContadorRep1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        ContadorRep1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContadorRep1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout EjemploYap1Layout = new javax.swing.GroupLayout(EjemploYap1);
        EjemploYap1.setLayout(EjemploYap1Layout);
        EjemploYap1Layout.setHorizontalGroup(
            EjemploYap1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EjemploYap1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(FotodeComunidadBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(EjemploYap1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(EjemploYap1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(ContadorYaps1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ContadorReYaps1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ContadorYustas1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ContadorRep1))
                    .addGroup(EjemploYap1Layout.createSequentialGroup()
                        .addComponent(jLabel42)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(UsuarioYap1)
                        .addGap(18, 18, 18)
                        .addComponent(TiempoYap1))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
            .addGroup(EjemploYap1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(EjemploYap1Layout.createSequentialGroup()
                    .addGap(74, 74, 74)
                    .addComponent(DescripcionYap1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(282, Short.MAX_VALUE)))
        );
        EjemploYap1Layout.setVerticalGroup(
            EjemploYap1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EjemploYap1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(EjemploYap1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(EjemploYap1Layout.createSequentialGroup()
                        .addGroup(EjemploYap1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(UsuarioYap1)
                            .addComponent(TiempoYap1))
                        .addGap(36, 36, 36))
                    .addGroup(EjemploYap1Layout.createSequentialGroup()
                        .addComponent(FotodeComunidadBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(EjemploYap1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ContadorYaps1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ContadorReYaps1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ContadorYustas1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ContadorRep1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11))
            .addGroup(EjemploYap1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(EjemploYap1Layout.createSequentialGroup()
                    .addGap(41, 41, 41)
                    .addComponent(DescripcionYap1)
                    .addContainerGap(168, Short.MAX_VALUE)))
        );

        PanelTotalComunidad.add(EjemploYap1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 270, 470, 230));

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
        PanelTotalComunidad.add(UsuarioComunidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 140, -1, -1));

        NombreComunidad.setFont(new java.awt.Font("Roboto Black", 1, 22)); // NOI18N
        NombreComunidad.setForeground(new java.awt.Color(204, 204, 204));
        NombreComunidad.setText("Comunidad");
        PanelTotalComunidad.add(NombreComunidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 140, -1, 19));

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
        PanelTotalComunidad.add(YapsBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 180, 60, 50));

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
        PanelTotalComunidad.add(ContadorYaps, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 190, 50, 30));

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
        PanelTotalComunidad.add(DescripcionComunidadBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 170, 130, 20));

        EjemploYap2.setBackground(new java.awt.Color(102, 102, 102));
        EjemploYap2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        EjemploYap2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        EjemploYap2.setPreferredSize(new java.awt.Dimension(470, 240));

        UsuarioYap2.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        UsuarioYap2.setForeground(new java.awt.Color(204, 204, 204));
        UsuarioYap2.setText("@Usuario");
        UsuarioYap2.setBorder(null);
        UsuarioYap2.setBorderPainted(false);
        UsuarioYap2.setContentAreaFilled(false);
        UsuarioYap2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        UsuarioYap2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        UsuarioYap2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsuarioYap2ActionPerformed(evt);
            }
        });

        jLabel44.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(204, 204, 204));
        jLabel44.setText("Usuario");

        TiempoYap2.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        TiempoYap2.setForeground(new java.awt.Color(204, 204, 204));
        TiempoYap2.setText("0h");
        TiempoYap2.setBorder(null);
        TiempoYap2.setBorderPainted(false);
        TiempoYap2.setContentAreaFilled(false);
        TiempoYap2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TiempoYap2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        TiempoYap2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TiempoYap2ActionPerformed(evt);
            }
        });

        ContadorYaps2.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        ContadorYaps2.setForeground(new java.awt.Color(204, 204, 204));
        ContadorYaps2.setText("Yap's 0");
        ContadorYaps2.setBorder(null);
        ContadorYaps2.setBorderPainted(false);
        ContadorYaps2.setContentAreaFilled(false);
        ContadorYaps2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ContadorYaps2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        ContadorYaps2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContadorYaps2ActionPerformed(evt);
            }
        });

        FotodeComunidadBtn3.setBackground(new java.awt.Color(166, 77, 121));
        FotodeComunidadBtn3.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        FotodeComunidadBtn3.setForeground(new java.awt.Color(204, 204, 204));
        FotodeComunidadBtn3.setToolTipText("");
        FotodeComunidadBtn3.setAlignmentY(0.0F);
        FotodeComunidadBtn3.setBorderPainted(false);
        FotodeComunidadBtn3.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        FotodeComunidadBtn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FotodeComunidadBtn3ActionPerformed(evt);
            }
        });

        jPanel7.setBackground(new java.awt.Color(106, 30, 85));
        jPanel7.setToolTipText("");
        jPanel7.setName(""); // NOI18N

        CuentaBtn29.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        CuentaBtn29.setForeground(new java.awt.Color(204, 204, 204));
        CuentaBtn29.setText("<Multimedia>");
        CuentaBtn29.setBorder(null);
        CuentaBtn29.setBorderPainted(false);
        CuentaBtn29.setContentAreaFilled(false);
        CuentaBtn29.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CuentaBtn29.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        CuentaBtn29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CuentaBtn29ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addComponent(CuentaBtn29, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(150, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(CuentaBtn29, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(68, Short.MAX_VALUE))
        );

        DecripcionYap2.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        DecripcionYap2.setForeground(new java.awt.Color(204, 204, 204));
        DecripcionYap2.setText("Descripcion...");
        DecripcionYap2.setBorder(null);
        DecripcionYap2.setBorderPainted(false);
        DecripcionYap2.setContentAreaFilled(false);
        DecripcionYap2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DecripcionYap2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        DecripcionYap2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DecripcionYap2ActionPerformed(evt);
            }
        });

        ContadorReYaps2.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        ContadorReYaps2.setForeground(new java.awt.Color(204, 204, 204));
        ContadorReYaps2.setText("Re- Yap's 0");
        ContadorReYaps2.setBorder(null);
        ContadorReYaps2.setBorderPainted(false);
        ContadorReYaps2.setContentAreaFilled(false);
        ContadorReYaps2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ContadorReYaps2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        ContadorReYaps2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContadorReYaps2ActionPerformed(evt);
            }
        });

        ContadorYustas2.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        ContadorYustas2.setForeground(new java.awt.Color(204, 204, 204));
        ContadorYustas2.setText("Yusta's 0");
        ContadorYustas2.setBorder(null);
        ContadorYustas2.setBorderPainted(false);
        ContadorYustas2.setContentAreaFilled(false);
        ContadorYustas2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ContadorYustas2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        ContadorYustas2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContadorYustas2ActionPerformed(evt);
            }
        });

        ContadorRep2.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        ContadorRep2.setForeground(new java.awt.Color(204, 204, 204));
        ContadorRep2.setText("Reproducciones 0");
        ContadorRep2.setBorder(null);
        ContadorRep2.setBorderPainted(false);
        ContadorRep2.setContentAreaFilled(false);
        ContadorRep2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ContadorRep2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        ContadorRep2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContadorRep2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout EjemploYap2Layout = new javax.swing.GroupLayout(EjemploYap2);
        EjemploYap2.setLayout(EjemploYap2Layout);
        EjemploYap2Layout.setHorizontalGroup(
            EjemploYap2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EjemploYap2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(FotodeComunidadBtn3, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(EjemploYap2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(EjemploYap2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(ContadorYaps2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ContadorReYaps2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ContadorYustas2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ContadorRep2))
                    .addGroup(EjemploYap2Layout.createSequentialGroup()
                        .addComponent(jLabel44)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(UsuarioYap2)
                        .addGap(18, 18, 18)
                        .addComponent(TiempoYap2))
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
            .addGroup(EjemploYap2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(EjemploYap2Layout.createSequentialGroup()
                    .addGap(74, 74, 74)
                    .addComponent(DecripcionYap2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(282, Short.MAX_VALUE)))
        );
        EjemploYap2Layout.setVerticalGroup(
            EjemploYap2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EjemploYap2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(EjemploYap2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(EjemploYap2Layout.createSequentialGroup()
                        .addGroup(EjemploYap2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(UsuarioYap2)
                            .addComponent(TiempoYap2))
                        .addGap(36, 36, 36))
                    .addGroup(EjemploYap2Layout.createSequentialGroup()
                        .addComponent(FotodeComunidadBtn3, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(EjemploYap2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ContadorYaps2, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ContadorReYaps2, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ContadorYustas2, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ContadorRep2, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11))
            .addGroup(EjemploYap2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(EjemploYap2Layout.createSequentialGroup()
                    .addGap(41, 41, 41)
                    .addComponent(DecripcionYap2)
                    .addContainerGap(188, Short.MAX_VALUE)))
        );

        PanelTotalComunidad.add(EjemploYap2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 520, -1, 250));
        PanelTotalComunidad.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 510, 470, 30));

        SiguientePagBtn.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        SiguientePagBtn.setForeground(new java.awt.Color(204, 204, 204));
        SiguientePagBtn.setText("Siguiente");
        SiguientePagBtn.setBorder(null);
        SiguientePagBtn.setBorderPainted(false);
        SiguientePagBtn.setContentAreaFilled(false);
        SiguientePagBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SiguientePagBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        SiguientePagBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SiguientePagBtnActionPerformed(evt);
            }
        });
        PanelTotalComunidad.add(SiguientePagBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 770, 80, 30));

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
        PanelTotalComunidad.add(ConfiBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 420, 250, 40));

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
        PanelTotalComunidad.add(InicioBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, 250, 40));

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
        PanelTotalComunidad.add(ExplorarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 250, 40));

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
        PanelTotalComunidad.add(ComunidadesBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 240, 250, 40));

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
        PanelTotalComunidad.add(NotificacionesBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 250, 40));

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
        PanelTotalComunidad.add(GuardadoBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 300, 250, 40));

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
        PanelTotalComunidad.add(PerfilBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 360, 250, 40));

        jPanel21.setOpaque(false);
        jPanel21.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel21.add(Y_logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 60, 40));

        PanelTotalComunidad.add(jPanel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, 70, 50));
        PanelTotalComunidad.add(Perfil_Img, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 50, 40));

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
        PanelTotalComunidad.add(PostearBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 650, 200, 40));

        PerfilPanel.setBackground(new java.awt.Color(0, 0, 0));
        PerfilPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        PerfilPanel.add(Perfil_Img1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 50, 40));

        NombreUsuario.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        NombreUsuario.setForeground(new java.awt.Color(204, 204, 204));
        NombreUsuario.setText("Usuario Ejemplo");
        PerfilPanel.add(NombreUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, -1));

        IdUsuario.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        IdUsuario.setForeground(new java.awt.Color(106, 30, 85));
        IdUsuario.setText("@Usuario1");
        PerfilPanel.add(IdUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, -1, -1));

        jButton1.setBackground(new java.awt.Color(106, 30, 85));
        jButton1.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(106, 30, 85));
        jButton1.setText("...");
        jButton1.setAlignmentY(0.0F);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        PerfilPanel.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, 50, 40));

        PanelTotalComunidad.add(PerfilPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 720, 270, 60));

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
        PanelTotalComunidad.add(PublicacionesBtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 560, 100, 30));

        QuePasa.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        QuePasa.setForeground(new java.awt.Color(204, 204, 204));
        QuePasa.setText("Qué pasa");
        PanelTotalComunidad.add(QuePasa, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 370, 210, 30));

        SeguirCuentaBtn3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        SeguirCuentaBtn3.setText("Seguir");
        PanelTotalComunidad.add(SeguirCuentaBtn3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 230, -1, 30));

        SeguirCuentaBtn1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        SeguirCuentaBtn1.setText("Seguir");
        PanelTotalComunidad.add(SeguirCuentaBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 133, -1, 30));

        SeguirCuentaBtn2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        SeguirCuentaBtn2.setText("Seguir");
        PanelTotalComunidad.add(SeguirCuentaBtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 180, -1, 30));

        jSeparator6.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator6.setForeground(new java.awt.Color(153, 153, 153));
        jSeparator6.setOrientation(javax.swing.SwingConstants.VERTICAL);
        PanelTotalComunidad.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 80, 30, 220));

        jSeparator7.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator7.setForeground(new java.awt.Color(153, 153, 153));
        jSeparator7.setOrientation(javax.swing.SwingConstants.VERTICAL);
        PanelTotalComunidad.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 80, 20, 220));
        PanelTotalComunidad.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 300, 280, 20));
        PanelTotalComunidad.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 80, 280, 10));

        jLabel40.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(204, 204, 204));
        jLabel40.setText("Te puede interesar");
        PanelTotalComunidad.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 80, 210, 30));

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
        PanelTotalComunidad.add(TendenciaYapBtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 490, 130, 50));

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
        PanelTotalComunidad.add(MostrarMasTendenciaBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 570, 80, 50));

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
        PanelTotalComunidad.add(CuentaBtn20, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 390, 80, 30));

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
        PanelTotalComunidad.add(TendenciaYapBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 410, 130, 50));

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
        PanelTotalComunidad.add(PublicacionesBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 460, 100, 50));

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
        PanelTotalComunidad.add(MostrarMasInteresBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 260, 80, 50));

        ImgInt3.setForeground(new java.awt.Color(255, 255, 255));
        ImgInt3.setText("ImgInteres2");
        PanelTotalComunidad.add(ImgInt3, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 220, 60, 50));

        ImgInt1.setForeground(new java.awt.Color(255, 255, 255));
        ImgInt1.setText("ImgInteres1");
        PanelTotalComunidad.add(ImgInt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 120, 60, 50));

        ImgInt2.setForeground(new java.awt.Color(255, 255, 255));
        ImgInt2.setText("ImgInteres2");
        PanelTotalComunidad.add(ImgInt2, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 170, 60, 50));

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
        PanelTotalComunidad.add(UserInt3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 230, -1, 30));

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
        PanelTotalComunidad.add(UserInt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 130, -1, 30));

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
        PanelTotalComunidad.add(UserInt2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 180, -1, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(PanelTotalComunidad, javax.swing.GroupLayout.PREFERRED_SIZE, 1550, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelTotalComunidad, javax.swing.GroupLayout.PREFERRED_SIZE, 820, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SeguridadYAccesoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeguridadYAccesoBtnActionPerformed
        
    }//GEN-LAST:event_SeguridadYAccesoBtnActionPerformed

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

    private void SeguridadYAccesoBtn8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeguridadYAccesoBtn8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SeguridadYAccesoBtn8ActionPerformed

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

    private void UsuarioYap1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsuarioYap1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UsuarioYap1ActionPerformed

    private void YapsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_YapsBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_YapsBtnActionPerformed

    private void ContadorYapsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContadorYapsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ContadorYapsActionPerformed

    private void DescripcionComunidadBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DescripcionComunidadBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DescripcionComunidadBtnActionPerformed

    private void FotodeComunidadBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FotodeComunidadBtn2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FotodeComunidadBtn2ActionPerformed

    private void ContadorYaps1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContadorYaps1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ContadorYaps1ActionPerformed

    private void TiempoYap1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TiempoYap1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TiempoYap1ActionPerformed

    private void DescripcionYap1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DescripcionYap1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DescripcionYap1ActionPerformed

    private void ContadorReYaps1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContadorReYaps1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ContadorReYaps1ActionPerformed

    private void ContadorYustas1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContadorYustas1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ContadorYustas1ActionPerformed

    private void ContadorRep1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContadorRep1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ContadorRep1ActionPerformed

    private void CuentaBtn26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CuentaBtn26ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CuentaBtn26ActionPerformed

    private void UsuarioYap2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsuarioYap2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UsuarioYap2ActionPerformed

    private void TiempoYap2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TiempoYap2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TiempoYap2ActionPerformed

    private void ContadorYaps2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContadorYaps2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ContadorYaps2ActionPerformed

    private void FotodeComunidadBtn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FotodeComunidadBtn3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FotodeComunidadBtn3ActionPerformed

    private void CuentaBtn29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CuentaBtn29ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CuentaBtn29ActionPerformed

    private void DecripcionYap2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DecripcionYap2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DecripcionYap2ActionPerformed

    private void ContadorReYaps2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContadorReYaps2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ContadorReYaps2ActionPerformed

    private void ContadorYustas2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContadorYustas2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ContadorYustas2ActionPerformed

    private void ContadorRep2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContadorRep2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ContadorRep2ActionPerformed

    private void SiguientePagBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SiguientePagBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SiguientePagBtnActionPerformed

    private void ConfiBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfiBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ConfiBtnActionPerformed

    private void InicioBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InicioBtn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InicioBtn1ActionPerformed

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

    private void ExplorarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExplorarBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ExplorarBtnActionPerformed

    private void PostearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PostearBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PostearBtnActionPerformed

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

    private void FotodeComunidadBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FotodeComunidadBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FotodeComunidadBtnActionPerformed

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
    private javax.swing.JButton ContadorReYaps1;
    private javax.swing.JButton ContadorReYaps2;
    private javax.swing.JButton ContadorRep1;
    private javax.swing.JButton ContadorRep2;
    private javax.swing.JButton ContadorYaps;
    private javax.swing.JButton ContadorYaps1;
    private javax.swing.JButton ContadorYaps2;
    private javax.swing.JButton ContadorYustas1;
    private javax.swing.JButton ContadorYustas2;
    private javax.swing.JButton CuentaBtn1;
    private javax.swing.JButton CuentaBtn20;
    private javax.swing.JButton CuentaBtn26;
    private javax.swing.JButton CuentaBtn29;
    private javax.swing.JButton DecripcionYap2;
    private javax.swing.JButton DescripcionComunidadBtn;
    private javax.swing.JButton DescripcionYap1;
    private javax.swing.JPanel EjemploYap1;
    private javax.swing.JPanel EjemploYap2;
    private javax.swing.JButton ExplorarBtn;
    private javax.swing.JButton FiltrarDestacados;
    private javax.swing.JButton FiltrarEventos;
    private javax.swing.JButton FiltrarMultimedia;
    private javax.swing.JButton FiltrarReYaps;
    private javax.swing.JButton FiltrarSeguidores;
    private javax.swing.JButton FiltrarYaps;
    private javax.swing.JButton FotodeComunidadBtn;
    private javax.swing.JButton FotodeComunidadBtn2;
    private javax.swing.JButton FotodeComunidadBtn3;
    private javax.swing.JButton GuardadoBtn;
    private javax.swing.JLabel IdUsuario;
    private javax.swing.JLabel ImgInt1;
    private javax.swing.JLabel ImgInt2;
    private javax.swing.JLabel ImgInt3;
    private javax.swing.JButton InicioBtn1;
    private javax.swing.JButton MostrarMasInteresBtn;
    private javax.swing.JButton MostrarMasTendenciaBtn;
    private javax.swing.JButton NoSeguidoresBtn;
    private javax.swing.JLabel NombreComunidad;
    private javax.swing.JLabel NombreUsuario;
    private javax.swing.JButton NotificacionesBtn;
    private javax.swing.JPanel PanelTotalComunidad;
    private javax.swing.JButton PerfilBtn;
    private javax.swing.JPanel PerfilPanel;
    private javax.swing.JLabel Perfil_Img;
    private javax.swing.JLabel Perfil_Img1;
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
    private javax.swing.JButton SeguridadYAccesoBtn;
    private javax.swing.JButton SeguridadYAccesoBtn8;
    private javax.swing.JButton SiguientePagBtn;
    private javax.swing.JButton TendenciaYapBtn1;
    private javax.swing.JButton TendenciaYapBtn2;
    private javax.swing.JButton TiempoYap1;
    private javax.swing.JButton TiempoYap2;
    private javax.swing.JButton UserInt1;
    private javax.swing.JButton UserInt2;
    private javax.swing.JButton UserInt3;
    private javax.swing.JButton UsuarioComunidad;
    private javax.swing.JButton UsuarioYap1;
    private javax.swing.JButton UsuarioYap2;
    private javax.swing.JLabel Y_logo;
    private javax.swing.JButton YapsBtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    // End of variables declaration//GEN-END:variables
}
