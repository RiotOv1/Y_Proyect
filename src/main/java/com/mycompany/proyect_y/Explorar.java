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
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Explorar extends javax.swing.JFrame {
    int xMouse;
    int yMouse;
    private UsuariosDAO usuarioDao;
    private PublicacionDAO publicacionDAO;
    /*private List<Usuarios> usuarioss;
    private List<Publicacion> publicaciones;*/
    private int ResPublicadoAct = 0;
    private int currentUserPanel = 0;
    private int currentPubPanel = 0;
    private int publicacionActual2 = 0;
    private int usuariosActuales = 0;
    List<Usuarios> usuarios;
    List<Publicacion> publicacioness;
    private boolean hayPublicaciones = false;
    private boolean hayUsuarios = false;
    private String textoBusqueda;
    private static final int USER_PER_PAGE = 5; //Mostrar 5 usuarios por pagina
    private int currentUserGroup = 0 ; //Para manejar grupos de usuarios
    private Publicacion publicacionId;
    private List<Publicacion> publicaciones, publicacionesSeguidos;
    private int publicacionActual = 0,publicacionSeguidoActual = 0, publicacionTrend1 = 0, publicacionTrend2 = 0, publicacionTrend3 = 0;
    private String Interes1,Interes2,Interes3;
    String UsuarioPubActual;
    
    public Explorar() {
        initComponents();
        this.setLocationRelativeTo(null);
        Img();
        cargarFotoPerfil(); 
        limpiarPaneles();
        SeccionTePuedeInteresar();
        SeccionTendencias();
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
        Perfil_Img2.setIcon(Icono);

        //IconoInicio
        String url1 = "src\\main\\java\\Multimedia\\Icon-Inicio.png";
        ImageIcon image1 = new ImageIcon(url1);
        Image img1 = image1.getImage().getScaledInstance(32, 32, 0);
        ImageIcon Icono1 = new ImageIcon(img1);
        InicioBtn.setIcon(Icono1);

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
        ExplorarBtn4.setIcon(Icono23);
        
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
        limpiarPaneles(); 
        
        if(textoBusqueda.isEmpty()){
            return;
        }
        
        //Limpiar paneles antes de una busqueda
        //limpiarPaneles();
        
        //Buscar en la base de datos
        usuarios = usuarioDao.buscarUsuarios(textoBusqueda,1,USER_PER_PAGE);
        hayUsuarios = !usuarios.isEmpty();
        publicacioness = publicacionDAO.buscarPublicacionesResult(textoBusqueda,1,1);
        hayPublicaciones = !publicacioness.isEmpty();
        
        //Mostrar primer grupo de usuarios
        if(hayUsuarios) mostrarGrupoUsuarios(usuarios);
        
        if(hayPublicaciones){
            configurarPanelPublicacion(PanelNot2, publicacioness.get(0),
                    lblUsuario1, Nombre_usuarioBtn1, UsuarioPub6,
                lblTexto_publicacion1, Fecha_Label1,
                meGustaBtn1, lblLikesLabel1,
                repostearBtn1, lblRepostearLabel1, ImagenPublicacion_lbl4, comentarBtn1);
            PanelNot2.setVisible(true);
        }
        
        
        
        
    }
    
    private void mostrarSiguienteGrupoUsuarios(){
        if(!hayUsuarios) return;
        
        //Obtener el siguiente cuerpode usuarios
        List<Usuarios> usuariosGrupo = usuarioDao.buscarUsuarios(textoBusqueda, currentUserGroup+1, USER_PER_PAGE);
        
        if(usuariosGrupo.isEmpty()){
            //Volver al primer grupo si llegamos al final
            currentUserGroup = 0;
            usuariosGrupo = usuarioDao.buscarUsuarios(textoBusqueda,1,USER_PER_PAGE);
        }
        else currentUserGroup++;
        
        mostrarGrupoUsuarios(usuariosGrupo);    
    }
    
    private void limpiarPaneles(){
        //Ocultar todos los paneles de usuarios
        for(int i = 0;i < 5; i++){
            getPanelUsuario(i).setVisible(false);
        }
        
        //Ocultar todos los paneles de publicaciones
            PanelNot2.setVisible(false);
            /*ImagenPublicacion_lbl.setVisible(false);
            lblUsuario.setVisible(false);
            ImagenPublicacion_lbl3.setVisible(false);*/
        
        currentUserPanel = 0;
        currentPubPanel = 0;
    }
    
    private void mostrarGrupoUsuarios(List<Usuarios> usuariosGrupo){
        //Primero ocultar todos los paneles
        limpiarPaneles();
        
        currentUserPanel = 0;
        for(Usuarios usuario : usuariosGrupo){
            if(currentUserPanel >= USER_PER_PAGE) break;
            JPanel panelUsuario = getPanelUsuario(currentUserPanel);
            configurarPanelUsuario(
                    getPanelUsuario(currentUserPanel), usuario,
                    getBotonNombreUsuario(currentUserPanel),
                    getBotonCorreoUsuario(currentUserPanel),
                    getFotoPerfil(currentUserPanel)
            );
            panelUsuario.setVisible(true);
            currentUserPanel++;
        }
    }
    
    //Metodos auxiliares para obtener los paneles y componentes
    private JPanel getPanelUsuario(int index){
        switch(index){
            case 0: return EjemploBusquedas3; //EjemploBusquedas3
            case 1: return EjemploBusqueda6; //EjemploBusqueda6
            case 2: return EjemploBusquedas1; //EjemploBusquedas1
            case 3: return EjemploBusquedas2; //EjemploBusquedas2
            case 4: return EjemploBusquedas4; //EjemploBusquedas4
            default: return null;
        }
    }
    
    private JButton getBotonNombreUsuario(int index){
        switch(index){
            case 0: return UserResu1_Btn3; //UserResu1_Btn3
            case 1: return UserResu1_Btn1; //UserResu1_Btn1
            case 2: return UserResu1_Btn2; //UserResu1_Btn2
            case 3: return UserResu1_Btn; //UserResu1_Btn
            case 4: return UserResu1_Btn4; //UserResu1_Btn4
            default: return null;
        }
    }
    
    private JButton getBotonCorreoUsuario(int index){
        switch(index){
            case 0: return UserResu4; //UserResu4
            case 1: return UserResu3; //UserResu3
            case 2: return UserResu1; //UserResu1
            case 3: return UserResu2; //UserResu2
            case 4: return UserResu5; //UserResu5
            default: return null;
        }
    }
    
    private JLabel getFotoPerfil(int index){
        switch(index){
            case 0: return ImgResu4; //ImgResu4
            case 1: return ImgResu3; //ImgResu3
            case 2: return ImgRes1; //ImgRes1
            case 3: return ImgRes2; //ImgRes2
            case 4: return ImgResu3; //ImgResu3
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
        UsuarioPubActual = publica.getIdUsuario();
        
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
        jSeparator1 = new javax.swing.JSeparator();
        BuscarBtn = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        BusquedaTodoBtn = new javax.swing.JButton();
        BusquedaTodoBtn1 = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        IconoExplorar = new javax.swing.JButton();
        ExplorarTitulo = new javax.swing.JLabel();
        Busqueda_TxtFld = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        Busquedas_jTabbePane = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        ImagenPublicacion_lbl1 = new javax.swing.JLabel();
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
        ImagenPublicacion_lbl4 = new javax.swing.JLabel();
        SiguienteBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
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
        EjemploBusquedas3 = new javax.swing.JPanel();
        UserResu4 = new javax.swing.JButton();
        SeguidoresResu4 = new javax.swing.JButton();
        NoSeguidoresResu4 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        ImgResu4 = new javax.swing.JLabel();
        UserResu1_Btn3 = new javax.swing.JButton();
        EjemploBusquedas4 = new javax.swing.JPanel();
        UserResu5 = new javax.swing.JButton();
        SeguidoresResu5 = new javax.swing.JButton();
        NoSeguidoresResu5 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        ImgRes2 = new javax.swing.JLabel();
        UserResu1_Btn4 = new javax.swing.JButton();
        SiguienteBtn1 = new javax.swing.JButton();
        PerfilPanel = new javax.swing.JPanel();
        NombreUsuario = new javax.swing.JLabel();
        IdUsuario2 = new javax.swing.JLabel();
        Perfil_Img2 = new javax.swing.JLabel();
        ConfiBtn = new javax.swing.JButton();
        InicioBtn = new javax.swing.JButton();
        NotificacionesBtn = new javax.swing.JButton();
        PerfilBtn = new javax.swing.JButton();
        ExplorarBtn4 = new javax.swing.JButton();
        Y_logo = new javax.swing.JLabel();
        Header = new javax.swing.JPanel();
        ExitPane = new javax.swing.JPanel();
        ExitBtn = new javax.swing.JLabel();
        QuePasa = new javax.swing.JLabel();
        SeguirCuentaBtn3 = new javax.swing.JButton();
        SeguirCuentaBtn1 = new javax.swing.JButton();
        SeguirCuentaBtn2 = new javax.swing.JButton();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
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
        jSeparator10 = new javax.swing.JSeparator();
        LabelAviso2 = new javax.swing.JLabel();
        Num_Reacciones = new javax.swing.JLabel();
        TendenciaYapBtn1 = new javax.swing.JButton();
        numreacciones1 = new javax.swing.JButton();
        Num_Reacciones1 = new javax.swing.JLabel();
        TendenciaYapBtn2 = new javax.swing.JButton();
        numreacciones2 = new javax.swing.JButton();
        Num_Reacciones2 = new javax.swing.JLabel();
        jSeparator12 = new javax.swing.JSeparator();
        jSeparator13 = new javax.swing.JSeparator();
        jSeparator14 = new javax.swing.JSeparator();
        jSeparator15 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(26, 26, 29));
        setLocationByPlatform(true);
        setMinimumSize(new java.awt.Dimension(1550, 820));
        setUndecorated(true);
        setResizable(false);

        PanelTotalExplorar.setBackground(new java.awt.Color(0, 0, 0));
        PanelTotalExplorar.setPreferredSize(new java.awt.Dimension(1550, 890));
        PanelTotalExplorar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator1.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator1.setForeground(new java.awt.Color(153, 153, 153));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        PanelTotalExplorar.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 50, -1, 1040));

        BuscarBtn.setBackground(new java.awt.Color(166, 77, 121));
        BuscarBtn.setForeground(new java.awt.Color(255, 255, 255));
        BuscarBtn.setText("Buscar");
        BuscarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarBtnActionPerformed(evt);
            }
        });
        PanelTotalExplorar.add(BuscarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 90, 140, 30));

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PanelTotalExplorar.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 130, 750, 40));

        jSeparator4.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator4.setForeground(new java.awt.Color(153, 153, 153));
        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);
        PanelTotalExplorar.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 50, 10, 1040));

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
        PanelTotalExplorar.add(IconoExplorar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 60, 60, 60));

        ExplorarTitulo.setFont(new java.awt.Font("Roboto Black", 1, 30)); // NOI18N
        ExplorarTitulo.setForeground(new java.awt.Color(204, 204, 204));
        ExplorarTitulo.setText("Explorar");
        PanelTotalExplorar.add(ExplorarTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 70, 250, 40));

        Busqueda_TxtFld.setBackground(new java.awt.Color(0, 0, 0));
        Busqueda_TxtFld.setForeground(new java.awt.Color(255, 255, 255));
        PanelTotalExplorar.add(Busqueda_TxtFld, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 90, 250, 30));

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("🔍Buscar\n");
        PanelTotalExplorar.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 70, 80, -1));

        Busquedas_jTabbePane.setBackground(new java.awt.Color(102, 102, 102));
        Busquedas_jTabbePane.setForeground(new java.awt.Color(204, 204, 204));

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ImagenPublicacion_lbl1.setForeground(new java.awt.Color(255, 255, 255));
        ImagenPublicacion_lbl1.setText("ImagenPublicacion1");
        jPanel3.add(ImagenPublicacion_lbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 140, 280, 150));

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

        ImagenPublicacion_lbl4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ImagenPublicacion_lbl4.setForeground(new java.awt.Color(204, 204, 204));
        ImagenPublicacion_lbl4.setText("Sin multimedia disponible");

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
                .addGroup(PanelNot2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelNot2Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(lblTexto_publicacion1, javax.swing.GroupLayout.PREFERRED_SIZE, 690, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelNot2Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(ImagenPublicacion_lbl4, javax.swing.GroupLayout.PREFERRED_SIZE, 690, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelNot2Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
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
                        .addComponent(repostearBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addGap(0, 0, 0)
                .addComponent(ImagenPublicacion_lbl4, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(PanelNot2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLikesLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(meGustaBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblComentarLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comentarBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRepostearLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(repostearBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel3.add(PanelNot2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

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
        jPanel3.add(SiguienteBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 560, 380, 60));

        jLabel1.setText("jLabel1");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 600, -1, -1));

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

        jPanel1.add(EjemploBusquedas2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, -1, -1));

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
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 469, Short.MAX_VALUE)
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
                        .addGap(0, 20, Short.MAX_VALUE))
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

        EjemploBusquedas3.setBackground(new java.awt.Color(106, 30, 85));
        EjemploBusquedas3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        EjemploBusquedas3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

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

        UserResu1_Btn3.setFont(new java.awt.Font("Roboto", 1, 22)); // NOI18N
        UserResu1_Btn3.setForeground(new java.awt.Color(204, 204, 204));
        UserResu1_Btn3.setText("Usuario");
        UserResu1_Btn3.setToolTipText("");
        UserResu1_Btn3.setBorder(null);
        UserResu1_Btn3.setBorderPainted(false);
        UserResu1_Btn3.setContentAreaFilled(false);
        UserResu1_Btn3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        UserResu1_Btn3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        UserResu1_Btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserResu1_Btn3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout EjemploBusquedas3Layout = new javax.swing.GroupLayout(EjemploBusquedas3);
        EjemploBusquedas3.setLayout(EjemploBusquedas3Layout);
        EjemploBusquedas3Layout.setHorizontalGroup(
            EjemploBusquedas3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EjemploBusquedas3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ImgResu4, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(EjemploBusquedas3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(EjemploBusquedas3Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(EjemploBusquedas3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(EjemploBusquedas3Layout.createSequentialGroup()
                                .addComponent(UserResu1_Btn3, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(EjemploBusquedas3Layout.createSequentialGroup()
                                .addComponent(UserResu4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 465, Short.MAX_VALUE)
                                .addComponent(NoSeguidoresResu4, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SeguidoresResu4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        EjemploBusquedas3Layout.setVerticalGroup(
            EjemploBusquedas3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EjemploBusquedas3Layout.createSequentialGroup()
                .addGroup(EjemploBusquedas3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EjemploBusquedas3Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(UserResu1_Btn3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(UserResu4)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel7)
                        .addGap(0, 6, Short.MAX_VALUE))
                    .addGroup(EjemploBusquedas3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(ImgResu4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EjemploBusquedas3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(EjemploBusquedas3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SeguidoresResu4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NoSeguidoresResu4)))
        );

        jPanel1.add(EjemploBusquedas3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        EjemploBusquedas4.setBackground(new java.awt.Color(59, 28, 50));
        EjemploBusquedas4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        EjemploBusquedas4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        UserResu5.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        UserResu5.setForeground(new java.awt.Color(204, 204, 204));
        UserResu5.setText("@Usuario");
        UserResu5.setToolTipText("");
        UserResu5.setBorder(null);
        UserResu5.setBorderPainted(false);
        UserResu5.setContentAreaFilled(false);
        UserResu5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        UserResu5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        UserResu5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserResu5ActionPerformed(evt);
            }
        });

        SeguidoresResu5.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        SeguidoresResu5.setForeground(new java.awt.Color(204, 204, 204));
        SeguidoresResu5.setText("Seguidores");
        SeguidoresResu5.setBorder(null);
        SeguidoresResu5.setBorderPainted(false);
        SeguidoresResu5.setContentAreaFilled(false);
        SeguidoresResu5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SeguidoresResu5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        SeguidoresResu5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SeguidoresResu5ActionPerformed(evt);
            }
        });

        NoSeguidoresResu5.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        NoSeguidoresResu5.setForeground(new java.awt.Color(204, 204, 204));
        NoSeguidoresResu5.setText("0");
        NoSeguidoresResu5.setBorder(null);
        NoSeguidoresResu5.setBorderPainted(false);
        NoSeguidoresResu5.setContentAreaFilled(false);
        NoSeguidoresResu5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        NoSeguidoresResu5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        NoSeguidoresResu5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NoSeguidoresResu5ActionPerformed(evt);
            }
        });

        ImgRes2.setText("img_resultado1");

        UserResu1_Btn4.setFont(new java.awt.Font("Roboto", 1, 22)); // NOI18N
        UserResu1_Btn4.setForeground(new java.awt.Color(204, 204, 204));
        UserResu1_Btn4.setText("Usuario");
        UserResu1_Btn4.setToolTipText("");
        UserResu1_Btn4.setBorder(null);
        UserResu1_Btn4.setBorderPainted(false);
        UserResu1_Btn4.setContentAreaFilled(false);
        UserResu1_Btn4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        UserResu1_Btn4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        UserResu1_Btn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserResu1_Btn4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout EjemploBusquedas4Layout = new javax.swing.GroupLayout(EjemploBusquedas4);
        EjemploBusquedas4.setLayout(EjemploBusquedas4Layout);
        EjemploBusquedas4Layout.setHorizontalGroup(
            EjemploBusquedas4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EjemploBusquedas4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ImgRes2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(EjemploBusquedas4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(EjemploBusquedas4Layout.createSequentialGroup()
                        .addGroup(EjemploBusquedas4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(EjemploBusquedas4Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(UserResu5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(NoSeguidoresResu5, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SeguidoresResu5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(EjemploBusquedas4Layout.createSequentialGroup()
                        .addComponent(UserResu1_Btn4, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        EjemploBusquedas4Layout.setVerticalGroup(
            EjemploBusquedas4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EjemploBusquedas4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(EjemploBusquedas4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(EjemploBusquedas4Layout.createSequentialGroup()
                        .addComponent(UserResu1_Btn4)
                        .addGap(4, 4, 4)
                        .addComponent(UserResu5)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel8)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(ImgRes2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EjemploBusquedas4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(EjemploBusquedas4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SeguidoresResu5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NoSeguidoresResu5)))
        );

        jPanel1.add(EjemploBusquedas4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 470, 730, 90));

        SiguienteBtn1.setBackground(new java.awt.Color(0, 0, 0));
        SiguienteBtn1.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        SiguienteBtn1.setForeground(new java.awt.Color(204, 204, 204));
        SiguienteBtn1.setText("Siguiente  >");
        SiguienteBtn1.setToolTipText("");
        SiguienteBtn1.setActionCommand("");
        SiguienteBtn1.setAlignmentY(0.0F);
        SiguienteBtn1.setBorderPainted(false);
        SiguienteBtn1.setContentAreaFilled(false);
        SiguienteBtn1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SiguienteBtn1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        SiguienteBtn1.setOpaque(true);
        SiguienteBtn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SiguienteBtn1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                SiguienteBtn1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                SiguienteBtn1MousePressed(evt);
            }
        });
        SiguienteBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SiguienteBtn1ActionPerformed(evt);
            }
        });
        jPanel1.add(SiguienteBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 580, 380, 60));

        Busquedas_jTabbePane.addTab("Usuarios", jPanel1);

        Busquedas_jTabbePane.setSelectedIndex(1);

        PanelTotalExplorar.add(Busquedas_jTabbePane, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 160, 750, 710));

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

        Perfil_Img2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Perfil_Img2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Perfil_Img2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Perfil_Img2MousePressed(evt);
            }
        });
        PerfilPanel.add(Perfil_Img2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 60, 60));

        PanelTotalExplorar.add(PerfilPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 750, 320, 80));

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
        PanelTotalExplorar.add(ConfiBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 430, 260, 40));

        InicioBtn.setBackground(new java.awt.Color(26, 26, 29));
        InicioBtn.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        InicioBtn.setForeground(new java.awt.Color(204, 204, 204));
        InicioBtn.setText("  Inicio");
        InicioBtn.setToolTipText("");
        InicioBtn.setAlignmentY(0.0F);
        InicioBtn.setBorderPainted(false);
        InicioBtn.setContentAreaFilled(false);
        InicioBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        InicioBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InicioBtnActionPerformed(evt);
            }
        });
        PanelTotalExplorar.add(InicioBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 250, 40));

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
        PanelTotalExplorar.add(NotificacionesBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 310, 250, 40));

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
        PanelTotalExplorar.add(PerfilBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 370, 250, 40));

        ExplorarBtn4.setBackground(new java.awt.Color(26, 26, 29));
        ExplorarBtn4.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        ExplorarBtn4.setForeground(new java.awt.Color(204, 204, 204));
        ExplorarBtn4.setText("  Explorar");
        ExplorarBtn4.setToolTipText("");
        ExplorarBtn4.setAlignmentY(0.0F);
        ExplorarBtn4.setBorderPainted(false);
        ExplorarBtn4.setContentAreaFilled(false);
        ExplorarBtn4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ExplorarBtn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExplorarBtn4ActionPerformed(evt);
            }
        });
        PanelTotalExplorar.add(ExplorarBtn4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, 250, 40));
        PanelTotalExplorar.add(Y_logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 90, 80));

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
            .addGap(0, 52, Short.MAX_VALUE)
            .addGroup(ExitPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(ExitPaneLayout.createSequentialGroup()
                    .addComponent(ExitBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout HeaderLayout = new javax.swing.GroupLayout(Header);
        Header.setLayout(HeaderLayout);
        HeaderLayout.setHorizontalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1550, Short.MAX_VALUE)
            .addGroup(HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HeaderLayout.createSequentialGroup()
                    .addGap(0, 1490, Short.MAX_VALUE)
                    .addComponent(ExitPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        HeaderLayout.setVerticalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(HeaderLayout.createSequentialGroup()
                    .addGap(2, 2, 2)
                    .addComponent(ExitPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        PanelTotalExplorar.add(Header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1550, 50));

        QuePasa.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        QuePasa.setForeground(new java.awt.Color(204, 204, 204));
        QuePasa.setText("Qué pasa");
        PanelTotalExplorar.add(QuePasa, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 470, 90, 30));

        SeguirCuentaBtn3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        SeguirCuentaBtn3.setText("Seguir");
        SeguirCuentaBtn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SeguirCuentaBtn3ActionPerformed(evt);
            }
        });
        PanelTotalExplorar.add(SeguirCuentaBtn3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1400, 330, -1, 30));

        SeguirCuentaBtn1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        SeguirCuentaBtn1.setText("Seguir");
        SeguirCuentaBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SeguirCuentaBtn1ActionPerformed(evt);
            }
        });
        PanelTotalExplorar.add(SeguirCuentaBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1400, 210, -1, 30));

        SeguirCuentaBtn2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        SeguirCuentaBtn2.setText("Seguir");
        SeguirCuentaBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SeguirCuentaBtn2ActionPerformed(evt);
            }
        });
        PanelTotalExplorar.add(SeguirCuentaBtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1400, 270, -1, 30));

        jSeparator6.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator6.setForeground(new java.awt.Color(153, 153, 153));
        jSeparator6.setOrientation(javax.swing.SwingConstants.VERTICAL);
        PanelTotalExplorar.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 140, 30, 250));

        jSeparator7.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator7.setForeground(new java.awt.Color(153, 153, 153));
        jSeparator7.setOrientation(javax.swing.SwingConstants.VERTICAL);
        PanelTotalExplorar.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 440, 10, 340));
        PanelTotalExplorar.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 440, 330, 20));

        jLabel40.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(204, 204, 204));
        jLabel40.setText("Te puede interesar");
        PanelTotalExplorar.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 140, 210, 30));

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
        PanelTotalExplorar.add(CuentaBtn20, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 450, 80, 20));

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
        PanelTotalExplorar.add(TendenciaYapBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 510, 310, 60));

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
        PanelTotalExplorar.add(numreacciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 570, 70, 30));

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
        PanelTotalExplorar.add(MostrarMasInteresBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1430, 370, 60, 20));

        ImgInt3.setForeground(new java.awt.Color(255, 255, 255));
        ImgInt3.setText("ImgInteres2");
        PanelTotalExplorar.add(ImgInt3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 320, 60, 60));

        ImgInt1.setForeground(new java.awt.Color(255, 255, 255));
        ImgInt1.setText("ImgInteres1");
        PanelTotalExplorar.add(ImgInt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 180, 60, 60));

        ImgInt2.setForeground(new java.awt.Color(255, 255, 255));
        ImgInt2.setText("ImgInteres2");
        PanelTotalExplorar.add(ImgInt2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 250, 60, 60));

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
        PanelTotalExplorar.add(UserInt3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 330, -1, 30));

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
        PanelTotalExplorar.add(UserInt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 210, -1, 30));

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
        PanelTotalExplorar.add(UserInt2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 270, -1, 30));
        PanelTotalExplorar.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 140, 280, 10));

        LabelAviso2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LabelAviso2.setForeground(new java.awt.Color(166, 77, 121));
        PanelTotalExplorar.add(LabelAviso2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 390, 250, 40));

        Num_Reacciones.setForeground(new java.awt.Color(204, 204, 204));
        Num_Reacciones.setText("10");
        PanelTotalExplorar.add(Num_Reacciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 570, 30, 30));

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
        PanelTotalExplorar.add(TendenciaYapBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 600, 310, 60));

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
        PanelTotalExplorar.add(numreacciones1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 660, 70, 30));

        Num_Reacciones1.setForeground(new java.awt.Color(204, 204, 204));
        Num_Reacciones1.setText("10");
        PanelTotalExplorar.add(Num_Reacciones1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 660, 30, 30));

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
        PanelTotalExplorar.add(TendenciaYapBtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 690, 310, 60));

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
        PanelTotalExplorar.add(numreacciones2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 750, 70, 30));

        Num_Reacciones2.setForeground(new java.awt.Color(204, 204, 204));
        Num_Reacciones2.setText("10");
        PanelTotalExplorar.add(Num_Reacciones2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 750, 30, 30));
        PanelTotalExplorar.add(jSeparator12, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 390, 280, 20));

        jSeparator13.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator13.setForeground(new java.awt.Color(153, 153, 153));
        jSeparator13.setOrientation(javax.swing.SwingConstants.VERTICAL);
        PanelTotalExplorar.add(jSeparator13, new org.netbeans.lib.awtextra.AbsoluteConstraints(1490, 140, 20, 250));
        PanelTotalExplorar.add(jSeparator14, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 780, 330, 20));

        jSeparator15.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator15.setForeground(new java.awt.Color(153, 153, 153));
        jSeparator15.setOrientation(javax.swing.SwingConstants.VERTICAL);
        PanelTotalExplorar.add(jSeparator15, new org.netbeans.lib.awtextra.AbsoluteConstraints(1530, 440, 10, 340));

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
            .addComponent(PanelTotalExplorar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 890, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BusquedaTodoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BusquedaTodoBtnActionPerformed
        // TODO add your handling code here:
        Busquedas_jTabbePane.setSelectedIndex(0);
    }//GEN-LAST:event_BusquedaTodoBtnActionPerformed

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
        limpiarPaneles();
        
        textoBusqueda = Busqueda_TxtFld.getText().trim();
        if(textoBusqueda.isEmpty()) return;
        
        //Reiniciar indices
        publicacionActual = 0;
        currentUserGroup = 0;
        
        //Buscar Usuarios (primer grupo)
        List<Usuarios> primerGrupoUsuarios = usuarioDao.buscarUsuarios(textoBusqueda,1,USER_PER_PAGE);
        hayUsuarios = !primerGrupoUsuarios.isEmpty();
        
        //Buscar publicaciones
        publicacioness = publicacionDAO.buscarPublicacionesResult(textoBusqueda, 1, 1);
        hayPublicaciones = !publicacioness.isEmpty();
        
        //Mostrar resultados
        if(hayUsuarios){
            mostrarGrupoUsuarios(primerGrupoUsuarios);
        }
        else if (hayPublicaciones){
            configurarPanelPublicacion(
            PanelNot2, publicacioness.get(0),
            lblUsuario1, Nombre_usuarioBtn1, UsuarioPub6,
            lblTexto_publicacion1, Fecha_Label1,
            meGustaBtn1, lblLikesLabel1,
            repostearBtn1, lblRepostearLabel1, ImagenPublicacion_lbl4, comentarBtn1
        );
        PanelNot2.setVisible(true);
        }
    }//GEN-LAST:event_BuscarBtnActionPerformed

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

    private void ConfiBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfiBtnActionPerformed
        this.dispose();
        new Configuracion().setVisible(true);
    }//GEN-LAST:event_ConfiBtnActionPerformed

    private void InicioBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InicioBtnActionPerformed
        this.dispose();
        new Menu_Principal().setVisible(true);
    }//GEN-LAST:event_InicioBtnActionPerformed

    private void NotificacionesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NotificacionesBtnActionPerformed
        this.dispose();
        new Notificaciones().setVisible(true);
    }//GEN-LAST:event_NotificacionesBtnActionPerformed

    private void PerfilBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PerfilBtnActionPerformed
        this.dispose();
        new Perfil().setVisible(true);
    }//GEN-LAST:event_PerfilBtnActionPerformed

    private void ExplorarBtn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExplorarBtn4ActionPerformed
        this.dispose();
        new Explorar().setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_ExplorarBtn4ActionPerformed

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

    private void SeguirCuentaBtn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeguirCuentaBtn3ActionPerformed
        String idSeguidor = SesionUsuario.idUsuario; // ID del usuario logueado
        String idSeguido = UserInt3.getText(); // ID del perfil que se está viendo

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
        String idSeguido = UserInt2.getText(); // ID del perfil que se está viendo

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

    private void CuentaBtn20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CuentaBtn20ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CuentaBtn20ActionPerformed

    private void TendenciaYapBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TendenciaYapBtnMousePressed
        this.dispose();
        new Menu_Principal().setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_TendenciaYapBtnMousePressed

    private void TendenciaYapBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TendenciaYapBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TendenciaYapBtnActionPerformed

    private void numreaccionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numreaccionesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numreaccionesActionPerformed

    private void MostrarMasInteresBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MostrarMasInteresBtnMousePressed
        SeccionTePuedeInteresar();
        // TODO add your handling code here:
    }//GEN-LAST:event_MostrarMasInteresBtnMousePressed

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

    private void UserInt1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UserInt1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_UserInt1MousePressed

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

    private void TendenciaYapBtn1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TendenciaYapBtn1MousePressed
        this.dispose();
        new Menu_Principal().setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_TendenciaYapBtn1MousePressed

    private void TendenciaYapBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TendenciaYapBtn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TendenciaYapBtn1ActionPerformed

    private void numreacciones1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numreacciones1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numreacciones1ActionPerformed

    private void TendenciaYapBtn2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TendenciaYapBtn2MousePressed
        this.dispose();
        new Menu_Principal().setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_TendenciaYapBtn2MousePressed

    private void TendenciaYapBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TendenciaYapBtn2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TendenciaYapBtn2ActionPerformed

    private void numreacciones2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numreacciones2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numreacciones2ActionPerformed

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

    private void SiguienteBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SiguienteBtnMouseEntered
        SiguienteBtn.setBackground(new java.awt.Color(166,77,121));
        // TODO add your handling code here:
    }//GEN-LAST:event_SiguienteBtnMouseEntered

    private void SiguienteBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SiguienteBtnMouseExited
        SiguienteBtn.setBackground(Color.BLACK);
        // TODO add your handling code here:
    }//GEN-LAST:event_SiguienteBtnMouseExited

    private void SiguienteBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SiguienteBtnMousePressed
        if(!hayPublicaciones) return;
        publicacioness = publicacionDAO.buscarPublicacionesResult(textoBusqueda, 1,1);
        bandera_likes = false;
        bandera_repost = false;
        
        if (publicacionActual < (publicacioness.size()-1))publicacionActual++;
        else publicacionActual = 0;
        
        if(!publicacioness.isEmpty()){
           configurarPanelPublicacion(
            PanelNot2, publicacioness.get(0),
            lblUsuario1, Nombre_usuarioBtn1, UsuarioPub6,
            lblTexto_publicacion1, Fecha_Label1,
            meGustaBtn1, lblLikesLabel1,
            repostearBtn1, lblRepostearLabel1, ImagenPublicacion_lbl4, comentarBtn1);
            PanelNot2.setVisible(true);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_SiguienteBtnMousePressed

    private void SiguienteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SiguienteBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SiguienteBtnActionPerformed

    private void UserResu5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserResu5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UserResu5ActionPerformed

    private void SeguidoresResu5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeguidoresResu5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SeguidoresResu5ActionPerformed

    private void NoSeguidoresResu5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NoSeguidoresResu5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NoSeguidoresResu5ActionPerformed

    private void UserResu1_Btn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserResu1_Btn4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UserResu1_Btn4ActionPerformed

    private void UserResu1_Btn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserResu1_Btn3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UserResu1_Btn3ActionPerformed

    private void NoSeguidoresResu4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NoSeguidoresResu4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NoSeguidoresResu4ActionPerformed

    private void SeguidoresResu4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeguidoresResu4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SeguidoresResu4ActionPerformed

    private void UserResu4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserResu4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UserResu4ActionPerformed

    private void SiguienteBtn1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SiguienteBtn1MouseEntered
        // TODO add your handling code here:
        SiguienteBtn1.setBackground(new java.awt.Color(166,77,121));
    }//GEN-LAST:event_SiguienteBtn1MouseEntered

    private void SiguienteBtn1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SiguienteBtn1MouseExited
        // TODO add your handling code here:
        SiguienteBtn.setBackground(Color.BLACK);
    }//GEN-LAST:event_SiguienteBtn1MouseExited

    private void SiguienteBtn1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SiguienteBtn1MousePressed
        // TODO add your handling code here:
        if(!hayUsuarios) return;
        List<Usuarios> siguienteGrupo = usuarioDao.buscarUsuarios(textoBusqueda, currentUserGroup+1, USER_PER_PAGE);
        
        if(siguienteGrupo.isEmpty()){
            //Si no hay más resultados, volver al primer grupo
            currentUserGroup = 0;
            siguienteGrupo = usuarioDao.buscarUsuarios(textoBusqueda,1,USER_PER_PAGE);
        }else currentUserGroup++;
        mostrarGrupoUsuarios(siguienteGrupo);
    }//GEN-LAST:event_SiguienteBtn1MousePressed

    private void SiguienteBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SiguienteBtn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SiguienteBtn1ActionPerformed

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
    private javax.swing.JButton BuscarBtn;
    private javax.swing.JButton BusquedaTodoBtn;
    private javax.swing.JButton BusquedaTodoBtn1;
    private javax.swing.JTextField Busqueda_TxtFld;
    private javax.swing.JTabbedPane Busquedas_jTabbePane;
    private javax.swing.JButton ConfiBtn;
    private javax.swing.JButton CuentaBtn20;
    private javax.swing.JPanel EjemploBusqueda6;
    private javax.swing.JPanel EjemploBusquedas1;
    private javax.swing.JPanel EjemploBusquedas2;
    private javax.swing.JPanel EjemploBusquedas3;
    private javax.swing.JPanel EjemploBusquedas4;
    private javax.swing.JLabel ExitBtn;
    private javax.swing.JPanel ExitPane;
    private javax.swing.JButton ExplorarBtn4;
    private javax.swing.JLabel ExplorarTitulo;
    private javax.swing.JLabel Fecha_Label1;
    private javax.swing.JPanel Header;
    private javax.swing.JButton IconoExplorar;
    private javax.swing.JLabel IdUsuario2;
    private javax.swing.JLabel ImagenPublicacion_lbl1;
    private javax.swing.JLabel ImagenPublicacion_lbl4;
    private javax.swing.JLabel ImgInt1;
    private javax.swing.JLabel ImgInt2;
    private javax.swing.JLabel ImgInt3;
    private javax.swing.JLabel ImgRes1;
    private javax.swing.JLabel ImgRes2;
    private javax.swing.JLabel ImgResu2;
    private javax.swing.JLabel ImgResu3;
    private javax.swing.JLabel ImgResu4;
    private javax.swing.JButton InicioBtn;
    private javax.swing.JLabel LabelAviso2;
    private javax.swing.JButton MostrarMasInteresBtn;
    private javax.swing.JButton NoSeguidoresResu1;
    private javax.swing.JButton NoSeguidoresResu2;
    private javax.swing.JButton NoSeguidoresResu3;
    private javax.swing.JButton NoSeguidoresResu4;
    private javax.swing.JButton NoSeguidoresResu5;
    private javax.swing.JLabel NombreUsuario;
    private javax.swing.JButton Nombre_usuarioBtn1;
    private javax.swing.JButton NotificacionesBtn;
    private javax.swing.JLabel Num_Reacciones;
    private javax.swing.JLabel Num_Reacciones1;
    private javax.swing.JLabel Num_Reacciones2;
    private javax.swing.JPanel PanelNot2;
    private javax.swing.JPanel PanelTotalExplorar;
    private javax.swing.JButton PerfilBtn;
    private javax.swing.JPanel PerfilPanel;
    private javax.swing.JLabel Perfil_Img2;
    private javax.swing.JLabel QuePasa;
    private javax.swing.JLabel Resultados_JLabel;
    private javax.swing.JButton SeguidoresResu1;
    private javax.swing.JButton SeguidoresResu2;
    private javax.swing.JButton SeguidoresResu3;
    private javax.swing.JButton SeguidoresResu4;
    private javax.swing.JButton SeguidoresResu5;
    private javax.swing.JButton SeguirCuentaBtn1;
    private javax.swing.JButton SeguirCuentaBtn2;
    private javax.swing.JButton SeguirCuentaBtn3;
    private javax.swing.JButton SiguienteBtn;
    private javax.swing.JButton SiguienteBtn1;
    private javax.swing.JButton TendenciaYapBtn;
    private javax.swing.JButton TendenciaYapBtn1;
    private javax.swing.JButton TendenciaYapBtn2;
    private javax.swing.JButton UserInt1;
    private javax.swing.JButton UserInt2;
    private javax.swing.JButton UserInt3;
    private javax.swing.JButton UserResu1;
    private javax.swing.JButton UserResu1_Btn;
    private javax.swing.JButton UserResu1_Btn1;
    private javax.swing.JButton UserResu1_Btn2;
    private javax.swing.JButton UserResu1_Btn3;
    private javax.swing.JButton UserResu1_Btn4;
    private javax.swing.JButton UserResu2;
    private javax.swing.JButton UserResu3;
    private javax.swing.JButton UserResu4;
    private javax.swing.JButton UserResu5;
    private javax.swing.JButton UsuarioPub6;
    private javax.swing.JLabel Y_logo;
    private javax.swing.JButton comentarBtn1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator15;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JLabel lblComentarLabel1;
    private javax.swing.JLabel lblLikesLabel1;
    private javax.swing.JLabel lblRepostearLabel1;
    private javax.swing.JLabel lblTexto_publicacion1;
    private javax.swing.JLabel lblUsuario1;
    private javax.swing.JButton meGustaBtn1;
    private javax.swing.JButton numreacciones;
    private javax.swing.JButton numreacciones1;
    private javax.swing.JButton numreacciones2;
    private javax.swing.JButton repostearBtn1;
    // End of variables declaration//GEN-END:variables
}
