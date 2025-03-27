
package com.mycompany.proyect_y;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Explorar extends javax.swing.JFrame {

    public Explorar() {
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
        PublicacionesBtn2 = new javax.swing.JButton();
        EliminarBusquedasBtn = new javax.swing.JButton();
        QuePasa = new javax.swing.JLabel();
        BusquedaVerTodoBtn = new javax.swing.JButton();
        BarraBusquedaBtn = new javax.swing.JButton();
        SeguirCuentaBtn3 = new javax.swing.JButton();
        SeguirCuentaBtn1 = new javax.swing.JButton();
        SeguirCuentaBtn2 = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JSeparator();
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
        TusYapsBtn = new javax.swing.JButton();
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
        CumpImg = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        TusYapsImg = new javax.swing.JLabel();
        ImgInt3 = new javax.swing.JLabel();
        MencionesImg = new javax.swing.JLabel();
        AmigosImg1 = new javax.swing.JLabel();
        ImgInt1 = new javax.swing.JLabel();
        ImgInt2 = new javax.swing.JLabel();
        UserInt3 = new javax.swing.JButton();
        UserInt1 = new javax.swing.JButton();
        UserInt2 = new javax.swing.JButton();
        SeguirCuentaBtn8 = new javax.swing.JPanel();
        MencionesBtn1 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator10 = new javax.swing.JSeparator();
        jSeparator11 = new javax.swing.JSeparator();
        CuentaBtn1 = new javax.swing.JButton();
        EliminarBusquedasBtn1 = new javax.swing.JButton();
        jLabel39 = new javax.swing.JLabel();
        BusquedaVerTodoBtn1 = new javax.swing.JButton();
        CuentaBtn8 = new javax.swing.JButton();
        BarraBusquedaBtn1 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        CuentaBtn18 = new javax.swing.JButton();
        CuentaBtn19 = new javax.swing.JButton();
        SeguirCuentaBtn14 = new javax.swing.JButton();
        CuentaBtn21 = new javax.swing.JButton();
        CuentaBtn22 = new javax.swing.JButton();
        SeguirCuentaBtn16 = new javax.swing.JButton();
        CuentaBtn24 = new javax.swing.JButton();
        jSeparator12 = new javax.swing.JSeparator();
        jSeparator13 = new javax.swing.JSeparator();
        jSeparator14 = new javax.swing.JSeparator();
        jSeparator15 = new javax.swing.JSeparator();
        jSeparator16 = new javax.swing.JSeparator();
        jLabel41 = new javax.swing.JLabel();
        CuentaBtn9 = new javax.swing.JButton();
        TendenciaYapBtn3 = new javax.swing.JButton();
        MostrarMasTendenciaBtn1 = new javax.swing.JButton();
        CuentaBtn25 = new javax.swing.JButton();
        TendenciaYapBtn4 = new javax.swing.JButton();
        CuentaBtn26 = new javax.swing.JButton();
        MostrarMasTePuedeInteresarBtn1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        BusquedaPersonasBtn1 = new javax.swing.JButton();
        BusquedaComunidadesBtn1 = new javax.swing.JButton();
        BusquedaYapsBtn1 = new javax.swing.JButton();
        SeguridadYAccesoBtn9 = new javax.swing.JButton();
        SeguridadYAccesoBtn1 = new javax.swing.JButton();
        BusquedaTodoBtn1 = new javax.swing.JButton();
        BusquedaEventosBtn1 = new javax.swing.JButton();
        BusquedaMultimediaBtn1 = new javax.swing.JButton();
        EjemploBusqueda2 = new javax.swing.JPanel();
        UserRes2 = new javax.swing.JButton();
        NombreRes2 = new javax.swing.JLabel();
        SeguidoresRes2 = new javax.swing.JButton();
        NoSeguidoresRes2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        ImgRes2 = new javax.swing.JLabel();
        CumpleBtn1 = new javax.swing.JButton();
        TusYapsBtn1 = new javax.swing.JButton();
        AmigosBtn1 = new javax.swing.JButton();
        ConfiBtn1 = new javax.swing.JButton();
        InicioBtn2 = new javax.swing.JButton();
        ExplorarBtn1 = new javax.swing.JButton();
        ComunidadesBtn1 = new javax.swing.JButton();
        NotificacionesBtn1 = new javax.swing.JButton();
        GuardadoBtn1 = new javax.swing.JButton();
        PerfilBtn1 = new javax.swing.JButton();
        jPanel22 = new javax.swing.JPanel();
        Y_logo1 = new javax.swing.JLabel();
        PostearBtn1 = new javax.swing.JButton();
        PerfilPanel1 = new javax.swing.JPanel();
        Perfil_Img2 = new javax.swing.JLabel();
        NombreUsuario1 = new javax.swing.JLabel();
        IdUsuario1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        Perfil_Img3 = new javax.swing.JLabel();
        SeguirCuentaBtn9 = new javax.swing.JPanel();
        MencionesBtn2 = new javax.swing.JButton();
        jSeparator17 = new javax.swing.JSeparator();
        jSeparator18 = new javax.swing.JSeparator();
        jSeparator19 = new javax.swing.JSeparator();
        CuentaBtn2 = new javax.swing.JButton();
        EliminarBusquedasBtn2 = new javax.swing.JButton();
        jLabel42 = new javax.swing.JLabel();
        BusquedaVerTodoBtn2 = new javax.swing.JButton();
        CuentaBtn10 = new javax.swing.JButton();
        BarraBusquedaBtn2 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        CuentaBtn27 = new javax.swing.JButton();
        CuentaBtn28 = new javax.swing.JButton();
        SeguirCuentaBtn17 = new javax.swing.JButton();
        CuentaBtn29 = new javax.swing.JButton();
        CuentaBtn30 = new javax.swing.JButton();
        SeguirCuentaBtn18 = new javax.swing.JButton();
        CuentaBtn31 = new javax.swing.JButton();
        jSeparator20 = new javax.swing.JSeparator();
        jSeparator21 = new javax.swing.JSeparator();
        jSeparator22 = new javax.swing.JSeparator();
        jSeparator23 = new javax.swing.JSeparator();
        jSeparator24 = new javax.swing.JSeparator();
        jLabel43 = new javax.swing.JLabel();
        CuentaBtn11 = new javax.swing.JButton();
        TendenciaYapBtn5 = new javax.swing.JButton();
        MostrarMasTendenciaBtn2 = new javax.swing.JButton();
        CuentaBtn32 = new javax.swing.JButton();
        TendenciaYapBtn6 = new javax.swing.JButton();
        CuentaBtn33 = new javax.swing.JButton();
        MostrarMasTePuedeInteresarBtn2 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        BusquedaPersonasBtn2 = new javax.swing.JButton();
        BusquedaComunidadesBtn2 = new javax.swing.JButton();
        BusquedaYapsBtn2 = new javax.swing.JButton();
        SeguridadYAccesoBtn10 = new javax.swing.JButton();
        SeguridadYAccesoBtn2 = new javax.swing.JButton();
        BusquedaTodoBtn2 = new javax.swing.JButton();
        BusquedaEventosBtn2 = new javax.swing.JButton();
        BusquedaMultimediaBtn2 = new javax.swing.JButton();
        EjemploBusqueda3 = new javax.swing.JPanel();
        UserRes3 = new javax.swing.JButton();
        NombreRes3 = new javax.swing.JLabel();
        SeguidoresRes3 = new javax.swing.JButton();
        NoSeguidoresRes3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        ImgRes3 = new javax.swing.JLabel();
        CumpleBtn2 = new javax.swing.JButton();
        TusYapsBtn2 = new javax.swing.JButton();
        AmigosBtn2 = new javax.swing.JButton();
        ConfiBtn2 = new javax.swing.JButton();
        InicioBtn3 = new javax.swing.JButton();
        ExplorarBtn2 = new javax.swing.JButton();
        ComunidadesBtn2 = new javax.swing.JButton();
        NotificacionesBtn2 = new javax.swing.JButton();
        GuardadoBtn2 = new javax.swing.JButton();
        PerfilBtn2 = new javax.swing.JButton();
        jPanel23 = new javax.swing.JPanel();
        Y_logo2 = new javax.swing.JLabel();
        PostearBtn2 = new javax.swing.JButton();
        PerfilPanel2 = new javax.swing.JPanel();
        Perfil_Img4 = new javax.swing.JLabel();
        NombreUsuario2 = new javax.swing.JLabel();
        IdUsuario2 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        Perfil_Img5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));

        SeguirCuentaBtn7.setBackground(new java.awt.Color(0, 0, 0));
        SeguirCuentaBtn7.setPreferredSize(new java.awt.Dimension(1550, 820));
        SeguirCuentaBtn7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        SeguirCuentaBtn7.add(MencionesBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 670, 140, 70));

        jSeparator1.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator1.setForeground(new java.awt.Color(153, 153, 153));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        SeguirCuentaBtn7.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(427, 0, -1, 1040));
        SeguirCuentaBtn7.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 570, 490, -1));

        jSeparator4.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator4.setForeground(new java.awt.Color(153, 153, 153));
        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);
        SeguirCuentaBtn7.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 0, 10, 1040));

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
        SeguirCuentaBtn7.add(PublicacionesBtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 510, 100, 30));

        EliminarBusquedasBtn.setBackground(new java.awt.Color(166, 77, 121));
        EliminarBusquedasBtn.setText("Eliminar busquedas");
        SeguirCuentaBtn7.add(EliminarBusquedasBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 20, 140, 30));

        QuePasa.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        QuePasa.setForeground(new java.awt.Color(204, 204, 204));
        QuePasa.setText("Qué pasa");
        SeguirCuentaBtn7.add(QuePasa, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 350, 210, 30));

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

        BarraBusquedaBtn.setBackground(new java.awt.Color(0, 0, 0));
        BarraBusquedaBtn.setForeground(new java.awt.Color(255, 255, 255));
        BarraBusquedaBtn.setText("🔍Buscar");
        BarraBusquedaBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        SeguirCuentaBtn7.add(BarraBusquedaBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 20, 450, 30));

        SeguirCuentaBtn3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        SeguirCuentaBtn3.setText("Seguir");
        SeguirCuentaBtn7.add(SeguirCuentaBtn3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 230, -1, 30));

        SeguirCuentaBtn1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        SeguirCuentaBtn1.setText("Seguir");
        SeguirCuentaBtn7.add(SeguirCuentaBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 133, -1, 30));

        SeguirCuentaBtn2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        SeguirCuentaBtn2.setText("Seguir");
        SeguirCuentaBtn7.add(SeguirCuentaBtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 180, -1, 30));

        jSeparator5.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator5.setForeground(new java.awt.Color(153, 153, 153));
        jSeparator5.setOrientation(javax.swing.SwingConstants.VERTICAL);
        SeguirCuentaBtn7.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 0, 10, 1040));

        jSeparator6.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator6.setForeground(new java.awt.Color(153, 153, 153));
        jSeparator6.setOrientation(javax.swing.SwingConstants.VERTICAL);
        SeguirCuentaBtn7.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 80, 30, 220));

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
        SeguirCuentaBtn7.add(TendenciaYapBtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 480, 130, 50));

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
        SeguirCuentaBtn7.add(MostrarMasTendenciaBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 540, 80, 50));

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
        SeguirCuentaBtn7.add(CuentaBtn20, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 400, 80, 30));

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
        SeguirCuentaBtn7.add(TendenciaYapBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 420, 130, 50));

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
        SeguirCuentaBtn7.add(PublicacionesBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 440, 100, 50));

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
                    .addGroup(EjemploBusqueda1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(UserResu4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 203, Short.MAX_VALUE)
                        .addComponent(NoSeguidoresResu4, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NombreResu4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                        .addGap(0, 4, Short.MAX_VALUE))
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

        SeguirCuentaBtn7.add(EjemploBusqueda1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 470, 470, 80));

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
        SeguirCuentaBtn7.add(CumpleBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 670, 140, 70));

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
        SeguirCuentaBtn7.add(AmigosBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 590, 140, 70));

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
        SeguirCuentaBtn7.add(TusYapsBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 590, 140, 70));

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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 203, Short.MAX_VALUE)
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
                        .addGap(0, 4, Short.MAX_VALUE))
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

        SeguirCuentaBtn7.add(EjemploBusquedas1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 140, 470, 80));

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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 203, Short.MAX_VALUE)
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
                        .addGap(0, 4, Short.MAX_VALUE))
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

        SeguirCuentaBtn7.add(EjemploBusquedas2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 250, 470, 80));

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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 203, Short.MAX_VALUE)
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
                        .addGap(0, 4, Short.MAX_VALUE))
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

        SeguirCuentaBtn7.add(EjemploBusqueda6, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 360, 470, 80));

        CumpImg.setForeground(new java.awt.Color(255, 255, 255));
        CumpImg.setText("CumpImg");
        SeguirCuentaBtn7.add(CumpImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 670, 70, 70));

        jLabel8.setText("jLabel8");
        SeguirCuentaBtn7.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 600, -1, -1));

        TusYapsImg.setForeground(new java.awt.Color(255, 255, 255));
        TusYapsImg.setText("TusYapsImg");
        SeguirCuentaBtn7.add(TusYapsImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 590, 70, 70));

        ImgInt3.setForeground(new java.awt.Color(255, 255, 255));
        ImgInt3.setText("ImgInteres2");
        SeguirCuentaBtn7.add(ImgInt3, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 220, 60, 50));

        MencionesImg.setForeground(new java.awt.Color(255, 255, 255));
        MencionesImg.setText("MencionesImg");
        SeguirCuentaBtn7.add(MencionesImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 670, 70, 70));

        AmigosImg1.setForeground(new java.awt.Color(255, 255, 255));
        AmigosImg1.setText("AmigosImg");
        SeguirCuentaBtn7.add(AmigosImg1, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 590, 70, 70));

        ImgInt1.setForeground(new java.awt.Color(255, 255, 255));
        ImgInt1.setText("ImgInteres1");
        SeguirCuentaBtn7.add(ImgInt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 120, 60, 50));

        ImgInt2.setForeground(new java.awt.Color(255, 255, 255));
        ImgInt2.setText("ImgInteres2");
        SeguirCuentaBtn7.add(ImgInt2, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 170, 60, 50));

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
        SeguirCuentaBtn7.add(UserInt3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 230, -1, 30));

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
        SeguirCuentaBtn7.add(UserInt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 130, -1, 30));

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
        SeguirCuentaBtn7.add(UserInt2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 180, -1, 30));

        SeguirCuentaBtn8.setBackground(new java.awt.Color(0, 0, 0));
        SeguirCuentaBtn8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        MencionesBtn1.setBackground(new java.awt.Color(166, 77, 121));
        MencionesBtn1.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        MencionesBtn1.setForeground(new java.awt.Color(204, 204, 204));
        MencionesBtn1.setText("Menciones de ti");
        MencionesBtn1.setToolTipText("");
        MencionesBtn1.setAlignmentY(0.0F);
        MencionesBtn1.setBorderPainted(false);
        MencionesBtn1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        MencionesBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MencionesBtn1ActionPerformed(evt);
            }
        });
        SeguirCuentaBtn8.add(MencionesBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 660, 210, 50));

        jSeparator2.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator2.setForeground(new java.awt.Color(153, 153, 153));
        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        SeguirCuentaBtn8.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(427, 0, -1, 1040));
        SeguirCuentaBtn8.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 570, 490, -1));

        jSeparator11.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator11.setForeground(new java.awt.Color(153, 153, 153));
        jSeparator11.setOrientation(javax.swing.SwingConstants.VERTICAL);
        SeguirCuentaBtn8.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 0, 10, 1040));

        CuentaBtn1.setFont(new java.awt.Font("Roboto Black", 0, 10)); // NOI18N
        CuentaBtn1.setForeground(new java.awt.Color(204, 204, 204));
        CuentaBtn1.setText("1000 publicaciones");
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
        SeguirCuentaBtn8.add(CuentaBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 490, 100, 30));

        EliminarBusquedasBtn1.setBackground(new java.awt.Color(166, 77, 121));
        EliminarBusquedasBtn1.setText("Eliminar busquedas");
        SeguirCuentaBtn8.add(EliminarBusquedasBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 20, 140, 30));

        jLabel39.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(204, 204, 204));
        jLabel39.setText("Qué pasa");
        SeguirCuentaBtn8.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 350, 210, 30));

        BusquedaVerTodoBtn1.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        BusquedaVerTodoBtn1.setForeground(new java.awt.Color(204, 204, 204));
        BusquedaVerTodoBtn1.setText("Ver todo");
        BusquedaVerTodoBtn1.setBorder(null);
        BusquedaVerTodoBtn1.setBorderPainted(false);
        BusquedaVerTodoBtn1.setContentAreaFilled(false);
        BusquedaVerTodoBtn1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BusquedaVerTodoBtn1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BusquedaVerTodoBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BusquedaVerTodoBtn1ActionPerformed(evt);
            }
        });
        SeguirCuentaBtn8.add(BusquedaVerTodoBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 100, 70, 40));

        CuentaBtn8.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        CuentaBtn8.setForeground(new java.awt.Color(204, 204, 204));
        CuentaBtn8.setText("00000");
        CuentaBtn8.setBorder(null);
        CuentaBtn8.setBorderPainted(false);
        CuentaBtn8.setContentAreaFilled(false);
        CuentaBtn8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CuentaBtn8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        CuentaBtn8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CuentaBtn8ActionPerformed(evt);
            }
        });
        SeguirCuentaBtn8.add(CuentaBtn8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 220, 80, 50));

        BarraBusquedaBtn1.setBackground(new java.awt.Color(0, 0, 0));
        BarraBusquedaBtn1.setForeground(new java.awt.Color(255, 255, 255));
        BarraBusquedaBtn1.setText("🔍Buscar");
        BarraBusquedaBtn1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        SeguirCuentaBtn8.add(BarraBusquedaBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 20, 450, 30));

        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton6.setText("Seguir");
        SeguirCuentaBtn8.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 230, -1, -1));

        CuentaBtn18.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        CuentaBtn18.setForeground(new java.awt.Color(204, 204, 204));
        CuentaBtn18.setText("''''''''");
        CuentaBtn18.setBorder(null);
        CuentaBtn18.setBorderPainted(false);
        CuentaBtn18.setContentAreaFilled(false);
        CuentaBtn18.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CuentaBtn18.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        CuentaBtn18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CuentaBtn18ActionPerformed(evt);
            }
        });
        SeguirCuentaBtn8.add(CuentaBtn18, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 110, 80, 50));

        CuentaBtn19.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        CuentaBtn19.setForeground(new java.awt.Color(204, 204, 204));
        CuentaBtn19.setText("00000");
        CuentaBtn19.setBorder(null);
        CuentaBtn19.setBorderPainted(false);
        CuentaBtn19.setContentAreaFilled(false);
        CuentaBtn19.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CuentaBtn19.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        CuentaBtn19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CuentaBtn19ActionPerformed(evt);
            }
        });
        SeguirCuentaBtn8.add(CuentaBtn19, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 120, 80, 50));

        SeguirCuentaBtn14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        SeguirCuentaBtn14.setText("Seguir");
        SeguirCuentaBtn8.add(SeguirCuentaBtn14, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 130, -1, -1));

        CuentaBtn21.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        CuentaBtn21.setForeground(new java.awt.Color(204, 204, 204));
        CuentaBtn21.setText("''''''''");
        CuentaBtn21.setBorder(null);
        CuentaBtn21.setBorderPainted(false);
        CuentaBtn21.setContentAreaFilled(false);
        CuentaBtn21.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CuentaBtn21.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        CuentaBtn21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CuentaBtn21ActionPerformed(evt);
            }
        });
        SeguirCuentaBtn8.add(CuentaBtn21, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 160, 80, 50));

        CuentaBtn22.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        CuentaBtn22.setForeground(new java.awt.Color(204, 204, 204));
        CuentaBtn22.setText("00000");
        CuentaBtn22.setBorder(null);
        CuentaBtn22.setBorderPainted(false);
        CuentaBtn22.setContentAreaFilled(false);
        CuentaBtn22.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CuentaBtn22.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        CuentaBtn22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CuentaBtn22ActionPerformed(evt);
            }
        });
        SeguirCuentaBtn8.add(CuentaBtn22, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 170, 80, 50));

        SeguirCuentaBtn16.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        SeguirCuentaBtn16.setText("Seguir");
        SeguirCuentaBtn8.add(SeguirCuentaBtn16, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 180, -1, -1));

        CuentaBtn24.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        CuentaBtn24.setForeground(new java.awt.Color(204, 204, 204));
        CuentaBtn24.setText("''''''''");
        CuentaBtn24.setBorder(null);
        CuentaBtn24.setBorderPainted(false);
        CuentaBtn24.setContentAreaFilled(false);
        CuentaBtn24.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CuentaBtn24.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        CuentaBtn24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CuentaBtn24ActionPerformed(evt);
            }
        });
        SeguirCuentaBtn8.add(CuentaBtn24, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 210, 80, 50));

        jSeparator12.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator12.setForeground(new java.awt.Color(153, 153, 153));
        jSeparator12.setOrientation(javax.swing.SwingConstants.VERTICAL);
        SeguirCuentaBtn8.add(jSeparator12, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 0, 10, 1040));

        jSeparator13.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator13.setForeground(new java.awt.Color(153, 153, 153));
        jSeparator13.setOrientation(javax.swing.SwingConstants.VERTICAL);
        SeguirCuentaBtn8.add(jSeparator13, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 80, 80, 220));

        jSeparator14.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator14.setForeground(new java.awt.Color(153, 153, 153));
        jSeparator14.setOrientation(javax.swing.SwingConstants.VERTICAL);
        SeguirCuentaBtn8.add(jSeparator14, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 80, 20, 220));
        SeguirCuentaBtn8.add(jSeparator15, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 300, 280, 20));
        SeguirCuentaBtn8.add(jSeparator16, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 80, 280, 10));

        jLabel41.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(204, 204, 204));
        jLabel41.setText("Te puede interesar");
        SeguirCuentaBtn8.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 80, 210, 30));

        CuentaBtn9.setFont(new java.awt.Font("Roboto Black", 0, 10)); // NOI18N
        CuentaBtn9.setForeground(new java.awt.Color(204, 204, 204));
        CuentaBtn9.setText("Tendencia");
        CuentaBtn9.setBorder(null);
        CuentaBtn9.setBorderPainted(false);
        CuentaBtn9.setContentAreaFilled(false);
        CuentaBtn9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CuentaBtn9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        CuentaBtn9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CuentaBtn9ActionPerformed(evt);
            }
        });
        SeguirCuentaBtn8.add(CuentaBtn9, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 450, 80, 30));

        TendenciaYapBtn3.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        TendenciaYapBtn3.setForeground(new java.awt.Color(204, 204, 204));
        TendenciaYapBtn3.setText("#0000");
        TendenciaYapBtn3.setBorder(null);
        TendenciaYapBtn3.setBorderPainted(false);
        TendenciaYapBtn3.setContentAreaFilled(false);
        TendenciaYapBtn3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TendenciaYapBtn3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        TendenciaYapBtn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TendenciaYapBtn3ActionPerformed(evt);
            }
        });
        SeguirCuentaBtn8.add(TendenciaYapBtn3, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 460, 80, 50));

        MostrarMasTendenciaBtn1.setFont(new java.awt.Font("Roboto Black", 0, 10)); // NOI18N
        MostrarMasTendenciaBtn1.setForeground(new java.awt.Color(204, 204, 204));
        MostrarMasTendenciaBtn1.setText("Mostrar mas");
        MostrarMasTendenciaBtn1.setBorder(null);
        MostrarMasTendenciaBtn1.setBorderPainted(false);
        MostrarMasTendenciaBtn1.setContentAreaFilled(false);
        MostrarMasTendenciaBtn1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MostrarMasTendenciaBtn1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        MostrarMasTendenciaBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MostrarMasTendenciaBtn1ActionPerformed(evt);
            }
        });
        SeguirCuentaBtn8.add(MostrarMasTendenciaBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 510, 80, 50));

        CuentaBtn25.setFont(new java.awt.Font("Roboto Black", 0, 10)); // NOI18N
        CuentaBtn25.setForeground(new java.awt.Color(204, 204, 204));
        CuentaBtn25.setText("Tendencia");
        CuentaBtn25.setBorder(null);
        CuentaBtn25.setBorderPainted(false);
        CuentaBtn25.setContentAreaFilled(false);
        CuentaBtn25.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CuentaBtn25.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        CuentaBtn25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CuentaBtn25ActionPerformed(evt);
            }
        });
        SeguirCuentaBtn8.add(CuentaBtn25, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 380, 80, 30));

        TendenciaYapBtn4.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        TendenciaYapBtn4.setForeground(new java.awt.Color(204, 204, 204));
        TendenciaYapBtn4.setText("#0000");
        TendenciaYapBtn4.setBorder(null);
        TendenciaYapBtn4.setBorderPainted(false);
        TendenciaYapBtn4.setContentAreaFilled(false);
        TendenciaYapBtn4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TendenciaYapBtn4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        TendenciaYapBtn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TendenciaYapBtn4ActionPerformed(evt);
            }
        });
        SeguirCuentaBtn8.add(TendenciaYapBtn4, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 390, 80, 50));

        CuentaBtn26.setFont(new java.awt.Font("Roboto Black", 0, 10)); // NOI18N
        CuentaBtn26.setForeground(new java.awt.Color(204, 204, 204));
        CuentaBtn26.setText("1000 publicaciones");
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
        SeguirCuentaBtn8.add(CuentaBtn26, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 410, 100, 50));

        MostrarMasTePuedeInteresarBtn1.setFont(new java.awt.Font("Roboto Black", 0, 10)); // NOI18N
        MostrarMasTePuedeInteresarBtn1.setForeground(new java.awt.Color(204, 204, 204));
        MostrarMasTePuedeInteresarBtn1.setText("Mostrar mas");
        MostrarMasTePuedeInteresarBtn1.setBorder(null);
        MostrarMasTePuedeInteresarBtn1.setBorderPainted(false);
        MostrarMasTePuedeInteresarBtn1.setContentAreaFilled(false);
        MostrarMasTePuedeInteresarBtn1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MostrarMasTePuedeInteresarBtn1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        MostrarMasTePuedeInteresarBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MostrarMasTePuedeInteresarBtn1ActionPerformed(evt);
            }
        });
        SeguirCuentaBtn8.add(MostrarMasTePuedeInteresarBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 260, 80, 50));

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        BusquedaPersonasBtn1.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        BusquedaPersonasBtn1.setForeground(new java.awt.Color(204, 204, 204));
        BusquedaPersonasBtn1.setText("Personas");
        BusquedaPersonasBtn1.setToolTipText("");
        BusquedaPersonasBtn1.setBorder(null);
        BusquedaPersonasBtn1.setBorderPainted(false);
        BusquedaPersonasBtn1.setContentAreaFilled(false);
        BusquedaPersonasBtn1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BusquedaPersonasBtn1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BusquedaPersonasBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BusquedaPersonasBtn1ActionPerformed(evt);
            }
        });

        BusquedaComunidadesBtn1.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        BusquedaComunidadesBtn1.setForeground(new java.awt.Color(204, 204, 204));
        BusquedaComunidadesBtn1.setText("Comunidades");
        BusquedaComunidadesBtn1.setToolTipText("");
        BusquedaComunidadesBtn1.setBorder(null);
        BusquedaComunidadesBtn1.setBorderPainted(false);
        BusquedaComunidadesBtn1.setContentAreaFilled(false);
        BusquedaComunidadesBtn1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BusquedaComunidadesBtn1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BusquedaComunidadesBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BusquedaComunidadesBtn1ActionPerformed(evt);
            }
        });

        BusquedaYapsBtn1.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        BusquedaYapsBtn1.setForeground(new java.awt.Color(204, 204, 204));
        BusquedaYapsBtn1.setText("Yap's");
        BusquedaYapsBtn1.setToolTipText("");
        BusquedaYapsBtn1.setBorder(null);
        BusquedaYapsBtn1.setBorderPainted(false);
        BusquedaYapsBtn1.setContentAreaFilled(false);
        BusquedaYapsBtn1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BusquedaYapsBtn1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BusquedaYapsBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BusquedaYapsBtn1ActionPerformed(evt);
            }
        });

        SeguridadYAccesoBtn9.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        SeguridadYAccesoBtn9.setForeground(new java.awt.Color(204, 204, 204));
        SeguridadYAccesoBtn9.setToolTipText("");
        SeguridadYAccesoBtn9.setBorder(null);
        SeguridadYAccesoBtn9.setBorderPainted(false);
        SeguridadYAccesoBtn9.setContentAreaFilled(false);
        SeguridadYAccesoBtn9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SeguridadYAccesoBtn9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        SeguridadYAccesoBtn9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SeguridadYAccesoBtn9ActionPerformed(evt);
            }
        });

        SeguridadYAccesoBtn1.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        SeguridadYAccesoBtn1.setForeground(new java.awt.Color(204, 204, 204));
        SeguridadYAccesoBtn1.setText("Le gusta");
        SeguridadYAccesoBtn1.setToolTipText("");
        SeguridadYAccesoBtn1.setBorder(null);
        SeguridadYAccesoBtn1.setBorderPainted(false);
        SeguridadYAccesoBtn1.setContentAreaFilled(false);
        SeguridadYAccesoBtn1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SeguridadYAccesoBtn1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        SeguridadYAccesoBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SeguridadYAccesoBtn1ActionPerformed(evt);
            }
        });

        BusquedaTodoBtn1.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        BusquedaTodoBtn1.setForeground(new java.awt.Color(204, 204, 204));
        BusquedaTodoBtn1.setText("Todo");
        BusquedaTodoBtn1.setToolTipText("");
        BusquedaTodoBtn1.setBorder(null);
        BusquedaTodoBtn1.setBorderPainted(false);
        BusquedaTodoBtn1.setContentAreaFilled(false);
        BusquedaTodoBtn1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BusquedaTodoBtn1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BusquedaTodoBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BusquedaTodoBtn1ActionPerformed(evt);
            }
        });

        BusquedaEventosBtn1.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        BusquedaEventosBtn1.setForeground(new java.awt.Color(204, 204, 204));
        BusquedaEventosBtn1.setText("Eventos");
        BusquedaEventosBtn1.setToolTipText("");
        BusquedaEventosBtn1.setBorder(null);
        BusquedaEventosBtn1.setBorderPainted(false);
        BusquedaEventosBtn1.setContentAreaFilled(false);
        BusquedaEventosBtn1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BusquedaEventosBtn1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BusquedaEventosBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BusquedaEventosBtn1ActionPerformed(evt);
            }
        });

        BusquedaMultimediaBtn1.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        BusquedaMultimediaBtn1.setForeground(new java.awt.Color(204, 204, 204));
        BusquedaMultimediaBtn1.setText("Multimedia");
        BusquedaMultimediaBtn1.setToolTipText("");
        BusquedaMultimediaBtn1.setBorder(null);
        BusquedaMultimediaBtn1.setBorderPainted(false);
        BusquedaMultimediaBtn1.setContentAreaFilled(false);
        BusquedaMultimediaBtn1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BusquedaMultimediaBtn1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BusquedaMultimediaBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BusquedaMultimediaBtn1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BusquedaTodoBtn1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BusquedaPersonasBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BusquedaComunidadesBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BusquedaYapsBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BusquedaEventosBtn1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BusquedaMultimediaBtn1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SeguridadYAccesoBtn9, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(126, 126, 126)
                .addComponent(SeguridadYAccesoBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BusquedaPersonasBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BusquedaComunidadesBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BusquedaYapsBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SeguridadYAccesoBtn9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SeguridadYAccesoBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BusquedaTodoBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BusquedaEventosBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BusquedaMultimediaBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        SeguirCuentaBtn8.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 60, 490, 40));

        EjemploBusqueda2.setBackground(new java.awt.Color(59, 28, 50));
        EjemploBusqueda2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        EjemploBusqueda2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        UserRes2.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        UserRes2.setForeground(new java.awt.Color(204, 204, 204));
        UserRes2.setText("@Usuario");
        UserRes2.setToolTipText("");
        UserRes2.setBorder(null);
        UserRes2.setBorderPainted(false);
        UserRes2.setContentAreaFilled(false);
        UserRes2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        UserRes2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        UserRes2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserRes2ActionPerformed(evt);
            }
        });

        NombreRes2.setFont(new java.awt.Font("Roboto Black", 1, 22)); // NOI18N
        NombreRes2.setForeground(new java.awt.Color(204, 204, 204));
        NombreRes2.setText("Resultado 1");

        SeguidoresRes2.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        SeguidoresRes2.setForeground(new java.awt.Color(204, 204, 204));
        SeguidoresRes2.setText("Seguidores");
        SeguidoresRes2.setBorder(null);
        SeguidoresRes2.setBorderPainted(false);
        SeguidoresRes2.setContentAreaFilled(false);
        SeguidoresRes2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SeguidoresRes2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        SeguidoresRes2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SeguidoresRes2ActionPerformed(evt);
            }
        });

        NoSeguidoresRes2.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        NoSeguidoresRes2.setForeground(new java.awt.Color(204, 204, 204));
        NoSeguidoresRes2.setText("0");
        NoSeguidoresRes2.setBorder(null);
        NoSeguidoresRes2.setBorderPainted(false);
        NoSeguidoresRes2.setContentAreaFilled(false);
        NoSeguidoresRes2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        NoSeguidoresRes2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        NoSeguidoresRes2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NoSeguidoresRes2ActionPerformed(evt);
            }
        });

        ImgRes2.setText("img_resultado1");

        javax.swing.GroupLayout EjemploBusqueda2Layout = new javax.swing.GroupLayout(EjemploBusqueda2);
        EjemploBusqueda2.setLayout(EjemploBusqueda2Layout);
        EjemploBusqueda2Layout.setHorizontalGroup(
            EjemploBusqueda2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EjemploBusqueda2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ImgRes2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(EjemploBusqueda2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(EjemploBusqueda2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(UserRes2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 203, Short.MAX_VALUE)
                        .addComponent(NoSeguidoresRes2, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NombreRes2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SeguidoresRes2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        EjemploBusqueda2Layout.setVerticalGroup(
            EjemploBusqueda2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EjemploBusqueda2Layout.createSequentialGroup()
                .addGroup(EjemploBusqueda2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EjemploBusqueda2Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(NombreRes2, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(UserRes2)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel2)
                        .addGap(0, 4, Short.MAX_VALUE))
                    .addGroup(EjemploBusqueda2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(ImgRes2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EjemploBusqueda2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(EjemploBusqueda2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SeguidoresRes2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NoSeguidoresRes2)))
        );

        SeguirCuentaBtn8.add(EjemploBusqueda2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 140, 470, 80));

        CumpleBtn1.setBackground(new java.awt.Color(106, 30, 85));
        CumpleBtn1.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        CumpleBtn1.setForeground(new java.awt.Color(204, 204, 204));
        CumpleBtn1.setText(" Cumpleaños");
        CumpleBtn1.setToolTipText("");
        CumpleBtn1.setAlignmentY(0.0F);
        CumpleBtn1.setBorderPainted(false);
        CumpleBtn1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        CumpleBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CumpleBtn1ActionPerformed(evt);
            }
        });
        SeguirCuentaBtn8.add(CumpleBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 660, 210, 50));

        TusYapsBtn1.setBackground(new java.awt.Color(106, 30, 85));
        TusYapsBtn1.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        TusYapsBtn1.setForeground(new java.awt.Color(204, 204, 204));
        TusYapsBtn1.setText("Tus Yap's");
        TusYapsBtn1.setToolTipText("");
        TusYapsBtn1.setAlignmentY(0.0F);
        TusYapsBtn1.setBorderPainted(false);
        TusYapsBtn1.setHideActionText(true);
        TusYapsBtn1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        TusYapsBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TusYapsBtn1ActionPerformed(evt);
            }
        });
        SeguirCuentaBtn8.add(TusYapsBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 590, 210, 50));

        AmigosBtn1.setBackground(new java.awt.Color(166, 77, 121));
        AmigosBtn1.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        AmigosBtn1.setForeground(new java.awt.Color(204, 204, 204));
        AmigosBtn1.setText("Amigos");
        AmigosBtn1.setToolTipText("");
        AmigosBtn1.setAlignmentY(0.0F);
        AmigosBtn1.setBorderPainted(false);
        AmigosBtn1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        AmigosBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AmigosBtn1ActionPerformed(evt);
            }
        });
        SeguirCuentaBtn8.add(AmigosBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 590, 210, 50));

        ConfiBtn1.setBackground(new java.awt.Color(26, 26, 29));
        ConfiBtn1.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        ConfiBtn1.setForeground(new java.awt.Color(204, 204, 204));
        ConfiBtn1.setText("Configuracion");
        ConfiBtn1.setToolTipText("");
        ConfiBtn1.setAlignmentY(0.0F);
        ConfiBtn1.setBorderPainted(false);
        ConfiBtn1.setContentAreaFilled(false);
        ConfiBtn1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ConfiBtn1.setVerifyInputWhenFocusTarget(false);
        ConfiBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfiBtn1ActionPerformed(evt);
            }
        });
        SeguirCuentaBtn8.add(ConfiBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 420, 260, 40));

        InicioBtn2.setBackground(new java.awt.Color(26, 26, 29));
        InicioBtn2.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
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
        SeguirCuentaBtn8.add(InicioBtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, 250, 40));

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
        SeguirCuentaBtn8.add(ExplorarBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, 250, 40));

        ComunidadesBtn1.setBackground(new java.awt.Color(26, 26, 29));
        ComunidadesBtn1.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        ComunidadesBtn1.setForeground(new java.awt.Color(204, 204, 204));
        ComunidadesBtn1.setText("  Comunidades");
        ComunidadesBtn1.setToolTipText("");
        ComunidadesBtn1.setAlignmentY(0.0F);
        ComunidadesBtn1.setBorderPainted(false);
        ComunidadesBtn1.setContentAreaFilled(false);
        ComunidadesBtn1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ComunidadesBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComunidadesBtn1ActionPerformed(evt);
            }
        });
        SeguirCuentaBtn8.add(ComunidadesBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 240, 250, 40));

        NotificacionesBtn1.setBackground(new java.awt.Color(26, 26, 29));
        NotificacionesBtn1.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        NotificacionesBtn1.setForeground(new java.awt.Color(204, 204, 204));
        NotificacionesBtn1.setText("  Notificaciones");
        NotificacionesBtn1.setToolTipText("");
        NotificacionesBtn1.setAlignmentY(0.0F);
        NotificacionesBtn1.setBorderPainted(false);
        NotificacionesBtn1.setContentAreaFilled(false);
        NotificacionesBtn1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        NotificacionesBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NotificacionesBtn1ActionPerformed(evt);
            }
        });
        SeguirCuentaBtn8.add(NotificacionesBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 250, 40));

        GuardadoBtn1.setBackground(new java.awt.Color(26, 26, 29));
        GuardadoBtn1.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        GuardadoBtn1.setForeground(new java.awt.Color(204, 204, 204));
        GuardadoBtn1.setText("  Guardados");
        GuardadoBtn1.setToolTipText("");
        GuardadoBtn1.setAlignmentY(0.0F);
        GuardadoBtn1.setBorderPainted(false);
        GuardadoBtn1.setContentAreaFilled(false);
        GuardadoBtn1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        GuardadoBtn1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        GuardadoBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardadoBtn1ActionPerformed(evt);
            }
        });
        SeguirCuentaBtn8.add(GuardadoBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 300, 250, 40));

        PerfilBtn1.setBackground(new java.awt.Color(26, 26, 29));
        PerfilBtn1.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        PerfilBtn1.setForeground(new java.awt.Color(204, 204, 204));
        PerfilBtn1.setText("  Perfil");
        PerfilBtn1.setToolTipText("");
        PerfilBtn1.setAlignmentY(0.0F);
        PerfilBtn1.setBorderPainted(false);
        PerfilBtn1.setContentAreaFilled(false);
        PerfilBtn1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        PerfilBtn1.setVerifyInputWhenFocusTarget(false);
        PerfilBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PerfilBtn1ActionPerformed(evt);
            }
        });
        SeguirCuentaBtn8.add(PerfilBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 360, 250, 40));

        jPanel22.setOpaque(false);
        jPanel22.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel22.add(Y_logo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 60, 40));

        SeguirCuentaBtn8.add(jPanel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, 70, 50));

        PostearBtn1.setBackground(new java.awt.Color(166, 77, 121));
        PostearBtn1.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        PostearBtn1.setForeground(new java.awt.Color(204, 204, 204));
        PostearBtn1.setText("Publicacion");
        PostearBtn1.setToolTipText("");
        PostearBtn1.setAlignmentY(0.0F);
        PostearBtn1.setBorderPainted(false);
        PostearBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PostearBtn1ActionPerformed(evt);
            }
        });
        SeguirCuentaBtn8.add(PostearBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 650, 200, 40));

        PerfilPanel1.setBackground(new java.awt.Color(0, 0, 0));
        PerfilPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        PerfilPanel1.add(Perfil_Img2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 50, 40));

        NombreUsuario1.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        NombreUsuario1.setForeground(new java.awt.Color(204, 204, 204));
        NombreUsuario1.setText("Usuario Ejemplo");
        PerfilPanel1.add(NombreUsuario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, -1));

        IdUsuario1.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        IdUsuario1.setForeground(new java.awt.Color(106, 30, 85));
        IdUsuario1.setText("@Usuario1");
        PerfilPanel1.add(IdUsuario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, -1, -1));

        jButton2.setBackground(new java.awt.Color(106, 30, 85));
        jButton2.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jButton2.setForeground(new java.awt.Color(106, 30, 85));
        jButton2.setText("...");
        jButton2.setAlignmentY(0.0F);
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        PerfilPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, 50, 40));

        SeguirCuentaBtn8.add(PerfilPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 720, 270, 60));
        SeguirCuentaBtn8.add(Perfil_Img3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 50, 40));

        SeguirCuentaBtn9.setBackground(new java.awt.Color(0, 0, 0));
        SeguirCuentaBtn9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        MencionesBtn2.setBackground(new java.awt.Color(166, 77, 121));
        MencionesBtn2.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        MencionesBtn2.setForeground(new java.awt.Color(204, 204, 204));
        MencionesBtn2.setText("Menciones de ti");
        MencionesBtn2.setToolTipText("");
        MencionesBtn2.setAlignmentY(0.0F);
        MencionesBtn2.setBorderPainted(false);
        MencionesBtn2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        MencionesBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MencionesBtn2ActionPerformed(evt);
            }
        });
        SeguirCuentaBtn9.add(MencionesBtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 660, 210, 50));

        jSeparator17.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator17.setForeground(new java.awt.Color(153, 153, 153));
        jSeparator17.setOrientation(javax.swing.SwingConstants.VERTICAL);
        SeguirCuentaBtn9.add(jSeparator17, new org.netbeans.lib.awtextra.AbsoluteConstraints(427, 0, -1, 1040));
        SeguirCuentaBtn9.add(jSeparator18, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 570, 490, -1));

        jSeparator19.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator19.setForeground(new java.awt.Color(153, 153, 153));
        jSeparator19.setOrientation(javax.swing.SwingConstants.VERTICAL);
        SeguirCuentaBtn9.add(jSeparator19, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 0, 10, 1040));

        CuentaBtn2.setFont(new java.awt.Font("Roboto Black", 0, 10)); // NOI18N
        CuentaBtn2.setForeground(new java.awt.Color(204, 204, 204));
        CuentaBtn2.setText("1000 publicaciones");
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
        SeguirCuentaBtn9.add(CuentaBtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 490, 100, 30));

        EliminarBusquedasBtn2.setBackground(new java.awt.Color(166, 77, 121));
        EliminarBusquedasBtn2.setText("Eliminar busquedas");
        SeguirCuentaBtn9.add(EliminarBusquedasBtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 20, 140, 30));

        jLabel42.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(204, 204, 204));
        jLabel42.setText("Qué pasa");
        SeguirCuentaBtn9.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 350, 210, 30));

        BusquedaVerTodoBtn2.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        BusquedaVerTodoBtn2.setForeground(new java.awt.Color(204, 204, 204));
        BusquedaVerTodoBtn2.setText("Ver todo");
        BusquedaVerTodoBtn2.setBorder(null);
        BusquedaVerTodoBtn2.setBorderPainted(false);
        BusquedaVerTodoBtn2.setContentAreaFilled(false);
        BusquedaVerTodoBtn2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BusquedaVerTodoBtn2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BusquedaVerTodoBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BusquedaVerTodoBtn2ActionPerformed(evt);
            }
        });
        SeguirCuentaBtn9.add(BusquedaVerTodoBtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 100, 70, 40));

        CuentaBtn10.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        CuentaBtn10.setForeground(new java.awt.Color(204, 204, 204));
        CuentaBtn10.setText("00000");
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
        SeguirCuentaBtn9.add(CuentaBtn10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 220, 80, 50));

        BarraBusquedaBtn2.setBackground(new java.awt.Color(0, 0, 0));
        BarraBusquedaBtn2.setForeground(new java.awt.Color(255, 255, 255));
        BarraBusquedaBtn2.setText("🔍Buscar");
        BarraBusquedaBtn2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        SeguirCuentaBtn9.add(BarraBusquedaBtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 20, 450, 30));

        jButton7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton7.setText("Seguir");
        SeguirCuentaBtn9.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 230, -1, -1));

        CuentaBtn27.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        CuentaBtn27.setForeground(new java.awt.Color(204, 204, 204));
        CuentaBtn27.setText("''''''''");
        CuentaBtn27.setBorder(null);
        CuentaBtn27.setBorderPainted(false);
        CuentaBtn27.setContentAreaFilled(false);
        CuentaBtn27.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CuentaBtn27.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        CuentaBtn27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CuentaBtn27ActionPerformed(evt);
            }
        });
        SeguirCuentaBtn9.add(CuentaBtn27, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 110, 80, 50));

        CuentaBtn28.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        CuentaBtn28.setForeground(new java.awt.Color(204, 204, 204));
        CuentaBtn28.setText("00000");
        CuentaBtn28.setBorder(null);
        CuentaBtn28.setBorderPainted(false);
        CuentaBtn28.setContentAreaFilled(false);
        CuentaBtn28.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CuentaBtn28.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        CuentaBtn28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CuentaBtn28ActionPerformed(evt);
            }
        });
        SeguirCuentaBtn9.add(CuentaBtn28, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 120, 80, 50));

        SeguirCuentaBtn17.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        SeguirCuentaBtn17.setText("Seguir");
        SeguirCuentaBtn9.add(SeguirCuentaBtn17, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 130, -1, -1));

        CuentaBtn29.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        CuentaBtn29.setForeground(new java.awt.Color(204, 204, 204));
        CuentaBtn29.setText("''''''''");
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
        SeguirCuentaBtn9.add(CuentaBtn29, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 160, 80, 50));

        CuentaBtn30.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        CuentaBtn30.setForeground(new java.awt.Color(204, 204, 204));
        CuentaBtn30.setText("00000");
        CuentaBtn30.setBorder(null);
        CuentaBtn30.setBorderPainted(false);
        CuentaBtn30.setContentAreaFilled(false);
        CuentaBtn30.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CuentaBtn30.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        CuentaBtn30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CuentaBtn30ActionPerformed(evt);
            }
        });
        SeguirCuentaBtn9.add(CuentaBtn30, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 170, 80, 50));

        SeguirCuentaBtn18.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        SeguirCuentaBtn18.setText("Seguir");
        SeguirCuentaBtn9.add(SeguirCuentaBtn18, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 180, -1, -1));

        CuentaBtn31.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        CuentaBtn31.setForeground(new java.awt.Color(204, 204, 204));
        CuentaBtn31.setText("''''''''");
        CuentaBtn31.setBorder(null);
        CuentaBtn31.setBorderPainted(false);
        CuentaBtn31.setContentAreaFilled(false);
        CuentaBtn31.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CuentaBtn31.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        CuentaBtn31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CuentaBtn31ActionPerformed(evt);
            }
        });
        SeguirCuentaBtn9.add(CuentaBtn31, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 210, 80, 50));

        jSeparator20.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator20.setForeground(new java.awt.Color(153, 153, 153));
        jSeparator20.setOrientation(javax.swing.SwingConstants.VERTICAL);
        SeguirCuentaBtn9.add(jSeparator20, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 0, 10, 1040));

        jSeparator21.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator21.setForeground(new java.awt.Color(153, 153, 153));
        jSeparator21.setOrientation(javax.swing.SwingConstants.VERTICAL);
        SeguirCuentaBtn9.add(jSeparator21, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 80, 80, 220));

        jSeparator22.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator22.setForeground(new java.awt.Color(153, 153, 153));
        jSeparator22.setOrientation(javax.swing.SwingConstants.VERTICAL);
        SeguirCuentaBtn9.add(jSeparator22, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 80, 20, 220));
        SeguirCuentaBtn9.add(jSeparator23, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 300, 280, 20));
        SeguirCuentaBtn9.add(jSeparator24, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 80, 280, 10));

        jLabel43.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(204, 204, 204));
        jLabel43.setText("Te puede interesar");
        SeguirCuentaBtn9.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 80, 210, 30));

        CuentaBtn11.setFont(new java.awt.Font("Roboto Black", 0, 10)); // NOI18N
        CuentaBtn11.setForeground(new java.awt.Color(204, 204, 204));
        CuentaBtn11.setText("Tendencia");
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
        SeguirCuentaBtn9.add(CuentaBtn11, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 450, 80, 30));

        TendenciaYapBtn5.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        TendenciaYapBtn5.setForeground(new java.awt.Color(204, 204, 204));
        TendenciaYapBtn5.setText("#0000");
        TendenciaYapBtn5.setBorder(null);
        TendenciaYapBtn5.setBorderPainted(false);
        TendenciaYapBtn5.setContentAreaFilled(false);
        TendenciaYapBtn5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TendenciaYapBtn5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        TendenciaYapBtn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TendenciaYapBtn5ActionPerformed(evt);
            }
        });
        SeguirCuentaBtn9.add(TendenciaYapBtn5, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 460, 80, 50));

        MostrarMasTendenciaBtn2.setFont(new java.awt.Font("Roboto Black", 0, 10)); // NOI18N
        MostrarMasTendenciaBtn2.setForeground(new java.awt.Color(204, 204, 204));
        MostrarMasTendenciaBtn2.setText("Mostrar mas");
        MostrarMasTendenciaBtn2.setBorder(null);
        MostrarMasTendenciaBtn2.setBorderPainted(false);
        MostrarMasTendenciaBtn2.setContentAreaFilled(false);
        MostrarMasTendenciaBtn2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MostrarMasTendenciaBtn2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        MostrarMasTendenciaBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MostrarMasTendenciaBtn2ActionPerformed(evt);
            }
        });
        SeguirCuentaBtn9.add(MostrarMasTendenciaBtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 510, 80, 50));

        CuentaBtn32.setFont(new java.awt.Font("Roboto Black", 0, 10)); // NOI18N
        CuentaBtn32.setForeground(new java.awt.Color(204, 204, 204));
        CuentaBtn32.setText("Tendencia");
        CuentaBtn32.setBorder(null);
        CuentaBtn32.setBorderPainted(false);
        CuentaBtn32.setContentAreaFilled(false);
        CuentaBtn32.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CuentaBtn32.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        CuentaBtn32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CuentaBtn32ActionPerformed(evt);
            }
        });
        SeguirCuentaBtn9.add(CuentaBtn32, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 380, 80, 30));

        TendenciaYapBtn6.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        TendenciaYapBtn6.setForeground(new java.awt.Color(204, 204, 204));
        TendenciaYapBtn6.setText("#0000");
        TendenciaYapBtn6.setBorder(null);
        TendenciaYapBtn6.setBorderPainted(false);
        TendenciaYapBtn6.setContentAreaFilled(false);
        TendenciaYapBtn6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TendenciaYapBtn6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        TendenciaYapBtn6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TendenciaYapBtn6ActionPerformed(evt);
            }
        });
        SeguirCuentaBtn9.add(TendenciaYapBtn6, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 390, 80, 50));

        CuentaBtn33.setFont(new java.awt.Font("Roboto Black", 0, 10)); // NOI18N
        CuentaBtn33.setForeground(new java.awt.Color(204, 204, 204));
        CuentaBtn33.setText("1000 publicaciones");
        CuentaBtn33.setBorder(null);
        CuentaBtn33.setBorderPainted(false);
        CuentaBtn33.setContentAreaFilled(false);
        CuentaBtn33.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CuentaBtn33.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        CuentaBtn33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CuentaBtn33ActionPerformed(evt);
            }
        });
        SeguirCuentaBtn9.add(CuentaBtn33, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 410, 100, 50));

        MostrarMasTePuedeInteresarBtn2.setFont(new java.awt.Font("Roboto Black", 0, 10)); // NOI18N
        MostrarMasTePuedeInteresarBtn2.setForeground(new java.awt.Color(204, 204, 204));
        MostrarMasTePuedeInteresarBtn2.setText("Mostrar mas");
        MostrarMasTePuedeInteresarBtn2.setBorder(null);
        MostrarMasTePuedeInteresarBtn2.setBorderPainted(false);
        MostrarMasTePuedeInteresarBtn2.setContentAreaFilled(false);
        MostrarMasTePuedeInteresarBtn2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MostrarMasTePuedeInteresarBtn2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        MostrarMasTePuedeInteresarBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MostrarMasTePuedeInteresarBtn2ActionPerformed(evt);
            }
        });
        SeguirCuentaBtn9.add(MostrarMasTePuedeInteresarBtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 260, 80, 50));

        jPanel4.setBackground(new java.awt.Color(102, 102, 102));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        BusquedaPersonasBtn2.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        BusquedaPersonasBtn2.setForeground(new java.awt.Color(204, 204, 204));
        BusquedaPersonasBtn2.setText("Personas");
        BusquedaPersonasBtn2.setToolTipText("");
        BusquedaPersonasBtn2.setBorder(null);
        BusquedaPersonasBtn2.setBorderPainted(false);
        BusquedaPersonasBtn2.setContentAreaFilled(false);
        BusquedaPersonasBtn2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BusquedaPersonasBtn2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BusquedaPersonasBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BusquedaPersonasBtn2ActionPerformed(evt);
            }
        });

        BusquedaComunidadesBtn2.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        BusquedaComunidadesBtn2.setForeground(new java.awt.Color(204, 204, 204));
        BusquedaComunidadesBtn2.setText("Comunidades");
        BusquedaComunidadesBtn2.setToolTipText("");
        BusquedaComunidadesBtn2.setBorder(null);
        BusquedaComunidadesBtn2.setBorderPainted(false);
        BusquedaComunidadesBtn2.setContentAreaFilled(false);
        BusquedaComunidadesBtn2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BusquedaComunidadesBtn2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BusquedaComunidadesBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BusquedaComunidadesBtn2ActionPerformed(evt);
            }
        });

        BusquedaYapsBtn2.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        BusquedaYapsBtn2.setForeground(new java.awt.Color(204, 204, 204));
        BusquedaYapsBtn2.setText("Yap's");
        BusquedaYapsBtn2.setToolTipText("");
        BusquedaYapsBtn2.setBorder(null);
        BusquedaYapsBtn2.setBorderPainted(false);
        BusquedaYapsBtn2.setContentAreaFilled(false);
        BusquedaYapsBtn2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BusquedaYapsBtn2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BusquedaYapsBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BusquedaYapsBtn2ActionPerformed(evt);
            }
        });

        SeguridadYAccesoBtn10.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        SeguridadYAccesoBtn10.setForeground(new java.awt.Color(204, 204, 204));
        SeguridadYAccesoBtn10.setToolTipText("");
        SeguridadYAccesoBtn10.setBorder(null);
        SeguridadYAccesoBtn10.setBorderPainted(false);
        SeguridadYAccesoBtn10.setContentAreaFilled(false);
        SeguridadYAccesoBtn10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SeguridadYAccesoBtn10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        SeguridadYAccesoBtn10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SeguridadYAccesoBtn10ActionPerformed(evt);
            }
        });

        SeguridadYAccesoBtn2.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        SeguridadYAccesoBtn2.setForeground(new java.awt.Color(204, 204, 204));
        SeguridadYAccesoBtn2.setText("Le gusta");
        SeguridadYAccesoBtn2.setToolTipText("");
        SeguridadYAccesoBtn2.setBorder(null);
        SeguridadYAccesoBtn2.setBorderPainted(false);
        SeguridadYAccesoBtn2.setContentAreaFilled(false);
        SeguridadYAccesoBtn2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SeguridadYAccesoBtn2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        SeguridadYAccesoBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SeguridadYAccesoBtn2ActionPerformed(evt);
            }
        });

        BusquedaTodoBtn2.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        BusquedaTodoBtn2.setForeground(new java.awt.Color(204, 204, 204));
        BusquedaTodoBtn2.setText("Todo");
        BusquedaTodoBtn2.setToolTipText("");
        BusquedaTodoBtn2.setBorder(null);
        BusquedaTodoBtn2.setBorderPainted(false);
        BusquedaTodoBtn2.setContentAreaFilled(false);
        BusquedaTodoBtn2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BusquedaTodoBtn2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BusquedaTodoBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BusquedaTodoBtn2ActionPerformed(evt);
            }
        });

        BusquedaEventosBtn2.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        BusquedaEventosBtn2.setForeground(new java.awt.Color(204, 204, 204));
        BusquedaEventosBtn2.setText("Eventos");
        BusquedaEventosBtn2.setToolTipText("");
        BusquedaEventosBtn2.setBorder(null);
        BusquedaEventosBtn2.setBorderPainted(false);
        BusquedaEventosBtn2.setContentAreaFilled(false);
        BusquedaEventosBtn2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BusquedaEventosBtn2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BusquedaEventosBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BusquedaEventosBtn2ActionPerformed(evt);
            }
        });

        BusquedaMultimediaBtn2.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        BusquedaMultimediaBtn2.setForeground(new java.awt.Color(204, 204, 204));
        BusquedaMultimediaBtn2.setText("Multimedia");
        BusquedaMultimediaBtn2.setToolTipText("");
        BusquedaMultimediaBtn2.setBorder(null);
        BusquedaMultimediaBtn2.setBorderPainted(false);
        BusquedaMultimediaBtn2.setContentAreaFilled(false);
        BusquedaMultimediaBtn2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BusquedaMultimediaBtn2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BusquedaMultimediaBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BusquedaMultimediaBtn2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BusquedaTodoBtn2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BusquedaPersonasBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BusquedaComunidadesBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BusquedaYapsBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BusquedaEventosBtn2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BusquedaMultimediaBtn2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SeguridadYAccesoBtn10, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(126, 126, 126)
                .addComponent(SeguridadYAccesoBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BusquedaPersonasBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BusquedaComunidadesBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BusquedaYapsBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SeguridadYAccesoBtn10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SeguridadYAccesoBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BusquedaTodoBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BusquedaEventosBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BusquedaMultimediaBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        SeguirCuentaBtn9.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 60, 490, 40));

        EjemploBusqueda3.setBackground(new java.awt.Color(59, 28, 50));
        EjemploBusqueda3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        EjemploBusqueda3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        UserRes3.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        UserRes3.setForeground(new java.awt.Color(204, 204, 204));
        UserRes3.setText("@Usuario");
        UserRes3.setToolTipText("");
        UserRes3.setBorder(null);
        UserRes3.setBorderPainted(false);
        UserRes3.setContentAreaFilled(false);
        UserRes3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        UserRes3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        UserRes3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserRes3ActionPerformed(evt);
            }
        });

        NombreRes3.setFont(new java.awt.Font("Roboto Black", 1, 22)); // NOI18N
        NombreRes3.setForeground(new java.awt.Color(204, 204, 204));
        NombreRes3.setText("Resultado 1");

        SeguidoresRes3.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        SeguidoresRes3.setForeground(new java.awt.Color(204, 204, 204));
        SeguidoresRes3.setText("Seguidores");
        SeguidoresRes3.setBorder(null);
        SeguidoresRes3.setBorderPainted(false);
        SeguidoresRes3.setContentAreaFilled(false);
        SeguidoresRes3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SeguidoresRes3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        SeguidoresRes3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SeguidoresRes3ActionPerformed(evt);
            }
        });

        NoSeguidoresRes3.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        NoSeguidoresRes3.setForeground(new java.awt.Color(204, 204, 204));
        NoSeguidoresRes3.setText("0");
        NoSeguidoresRes3.setBorder(null);
        NoSeguidoresRes3.setBorderPainted(false);
        NoSeguidoresRes3.setContentAreaFilled(false);
        NoSeguidoresRes3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        NoSeguidoresRes3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        NoSeguidoresRes3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NoSeguidoresRes3ActionPerformed(evt);
            }
        });

        ImgRes3.setText("img_resultado1");

        javax.swing.GroupLayout EjemploBusqueda3Layout = new javax.swing.GroupLayout(EjemploBusqueda3);
        EjemploBusqueda3.setLayout(EjemploBusqueda3Layout);
        EjemploBusqueda3Layout.setHorizontalGroup(
            EjemploBusqueda3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EjemploBusqueda3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ImgRes3, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(EjemploBusqueda3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(EjemploBusqueda3Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(UserRes3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 203, Short.MAX_VALUE)
                        .addComponent(NoSeguidoresRes3, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NombreRes3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SeguidoresRes3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        EjemploBusqueda3Layout.setVerticalGroup(
            EjemploBusqueda3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EjemploBusqueda3Layout.createSequentialGroup()
                .addGroup(EjemploBusqueda3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EjemploBusqueda3Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(NombreRes3, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(UserRes3)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel3)
                        .addGap(0, 4, Short.MAX_VALUE))
                    .addGroup(EjemploBusqueda3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(ImgRes3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EjemploBusqueda3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(EjemploBusqueda3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SeguidoresRes3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NoSeguidoresRes3)))
        );

        SeguirCuentaBtn9.add(EjemploBusqueda3, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 140, 470, 80));

        CumpleBtn2.setBackground(new java.awt.Color(106, 30, 85));
        CumpleBtn2.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        CumpleBtn2.setForeground(new java.awt.Color(204, 204, 204));
        CumpleBtn2.setText(" Cumpleaños");
        CumpleBtn2.setToolTipText("");
        CumpleBtn2.setAlignmentY(0.0F);
        CumpleBtn2.setBorderPainted(false);
        CumpleBtn2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        CumpleBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CumpleBtn2ActionPerformed(evt);
            }
        });
        SeguirCuentaBtn9.add(CumpleBtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 660, 210, 50));

        TusYapsBtn2.setBackground(new java.awt.Color(106, 30, 85));
        TusYapsBtn2.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        TusYapsBtn2.setForeground(new java.awt.Color(204, 204, 204));
        TusYapsBtn2.setText("Tus Yap's");
        TusYapsBtn2.setToolTipText("");
        TusYapsBtn2.setAlignmentY(0.0F);
        TusYapsBtn2.setBorderPainted(false);
        TusYapsBtn2.setHideActionText(true);
        TusYapsBtn2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        TusYapsBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TusYapsBtn2ActionPerformed(evt);
            }
        });
        SeguirCuentaBtn9.add(TusYapsBtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 590, 210, 50));

        AmigosBtn2.setBackground(new java.awt.Color(166, 77, 121));
        AmigosBtn2.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        AmigosBtn2.setForeground(new java.awt.Color(204, 204, 204));
        AmigosBtn2.setText("Amigos");
        AmigosBtn2.setToolTipText("");
        AmigosBtn2.setAlignmentY(0.0F);
        AmigosBtn2.setBorderPainted(false);
        AmigosBtn2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        AmigosBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AmigosBtn2ActionPerformed(evt);
            }
        });
        SeguirCuentaBtn9.add(AmigosBtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 590, 210, 50));

        ConfiBtn2.setBackground(new java.awt.Color(26, 26, 29));
        ConfiBtn2.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        ConfiBtn2.setForeground(new java.awt.Color(204, 204, 204));
        ConfiBtn2.setText("Configuracion");
        ConfiBtn2.setToolTipText("");
        ConfiBtn2.setAlignmentY(0.0F);
        ConfiBtn2.setBorderPainted(false);
        ConfiBtn2.setContentAreaFilled(false);
        ConfiBtn2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ConfiBtn2.setVerifyInputWhenFocusTarget(false);
        ConfiBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfiBtn2ActionPerformed(evt);
            }
        });
        SeguirCuentaBtn9.add(ConfiBtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 420, 260, 40));

        InicioBtn3.setBackground(new java.awt.Color(26, 26, 29));
        InicioBtn3.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        InicioBtn3.setForeground(new java.awt.Color(204, 204, 204));
        InicioBtn3.setText("   Inicio");
        InicioBtn3.setToolTipText("");
        InicioBtn3.setAlignmentY(0.0F);
        InicioBtn3.setBorderPainted(false);
        InicioBtn3.setContentAreaFilled(false);
        InicioBtn3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        InicioBtn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InicioBtn3ActionPerformed(evt);
            }
        });
        SeguirCuentaBtn9.add(InicioBtn3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, 250, 40));

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
        SeguirCuentaBtn9.add(ExplorarBtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, 250, 40));

        ComunidadesBtn2.setBackground(new java.awt.Color(26, 26, 29));
        ComunidadesBtn2.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        ComunidadesBtn2.setForeground(new java.awt.Color(204, 204, 204));
        ComunidadesBtn2.setText("  Comunidades");
        ComunidadesBtn2.setToolTipText("");
        ComunidadesBtn2.setAlignmentY(0.0F);
        ComunidadesBtn2.setBorderPainted(false);
        ComunidadesBtn2.setContentAreaFilled(false);
        ComunidadesBtn2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ComunidadesBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComunidadesBtn2ActionPerformed(evt);
            }
        });
        SeguirCuentaBtn9.add(ComunidadesBtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 240, 250, 40));

        NotificacionesBtn2.setBackground(new java.awt.Color(26, 26, 29));
        NotificacionesBtn2.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        NotificacionesBtn2.setForeground(new java.awt.Color(204, 204, 204));
        NotificacionesBtn2.setText("  Notificaciones");
        NotificacionesBtn2.setToolTipText("");
        NotificacionesBtn2.setAlignmentY(0.0F);
        NotificacionesBtn2.setBorderPainted(false);
        NotificacionesBtn2.setContentAreaFilled(false);
        NotificacionesBtn2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        NotificacionesBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NotificacionesBtn2ActionPerformed(evt);
            }
        });
        SeguirCuentaBtn9.add(NotificacionesBtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 250, 40));

        GuardadoBtn2.setBackground(new java.awt.Color(26, 26, 29));
        GuardadoBtn2.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        GuardadoBtn2.setForeground(new java.awt.Color(204, 204, 204));
        GuardadoBtn2.setText("  Guardados");
        GuardadoBtn2.setToolTipText("");
        GuardadoBtn2.setAlignmentY(0.0F);
        GuardadoBtn2.setBorderPainted(false);
        GuardadoBtn2.setContentAreaFilled(false);
        GuardadoBtn2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        GuardadoBtn2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        GuardadoBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardadoBtn2ActionPerformed(evt);
            }
        });
        SeguirCuentaBtn9.add(GuardadoBtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 300, 250, 40));

        PerfilBtn2.setBackground(new java.awt.Color(26, 26, 29));
        PerfilBtn2.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        PerfilBtn2.setForeground(new java.awt.Color(204, 204, 204));
        PerfilBtn2.setText("  Perfil");
        PerfilBtn2.setToolTipText("");
        PerfilBtn2.setAlignmentY(0.0F);
        PerfilBtn2.setBorderPainted(false);
        PerfilBtn2.setContentAreaFilled(false);
        PerfilBtn2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        PerfilBtn2.setVerifyInputWhenFocusTarget(false);
        PerfilBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PerfilBtn2ActionPerformed(evt);
            }
        });
        SeguirCuentaBtn9.add(PerfilBtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 360, 250, 40));

        jPanel23.setOpaque(false);
        jPanel23.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel23.add(Y_logo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 60, 40));

        SeguirCuentaBtn9.add(jPanel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, 70, 50));

        PostearBtn2.setBackground(new java.awt.Color(166, 77, 121));
        PostearBtn2.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        PostearBtn2.setForeground(new java.awt.Color(204, 204, 204));
        PostearBtn2.setText("Publicacion");
        PostearBtn2.setToolTipText("");
        PostearBtn2.setAlignmentY(0.0F);
        PostearBtn2.setBorderPainted(false);
        PostearBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PostearBtn2ActionPerformed(evt);
            }
        });
        SeguirCuentaBtn9.add(PostearBtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 650, 200, 40));

        PerfilPanel2.setBackground(new java.awt.Color(0, 0, 0));
        PerfilPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        PerfilPanel2.add(Perfil_Img4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 50, 40));

        NombreUsuario2.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        NombreUsuario2.setForeground(new java.awt.Color(204, 204, 204));
        NombreUsuario2.setText("Usuario Ejemplo");
        PerfilPanel2.add(NombreUsuario2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, -1));

        IdUsuario2.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        IdUsuario2.setForeground(new java.awt.Color(106, 30, 85));
        IdUsuario2.setText("@Usuario1");
        PerfilPanel2.add(IdUsuario2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, -1, -1));

        jButton3.setBackground(new java.awt.Color(106, 30, 85));
        jButton3.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jButton3.setForeground(new java.awt.Color(106, 30, 85));
        jButton3.setText("...");
        jButton3.setAlignmentY(0.0F);
        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        PerfilPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, 50, 40));

        SeguirCuentaBtn9.add(PerfilPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 720, 270, 60));
        SeguirCuentaBtn9.add(Perfil_Img5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 50, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(SeguirCuentaBtn7, javax.swing.GroupLayout.PREFERRED_SIZE, 1550, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(SeguirCuentaBtn8, javax.swing.GroupLayout.PREFERRED_SIZE, 1550, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(SeguirCuentaBtn9, javax.swing.GroupLayout.PREFERRED_SIZE, 1550, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(SeguirCuentaBtn7, javax.swing.GroupLayout.PREFERRED_SIZE, 820, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SeguirCuentaBtn9, javax.swing.GroupLayout.PREFERRED_SIZE, 1042, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SeguirCuentaBtn8, javax.swing.GroupLayout.PREFERRED_SIZE, 1042, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MencionesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MencionesBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MencionesBtnActionPerformed

    private void PublicacionesBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PublicacionesBtn2ActionPerformed
        
    }//GEN-LAST:event_PublicacionesBtn2ActionPerformed

    private void SeguridadYAccesoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeguridadYAccesoBtnActionPerformed

    }//GEN-LAST:event_SeguridadYAccesoBtnActionPerformed

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

    private void SeguridadYAccesoBtn8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeguridadYAccesoBtn8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SeguridadYAccesoBtn8ActionPerformed

    private void SeguidoresResu4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeguidoresResu4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SeguidoresResu4ActionPerformed

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

    private void MostrarMasTePuedeInteresarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MostrarMasTePuedeInteresarBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MostrarMasTePuedeInteresarBtnActionPerformed

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

    private void MencionesBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MencionesBtn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MencionesBtn1ActionPerformed

    private void CuentaBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CuentaBtn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CuentaBtn1ActionPerformed

    private void BusquedaVerTodoBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BusquedaVerTodoBtn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BusquedaVerTodoBtn1ActionPerformed

    private void CuentaBtn8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CuentaBtn8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CuentaBtn8ActionPerformed

    private void CuentaBtn18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CuentaBtn18ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CuentaBtn18ActionPerformed

    private void CuentaBtn19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CuentaBtn19ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CuentaBtn19ActionPerformed

    private void CuentaBtn21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CuentaBtn21ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CuentaBtn21ActionPerformed

    private void CuentaBtn22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CuentaBtn22ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CuentaBtn22ActionPerformed

    private void CuentaBtn24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CuentaBtn24ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CuentaBtn24ActionPerformed

    private void CuentaBtn9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CuentaBtn9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CuentaBtn9ActionPerformed

    private void TendenciaYapBtn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TendenciaYapBtn3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TendenciaYapBtn3ActionPerformed

    private void MostrarMasTendenciaBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MostrarMasTendenciaBtn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MostrarMasTendenciaBtn1ActionPerformed

    private void CuentaBtn25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CuentaBtn25ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CuentaBtn25ActionPerformed

    private void TendenciaYapBtn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TendenciaYapBtn4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TendenciaYapBtn4ActionPerformed

    private void CuentaBtn26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CuentaBtn26ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CuentaBtn26ActionPerformed

    private void MostrarMasTePuedeInteresarBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MostrarMasTePuedeInteresarBtn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MostrarMasTePuedeInteresarBtn1ActionPerformed

    private void BusquedaPersonasBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BusquedaPersonasBtn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BusquedaPersonasBtn1ActionPerformed

    private void BusquedaComunidadesBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BusquedaComunidadesBtn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BusquedaComunidadesBtn1ActionPerformed

    private void BusquedaYapsBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BusquedaYapsBtn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BusquedaYapsBtn1ActionPerformed

    private void SeguridadYAccesoBtn9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeguridadYAccesoBtn9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SeguridadYAccesoBtn9ActionPerformed

    private void SeguridadYAccesoBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeguridadYAccesoBtn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SeguridadYAccesoBtn1ActionPerformed

    private void BusquedaTodoBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BusquedaTodoBtn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BusquedaTodoBtn1ActionPerformed

    private void BusquedaEventosBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BusquedaEventosBtn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BusquedaEventosBtn1ActionPerformed

    private void BusquedaMultimediaBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BusquedaMultimediaBtn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BusquedaMultimediaBtn1ActionPerformed

    private void UserRes2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserRes2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UserRes2ActionPerformed

    private void SeguidoresRes2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeguidoresRes2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SeguidoresRes2ActionPerformed

    private void NoSeguidoresRes2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NoSeguidoresRes2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NoSeguidoresRes2ActionPerformed

    private void CumpleBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CumpleBtn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CumpleBtn1ActionPerformed

    private void TusYapsBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TusYapsBtn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TusYapsBtn1ActionPerformed

    private void AmigosBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AmigosBtn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AmigosBtn1ActionPerformed

    private void ConfiBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfiBtn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ConfiBtn1ActionPerformed

    private void InicioBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InicioBtn2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InicioBtn2ActionPerformed

    private void ExplorarBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExplorarBtn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ExplorarBtn1ActionPerformed

    private void ComunidadesBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComunidadesBtn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComunidadesBtn1ActionPerformed

    private void NotificacionesBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NotificacionesBtn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NotificacionesBtn1ActionPerformed

    private void GuardadoBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardadoBtn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GuardadoBtn1ActionPerformed

    private void PerfilBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PerfilBtn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PerfilBtn1ActionPerformed

    private void PostearBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PostearBtn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PostearBtn1ActionPerformed

    private void MencionesBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MencionesBtn2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MencionesBtn2ActionPerformed

    private void CuentaBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CuentaBtn2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CuentaBtn2ActionPerformed

    private void BusquedaVerTodoBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BusquedaVerTodoBtn2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BusquedaVerTodoBtn2ActionPerformed

    private void CuentaBtn10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CuentaBtn10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CuentaBtn10ActionPerformed

    private void CuentaBtn27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CuentaBtn27ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CuentaBtn27ActionPerformed

    private void CuentaBtn28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CuentaBtn28ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CuentaBtn28ActionPerformed

    private void CuentaBtn29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CuentaBtn29ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CuentaBtn29ActionPerformed

    private void CuentaBtn30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CuentaBtn30ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CuentaBtn30ActionPerformed

    private void CuentaBtn31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CuentaBtn31ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CuentaBtn31ActionPerformed

    private void CuentaBtn11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CuentaBtn11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CuentaBtn11ActionPerformed

    private void TendenciaYapBtn5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TendenciaYapBtn5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TendenciaYapBtn5ActionPerformed

    private void MostrarMasTendenciaBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MostrarMasTendenciaBtn2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MostrarMasTendenciaBtn2ActionPerformed

    private void CuentaBtn32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CuentaBtn32ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CuentaBtn32ActionPerformed

    private void TendenciaYapBtn6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TendenciaYapBtn6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TendenciaYapBtn6ActionPerformed

    private void CuentaBtn33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CuentaBtn33ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CuentaBtn33ActionPerformed

    private void MostrarMasTePuedeInteresarBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MostrarMasTePuedeInteresarBtn2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MostrarMasTePuedeInteresarBtn2ActionPerformed

    private void BusquedaPersonasBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BusquedaPersonasBtn2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BusquedaPersonasBtn2ActionPerformed

    private void BusquedaComunidadesBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BusquedaComunidadesBtn2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BusquedaComunidadesBtn2ActionPerformed

    private void BusquedaYapsBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BusquedaYapsBtn2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BusquedaYapsBtn2ActionPerformed

    private void SeguridadYAccesoBtn10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeguridadYAccesoBtn10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SeguridadYAccesoBtn10ActionPerformed

    private void SeguridadYAccesoBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeguridadYAccesoBtn2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SeguridadYAccesoBtn2ActionPerformed

    private void BusquedaTodoBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BusquedaTodoBtn2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BusquedaTodoBtn2ActionPerformed

    private void BusquedaEventosBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BusquedaEventosBtn2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BusquedaEventosBtn2ActionPerformed

    private void BusquedaMultimediaBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BusquedaMultimediaBtn2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BusquedaMultimediaBtn2ActionPerformed

    private void UserRes3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserRes3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UserRes3ActionPerformed

    private void SeguidoresRes3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeguidoresRes3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SeguidoresRes3ActionPerformed

    private void NoSeguidoresRes3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NoSeguidoresRes3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NoSeguidoresRes3ActionPerformed

    private void CumpleBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CumpleBtn2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CumpleBtn2ActionPerformed

    private void TusYapsBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TusYapsBtn2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TusYapsBtn2ActionPerformed

    private void AmigosBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AmigosBtn2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AmigosBtn2ActionPerformed

    private void ConfiBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfiBtn2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ConfiBtn2ActionPerformed

    private void InicioBtn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InicioBtn3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InicioBtn3ActionPerformed

    private void ExplorarBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExplorarBtn2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ExplorarBtn2ActionPerformed

    private void ComunidadesBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComunidadesBtn2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComunidadesBtn2ActionPerformed

    private void NotificacionesBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NotificacionesBtn2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NotificacionesBtn2ActionPerformed

    private void GuardadoBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardadoBtn2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GuardadoBtn2ActionPerformed

    private void PerfilBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PerfilBtn2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PerfilBtn2ActionPerformed

    private void PostearBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PostearBtn2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PostearBtn2ActionPerformed

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

    private void UserInt3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserInt3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UserInt3ActionPerformed

    private void UserInt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserInt1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UserInt1ActionPerformed

    private void UserInt2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserInt2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UserInt2ActionPerformed

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
    private javax.swing.JButton AmigosBtn1;
    private javax.swing.JButton AmigosBtn2;
    private javax.swing.JLabel AmigosImg1;
    private javax.swing.JButton BarraBusquedaBtn;
    private javax.swing.JButton BarraBusquedaBtn1;
    private javax.swing.JButton BarraBusquedaBtn2;
    private javax.swing.JButton BusquedaComunidadesBtn;
    private javax.swing.JButton BusquedaComunidadesBtn1;
    private javax.swing.JButton BusquedaComunidadesBtn2;
    private javax.swing.JButton BusquedaEventosBtn;
    private javax.swing.JButton BusquedaEventosBtn1;
    private javax.swing.JButton BusquedaEventosBtn2;
    private javax.swing.JButton BusquedaMultimediaBtn;
    private javax.swing.JButton BusquedaMultimediaBtn1;
    private javax.swing.JButton BusquedaMultimediaBtn2;
    private javax.swing.JButton BusquedaPersonasBtn;
    private javax.swing.JButton BusquedaPersonasBtn1;
    private javax.swing.JButton BusquedaPersonasBtn2;
    private javax.swing.JButton BusquedaTodoBtn;
    private javax.swing.JButton BusquedaTodoBtn1;
    private javax.swing.JButton BusquedaTodoBtn2;
    private javax.swing.JButton BusquedaVerTodoBtn;
    private javax.swing.JButton BusquedaVerTodoBtn1;
    private javax.swing.JButton BusquedaVerTodoBtn2;
    private javax.swing.JButton BusquedaYapsBtn;
    private javax.swing.JButton BusquedaYapsBtn1;
    private javax.swing.JButton BusquedaYapsBtn2;
    private javax.swing.JButton ComunidadesBtn;
    private javax.swing.JButton ComunidadesBtn1;
    private javax.swing.JButton ComunidadesBtn2;
    private javax.swing.JButton ConfiBtn;
    private javax.swing.JButton ConfiBtn1;
    private javax.swing.JButton ConfiBtn2;
    private javax.swing.JButton CuentaBtn1;
    private javax.swing.JButton CuentaBtn10;
    private javax.swing.JButton CuentaBtn11;
    private javax.swing.JButton CuentaBtn18;
    private javax.swing.JButton CuentaBtn19;
    private javax.swing.JButton CuentaBtn2;
    private javax.swing.JButton CuentaBtn20;
    private javax.swing.JButton CuentaBtn21;
    private javax.swing.JButton CuentaBtn22;
    private javax.swing.JButton CuentaBtn24;
    private javax.swing.JButton CuentaBtn25;
    private javax.swing.JButton CuentaBtn26;
    private javax.swing.JButton CuentaBtn27;
    private javax.swing.JButton CuentaBtn28;
    private javax.swing.JButton CuentaBtn29;
    private javax.swing.JButton CuentaBtn30;
    private javax.swing.JButton CuentaBtn31;
    private javax.swing.JButton CuentaBtn32;
    private javax.swing.JButton CuentaBtn33;
    private javax.swing.JButton CuentaBtn8;
    private javax.swing.JButton CuentaBtn9;
    private javax.swing.JLabel CumpImg;
    private javax.swing.JButton CumpleBtn;
    private javax.swing.JButton CumpleBtn1;
    private javax.swing.JButton CumpleBtn2;
    private javax.swing.JPanel EjemploBusqueda1;
    private javax.swing.JPanel EjemploBusqueda2;
    private javax.swing.JPanel EjemploBusqueda3;
    private javax.swing.JPanel EjemploBusqueda6;
    private javax.swing.JPanel EjemploBusquedas1;
    private javax.swing.JPanel EjemploBusquedas2;
    private javax.swing.JButton EliminarBusquedasBtn;
    private javax.swing.JButton EliminarBusquedasBtn1;
    private javax.swing.JButton EliminarBusquedasBtn2;
    private javax.swing.JButton ExplorarBtn;
    private javax.swing.JButton ExplorarBtn1;
    private javax.swing.JButton ExplorarBtn2;
    private javax.swing.JButton GuardadoBtn;
    private javax.swing.JButton GuardadoBtn1;
    private javax.swing.JButton GuardadoBtn2;
    private javax.swing.JLabel IdUsuario;
    private javax.swing.JLabel IdUsuario1;
    private javax.swing.JLabel IdUsuario2;
    private javax.swing.JLabel ImgInt1;
    private javax.swing.JLabel ImgInt2;
    private javax.swing.JLabel ImgInt3;
    private javax.swing.JLabel ImgRes1;
    private javax.swing.JLabel ImgRes2;
    private javax.swing.JLabel ImgRes3;
    private javax.swing.JLabel ImgResu2;
    private javax.swing.JLabel ImgResu3;
    private javax.swing.JLabel ImgResu4;
    private javax.swing.JButton InicioBtn1;
    private javax.swing.JButton InicioBtn2;
    private javax.swing.JButton InicioBtn3;
    private javax.swing.JButton MencionesBtn;
    private javax.swing.JButton MencionesBtn1;
    private javax.swing.JButton MencionesBtn2;
    private javax.swing.JLabel MencionesImg;
    private javax.swing.JButton MostrarMasTePuedeInteresarBtn;
    private javax.swing.JButton MostrarMasTePuedeInteresarBtn1;
    private javax.swing.JButton MostrarMasTePuedeInteresarBtn2;
    private javax.swing.JButton MostrarMasTendenciaBtn;
    private javax.swing.JButton MostrarMasTendenciaBtn1;
    private javax.swing.JButton MostrarMasTendenciaBtn2;
    private javax.swing.JButton NoSeguidoresRes2;
    private javax.swing.JButton NoSeguidoresRes3;
    private javax.swing.JButton NoSeguidoresResu1;
    private javax.swing.JButton NoSeguidoresResu2;
    private javax.swing.JButton NoSeguidoresResu3;
    private javax.swing.JButton NoSeguidoresResu4;
    private javax.swing.JLabel NombreRes2;
    private javax.swing.JLabel NombreRes3;
    private javax.swing.JLabel NombreResu1;
    private javax.swing.JLabel NombreResu2;
    private javax.swing.JLabel NombreResu3;
    private javax.swing.JLabel NombreResu4;
    private javax.swing.JLabel NombreUsuario;
    private javax.swing.JLabel NombreUsuario1;
    private javax.swing.JLabel NombreUsuario2;
    private javax.swing.JButton NotificacionesBtn;
    private javax.swing.JButton NotificacionesBtn1;
    private javax.swing.JButton NotificacionesBtn2;
    private javax.swing.JButton PerfilBtn;
    private javax.swing.JButton PerfilBtn1;
    private javax.swing.JButton PerfilBtn2;
    private javax.swing.JPanel PerfilPanel;
    private javax.swing.JPanel PerfilPanel1;
    private javax.swing.JPanel PerfilPanel2;
    private javax.swing.JLabel Perfil_Img;
    private javax.swing.JLabel Perfil_Img1;
    private javax.swing.JLabel Perfil_Img2;
    private javax.swing.JLabel Perfil_Img3;
    private javax.swing.JLabel Perfil_Img4;
    private javax.swing.JLabel Perfil_Img5;
    private javax.swing.JButton PostearBtn;
    private javax.swing.JButton PostearBtn1;
    private javax.swing.JButton PostearBtn2;
    private javax.swing.JButton PublicacionesBtn1;
    private javax.swing.JButton PublicacionesBtn2;
    private javax.swing.JLabel QuePasa;
    private javax.swing.JButton SeguidoresRes2;
    private javax.swing.JButton SeguidoresRes3;
    private javax.swing.JButton SeguidoresResu1;
    private javax.swing.JButton SeguidoresResu2;
    private javax.swing.JButton SeguidoresResu3;
    private javax.swing.JButton SeguidoresResu4;
    private javax.swing.JButton SeguirCuentaBtn1;
    private javax.swing.JButton SeguirCuentaBtn14;
    private javax.swing.JButton SeguirCuentaBtn16;
    private javax.swing.JButton SeguirCuentaBtn17;
    private javax.swing.JButton SeguirCuentaBtn18;
    private javax.swing.JButton SeguirCuentaBtn2;
    private javax.swing.JButton SeguirCuentaBtn3;
    private javax.swing.JPanel SeguirCuentaBtn7;
    private javax.swing.JPanel SeguirCuentaBtn8;
    private javax.swing.JPanel SeguirCuentaBtn9;
    private javax.swing.JButton SeguridadYAccesoBtn;
    private javax.swing.JButton SeguridadYAccesoBtn1;
    private javax.swing.JButton SeguridadYAccesoBtn10;
    private javax.swing.JButton SeguridadYAccesoBtn2;
    private javax.swing.JButton SeguridadYAccesoBtn8;
    private javax.swing.JButton SeguridadYAccesoBtn9;
    private javax.swing.JButton TendenciaYapBtn1;
    private javax.swing.JButton TendenciaYapBtn2;
    private javax.swing.JButton TendenciaYapBtn3;
    private javax.swing.JButton TendenciaYapBtn4;
    private javax.swing.JButton TendenciaYapBtn5;
    private javax.swing.JButton TendenciaYapBtn6;
    private javax.swing.JButton TusYapsBtn;
    private javax.swing.JButton TusYapsBtn1;
    private javax.swing.JButton TusYapsBtn2;
    private javax.swing.JLabel TusYapsImg;
    private javax.swing.JButton UserInt1;
    private javax.swing.JButton UserInt2;
    private javax.swing.JButton UserInt3;
    private javax.swing.JButton UserRes2;
    private javax.swing.JButton UserRes3;
    private javax.swing.JButton UserResu1;
    private javax.swing.JButton UserResu2;
    private javax.swing.JButton UserResu3;
    private javax.swing.JButton UserResu4;
    private javax.swing.JLabel Y_logo;
    private javax.swing.JLabel Y_logo1;
    private javax.swing.JLabel Y_logo2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator15;
    private javax.swing.JSeparator jSeparator16;
    private javax.swing.JSeparator jSeparator17;
    private javax.swing.JSeparator jSeparator18;
    private javax.swing.JSeparator jSeparator19;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator20;
    private javax.swing.JSeparator jSeparator21;
    private javax.swing.JSeparator jSeparator22;
    private javax.swing.JSeparator jSeparator23;
    private javax.swing.JSeparator jSeparator24;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    // End of variables declaration//GEN-END:variables
}
