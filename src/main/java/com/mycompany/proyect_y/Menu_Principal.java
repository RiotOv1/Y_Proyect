package com.mycompany.proyect_y;

import Conection.DBConnection;
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
import java.awt.Graphics;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;

public class Menu_Principal extends javax.swing.JFrame {
    int xMouse;
    int yMouse;
    private PublicacionDAO publicacionDAO;
    private Publicacion publicacionId;
    private List<Publicacion> publicaciones, publicacionesSeguidos;
    private int publicacionActual = 0,publicacionSeguidoActual = 0, publicacionTrend1 = 0, publicacionTrend2 = 0, publicacionTrend3 = 0;
    private String Interes1,Interes2,Interes3;
    File archivoSeleccionado;
    String UsuarioPubActual;
    
    public Menu_Principal() {
        initComponents();
        TipoDePublicaciones.setSelectedIndex(1);
        this.setLocationRelativeTo(null);
        Img();
        ParaTiBtn1.setBackground(new java.awt.Color(59,28,50));
        SeccionTePuedeInteresar();
        SeccionTendencias();
        UsuariosDAO dao = new UsuariosDAO();
        String idUsuario = SesionUsuario.idUsuario; // tu ID logueado
        List<String> lista = dao.obtenerIdsRelacionUsuarios("seguidos", idUsuario); 
        
        publicacionDAO = new PublicacionDAO();
        publicaciones = publicacionDAO.obtenerTodasPublicaciones();
        publicacionesSeguidos = publicacionDAO.obtenerPublicacionesDeSeguidos(lista);
        
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
     
         if (!publicacionesSeguidos.isEmpty()){
                int numero2 = (int) (Math.random() * publicacionesSeguidos.size()); 
                publicacionSeguidoActual = numero2;
                configurarPanelPublicacion(
                        PanelNot2, publicacionesSeguidos.get(numero2),
                        lblUsuario1,Nombre_usuarioBtn1,UsuarioPub6,
                        lblTexto_publicacion1,Fecha_Label1,
                        meGustaBtn1, lblLikesLabel1,
                        repostearBtn1, lblRepostearLabel1,ImagenPublicacion_lbl1,comentarBtn1
                        );
            } else {
             //LabelAviso1.setText("No sigues a nadie :C");
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
    
public void notificarSeguidores(String idUsuarioEmisor, int idPublicacion) {
    Connection con = DB_Conection.conectar();
    try {
        String sqlSeguidores = "SELECT id_seguidor FROM seguidores WHERE id_seguido = ?";
        PreparedStatement psSeguidores = con.prepareStatement(sqlSeguidores);
        psSeguidores.setString(1, SesionUsuario.idUsuario);
        ResultSet rs = psSeguidores.executeQuery();
        while (rs.next()) {
            String idReceptor = rs.getString("id_seguidor");
            String sqlNoti = "INSERT INTO notificacion (id_usuario_receptor, id_usuario_emisor, id_publicacion, tipo) VALUES (?, ?, ?, 'publico')";
           
            PreparedStatement psNoti = con.prepareStatement(sqlNoti);
            
            psNoti.setString(1, idReceptor);
            psNoti.setString(2, SesionUsuario.idUsuario);
            psNoti.setInt(3, idPublicacion);
            psNoti.executeUpdate();

        }

        rs.close();
        psSeguidores.close();

    } catch (SQLException e) {
        e.printStackTrace();
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
    
public void notificarSeguido(String idUsuarioReceptor) {
    Connection con = DB_Conection.conectar();
    String sql = "INSERT INTO notificacion (id_usuario_receptor, id_usuario_emisor, tipo, visto, fecha) " +
                 "VALUES (?, ?, ?, ?, NOW())";
    try (
         PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setString(1, idUsuarioReceptor);
        ps.setString(2, SesionUsuario.idUsuario);
        ps.setString(3, "seguimiento");
        ps.setBoolean(4, false); // false = no visto
        ps.executeUpdate();
        
        ps.close();
        con.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
}
    
    private void configurarPanelPublicacion(JPanel publi, Publicacion publica,JLabel lblUsuario,JButton nomUsuario ,JButton btnUsuario, JLabel lblTexto,JLabel lblFecha
    ,JButton btnLike, JLabel lblLikes, JButton btnRepost, JLabel lblReposts, JLabel imagen_publi, JButton btnComentarios){
        UsuarioPubActual = publica.getIdUsuario();
        
        //Variables locales
        // Configurar iconos iniciales
        String likeIcon = "src\\main\\java\\Multimedia\\Yap-icono.png";
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
                    if (publicacionDAO.darLike(publica.getIdPublicacion(), publica.getIdUsuario())){
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
        TipoDePublicaciones = new javax.swing.JTabbedPane();
        PanelNot2 = new javax.swing.JPanel();
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
        ImagenPublicacion_lbl1 = new javax.swing.JLabel();
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
        QuePasa = new javax.swing.JLabel();
        SeguirCuentaBtn3 = new javax.swing.JButton();
        SeguirCuentaBtn1 = new javax.swing.JButton();
        SeguirCuentaBtn2 = new javax.swing.JButton();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
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
        LabelAviso2 = new javax.swing.JLabel();
        ImgSeleccion = new javax.swing.JLabel();
        AtrasBtn = new javax.swing.JButton();
        Num_Reacciones = new javax.swing.JLabel();
        TendenciaYapBtn1 = new javax.swing.JButton();
        numreacciones1 = new javax.swing.JButton();
        Num_Reacciones1 = new javax.swing.JLabel();
        LabelAviso = new javax.swing.JLabel();
        TendenciaYapBtn2 = new javax.swing.JButton();
        numreacciones2 = new javax.swing.JButton();
        Num_Reacciones2 = new javax.swing.JLabel();
        jSeparator12 = new javax.swing.JSeparator();
        jSeparator13 = new javax.swing.JSeparator();
        jSeparator14 = new javax.swing.JSeparator();
        jSeparator15 = new javax.swing.JSeparator();
        jSeparator16 = new javax.swing.JSeparator();
        Header = new javax.swing.JPanel();
        ExitPane = new javax.swing.JPanel();
        ExitBtn = new javax.swing.JLabel();
        LabelAviso1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setMinimumSize(new java.awt.Dimension(1550, 820));
        jPanel1.setPreferredSize(new java.awt.Dimension(1550, 890));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator1.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator1.setForeground(new java.awt.Color(153, 153, 153));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(383, 50, 20, 1050));

        jSeparator4.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator4.setForeground(new java.awt.Color(153, 153, 153));
        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 50, 10, 1050));

        TipoDePublicaciones.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        TipoDePublicaciones.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);
        TipoDePublicaciones.setToolTipText("");

        PanelNot2.setBackground(new java.awt.Color(59, 28, 50));
        PanelNot2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        PanelNot2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lblUsuario1.setForeground(new java.awt.Color(255, 255, 255));
        lblUsuario1.setText("ImgNot");
        lblUsuario1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        meGustaBtn1.setBackground(new java.awt.Color(59, 28, 50));
        meGustaBtn1.setForeground(new java.awt.Color(255, 255, 255));
        meGustaBtn1.setBorder(null);
        meGustaBtn1.setBorderPainted(false);
        meGustaBtn1.setContentAreaFilled(false);
        meGustaBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                meGustaBtn1ActionPerformed(evt);
            }
        });

