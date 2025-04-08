
package com.mycompany.proyect_y;

import java.awt.Image;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Menu_Principal extends javax.swing.JFrame {
    private PublicacionDAO publicacionDAO;
    private List<Publicacion> publicaciones;
    private int publicacionActual = 0;
    public Menu_Principal() {
        initComponents();
        this.setLocationRelativeTo(null);
        Img();
        
        publicacionDAO = new PublicacionDAO();
        publicaciones = publicacionDAO.obtenerTodasPublicaciones();
        
        /*if(!publicaciones.isEmpty()){
            mostrarPublicacion(publicaciones.get(publicacionActual));
        }*/
        
        //Configuracion de cada panel con su publicacion correspondiente
        if (!publicaciones.isEmpty()){
            //Panel 1
            if(publicaciones.size()>0){
                configurarPanelPublicacion(
                        PanelNot1, publicaciones.get(0),
                        lblUsuario,Nombre_usuarioBtn,UsuarioPub5,
                        lblTexto_publicacion,Fecha_Label,
                        meGustaBtn, lblLikesLabel,
                        repostearBtn, lblRepostearLabel
                        );
            }
            //Panel 2
            if(publicaciones.size()>1){
                configurarPanelPublicacion(
                        PanelNot4,publicaciones.get(1),
                        lblUsuario1, Nombre_usuarioBtn1, UsuarioPub6,
                        lblTexto_publicacion1,Fecha_Label1,
                        meGustaBtn1,lblLikesLabel1,
                        repostearBtn1,lblRepostearLabel1
                );
            }
            
            //Panel 3
            if(publicaciones.size()>2){
                configurarPanelPublicacion(
                        PanelNot5,publicaciones.get(2),
                        lblUsuario2, Nombre_usuarioBtn2, UsuarioPub7,
                        lblTexto_publicacion2, Fecha_Label2,
                        meGustaBtn2, lblLikesLabel2,
                        repostearBtn2,lblRepostearLabel2
                );
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
    
    private void configurarPanelPublicacion(JPanel publi, Publicacion publica,JLabel lblUsuario,JButton nomUsuario ,JButton btnUsuario, JLabel lblTexto,JLabel lblFecha
    ,JButton btnLike, JLabel lblLikes, JButton btnRepost, JLabel lblReposts){
        
        //Configurar los componentes con los datos de la publicacion
        nomUsuario.setText(publica.getIdUsuario());
        btnUsuario.setText("@"+publica.getIdUsuario());
        lblTexto.setText(publica.getTexto());
        lblFecha.setText(publica.getFechaHora().toString());
        lblLikes.setText(String.valueOf(publica.getNumReacciones()));
        lblReposts.setText(String.valueOf(publica.getNumCompartidos()));
        
        //Configurar imagen de perfil del usurio
        if(publica.getFotoPerfilUsuario()!=null){
            ImageIcon icon = new ImageIcon(publica.getFotoPerfilUsuario());
            Image img  = icon.getImage().getScaledInstance(54,54,Image.SCALE_SMOOTH);
            lblUsuario.setIcon(new ImageIcon(img));
        }else{
            lblUsuario.setIcon(null);
        }
        
        //Configurar acciones de los botones
        btnLike.addActionListener(e->{
            if (publicacionDAO.darLike(publica.getIdPublicacion())){
                publica.setNumReacciones(publica.getNumReacciones()+1);
                lblLikes.setText(String.valueOf(publica.getNumReacciones()));
                
                //Cambiar icono del like
                String likeIcon = "src\\main\\java\\Multimedia\\heart-icon-Filled.png";
                ImageIcon imageLike = new ImageIcon(likeIcon);
                Image imgLike = imageLike.getImage().getScaledInstance(24, 24, 0);
                btnLike.setIcon(new ImageIcon(imgLike));
            }
        });
        
        btnRepost.addActionListener(e -> {
            if (publicacionDAO.repostear(publica.getIdPublicacion())) {
                publica.setNumCompartidos(publica.getNumCompartidos() + 1);
                lblReposts.setText(String.valueOf(publica.getNumCompartidos()));

                // Cambiar icono de repost
                String repostIcon = "src\\main\\java\\Multimedia\\repost-icon-High.png";
                ImageIcon imageRepost = new ImageIcon(repostIcon);
                Image imgRepost = imageRepost.getImage().getScaledInstance(24, 24, 0);
                btnRepost.setIcon(new ImageIcon(imgRepost));
             }
        });
        // Configurar iconos iniciales
        String likeIcon = "src\\main\\java\\Multimedia\\heart-icon-noFill.png";
        ImageIcon imageLike = new ImageIcon(likeIcon);
        Image imgLike = imageLike.getImage().getScaledInstance(24, 24, 0);
        btnLike.setIcon(new ImageIcon(imgLike));

        String repostIcon = "src\\main\\java\\Multimedia\\repost-icon-notHigh.png";
        ImageIcon imageRepost = new ImageIcon(repostIcon);
        Image imgRepost = imageRepost.getImage().getScaledInstance(24, 24, 0);
        btnRepost.setIcon(new ImageIcon(imgRepost));
    }
    
    
    /*private void mostrarPublicacion(Publicacion publi){
        Nombre_usuarioBtn.setText(publi.getIdUsuario());
        UsuarioPub5.setText("@"+publi.getIdUsuario());
        lblTexto_publicacion.setText(publi.getTexto());
        Fecha_Label.setText(publi.getFechaHora().toString());
        lblLikesLabel.setText(String.valueOf(publi.getNumReacciones()));
        lblRepostearLabel.setText(String.valueOf(publi.getNumCompartidos()));
        //Icono para el boton de like sin rellenar
        String url15 = "src\\main\\java\\Multimedia\\heart-icon-noFill.png";
        ImageIcon image15 = new ImageIcon(url15);
        Image img15 = image15.getImage().getScaledInstance(24, 24, 0);
        ImageIcon Icono15 = new ImageIcon(img15);
        meGustaBtn.setIcon(Icono15);
        //Icono para el boton de repostear sin pintar
        String url16 = "src\\main\\java\\Multimedia\\repost-icon-notHigh.png";
        ImageIcon image16 = new ImageIcon(url16);
        Image img16 = image16.getImage().getScaledInstance(24, 24, 0);
        ImageIcon Icono16 = new ImageIcon(img16);
        repostearBtn.setIcon(Icono16);
        
        //Configurar imagen de perfil si existe
        if(publi.getFotoPerfilUsuario()!=null){
            ImageIcon icon = new ImageIcon(publi.getFotoPerfilUsuario());
            Image img  = icon.getImage().getScaledInstance(54,54,Image.SCALE_SMOOTH);
            lblUsuario.setIcon(new ImageIcon(img));
        }else{
            lblUsuario.setIcon(null);
        }
        // Configurar imagen de la publicación si existe
        if (publi.getMultimediaPubli() != null) {
            ImageIcon icon = new ImageIcon(publi.getMultimediaPubli());
            Image img = icon.getImage().getScaledInstance(280, 150, Image.SCALE_SMOOTH);
            jLabel2.setIcon(new ImageIcon(img));
        } else {
            jLabel2.setIcon(null);
        }
        
    }*/
    
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
        PanelNot1 = new javax.swing.JPanel();
        lblUsuario = new javax.swing.JLabel();
        meGustaBtn = new javax.swing.JButton();
        comentarBtn = new javax.swing.JButton();
        repostearBtn = new javax.swing.JButton();
        lblLikesLabel = new javax.swing.JLabel();
        lblComentarLabel = new javax.swing.JLabel();
        lblRepostearLabel = new javax.swing.JLabel();
        Nombre_usuarioBtn = new javax.swing.JButton();
        UsuarioPub5 = new javax.swing.JButton();
        Fecha_Label = new javax.swing.JLabel();
        lblTexto_publicacion = new javax.swing.JLabel();
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        PostearBtn = new javax.swing.JButton();
        InicioBtn2 = new javax.swing.JButton();
        IconoParaTi = new javax.swing.JButton();
        PanelNot4 = new javax.swing.JPanel();
        lblUsuario1 = new javax.swing.JLabel();
        meGustaBtn1 = new javax.swing.JButton();
        comentarBtn1 = new javax.swing.JButton();
        repostearBtn1 = new javax.swing.JButton();
        lblLikesLabel1 = new javax.swing.JLabel();
        lblComentarLabel1 = new javax.swing.JLabel();
        lblRepostearLabel1 = new javax.swing.JLabel();
        Nombre_usuarioBtn1 = new javax.swing.JButton();
        UsuarioPub6 = new javax.swing.JButton();
        Fecha_Label1 = new javax.swing.JLabel();
        lblTexto_publicacion1 = new javax.swing.JLabel();
        PanelNot5 = new javax.swing.JPanel();
        lblUsuario2 = new javax.swing.JLabel();
        meGustaBtn2 = new javax.swing.JButton();
        comentarBtn2 = new javax.swing.JButton();
        repostearBtn2 = new javax.swing.JButton();
        lblLikesLabel2 = new javax.swing.JLabel();
        lblComentarLabel2 = new javax.swing.JLabel();
        lblRepostearLabel2 = new javax.swing.JLabel();
        Nombre_usuarioBtn2 = new javax.swing.JButton();
        UsuarioPub7 = new javax.swing.JButton();
        Fecha_Label2 = new javax.swing.JLabel();
        lblTexto_publicacion2 = new javax.swing.JLabel();

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

        PanelNot1.setBackground(new java.awt.Color(59, 28, 50));
        PanelNot1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        PanelNot1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PanelNot1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lblUsuario.setText("ImgNot");
        PanelNot1.add(lblUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 54, 54));

        meGustaBtn.setBackground(new java.awt.Color(59, 28, 50));
        meGustaBtn.setForeground(new java.awt.Color(255, 255, 255));
        meGustaBtn.setText("-");
        meGustaBtn.setBorder(null);
        meGustaBtn.setBorderPainted(false);
        meGustaBtn.setContentAreaFilled(false);
        meGustaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                meGustaBtnActionPerformed(evt);
            }
        });
        PanelNot1.add(meGustaBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 80, 20));

        comentarBtn.setText("Comentar");
        comentarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comentarBtnActionPerformed(evt);
            }
        });
        PanelNot1.add(comentarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, -1, -1));

        repostearBtn.setBackground(new java.awt.Color(59, 28, 50));
        repostearBtn.setForeground(new java.awt.Color(255, 255, 255));
        repostearBtn.setText("-");
        repostearBtn.setBorder(null);
        repostearBtn.setBorderPainted(false);
        repostearBtn.setContentAreaFilled(false);
        repostearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                repostearBtnActionPerformed(evt);
            }
        });
        PanelNot1.add(repostearBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 150, -1, -1));

        lblLikesLabel.setForeground(new java.awt.Color(255, 255, 255));
        lblLikesLabel.setText("0");
        PanelNot1.add(lblLikesLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 80, -1));

        lblComentarLabel.setForeground(new java.awt.Color(255, 255, 255));
        lblComentarLabel.setText("0");
        PanelNot1.add(lblComentarLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, 80, -1));

        lblRepostearLabel.setForeground(new java.awt.Color(255, 255, 255));
        lblRepostearLabel.setText("0");
        PanelNot1.add(lblRepostearLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 180, 90, -1));

        Nombre_usuarioBtn.setBackground(new java.awt.Color(59, 28, 50));
        Nombre_usuarioBtn.setForeground(new java.awt.Color(255, 255, 255));
        Nombre_usuarioBtn.setText("Nombre_usuario");
        Nombre_usuarioBtn.setBorder(null);
        Nombre_usuarioBtn.setBorderPainted(false);
        Nombre_usuarioBtn.setContentAreaFilled(false);
        PanelNot1.add(Nombre_usuarioBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        UsuarioPub5.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        UsuarioPub5.setForeground(new java.awt.Color(204, 204, 204));
        UsuarioPub5.setText("@Usuario");
        UsuarioPub5.setToolTipText("");
        UsuarioPub5.setBorder(null);
        UsuarioPub5.setBorderPainted(false);
        UsuarioPub5.setContentAreaFilled(false);
        UsuarioPub5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        UsuarioPub5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        UsuarioPub5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsuarioPub5ActionPerformed(evt);
            }
        });
        PanelNot1.add(UsuarioPub5, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, -1, -1));

        Fecha_Label.setForeground(new java.awt.Color(255, 255, 255));
        Fecha_Label.setText("Fecha_posts");
        PanelNot1.add(Fecha_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, 130, -1));

        lblTexto_publicacion.setForeground(new java.awt.Color(255, 255, 255));
        lblTexto_publicacion.setText("Texto_publicacion");
        PanelNot1.add(lblTexto_publicacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 410, 80));

        jPanel1.add(PanelNot1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 140, 450, 200));

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

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ImagenPublicacion1");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 140, 280, 150));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("ImagenPublicacion2");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 350, 280, 150));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("ImagenPublicacion3");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 560, 280, 150));

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

        PanelNot4.setBackground(new java.awt.Color(106, 30, 85));
        PanelNot4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        PanelNot4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PanelNot4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblUsuario1.setForeground(new java.awt.Color(255, 255, 255));
        lblUsuario1.setText("ImgNot");
        PanelNot4.add(lblUsuario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 54, 54));

        meGustaBtn1.setBackground(new java.awt.Color(59, 28, 50));
        meGustaBtn1.setForeground(new java.awt.Color(255, 255, 255));
        meGustaBtn1.setText("-");
        meGustaBtn1.setBorder(null);
        meGustaBtn1.setBorderPainted(false);
        meGustaBtn1.setContentAreaFilled(false);
        meGustaBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                meGustaBtn1ActionPerformed(evt);
            }
        });
        PanelNot4.add(meGustaBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 80, 20));

        comentarBtn1.setText("Comentar");
        PanelNot4.add(comentarBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, -1, -1));

        repostearBtn1.setBackground(new java.awt.Color(59, 28, 50));
        repostearBtn1.setForeground(new java.awt.Color(255, 255, 255));
        repostearBtn1.setText("-");
        repostearBtn1.setBorder(null);
        repostearBtn1.setBorderPainted(false);
        repostearBtn1.setContentAreaFilled(false);
        repostearBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                repostearBtn1ActionPerformed(evt);
            }
        });
        PanelNot4.add(repostearBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 150, -1, -1));

        lblLikesLabel1.setForeground(new java.awt.Color(255, 255, 255));
        lblLikesLabel1.setText("0");
        PanelNot4.add(lblLikesLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 80, -1));

        lblComentarLabel1.setForeground(new java.awt.Color(255, 255, 255));
        lblComentarLabel1.setText("0");
        PanelNot4.add(lblComentarLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, 80, -1));

        lblRepostearLabel1.setForeground(new java.awt.Color(255, 255, 255));
        lblRepostearLabel1.setText("0");
        PanelNot4.add(lblRepostearLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 180, 90, -1));

        Nombre_usuarioBtn1.setBackground(new java.awt.Color(106, 30, 85));
        Nombre_usuarioBtn1.setForeground(new java.awt.Color(255, 255, 255));
        Nombre_usuarioBtn1.setText("Nombre_usuario");
        Nombre_usuarioBtn1.setBorder(null);
        Nombre_usuarioBtn1.setBorderPainted(false);
        Nombre_usuarioBtn1.setContentAreaFilled(false);
        PanelNot4.add(Nombre_usuarioBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        UsuarioPub6.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        UsuarioPub6.setForeground(new java.awt.Color(204, 204, 204));
        UsuarioPub6.setText("@Usuario");
        UsuarioPub6.setToolTipText("");
        UsuarioPub6.setBorder(null);
        UsuarioPub6.setBorderPainted(false);
        UsuarioPub6.setContentAreaFilled(false);
        UsuarioPub6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        UsuarioPub6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        UsuarioPub6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsuarioPub6ActionPerformed(evt);
            }
        });
        PanelNot4.add(UsuarioPub6, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, -1, -1));

        Fecha_Label1.setForeground(new java.awt.Color(255, 255, 255));
        Fecha_Label1.setText("Fecha_posts");
        PanelNot4.add(Fecha_Label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, 130, -1));

        lblTexto_publicacion1.setForeground(new java.awt.Color(255, 255, 255));
        lblTexto_publicacion1.setText("Texto_publicacion");
        PanelNot4.add(lblTexto_publicacion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 410, 80));

        jPanel1.add(PanelNot4, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 350, 450, 200));

        PanelNot5.setBackground(new java.awt.Color(166, 77, 121));
        PanelNot5.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        PanelNot5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PanelNot5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblUsuario2.setForeground(new java.awt.Color(255, 255, 255));
        lblUsuario2.setText("ImgNot");
        lblUsuario2.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                lblUsuario2AncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        PanelNot5.add(lblUsuario2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 54, 54));

        meGustaBtn2.setBackground(new java.awt.Color(59, 28, 50));
        meGustaBtn2.setForeground(new java.awt.Color(255, 255, 255));
        meGustaBtn2.setText("-");
        meGustaBtn2.setBorder(null);
        meGustaBtn2.setBorderPainted(false);
        meGustaBtn2.setContentAreaFilled(false);
        meGustaBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                meGustaBtn2ActionPerformed(evt);
            }
        });
        PanelNot5.add(meGustaBtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 80, 20));

        comentarBtn2.setText("Comentar");
        PanelNot5.add(comentarBtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, -1, -1));

        repostearBtn2.setBackground(new java.awt.Color(59, 28, 50));
        repostearBtn2.setForeground(new java.awt.Color(255, 255, 255));
        repostearBtn2.setText("-");
        repostearBtn2.setBorder(null);
        repostearBtn2.setBorderPainted(false);
        repostearBtn2.setContentAreaFilled(false);
        repostearBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                repostearBtn2ActionPerformed(evt);
            }
        });
        PanelNot5.add(repostearBtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 150, -1, -1));

        lblLikesLabel2.setForeground(new java.awt.Color(255, 255, 255));
        lblLikesLabel2.setText("0");
        PanelNot5.add(lblLikesLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 80, -1));

        lblComentarLabel2.setForeground(new java.awt.Color(255, 255, 255));
        lblComentarLabel2.setText("0");
        PanelNot5.add(lblComentarLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, 80, -1));

        lblRepostearLabel2.setForeground(new java.awt.Color(255, 255, 255));
        lblRepostearLabel2.setText("0");
        PanelNot5.add(lblRepostearLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 180, 90, -1));

        Nombre_usuarioBtn2.setBackground(new java.awt.Color(106, 30, 85));
        Nombre_usuarioBtn2.setForeground(new java.awt.Color(255, 255, 255));
        Nombre_usuarioBtn2.setText("Nombre_usuario");
        Nombre_usuarioBtn2.setBorder(null);
        Nombre_usuarioBtn2.setBorderPainted(false);
        Nombre_usuarioBtn2.setContentAreaFilled(false);
        PanelNot5.add(Nombre_usuarioBtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        UsuarioPub7.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        UsuarioPub7.setForeground(new java.awt.Color(204, 204, 204));
        UsuarioPub7.setText("@Usuario");
        UsuarioPub7.setToolTipText("");
        UsuarioPub7.setBorder(null);
        UsuarioPub7.setBorderPainted(false);
        UsuarioPub7.setContentAreaFilled(false);
        UsuarioPub7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        UsuarioPub7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        UsuarioPub7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsuarioPub7ActionPerformed(evt);
            }
        });
        PanelNot5.add(UsuarioPub7, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, -1, -1));

        Fecha_Label2.setForeground(new java.awt.Color(255, 255, 255));
        Fecha_Label2.setText("Fecha_posts");
        PanelNot5.add(Fecha_Label2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, 130, -1));

        lblTexto_publicacion2.setForeground(new java.awt.Color(255, 255, 255));
        lblTexto_publicacion2.setText("Texto_publicacion");
        PanelNot5.add(lblTexto_publicacion2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 410, 80));

        jPanel1.add(PanelNot5, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 560, 450, 200));

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
                .addGap(0, 12, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 820, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void ConfiBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfiBtnActionPerformed
        
       this.dispose();
       new Configuracion().setVisible(true); // TODO add your handling code here:
    }//GEN-LAST:event_ConfiBtnActionPerformed

    private void InicioBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InicioBtn1ActionPerformed
              this.dispose();
       new Menu_Principal().setVisible(true);  // TODO add your handling code here:
    }//GEN-LAST:event_InicioBtn1ActionPerformed

    private void ExplorarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExplorarBtnActionPerformed
       this.dispose();
       new Explorar().setVisible(true);         // TODO add your handling code here:
    }//GEN-LAST:event_ExplorarBtnActionPerformed

    private void ComunidadesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComunidadesBtnActionPerformed
               this.dispose();
       new Comunidad().setVisible(true); // TODO add your handling code here:
    }//GEN-LAST:event_ComunidadesBtnActionPerformed

    private void NotificacionesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NotificacionesBtnActionPerformed
               this.dispose();
       new Notificaciones().setVisible(true); // TODO add your handling code here:
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

    private void meGustaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meGustaBtnActionPerformed
        // TODO add your handling code here:
        String likeIcon = "src\\main\\java\\Multimedia\\heart-icon-Filled.png";
        ImageIcon imageLike = new ImageIcon(likeIcon);
        Image imgLike = imageLike.getImage().getScaledInstance(24, 24, 0);
        ImageIcon Icono15 = new ImageIcon(imgLike);
        meGustaBtn.setIcon(Icono15);
         if (!publicaciones.isEmpty()) {
            Publicacion publi = publicaciones.get(publicacionActual);
            if (publicacionDAO.darLike(publi.getIdPublicacion())) {
                // Actualizar el contador
                publi.setNumReacciones(publi.getNumReacciones() + 1);
                lblLikesLabel.setText(String.valueOf(publi.getNumReacciones()));
            }
        }
    }//GEN-LAST:event_meGustaBtnActionPerformed

    private void UsuarioPub5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsuarioPub5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UsuarioPub5ActionPerformed

    private void repostearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_repostearBtnActionPerformed
        // TODO add your handling code here:
        //Cambia el icono cuando se click y sube el contador de la publicacion
        String repostIcon = "src\\main\\java\\Multimedia\\repost-icon-High.png";
        ImageIcon imageRepost = new ImageIcon(repostIcon);
        Image imgRepost = imageRepost.getImage().getScaledInstance(24, 24, 0);
        ImageIcon Icono15 = new ImageIcon(imgRepost);
        repostearBtn.setIcon(Icono15);
        if (!publicaciones.isEmpty()) {
            Publicacion publi = publicaciones.get(publicacionActual);
            if (publicacionDAO.repostear(publi.getIdPublicacion())) {
                // Actualizar el contador
                publi.setNumCompartidos(publi.getNumCompartidos() + 1);
                lblRepostearLabel.setText(String.valueOf(publi.getNumCompartidos()));
            }
        }
    }//GEN-LAST:event_repostearBtnActionPerformed

    private void meGustaBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meGustaBtn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_meGustaBtn1ActionPerformed

    private void repostearBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_repostearBtn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_repostearBtn1ActionPerformed

    private void UsuarioPub6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsuarioPub6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UsuarioPub6ActionPerformed

    private void meGustaBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meGustaBtn2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_meGustaBtn2ActionPerformed

    private void repostearBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_repostearBtn2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_repostearBtn2ActionPerformed

    private void UsuarioPub7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsuarioPub7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UsuarioPub7ActionPerformed

    private void lblUsuario2AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_lblUsuario2AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_lblUsuario2AncestorAdded

    private void comentarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comentarBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comentarBtnActionPerformed

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
    private javax.swing.JButton ExplorarBtn;
    private javax.swing.JLabel Fecha_Label;
    private javax.swing.JLabel Fecha_Label1;
    private javax.swing.JLabel Fecha_Label2;
    private javax.swing.JButton FiltroSeguidores;
    private javax.swing.JButton FiltroTodo;
    private javax.swing.JButton FiltroYaps;
    private javax.swing.JButton GuardadoBtn;
    private javax.swing.JButton IconoParaTi;
    private javax.swing.JLabel IdUsuario2;
    private javax.swing.JLabel ImgInt1;
    private javax.swing.JLabel ImgInt2;
    private javax.swing.JLabel ImgInt3;
    private javax.swing.JButton InicioBtn1;
    private javax.swing.JButton InicioBtn2;
    private javax.swing.JButton MostrarMasInteresBtn;
    private javax.swing.JButton MostrarMasTendenciaBtn;
    private javax.swing.JLabel NombreUsuario;
    private javax.swing.JButton Nombre_usuarioBtn;
    private javax.swing.JButton Nombre_usuarioBtn1;
    private javax.swing.JButton Nombre_usuarioBtn2;
    private javax.swing.JButton NotificacionesBtn;
    private javax.swing.JPanel PanelNot1;
    private javax.swing.JPanel PanelNot4;
    private javax.swing.JPanel PanelNot5;
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
    private javax.swing.JButton UsuarioPub5;
    private javax.swing.JButton UsuarioPub6;
    private javax.swing.JButton UsuarioPub7;
    private javax.swing.JLabel Y_logo;
    private javax.swing.JButton comentarBtn;
    private javax.swing.JButton comentarBtn1;
    private javax.swing.JButton comentarBtn2;
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
    private javax.swing.JLabel lblComentarLabel;
    private javax.swing.JLabel lblComentarLabel1;
    private javax.swing.JLabel lblComentarLabel2;
    private javax.swing.JLabel lblLikesLabel;
    private javax.swing.JLabel lblLikesLabel1;
    private javax.swing.JLabel lblLikesLabel2;
    private javax.swing.JLabel lblRepostearLabel;
    private javax.swing.JLabel lblRepostearLabel1;
    private javax.swing.JLabel lblRepostearLabel2;
    private javax.swing.JLabel lblTexto_publicacion;
    private javax.swing.JLabel lblTexto_publicacion1;
    private javax.swing.JLabel lblTexto_publicacion2;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JLabel lblUsuario1;
    private javax.swing.JLabel lblUsuario2;
    private javax.swing.JButton meGustaBtn;
    private javax.swing.JButton meGustaBtn1;
    private javax.swing.JButton meGustaBtn2;
    private javax.swing.JButton repostearBtn;
    private javax.swing.JButton repostearBtn1;
    private javax.swing.JButton repostearBtn2;
    // End of variables declaration//GEN-END:variables
}
