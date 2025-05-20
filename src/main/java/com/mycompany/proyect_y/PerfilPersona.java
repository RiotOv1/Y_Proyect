/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.proyect_y;

import Conection.DBConnection;
import Conection.DB_Conection;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Kevin G
 */
public class PerfilPersona extends javax.swing.JFrame {
    private File archivoImagenSeleccionado;
    private PublicacionDAO publicacionDAO;
    private List<Publicacion> publicaciones;
    private List<Publicacion> publicacionestxt; 
    int indextex = 0;
    int indexmulti = 0;
    String IdUsuario = "";
    public PerfilPersona(String U2) throws SQLException {
        initComponents();
        this.setLocationRelativeTo(null);
        Img();
        //usuario principal aka duenio de la cuenta
        
        NombreUsuario.setText(obtenerNombreUsuario(SesionUsuario.idUsuario));
        IdUsuario2.setText( "@" + SesionUsuario.idUsuario);
        Connection con =  DB_Conection.conectar(); // tu clase de conexión}
        ObtenerDatosUsuario(U2);
        IdUsuario = U2;
        if (IdUsuario != null) {
            String nom = obtenerNombreUsuario(U2);
            cargarFotoPerfil(U2); 
            NombreComunidad.setText(nom);
            UsuarioComunidad.setText( "@" + IdUsuario);
            NombrePub1.setText(nom);
            UsuarioPub1.setText( "@" + IdUsuario);
            
            String sqlSeguidores = "SELECT COUNT(*) FROM seguidores WHERE id_seguido = ?";
            PreparedStatement ps1 = con.prepareStatement(sqlSeguidores);
            ps1.setString(1, U2);
            ResultSet rs1 = ps1.executeQuery();
            if (rs1.next()) {
                int seguidores = rs1.getInt(1);
                Num_Siguiendo.setText(String.valueOf(seguidores));
            }
            
            // Contar seguidos
            String sqlSeguidos = "SELECT COUNT(*) FROM seguidores WHERE id_seguidor = ?";
            PreparedStatement ps2 = con.prepareStatement(sqlSeguidos);
            ps2.setString(1, U2);
            ResultSet rs2 = ps2.executeQuery();
            if (rs2.next()) {
                int seguidos = rs2.getInt(1);
                Num_Seguidores.setText(String.valueOf(seguidos));
            }
            
            ps1.close();
            ps2.close();
        }
        publicacionDAO = new PublicacionDAO();
        publicaciones = publicacionDAO.obtenerTodasPublicacionesUsuario(IdUsuario);
        publicacionestxt = publicacionDAO.obtenerTodasPublicacionesUsuarioTxt(IdUsuario);
        actualizarPublicacionesMultimedia();
        actualizarPublicacionesTexto();
        //Ayuda Selecciones
        SubMenu.setSelectedIndex(1);
        
        Btn_Siguiente1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (indexmulti + 2 < publicaciones.size()) {
                    indexmulti += 2;
                    actualizarPublicacionesMultimedia();
                }
            }
        });

        Btn_Siguiente2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (indextex + 3 < publicacionestxt.size()) {
                    indextex += 3;
                    actualizarPublicacionesTexto();
                }
            }
        });
        
        Btn_Anterior1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (indexmulti - 2 >= 0) {
                    indexmulti -= 2;
                    actualizarPublicacionesMultimedia();
                }
            }
        });
        
        Btn_Anterior2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (indextex - 3 >= 0) {
                    indextex -= 3;
                    actualizarPublicacionesTexto();
                }   
            }   
        });
        
        con.close();
    } 
    
    private void actualizarPublicacionesMultimedia() {
        if (publicaciones.size() > indexmulti) {
            // Panel 1
            if (indexmulti < publicaciones.size()) {
                configurarPanelPublicacion(PanelNot1, publicaciones.get(indexmulti),
                        ImgPub1, NombrePub1, UsuarioPub1,
                        DescripcionPub1, Fecha_Label1,
                        meGustaBtn1, lblLikesLabel1,
                        repostearBtn1, lblRepostearLabel1, imagen1, comentarBtn1);
                PanelNot1.setVisible(true);
            } else {
                PanelNot1.setVisible(false);
            }
            
            // Panel 2
            if (indexmulti + 1 < publicaciones.size()) {
                configurarPanelPublicacion(PanelNot2, publicaciones.get(indexmulti + 1),
                        ImgPub2, NombrePub2, UsuarioPub2,
                        DescripcionPub2, Fecha_Label2,
                        meGustaBtn2, lblLikesLabel2,
                        repostearBtn2, lblRepostearLabel2, imagen2, comentarBtn2);
                PanelNot2.setVisible(true);
            } else {
                PanelNot2.setVisible(false);
            }
            
        }
        Btn_Anterior1.setVisible(indexmulti > 0);
        Btn_Siguiente1.setVisible(indexmulti + 2 < publicaciones.size());
        
        if (!publicaciones.isEmpty()) { 
            
            PanelNot2.setVisible(publicaciones.size() > 1);
        }
        else {
            PanelNot2.setVisible(false);
            PanelNot1.setVisible(false);
        }
        
    }

    private void actualizarPublicacionesTexto() {
        if (publicacionestxt.size() > indextex) {
            // Panel 1
            if (indextex < publicacionestxt.size()) {
                configurarPanelPublicacionTexto(PanelTxt1, publicacionestxt.get(indextex),
                        ImgPub3, NombrePub3, UsuarioPub3,
                        DescripcionPub3, Fecha_Label3,
                        meGustaBtn3, lblLikesLabel3,
                        repostearBtn3, lblRepostearLabel3, comentarBtn3);
                PanelTxt1.setVisible(true);
            } else {
                PanelTxt1.setVisible(false);
            }
            
            // Panel 2
            if (indextex + 1 < publicacionestxt.size()) {
                configurarPanelPublicacionTexto(PanelTxt2, publicacionestxt.get(indextex + 1),
                        ImgPub4, NombrePub4, UsuarioPub4,
                        DescripcionPub4, Fecha_Label4,
                        meGustaBtn4, lblLikesLabel4,
                        repostearBtn4, lblRepostearLabel4, comentarBtn4);
                PanelTxt2.setVisible(true);
            } else {
                PanelTxt2.setVisible(false);
            }

            // Panel 3
            if (indextex + 2 < publicacionestxt.size()) {
                configurarPanelPublicacionTexto(PanelTxt3, publicacionestxt.get(indextex + 2),
                    ImgPub5, NombrePub5, UsuarioPub5,
                    DescripcionPub5, Fecha_Label5,
                    meGustaBtn5, lblLikesLabel5,
                    repostearBtn5, lblRepostearLabel5, comentarBtn5);
                    PanelTxt3.setVisible(true);
            } else {
                PanelTxt3.setVisible(false);
            }
        }

        Btn_Anterior2.setVisible(indextex > 0);
        Btn_Siguiente2.setVisible(indextex + 3 < publicacionestxt.size());
        if (!publicacionestxt.isEmpty()) { 
            
            PanelTxt2.setVisible(publicacionestxt.size() > 1);
            PanelTxt3.setVisible(publicacionestxt.size() > 2);
        }
        else {
            PanelTxt1.setVisible(false);
            PanelTxt2.setVisible(false);
            PanelTxt3.setVisible(false);
        }
    }

    
    
    //Configuracion del panel solo de texto
    private void configurarPanelPublicacionTexto(JPanel publi, Publicacion publica, JLabel ImageUser,JLabel nomUsuario ,
            JButton btnUsuario, JLabel lblTexto,JLabel lblFecha,JButton btnLike, JLabel lblLikes, JButton btnRepost, 
            JLabel lblReposts, JButton btnComentarios){
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
        NombrePub3.setText(obtenerNombreUsuario(publica.getIdUsuario()));
        NombrePub4.setText(obtenerNombreUsuario(publica.getIdUsuario()));
        btnUsuario.setText("@"+publica.getIdUsuario());
        lblTexto.setText("<html><p>" + publica.getTexto() + "</html></p>");
        lblFecha.setText(publica.getFechaHora().toString());
        lblLikes.setText(String.valueOf(publica.getNumReacciones()));
        lblReposts.setText(String.valueOf(publica.getNumCompartidos()));
        
        //Configurar imagen de perfil del usurio
        if(publica.getFotoPerfilUsuario()!=null){
            ImageIcon icon = new ImageIcon(publica.getFotoPerfilUsuario());
            Image img  = icon.getImage().getScaledInstance(ImageUser.getWidth(), ImageUser.getHeight(),Image.SCALE_SMOOTH);
            ImageUser.setIcon(new ImageIcon(img));
        }else{
            ImgPub4.setIcon(null);
            ImgPub3.setIcon(null);
        }       
        
        //Configurar acciones de los botones
        
        btnLike.addActionListener(new ActionListener() {
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
    
        boolean bandera_likes = false; //Variable para verificar que no haya likes repetidos
    boolean bandera_repost = false; //Variable para verificar que no haya repost repetidos
    private void configurarPanelPublicacion(JPanel publi, Publicacion publica,JLabel lblUsuario, JLabel nomUsuario ,JButton btnUsuario, JLabel lblTexto,JLabel lblFecha
    ,JButton btnLike, JLabel lblLikes, JButton btnRepost, JLabel lblReposts, JLabel imagen, JButton btnComentarios){
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
        nomUsuario.setText(obtenerNombreUsuario(publica.getIdUsuario()));
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
            Image img_publi = icono_imagen.getImage().getScaledInstance(290,220, Image.SCALE_SMOOTH);
            imagen.setIcon(new ImageIcon(img_publi));
        }
        else{
            imagen.setIcon(null);
        }
        
        //Configurar acciones de los botones
        
        btnLike.addActionListener(new ActionListener() {
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
    
    
    public String obtenerNombreUsuario(String usuario) {
            String nombre = "";
            String apellido = "";
            Connection con =  DB_Conection.conectar(); // tu clase de conexión
            if (con != null) {
                try {
                    String sql = "SELECT nombre, apellido FROM usuario WHERE id_usuario = ?";
                    PreparedStatement ps = con.prepareStatement(sql);
                    ps.setString(1, usuario); // usamos el ID guardado en la sesión
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
       
    public void cargarFotoPerfil(String usuario) {
        Connection con = DB_Conection.conectar();
        
        if (con != null) {
            try {
                String sql = "SELECT foto_perfil FROM usuario WHERE id_usuario = ?";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, usuario);
                ResultSet rs = ps.executeQuery();
                
                if (rs.next()) {
                    byte[] imagenBytes = rs.getBytes("foto_perfil");
                    
                    if (imagenBytes != null) {
                        ImageIcon icon = new ImageIcon(imagenBytes);
                        Image img = icon.getImage().getScaledInstance(FotoPerfil.getWidth(), FotoPerfil.getHeight(), Image.SCALE_SMOOTH);
                        FotoPerfil.setIcon(new ImageIcon(img));
                        Image img2 = icon.getImage().getScaledInstance(ImgPub1.getWidth(), ImgPub1.getHeight(), Image.SCALE_SMOOTH);
                        ImgPub1.setIcon((new ImageIcon(img2)));

                    } else {
                        FotoPerfil.setText("Sin imagen");
                        ImgPub1.setText("Sin imagen");
                    }
                }
                
                rs.close();
                ps.close();
                
                String sqll = "SELECT foto_perfil FROM usuario WHERE id_usuario = ?";
                PreparedStatement pss = con.prepareStatement(sql);
                pss.setString(1, SesionUsuario.idUsuario);
                ResultSet rss = ps.executeQuery();
                
                if (rs.next()) {
                    byte[] imagenBytes = rs.getBytes("foto_perfil");
                    
                    if (imagenBytes != null) {
                        ImageIcon icon = new ImageIcon(imagenBytes);
                        Image img = icon.getImage().getScaledInstance(Perfil_Img1.getWidth(), Perfil_Img1.getHeight(), Image.SCALE_SMOOTH);
                        Perfil_Img1.setIcon(new ImageIcon(img));
                        
                    } else {
                        Perfil_Img1.setText("Sin imagen");
                        
                    }
                }
                
                rss.close();
                pss.close();
                
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
   
    public void ObtenerDatosUsuario(String usuario){
        //Obtenemos todos los datos del usuario
         try {
            Connection con = DB_Conection.conectar();
      
             String sql = "SELECT * FROM usuario WHERE id_usuario = ?";
             PreparedStatement ps = con.prepareStatement(sql);
             ps.setString(1, usuario);
             ResultSet rs = ps.executeQuery();
             
             if (rs.next()) {
            // Extrae valores de cada columna
            String Descripcion = rs.getString("Descripcion");
            String ColorBanner = rs.getString("ColorBanner");
            
            if (Descripcion != null){
                //Formato de texto
                DescLabel.setText("<html><p>" + Descripcion + "</html></p>");
                
            } else {
                DescLabel.setText("Sin descripcion");
            }
            //Comprobacion de campo vacio por defecto
            if (ColorBanner == null ){               
                System.out.println("Null El banner");
                
            } else{
                CuentaBtn3.setVisible(false);
                System.out.println(ColorBanner);
                //Asignamos color a el banner
                switch (ColorBanner) {
                    case "Azul":
                        PortadaPanel.setBackground(Color.BLUE);
                        break;
                    case "Rojo":
                        PortadaPanel.setBackground(Color.RED);
                        break;
                    case "Morado":
                        PortadaPanel.setBackground(Color.MAGENTA);
                        break;
                    case "Amarillo":
                        PortadaPanel.setBackground(Color.yellow);
                        break;
                    case "Verde":
                        PortadaPanel.setBackground(Color.green);
                        break;
                    case "Naranja":
                        PortadaPanel.setBackground(Color.orange);
                        break;
                    case "Rosa":
                        PortadaPanel.setBackground(Color.pink);
                        break;
                    default:
                        break;
                }
                
            }
            
              // Muestra los valores en los labels
            //Comprobacion de vacio
            
            
             }  else
             {
                 JOptionPane.showMessageDialog(null, "No se encontro el usuario");
             }}catch(SQLException e) {
    e.printStackTrace(); // Mostrará errores ocultos
    JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
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
        
        //IconoPerfil
        String url66 = "src\\main\\java\\Multimedia\\Icon-Usuario.png";
        ImageIcon image66 = new ImageIcon(url66);
        Image img66 = image66.getImage().getScaledInstance(32, 32, 0);
        ImageIcon Icono66 = new ImageIcon(img66);
        FotoPerfil.setIcon(Icono66);

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

        Colores = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        CuentaBtn9 = new javax.swing.JButton();
        CuentaBtn2 = new javax.swing.JButton();
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
        jSeparator1 = new javax.swing.JSeparator();
        FotoPerfil = new javax.swing.JLabel();
        PortadaPanel = new javax.swing.JPanel();
        CuentaBtn3 = new javax.swing.JButton();
        UsuarioComunidad = new javax.swing.JButton();
        NombreComunidad = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        SubMenu = new javax.swing.JTabbedPane();
        PublicacionesImagenes = new javax.swing.JPanel();
        PanelNot1 = new javax.swing.JPanel();
        UsuarioPub1 = new javax.swing.JButton();
        NombrePub1 = new javax.swing.JLabel();
        DescripcionPub1 = new javax.swing.JLabel();
        ImgPub1 = new javax.swing.JLabel();
        imagen1 = new javax.swing.JLabel();
        Fecha_Label1 = new javax.swing.JLabel();
        lblLikesLabel1 = new javax.swing.JLabel();
        meGustaBtn1 = new javax.swing.JButton();
        lblComentarLabel1 = new javax.swing.JLabel();
        comentarBtn1 = new javax.swing.JButton();
        repostearBtn1 = new javax.swing.JButton();
        lblRepostearLabel1 = new javax.swing.JLabel();
        PanelNot2 = new javax.swing.JPanel();
        ImgPub2 = new javax.swing.JLabel();
        NombrePub2 = new javax.swing.JLabel();
        DescripcionPub2 = new javax.swing.JLabel();
        UsuarioPub2 = new javax.swing.JButton();
        imagen2 = new javax.swing.JLabel();
        meGustaBtn2 = new javax.swing.JButton();
        comentarBtn2 = new javax.swing.JButton();
        repostearBtn2 = new javax.swing.JButton();
        lblLikesLabel2 = new javax.swing.JLabel();
        lblComentarLabel2 = new javax.swing.JLabel();
        lblRepostearLabel2 = new javax.swing.JLabel();
        Fecha_Label2 = new javax.swing.JLabel();
        Btn_Siguiente1 = new javax.swing.JButton();
        Btn_Anterior1 = new javax.swing.JButton();
        PublicacionesTexto = new javax.swing.JPanel();
        PanelTxt1 = new javax.swing.JPanel();
        UsuarioPub3 = new javax.swing.JButton();
        NombrePub3 = new javax.swing.JLabel();
        ImgPub3 = new javax.swing.JLabel();
        Fecha_Label3 = new javax.swing.JLabel();
        lblLikesLabel3 = new javax.swing.JLabel();
        meGustaBtn3 = new javax.swing.JButton();
        lblComentarLabel3 = new javax.swing.JLabel();
        comentarBtn3 = new javax.swing.JButton();
        repostearBtn3 = new javax.swing.JButton();
        lblRepostearLabel3 = new javax.swing.JLabel();
        DescripcionPub3 = new javax.swing.JLabel();
        PanelTxt2 = new javax.swing.JPanel();
        ImgPub4 = new javax.swing.JLabel();
        meGustaBtn4 = new javax.swing.JButton();
        comentarBtn4 = new javax.swing.JButton();
        repostearBtn4 = new javax.swing.JButton();
        lblLikesLabel4 = new javax.swing.JLabel();
        lblComentarLabel4 = new javax.swing.JLabel();
        lblRepostearLabel4 = new javax.swing.JLabel();
        UsuarioPub4 = new javax.swing.JButton();
        Fecha_Label4 = new javax.swing.JLabel();
        NombrePub4 = new javax.swing.JLabel();
        DescripcionPub4 = new javax.swing.JLabel();
        PanelTxt3 = new javax.swing.JPanel();
        ImgPub5 = new javax.swing.JLabel();
        meGustaBtn5 = new javax.swing.JButton();
        comentarBtn5 = new javax.swing.JButton();
        repostearBtn5 = new javax.swing.JButton();
        lblLikesLabel5 = new javax.swing.JLabel();
        lblComentarLabel5 = new javax.swing.JLabel();
        lblRepostearLabel5 = new javax.swing.JLabel();
        UsuarioPub5 = new javax.swing.JButton();
        Fecha_Label5 = new javax.swing.JLabel();
        NombrePub5 = new javax.swing.JLabel();
        DescripcionPub5 = new javax.swing.JLabel();
        Btn_Anterior2 = new javax.swing.JButton();
        Btn_Siguiente2 = new javax.swing.JButton();
        Seguir = new javax.swing.JButton();
        DescLabel = new javax.swing.JLabel();
        MenuDeNavegacion = new javax.swing.JPanel();
        AyudaSeleccion1 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        AyudaSeleccion2 = new javax.swing.JSeparator();
        Num_Siguiendo = new javax.swing.JLabel();
        Num_Seguidores = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setMinimumSize(new java.awt.Dimension(1550, 820));
        jPanel1.setPreferredSize(new java.awt.Dimension(1550, 820));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CuentaBtn9.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        CuentaBtn9.setForeground(new java.awt.Color(204, 204, 204));
        CuentaBtn9.setText("Siguiendo");
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
        jPanel1.add(CuentaBtn9, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 200, 80, 50));

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
        jPanel1.add(CuentaBtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 200, 80, 50));

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
        jPanel1.add(ConfiBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 420, 250, 40));

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
        jPanel1.add(InicioBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, 250, 40));

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
        PerfilBtn.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
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
        jPanel1.add(PerfilBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 360, 250, 40));

        jPanel21.setOpaque(false);
        jPanel21.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel21.add(Y_logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 60, 40));

        jPanel1.add(jPanel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, 70, 50));

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

        PerfilPanel.setBackground(new java.awt.Color(0, 0, 0));
        PerfilPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        PerfilPanel.add(Perfil_Img1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 50, 50));

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

        jSeparator1.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator1.setForeground(new java.awt.Color(153, 153, 153));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(427, 0, -1, 1040));

        FotoPerfil.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.add(FotoPerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 80, 110, 110));

        PortadaPanel.setBackground(new java.awt.Color(59, 28, 50));
        PortadaPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        PortadaPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        CuentaBtn3.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        CuentaBtn3.setForeground(new java.awt.Color(204, 204, 204));
        CuentaBtn3.setText("<agregar fondo>");
        CuentaBtn3.setBorder(null);
        CuentaBtn3.setBorderPainted(false);
        CuentaBtn3.setContentAreaFilled(false);
        CuentaBtn3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CuentaBtn3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        CuentaBtn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CuentaBtn3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PortadaPanelLayout = new javax.swing.GroupLayout(PortadaPanel);
        PortadaPanel.setLayout(PortadaPanelLayout);
        PortadaPanelLayout.setHorizontalGroup(
            PortadaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PortadaPanelLayout.createSequentialGroup()
                .addGap(162, 162, 162)
                .addComponent(CuentaBtn3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(456, Short.MAX_VALUE))
        );
        PortadaPanelLayout.setVerticalGroup(
            PortadaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PortadaPanelLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(CuentaBtn3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(PortadaPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 0, 750, 130));

        UsuarioComunidad.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
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
        jPanel1.add(UsuarioComunidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 170, -1, -1));

        NombreComunidad.setFont(new java.awt.Font("Roboto Black", 1, 22)); // NOI18N
        NombreComunidad.setForeground(new java.awt.Color(204, 204, 204));
        NombreComunidad.setText("Usuario");
        jPanel1.add(NombreComunidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 140, -1, 19));

        jSeparator4.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator4.setForeground(new java.awt.Color(153, 153, 153));
        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 0, 10, 1040));

        SubMenu.setBackground(new java.awt.Color(0, 102, 204));
        SubMenu.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);

        PublicacionesImagenes.setBackground(new java.awt.Color(0, 0, 0));

        PanelNot1.setBackground(new java.awt.Color(106, 30, 85));
        PanelNot1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        PanelNot1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PanelNot1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        UsuarioPub1.setFont(new java.awt.Font("SansSerif", 0, 10)); // NOI18N
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
        PanelNot1.add(UsuarioPub1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, -1, -1));

        NombrePub1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        NombrePub1.setForeground(new java.awt.Color(204, 204, 204));
        NombrePub1.setText("Usuario");
        PanelNot1.add(NombrePub1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, -1, -1));

        DescripcionPub1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        DescripcionPub1.setForeground(new java.awt.Color(204, 204, 204));
        DescripcionPub1.setText("Descripcion...");
        PanelNot1.add(DescripcionPub1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 430, 110));

        ImgPub1.setForeground(new java.awt.Color(255, 255, 255));
        ImgPub1.setText("ImgNot");
        PanelNot1.add(ImgPub1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 70, 70));

        imagen1.setForeground(new java.awt.Color(255, 255, 255));
        imagen1.setToolTipText("");
        PanelNot1.add(imagen1, new org.netbeans.lib.awtextra.AbsoluteConstraints(437, 7, 295, 230));

        Fecha_Label1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        Fecha_Label1.setForeground(new java.awt.Color(255, 255, 255));
        Fecha_Label1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Fecha_Label1.setText("Fecha_posts");
        PanelNot1.add(Fecha_Label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(289, 28, 130, -1));

        lblLikesLabel1.setForeground(new java.awt.Color(255, 255, 255));
        lblLikesLabel1.setText("0");
        PanelNot1.add(lblLikesLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 90, -1));

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
        PanelNot1.add(meGustaBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 40, 30));

        lblComentarLabel1.setForeground(new java.awt.Color(255, 255, 255));
        lblComentarLabel1.setText("0");
        PanelNot1.add(lblComentarLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 210, 100, -1));

        comentarBtn1.setBackground(new java.awt.Color(106, 30, 85));
        comentarBtn1.setForeground(new java.awt.Color(255, 255, 255));
        comentarBtn1.setText("-");
        comentarBtn1.setBorder(null);
        comentarBtn1.setBorderPainted(false);
        comentarBtn1.setContentAreaFilled(false);
        PanelNot1.add(comentarBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(147, 200, 40, 30));

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
        PanelNot1.add(repostearBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(297, 200, 40, 30));

        lblRepostearLabel1.setForeground(new java.awt.Color(255, 255, 255));
        lblRepostearLabel1.setText("0");
        PanelNot1.add(lblRepostearLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 210, 90, -1));

        PanelNot2.setBackground(new java.awt.Color(106, 30, 85));
        PanelNot2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        PanelNot2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PanelNot2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ImgPub2.setForeground(new java.awt.Color(255, 255, 255));
        ImgPub2.setText("ImgNot");
        PanelNot2.add(ImgPub2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 70, 70));

        NombrePub2.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        NombrePub2.setForeground(new java.awt.Color(204, 204, 204));
        NombrePub2.setText("Usuario");
        PanelNot2.add(NombrePub2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, -1, -1));

        DescripcionPub2.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        DescripcionPub2.setForeground(new java.awt.Color(204, 204, 204));
        DescripcionPub2.setText("Descripcion...");
        PanelNot2.add(DescripcionPub2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 430, 110));

        UsuarioPub2.setFont(new java.awt.Font("SansSerif", 0, 10)); // NOI18N
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
        PanelNot2.add(UsuarioPub2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, -1, -1));

        imagen2.setForeground(new java.awt.Color(255, 255, 255));
        PanelNot2.add(imagen2, new org.netbeans.lib.awtextra.AbsoluteConstraints(437, 7, 295, 230));

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
        PanelNot2.add(meGustaBtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 40, 30));

        comentarBtn2.setBackground(new java.awt.Color(106, 30, 85));
        comentarBtn2.setForeground(new java.awt.Color(255, 255, 255));
        comentarBtn2.setText("-");
        comentarBtn2.setBorder(null);
        comentarBtn2.setBorderPainted(false);
        comentarBtn2.setContentAreaFilled(false);
        PanelNot2.add(comentarBtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, 40, 30));

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
        PanelNot2.add(repostearBtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(297, 200, 40, 30));

        lblLikesLabel2.setForeground(new java.awt.Color(255, 255, 255));
        lblLikesLabel2.setText("0");
        PanelNot2.add(lblLikesLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 90, 20));

        lblComentarLabel2.setForeground(new java.awt.Color(255, 255, 255));
        lblComentarLabel2.setText("0");
        PanelNot2.add(lblComentarLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 210, 70, 20));

        lblRepostearLabel2.setForeground(new java.awt.Color(255, 255, 255));
        lblRepostearLabel2.setText("0");
        PanelNot2.add(lblRepostearLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 210, 80, 20));

        Fecha_Label2.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        Fecha_Label2.setForeground(new java.awt.Color(255, 255, 255));
        Fecha_Label2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Fecha_Label2.setText("Fecha_posts");
        PanelNot2.add(Fecha_Label2, new org.netbeans.lib.awtextra.AbsoluteConstraints(289, 28, 130, -1));

        Btn_Siguiente1.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        Btn_Siguiente1.setForeground(new java.awt.Color(255, 255, 255));
        Btn_Siguiente1.setText(">");
        Btn_Siguiente1.setBorderPainted(false);
        Btn_Siguiente1.setContentAreaFilled(false);
        Btn_Siguiente1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Siguiente1ActionPerformed(evt);
            }
        });

        Btn_Anterior1.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        Btn_Anterior1.setForeground(new java.awt.Color(255, 255, 255));
        Btn_Anterior1.setText("<");
        Btn_Anterior1.setBorderPainted(false);
        Btn_Anterior1.setContentAreaFilled(false);
        Btn_Anterior1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Anterior1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PublicacionesImagenesLayout = new javax.swing.GroupLayout(PublicacionesImagenes);
        PublicacionesImagenes.setLayout(PublicacionesImagenesLayout);
        PublicacionesImagenesLayout.setHorizontalGroup(
            PublicacionesImagenesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PublicacionesImagenesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Btn_Anterior1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(Btn_Siguiente1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(314, 314, 314))
            .addGroup(PublicacionesImagenesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PublicacionesImagenesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanelNot1, javax.swing.GroupLayout.DEFAULT_SIZE, 738, Short.MAX_VALUE)
                    .addComponent(PanelNot2, javax.swing.GroupLayout.DEFAULT_SIZE, 738, Short.MAX_VALUE))
                .addContainerGap())
        );
        PublicacionesImagenesLayout.setVerticalGroup(
            PublicacionesImagenesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PublicacionesImagenesLayout.createSequentialGroup()
                .addGroup(PublicacionesImagenesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Btn_Siguiente1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Btn_Anterior1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelNot1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelNot2, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        SubMenu.addTab("Multimedia", PublicacionesImagenes);

        PublicacionesTexto.setBackground(new java.awt.Color(0, 0, 0));

        PanelTxt1.setBackground(new java.awt.Color(64, 11, 59));
        PanelTxt1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        PanelTxt1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PanelTxt1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        UsuarioPub3.setFont(new java.awt.Font("SansSerif", 0, 10)); // NOI18N
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
        PanelTxt1.add(UsuarioPub3, new org.netbeans.lib.awtextra.AbsoluteConstraints(127, 28, -1, -1));

        NombrePub3.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        NombrePub3.setForeground(new java.awt.Color(204, 204, 204));
        NombrePub3.setText("Usuario");
        PanelTxt1.add(NombrePub3, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 24, -1, -1));

        ImgPub3.setForeground(new java.awt.Color(255, 255, 255));
        ImgPub3.setText("ImgNot");
        PanelTxt1.add(ImgPub3, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 7, 54, 54));

        Fecha_Label3.setForeground(new java.awt.Color(255, 255, 255));
        Fecha_Label3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Fecha_Label3.setText("Fecha_posts");
        PanelTxt1.add(Fecha_Label3, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 20, 130, -1));

        lblLikesLabel3.setForeground(new java.awt.Color(255, 255, 255));
        lblLikesLabel3.setText("0");
        PanelTxt1.add(lblLikesLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 90, -1));

        meGustaBtn3.setBackground(new java.awt.Color(59, 28, 50));
        meGustaBtn3.setForeground(new java.awt.Color(255, 255, 255));
        meGustaBtn3.setText("-");
        meGustaBtn3.setBorder(null);
        meGustaBtn3.setBorderPainted(false);
        meGustaBtn3.setContentAreaFilled(false);
        meGustaBtn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                meGustaBtn3ActionPerformed(evt);
            }
        });
        PanelTxt1.add(meGustaBtn3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 40, 30));

        lblComentarLabel3.setForeground(new java.awt.Color(255, 255, 255));
        lblComentarLabel3.setText("0");
        PanelTxt1.add(lblComentarLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 130, 90, -1));

        comentarBtn3.setBackground(new java.awt.Color(106, 30, 85));
        comentarBtn3.setForeground(new java.awt.Color(255, 255, 255));
        comentarBtn3.setText("-");
        comentarBtn3.setBorder(null);
        comentarBtn3.setBorderPainted(false);
        comentarBtn3.setContentAreaFilled(false);
        PanelTxt1.add(comentarBtn3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 40, 30));

        repostearBtn3.setBackground(new java.awt.Color(59, 28, 50));
        repostearBtn3.setForeground(new java.awt.Color(255, 255, 255));
        repostearBtn3.setText("-");
        repostearBtn3.setBorder(null);
        repostearBtn3.setBorderPainted(false);
        repostearBtn3.setContentAreaFilled(false);
        repostearBtn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                repostearBtn3ActionPerformed(evt);
            }
        });
        PanelTxt1.add(repostearBtn3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 120, 40, 30));

        lblRepostearLabel3.setForeground(new java.awt.Color(255, 255, 255));
        lblRepostearLabel3.setText("0");
        PanelTxt1.add(lblRepostearLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 130, 90, -1));

        DescripcionPub3.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        DescripcionPub3.setForeground(new java.awt.Color(204, 204, 204));
        DescripcionPub3.setText("Descripcion...");
        PanelTxt1.add(DescripcionPub3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 720, 60));

        PanelTxt2.setBackground(new java.awt.Color(64, 11, 59));
        PanelTxt2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        PanelTxt2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PanelTxt2.setPreferredSize(new java.awt.Dimension(736, 190));
        PanelTxt2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ImgPub4.setForeground(new java.awt.Color(255, 255, 255));
        ImgPub4.setText("ImgNot");
        PanelTxt2.add(ImgPub4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 54, 54));

        meGustaBtn4.setBackground(new java.awt.Color(59, 28, 50));
        meGustaBtn4.setForeground(new java.awt.Color(255, 255, 255));
        meGustaBtn4.setText("-");
        meGustaBtn4.setBorder(null);
        meGustaBtn4.setBorderPainted(false);
        meGustaBtn4.setContentAreaFilled(false);
        meGustaBtn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                meGustaBtn4ActionPerformed(evt);
            }
        });
        PanelTxt2.add(meGustaBtn4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 40, 30));

        comentarBtn4.setBackground(new java.awt.Color(106, 30, 85));
        comentarBtn4.setForeground(new java.awt.Color(255, 255, 255));
        comentarBtn4.setText("-");
        comentarBtn4.setBorder(null);
        comentarBtn4.setBorderPainted(false);
        comentarBtn4.setContentAreaFilled(false);
        comentarBtn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comentarBtn4ActionPerformed(evt);
            }
        });
        PanelTxt2.add(comentarBtn4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 40, 30));

        repostearBtn4.setBackground(new java.awt.Color(59, 28, 50));
        repostearBtn4.setForeground(new java.awt.Color(255, 255, 255));
        repostearBtn4.setText("-");
        repostearBtn4.setBorder(null);
        repostearBtn4.setBorderPainted(false);
        repostearBtn4.setContentAreaFilled(false);
        repostearBtn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                repostearBtn4ActionPerformed(evt);
            }
        });
        PanelTxt2.add(repostearBtn4, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 120, 40, 30));

        lblLikesLabel4.setForeground(new java.awt.Color(255, 255, 255));
        lblLikesLabel4.setText("0");
        PanelTxt2.add(lblLikesLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 90, -1));

        lblComentarLabel4.setForeground(new java.awt.Color(255, 255, 255));
        lblComentarLabel4.setText("0");
        PanelTxt2.add(lblComentarLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 130, 50, -1));

        lblRepostearLabel4.setForeground(new java.awt.Color(255, 255, 255));
        lblRepostearLabel4.setText("0");
        PanelTxt2.add(lblRepostearLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 130, 90, -1));

        UsuarioPub4.setFont(new java.awt.Font("SansSerif", 0, 10)); // NOI18N
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
        PanelTxt2.add(UsuarioPub4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 24, -1, 20));

        Fecha_Label4.setForeground(new java.awt.Color(255, 255, 255));
        Fecha_Label4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Fecha_Label4.setText("Fecha_posts");
        PanelTxt2.add(Fecha_Label4, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 20, 130, -1));

        NombrePub4.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        NombrePub4.setForeground(new java.awt.Color(204, 204, 204));
        NombrePub4.setText("Usuario");
        PanelTxt2.add(NombrePub4, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 24, -1, -1));

        DescripcionPub4.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        DescripcionPub4.setForeground(new java.awt.Color(204, 204, 204));
        DescripcionPub4.setText("Descripcion...");
        PanelTxt2.add(DescripcionPub4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 720, 60));

        PanelTxt3.setBackground(new java.awt.Color(64, 11, 59));
        PanelTxt3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        PanelTxt3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PanelTxt3.setPreferredSize(new java.awt.Dimension(736, 190));
        PanelTxt3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ImgPub5.setForeground(new java.awt.Color(255, 255, 255));
        ImgPub5.setText("ImgNot");
        PanelTxt3.add(ImgPub5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 54, 54));

        meGustaBtn5.setBackground(new java.awt.Color(59, 28, 50));
        meGustaBtn5.setForeground(new java.awt.Color(255, 255, 255));
        meGustaBtn5.setText("-");
        meGustaBtn5.setBorder(null);
        meGustaBtn5.setBorderPainted(false);
        meGustaBtn5.setContentAreaFilled(false);
        meGustaBtn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                meGustaBtn5ActionPerformed(evt);
            }
        });
        PanelTxt3.add(meGustaBtn5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 40, 30));

        comentarBtn5.setBackground(new java.awt.Color(106, 30, 85));
        comentarBtn5.setForeground(new java.awt.Color(255, 255, 255));
        comentarBtn5.setText("-");
        comentarBtn5.setBorder(null);
        comentarBtn5.setBorderPainted(false);
        comentarBtn5.setContentAreaFilled(false);
        comentarBtn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comentarBtn5ActionPerformed(evt);
            }
        });
        PanelTxt3.add(comentarBtn5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 40, 30));

        repostearBtn5.setBackground(new java.awt.Color(59, 28, 50));
        repostearBtn5.setForeground(new java.awt.Color(255, 255, 255));
        repostearBtn5.setText("-");
        repostearBtn5.setBorder(null);
        repostearBtn5.setBorderPainted(false);
        repostearBtn5.setContentAreaFilled(false);
        repostearBtn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                repostearBtn5ActionPerformed(evt);
            }
        });
        PanelTxt3.add(repostearBtn5, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 120, 40, 30));

        lblLikesLabel5.setForeground(new java.awt.Color(255, 255, 255));
        lblLikesLabel5.setText("0");
        PanelTxt3.add(lblLikesLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 90, -1));

        lblComentarLabel5.setForeground(new java.awt.Color(255, 255, 255));
        lblComentarLabel5.setText("0");
        PanelTxt3.add(lblComentarLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 130, 100, -1));

        lblRepostearLabel5.setForeground(new java.awt.Color(255, 255, 255));
        lblRepostearLabel5.setText("0");
        PanelTxt3.add(lblRepostearLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 130, 90, -1));

        UsuarioPub5.setFont(new java.awt.Font("SansSerif", 0, 10)); // NOI18N
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
        PanelTxt3.add(UsuarioPub5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 24, -1, 20));

        Fecha_Label5.setForeground(new java.awt.Color(255, 255, 255));
        Fecha_Label5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Fecha_Label5.setText("Fecha_posts");
        PanelTxt3.add(Fecha_Label5, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 20, 130, -1));

        NombrePub5.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        NombrePub5.setForeground(new java.awt.Color(204, 204, 204));
        NombrePub5.setText("Usuario");
        PanelTxt3.add(NombrePub5, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 24, -1, -1));

        DescripcionPub5.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        DescripcionPub5.setForeground(new java.awt.Color(204, 204, 204));
        DescripcionPub5.setText("Descripcion...");
        PanelTxt3.add(DescripcionPub5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 720, 60));

        Btn_Anterior2.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        Btn_Anterior2.setForeground(new java.awt.Color(255, 255, 255));
        Btn_Anterior2.setText("<");
        Btn_Anterior2.setBorderPainted(false);
        Btn_Anterior2.setContentAreaFilled(false);
        Btn_Anterior2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Anterior2ActionPerformed(evt);
            }
        });

        Btn_Siguiente2.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        Btn_Siguiente2.setForeground(new java.awt.Color(255, 255, 255));
        Btn_Siguiente2.setText(">");
        Btn_Siguiente2.setBorderPainted(false);
        Btn_Siguiente2.setContentAreaFilled(false);
        Btn_Siguiente2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Siguiente2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PublicacionesTextoLayout = new javax.swing.GroupLayout(PublicacionesTexto);
        PublicacionesTexto.setLayout(PublicacionesTextoLayout);
        PublicacionesTextoLayout.setHorizontalGroup(
            PublicacionesTextoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PublicacionesTextoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PublicacionesTextoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanelTxt1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelTxt2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 738, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PublicacionesTextoLayout.createSequentialGroup()
                        .addComponent(PanelTxt3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(PublicacionesTextoLayout.createSequentialGroup()
                .addGap(314, 314, 314)
                .addComponent(Btn_Anterior2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(Btn_Siguiente2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PublicacionesTextoLayout.setVerticalGroup(
            PublicacionesTextoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PublicacionesTextoLayout.createSequentialGroup()
                .addGroup(PublicacionesTextoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Btn_Siguiente2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Btn_Anterior2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelTxt1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelTxt2, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelTxt3, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        SubMenu.addTab("Texto", PublicacionesTexto);

        jPanel1.add(SubMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 300, 750, 560));

        Seguir.setBackground(new java.awt.Color(166, 77, 121));
        Seguir.setForeground(new java.awt.Color(255, 255, 255));
        Seguir.setText("Seguir");
        Seguir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SeguirActionPerformed(evt);
            }
        });
        jPanel1.add(Seguir, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 150, 100, -1));

        DescLabel.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        DescLabel.setForeground(new java.awt.Color(204, 204, 204));
        DescLabel.setText("Descripcion");
        jPanel1.add(DescLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 190, 450, 60));

        MenuDeNavegacion.setBackground(new java.awt.Color(51, 51, 51));

        AyudaSeleccion1.setForeground(new java.awt.Color(255, 0, 255));

        jButton1.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(204, 204, 204));
        jButton1.setText("Multimedia");
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(204, 204, 204));
        jButton3.setText("Post");
        jButton3.setContentAreaFilled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        AyudaSeleccion2.setForeground(new java.awt.Color(102, 0, 102));

        javax.swing.GroupLayout MenuDeNavegacionLayout = new javax.swing.GroupLayout(MenuDeNavegacion);
        MenuDeNavegacion.setLayout(MenuDeNavegacionLayout);
        MenuDeNavegacionLayout.setHorizontalGroup(
            MenuDeNavegacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MenuDeNavegacionLayout.createSequentialGroup()
                .addGap(142, 142, 142)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(154, 154, 154))
            .addGroup(MenuDeNavegacionLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(AyudaSeleccion1, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(AyudaSeleccion2, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        MenuDeNavegacionLayout.setVerticalGroup(
            MenuDeNavegacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(MenuDeNavegacionLayout.createSequentialGroup()
                .addGroup(MenuDeNavegacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(MenuDeNavegacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(MenuDeNavegacionLayout.createSequentialGroup()
                        .addComponent(AyudaSeleccion2)
                        .addContainerGap())
                    .addComponent(AyudaSeleccion1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel1.add(MenuDeNavegacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 250, 750, 40));

        Num_Siguiendo.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        Num_Siguiendo.setForeground(new java.awt.Color(204, 204, 204));
        Num_Siguiendo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Num_Siguiendo.setText("0");
        Num_Siguiendo.setToolTipText("");
        jPanel1.add(Num_Siguiendo, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 210, 40, 30));

        Num_Seguidores.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        Num_Seguidores.setForeground(new java.awt.Color(204, 204, 204));
        Num_Seguidores.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Num_Seguidores.setText("0");
        Num_Seguidores.setToolTipText("");
        jPanel1.add(Num_Seguidores, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 210, 40, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1550, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CuentaBtn9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CuentaBtn9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CuentaBtn9ActionPerformed

    private void CuentaBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CuentaBtn2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CuentaBtn2ActionPerformed

    private void ConfiBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfiBtnActionPerformed
               this.dispose();
       new Configuracion().setVisible(true); // TODO add your handling code here:
    }//GEN-LAST:event_ConfiBtnActionPerformed

    private void InicioBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InicioBtn1ActionPerformed
this.dispose();
new Menu_Principal().setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_InicioBtn1ActionPerformed

    private void ExplorarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExplorarBtnActionPerformed
       this.dispose();
       new Explorar().setVisible(true);  
        // TODO add your handling code here:
    }//GEN-LAST:event_ExplorarBtnActionPerformed

    private void ComunidadesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComunidadesBtnActionPerformed

               this.dispose();
       new Comunidad().setVisible(true); 
        // TODO add your handling code here:
    }//GEN-LAST:event_ComunidadesBtnActionPerformed

    private void NotificacionesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NotificacionesBtnActionPerformed
       this.dispose();
       new Notificaciones().setVisible(true);         
// TODO add your handling code here:
    }//GEN-LAST:event_NotificacionesBtnActionPerformed

    private void GuardadoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardadoBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GuardadoBtnActionPerformed

    private void PerfilBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PerfilBtnActionPerformed
               this.dispose();
       new Perfil().setVisible(true); // TODO add your handling code here:
    }//GEN-LAST:event_PerfilBtnActionPerformed

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

    private void CuentaBtn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CuentaBtn3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CuentaBtn3ActionPerformed

    private void UsuarioComunidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsuarioComunidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UsuarioComunidadActionPerformed

    private void UsuarioPub4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsuarioPub4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UsuarioPub4ActionPerformed

    private void repostearBtn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_repostearBtn4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_repostearBtn4ActionPerformed

    private void comentarBtn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comentarBtn4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comentarBtn4ActionPerformed

    private void meGustaBtn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meGustaBtn4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_meGustaBtn4ActionPerformed

    private void repostearBtn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_repostearBtn3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_repostearBtn3ActionPerformed

    private void meGustaBtn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meGustaBtn3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_meGustaBtn3ActionPerformed

    private void UsuarioPub3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsuarioPub3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UsuarioPub3ActionPerformed

    private void repostearBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_repostearBtn2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_repostearBtn2ActionPerformed

    private void meGustaBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meGustaBtn2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_meGustaBtn2ActionPerformed

    private void repostearBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_repostearBtn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_repostearBtn1ActionPerformed

    private void meGustaBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meGustaBtn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_meGustaBtn1ActionPerformed

    private void UsuarioPub1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsuarioPub1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UsuarioPub1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String Selec = SubMenu.getSelectedComponent().toString();
        if(Selec != "PublicacionesTexto"){
            SubMenu.setSelectedIndex(1);
            AyudaSeleccion1.setForeground(new Color(255,0,255));
        } else{
            AyudaSeleccion1.setBackground(new Color(51,51,51));
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String Selec = SubMenu.getSelectedComponent().toString();
        if(Selec != "PublicacionesImagenes"){
            SubMenu.setSelectedIndex(0);
            AyudaSeleccion2.setForeground(new Color(255,0,255));
        } else{
            AyudaSeleccion2.setBackground(new Color(51,51,51));
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void SeguirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeguirActionPerformed
    String idSeguidor = SesionUsuario.idUsuario; // ID del usuario logueado
    String idSeguido = IdUsuario; // ID del perfil que se está viendo

    try {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/tu_basedatos", "root", "tu_password");

        String sql = "INSERT IGNORE INTO seguidores (id_seguidor, id_seguido) VALUES (?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, idSeguidor);
        ps.setString(2, idSeguido);

        int filas = ps.executeUpdate();

        if (filas > 0) {
            // Éxito: se insertó un nuevo seguidor
            JOptionPane.showMessageDialog(null, "Ahora estás siguiendo a " + idSeguido);

            // Cambiar texto y colores del botón
            Seguir.setText("Siguiendo");
            Seguir.setBackground(Color.BLACK);
            Seguir.setForeground(Color.WHITE);
            Seguir.setEnabled(false); // Deshabilitar si no quieres que vuelva a apretarse

            // Actualizar contador de seguidores
            String texto = Num_Seguidores.getText(); // Por ejemplo: "Seguidores: 123"
            String[] partes = texto.split(": ");
            if (partes.length == 2) {
                try {
                    int seguidores = Integer.parseInt(partes[1]);
                    seguidores++;
                    Num_Seguidores.setText("Seguidores: " + seguidores);
                } catch (NumberFormatException e) {
                    System.err.println("Error al convertir el número de seguidores.");
                }
            }

        } else {
            JOptionPane.showMessageDialog(null, "Ya lo estás siguiendo");
        }

        ps.close();
        conn.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }


    }//GEN-LAST:event_SeguirActionPerformed

    private void UsuarioPub2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsuarioPub2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UsuarioPub2ActionPerformed

    private void Btn_Anterior1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Anterior1ActionPerformed
        
    }//GEN-LAST:event_Btn_Anterior1ActionPerformed

    private void Btn_Siguiente1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Siguiente1ActionPerformed
        
    }//GEN-LAST:event_Btn_Siguiente1ActionPerformed

    private void meGustaBtn5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meGustaBtn5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_meGustaBtn5ActionPerformed

    private void comentarBtn5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comentarBtn5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comentarBtn5ActionPerformed

    private void repostearBtn5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_repostearBtn5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_repostearBtn5ActionPerformed

    private void UsuarioPub5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsuarioPub5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UsuarioPub5ActionPerformed

    private void Btn_Anterior2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Anterior2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Btn_Anterior2ActionPerformed

    private void Btn_Siguiente2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Siguiente2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Btn_Siguiente2ActionPerformed

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
            java.util.logging.Logger.getLogger(PerfilPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PerfilPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PerfilPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PerfilPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                String usuario = "usuarioDesdeOtraVentana";
                try {
                    new PerfilPersona(usuario).setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(PerfilPersona.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSeparator AyudaSeleccion1;
    private javax.swing.JSeparator AyudaSeleccion2;
    private javax.swing.JButton Btn_Anterior1;
    private javax.swing.JButton Btn_Anterior2;
    private javax.swing.JButton Btn_Siguiente1;
    private javax.swing.JButton Btn_Siguiente2;
    private javax.swing.ButtonGroup Colores;
    private javax.swing.JButton ComunidadesBtn;
    private javax.swing.JButton ConfiBtn;
    private javax.swing.JButton CuentaBtn2;
    private javax.swing.JButton CuentaBtn20;
    private javax.swing.JButton CuentaBtn3;
    private javax.swing.JButton CuentaBtn9;
    private javax.swing.JLabel DescLabel;
    private javax.swing.JLabel DescripcionPub1;
    private javax.swing.JLabel DescripcionPub2;
    private javax.swing.JLabel DescripcionPub3;
    private javax.swing.JLabel DescripcionPub4;
    private javax.swing.JLabel DescripcionPub5;
    private javax.swing.JButton ExplorarBtn;
    private javax.swing.JLabel Fecha_Label1;
    private javax.swing.JLabel Fecha_Label2;
    private javax.swing.JLabel Fecha_Label3;
    private javax.swing.JLabel Fecha_Label4;
    private javax.swing.JLabel Fecha_Label5;
    private javax.swing.JLabel FotoPerfil;
    private javax.swing.JButton GuardadoBtn;
    private javax.swing.JLabel IdUsuario2;
    private javax.swing.JLabel ImgInt1;
    private javax.swing.JLabel ImgInt2;
    private javax.swing.JLabel ImgInt3;
    private javax.swing.JLabel ImgPub1;
    private javax.swing.JLabel ImgPub2;
    private javax.swing.JLabel ImgPub3;
    private javax.swing.JLabel ImgPub4;
    private javax.swing.JLabel ImgPub5;
    private javax.swing.JButton InicioBtn1;
    private javax.swing.JPanel MenuDeNavegacion;
    private javax.swing.JButton MostrarMasInteresBtn;
    private javax.swing.JButton MostrarMasTendenciaBtn;
    private javax.swing.JLabel NombreComunidad;
    private javax.swing.JLabel NombrePub1;
    private javax.swing.JLabel NombrePub2;
    private javax.swing.JLabel NombrePub3;
    private javax.swing.JLabel NombrePub4;
    private javax.swing.JLabel NombrePub5;
    private javax.swing.JLabel NombreUsuario;
    private javax.swing.JButton NotificacionesBtn;
    private javax.swing.JLabel Num_Seguidores;
    private javax.swing.JLabel Num_Siguiendo;
    private javax.swing.JPanel PanelNot1;
    private javax.swing.JPanel PanelNot2;
    private javax.swing.JPanel PanelTxt1;
    private javax.swing.JPanel PanelTxt2;
    private javax.swing.JPanel PanelTxt3;
    private javax.swing.JButton PerfilBtn;
    private javax.swing.JPanel PerfilPanel;
    private javax.swing.JLabel Perfil_Img;
    private javax.swing.JLabel Perfil_Img1;
    private javax.swing.JPanel PortadaPanel;
    private javax.swing.JButton PostearBtn;
    private javax.swing.JButton PublicacionesBtn1;
    private javax.swing.JButton PublicacionesBtn2;
    private javax.swing.JPanel PublicacionesImagenes;
    private javax.swing.JPanel PublicacionesTexto;
    private javax.swing.JLabel QuePasa;
    private javax.swing.JButton Seguir;
    private javax.swing.JButton SeguirCuentaBtn1;
    private javax.swing.JButton SeguirCuentaBtn2;
    private javax.swing.JButton SeguirCuentaBtn3;
    private javax.swing.JTabbedPane SubMenu;
    private javax.swing.JButton TendenciaYapBtn1;
    private javax.swing.JButton TendenciaYapBtn2;
    private javax.swing.JButton UserInt1;
    private javax.swing.JButton UserInt2;
    private javax.swing.JButton UserInt3;
    private javax.swing.JButton UsuarioComunidad;
    private javax.swing.JButton UsuarioPub1;
    private javax.swing.JButton UsuarioPub2;
    private javax.swing.JButton UsuarioPub3;
    private javax.swing.JButton UsuarioPub4;
    private javax.swing.JButton UsuarioPub5;
    private javax.swing.JLabel Y_logo;
    private javax.swing.JButton comentarBtn1;
    private javax.swing.JButton comentarBtn2;
    private javax.swing.JButton comentarBtn3;
    private javax.swing.JButton comentarBtn4;
    private javax.swing.JButton comentarBtn5;
    private javax.swing.JLabel imagen1;
    private javax.swing.JLabel imagen2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JLabel lblComentarLabel1;
    private javax.swing.JLabel lblComentarLabel2;
    private javax.swing.JLabel lblComentarLabel3;
    private javax.swing.JLabel lblComentarLabel4;
    private javax.swing.JLabel lblComentarLabel5;
    private javax.swing.JLabel lblLikesLabel1;
    private javax.swing.JLabel lblLikesLabel2;
    private javax.swing.JLabel lblLikesLabel3;
    private javax.swing.JLabel lblLikesLabel4;
    private javax.swing.JLabel lblLikesLabel5;
    private javax.swing.JLabel lblRepostearLabel1;
    private javax.swing.JLabel lblRepostearLabel2;
    private javax.swing.JLabel lblRepostearLabel3;
    private javax.swing.JLabel lblRepostearLabel4;
    private javax.swing.JLabel lblRepostearLabel5;
    private javax.swing.JButton meGustaBtn1;
    private javax.swing.JButton meGustaBtn2;
    private javax.swing.JButton meGustaBtn3;
    private javax.swing.JButton meGustaBtn4;
    private javax.swing.JButton meGustaBtn5;
    private javax.swing.JButton repostearBtn1;
    private javax.swing.JButton repostearBtn2;
    private javax.swing.JButton repostearBtn3;
    private javax.swing.JButton repostearBtn4;
    private javax.swing.JButton repostearBtn5;
    // End of variables declaration//GEN-END:variables
}
