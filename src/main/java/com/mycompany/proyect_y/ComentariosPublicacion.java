
package com.mycompany.proyect_y;

import Conection.DB_Conection;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Duration;
import java.time.Instant;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


public class ComentariosPublicacion extends javax.swing.JFrame {
    private PublicacionDAO publicacionDAO;
    private ComentariosDAO comentariosDAO;
    private List<Publicacion> publicaciones;
    private List<Comentarios> ListaComentarios;
    private int publicacionActual = 0;
    
    public ComentariosPublicacion() {
        initComponents();
        this.setLocationRelativeTo(null);
        Img();
        
        // BuscarComentarios();
        
            PanelComentario1.setVisible(false);
            PanelComentario2.setVisible(false);
            PanelComentario3.setVisible(false);
            PanelComentario4.setVisible(false);
            PanelComentario5.setVisible(false);
            PanelComentario6.setVisible(false);
            PanelComentario7.setVisible(false);
        //Validacion si el usuario tiene un comentario
        if(UsuarioComentario()){
            CasillaComentarios.setVisible(false);
            comentarBtn.setVisible(false);
        }
        else {
            ComentarioExistente.setVisible(false);
            FechaComent.setVisible(false);
            EditarComentario.setVisible(false);
            AlertaEditado.setVisible(false);
        }
        
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
                        repostearBtn, lblRepostearLabel,ImagenPublicacion_lbl,comentarBtn
                        );
            } 
        }
        
        comentariosDAO = new ComentariosDAO();
        ListaComentarios = comentariosDAO.obtenerTodosComentarios();

        if (!ListaComentarios.isEmpty()){
            //Panel 1
            if(ListaComentarios.size()>0){
                PanelComentario1.setVisible(true);
                ConfiguracionPanelComentarios(PanelComentario1,
                        ListaComentarios.get(0),
                        UserComentario2,
                        ComentarioBD1, 
                        DifHors1
                        );
            }
            if(ListaComentarios.size()>1){
                PanelComentario2.setVisible(true);
                ConfiguracionPanelComentarios(PanelComentario2,
                        ListaComentarios.get(1),
                        UserComentario3,
                        ComentarioBD2, 
                        DifHors2
                        );
            }
            if(ListaComentarios.size()>3){
                PanelComentario2.setVisible(true);
                ConfiguracionPanelComentarios(PanelComentario3,
                        ListaComentarios.get(2),
                        UserComentario4,
                        ComentarioBD3, 
                        DifHors3
                        );
            }
            if(ListaComentarios.size()>4){
                PanelComentario2.setVisible(true);
                ConfiguracionPanelComentarios(PanelComentario4,
                        ListaComentarios.get(3),
                        UserComentario5,
                        ComentarioBD4, 
                        DifHors4
                        );
            }
            
        } else
        {
            JOptionPane.showConfirmDialog(null, "No hay Comentarios");
            System.out.println("Sin comentarios");
            PanelComentario1.setVisible(false);
            PanelComentario2.setVisible(false);
            PanelComentario3.setVisible(false);
            PanelComentario4.setVisible(false);
            PanelComentario5.setVisible(false);
            PanelComentario6.setVisible(false);
            PanelComentario7.setVisible(false);
        }
        
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
                        FotoUsuario.setIcon(new ImageIcon(img));
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
    
    public void BuscarComentarios() {  
        try {
            //Conexion a la base de datos
            Connection con = DB_Conection.conectar();
            //Consultar los comentarios
            String sql = "SELECT * FROM comentarios WHERE id_publicacion = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, publicacionDAO.idPubicacion);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){                 
                 // Extrae valores de cada columna
                String U = rs.getString("id_usuario");
                String Comentario = rs.getString("texto");
                byte[] multimediaUsuario = rs.getBytes("foto_perfil");
                // Dentro de tu conexión a la base de datos
                java.sql.Timestamp timestampBD = rs.getTimestamp("fecha_hora");
                Instant horaBD = timestampBD.toInstant(); // Convertir a Instant
                // Obtener la hora actual en UTC
                Instant horaActual = Instant.now();
                
                long diferenciaHoras = Math.abs(Duration.between(horaBD, horaActual).toHours());

                 //Diferencia de tiempo de publicacion del comentario y a la hora que lo ves
                DifHors1.setText(diferenciaHoras + " horas");
                //Formato para que se muestre como texto multilinea
                ComentarioBD1.setText("<html><p>" + Comentario + "</html></p>");

                
                if(multimediaUsuario!=null){
            ImageIcon icon = new ImageIcon(multimediaUsuario);
            Image img  = icon.getImage().getScaledInstance(54,54,Image.SCALE_SMOOTH);
                lblUsuario2.setIcon(new ImageIcon(img));
            }else{
                lblUsuario2.setIcon(null);
            }
            }
              
        } catch (Exception e) {
            System.out.println(e);
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
        
        String urlSalvar = "src\\main\\java\\Multimedia\\Icono_Guardar.png";
        ImageIcon image17 = new ImageIcon(urlSalvar);
        Image img17 = image17.getImage().getScaledInstance(24, 24, 0);
        ImageIcon Icono17 = new ImageIcon(img17);
        GuardarCambio.setIcon(Icono17);
        GuardarCambio.setVisible(false);
 
    }
    boolean bandera_likes = false; //Variable para verificar que no haya likes repetidos
    boolean bandera_repost = false; //Variable para verificar que no haya repost repetidos
    private void configurarPanelPublicacion(JPanel publi, Publicacion publica,JLabel lblUsuario,JButton nomUsuario ,JButton btnUsuario, JLabel lblTexto,JLabel lblFecha
    ,JButton btnLike, JLabel lblLikes, JButton btnRepost, JLabel lblReposts, JLabel imagen_publi, JButton btnComentarios){
        //Variables locales
        
        
        // Configurar iconos iniciales
        String likeIcon = "src\\main\\java\\Multimedia\\heart-icon-noFill.png";
        ImageIcon imageLike = new ImageIcon(likeIcon);
        Image imgLike = imageLike.getImage().getScaledInstance(24, 24, 0);
        ImageIcon IconoLike = new ImageIcon(imgLike);
        btnLike.setIcon(IconoLike);

        String repostIcon = "src\\main\\java\\Multimedia\\repost-icon-notHigh.png";
        ImageIcon imageRepost = new ImageIcon(repostIcon);
        Image imgRepost = imageRepost.getImage().getScaledInstance(24, 24, 0);
        ImageIcon IconoRepost = new ImageIcon(imgRepost);
        btnRepost.setIcon(IconoRepost);
        
        String comentarioIcon = "src\\main\\java\\Multimedia\\Comment-icon-notHigh.png";
        ImageIcon imageComentario = new ImageIcon(comentarioIcon);
        Image imgComentario = imageComentario.getImage().getScaledInstance(24, 24, 0);
        ImageIcon IconoComentario = new ImageIcon(imgComentario);
        btnComentarios.setIcon(IconoComentario);
        
        //Configurar los componentes con los datos de la publicacion
        nomUsuario.setText(publica.getIdUsuario());
        UserOtraves.setText("@"+publica.getIdUsuario());
        btnUsuario.setText("@"+publica.getIdUsuario());
        lblTexto.setText("<html><p>" + publica.getTexto() + "</html></p>");
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
        
        //Configurar imagen de la publicacion
        if(publica.getMultimediaPubli()!=null){
            ImageIcon icono_imagen = new ImageIcon(publica.getMultimediaPubli());
            Image img_publi = icono_imagen.getImage().getScaledInstance(500,350, Image.SCALE_SMOOTH);
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
                        String likeIcon2 = "src\\main\\java\\Multimedia\\heart-icon-Filled.png";
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
                    String repostIcon2 = "src\\main\\java\\Multimedia\\repost-icon-High.png";
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
    
    //constructor de los comentarios
    private void ConfiguracionPanelComentarios(JPanel PanelComentarios, Comentarios coments, JButton UserComentario2, JLabel ComentarioBD1, JLabel DifHors1){
         //Configurar los componentes con los datos de la publicacion
        UserComentario2.setText("@"+coments.getIdUsuario());
        ComentarioBD1.setText("<html><p>" + coments.getTexto() + "</html></p>");
        
        java.sql.Timestamp timestampBD = coments.getFechaHora();
        Instant horaBD = timestampBD.toInstant();
        Instant horaActual = Instant.now();
        long diferenciaHoras = Math.abs(Duration.between(horaBD, horaActual).toHours());
        DifHors1.setText(diferenciaHoras + " horas");
        
    }
    
    private void CrearComentariosPublicaciones(){
        try {
            Connection con = DB_Conection.conectar();
            String ContenidoComentario = CasillaComentarios.getText();
            String sql = "INSERT INTO `comentarios`(`id_usuario`, `id_publicacion`, `texto`) VALUES (?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, SesionUsuario.idUsuario);
            ps.setInt(2, publicacionDAO.idPubicacion);
            ps.setString(3, ContenidoComentario);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public boolean UsuarioComentario(){
        try {
        Connection con = DB_Conection.conectar();
        String sql = "SELECT `texto`, `fecha_hora` FROM `comentarios` WHERE id_usuario = ? AND id_publicacion = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, SesionUsuario.idUsuario);
        ps.setInt(2, publicacionDAO.idPubicacion);
        ResultSet rs = ps.executeQuery();
        
        if(rs.next()){
            String Texto = rs.getString("texto");
            
            java.sql.Timestamp timestampBD = rs.getTimestamp("fecha_hora");
            Instant horaBD = timestampBD.toInstant(); // Convertir a Instant
                // Obtener la hora actual en UTC
            Instant horaActual = Instant.now();
               //Calculo para la diferencia de horas 
            long diferenciaHoras = Math.abs(Duration.between(horaBD, horaActual).toHours());

                 //Diferencia de tiempo de publicacion del comentario y a la hora que lo ves
            ComentarioExistente.setText( Texto);
            FechaComent.setText(diferenciaHoras + " horas");
            return true;
        }
        } catch (Exception e) {
            System.out.println(e);
        }
       return false;
    }
    
    public void EditarComentarioUsuario(){
        try {
        String Comentario =  CasillaComentarios.getText();    
        Connection con = DB_Conection.conectar();
        String sql = "UPDATE comentarios SET texto = ?  WHERE id_usuario = ? AND id_publicacion = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, Comentario);
        ps.setString(2, SesionUsuario.idUsuario);
        ps.setInt(3, PublicacionDAO.idPubicacion);
        ps.executeUpdate();
        UsuarioComentario();
        AlertaEditado.setVisible(true);
        CasillaComentarios.setVisible(false);
        GuardarCambio.setVisible(false);
        ComentarioExistente.setVisible(true);
        EditarComentario.setVisible(true);
        FechaComent.setVisible(true);
        comentarBtn.setVisible(false);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    
    @SuppressWarnings("unchecked")
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        PanelNot1 = new javax.swing.JPanel();
        Fecha_Label = new javax.swing.JLabel();
        lblTexto_publicacion = new javax.swing.JLabel();
        ImagenPublicacion_lbl = new javax.swing.JLabel();
        ConfiBtn = new javax.swing.JButton();
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
        PostearBtn = new javax.swing.JButton();
        InicioBtn2 = new javax.swing.JButton();
        IconoParaTi = new javax.swing.JButton();
        UsuarioPub5 = new javax.swing.JButton();
        Nombre_usuarioBtn = new javax.swing.JButton();
        lblUsuario = new javax.swing.JLabel();
        InformacionPublicacionPanel = new javax.swing.JPanel();
        meGustaBtn = new javax.swing.JButton();
        lblLikesLabel = new javax.swing.JLabel();
        lblComentarLabel = new javax.swing.JLabel();
        repostearBtn = new javax.swing.JButton();
        comentarBtn = new javax.swing.JButton();
        lblRepostearLabel = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator15 = new javax.swing.JSeparator();
        InicioBtn3 = new javax.swing.JButton();
        ComentariosPanel = new javax.swing.JPanel();
        InicioBtn1 = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        PanelComentario1 = new javax.swing.JPanel();
        lblUsuario2 = new javax.swing.JLabel();
        UserComentario2 = new javax.swing.JButton();
        DifHors1 = new javax.swing.JLabel();
        ComentarioBD1 = new javax.swing.JLabel();
        PanelComentario2 = new javax.swing.JPanel();
        lblUsuario3 = new javax.swing.JLabel();
        UserComentario3 = new javax.swing.JButton();
        DifHors2 = new javax.swing.JLabel();
        ComentarioBD2 = new javax.swing.JLabel();
        PanelComentario4 = new javax.swing.JPanel();
        lblUsuario5 = new javax.swing.JLabel();
        UserComentario5 = new javax.swing.JButton();
        DifHors4 = new javax.swing.JLabel();
        ComentarioBD4 = new javax.swing.JLabel();
        PanelComentario7 = new javax.swing.JPanel();
        lblUsuario7 = new javax.swing.JLabel();
        UserComentario7 = new javax.swing.JButton();
        DifHors6 = new javax.swing.JLabel();
        ComentarioBD6 = new javax.swing.JLabel();
        PanelComentario3 = new javax.swing.JPanel();
        lblUsuario4 = new javax.swing.JLabel();
        UserComentario4 = new javax.swing.JButton();
        DifHors3 = new javax.swing.JLabel();
        ComentarioBD3 = new javax.swing.JLabel();
        PanelComentario5 = new javax.swing.JPanel();
        lblUsuario6 = new javax.swing.JLabel();
        UserComentario6 = new javax.swing.JButton();
        DifHors5 = new javax.swing.JLabel();
        ComentarioBD5 = new javax.swing.JLabel();
        PanelComentario6 = new javax.swing.JPanel();
        lblUsuario10 = new javax.swing.JLabel();
        UserComentario10 = new javax.swing.JButton();
        DifHors9 = new javax.swing.JLabel();
        ComentarioBD9 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        FotoUsuario = new javax.swing.JLabel();
        UserOtraves = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        ComentarioExistente = new javax.swing.JLabel();
        EditarComentario = new javax.swing.JButton();
        CasillaComentarios = new javax.swing.JTextField();
        FechaComent = new javax.swing.JLabel();
        AlertaEditado = new javax.swing.JLabel();
        ComentarBtn = new javax.swing.JButton();
        GuardarCambio = new javax.swing.JButton();

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
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 0, 10, 820));

        PanelNot1.setBackground(new java.awt.Color(59, 28, 50));
        PanelNot1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        PanelNot1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PanelNot1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Fecha_Label.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        Fecha_Label.setForeground(new java.awt.Color(255, 255, 255));
        Fecha_Label.setText("Fecha_posts");
        PanelNot1.add(Fecha_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, 530, -1));

        lblTexto_publicacion.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        lblTexto_publicacion.setForeground(new java.awt.Color(255, 255, 255));
        lblTexto_publicacion.setText("Texto_publicacion");
        PanelNot1.add(lblTexto_publicacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 540, 80));

        ImagenPublicacion_lbl.setBackground(new java.awt.Color(255, 255, 255));
        ImagenPublicacion_lbl.setForeground(new java.awt.Color(255, 255, 255));
        ImagenPublicacion_lbl.setAlignmentY(0.0F);
        ImagenPublicacion_lbl.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        PanelNot1.add(ImagenPublicacion_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 500, 350));

        jPanel1.add(PanelNot1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 140, 580, 470));

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
        jPanel1.add(IconoParaTi, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, 60, 40));

        UsuarioPub5.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
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
        jPanel1.add(UsuarioPub5, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 100, -1, -1));

        Nombre_usuarioBtn.setBackground(new java.awt.Color(59, 28, 50));
        Nombre_usuarioBtn.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        Nombre_usuarioBtn.setForeground(new java.awt.Color(255, 255, 255));
        Nombre_usuarioBtn.setText("Nombre_usuario");
        Nombre_usuarioBtn.setToolTipText("");
        Nombre_usuarioBtn.setBorder(null);
        Nombre_usuarioBtn.setBorderPainted(false);
        Nombre_usuarioBtn.setContentAreaFilled(false);
        Nombre_usuarioBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Nombre_usuarioBtnActionPerformed(evt);
            }
        });
        jPanel1.add(Nombre_usuarioBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 80, -1, -1));

        lblUsuario.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        lblUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lblUsuario.setOpaque(true);
        jPanel1.add(lblUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 70, 54, 54));

        InformacionPublicacionPanel.setBackground(new java.awt.Color(0, 0, 0));

        meGustaBtn.setBackground(new java.awt.Color(59, 28, 50));
        meGustaBtn.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        meGustaBtn.setForeground(new java.awt.Color(255, 255, 255));
        meGustaBtn.setBorder(null);
        meGustaBtn.setBorderPainted(false);
        meGustaBtn.setContentAreaFilled(false);
        meGustaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                meGustaBtnActionPerformed(evt);
            }
        });

        lblLikesLabel.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        lblLikesLabel.setForeground(new java.awt.Color(255, 255, 255));
        lblLikesLabel.setText("0");

        lblComentarLabel.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        lblComentarLabel.setForeground(new java.awt.Color(255, 255, 255));
        lblComentarLabel.setText("0");

        repostearBtn.setBackground(new java.awt.Color(59, 28, 50));
        repostearBtn.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        repostearBtn.setForeground(new java.awt.Color(255, 255, 255));
        repostearBtn.setBorder(null);
        repostearBtn.setBorderPainted(false);
        repostearBtn.setContentAreaFilled(false);
        repostearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                repostearBtnActionPerformed(evt);
            }
        });

        comentarBtn.setBackground(new java.awt.Color(59, 28, 50));
        comentarBtn.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        comentarBtn.setForeground(new java.awt.Color(255, 255, 255));
        comentarBtn.setBorder(null);
        comentarBtn.setBorderPainted(false);
        comentarBtn.setContentAreaFilled(false);
        comentarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comentarBtnActionPerformed(evt);
            }
        });

        lblRepostearLabel.setForeground(new java.awt.Color(255, 255, 255));
        lblRepostearLabel.setText("0");

        javax.swing.GroupLayout InformacionPublicacionPanelLayout = new javax.swing.GroupLayout(InformacionPublicacionPanel);
        InformacionPublicacionPanel.setLayout(InformacionPublicacionPanelLayout);
        InformacionPublicacionPanelLayout.setHorizontalGroup(
            InformacionPublicacionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InformacionPublicacionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(meGustaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblLikesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comentarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblComentarLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(repostearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblRepostearLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(188, 188, 188))
        );
        InformacionPublicacionPanelLayout.setVerticalGroup(
            InformacionPublicacionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InformacionPublicacionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(InformacionPublicacionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lblLikesLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(meGustaBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(comentarBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblComentarLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblRepostearLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(repostearBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel1.add(InformacionPublicacionPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 620, 580, -1));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 670, 580, 10));
        jPanel1.add(jSeparator15, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 610, 580, 10));

        InicioBtn3.setBackground(new java.awt.Color(26, 26, 29));
        InicioBtn3.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        InicioBtn3.setForeground(new java.awt.Color(204, 204, 204));
        InicioBtn3.setText("Publicacion");
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
        jPanel1.add(InicioBtn3, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 10, 250, 40));

        ComentariosPanel.setBackground(new java.awt.Color(0, 0, 0));
        ComentariosPanel.setOpaque(false);
        ComentariosPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        InicioBtn1.setBackground(new java.awt.Color(26, 26, 29));
        InicioBtn1.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        InicioBtn1.setForeground(new java.awt.Color(204, 204, 204));
        InicioBtn1.setText("Comentarios de la publicacion");
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
        ComentariosPanel.add(InicioBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 10, 250, 40));
        ComentariosPanel.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 500, 20));

        jLabel2.setFont(new java.awt.Font("SansSerif", 3, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("Comentarios de publicacion");
        ComentariosPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 360, 40));

        PanelComentario1.setBackground(new java.awt.Color(0, 0, 0));
        PanelComentario1.setPreferredSize(new java.awt.Dimension(584, 66));
        PanelComentario1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblUsuario2.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        lblUsuario2.setForeground(new java.awt.Color(255, 255, 255));
        lblUsuario2.setText("ImgNot");
        lblUsuario2.setOpaque(true);
        PanelComentario1.add(lblUsuario2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 54, 54));

        UserComentario2.setBackground(new java.awt.Color(59, 28, 50));
        UserComentario2.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        UserComentario2.setForeground(new java.awt.Color(255, 255, 255));
        UserComentario2.setText("Nombre_usuario");
        UserComentario2.setToolTipText("");
        UserComentario2.setBorder(null);
        UserComentario2.setBorderPainted(false);
        UserComentario2.setContentAreaFilled(false);
        UserComentario2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserComentario2ActionPerformed(evt);
            }
        });
        PanelComentario1.add(UserComentario2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, -1));

        DifHors1.setFont(new java.awt.Font("Roboto Mono", 2, 12)); // NOI18N
        DifHors1.setForeground(new java.awt.Color(255, 255, 255));
        DifHors1.setText("HoraActual");
        PanelComentario1.add(DifHors1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, 90, 20));

        ComentarioBD1.setFont(new java.awt.Font("SansSerif", 0, 10)); // NOI18N
        ComentarioBD1.setForeground(new java.awt.Color(204, 204, 204));
        ComentarioBD1.setText("Comentario");
        ComentarioBD1.setToolTipText("");
        PanelComentario1.add(ComentarioBD1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, 410, 60));

        ComentariosPanel.add(PanelComentario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 500, 110));

        PanelComentario2.setBackground(new java.awt.Color(0, 0, 0));
        PanelComentario2.setPreferredSize(new java.awt.Dimension(584, 66));
        PanelComentario2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblUsuario3.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        lblUsuario3.setForeground(new java.awt.Color(255, 255, 255));
        lblUsuario3.setText("ImgNot");
        lblUsuario3.setOpaque(true);
        PanelComentario2.add(lblUsuario3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 54, 54));

        UserComentario3.setBackground(new java.awt.Color(59, 28, 50));
        UserComentario3.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        UserComentario3.setForeground(new java.awt.Color(255, 255, 255));
        UserComentario3.setText("Nombre_usuario");
        UserComentario3.setToolTipText("");
        UserComentario3.setBorder(null);
        UserComentario3.setBorderPainted(false);
        UserComentario3.setContentAreaFilled(false);
        UserComentario3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserComentario3ActionPerformed(evt);
            }
        });
        PanelComentario2.add(UserComentario3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, -1));

        DifHors2.setFont(new java.awt.Font("Roboto Mono", 2, 12)); // NOI18N
        DifHors2.setForeground(new java.awt.Color(255, 255, 255));
        DifHors2.setText("HoraActual");
        PanelComentario2.add(DifHors2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, 90, 20));

        ComentarioBD2.setFont(new java.awt.Font("SansSerif", 0, 10)); // NOI18N
        ComentarioBD2.setForeground(new java.awt.Color(204, 204, 204));
        ComentarioBD2.setText("Comentario");
        ComentarioBD2.setToolTipText("");
        PanelComentario2.add(ComentarioBD2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, 410, 60));

        ComentariosPanel.add(PanelComentario2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 500, 110));

        PanelComentario4.setBackground(new java.awt.Color(0, 0, 0));
        PanelComentario4.setPreferredSize(new java.awt.Dimension(584, 66));
        PanelComentario4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblUsuario5.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        lblUsuario5.setForeground(new java.awt.Color(255, 255, 255));
        lblUsuario5.setText("ImgNot");
        lblUsuario5.setOpaque(true);
        PanelComentario4.add(lblUsuario5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 54, 54));

        UserComentario5.setBackground(new java.awt.Color(59, 28, 50));
        UserComentario5.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        UserComentario5.setForeground(new java.awt.Color(255, 255, 255));
        UserComentario5.setText("Nombre_usuario");
        UserComentario5.setToolTipText("");
        UserComentario5.setBorder(null);
        UserComentario5.setBorderPainted(false);
        UserComentario5.setContentAreaFilled(false);
        UserComentario5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserComentario5ActionPerformed(evt);
            }
        });
        PanelComentario4.add(UserComentario5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, -1));

        DifHors4.setFont(new java.awt.Font("Roboto Mono", 2, 12)); // NOI18N
        DifHors4.setForeground(new java.awt.Color(255, 255, 255));
        DifHors4.setText("HoraActual");
        PanelComentario4.add(DifHors4, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, 90, 20));

        ComentarioBD4.setFont(new java.awt.Font("SansSerif", 0, 10)); // NOI18N
        ComentarioBD4.setForeground(new java.awt.Color(204, 204, 204));
        ComentarioBD4.setText("Comentario");
        ComentarioBD4.setToolTipText("");
        PanelComentario4.add(ComentarioBD4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, 410, 60));

        ComentariosPanel.add(PanelComentario4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 500, 110));

        PanelComentario7.setBackground(new java.awt.Color(0, 0, 0));
        PanelComentario7.setPreferredSize(new java.awt.Dimension(584, 66));
        PanelComentario7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblUsuario7.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        lblUsuario7.setForeground(new java.awt.Color(255, 255, 255));
        lblUsuario7.setText("ImgNot");
        lblUsuario7.setOpaque(true);
        PanelComentario7.add(lblUsuario7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 54, 54));

        UserComentario7.setBackground(new java.awt.Color(59, 28, 50));
        UserComentario7.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        UserComentario7.setForeground(new java.awt.Color(255, 255, 255));
        UserComentario7.setText("Nombre_usuario");
        UserComentario7.setToolTipText("");
        UserComentario7.setBorder(null);
        UserComentario7.setBorderPainted(false);
        UserComentario7.setContentAreaFilled(false);
        UserComentario7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserComentario7ActionPerformed(evt);
            }
        });
        PanelComentario7.add(UserComentario7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, -1));

        DifHors6.setFont(new java.awt.Font("Roboto Mono", 2, 12)); // NOI18N
        DifHors6.setForeground(new java.awt.Color(255, 255, 255));
        DifHors6.setText("HoraActual");
        PanelComentario7.add(DifHors6, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, 90, 20));

        ComentarioBD6.setFont(new java.awt.Font("SansSerif", 0, 10)); // NOI18N
        ComentarioBD6.setForeground(new java.awt.Color(204, 204, 204));
        ComentarioBD6.setText("Comentario");
        ComentarioBD6.setToolTipText("");
        PanelComentario7.add(ComentarioBD6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, 410, 60));

        ComentariosPanel.add(PanelComentario7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 680, 500, 110));

        PanelComentario3.setBackground(new java.awt.Color(0, 0, 0));
        PanelComentario3.setPreferredSize(new java.awt.Dimension(584, 66));
        PanelComentario3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblUsuario4.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        lblUsuario4.setForeground(new java.awt.Color(255, 255, 255));
        lblUsuario4.setText("ImgNot");
        lblUsuario4.setOpaque(true);
        PanelComentario3.add(lblUsuario4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 54, 54));

        UserComentario4.setBackground(new java.awt.Color(59, 28, 50));
        UserComentario4.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        UserComentario4.setForeground(new java.awt.Color(255, 255, 255));
        UserComentario4.setText("Nombre_usuario");
        UserComentario4.setToolTipText("");
        UserComentario4.setBorder(null);
        UserComentario4.setBorderPainted(false);
        UserComentario4.setContentAreaFilled(false);
        UserComentario4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserComentario4ActionPerformed(evt);
            }
        });
        PanelComentario3.add(UserComentario4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, -1));

        DifHors3.setFont(new java.awt.Font("Roboto Mono", 2, 12)); // NOI18N
        DifHors3.setForeground(new java.awt.Color(255, 255, 255));
        DifHors3.setText("HoraActual");
        PanelComentario3.add(DifHors3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, 90, 20));

        ComentarioBD3.setFont(new java.awt.Font("SansSerif", 0, 10)); // NOI18N
        ComentarioBD3.setForeground(new java.awt.Color(204, 204, 204));
        ComentarioBD3.setText("Comentario");
        ComentarioBD3.setToolTipText("");
        PanelComentario3.add(ComentarioBD3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, 410, 60));

        ComentariosPanel.add(PanelComentario3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 500, 110));

        PanelComentario5.setBackground(new java.awt.Color(0, 0, 0));
        PanelComentario5.setPreferredSize(new java.awt.Dimension(584, 66));
        PanelComentario5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblUsuario6.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        lblUsuario6.setForeground(new java.awt.Color(255, 255, 255));
        lblUsuario6.setText("ImgNot");
        lblUsuario6.setOpaque(true);
        PanelComentario5.add(lblUsuario6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 54, 54));

        UserComentario6.setBackground(new java.awt.Color(59, 28, 50));
        UserComentario6.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        UserComentario6.setForeground(new java.awt.Color(255, 255, 255));
        UserComentario6.setText("Nombre_usuario");
        UserComentario6.setToolTipText("");
        UserComentario6.setBorder(null);
        UserComentario6.setBorderPainted(false);
        UserComentario6.setContentAreaFilled(false);
        UserComentario6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserComentario6ActionPerformed(evt);
            }
        });
        PanelComentario5.add(UserComentario6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, -1));

        DifHors5.setFont(new java.awt.Font("Roboto Mono", 2, 12)); // NOI18N
        DifHors5.setForeground(new java.awt.Color(255, 255, 255));
        DifHors5.setText("HoraActual");
        PanelComentario5.add(DifHors5, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, 90, 20));

        ComentarioBD5.setFont(new java.awt.Font("SansSerif", 0, 10)); // NOI18N
        ComentarioBD5.setForeground(new java.awt.Color(204, 204, 204));
        ComentarioBD5.setText("Comentario");
        ComentarioBD5.setToolTipText("");
        PanelComentario5.add(ComentarioBD5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, 410, 60));

        ComentariosPanel.add(PanelComentario5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, 500, 110));

        PanelComentario6.setBackground(new java.awt.Color(0, 0, 0));
        PanelComentario6.setPreferredSize(new java.awt.Dimension(584, 66));
        PanelComentario6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblUsuario10.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        lblUsuario10.setForeground(new java.awt.Color(255, 255, 255));
        lblUsuario10.setText("ImgNot");
        lblUsuario10.setOpaque(true);
        PanelComentario6.add(lblUsuario10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 54, 54));

        UserComentario10.setBackground(new java.awt.Color(59, 28, 50));
        UserComentario10.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        UserComentario10.setForeground(new java.awt.Color(255, 255, 255));
        UserComentario10.setText("Nombre_usuario");
        UserComentario10.setToolTipText("");
        UserComentario10.setBorder(null);
        UserComentario10.setBorderPainted(false);
        UserComentario10.setContentAreaFilled(false);
        UserComentario10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserComentario10ActionPerformed(evt);
            }
        });
        PanelComentario6.add(UserComentario10, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, -1));

        DifHors9.setFont(new java.awt.Font("Roboto Mono", 2, 12)); // NOI18N
        DifHors9.setForeground(new java.awt.Color(255, 255, 255));
        DifHors9.setText("HoraActual");
        PanelComentario6.add(DifHors9, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, 90, 20));

        ComentarioBD9.setFont(new java.awt.Font("SansSerif", 0, 10)); // NOI18N
        ComentarioBD9.setForeground(new java.awt.Color(204, 204, 204));
        ComentarioBD9.setText("Comentario");
        ComentarioBD9.setToolTipText("");
        PanelComentario6.add(ComentarioBD9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, 410, 60));

        ComentariosPanel.add(PanelComentario6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 570, 500, 110));

        jPanel1.add(ComentariosPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 0, 530, 820));

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        FotoUsuario.setBackground(new java.awt.Color(255, 255, 255));
        FotoUsuario.setOpaque(true);
        jPanel3.add(FotoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 50, 50));

        UserOtraves.setFont(new java.awt.Font("SansSerif", 0, 10)); // NOI18N
        UserOtraves.setForeground(new java.awt.Color(255, 102, 204));
        UserOtraves.setText("@Usuario");
        jPanel3.add(UserOtraves, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, -1, -1));

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 10)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Respondiendo a");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, -1));

        ComentarioExistente.setForeground(new java.awt.Color(204, 204, 204));
        ComentarioExistente.setText("Comentario En caso de existir");
        jPanel3.add(ComentarioExistente, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 430, 64));

        EditarComentario.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        EditarComentario.setForeground(new java.awt.Color(204, 204, 204));
        EditarComentario.setText("Editar ");
        EditarComentario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 255)));
        EditarComentario.setContentAreaFilled(false);
        EditarComentario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarComentarioActionPerformed(evt);
            }
        });
        jPanel3.add(EditarComentario, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 100, 90, 30));

        CasillaComentarios.setBackground(new java.awt.Color(0, 0, 0));
        CasillaComentarios.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        CasillaComentarios.setForeground(new java.awt.Color(204, 204, 204));
        CasillaComentarios.setText("Publica Tu Respuesta");
        CasillaComentarios.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        CasillaComentarios.setMargin(new java.awt.Insets(3, 6, 3, 6));
        CasillaComentarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CasillaComentariosMouseClicked(evt);
            }
        });
        jPanel3.add(CasillaComentarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, 327, 30));

        FechaComent.setForeground(new java.awt.Color(204, 204, 204));
        FechaComent.setText("Fecha");
        jPanel3.add(FechaComent, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 60, 84, -1));

        AlertaEditado.setFont(new java.awt.Font("SansSerif", 2, 10)); // NOI18N
        AlertaEditado.setForeground(new java.awt.Color(255, 153, 255));
        AlertaEditado.setText("Comentario Editado");
        jPanel3.add(AlertaEditado, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 130, -1, -1));

        ComentarBtn.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        ComentarBtn.setForeground(new java.awt.Color(204, 204, 204));
        ComentarBtn.setText("Responder");
        ComentarBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 255)));
        ComentarBtn.setContentAreaFilled(false);
        ComentarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComentarBtnActionPerformed(evt);
            }
        });
        jPanel3.add(ComentarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 10, 90, 30));

        GuardarCambio.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        GuardarCambio.setForeground(new java.awt.Color(204, 204, 204));
        GuardarCambio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 255)));
        GuardarCambio.setContentAreaFilled(false);
        GuardarCambio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarCambioActionPerformed(evt);
            }
        });
        jPanel3.add(GuardarCambio, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, 43, 40));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 670, 600, 150));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1556, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 820, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ConfiBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfiBtnActionPerformed
       Configuracion vnt = new Configuracion();
       vnt.setVisible(true);
       this.dispose();// TODO add your handling code here:
    }//GEN-LAST:event_ConfiBtnActionPerformed

    private void InicioBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InicioBtn1ActionPerformed
       this.dispose();
       new ComentariosPublicacion().setVisible(true);  // TODO add your handling code here:
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

    private void PostearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PostearBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PostearBtnActionPerformed

    private void InicioBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InicioBtn2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InicioBtn2ActionPerformed

    private void IconoParaTiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IconoParaTiActionPerformed
        this.dispose();
        new Menu_Principal().setVisible(true);
    }//GEN-LAST:event_IconoParaTiActionPerformed

    private void meGustaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meGustaBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_meGustaBtnActionPerformed

    private void repostearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_repostearBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_repostearBtnActionPerformed

    private void comentarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comentarBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comentarBtnActionPerformed

    private void Nombre_usuarioBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Nombre_usuarioBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Nombre_usuarioBtnActionPerformed

    private void UsuarioPub5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsuarioPub5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UsuarioPub5ActionPerformed

    private void CasillaComentariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CasillaComentariosMouseClicked
        CasillaComentarios.setText("");
    }//GEN-LAST:event_CasillaComentariosMouseClicked

    private void InicioBtn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InicioBtn3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InicioBtn3ActionPerformed

    private void UserComentario2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserComentario2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UserComentario2ActionPerformed

    private void UserComentario3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserComentario3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UserComentario3ActionPerformed

    private void UserComentario4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserComentario4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UserComentario4ActionPerformed

    private void UserComentario5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserComentario5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UserComentario5ActionPerformed

    private void UserComentario6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserComentario6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UserComentario6ActionPerformed

    private void UserComentario7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserComentario7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UserComentario7ActionPerformed

    private void UserComentario10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserComentario10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UserComentario10ActionPerformed

    private void ComentarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComentarBtnActionPerformed
        CrearComentariosPublicaciones();
    }//GEN-LAST:event_ComentarBtnActionPerformed

    private void EditarComentarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarComentarioActionPerformed
        String Comentario =  ComentarioExistente.getText();
        CasillaComentarios.setText(Comentario);
        CasillaComentarios.setVisible(true);
        GuardarCambio.setVisible(true);
        ComentarioExistente.setVisible(false);
        EditarComentario.setVisible(false);
        FechaComent.setVisible(false);
    }//GEN-LAST:event_EditarComentarioActionPerformed

    private void GuardarCambioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarCambioActionPerformed
        EditarComentarioUsuario();
    }//GEN-LAST:event_GuardarCambioActionPerformed

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
            java.util.logging.Logger.getLogger(ComentariosPublicacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ComentariosPublicacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ComentariosPublicacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ComentariosPublicacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
                new ComentariosPublicacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AlertaEditado;
    private javax.swing.JTextField CasillaComentarios;
    private javax.swing.JButton ComentarBtn;
    private javax.swing.JLabel ComentarioBD1;
    private javax.swing.JLabel ComentarioBD2;
    private javax.swing.JLabel ComentarioBD3;
    private javax.swing.JLabel ComentarioBD4;
    private javax.swing.JLabel ComentarioBD5;
    private javax.swing.JLabel ComentarioBD6;
    private javax.swing.JLabel ComentarioBD9;
    private javax.swing.JLabel ComentarioExistente;
    private javax.swing.JPanel ComentariosPanel;
    private javax.swing.JButton ComunidadesBtn;
    private javax.swing.JButton ConfiBtn;
    private javax.swing.JLabel DifHors1;
    private javax.swing.JLabel DifHors2;
    private javax.swing.JLabel DifHors3;
    private javax.swing.JLabel DifHors4;
    private javax.swing.JLabel DifHors5;
    private javax.swing.JLabel DifHors6;
    private javax.swing.JLabel DifHors9;
    private javax.swing.JButton EditarComentario;
    private javax.swing.JButton ExplorarBtn;
    private javax.swing.JLabel FechaComent;
    private javax.swing.JLabel Fecha_Label;
    private javax.swing.JLabel FotoUsuario;
    private javax.swing.JButton GuardadoBtn;
    private javax.swing.JButton GuardarCambio;
    private javax.swing.JButton IconoParaTi;
    private javax.swing.JLabel IdUsuario2;
    private javax.swing.JLabel ImagenPublicacion_lbl;
    private javax.swing.JPanel InformacionPublicacionPanel;
    private javax.swing.JButton InicioBtn1;
    private javax.swing.JButton InicioBtn2;
    private javax.swing.JButton InicioBtn3;
    private javax.swing.JLabel NombreUsuario;
    private javax.swing.JButton Nombre_usuarioBtn;
    private javax.swing.JButton NotificacionesBtn;
    private javax.swing.JPanel PanelComentario1;
    private javax.swing.JPanel PanelComentario2;
    private javax.swing.JPanel PanelComentario3;
    private javax.swing.JPanel PanelComentario4;
    private javax.swing.JPanel PanelComentario5;
    private javax.swing.JPanel PanelComentario6;
    private javax.swing.JPanel PanelComentario7;
    private javax.swing.JPanel PanelNot1;
    private javax.swing.JButton PerfilBtn;
    private javax.swing.JPanel PerfilPanel;
    private javax.swing.JLabel Perfil_Img;
    private javax.swing.JButton PostearBtn;
    private javax.swing.JButton UserComentario10;
    private javax.swing.JButton UserComentario2;
    private javax.swing.JButton UserComentario3;
    private javax.swing.JButton UserComentario4;
    private javax.swing.JButton UserComentario5;
    private javax.swing.JButton UserComentario6;
    private javax.swing.JButton UserComentario7;
    private javax.swing.JLabel UserOtraves;
    private javax.swing.JButton UsuarioPub5;
    private javax.swing.JLabel Y_logo;
    private javax.swing.JButton comentarBtn;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator15;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel lblComentarLabel;
    private javax.swing.JLabel lblLikesLabel;
    private javax.swing.JLabel lblRepostearLabel;
    private javax.swing.JLabel lblTexto_publicacion;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JLabel lblUsuario10;
    private javax.swing.JLabel lblUsuario2;
    private javax.swing.JLabel lblUsuario3;
    private javax.swing.JLabel lblUsuario4;
    private javax.swing.JLabel lblUsuario5;
    private javax.swing.JLabel lblUsuario6;
    private javax.swing.JLabel lblUsuario7;
    private javax.swing.JButton meGustaBtn;
    private javax.swing.JButton repostearBtn;
    // End of variables declaration//GEN-END:variables

}
