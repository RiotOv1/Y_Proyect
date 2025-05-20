package com.mycompany.proyect_y;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Conection.DB_Conection;
import java.awt.Color;
import java.awt.Dimension;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;

public class Menu_Principal extends javax.swing.JFrame {
    private PublicacionDAO publicacionDAO;
    private List<Publicacion> publicaciones;
    private int publicacionActual = 0;
    File archivoSeleccionado;
    String UsuarioPubActual;
    
    public Menu_Principal() {
        initComponents();
        this.setLocationRelativeTo(null);
        Img();
        
        publicacionDAO = new PublicacionDAO();
        publicaciones = publicacionDAO.obtenerTodasPublicaciones();
        
        /*if(!publicaciones.isEmpty()){
            mostrarPublicacion(publicaciones.get(publicacionActual));
        }*/

        if (!publicaciones.isEmpty()){
            //Panel 
                int numero = (int) (Math.random() * publicaciones.size()); 
                publicacionActual = numero;
                configurarPanelPublicacion(
                        PanelNot1, publicaciones.get(numero),
                        lblUsuario,Nombre_usuarioBtn,UsuarioPub5,
                        lblTexto_publicacion,Fecha_Label,
                        meGustaBtn, lblLikesLabel,
                        repostearBtn, lblRepostearLabel,ImagenPublicacion_lbl,comentarBtn
                        );
            }
        
        cargarFotoPerfil(); 
        Connection con =  DB_Conection.conectar(); // tu clase de conexión
        String IdUsuario = SesionUsuario.idUsuario; 
        if (IdUsuario != null) {
            String nom = obtenerNombreUsuario();
            NombreUsuario.setText(nom);
            IdUsuario2.setText( "@" + IdUsuario);
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
                public String obtenerNombreUsuario(String id_usuario) {
            String nombre = "";
            String apellido = "";
            Connection con =  DB_Conection.conectar(); // tu clase de conexión
            if (con != null) {
                try {
                    String sql = "SELECT nombre, apellido FROM usuario WHERE id_usuario = ?";
                    PreparedStatement ps = con.prepareStatement(sql);
                    ps.setString(1, id_usuario); // usamos el ID guardado en la sesión
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
        
        public String obtenerIdUsuario() {
            String id_usuario = "";

            Connection con =  DB_Conection.conectar(); // tu clase de conexión
            if (con != null) {
                try {
                    String sql = "SELECT id_usuario FROM usuario WHERE id_usuario = ?";
                    PreparedStatement ps = con.prepareStatement(sql);
                    ps.setString(1, SesionUsuario.idUsuario); // usamos el ID guardado en la sesión
                    ResultSet rs = ps.executeQuery();
                        
                    if (rs.next()) {
                        id_usuario = rs.getString("id_usuario");
                    }

                    rs.close();
                    ps.close();

                } catch (SQLException e) {
            }
        }
        return (id_usuario);
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
                        Image img = icon.getImage().getScaledInstance(Perfil_Img1.getWidth(), Perfil_Img1.getHeight(), Image.SCALE_SMOOTH);
                        Perfil_Img1.setIcon(new ImageIcon(img));
                        Perfil_Img2.setIcon(new ImageIcon(img));
                        
                    } else {
                        Agregar_Img.setText("Sin imagen");
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

        //IconoInicio
        String url1 = "src\\main\\java\\Multimedia\\Icon-Inicio.png";
        ImageIcon image1 = new ImageIcon(url1);
        Image img1 = image1.getImage().getScaledInstance(32, 32, 0);
        ImageIcon Icono1 = new ImageIcon(img1);
        InicioBtn1.setIcon(Icono1);
        
        //+Imagen
        String url12 = "src\\main\\java\\Multimedia\\anadir-imagen.png";
        ImageIcon image12 = new ImageIcon(url12);
        Image img12 = image12.getImage().getScaledInstance(60, 60, 0);
        ImageIcon Icono12 = new ImageIcon(img12);
        Agregar_Img.setIcon(Icono12);

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
    
    boolean bandera_likes = false; //Variable para verificar que no haya likes repetidos
    boolean bandera_repost = false; //Variable para verificar que no haya repost repetidos
        
    
    private void configurarPanelPublicacion(JPanel publi, Publicacion publica,JLabel lblUsuario,JButton nomUsuario ,JButton btnUsuario, JLabel lblTexto,JLabel lblFecha
    ,JButton btnLike, JLabel lblLikes, JButton btnRepost, JLabel lblReposts, JLabel imagen_publi, JButton btnComentarios){
        UsuarioPubActual = publica.getIdUsuario();
        
        if(publica.getMultimediaPubli()==null){
            PanelNot1.setPreferredSize(new Dimension(300, 200));
            PanelNot1.revalidate(); // Reorganiza el layout
            PanelNot1.repaint();    // Redibuja el panel
        }
        
        //Variables locales
        // Configurar iconos iniciales
        String likeIcon = "src\\main\\java\\Multimedia\\Yap-icon.png";
        ImageIcon imageLike = new ImageIcon(likeIcon);
        Image imgLike = imageLike.getImage().getScaledInstance(24, 24, 0);
        ImageIcon IconoLike = new ImageIcon(imgLike);
        btnLike.setIcon(IconoLike);

        String repostIcon = "src\\main\\java\\Multimedia\\ReYap-Icon.png";
        ImageIcon imageRepost = new ImageIcon(repostIcon);
        Image imgRepost = imageRepost.getImage().getScaledInstance(24, 24, 0);
        ImageIcon IconoRepost = new ImageIcon(imgRepost);
        btnRepost.setIcon(IconoRepost);
        
        String comentarioIcon = "src\\main\\java\\Multimedia\\Comentario-icon.png";
        ImageIcon imageComentario = new ImageIcon(comentarioIcon);
        Image imgComentario = imageComentario.getImage().getScaledInstance(24, 24, 0);
        ImageIcon IconoComentario = new ImageIcon(imgComentario);
        btnComentarios.setIcon(IconoComentario);
        
        //Configurar los componentes con los datos de la publicacion
        nomUsuario.setText(obtenerNombreUsuario(publica.getIdUsuario()));
        btnUsuario.setText("@"+publica.getIdUsuario());
        lblTexto.setText(publica.getTexto());
        Timestamp timestamp = publica.getFechaHora();
        LocalDateTime fechaHora = timestamp.toLocalDateTime();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy/MM/dd     HH:mm");
        lblFecha.setText(fechaHora.format(formatter));
        lblLikes.setText(String.valueOf(publica.getNumReacciones()));
        lblReposts.setText(String.valueOf(publica.getNumCompartidos()));
        
        //Configurar imagen de perfil del usurio
        if(publica.getFotoPerfilUsuario()!=null){
            ImageIcon icon = new ImageIcon(publica.getFotoPerfilUsuario());
            Image img  = icon.getImage().getScaledInstance(70,70,Image.SCALE_SMOOTH);
            lblUsuario.setIcon(new ImageIcon(img));
        }else{
            lblUsuario.setIcon(null);
        }
        
        //Configurar imagen de la publicacion
        if(publica.getMultimediaPubli()!=null){
            ImageIcon icono_imagen = new ImageIcon(publica.getMultimediaPubli());
            Image img_publi = icono_imagen.getImage().getScaledInstance(690,310, Image.SCALE_SMOOTH);
            imagen_publi.setIcon(new ImageIcon(img_publi));
        }
        else{
            imagen_publi.setIcon(null);
        }
        
        //Configurar acciones de los botones
        
        btnLike.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!bandera_likes){
                    if (publicacionDAO.darLike(publica.getIdPublicacion())){
                        publica.setNumReacciones(publica.getNumReacciones()+1);
                        lblLikes.setText(String.valueOf(publica.getNumReacciones()));
                        
                        //Cambiar icono del like
                        String likeIcon2 = "src\\main\\java\\Multimedia\\Yap-filled.png";
                        ImageIcon imageLike2 = new ImageIcon(likeIcon2);
                        Image imgLike2 = imageLike2.getImage().getScaledInstance(24, 24, 0);
                        btnLike.setIcon(new ImageIcon(imgLike2));
                        bandera_likes = true;
                    }
                }
                else{
                    if(publicacionDAO.quitarLike(publica.getIdPublicacion())){
                        publica.setNumReacciones(publica.getNumReacciones()-1);
                        lblLikes.setText(String.valueOf(publica.getNumReacciones()));
                        
                        //Cambiar icono de like al original
                        btnLike.setIcon(IconoLike);
                        
                        bandera_likes = false;
                    }
                }
            }
        });
        
        btnRepost.addActionListener(e -> {
            if(!bandera_repost){
                if (publicacionDAO.repostear(publica.getIdPublicacion())) {
                    publica.setNumCompartidos(publica.getNumCompartidos() + 1);
                    lblReposts.setText(String.valueOf(publica.getNumCompartidos()));

                    // Cambiar icono de repost
                    String repostIcon2 = "src\\main\\java\\Multimedia\\ReYap-filled.png";
                    ImageIcon imageRepost2 = new ImageIcon(repostIcon2);
                    Image imgRepost2 = imageRepost2.getImage().getScaledInstance(24, 24, 0);
                    btnRepost.setIcon(new ImageIcon(imgRepost2));
                    bandera_repost = true;
                 }
            }
            else{
                if(publicacionDAO.quitarRepost(publica.getIdPublicacion())){
                    publica.setNumCompartidos(publica.getNumCompartidos()-1);
                    lblReposts.setText(String.valueOf(publica.getNumCompartidos()));
                    
                    //Cambiar icono de repost
                    btnRepost.setIcon(IconoRepost);
                    
                    bandera_repost = false;
                }
            }
        });
        
    }
    
    @SuppressWarnings("unchecked")
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
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
        ImagenPublicacion_lbl = new javax.swing.JLabel();
        PerfilPanel = new javax.swing.JPanel();
        NombreUsuario = new javax.swing.JLabel();
        IdUsuario2 = new javax.swing.JLabel();
        Perfil_Img1 = new javax.swing.JLabel();
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
        PublicarBtn = new javax.swing.JButton();
        jSeparator10 = new javax.swing.JSeparator();
        jSeparator11 = new javax.swing.JSeparator();
        Agregar_Img = new javax.swing.JLabel();
        Perfil_Img2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        CrearPublicacionTextArea = new javax.swing.JTextArea();
        ParaTiBtn1 = new javax.swing.JButton();
        SiguiendoBtn1 = new javax.swing.JButton();
        SiguienteBtn = new javax.swing.JButton();
        ConfiBtn = new javax.swing.JButton();
        InicioBtn1 = new javax.swing.JButton();
        NotificacionesBtn = new javax.swing.JButton();
        PerfilBtn = new javax.swing.JButton();
        ExplorarBtn1 = new javax.swing.JButton();
        Y_logo = new javax.swing.JLabel();
        LabelAviso = new javax.swing.JLabel();
        ImgSeleccion = new javax.swing.JLabel();
        AtrasBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

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

        PanelNot1.setBackground(new java.awt.Color(59, 28, 50));
        PanelNot1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        PanelNot1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lblUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lblUsuario.setText("ImgNot");
        lblUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

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

        comentarBtn.setBackground(new java.awt.Color(59, 28, 50));
        comentarBtn.setForeground(new java.awt.Color(255, 255, 255));
        comentarBtn.setText("-");
        comentarBtn.setBorder(null);
        comentarBtn.setBorderPainted(false);
        comentarBtn.setContentAreaFilled(false);
        comentarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comentarBtnActionPerformed(evt);
            }
        });

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

        lblLikesLabel.setForeground(new java.awt.Color(255, 255, 255));
        lblLikesLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLikesLabel.setText("0");

        lblComentarLabel.setForeground(new java.awt.Color(255, 255, 255));
        lblComentarLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblComentarLabel.setText("0");

        lblRepostearLabel.setForeground(new java.awt.Color(255, 255, 255));
        lblRepostearLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRepostearLabel.setText("0");

        Nombre_usuarioBtn.setBackground(new java.awt.Color(59, 28, 50));
        Nombre_usuarioBtn.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        Nombre_usuarioBtn.setForeground(new java.awt.Color(255, 255, 255));
        Nombre_usuarioBtn.setText("Nombre_usuario");
        Nombre_usuarioBtn.setBorder(null);
        Nombre_usuarioBtn.setBorderPainted(false);
        Nombre_usuarioBtn.setContentAreaFilled(false);
        Nombre_usuarioBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Nombre_usuarioBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Nombre_usuarioBtnMousePressed(evt);
            }
        });
        Nombre_usuarioBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Nombre_usuarioBtnActionPerformed(evt);
            }
        });

        UsuarioPub5.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
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

        Fecha_Label.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Fecha_Label.setForeground(new java.awt.Color(255, 255, 255));
        Fecha_Label.setText("Fecha_posts");

        lblTexto_publicacion.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTexto_publicacion.setForeground(new java.awt.Color(255, 255, 255));
        lblTexto_publicacion.setText("Texto_publicacion");

        ImagenPublicacion_lbl.setForeground(new java.awt.Color(255, 255, 255));
        ImagenPublicacion_lbl.setText("No hay imagen");

        javax.swing.GroupLayout PanelNot1Layout = new javax.swing.GroupLayout(PanelNot1);
        PanelNot1.setLayout(PanelNot1Layout);
        PanelNot1Layout.setHorizontalGroup(
            PanelNot1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelNot1Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(lblUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(PanelNot1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelNot1Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(UsuarioPub5))
                    .addGroup(PanelNot1Layout.createSequentialGroup()
                        .addComponent(Nombre_usuarioBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Fecha_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34))))
            .addGroup(PanelNot1Layout.createSequentialGroup()
                .addGroup(PanelNot1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelNot1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(lblTexto_publicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 690, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelNot1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(ImagenPublicacion_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 690, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelNot1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(lblLikesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(meGustaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(lblComentarLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(comentarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(lblRepostearLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(repostearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        PanelNot1Layout.setVerticalGroup(
            PanelNot1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelNot1Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(PanelNot1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelNot1Layout.createSequentialGroup()
                        .addGroup(PanelNot1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Nombre_usuarioBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Fecha_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addComponent(UsuarioPub5)))
                .addGap(10, 10, 10)
                .addComponent(lblTexto_publicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(ImagenPublicacion_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(PanelNot1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLikesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(meGustaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblComentarLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comentarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRepostearLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(repostearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel1.add(PanelNot1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 210, 730, 550));

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

        IdUsuario2.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        IdUsuario2.setForeground(new java.awt.Color(106, 30, 85));
        IdUsuario2.setText("@Usuario1");
        PerfilPanel.add(IdUsuario2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, -1, -1));

        Perfil_Img1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Perfil_Img1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Perfil_Img1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Perfil_Img1MousePressed(evt);
            }
        });
        PerfilPanel.add(Perfil_Img1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 60, 60));

        jPanel1.add(PerfilPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 700, 320, 80));

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
        jPanel1.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 200, 750, 20));

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

        PublicarBtn.setBackground(new java.awt.Color(166, 77, 121));
        PublicarBtn.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        PublicarBtn.setForeground(new java.awt.Color(204, 204, 204));
        PublicarBtn.setText("Publicar");
        PublicarBtn.setToolTipText("");
        PublicarBtn.setAlignmentY(0.0F);
        PublicarBtn.setBorder(null);
        PublicarBtn.setBorderPainted(false);
        PublicarBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PublicarBtn.setDefaultCapable(false);
        PublicarBtn.setFocusPainted(false);
        PublicarBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                PublicarBtnMousePressed(evt);
            }
        });
        PublicarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PublicarBtnActionPerformed(evt);
            }
        });
        jPanel1.add(PublicarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 150, 130, 40));
        jPanel1.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 80, 280, 10));
        jPanel1.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 60, 750, 20));

        Agregar_Img.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Agregar_ImgMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Agregar_ImgMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Agregar_ImgMousePressed(evt);
            }
        });
        jPanel1.add(Agregar_Img, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 80, 60, 60));

        Perfil_Img2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Perfil_Img2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Perfil_Img2MousePressed(evt);
            }
        });
        jPanel1.add(Perfil_Img2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 70, 60, 60));

        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        CrearPublicacionTextArea.setBackground(new java.awt.Color(0, 0, 0));
        CrearPublicacionTextArea.setColumns(20);
        CrearPublicacionTextArea.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        CrearPublicacionTextArea.setForeground(new java.awt.Color(204, 204, 204));
        CrearPublicacionTextArea.setRows(5);
        CrearPublicacionTextArea.setText("Que estás yapeando?");
        CrearPublicacionTextArea.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                CrearPublicacionTextAreaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                CrearPublicacionTextAreaFocusLost(evt);
            }
        });
        jScrollPane1.setViewportView(CrearPublicacionTextArea);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 70, 520, 120));

        ParaTiBtn1.setBackground(new java.awt.Color(0, 0, 0));
        ParaTiBtn1.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        ParaTiBtn1.setForeground(new java.awt.Color(204, 204, 204));
        ParaTiBtn1.setText("Para tí");
        ParaTiBtn1.setToolTipText("");
        ParaTiBtn1.setActionCommand("");
        ParaTiBtn1.setAlignmentY(0.0F);
        ParaTiBtn1.setBorderPainted(false);
        ParaTiBtn1.setContentAreaFilled(false);
        ParaTiBtn1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ParaTiBtn1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ParaTiBtn1.setOpaque(true);
        ParaTiBtn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ParaTiBtn1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ParaTiBtn1MouseExited(evt);
            }
        });
        ParaTiBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ParaTiBtn1ActionPerformed(evt);
            }
        });
        jPanel1.add(ParaTiBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 0, 375, 60));

        SiguiendoBtn1.setBackground(new java.awt.Color(0, 0, 0));
        SiguiendoBtn1.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        SiguiendoBtn1.setForeground(new java.awt.Color(204, 204, 204));
        SiguiendoBtn1.setText("Siguiendo");
        SiguiendoBtn1.setToolTipText("");
        SiguiendoBtn1.setActionCommand("");
        SiguiendoBtn1.setAlignmentY(0.0F);
        SiguiendoBtn1.setBorderPainted(false);
        SiguiendoBtn1.setContentAreaFilled(false);
        SiguiendoBtn1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SiguiendoBtn1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        SiguiendoBtn1.setOpaque(true);
        SiguiendoBtn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SiguiendoBtn1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                SiguiendoBtn1MouseExited(evt);
            }
        });
        SiguiendoBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SiguiendoBtn1ActionPerformed(evt);
            }
        });
        jPanel1.add(SiguiendoBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 0, 380, 60));

        SiguienteBtn.setBackground(new java.awt.Color(0, 0, 0));
        SiguienteBtn.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        SiguienteBtn.setForeground(new java.awt.Color(204, 204, 204));
        SiguienteBtn.setText("Siguiente  >");
        SiguienteBtn.setToolTipText("");
        SiguienteBtn.setActionCommand("");
        SiguienteBtn.setAlignmentY(0.0F);
        SiguienteBtn.setBorderPainted(false);
        SiguienteBtn.setContentAreaFilled(false);
        SiguienteBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SiguienteBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        SiguienteBtn.setOpaque(true);
        SiguienteBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SiguienteBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                SiguienteBtnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                SiguienteBtnMousePressed(evt);
            }
        });
        SiguienteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SiguienteBtnActionPerformed(evt);
            }
        });
        jPanel1.add(SiguienteBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 760, 380, 60));

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
        jPanel1.add(ConfiBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 380, 260, 40));

        InicioBtn1.setBackground(new java.awt.Color(26, 26, 29));
        InicioBtn1.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
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
        jPanel1.add(InicioBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, 250, 40));

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
        jPanel1.add(NotificacionesBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 260, 250, 40));

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
        jPanel1.add(PerfilBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 320, 250, 40));

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
        jPanel1.add(ExplorarBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, 250, 40));
        jPanel1.add(Y_logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, 90, 80));

        LabelAviso.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LabelAviso.setForeground(new java.awt.Color(166, 77, 121));
        jPanel1.add(LabelAviso, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 160, 170, 30));

        ImgSeleccion.setText("jLabel1");
        jPanel1.add(ImgSeleccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 80, 60, 60));

        AtrasBtn.setBackground(new java.awt.Color(0, 0, 0));
        AtrasBtn.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        AtrasBtn.setForeground(new java.awt.Color(204, 204, 204));
        AtrasBtn.setText("<  Atras");
        AtrasBtn.setToolTipText("");
        AtrasBtn.setActionCommand("");
        AtrasBtn.setAlignmentY(0.0F);
        AtrasBtn.setBorderPainted(false);
        AtrasBtn.setContentAreaFilled(false);
        AtrasBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AtrasBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        AtrasBtn.setOpaque(true);
        AtrasBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AtrasBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                AtrasBtnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                AtrasBtnMousePressed(evt);
            }
        });
        AtrasBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AtrasBtnActionPerformed(evt);
            }
        });
        jPanel1.add(AtrasBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 760, 380, 60));

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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 820, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SiguienteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SiguienteBtnActionPerformed
               // TODO add your handling code here:
    }//GEN-LAST:event_SiguienteBtnActionPerformed

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

    private void PublicarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PublicarBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PublicarBtnActionPerformed

    private void meGustaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meGustaBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_meGustaBtnActionPerformed

    private void UsuarioPub5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsuarioPub5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UsuarioPub5ActionPerformed

    private void repostearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_repostearBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_repostearBtnActionPerformed

    private void comentarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comentarBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comentarBtnActionPerformed

    private void SiguienteBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SiguienteBtnMouseExited
        SiguienteBtn.setBackground(Color.BLACK);
        // TODO add your handling code here:
    }//GEN-LAST:event_SiguienteBtnMouseExited

    private void SiguienteBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SiguienteBtnMouseEntered
        SiguienteBtn.setBackground(new java.awt.Color(59, 28, 50));
        // TODO add your handling code here:
    }//GEN-LAST:event_SiguienteBtnMouseEntered

    private void CrearPublicacionTextAreaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CrearPublicacionTextAreaFocusGained
        if (CrearPublicacionTextArea.getText().equals("Que estás yapeando?")) {
        CrearPublicacionTextArea.setText("");
        CrearPublicacionTextArea.setForeground(Color.WHITE); // Color normal del texto
}
        // TODO add your handling code here:
    }//GEN-LAST:event_CrearPublicacionTextAreaFocusGained

    private void CrearPublicacionTextAreaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CrearPublicacionTextAreaFocusLost
    if (CrearPublicacionTextArea.getText().isEmpty()) {
        CrearPublicacionTextArea.setText("Que estás yapeando?");
        CrearPublicacionTextArea.setForeground(Color.GRAY); // Color para el texto fantasma
       }
        // TODO add your handling code here:
    }//GEN-LAST:event_CrearPublicacionTextAreaFocusLost

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        CrearPublicacionTextArea.setText("Que estás yapeando?");
        CrearPublicacionTextArea.setForeground(java.awt.Color.LIGHT_GRAY);
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void ParaTiBtn1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ParaTiBtn1MouseEntered
        ParaTiBtn1.setBackground(new java.awt.Color(59, 28, 50));
        // TODO add your handling code here:
    }//GEN-LAST:event_ParaTiBtn1MouseEntered

    private void ParaTiBtn1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ParaTiBtn1MouseExited
        ParaTiBtn1.setBackground(Color.BLACK);
        // TODO add your handling code here:
    }//GEN-LAST:event_ParaTiBtn1MouseExited

    private void ParaTiBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ParaTiBtn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ParaTiBtn1ActionPerformed

    private void SiguiendoBtn1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SiguiendoBtn1MouseEntered
        SiguiendoBtn1.setBackground(new java.awt.Color(59, 28, 50));
        // TODO add your handling code here:
    }//GEN-LAST:event_SiguiendoBtn1MouseEntered

    private void SiguiendoBtn1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SiguiendoBtn1MouseExited
        SiguiendoBtn1.setBackground(Color.BLACK);
        // TODO add your handling code here:
    }//GEN-LAST:event_SiguiendoBtn1MouseExited

    private void SiguiendoBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SiguiendoBtn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SiguiendoBtn1ActionPerformed

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

    private void Agregar_ImgMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Agregar_ImgMouseEntered
        String url12 = "src\\main\\java\\Multimedia\\anadir-imagenfocus.png";
        ImageIcon image12 = new ImageIcon(url12);
        Image img12 = image12.getImage().getScaledInstance(60, 60, 0);
        ImageIcon Icono12 = new ImageIcon(img12);
        Agregar_Img.setIcon(Icono12);
        // TODO add your handling code here:
    }//GEN-LAST:event_Agregar_ImgMouseEntered

    private void Agregar_ImgMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Agregar_ImgMouseExited
        String url12 = "src\\main\\java\\Multimedia\\anadir-imagen.png";
        ImageIcon image12 = new ImageIcon(url12);
        Image img12 = image12.getImage().getScaledInstance(60, 60, 0);
        ImageIcon Icono12 = new ImageIcon(img12);
        Agregar_Img.setIcon(Icono12);
        // TODO add your handling code here:
    }//GEN-LAST:event_Agregar_ImgMouseExited

    private void SiguienteBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SiguienteBtnMousePressed
        publicacionDAO = new PublicacionDAO();
        publicaciones = publicacionDAO.obtenerTodasPublicaciones();
        bandera_likes = false;
        bandera_repost = false;

        if(publicacionActual<(publicaciones.size()-1)){
            publicacionActual++;
        } else {
            publicacionActual=0;
        }
        
        if (!publicaciones.isEmpty()){
            //Panel 
                configurarPanelPublicacion(
                        PanelNot1, publicaciones.get(publicacionActual),
                        lblUsuario,Nombre_usuarioBtn,UsuarioPub5,
                        lblTexto_publicacion,Fecha_Label,
                        meGustaBtn, lblLikesLabel,
                        repostearBtn, lblRepostearLabel,ImagenPublicacion_lbl,comentarBtn
                        );
            }
        // TODO add your handling code here:
    }//GEN-LAST:event_SiguienteBtnMousePressed

    private void PublicarBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PublicarBtnMousePressed
        
        Connection con =  DB_Conection.conectar(); // tu clase de conexión
        
        int id_publicacion = (int) (Math.random() * 99999);
        String texto = CrearPublicacionTextArea.getText();
        
        LocalDateTime fechaHoraActual = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        int num_reacciones = 0;
        int num_compartidos = 0;
        String id_usuario = obtenerIdUsuario();

        // Guardar en un String
        String Fecha = fechaHoraActual.format(formatter);
                
        // Convertir a java.sql.Date
        LocalDate localDate = LocalDate.parse(Fecha, formatter);
        java.sql.Date fechaSQL = java.sql.Date.valueOf(localDate);
 
        if (con == null) {
            LabelAviso.setText("Error: La conexión a la base de datos no está funcionando.");
            return;
        } else {
            LabelAviso.setText("Conexión exitosa a la base de datos.");
        }
        Timestamp timestamp = Timestamp.valueOf(fechaHoraActual);
        try {
            // Consulta SQL para insertar un nuevo usuario
            String sql = "INSERT INTO publicacion (id_publicacion, texto, multimedia_publi, fecha_hora, num_reacciones, num_compartidos , id_usuario) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id_publicacion);
            ps.setString(2, texto);
            ps.setString(3, null);
            ps.setTimestamp(4, timestamp);
            ps.setInt(5, num_reacciones);
            ps.setInt(6, num_compartidos);
            ps.setString(7, id_usuario);
            
            if(archivoSeleccionado!=null){            
                FileInputStream fis = new FileInputStream(archivoSeleccionado);
                ps.setBinaryStream(3, fis, (int) archivoSeleccionado.length());
            }
            
            int filasInsertadas = ps.executeUpdate();// Ejecutar la consulta
        
            if (filasInsertadas > 0) {
                LabelAviso.setText("Haz publicado");
                publicacionDAO = new PublicacionDAO();
                publicaciones = publicacionDAO.obtenerTodasPublicaciones();
        
                    if (!publicaciones.isEmpty()){
                        //Panel 
                        bandera_likes = false;
                        bandera_repost = false;
                        configurarPanelPublicacion(
                        PanelNot1, publicaciones.getFirst(),
                        lblUsuario,Nombre_usuarioBtn,UsuarioPub5,
                        lblTexto_publicacion,Fecha_Label,
                        meGustaBtn, lblLikesLabel,
                        repostearBtn, lblRepostearLabel,ImagenPublicacion_lbl,comentarBtn
                        );
            }
            } else {
                LabelAviso.setText( "Error al registrar publicacion");
            }
        } catch (SQLException e) {
            System.out.println("Insertando publicación con:");
            System.out.println("ID: " + id_publicacion);
            System.out.println("Texto: " + texto);
            System.out.println("Usuario: " + id_usuario);
            System.out.println("Fecha: " + timestamp);
            LabelAviso.setText( "Error al registrar publicacion: " + e.getMessage());
            e.printStackTrace(); // <-- esto ayuda mucho
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Menu_Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // TODO add your handling code here:
    }//GEN-LAST:event_PublicarBtnMousePressed

    private void Agregar_ImgMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Agregar_ImgMousePressed
            
        JFileChooser fileChooser = new JFileChooser();
        int resultado = fileChooser.showOpenDialog(this); // 'this' refiere a la ventana actual

        if (resultado == JFileChooser.APPROVE_OPTION) {
        archivoSeleccionado = fileChooser.getSelectedFile();
        System.out.println("Archivo seleccionado: " + archivoSeleccionado.getAbsolutePath());
        // También puedes guardar la ruta en un JLabel o JTextField si quieres
            } else {
            System.out.println("Selección cancelada.");
        }
   
            if (archivoSeleccionado != null) {
            ImageIcon imagen = new ImageIcon(archivoSeleccionado.getAbsolutePath());
            Image imgEscalada = imagen.getImage().getScaledInstance(ImgSeleccion.getWidth(), ImgSeleccion.getHeight(), Image.SCALE_SMOOTH);
            ImgSeleccion.setIcon(new ImageIcon(imgEscalada));
            }
            
        // TODO add your handling code here:
    }//GEN-LAST:event_Agregar_ImgMousePressed

    private void Nombre_usuarioBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Nombre_usuarioBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Nombre_usuarioBtnActionPerformed

    private void AtrasBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AtrasBtnMouseEntered
        AtrasBtn.setBackground(new java.awt.Color(59, 28, 50));
        // TODO add your handling code here:
    }//GEN-LAST:event_AtrasBtnMouseEntered

    private void AtrasBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AtrasBtnMouseExited
        AtrasBtn.setBackground(Color.BLACK);
        // TODO add your handling code here:
    }//GEN-LAST:event_AtrasBtnMouseExited

    private void AtrasBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AtrasBtnMousePressed
        publicacionDAO = new PublicacionDAO();
        publicaciones = publicacionDAO.obtenerTodasPublicaciones();
        bandera_likes = false;
        bandera_repost = false;

        if(publicacionActual>0){
            publicacionActual--;
        } else {
            publicacionActual=publicaciones.size()-1;
        }
        
        if (!publicaciones.isEmpty()){
            //Panel 
                configurarPanelPublicacion(
                        PanelNot1, publicaciones.get(publicacionActual),
                        lblUsuario,Nombre_usuarioBtn,UsuarioPub5,
                        lblTexto_publicacion,Fecha_Label,
                        meGustaBtn, lblLikesLabel,
                        repostearBtn, lblRepostearLabel,ImagenPublicacion_lbl,comentarBtn
                        );
            }
        // TODO add your handling code here
    }//GEN-LAST:event_AtrasBtnMousePressed

    private void AtrasBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AtrasBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AtrasBtnActionPerformed

    private void NombreUsuarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NombreUsuarioMousePressed
        this.dispose();
        new Perfil().setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_NombreUsuarioMousePressed

    private void Perfil_Img2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Perfil_Img2MousePressed
        this.dispose();
        new Perfil().setVisible(true);            
        // TODO add your handling code here:
    }//GEN-LAST:event_Perfil_Img2MousePressed

    private void Perfil_Img1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Perfil_Img1MousePressed
        this.dispose();
        new Perfil().setVisible(true);        
        // TODO add your handling code here:
    }//GEN-LAST:event_Perfil_Img1MousePressed

    private void Nombre_usuarioBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Nombre_usuarioBtnMousePressed
        this.dispose();
        try {
            new PerfilPersona(UsuarioPubActual).setVisible(true);
            // TODO add your handling code here:
        } catch (SQLException ex) {
            Logger.getLogger(Menu_Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Nombre_usuarioBtnMousePressed

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
    private javax.swing.JLabel Agregar_Img;
    private javax.swing.JButton AtrasBtn;
    private javax.swing.JButton ConfiBtn;
    private javax.swing.JTextArea CrearPublicacionTextArea;
    private javax.swing.JButton CuentaBtn20;
    private javax.swing.JButton ExplorarBtn1;
    private javax.swing.JLabel Fecha_Label;
    private javax.swing.JLabel IdUsuario2;
    private javax.swing.JLabel ImagenPublicacion_lbl;
    private javax.swing.JLabel ImgInt1;
    private javax.swing.JLabel ImgInt2;
    private javax.swing.JLabel ImgInt3;
    private javax.swing.JLabel ImgSeleccion;
    private javax.swing.JButton InicioBtn1;
    private javax.swing.JLabel LabelAviso;
    private javax.swing.JButton MostrarMasInteresBtn;
    private javax.swing.JButton MostrarMasTendenciaBtn;
    private javax.swing.JLabel NombreUsuario;
    private javax.swing.JButton Nombre_usuarioBtn;
    private javax.swing.JButton NotificacionesBtn;
    private javax.swing.JPanel PanelNot1;
    private javax.swing.JButton ParaTiBtn1;
    private javax.swing.JButton PerfilBtn;
    private javax.swing.JPanel PerfilPanel;
    private javax.swing.JLabel Perfil_Img1;
    private javax.swing.JLabel Perfil_Img2;
    private javax.swing.JButton PublicacionesBtn1;
    private javax.swing.JButton PublicacionesBtn2;
    private javax.swing.JButton PublicarBtn;
    private javax.swing.JLabel QuePasa;
    private javax.swing.JButton SeguirCuentaBtn1;
    private javax.swing.JButton SeguirCuentaBtn2;
    private javax.swing.JButton SeguirCuentaBtn3;
    private javax.swing.JButton SiguiendoBtn1;
    private javax.swing.JButton SiguienteBtn;
    private javax.swing.JButton TendenciaYapBtn1;
    private javax.swing.JButton TendenciaYapBtn2;
    private javax.swing.JButton UserInt1;
    private javax.swing.JButton UserInt2;
    private javax.swing.JButton UserInt3;
    private javax.swing.JButton UsuarioPub5;
    private javax.swing.JLabel Y_logo;
    private javax.swing.JButton comentarBtn;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JLabel lblComentarLabel;
    private javax.swing.JLabel lblLikesLabel;
    private javax.swing.JLabel lblRepostearLabel;
    private javax.swing.JLabel lblTexto_publicacion;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JButton meGustaBtn;
    private javax.swing.JButton repostearBtn;
    // End of variables declaration//GEN-END:variables
}
