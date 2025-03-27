
package com.mycompany.proyect_y;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Busqueda extends javax.swing.JFrame {

    public Busqueda() {
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

        SeguirCuentaBtn7 = new javax.swing.JPanel();
        MencionesBtn = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        CuentaBtn = new javax.swing.JButton();
        EliminarBusquedasBtn = new javax.swing.JButton();
        jLabel38 = new javax.swing.JLabel();
        BusquedaVerTodoBtn = new javax.swing.JButton();
        CuentaBtn7 = new javax.swing.JButton();
        BarraBusquedaBtn = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        CuentaBtn13 = new javax.swing.JButton();
        CuentaBtn14 = new javax.swing.JButton();
        SeguirCuentaBtn13 = new javax.swing.JButton();
        CuentaBtn15 = new javax.swing.JButton();
        CuentaBtn16 = new javax.swing.JButton();
        SeguirCuentaBtn15 = new javax.swing.JButton();
        CuentaBtn17 = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JSeparator();
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
        jPanel2 = new javax.swing.JPanel();
        BusquedaPersonasBtn = new javax.swing.JButton();
        BusquedaComunidadesBtn = new javax.swing.JButton();
        BusquedaYapsBtn = new javax.swing.JButton();
        SeguridadYAccesoBtn8 = new javax.swing.JButton();
        SeguridadYAccesoBtn = new javax.swing.JButton();
        BusquedaTodoBtn = new javax.swing.JButton();
        BusquedaEventosBtn = new javax.swing.JButton();
        BusquedaMultimediaBtn = new javax.swing.JButton();
        EjemploBusqueda2 = new javax.swing.JPanel();
        SeguridadYAccesoBtn3 = new javax.swing.JButton();
        jLabel37 = new javax.swing.JLabel();
        CuentaBtn10 = new javax.swing.JButton();
        CuentaBtn11 = new javax.swing.JButton();
        EjemploBusqueda1 = new javax.swing.JPanel();
        SeguridadYAccesoBtn11 = new javax.swing.JButton();
        jLabel41 = new javax.swing.JLabel();
        CuentaBtn2 = new javax.swing.JButton();
        CuentaBtn5 = new javax.swing.JButton();
        EjemploBusqueda3 = new javax.swing.JPanel();
        SeguridadYAccesoBtn12 = new javax.swing.JButton();
        jLabel42 = new javax.swing.JLabel();
        CuentaBtn4 = new javax.swing.JButton();
        CuentaBtn12 = new javax.swing.JButton();
        CumpleBtn = new javax.swing.JButton();
        TusYapsBtn = new javax.swing.JButton();
        AmigosBtn = new javax.swing.JButton();
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
        IdUsuario = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        Perfil_Img = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));

        SeguirCuentaBtn7.setBackground(new java.awt.Color(0, 0, 0));
        SeguirCuentaBtn7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        MencionesBtn.setBackground(new java.awt.Color(166, 77, 121));
        MencionesBtn.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        MencionesBtn.setForeground(new java.awt.Color(204, 204, 204));
        MencionesBtn.setText("Menciones de ti");
        MencionesBtn.setToolTipText("");
        MencionesBtn.setAlignmentY(0.0F);
        MencionesBtn.setBorderPainted(false);
        MencionesBtn.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        MencionesBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MencionesBtnActionPerformed(evt);
            }
        });
        SeguirCuentaBtn7.add(MencionesBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 660, 210, 50));

        jSeparator1.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator1.setForeground(new java.awt.Color(153, 153, 153));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        SeguirCuentaBtn7.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(427, 0, -1, 1040));
        SeguirCuentaBtn7.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 570, 490, -1));

        jSeparator4.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator4.setForeground(new java.awt.Color(153, 153, 153));
        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);
        SeguirCuentaBtn7.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 0, 10, 1040));

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
        SeguirCuentaBtn7.add(CuentaBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 490, 100, 30));

        EliminarBusquedasBtn.setBackground(new java.awt.Color(166, 77, 121));
        EliminarBusquedasBtn.setText("Eliminar busquedas");
        SeguirCuentaBtn7.add(EliminarBusquedasBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 20, 140, 30));

        jLabel38.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(204, 204, 204));
        jLabel38.setText("Qué pasa");
        SeguirCuentaBtn7.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 350, 210, 30));

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
        SeguirCuentaBtn7.add(BusquedaVerTodoBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 100, 70, 40));

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
        SeguirCuentaBtn7.add(CuentaBtn7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 220, 80, 50));

        BarraBusquedaBtn.setBackground(new java.awt.Color(0, 0, 0));
        BarraBusquedaBtn.setForeground(new java.awt.Color(255, 255, 255));
        BarraBusquedaBtn.setText("🔍Buscar");
        BarraBusquedaBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        SeguirCuentaBtn7.add(BarraBusquedaBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 20, 450, 30));

        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton5.setText("Seguir");
        SeguirCuentaBtn7.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 230, -1, -1));

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
        SeguirCuentaBtn7.add(CuentaBtn13, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 110, 80, 50));

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
        SeguirCuentaBtn7.add(CuentaBtn14, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 120, 80, 50));

        SeguirCuentaBtn13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        SeguirCuentaBtn13.setText("Seguir");
        SeguirCuentaBtn7.add(SeguirCuentaBtn13, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 130, -1, -1));

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
        SeguirCuentaBtn7.add(CuentaBtn15, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 160, 80, 50));

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
        SeguirCuentaBtn7.add(CuentaBtn16, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 170, 80, 50));

        SeguirCuentaBtn15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        SeguirCuentaBtn15.setText("Seguir");
        SeguirCuentaBtn7.add(SeguirCuentaBtn15, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 180, -1, -1));

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
        SeguirCuentaBtn7.add(CuentaBtn17, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 210, 80, 50));

        jSeparator5.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator5.setForeground(new java.awt.Color(153, 153, 153));
        jSeparator5.setOrientation(javax.swing.SwingConstants.VERTICAL);
        SeguirCuentaBtn7.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 0, 10, 1040));

        jSeparator6.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator6.setForeground(new java.awt.Color(153, 153, 153));
        jSeparator6.setOrientation(javax.swing.SwingConstants.VERTICAL);
        SeguirCuentaBtn7.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 80, 80, 220));

        jSeparator7.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator7.setForeground(new java.awt.Color(153, 153, 153));
        jSeparator7.setOrientation(javax.swing.SwingConstants.VERTICAL);
        SeguirCuentaBtn7.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 80, 20, 220));
        SeguirCuentaBtn7.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 300, 280, 20));
        SeguirCuentaBtn7.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 80, 280, 10));

        jLabel40.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(204, 204, 204));
        jLabel40.setText("Te puede interesar");
        SeguirCuentaBtn7.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 80, 210, 30));

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
        SeguirCuentaBtn7.add(CuentaBtn6, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 450, 80, 30));

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
        SeguirCuentaBtn7.add(TendenciaYapBtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 460, 80, 50));

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
        SeguirCuentaBtn7.add(MostrarMasTendenciaBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 510, 80, 50));

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
        SeguirCuentaBtn7.add(CuentaBtn20, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 380, 80, 30));

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
        SeguirCuentaBtn7.add(TendenciaYapBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 390, 80, 50));

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
        SeguirCuentaBtn7.add(CuentaBtn23, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 410, 100, 50));

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
        SeguirCuentaBtn7.add(MostrarMasTePuedeInteresarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 260, 80, 50));

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
                .addContainerGap()
                .addComponent(BusquedaTodoBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BusquedaPersonasBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BusquedaComunidadesBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BusquedaYapsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BusquedaEventosBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BusquedaMultimediaBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                    .addComponent(BusquedaPersonasBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BusquedaComunidadesBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BusquedaYapsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SeguridadYAccesoBtn8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SeguridadYAccesoBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BusquedaTodoBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BusquedaEventosBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BusquedaMultimediaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        SeguirCuentaBtn7.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 60, 490, 40));

        EjemploBusqueda2.setBackground(new java.awt.Color(106, 30, 85));
        EjemploBusqueda2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        EjemploBusqueda2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        SeguridadYAccesoBtn3.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        SeguridadYAccesoBtn3.setForeground(new java.awt.Color(204, 204, 204));
        SeguridadYAccesoBtn3.setText("@Usuario");
        SeguridadYAccesoBtn3.setToolTipText("");
        SeguridadYAccesoBtn3.setBorder(null);
        SeguridadYAccesoBtn3.setBorderPainted(false);
        SeguridadYAccesoBtn3.setContentAreaFilled(false);
        SeguridadYAccesoBtn3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SeguridadYAccesoBtn3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        SeguridadYAccesoBtn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SeguridadYAccesoBtn3ActionPerformed(evt);
            }
        });

        jLabel37.setFont(new java.awt.Font("Roboto Black", 1, 22)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(204, 204, 204));
        jLabel37.setText("Usuario");

        CuentaBtn10.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        CuentaBtn10.setForeground(new java.awt.Color(204, 204, 204));
        CuentaBtn10.setText("Seguidores");
        CuentaBtn10.setBorder(null);
        CuentaBtn10.setBorderPainted(false);
        CuentaBtn10.setContentAreaFilled(false);
        CuentaBtn10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CuentaBtn10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        CuentaBtn10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CuentaBtn10ActionPerformed(evt);
            }
        });

        CuentaBtn11.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        CuentaBtn11.setForeground(new java.awt.Color(204, 204, 204));
        CuentaBtn11.setText("0");
        CuentaBtn11.setBorder(null);
        CuentaBtn11.setBorderPainted(false);
        CuentaBtn11.setContentAreaFilled(false);
        CuentaBtn11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CuentaBtn11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        CuentaBtn11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CuentaBtn11ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout EjemploBusqueda2Layout = new javax.swing.GroupLayout(EjemploBusqueda2);
        EjemploBusqueda2.setLayout(EjemploBusqueda2Layout);
        EjemploBusqueda2Layout.setHorizontalGroup(
            EjemploBusqueda2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EjemploBusqueda2Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(EjemploBusqueda2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(SeguridadYAccesoBtn3)
                    .addComponent(jLabel37))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 211, Short.MAX_VALUE)
                .addComponent(CuentaBtn11, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CuentaBtn10, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        EjemploBusqueda2Layout.setVerticalGroup(
            EjemploBusqueda2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EjemploBusqueda2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SeguridadYAccesoBtn3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EjemploBusqueda2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(EjemploBusqueda2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CuentaBtn10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CuentaBtn11))
                .addContainerGap())
        );

        SeguirCuentaBtn7.add(EjemploBusqueda2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 220, 470, 70));

        EjemploBusqueda1.setBackground(new java.awt.Color(59, 28, 50));
        EjemploBusqueda1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        EjemploBusqueda1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        SeguridadYAccesoBtn11.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        SeguridadYAccesoBtn11.setForeground(new java.awt.Color(204, 204, 204));
        SeguridadYAccesoBtn11.setText("@Usuario");
        SeguridadYAccesoBtn11.setToolTipText("");
        SeguridadYAccesoBtn11.setBorder(null);
        SeguridadYAccesoBtn11.setBorderPainted(false);
        SeguridadYAccesoBtn11.setContentAreaFilled(false);
        SeguridadYAccesoBtn11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SeguridadYAccesoBtn11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        SeguridadYAccesoBtn11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SeguridadYAccesoBtn11ActionPerformed(evt);
            }
        });

        jLabel41.setFont(new java.awt.Font("Roboto Black", 1, 22)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(204, 204, 204));
        jLabel41.setText("Usuario");

        CuentaBtn2.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        CuentaBtn2.setForeground(new java.awt.Color(204, 204, 204));
        CuentaBtn2.setText("Seguidores");
        CuentaBtn2.setBorder(null);
        CuentaBtn2.setBorderPainted(false);
        CuentaBtn2.setContentAreaFilled(false);
        CuentaBtn2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CuentaBtn2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        CuentaBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CuentaBtn2ActionPerformed(evt);
            }
        });

        CuentaBtn5.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        CuentaBtn5.setForeground(new java.awt.Color(204, 204, 204));
        CuentaBtn5.setText("0");
        CuentaBtn5.setBorder(null);
        CuentaBtn5.setBorderPainted(false);
        CuentaBtn5.setContentAreaFilled(false);
        CuentaBtn5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CuentaBtn5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        CuentaBtn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CuentaBtn5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout EjemploBusqueda1Layout = new javax.swing.GroupLayout(EjemploBusqueda1);
        EjemploBusqueda1.setLayout(EjemploBusqueda1Layout);
        EjemploBusqueda1Layout.setHorizontalGroup(
            EjemploBusqueda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EjemploBusqueda1Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(EjemploBusqueda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(SeguridadYAccesoBtn11)
                    .addComponent(jLabel41))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 214, Short.MAX_VALUE)
                .addComponent(CuentaBtn5, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CuentaBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        EjemploBusqueda1Layout.setVerticalGroup(
            EjemploBusqueda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EjemploBusqueda1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SeguridadYAccesoBtn11)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EjemploBusqueda1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(EjemploBusqueda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CuentaBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CuentaBtn5))
                .addContainerGap())
        );

        SeguirCuentaBtn7.add(EjemploBusqueda1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 140, 470, 70));

        EjemploBusqueda3.setBackground(new java.awt.Color(166, 77, 121));
        EjemploBusqueda3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        EjemploBusqueda3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        SeguridadYAccesoBtn12.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        SeguridadYAccesoBtn12.setForeground(new java.awt.Color(204, 204, 204));
        SeguridadYAccesoBtn12.setText("@Usuario");
        SeguridadYAccesoBtn12.setToolTipText("");
        SeguridadYAccesoBtn12.setBorder(null);
        SeguridadYAccesoBtn12.setBorderPainted(false);
        SeguridadYAccesoBtn12.setContentAreaFilled(false);
        SeguridadYAccesoBtn12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SeguridadYAccesoBtn12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        SeguridadYAccesoBtn12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SeguridadYAccesoBtn12ActionPerformed(evt);
            }
        });

        jLabel42.setFont(new java.awt.Font("Roboto Black", 1, 22)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(204, 204, 204));
        jLabel42.setText("Usuario");

        CuentaBtn4.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        CuentaBtn4.setForeground(new java.awt.Color(204, 204, 204));
        CuentaBtn4.setText("Seguidores");
        CuentaBtn4.setBorder(null);
        CuentaBtn4.setBorderPainted(false);
        CuentaBtn4.setContentAreaFilled(false);
        CuentaBtn4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CuentaBtn4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        CuentaBtn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CuentaBtn4ActionPerformed(evt);
            }
        });

        CuentaBtn12.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        CuentaBtn12.setForeground(new java.awt.Color(204, 204, 204));
        CuentaBtn12.setText("0");
        CuentaBtn12.setBorder(null);
        CuentaBtn12.setBorderPainted(false);
        CuentaBtn12.setContentAreaFilled(false);
        CuentaBtn12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CuentaBtn12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        CuentaBtn12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CuentaBtn12ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout EjemploBusqueda3Layout = new javax.swing.GroupLayout(EjemploBusqueda3);
        EjemploBusqueda3.setLayout(EjemploBusqueda3Layout);
        EjemploBusqueda3Layout.setHorizontalGroup(
            EjemploBusqueda3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EjemploBusqueda3Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(EjemploBusqueda3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(SeguridadYAccesoBtn12)
                    .addComponent(jLabel42))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 214, Short.MAX_VALUE)
                .addComponent(CuentaBtn12, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CuentaBtn4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        EjemploBusqueda3Layout.setVerticalGroup(
            EjemploBusqueda3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EjemploBusqueda3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SeguridadYAccesoBtn12)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EjemploBusqueda3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(EjemploBusqueda3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CuentaBtn4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CuentaBtn12))
                .addContainerGap())
        );

        SeguirCuentaBtn7.add(EjemploBusqueda3, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 300, -1, -1));

        CumpleBtn.setBackground(new java.awt.Color(106, 30, 85));
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
        SeguirCuentaBtn7.add(CumpleBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 660, 210, 50));

        TusYapsBtn.setBackground(new java.awt.Color(106, 30, 85));
        TusYapsBtn.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        TusYapsBtn.setForeground(new java.awt.Color(204, 204, 204));
        TusYapsBtn.setText("Tus Yap's");
        TusYapsBtn.setToolTipText("");
        TusYapsBtn.setAlignmentY(0.0F);
        TusYapsBtn.setBorderPainted(false);
        TusYapsBtn.setHideActionText(true);
        TusYapsBtn.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        TusYapsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TusYapsBtnActionPerformed(evt);
            }
        });
        SeguirCuentaBtn7.add(TusYapsBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 590, 210, 50));

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
        SeguirCuentaBtn7.add(AmigosBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 590, 210, 50));

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
        SeguirCuentaBtn7.add(ConfiBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 420, 260, 40));

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
        SeguirCuentaBtn7.add(InicioBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, 250, 40));

        ExplorarBtn.setBackground(new java.awt.Color(26, 26, 29));
        ExplorarBtn.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
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
        SeguirCuentaBtn7.add(ExplorarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, 250, 40));

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
        SeguirCuentaBtn7.add(ComunidadesBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 240, 250, 40));

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
        SeguirCuentaBtn7.add(NotificacionesBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 250, 40));

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
        SeguirCuentaBtn7.add(GuardadoBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 300, 250, 40));

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
        SeguirCuentaBtn7.add(PerfilBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 360, 250, 40));

        jPanel21.setOpaque(false);
        jPanel21.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel21.add(Y_logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 60, 40));

        SeguirCuentaBtn7.add(jPanel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, 70, 50));

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
        SeguirCuentaBtn7.add(PostearBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 650, 200, 40));

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

        SeguirCuentaBtn7.add(PerfilPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 720, 270, 60));
        SeguirCuentaBtn7.add(Perfil_Img, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 50, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(SeguirCuentaBtn7, javax.swing.GroupLayout.PREFERRED_SIZE, 1550, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(SeguirCuentaBtn7, javax.swing.GroupLayout.PREFERRED_SIZE, 1042, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MencionesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MencionesBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MencionesBtnActionPerformed

    private void CuentaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CuentaBtnActionPerformed
        
    }//GEN-LAST:event_CuentaBtnActionPerformed

    private void SeguridadYAccesoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeguridadYAccesoBtnActionPerformed

    }//GEN-LAST:event_SeguridadYAccesoBtnActionPerformed

    private void BusquedaVerTodoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BusquedaVerTodoBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BusquedaVerTodoBtnActionPerformed

    private void CuentaBtn5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CuentaBtn5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CuentaBtn5ActionPerformed

    private void CuentaBtn7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CuentaBtn7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CuentaBtn7ActionPerformed

    private void SeguridadYAccesoBtn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeguridadYAccesoBtn3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SeguridadYAccesoBtn3ActionPerformed

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

    private void SeguridadYAccesoBtn8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeguridadYAccesoBtn8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SeguridadYAccesoBtn8ActionPerformed

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

    private void CuentaBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CuentaBtn2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CuentaBtn2ActionPerformed

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

    private void BusquedaEventosBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BusquedaEventosBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BusquedaEventosBtnActionPerformed

    private void BusquedaMultimediaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BusquedaMultimediaBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BusquedaMultimediaBtnActionPerformed

    private void SeguridadYAccesoBtn11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeguridadYAccesoBtn11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SeguridadYAccesoBtn11ActionPerformed

    private void SeguridadYAccesoBtn12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeguridadYAccesoBtn12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SeguridadYAccesoBtn12ActionPerformed

    private void CuentaBtn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CuentaBtn4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CuentaBtn4ActionPerformed

    private void CuentaBtn10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CuentaBtn10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CuentaBtn10ActionPerformed

    private void CuentaBtn11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CuentaBtn11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CuentaBtn11ActionPerformed

    private void CuentaBtn12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CuentaBtn12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CuentaBtn12ActionPerformed

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
            java.util.logging.Logger.getLogger(Busqueda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Busqueda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Busqueda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Busqueda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Busqueda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AmigosBtn;
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
    private javax.swing.JButton CuentaBtn;
    private javax.swing.JButton CuentaBtn10;
    private javax.swing.JButton CuentaBtn11;
    private javax.swing.JButton CuentaBtn12;
    private javax.swing.JButton CuentaBtn13;
    private javax.swing.JButton CuentaBtn14;
    private javax.swing.JButton CuentaBtn15;
    private javax.swing.JButton CuentaBtn16;
    private javax.swing.JButton CuentaBtn17;
    private javax.swing.JButton CuentaBtn2;
    private javax.swing.JButton CuentaBtn20;
    private javax.swing.JButton CuentaBtn23;
    private javax.swing.JButton CuentaBtn4;
    private javax.swing.JButton CuentaBtn5;
    private javax.swing.JButton CuentaBtn6;
    private javax.swing.JButton CuentaBtn7;
    private javax.swing.JButton CumpleBtn;
    private javax.swing.JPanel EjemploBusqueda1;
    private javax.swing.JPanel EjemploBusqueda2;
    private javax.swing.JPanel EjemploBusqueda3;
    private javax.swing.JButton EliminarBusquedasBtn;
    private javax.swing.JButton ExplorarBtn;
    private javax.swing.JButton GuardadoBtn;
    private javax.swing.JLabel IdUsuario;
    private javax.swing.JButton InicioBtn1;
    private javax.swing.JButton MencionesBtn;
    private javax.swing.JButton MostrarMasTePuedeInteresarBtn;
    private javax.swing.JButton MostrarMasTendenciaBtn;
    private javax.swing.JLabel NombreUsuario;
    private javax.swing.JButton NotificacionesBtn;
    private javax.swing.JButton PerfilBtn;
    private javax.swing.JPanel PerfilPanel;
    private javax.swing.JLabel Perfil_Img;
    private javax.swing.JLabel Perfil_Img1;
    private javax.swing.JButton PostearBtn;
    private javax.swing.JButton SeguirCuentaBtn13;
    private javax.swing.JButton SeguirCuentaBtn15;
    private javax.swing.JPanel SeguirCuentaBtn7;
    private javax.swing.JButton SeguridadYAccesoBtn;
    private javax.swing.JButton SeguridadYAccesoBtn11;
    private javax.swing.JButton SeguridadYAccesoBtn12;
    private javax.swing.JButton SeguridadYAccesoBtn3;
    private javax.swing.JButton SeguridadYAccesoBtn8;
    private javax.swing.JButton TendenciaYapBtn1;
    private javax.swing.JButton TendenciaYapBtn2;
    private javax.swing.JButton TusYapsBtn;
    private javax.swing.JLabel Y_logo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel21;
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
