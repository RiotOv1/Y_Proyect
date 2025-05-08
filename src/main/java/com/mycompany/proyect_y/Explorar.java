package com.mycompany.proyect_y;

import Conection.DB_Conection;
import com.mycompany.proyect_y.Comunidad;
import com.mycompany.proyect_y.Configuracion;
import com.mycompany.proyect_y.Guardados;
import com.mycompany.proyect_y.Menu_Principal;
import com.mycompany.proyect_y.Notificaciones;
import com.mycompany.proyect_y.Perfil;
import com.mycompany.proyect_y.Publicacion;
import com.mycompany.proyect_y.PublicacionDAO;
import com.mycompany.proyect_y.SesionUsuario;
import com.mycompany.proyect_y.Usuarios;
import com.mycompany.proyect_y.UsuariosDAO;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Explorar extends javax.swing.JFrame {
    private UsuariosDAO usuarioDao;
    private PublicacionDAO publicacionDAO;
    /*private List<Usuarios> usuarioss;
    private List<Publicacion> publicaciones;*/
    private int ResPublicadoAct = 0;
    private int currentUserPanel = 0;
    private int currentPubPanel = 0;
    
    public Explorar() {
        initComponents();
        this.setLocationRelativeTo(null);
        Img();
        cargarFotoPerfil(); 
        limpiarPaneles();
        Connection con =  DB_Conection.conectar(); // tu clase de conexión
        String Id =SesionUsuario.idUsuario;
        if (Id != null) {
            String nom = obtenerNombreUsuario();
            NombreUsuario.setText(nom);
            IdUsuario2.setText( "@" + Id);        
        }
        publicacionDAO = new PublicacionDAO();
        usuarioDao = new UsuariosDAO();

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
                        Image img = icon.getImage().getScaledInstance(Perfil_Img2.getWidth(), Perfil_Img2.getHeight(), Image.SCALE_SMOOTH);
                        Perfil_Img2.setIcon(new ImageIcon(img));
                        
                    } else {
                        Perfil_Img2.setText("Sin imagen");
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
        Image img2 = image2.getImage().getScaledInstance(40, 40, 0);
        ImageIcon Icono2 = new ImageIcon(img2);
        IconoExplorar.setIcon(Icono2);
        
        //IconoExplorar
        String url21 = "src\\main\\java\\Multimedia\\Icon-Explorar.png";
        ImageIcon image23 = new ImageIcon(url21);
        Image img23 = image23.getImage().getScaledInstance(32, 32, 0);
        ImageIcon Icono23 = new ImageIcon(img23);
        ExplorarBtn1.setIcon(Icono23);
        
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
        Image img13 = image13.getImage().getScaledInstance(90, 90, 0);
        ImageIcon Icono13 = new ImageIcon(img13);
        Y_logo.setIcon(Icono13);
        
        //Icono Tus Yaps
        
        /*String url132 = "src\\main\\java\\Multimedia\\Yap-Icon.png";
        ImageIcon image132 = new ImageIcon(url132);
        Image img132 = image132.getImage().getScaledInstance(34, 34, 0);
        ImageIcon Icono132 = new ImageIcon(img132);
        TusYapsImg.setIcon(Icono132); */

        //Icono Configuracion
        String url14 = "src\\main\\java\\Multimedia\\Icono-Configuracion.png";
        ImageIcon image14 = new ImageIcon(url14);
        Image img14 = image14.getImage().getScaledInstance(34, 34, 0);
        ImageIcon Icono14 = new ImageIcon(img14);
        ConfiBtn.setIcon(Icono14);
        
        //Icono Menciones
        
        /*String url147 = "src\\main\\java\\Multimedia\\Mencion-Icon.png";
        ImageIcon image147 = new ImageIcon(url147);
        Image img147 = image147.getImage().getScaledInstance(34, 34, 0);
        ImageIcon Icono147 = new ImageIcon(img147);
        MencionesImg.setIcon(Icono147);*/
        
        //Icono Cumple
        /*String url143 = "src\\main\\java\\Multimedia\\Cump-Icon.png";
        ImageIcon image143 = new ImageIcon(url143);
        Image img143= image143.getImage().getScaledInstance(34, 34, 0);
        ImageIcon Icono143= new ImageIcon(img143);
        CumpImg.setIcon(Icono143);

        //Icono Amigos
        String url141 = "src\\main\\java\\Multimedia\\Amigo-Icon.png";
        ImageIcon image141 = new ImageIcon(url141);
        Image img141= image141.getImage().getScaledInstance(34, 34, 0);
        ImageIcon Icono141= new ImageIcon(img141);
        AmigosImg1.setIcon(Icono141);
        
        //Icono Tendencias
        String url149 = "src\\main\\java\\Multimedia\\Tend-Icon.png";
        ImageIcon image149 = new ImageIcon(url149);
        Image img149= image149.getImage().getScaledInstance(34, 34, 0);
        ImageIcon Icono149= new ImageIcon(img149);
        TendenciaImg.setIcon(Icono149);
        
        //Icono Recientes
        String url144 = "src\\main\\java\\Multimedia\\Reciente-Icon.png";
        ImageIcon image144 = new ImageIcon(url144);
        Image img144= image144.getImage().getScaledInstance(34, 34, 0);
        ImageIcon Icono144= new ImageIcon(img144);
        RecientesImg.setIcon(Icono144);*/
    }
        
    private void mostrarResultadosUsuarios(String textoBusqueda){
        //Limpiar resultados anteriores 
        //limpiarResultados(); 
        
        if(textoBusqueda.isEmpty()){
            return;
        }
        
        //Limpiar paneles antes de una busqueda
        limpiarPaneles();
        
        //Buscar en la base de datos
        List<Usuarios> usuarios = usuarioDao.buscarUsuarios(textoBusqueda,1,3);
        List<Publicacion> publicacioness = publicacionDAO.buscarPublicacionesResult(textoBusqueda,1,3);
        
        //Mostrar usuarios en sus paneles correspondientes
        currentUserPanel = 0;
        for(Usuarios usuario : usuarios){
            if(currentUserPanel >= 3) break; //Solo tenemos 3 paneles para usuarios
                configurarPanelUsuario(
                    getPanelUsuario(currentUserPanel), usuario, getBotonNombreUsuario(currentUserPanel),
                        getBotonCorreoUsuario(currentUserPanel), getFotoPerfil(currentUserPanel)
                );
                getPanelUsuario(currentUserPanel).setVisible(true);
                currentUserPanel++;
        }
        
        //Mostrar publicaciones en sus paneles correspondientes
        currentPubPanel = 0;
        for (Publicacion publicacion : publicacioness){
            if(currentPubPanel >= 3) break; //Solo tenemos 3 paneles para publicaciones
            configurarPanelPublicacion(
                        getPanelPublicacion(currentPubPanel),publicacion,
                        getFotoPerfilUsuarioPubli(currentPubPanel), getNomUsuarioPubli(currentPubPanel), getNombreCorreoUsu(currentPubPanel),
                        getTextoPubli(currentPubPanel), getFechaPubli(currentPubPanel),
                        getLikeButton(currentPubPanel), getConteoLikes(currentPubPanel),
                        getRepostButton(currentPubPanel),getConteoRepost(currentPubPanel),getImagenPubli(currentPubPanel),getComentarioButton(currentPubPanel)
                );
            getPanelPublicacion(currentPubPanel).setVisible(true);
            currentPubPanel++;
        }
    }
    
    private void limpiarPaneles(){
        //Ocultar todos los paneles de usuarios
        for(int i = 0;i < 3; i++){
            getPanelUsuario(i).setVisible(false);
        }
        
        //Ocultar todos los paneles de publicaciones
        for(int i = 0; i < 3; i++){
            getPanelPublicacion(i).setVisible(false);
            ImagenPublicacion_lbl.setVisible(false);
            ImagenPublicacion_lbl2.setVisible(false);
            ImagenPublicacion_lbl3.setVisible(false);
        }
        
        currentUserPanel = 0;
        currentPubPanel = 0;
    }
    
    //Metodos auxiliares para obtener los paneles y componentes
    private JPanel getPanelUsuario(int index){
        switch(index){
            case 0: return EjemploBusquedas2;
            case 1: return EjemploBusqueda6;
            case 2: return EjemploBusquedas1;
            default: return null;
        }
    }
    
    private JButton getBotonNombreUsuario(int index){
        switch(index){
            case 0: return UserResu1_Btn;
            case 1: return UserResu1_Btn1;
            case 2: return UserResu1_Btn2;
            default: return null;
        }
    }
    
    private JButton getBotonCorreoUsuario(int index){
        switch(index){
            case 0: return UserResu2;
            case 1: return UserResu3;
            case 2: return UserResu1;
            default: return null;
        }
    }
    
    private JLabel getFotoPerfil(int index){
        switch(index){
            case 0: return ImgResu2;
            case 1: return ImgResu3;
            case 2: return ImgRes1;
            default: return null;
        }
    }
    
    //Metodos auxiliares para paneles de publicacion
    
    private JPanel getPanelPublicacion(int index){
        switch(index){
            case 0: return PanelNot1;
            case 1: return PanelNot4;
            case 2: return PanelNot5;
            default: return null;
        }
    }
    
    private JLabel getFotoPerfilUsuarioPubli(int index){
        switch(index){
            case 0: return lblUsuario;
            case 1: return lblUsuario1;
            case 2: return lblUsuario2;
            default: return null;
        }
    }
    
    private JButton getNomUsuarioPubli(int index){
        switch(index){
            case 0: return Nombre_usuarioBtn;
            case 1: return Nombre_usuarioBtn1;
            case 2: return Nombre_usuarioBtn2;
            default: return null;
        }
    }
    
    private JButton getNombreCorreoUsu(int index){
        switch(index){
            case 0: return UsuarioPub5;
            case 1: return UsuarioPub6;
            case 2: return UsuarioPub7;
            default: return null;
        }
    }
    
    private JLabel getTextoPubli(int index){
        switch(index){
            case 0: return lblTexto_publicacion;
            case 1: return lblTexto_publicacion1;
            case 2: return lblTexto_publicacion2;
            default: return null;
        }
    }
    
    private JLabel getFechaPubli(int index){
        switch(index){
            case 0: return Fecha_Label;
            case 1: return Fecha_Label1;
            case 2: return Fecha_Label2;
            default: return null;
        }
    }
    
    private JButton getLikeButton(int index){
        switch(index){
            case 0: return meGustaBtn;
            case 1: return meGustaBtn1;
            case 2: return meGustaBtn2;
            default: return null;
        }
    }
    
    private JLabel getConteoLikes(int index){
        switch(index){
            case 0: return lblLikesLabel;
            case 1: return lblLikesLabel1;
            case 2: return lblLikesLabel2;
            default: return null;
        }
    }
    
    private JButton getRepostButton(int index){
        switch(index){
            case 0: return repostearBtn;
            case 1: return repostearBtn1;
            case 2: return repostearBtn2;
            default: return null;
        }
    }
    
    private JLabel getConteoRepost(int index){
        switch(index){
            case 0: return lblRepostearLabel;
            case 1: return lblRepostearLabel1;
            case 2: return lblRepostearLabel2;
            default: return null;
        }
    }
    
    private JLabel getImagenPubli(int index){
        switch(index){
            case 0: return ImagenPublicacion_lbl2;
            case 1: return ImagenPublicacion_lbl3; 
            case 2: return ImagenPublicacion_lbl;
            default: return null;
        }
    }
    
    private JButton getComentarioButton(int index){
        switch(index){
            case 0: return comentarBtn;
            case 1: return comentarBtn1;
            case 2: return comentarBtn2;
            default: return null;
        }
    }
        
    private void configurarPanelUsuario(JPanel panUsu, Usuarios usu, JButton nombreUsu, JButton correoUsu, JLabel fotoPerfilUsu){
        
        //Configuracion de los paneles
        nombreUsu.setText(usu.getUserName());
        correoUsu.setText("@"+usu.getCorreoEle());
        
        if(usu.getImagenPerfil() != null){
            ImageIcon icon = new ImageIcon(usu.getImagenPerfil());
            Image img = icon.getImage().getScaledInstance(54,54,Image.SCALE_SMOOTH);
            fotoPerfilUsu.setIcon(new ImageIcon(img));
        }else{
            fotoPerfilUsu.setIcon(null);
        }
    }
    
    boolean bandera_likes = false;
    boolean bandera_repost = false;
    
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
        
        //Configurar imagen de la publicacion
        if(publica.getMultimediaPubli()!=null){
            ImageIcon icono_imagen = new ImageIcon(publica.getMultimediaPubli());
            Image img_publi = icono_imagen.getImage().getScaledInstance(54,54, Image.SCALE_SMOOTH);
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
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelTotalExplorar = new javax.swing.JPanel();
        AmigosImg1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        BuscarBtn = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        BusquedaTodoBtn = new javax.swing.JButton();
        BusquedaTodoBtn1 = new javax.swing.JButton();
        ConfiBtn = new javax.swing.JButton();
        InicioBtn1 = new javax.swing.JButton();
        ComunidadesBtn = new javax.swing.JButton();
        NotificacionesBtn = new javax.swing.JButton();
        GuardadoBtn = new javax.swing.JButton();
        PerfilBtn = new javax.swing.JButton();
        PublicacionesBtn2 = new javax.swing.JButton();
        QuePasa = new javax.swing.JLabel();
        SeguirCuentaBtn3 = new javax.swing.JButton();
        SeguirCuentaBtn1 = new javax.swing.JButton();
        SeguirCuentaBtn2 = new javax.swing.JButton();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        TePuedeInteresarLbl = new javax.swing.JLabel();
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
        jSeparator4 = new javax.swing.JSeparator();
        PerfilPanel = new javax.swing.JPanel();
        NombreUsuario = new javax.swing.JLabel();
        IdUsuario2 = new javax.swing.JLabel();
        Perfil_Img2 = new javax.swing.JLabel();
        Perfil_Img = new javax.swing.JLabel();
        PostearBtn = new javax.swing.JButton();
        jSeparator7 = new javax.swing.JSeparator();
        ExplorarBtn1 = new javax.swing.JButton();
        RecientesImg = new javax.swing.JLabel();
        IconoExplorar = new javax.swing.JButton();
        ExplorarTitulo = new javax.swing.JLabel();
        Y_logo = new javax.swing.JLabel();
        Busqueda_TxtFld = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        Busquedas_jTabbePane = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
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
        ImagenPublicacion_lbl1 = new javax.swing.JLabel();
        ImagenPublicacion_lbl2 = new javax.swing.JLabel();
        ImagenPublicacion_lbl3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        EjemploBusquedas2 = new javax.swing.JPanel();
        UserResu2 = new javax.swing.JButton();
        SeguidoresResu2 = new javax.swing.JButton();
        NoSeguidoresResu2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        ImgResu2 = new javax.swing.JLabel();
        UserResu1_Btn = new javax.swing.JButton();
        EjemploBusqueda6 = new javax.swing.JPanel();
        UserResu3 = new javax.swing.JButton();
        SeguidoresResu3 = new javax.swing.JButton();
        NoSeguidoresResu3 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        ImgResu3 = new javax.swing.JLabel();
        UserResu1_Btn1 = new javax.swing.JButton();
        EjemploBusquedas1 = new javax.swing.JPanel();
        UserResu1 = new javax.swing.JButton();
        SeguidoresResu1 = new javax.swing.JButton();
        NoSeguidoresResu1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        ImgRes1 = new javax.swing.JLabel();
        UserResu1_Btn2 = new javax.swing.JButton();
        Resultados_JLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(26, 26, 29));
        setLocationByPlatform(true);
        setMinimumSize(new java.awt.Dimension(1550, 820));
        setUndecorated(true);
        setResizable(false);

        PanelTotalExplorar.setBackground(new java.awt.Color(0, 0, 0));
        PanelTotalExplorar.setPreferredSize(new java.awt.Dimension(1550, 820));
        PanelTotalExplorar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        AmigosImg1.setForeground(new java.awt.Color(255, 255, 255));
        AmigosImg1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PanelTotalExplorar.add(AmigosImg1, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 620, 70, 70));

        jSeparator1.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator1.setForeground(new java.awt.Color(153, 153, 153));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        PanelTotalExplorar.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(427, 0, -1, 1040));

        BuscarBtn.setBackground(new java.awt.Color(166, 77, 121));
        BuscarBtn.setForeground(new java.awt.Color(255, 255, 255));
        BuscarBtn.setText("Buscar");
        BuscarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarBtnActionPerformed(evt);
            }
        });
        PanelTotalExplorar.add(BuscarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 40, 140, 30));

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        BusquedaTodoBtn.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        BusquedaTodoBtn.setForeground(new java.awt.Color(204, 204, 204));
        BusquedaTodoBtn.setText("Publicaciones");
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

        BusquedaTodoBtn1.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        BusquedaTodoBtn1.setForeground(new java.awt.Color(204, 204, 204));
        BusquedaTodoBtn1.setText("Usuarios");
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(BusquedaTodoBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 334, Short.MAX_VALUE)
                .addComponent(BusquedaTodoBtn)
                .addGap(132, 132, 132))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BusquedaTodoBtn1)
                    .addComponent(BusquedaTodoBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        PanelTotalExplorar.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 80, 750, 70));

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
        PanelTotalExplorar.add(ConfiBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 500, 260, 40));

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
        PanelTotalExplorar.add(InicioBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 250, 40));

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
        PanelTotalExplorar.add(ComunidadesBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 320, 250, 40));

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
        PanelTotalExplorar.add(NotificacionesBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 260, 250, 40));

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
        PanelTotalExplorar.add(GuardadoBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 380, 250, 40));

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
        PanelTotalExplorar.add(PerfilBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 440, 250, 40));

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
        PanelTotalExplorar.add(PublicacionesBtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 560, 100, 30));

        QuePasa.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        QuePasa.setForeground(new java.awt.Color(204, 204, 204));
        QuePasa.setText("Qué pasa");
        PanelTotalExplorar.add(QuePasa, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 370, 210, 30));

        SeguirCuentaBtn3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        SeguirCuentaBtn3.setText("Seguir");
        PanelTotalExplorar.add(SeguirCuentaBtn3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1400, 230, -1, 30));

        SeguirCuentaBtn1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        SeguirCuentaBtn1.setText("Seguir");
        PanelTotalExplorar.add(SeguirCuentaBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1400, 130, -1, 30));

        SeguirCuentaBtn2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        SeguirCuentaBtn2.setText("Seguir");
        PanelTotalExplorar.add(SeguirCuentaBtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1400, 180, -1, 30));

        jSeparator6.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator6.setForeground(new java.awt.Color(153, 153, 153));
        jSeparator6.setOrientation(javax.swing.SwingConstants.VERTICAL);
        PanelTotalExplorar.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 80, 30, 220));
        PanelTotalExplorar.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 300, 280, 20));
        PanelTotalExplorar.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 80, 280, 10));

        TePuedeInteresarLbl.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        TePuedeInteresarLbl.setForeground(new java.awt.Color(204, 204, 204));
        TePuedeInteresarLbl.setText("Te puede interesar");
        PanelTotalExplorar.add(TePuedeInteresarLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 80, 210, 30));

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
        PanelTotalExplorar.add(TendenciaYapBtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 490, 130, 50));

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
        PanelTotalExplorar.add(MostrarMasTendenciaBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 580, 80, 50));

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
        PanelTotalExplorar.add(CuentaBtn20, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 390, 80, 30));

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
        PanelTotalExplorar.add(TendenciaYapBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 410, 130, 50));

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
        PanelTotalExplorar.add(PublicacionesBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 460, 100, 50));

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
        PanelTotalExplorar.add(MostrarMasInteresBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 260, 80, 50));

        ImgInt3.setForeground(new java.awt.Color(255, 255, 255));
        ImgInt3.setText("ImgInteres2");
        PanelTotalExplorar.add(ImgInt3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 220, 60, 50));

        ImgInt1.setForeground(new java.awt.Color(255, 255, 255));
        ImgInt1.setText("ImgInteres1");
        PanelTotalExplorar.add(ImgInt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 120, 60, 50));

        ImgInt2.setForeground(new java.awt.Color(255, 255, 255));
        ImgInt2.setText("ImgInteres2");
        PanelTotalExplorar.add(ImgInt2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 170, 60, 50));

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
        PanelTotalExplorar.add(UserInt3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 230, -1, 30));

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
        PanelTotalExplorar.add(UserInt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 130, -1, 30));

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
        PanelTotalExplorar.add(UserInt2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 180, -1, 30));

        jSeparator4.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator4.setForeground(new java.awt.Color(153, 153, 153));
        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);
        PanelTotalExplorar.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 0, 10, 1040));

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
        PerfilPanel.add(Perfil_Img2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 50, 50));
        PerfilPanel.add(Perfil_Img, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 50, 40));

        PanelTotalExplorar.add(PerfilPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 720, 270, 60));

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
        PanelTotalExplorar.add(PostearBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 680, 200, 40));

        jSeparator7.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator7.setForeground(new java.awt.Color(153, 153, 153));
        jSeparator7.setOrientation(javax.swing.SwingConstants.VERTICAL);
        PanelTotalExplorar.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1490, 80, 20, 220));

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
        PanelTotalExplorar.add(ExplorarBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, 250, 40));

        RecientesImg.setForeground(new java.awt.Color(255, 255, 255));
        RecientesImg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PanelTotalExplorar.add(RecientesImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 710, 70, 70));

        IconoExplorar.setBackground(new java.awt.Color(166, 77, 121));
        IconoExplorar.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        IconoExplorar.setForeground(new java.awt.Color(204, 204, 204));
        IconoExplorar.setToolTipText("");
        IconoExplorar.setAlignmentY(0.0F);
        IconoExplorar.setBorderPainted(false);
        IconoExplorar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        IconoExplorar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IconoExplorarActionPerformed(evt);
            }
        });
        PanelTotalExplorar.add(IconoExplorar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, 60, 60));

        ExplorarTitulo.setFont(new java.awt.Font("Roboto Black", 1, 30)); // NOI18N
        ExplorarTitulo.setForeground(new java.awt.Color(204, 204, 204));
        ExplorarTitulo.setText("Explorar");
        PanelTotalExplorar.add(ExplorarTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 20, 250, 40));
        PanelTotalExplorar.add(Y_logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, 90, 80));

        Busqueda_TxtFld.setBackground(new java.awt.Color(0, 0, 0));
        Busqueda_TxtFld.setForeground(new java.awt.Color(255, 255, 255));
        PanelTotalExplorar.add(Busqueda_TxtFld, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 40, 250, 30));

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("🔍Buscar\n");
        PanelTotalExplorar.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 20, 80, -1));

        Busquedas_jTabbePane.setBackground(new java.awt.Color(102, 102, 102));
        Busquedas_jTabbePane.setForeground(new java.awt.Color(204, 204, 204));

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelNot1.setBackground(new java.awt.Color(59, 28, 50));
        PanelNot1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        PanelNot1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lblUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lblUsuario.setText("ImgNot");

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
        lblLikesLabel.setText("0");

        lblComentarLabel.setForeground(new java.awt.Color(255, 255, 255));
        lblComentarLabel.setText("0");

        lblRepostearLabel.setForeground(new java.awt.Color(255, 255, 255));
        lblRepostearLabel.setText("0");

        Nombre_usuarioBtn.setBackground(new java.awt.Color(59, 28, 50));
        Nombre_usuarioBtn.setForeground(new java.awt.Color(255, 255, 255));
        Nombre_usuarioBtn.setText("Nombre_usuario");
        Nombre_usuarioBtn.setBorder(null);
        Nombre_usuarioBtn.setBorderPainted(false);
        Nombre_usuarioBtn.setContentAreaFilled(false);

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

        Fecha_Label.setForeground(new java.awt.Color(255, 255, 255));
        Fecha_Label.setText("Fecha_posts");

        lblTexto_publicacion.setForeground(new java.awt.Color(255, 255, 255));
        lblTexto_publicacion.setText("Texto_publicacion");

        javax.swing.GroupLayout PanelNot1Layout = new javax.swing.GroupLayout(PanelNot1);
        PanelNot1.setLayout(PanelNot1Layout);
        PanelNot1Layout.setHorizontalGroup(
            PanelNot1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelNot1Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(PanelNot1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelNot1Layout.createSequentialGroup()
                        .addComponent(lblUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(Nombre_usuarioBtn)
                        .addGap(13, 13, 13)
                        .addComponent(UsuarioPub5)
                        .addGap(18, 18, 18)
                        .addComponent(Fecha_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblTexto_publicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelNot1Layout.createSequentialGroup()
                        .addComponent(meGustaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(comentarBtn)
                        .addGap(44, 44, 44)
                        .addComponent(repostearBtn))
                    .addGroup(PanelNot1Layout.createSequentialGroup()
                        .addComponent(lblLikesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addGroup(PanelNot1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblComentarLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(PanelNot1Layout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addComponent(lblRepostearLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))))
        );
        PanelNot1Layout.setVerticalGroup(
            PanelNot1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelNot1Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(PanelNot1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelNot1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(Nombre_usuarioBtn))
                    .addGroup(PanelNot1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(UsuarioPub5))
                    .addGroup(PanelNot1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(Fecha_Label))
                    .addGroup(PanelNot1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(lblTexto_publicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addGroup(PanelNot1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(meGustaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comentarBtn)
                    .addComponent(repostearBtn))
                .addGap(10, 10, 10)
                .addGroup(PanelNot1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLikesLabel)
                    .addComponent(lblComentarLabel)
                    .addComponent(lblRepostearLabel)))
        );

        jPanel3.add(PanelNot1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 450, 200));

        ImagenPublicacion_lbl.setForeground(new java.awt.Color(255, 255, 255));
        ImagenPublicacion_lbl.setText("ImagenPublicacion1");
        jPanel3.add(ImagenPublicacion_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 450, 270, 150));

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

        comentarBtn1.setBackground(new java.awt.Color(106, 30, 85));
        comentarBtn1.setForeground(new java.awt.Color(255, 255, 255));
        comentarBtn1.setText("-");
        comentarBtn1.setBorder(null);
        comentarBtn1.setBorderPainted(false);
        comentarBtn1.setContentAreaFilled(false);
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
        PanelNot4.add(repostearBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, -1, -1));

        lblLikesLabel1.setForeground(new java.awt.Color(255, 255, 255));
        lblLikesLabel1.setText("0");
        PanelNot4.add(lblLikesLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 80, -1));

        lblComentarLabel1.setForeground(new java.awt.Color(255, 255, 255));
        lblComentarLabel1.setText("0");
        PanelNot4.add(lblComentarLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, 80, -1));

        lblRepostearLabel1.setForeground(new java.awt.Color(255, 255, 255));
        lblRepostearLabel1.setText("0");
        PanelNot4.add(lblRepostearLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, 90, -1));

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

        jPanel3.add(PanelNot4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 450, 200));

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

        comentarBtn2.setBackground(new java.awt.Color(166, 77, 121));
        comentarBtn2.setForeground(new java.awt.Color(255, 255, 255));
        comentarBtn2.setText("-");
        comentarBtn2.setBorder(null);
        comentarBtn2.setBorderPainted(false);
        comentarBtn2.setContentAreaFilled(false);
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
        PanelNot5.add(repostearBtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, -1, -1));

        lblLikesLabel2.setForeground(new java.awt.Color(255, 255, 255));
        lblLikesLabel2.setText("0");
        PanelNot5.add(lblLikesLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 80, -1));

        lblComentarLabel2.setForeground(new java.awt.Color(255, 255, 255));
        lblComentarLabel2.setText("0");
        PanelNot5.add(lblComentarLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, 80, -1));

        lblRepostearLabel2.setForeground(new java.awt.Color(255, 255, 255));
        lblRepostearLabel2.setText("0");
        PanelNot5.add(lblRepostearLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 90, -1));

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

        jPanel3.add(PanelNot5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, 450, 200));

        ImagenPublicacion_lbl1.setForeground(new java.awt.Color(255, 255, 255));
        ImagenPublicacion_lbl1.setText("ImagenPublicacion1");
        jPanel3.add(ImagenPublicacion_lbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 140, 280, 150));

        ImagenPublicacion_lbl2.setForeground(new java.awt.Color(255, 255, 255));
        ImagenPublicacion_lbl2.setText("ImagenPublicacion1");
        jPanel3.add(ImagenPublicacion_lbl2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 30, 270, 150));

        ImagenPublicacion_lbl3.setForeground(new java.awt.Color(255, 255, 255));
        ImagenPublicacion_lbl3.setText("ImagenPublicacion1");
        jPanel3.add(ImagenPublicacion_lbl3, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 230, 270, 150));

        Busquedas_jTabbePane.addTab("Publicaciones", jPanel3);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        UserResu1_Btn.setFont(new java.awt.Font("Roboto", 1, 22)); // NOI18N
        UserResu1_Btn.setForeground(new java.awt.Color(204, 204, 204));
        UserResu1_Btn.setText("Usuario");
        UserResu1_Btn.setToolTipText("");
        UserResu1_Btn.setBorder(null);
        UserResu1_Btn.setBorderPainted(false);
        UserResu1_Btn.setContentAreaFilled(false);
        UserResu1_Btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        UserResu1_Btn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        UserResu1_Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserResu1_BtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout EjemploBusquedas2Layout = new javax.swing.GroupLayout(EjemploBusquedas2);
        EjemploBusquedas2.setLayout(EjemploBusquedas2Layout);
        EjemploBusquedas2Layout.setHorizontalGroup(
            EjemploBusquedas2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EjemploBusquedas2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ImgResu2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(EjemploBusquedas2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(EjemploBusquedas2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(EjemploBusquedas2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(EjemploBusquedas2Layout.createSequentialGroup()
                                .addComponent(UserResu1_Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(EjemploBusquedas2Layout.createSequentialGroup()
                                .addComponent(UserResu2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 465, Short.MAX_VALUE)
                                .addComponent(NoSeguidoresResu2, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SeguidoresResu2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        EjemploBusquedas2Layout.setVerticalGroup(
            EjemploBusquedas2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EjemploBusquedas2Layout.createSequentialGroup()
                .addGroup(EjemploBusquedas2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EjemploBusquedas2Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(UserResu1_Btn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(UserResu2)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel5)
                        .addGap(0, 6, Short.MAX_VALUE))
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

        jPanel1.add(EjemploBusquedas2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

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

        UserResu1_Btn1.setFont(new java.awt.Font("Roboto", 1, 22)); // NOI18N
        UserResu1_Btn1.setForeground(new java.awt.Color(204, 204, 204));
        UserResu1_Btn1.setText("Usuario");
        UserResu1_Btn1.setToolTipText("");
        UserResu1_Btn1.setBorder(null);
        UserResu1_Btn1.setBorderPainted(false);
        UserResu1_Btn1.setContentAreaFilled(false);
        UserResu1_Btn1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        UserResu1_Btn1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        UserResu1_Btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserResu1_Btn1ActionPerformed(evt);
            }
        });

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
                        .addGroup(EjemploBusqueda6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(EjemploBusqueda6Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(UserResu3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 465, Short.MAX_VALUE)
                                .addComponent(NoSeguidoresResu3, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SeguidoresResu3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(EjemploBusqueda6Layout.createSequentialGroup()
                        .addComponent(UserResu1_Btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        EjemploBusqueda6Layout.setVerticalGroup(
            EjemploBusqueda6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EjemploBusqueda6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(EjemploBusqueda6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(EjemploBusqueda6Layout.createSequentialGroup()
                        .addComponent(UserResu1_Btn1)
                        .addGap(4, 4, 4)
                        .addComponent(UserResu3)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel6)
                        .addGap(0, 16, Short.MAX_VALUE))
                    .addComponent(ImgResu3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EjemploBusqueda6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(EjemploBusqueda6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SeguidoresResu3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NoSeguidoresResu3)))
        );

        jPanel1.add(EjemploBusqueda6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

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

        UserResu1_Btn2.setFont(new java.awt.Font("Roboto", 1, 22)); // NOI18N
        UserResu1_Btn2.setForeground(new java.awt.Color(204, 204, 204));
        UserResu1_Btn2.setText("Usuario");
        UserResu1_Btn2.setToolTipText("");
        UserResu1_Btn2.setBorder(null);
        UserResu1_Btn2.setBorderPainted(false);
        UserResu1_Btn2.setContentAreaFilled(false);
        UserResu1_Btn2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        UserResu1_Btn2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        UserResu1_Btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserResu1_Btn2ActionPerformed(evt);
            }
        });

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
                        .addGroup(EjemploBusquedas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(EjemploBusquedas1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(UserResu1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 465, Short.MAX_VALUE)
                                .addComponent(NoSeguidoresResu1, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SeguidoresResu1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(EjemploBusquedas1Layout.createSequentialGroup()
                        .addComponent(UserResu1_Btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        EjemploBusquedas1Layout.setVerticalGroup(
            EjemploBusquedas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EjemploBusquedas1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(EjemploBusquedas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(EjemploBusquedas1Layout.createSequentialGroup()
                        .addComponent(UserResu1_Btn2)
                        .addGap(4, 4, 4)
                        .addComponent(UserResu1)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel4)
                        .addGap(0, 16, Short.MAX_VALUE))
                    .addComponent(ImgRes1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EjemploBusquedas1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(EjemploBusquedas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SeguidoresResu1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NoSeguidoresResu1)))
        );

        jPanel1.add(EjemploBusquedas1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, -1, -1));

        Resultados_JLabel.setBackground(new java.awt.Color(0, 0, 0));
        Resultados_JLabel.setForeground(new java.awt.Color(255, 255, 255));
        Resultados_JLabel.setText("Resultados encontrados");
        jPanel1.add(Resultados_JLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 310, -1));

        Busquedas_jTabbePane.addTab("Usuarios", jPanel1);

        Busquedas_jTabbePane.setSelectedIndex(1);

        PanelTotalExplorar.add(Busquedas_jTabbePane, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 110, 750, 690));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelTotalExplorar, javax.swing.GroupLayout.PREFERRED_SIZE, 1550, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelTotalExplorar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 820, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BusquedaTodoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BusquedaTodoBtnActionPerformed
        // TODO add your handling code here:
        Busquedas_jTabbePane.setSelectedIndex(0);
    }//GEN-LAST:event_BusquedaTodoBtnActionPerformed

    private void ConfiBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfiBtnActionPerformed
       this.dispose();
        new Configuracion().setVisible(true);
    }//GEN-LAST:event_ConfiBtnActionPerformed

    private void InicioBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InicioBtn1ActionPerformed
        this.dispose();
        new Menu_Principal().setVisible(true);
    }//GEN-LAST:event_InicioBtn1ActionPerformed

    private void ComunidadesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComunidadesBtnActionPerformed
        this.dispose();
        new Comunidad().setVisible(true);
    }//GEN-LAST:event_ComunidadesBtnActionPerformed

    private void NotificacionesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NotificacionesBtnActionPerformed
       this.dispose();
        new Notificaciones().setVisible(true);
    }//GEN-LAST:event_NotificacionesBtnActionPerformed

    private void GuardadoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardadoBtnActionPerformed
        this.dispose();
        new Guardados().setVisible(true);    }//GEN-LAST:event_GuardadoBtnActionPerformed

    private void PerfilBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PerfilBtnActionPerformed
        this.dispose();
        new Perfil().setVisible(true);
    }//GEN-LAST:event_PerfilBtnActionPerformed

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

    private void ExplorarBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExplorarBtn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ExplorarBtn1ActionPerformed

    private void IconoExplorarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IconoExplorarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IconoExplorarActionPerformed

    private void BusquedaTodoBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BusquedaTodoBtn1ActionPerformed
        // TODO add your handling code here:
        Busquedas_jTabbePane.setSelectedIndex(1);
    }//GEN-LAST:event_BusquedaTodoBtn1ActionPerformed

    private void UserResu1_BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserResu1_BtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UserResu1_BtnActionPerformed

    private void UserResu1_Btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserResu1_Btn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UserResu1_Btn1ActionPerformed

    private void UserResu1_Btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserResu1_Btn2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UserResu1_Btn2ActionPerformed

    private void BuscarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarBtnActionPerformed
        // TODO add your handling code here:
        String textoBusqueda = Busqueda_TxtFld.getText().trim();
        mostrarResultadosUsuarios(textoBusqueda);
    }//GEN-LAST:event_BuscarBtnActionPerformed

    private void meGustaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meGustaBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_meGustaBtnActionPerformed

    private void comentarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comentarBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comentarBtnActionPerformed

    private void repostearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_repostearBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_repostearBtnActionPerformed

    private void UsuarioPub5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsuarioPub5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UsuarioPub5ActionPerformed

    private void meGustaBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meGustaBtn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_meGustaBtn1ActionPerformed

    private void repostearBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_repostearBtn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_repostearBtn1ActionPerformed

    private void UsuarioPub6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsuarioPub6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UsuarioPub6ActionPerformed

    private void lblUsuario2AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_lblUsuario2AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_lblUsuario2AncestorAdded

    private void meGustaBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meGustaBtn2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_meGustaBtn2ActionPerformed

    private void repostearBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_repostearBtn2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_repostearBtn2ActionPerformed

    private void UsuarioPub7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsuarioPub7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UsuarioPub7ActionPerformed

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
    private javax.swing.JLabel AmigosImg1;
    private javax.swing.JButton BuscarBtn;
    private javax.swing.JButton BusquedaTodoBtn;
    private javax.swing.JButton BusquedaTodoBtn1;
    private javax.swing.JTextField Busqueda_TxtFld;
    private javax.swing.JTabbedPane Busquedas_jTabbePane;
    private javax.swing.JButton ComunidadesBtn;
    private javax.swing.JButton ConfiBtn;
    private javax.swing.JButton CuentaBtn20;
    private javax.swing.JPanel EjemploBusqueda6;
    private javax.swing.JPanel EjemploBusquedas1;
    private javax.swing.JPanel EjemploBusquedas2;
    private javax.swing.JButton ExplorarBtn1;
    private javax.swing.JLabel ExplorarTitulo;
    private javax.swing.JLabel Fecha_Label;
    private javax.swing.JLabel Fecha_Label1;
    private javax.swing.JLabel Fecha_Label2;
    private javax.swing.JButton GuardadoBtn;
    private javax.swing.JButton IconoExplorar;
    private javax.swing.JLabel IdUsuario2;
    private javax.swing.JLabel ImagenPublicacion_lbl;
    private javax.swing.JLabel ImagenPublicacion_lbl1;
    private javax.swing.JLabel ImagenPublicacion_lbl2;
    private javax.swing.JLabel ImagenPublicacion_lbl3;
    private javax.swing.JLabel ImgInt1;
    private javax.swing.JLabel ImgInt2;
    private javax.swing.JLabel ImgInt3;
    private javax.swing.JLabel ImgRes1;
    private javax.swing.JLabel ImgResu2;
    private javax.swing.JLabel ImgResu3;
    private javax.swing.JButton InicioBtn1;
    private javax.swing.JButton MostrarMasInteresBtn;
    private javax.swing.JButton MostrarMasTendenciaBtn;
    private javax.swing.JButton NoSeguidoresResu1;
    private javax.swing.JButton NoSeguidoresResu2;
    private javax.swing.JButton NoSeguidoresResu3;
    private javax.swing.JLabel NombreUsuario;
    private javax.swing.JButton Nombre_usuarioBtn;
    private javax.swing.JButton Nombre_usuarioBtn1;
    private javax.swing.JButton Nombre_usuarioBtn2;
    private javax.swing.JButton NotificacionesBtn;
    private javax.swing.JPanel PanelNot1;
    private javax.swing.JPanel PanelNot4;
    private javax.swing.JPanel PanelNot5;
    private javax.swing.JPanel PanelTotalExplorar;
    private javax.swing.JButton PerfilBtn;
    private javax.swing.JPanel PerfilPanel;
    private javax.swing.JLabel Perfil_Img;
    private javax.swing.JLabel Perfil_Img2;
    private javax.swing.JButton PostearBtn;
    private javax.swing.JButton PublicacionesBtn1;
    private javax.swing.JButton PublicacionesBtn2;
    private javax.swing.JLabel QuePasa;
    private javax.swing.JLabel RecientesImg;
    private javax.swing.JLabel Resultados_JLabel;
    private javax.swing.JButton SeguidoresResu1;
    private javax.swing.JButton SeguidoresResu2;
    private javax.swing.JButton SeguidoresResu3;
    private javax.swing.JButton SeguirCuentaBtn1;
    private javax.swing.JButton SeguirCuentaBtn2;
    private javax.swing.JButton SeguirCuentaBtn3;
    private javax.swing.JLabel TePuedeInteresarLbl;
    private javax.swing.JButton TendenciaYapBtn1;
    private javax.swing.JButton TendenciaYapBtn2;
    private javax.swing.JButton UserInt1;
    private javax.swing.JButton UserInt2;
    private javax.swing.JButton UserInt3;
    private javax.swing.JButton UserResu1;
    private javax.swing.JButton UserResu1_Btn;
    private javax.swing.JButton UserResu1_Btn1;
    private javax.swing.JButton UserResu1_Btn2;
    private javax.swing.JButton UserResu2;
    private javax.swing.JButton UserResu3;
    private javax.swing.JButton UsuarioPub5;
    private javax.swing.JButton UsuarioPub6;
    private javax.swing.JButton UsuarioPub7;
    private javax.swing.JLabel Y_logo;
    private javax.swing.JButton comentarBtn;
    private javax.swing.JButton comentarBtn1;
    private javax.swing.JButton comentarBtn2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
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