        comentarBtn1.setBackground(new java.awt.Color(59, 28, 50));
        comentarBtn1.setForeground(new java.awt.Color(255, 255, 255));
        comentarBtn1.setBorder(null);
        comentarBtn1.setBorderPainted(false);
        comentarBtn1.setContentAreaFilled(false);
        comentarBtn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                comentarBtn1MousePressed(evt);
            }
        });
        comentarBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comentarBtn1ActionPerformed(evt);
            }
        });

        repostearBtn1.setBackground(new java.awt.Color(59, 28, 50));
        repostearBtn1.setForeground(new java.awt.Color(255, 255, 255));
        repostearBtn1.setBorder(null);
        repostearBtn1.setBorderPainted(false);
        repostearBtn1.setContentAreaFilled(false);
        repostearBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                repostearBtn1ActionPerformed(evt);
            }
        });

        lblLikesLabel1.setForeground(new java.awt.Color(255, 255, 255));
        lblLikesLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLikesLabel1.setText("0");

        lblComentarLabel1.setForeground(new java.awt.Color(255, 255, 255));
        lblComentarLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblComentarLabel1.setText("0");

        lblRepostearLabel1.setForeground(new java.awt.Color(255, 255, 255));
        lblRepostearLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRepostearLabel1.setText("0");

        Nombre_usuarioBtn1.setBackground(new java.awt.Color(59, 28, 50));
        Nombre_usuarioBtn1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        Nombre_usuarioBtn1.setForeground(new java.awt.Color(255, 255, 255));
        Nombre_usuarioBtn1.setText("Nombre_usuario");
        Nombre_usuarioBtn1.setBorder(null);
        Nombre_usuarioBtn1.setBorderPainted(false);
        Nombre_usuarioBtn1.setContentAreaFilled(false);
        Nombre_usuarioBtn1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Nombre_usuarioBtn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Nombre_usuarioBtn1MousePressed(evt);
            }
        });
        Nombre_usuarioBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Nombre_usuarioBtn1ActionPerformed(evt);
            }
        });

        UsuarioPub6.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
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

        Fecha_Label1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Fecha_Label1.setForeground(new java.awt.Color(255, 255, 255));
        Fecha_Label1.setText("Fecha_posts");

        lblTexto_publicacion1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTexto_publicacion1.setForeground(new java.awt.Color(255, 255, 255));
        lblTexto_publicacion1.setText("Texto_publicacion");

        ImagenPublicacion_lbl1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ImagenPublicacion_lbl1.setForeground(new java.awt.Color(204, 204, 204));
        ImagenPublicacion_lbl1.setText("Sin multimedia disponible");

        javax.swing.GroupLayout PanelNot2Layout = new javax.swing.GroupLayout(PanelNot2);
        PanelNot2.setLayout(PanelNot2Layout);
        PanelNot2Layout.setHorizontalGroup(
            PanelNot2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelNot2Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(lblUsuario1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(PanelNot2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelNot2Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(UsuarioPub6))
                    .addGroup(PanelNot2Layout.createSequentialGroup()
                        .addComponent(Nombre_usuarioBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Fecha_Label1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14))))
            .addGroup(PanelNot2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(PanelNot2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTexto_publicacion1, javax.swing.GroupLayout.PREFERRED_SIZE, 690, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ImagenPublicacion_lbl1, javax.swing.GroupLayout.PREFERRED_SIZE, 690, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(49, Short.MAX_VALUE))
            .addGroup(PanelNot2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLikesLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(meGustaBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(lblComentarLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(comentarBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(lblRepostearLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(repostearBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        PanelNot2Layout.setVerticalGroup(
            PanelNot2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelNot2Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(PanelNot2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUsuario1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelNot2Layout.createSequentialGroup()
                        .addGroup(PanelNot2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Nombre_usuarioBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Fecha_Label1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addComponent(UsuarioPub6)))
                .addGap(10, 10, 10)
                .addComponent(lblTexto_publicacion1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ImagenPublicacion_lbl1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelNot2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLikesLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(meGustaBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblComentarLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comentarBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRepostearLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(repostearBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        TipoDePublicaciones.addTab("tab1", PanelNot2);

        PanelNot1.setBackground(new java.awt.Color(59, 28, 50));
        PanelNot1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        PanelNot1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lblUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lblUsuario.setText("ImgNot");
        lblUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        meGustaBtn.setBackground(new java.awt.Color(59, 28, 50));
        meGustaBtn.setForeground(new java.awt.Color(255, 255, 255));
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
        comentarBtn.setBorder(null);
        comentarBtn.setBorderPainted(false);
        comentarBtn.setContentAreaFilled(false);
        comentarBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                comentarBtnMousePressed(evt);
            }
        });
        comentarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comentarBtnActionPerformed(evt);
            }
        });

        repostearBtn.setBackground(new java.awt.Color(59, 28, 50));
        repostearBtn.setForeground(new java.awt.Color(255, 255, 255));
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
        UsuarioPub5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                UsuarioPub5MousePressed(evt);
            }
        });
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

        ImagenPublicacion_lbl.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ImagenPublicacion_lbl.setForeground(new java.awt.Color(204, 204, 204));
        ImagenPublicacion_lbl.setText("Sin multimedia disponible");

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
                        .addGap(16, 16, 16))))
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
                .addContainerGap(49, Short.MAX_VALUE))
        );
        PanelNot1Layout.setVerticalGroup(
            PanelNot1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelNot1Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(PanelNot1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelNot1Layout.createSequentialGroup()
                        .addGroup(PanelNot1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
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

        TipoDePublicaciones.addTab("tab1", PanelNot1);

        jPanel1.add(TipoDePublicaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 330, 760, 570));

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

        Perfil_Img1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Perfil_Img1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Perfil_Img1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Perfil_Img1MousePressed(evt);
            }
        });
        PerfilPanel.add(Perfil_Img1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 60, 60));

        jPanel1.add(PerfilPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 760, 320, 80));

        QuePasa.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        QuePasa.setForeground(new java.awt.Color(204, 204, 204));
        QuePasa.setText("Qué pasa");
        jPanel1.add(QuePasa, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 470, 90, 30));

        SeguirCuentaBtn3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        SeguirCuentaBtn3.setText("Seguir");
        SeguirCuentaBtn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SeguirCuentaBtn3ActionPerformed(evt);
            }
        });
        jPanel1.add(SeguirCuentaBtn3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1370, 330, -1, 30));

        SeguirCuentaBtn1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        SeguirCuentaBtn1.setText("Seguir");
        SeguirCuentaBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SeguirCuentaBtn1ActionPerformed(evt);
            }
        });
        jPanel1.add(SeguirCuentaBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1370, 210, -1, 30));

        SeguirCuentaBtn2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        SeguirCuentaBtn2.setText("Seguir");
        SeguirCuentaBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SeguirCuentaBtn2ActionPerformed(evt);
            }
        });
        jPanel1.add(SeguirCuentaBtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1370, 270, -1, 30));

        jSeparator6.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator6.setForeground(new java.awt.Color(153, 153, 153));
        jSeparator6.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 140, 30, 250));

        jSeparator7.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator7.setForeground(new java.awt.Color(153, 153, 153));
        jSeparator7.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 440, 10, 340));
        jPanel1.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 440, 330, 20));
        jPanel1.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 250, 760, 20));

        jLabel40.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(204, 204, 204));
        jLabel40.setText("Te puede interesar");
        jPanel1.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 140, 210, 30));

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
        jPanel1.add(CuentaBtn20, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 450, 80, 20));

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
        jPanel1.add(TendenciaYapBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 510, 310, 60));

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
        jPanel1.add(numreacciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 570, 70, 30));

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
        jPanel1.add(MostrarMasInteresBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1400, 370, 60, 20));

        ImgInt3.setForeground(new java.awt.Color(255, 255, 255));
        ImgInt3.setText("ImgInteres2");
        jPanel1.add(ImgInt3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 320, 60, 60));

        ImgInt1.setForeground(new java.awt.Color(255, 255, 255));
        ImgInt1.setText("ImgInteres1");
        jPanel1.add(ImgInt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 180, 60, 60));

        ImgInt2.setForeground(new java.awt.Color(255, 255, 255));
        ImgInt2.setText("ImgInteres2");
        jPanel1.add(ImgInt2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 250, 60, 60));

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
        jPanel1.add(UserInt3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1280, 330, -1, 30));

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
        jPanel1.add(UserInt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1280, 210, -1, 30));

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
        jPanel1.add(UserInt2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1280, 270, -1, 30));

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
        jPanel1.add(PublicarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 200, 130, 40));
        jPanel1.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 140, 280, 10));
        jPanel1.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 50, 760, 20));

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
        jPanel1.add(Agregar_Img, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 130, 60, 60));

        Perfil_Img2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Perfil_Img2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Perfil_Img2MousePressed(evt);
            }
        });
        jPanel1.add(Perfil_Img2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 130, 60, 60));

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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 130, 520, 120));

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
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ParaTiBtn1MousePressed(evt);
            }
        });
        ParaTiBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ParaTiBtn1ActionPerformed(evt);
            }
        });
        jPanel1.add(ParaTiBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 60, 380, 60));

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
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SiguiendoBtn1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SiguiendoBtn1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                SiguiendoBtn1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                SiguiendoBtn1MousePressed(evt);
            }
        });
        SiguiendoBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SiguiendoBtn1ActionPerformed(evt);
            }
        });
        jPanel1.add(SiguiendoBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 60, 380, 60));

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
        jPanel1.add(SiguienteBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 260, 380, 60));

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
        jPanel1.add(ConfiBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 440, 260, 40));

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
        jPanel1.add(InicioBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, 250, 40));

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
        jPanel1.add(NotificacionesBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 320, 250, 40));

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
        jPanel1.add(PerfilBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 380, 250, 40));

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
        jPanel1.add(ExplorarBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 260, 250, 40));
        jPanel1.add(Y_logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 90, 80));

        LabelAviso2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LabelAviso2.setForeground(new java.awt.Color(166, 77, 121));
        jPanel1.add(LabelAviso2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 390, 250, 40));

        ImgSeleccion.setText("jLabel1");
        jPanel1.add(ImgSeleccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 130, 60, 60));

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
        jPanel1.add(AtrasBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 260, 380, 60));

        Num_Reacciones.setForeground(new java.awt.Color(204, 204, 204));
        Num_Reacciones.setText("10");
        jPanel1.add(Num_Reacciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 570, 30, 30));

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
        jPanel1.add(TendenciaYapBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 600, 310, 60));

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
        jPanel1.add(numreacciones1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 660, 70, 30));

        Num_Reacciones1.setForeground(new java.awt.Color(204, 204, 204));
        Num_Reacciones1.setText("10");
        jPanel1.add(Num_Reacciones1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 660, 30, 30));

        LabelAviso.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LabelAviso.setForeground(new java.awt.Color(166, 77, 121));
        jPanel1.add(LabelAviso, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 120, 140, 40));

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
        jPanel1.add(TendenciaYapBtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 690, 310, 60));

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
        jPanel1.add(numreacciones2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 750, 70, 30));

        Num_Reacciones2.setForeground(new java.awt.Color(204, 204, 204));
        Num_Reacciones2.setText("10");
        jPanel1.add(Num_Reacciones2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 750, 30, 30));
        jPanel1.add(jSeparator12, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 390, 280, 20));

        jSeparator13.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator13.setForeground(new java.awt.Color(153, 153, 153));
        jSeparator13.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator13, new org.netbeans.lib.awtextra.AbsoluteConstraints(1460, 140, 20, 250));
        jPanel1.add(jSeparator14, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 780, 330, 20));

        jSeparator15.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator15.setForeground(new java.awt.Color(153, 153, 153));
        jSeparator15.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator15, new org.netbeans.lib.awtextra.AbsoluteConstraints(1500, 440, 10, 340));
        jPanel1.add(jSeparator16, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 120, 760, 20));

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
            .addGap(0, 56, Short.MAX_VALUE)
            .addGroup(ExitPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(ExitPaneLayout.createSequentialGroup()
                    .addComponent(ExitBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        LabelAviso1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LabelAviso1.setForeground(new java.awt.Color(166, 77, 121));

        javax.swing.GroupLayout HeaderLayout = new javax.swing.GroupLayout(Header);
        Header.setLayout(HeaderLayout);
        HeaderLayout.setHorizontalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HeaderLayout.createSequentialGroup()
                .addContainerGap(1012, Short.MAX_VALUE)
                .addComponent(LabelAviso1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(398, 398, 398))
            .addGroup(HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HeaderLayout.createSequentialGroup()
                    .addGap(0, 1490, Short.MAX_VALUE)
                    .addComponent(ExitPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        HeaderLayout.setVerticalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeaderLayout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(LabelAviso1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(HeaderLayout.createSequentialGroup()
                    .addGap(2, 2, 2)
                    .addComponent(ExitPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        jPanel1.add(Header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1550, 50));

        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 80, 50, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SiguienteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SiguienteBtnActionPerformed
               // TODO add your handling code here:
    }//GEN-LAST:event_SiguienteBtnActionPerformed

    private void CuentaBtn20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CuentaBtn20ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CuentaBtn20ActionPerformed

    private void TendenciaYapBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TendenciaYapBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TendenciaYapBtnActionPerformed

    private void numreaccionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numreaccionesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numreaccionesActionPerformed

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

    private void PublicarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PublicarBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PublicarBtnActionPerformed

    private void SiguienteBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SiguienteBtnMouseExited
        SiguienteBtn.setBackground(Color.BLACK);
        // TODO add your handling code here:
    }//GEN-LAST:event_SiguienteBtnMouseExited

    private void SiguienteBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SiguienteBtnMouseEntered
        SiguienteBtn.setBackground(new java.awt.Color(166,77,121));
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

        // TODO add your handling code here:
    }//GEN-LAST:event_ParaTiBtn1MouseEntered

    private void ParaTiBtn1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ParaTiBtn1MouseExited

        // TODO add your handling code here:
    }//GEN-LAST:event_ParaTiBtn1MouseExited

    private void ParaTiBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ParaTiBtn1ActionPerformed
        TipoDePublicaciones.setSelectedIndex(1);
        // TODO add your handling code here:
    }//GEN-LAST:event_ParaTiBtn1ActionPerformed

    private void SiguiendoBtn1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SiguiendoBtn1MouseEntered

        // TODO add your handling code here:
    }//GEN-LAST:event_SiguiendoBtn1MouseEntered

    private void SiguiendoBtn1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SiguiendoBtn1MouseExited

        // TODO add your handling code here:
    }//GEN-LAST:event_SiguiendoBtn1MouseExited

    private void SiguiendoBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SiguiendoBtn1ActionPerformed
        TipoDePublicaciones.setSelectedIndex(0);
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
        UsuariosDAO dao = new UsuariosDAO();
        String idUsuario = SesionUsuario.idUsuario; // tu ID logueado
        List<String> lista = dao.obtenerIdsRelacionUsuarios("seguidos", idUsuario);    
        publicacionesSeguidos = publicacionDAO.obtenerPublicacionesDeSeguidos(lista);
        
        bandera_likes = false;
        bandera_repost = false;
        
        if(publicacionActual<(publicaciones.size()-1)){
            publicacionActual++;
        } else {
            publicacionActual=0;
        }
        
        if(publicacionSeguidoActual<(publicacionesSeguidos.size()-1)){
            publicacionSeguidoActual++;
        } else {
            publicacionSeguidoActual=0;
        }
        
        if (!publicacionesSeguidos.isEmpty()){
                configurarPanelPublicacion(
                        PanelNot2, publicacionesSeguidos.get(publicacionSeguidoActual),
                        lblUsuario1,Nombre_usuarioBtn1,UsuarioPub6,
                        lblTexto_publicacion1,Fecha_Label1,
                        meGustaBtn1, lblLikesLabel1,
                        repostearBtn1, lblRepostearLabel1,ImagenPublicacion_lbl1,comentarBtn1
                        );
            }        

        if (!publicaciones.isEmpty()){
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
        
        if(texto.equals("Que estás yapeando?") && archivoSeleccionado==null){
            return;
        }
        
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
            LabelAviso2.setText("Error: La conexión a la base de datos no está funcionando.");
            return;
        } else {
            LabelAviso2.setText("Conexión exitosa a la base de datos.");
        }
        Timestamp timestamp = Timestamp.valueOf(fechaHoraActual);
        try {
            if(texto.equals("Que estás yapeando?")){
            texto="";
                }
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
            }else {
                ImagenPublicacion_lbl.setText("[La publicacion no contiene imagen]");
            }
            
            int filasInsertadas = ps.executeUpdate();// Ejecutar la consulta
        
            if (filasInsertadas > 0) {
                notificarSeguidores(SesionUsuario.idUsuario, id_publicacion);
                LabelAviso2.setText("Haz publicado");
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
                    ImgSeleccion.setBackground(Color.black);
                    archivoSeleccionado = null;
                    
            }
            } else {
                LabelAviso2.setText( "Error al registrar publicacion");
            }
        } catch (SQLException e) {
            System.out.println("Insertando publicación con:");
            System.out.println("ID: " + id_publicacion);
            System.out.println("Texto: " + texto);
            System.out.println("Usuario: " + id_usuario);
            System.out.println("Fecha: " + timestamp);
            LabelAviso2.setText( "Error al registrar publicacion: " + e.getMessage());
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

    private void AtrasBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AtrasBtnMouseEntered
        AtrasBtn.setBackground(new java.awt.Color(166,77,121));
        // TODO add your handling code here:
    }//GEN-LAST:event_AtrasBtnMouseEntered

    private void AtrasBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AtrasBtnMouseExited
        AtrasBtn.setBackground(Color.BLACK);
        // TODO add your handling code here:
    }//GEN-LAST:event_AtrasBtnMouseExited

    private void AtrasBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AtrasBtnMousePressed
        publicacionDAO = new PublicacionDAO();
        publicaciones = publicacionDAO.obtenerTodasPublicaciones();
        UsuariosDAO dao = new UsuariosDAO();
        String idUsuario = SesionUsuario.idUsuario; // tu ID logueado
        List<String> lista = dao.obtenerIdsRelacionUsuarios("seguidos", idUsuario);    
        publicacionesSeguidos = publicacionDAO.obtenerPublicacionesDeSeguidos(lista);
        
        bandera_likes = false;
        bandera_repost = false;

        if(publicacionActual>0){
            publicacionActual--;
        } else {
            publicacionActual=publicaciones.size()-1;
        }
        
        if(publicacionSeguidoActual>0){
            publicacionSeguidoActual--;
        } else {
            publicacionSeguidoActual=publicacionesSeguidos.size()-1;
        }
       
        if (!publicacionesSeguidos.isEmpty()){
                configurarPanelPublicacion(
                        PanelNot2, publicacionesSeguidos.get(publicacionSeguidoActual),
                        lblUsuario1,Nombre_usuarioBtn1,UsuarioPub6,
                        lblTexto_publicacion1,Fecha_Label1,
                        meGustaBtn1, lblLikesLabel1,
                        repostearBtn1, lblRepostearLabel1,ImagenPublicacion_lbl1,comentarBtn1
                        );
            }      
        
        if (!publicaciones.isEmpty()){
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

    private void TendenciaYapBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TendenciaYapBtn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TendenciaYapBtn1ActionPerformed

    private void numreacciones1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numreacciones1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numreacciones1ActionPerformed

    private void meGustaBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meGustaBtn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_meGustaBtn1ActionPerformed

    private void comentarBtn1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comentarBtn1MousePressed
        this.dispose();
        new ComentariosPublicacion().setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_comentarBtn1MousePressed

    private void comentarBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comentarBtn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comentarBtn1ActionPerformed

    private void repostearBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_repostearBtn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_repostearBtn1ActionPerformed

    private void Nombre_usuarioBtn1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Nombre_usuarioBtn1MousePressed
        this.dispose();
        try {
            new PerfilPersona(UsuarioPubActual).setVisible(true);
            // TODO add your handling code here:
        } catch (SQLException ex) {
            Logger.getLogger(Menu_Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_Nombre_usuarioBtn1MousePressed

    private void Nombre_usuarioBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Nombre_usuarioBtn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Nombre_usuarioBtn1ActionPerformed

    private void UsuarioPub6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsuarioPub6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UsuarioPub6ActionPerformed

    private void UsuarioPub5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsuarioPub5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UsuarioPub5ActionPerformed

    private void Nombre_usuarioBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Nombre_usuarioBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Nombre_usuarioBtnActionPerformed

    private void Nombre_usuarioBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Nombre_usuarioBtnMousePressed
        this.dispose();
        try {
            new PerfilPersona(UsuarioPubActual).setVisible(true);
            // TODO add your handling code here:
        } catch (SQLException ex) {
            Logger.getLogger(Menu_Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Nombre_usuarioBtnMousePressed

    private void repostearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_repostearBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_repostearBtnActionPerformed

    private void comentarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comentarBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comentarBtnActionPerformed

    private void comentarBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comentarBtnMousePressed
        this.dispose();
        new ComentariosPublicacion().setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_comentarBtnMousePressed

    private void meGustaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meGustaBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_meGustaBtnActionPerformed

    private void MostrarMasInteresBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MostrarMasInteresBtnMousePressed
        SeccionTePuedeInteresar();
        SeguirCuentaBtn1.setText("Seguir");
        SeguirCuentaBtn1.setEnabled(true);
        
        SeguirCuentaBtn2.setText("Seguir");
        SeguirCuentaBtn2.setEnabled(true);
        
        SeguirCuentaBtn3.setText("Seguir");
        SeguirCuentaBtn3.setEnabled(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_MostrarMasInteresBtnMousePressed

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
                notificarSeguido(idSeguido);
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
                notificarSeguido(idSeguido);
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

    private void SeguirCuentaBtn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeguirCuentaBtn3ActionPerformed
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
                notificarSeguido(idSeguido);
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

    private void UsuarioPub5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UsuarioPub5MousePressed
        this.dispose();
        try {
            new PerfilPersona(UsuarioPubActual).setVisible(true);
            // TODO add your handling code here:
        } catch (SQLException ex) {
            Logger.getLogger(Menu_Principal.class.getName()).log(Level.SEVERE, null, ex);
        }    
        // TODO add your handling code here:
    }//GEN-LAST:event_UsuarioPub5MousePressed

    private void UserInt1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UserInt1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_UserInt1MousePressed

    private void TendenciaYapBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TendenciaYapBtn2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TendenciaYapBtn2ActionPerformed

    private void numreacciones2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numreacciones2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numreacciones2ActionPerformed

    private void TendenciaYapBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TendenciaYapBtnMousePressed
        PublicacionDAO dao = new PublicacionDAO(); // Asegúrate de tener el DAO instanciado

        publicacionId = dao.obtenerPublicacionPorId(publicacionTrend1);
        
        bandera_likes = false;
        bandera_repost = false;      

        if (!publicaciones.isEmpty()){
                configurarPanelPublicacion(
                        PanelNot1, publicacionId,
                        lblUsuario,Nombre_usuarioBtn,UsuarioPub5,
                        lblTexto_publicacion,Fecha_Label,
                        meGustaBtn, lblLikesLabel,
                        repostearBtn, lblRepostearLabel,ImagenPublicacion_lbl,comentarBtn
                        );
            }
        if (!publicaciones.isEmpty()){
                configurarPanelPublicacion(
                        PanelNot2, publicacionId,
                        lblUsuario1,Nombre_usuarioBtn1,UsuarioPub6,
                        lblTexto_publicacion1,Fecha_Label1,
                        meGustaBtn1, lblLikesLabel1,
                        repostearBtn1, lblRepostearLabel1,ImagenPublicacion_lbl1,comentarBtn1
                        );
            }  
        // TODO add your handling code here:
    }//GEN-LAST:event_TendenciaYapBtnMousePressed

    private void TendenciaYapBtn1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TendenciaYapBtn1MousePressed
        PublicacionDAO dao = new PublicacionDAO(); // Asegúrate de tener el DAO instanciado

        publicacionId = dao.obtenerPublicacionPorId(publicacionTrend2);
        
        bandera_likes = false;
        bandera_repost = false;      

        if (!publicaciones.isEmpty()){
                configurarPanelPublicacion(
                        PanelNot1, publicacionId,
                        lblUsuario,Nombre_usuarioBtn,UsuarioPub5,
                        lblTexto_publicacion,Fecha_Label,
                        meGustaBtn, lblLikesLabel,
                        repostearBtn, lblRepostearLabel,ImagenPublicacion_lbl,comentarBtn
                        );
            }
                if (!publicaciones.isEmpty()){
                configurarPanelPublicacion(
                        PanelNot2, publicacionId,
                        lblUsuario1,Nombre_usuarioBtn1,UsuarioPub6,
                        lblTexto_publicacion1,Fecha_Label1,
                        meGustaBtn1, lblLikesLabel1,
                        repostearBtn1, lblRepostearLabel1,ImagenPublicacion_lbl1,comentarBtn1
                        );
            }  
        // TODO add your handling code here:
    }//GEN-LAST:event_TendenciaYapBtn1MousePressed

    private void TendenciaYapBtn2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TendenciaYapBtn2MousePressed
        PublicacionDAO dao = new PublicacionDAO(); // Asegúrate de tener el DAO instanciado

        publicacionId = dao.obtenerPublicacionPorId(publicacionTrend3);
        
        bandera_likes = false;
        bandera_repost = false;      

        if (!publicaciones.isEmpty()){
                configurarPanelPublicacion(
                        PanelNot1, publicacionId,
                        lblUsuario,Nombre_usuarioBtn,UsuarioPub5,
                        lblTexto_publicacion,Fecha_Label,
                        meGustaBtn, lblLikesLabel,
                        repostearBtn, lblRepostearLabel,ImagenPublicacion_lbl,comentarBtn
                        );
            }
                if (!publicaciones.isEmpty()){
                configurarPanelPublicacion(
                        PanelNot2, publicacionId,
                        lblUsuario1,Nombre_usuarioBtn1,UsuarioPub6,
                        lblTexto_publicacion1,Fecha_Label1,
                        meGustaBtn1, lblLikesLabel1,
                        repostearBtn1, lblRepostearLabel1,ImagenPublicacion_lbl1,comentarBtn1
                        );
            }  
        // TODO add your handling code here:
    }//GEN-LAST:event_TendenciaYapBtn2MousePressed

    private void SiguiendoBtn1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SiguiendoBtn1MousePressed

        // TODO add your handling code here:
    }//GEN-LAST:event_SiguiendoBtn1MousePressed

    private void ParaTiBtn1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ParaTiBtn1MousePressed
        ParaTiBtn1.setBackground(new java.awt.Color(59, 28, 50));
        SiguiendoBtn1.setBackground(Color.BLACK);
        // TODO add your handling code here:
    }//GEN-LAST:event_ParaTiBtn1MousePressed

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

    private void SiguiendoBtn1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SiguiendoBtn1MouseClicked
        if(publicacionesSeguidos.isEmpty()){
           LabelAviso1.setText("No sigues a nadie :C");
           TipoDePublicaciones.setSelectedIndex(1);
           return;
        }
        SiguiendoBtn1.setBackground(new java.awt.Color(59, 28, 50));
        ParaTiBtn1.setBackground(Color.BLACK);
        // TODO add your handling code here:
    }//GEN-LAST:event_SiguiendoBtn1MouseClicked

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
    private javax.swing.JLabel ExitBtn;
    private javax.swing.JPanel ExitPane;
    private javax.swing.JButton ExplorarBtn1;
    private javax.swing.JLabel Fecha_Label;
    private javax.swing.JLabel Fecha_Label1;
    private javax.swing.JPanel Header;
    private javax.swing.JLabel IdUsuario2;
    private javax.swing.JLabel ImagenPublicacion_lbl;
    private javax.swing.JLabel ImagenPublicacion_lbl1;
    private javax.swing.JLabel ImgInt1;
    private javax.swing.JLabel ImgInt2;
    private javax.swing.JLabel ImgInt3;
    private javax.swing.JLabel ImgSeleccion;
    private javax.swing.JButton InicioBtn1;
    private javax.swing.JLabel LabelAviso;
    private javax.swing.JLabel LabelAviso1;
    private javax.swing.JLabel LabelAviso2;
    private javax.swing.JButton MostrarMasInteresBtn;
    private javax.swing.JLabel NombreUsuario;
    private javax.swing.JButton Nombre_usuarioBtn;
    private javax.swing.JButton Nombre_usuarioBtn1;
    private javax.swing.JButton NotificacionesBtn;
    private javax.swing.JLabel Num_Reacciones;
    private javax.swing.JLabel Num_Reacciones1;
    private javax.swing.JLabel Num_Reacciones2;
    private javax.swing.JPanel PanelNot1;
    private javax.swing.JPanel PanelNot2;
    private javax.swing.JButton ParaTiBtn1;
    private javax.swing.JButton PerfilBtn;
    private javax.swing.JPanel PerfilPanel;
    private javax.swing.JLabel Perfil_Img1;
    private javax.swing.JLabel Perfil_Img2;
    private javax.swing.JButton PublicarBtn;
    private javax.swing.JLabel QuePasa;
    private javax.swing.JButton SeguirCuentaBtn1;
    private javax.swing.JButton SeguirCuentaBtn2;
    private javax.swing.JButton SeguirCuentaBtn3;
    private javax.swing.JButton SiguiendoBtn1;
    private javax.swing.JButton SiguienteBtn;
    private javax.swing.JButton TendenciaYapBtn;
    private javax.swing.JButton TendenciaYapBtn1;
    private javax.swing.JButton TendenciaYapBtn2;
    private javax.swing.JTabbedPane TipoDePublicaciones;
    private javax.swing.JButton UserInt1;
    private javax.swing.JButton UserInt2;
    private javax.swing.JButton UserInt3;
    private javax.swing.JButton UsuarioPub5;
    private javax.swing.JButton UsuarioPub6;
    private javax.swing.JLabel Y_logo;
    private javax.swing.JButton comentarBtn;
    private javax.swing.JButton comentarBtn1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator15;
    private javax.swing.JSeparator jSeparator16;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JLabel lblComentarLabel;
    private javax.swing.JLabel lblComentarLabel1;
    private javax.swing.JLabel lblLikesLabel;
    private javax.swing.JLabel lblLikesLabel1;
    private javax.swing.JLabel lblRepostearLabel;
    private javax.swing.JLabel lblRepostearLabel1;
    private javax.swing.JLabel lblTexto_publicacion;
    private javax.swing.JLabel lblTexto_publicacion1;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JLabel lblUsuario1;
    private javax.swing.JButton meGustaBtn;
    private javax.swing.JButton meGustaBtn1;
    private javax.swing.JButton numreacciones;
    private javax.swing.JButton numreacciones1;
    private javax.swing.JButton numreacciones2;
    private javax.swing.JButton repostearBtn;
    private javax.swing.JButton repostearBtn1;
    // End of variables declaration//GEN-END:variables
}
