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
import java.util.Collections;
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
public class Perfil extends javax.swing.JFrame {
     private File archivoImagenSeleccionado;
    private PublicacionDAO publicacionDAO;
    private List<Publicacion> publicaciones;
    private List<Publicacion> publicacionestxt; 
    private Publicacion publicacionId;
    //private List<Publicacion> publicaciones, publicacionesSeguidos;
    private int publicacionActual = 0,publicacionSeguidoActual = 0, publicacionTrend1 = 0, publicacionTrend2 = 0, publicacionTrend3 = 0;
    private String Interes1,Interes2,Interes3;
    int indextex = 0;
    int indexmulti = 0;
    String IdUsuario = "";
    int xMouse;
    int yMouse;
    String tipo = " ";
   int paginaActual = 1; // Inicialízala como global
    int tamanioPagina = 4;
    
    public Perfil()  {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setLocationRelativeTo(null);
        Img();
        
        SeccionTePuedeInteresar();
        SeccionTendencias();
        cargarFotoPerfil(); 
        Connection con =  DB_Conection.conectar(); // tu clase de conexión}
        ObtenerDatosUsuario();
        String IdUsuario = SesionUsuario.idUsuario;
        if (IdUsuario != null) {
            String nom = obtenerNombreUsuario(IdUsuario);
            NombreUsuario.setText(nom);
            IdUsuario2.setText( "@" + IdUsuario);
            NombreComunidad.setText(nom);
            UsuarioComunidad.setText( "@" + IdUsuario);
            NombrePub1.setText(nom);
            NombrePub4.setText(nom);
            
          String sqlSeguidores = "SELECT COUNT(*) FROM seguidores WHERE id_seguido = ?";
            PreparedStatement ps1;
            try {
                ps1 = con.prepareStatement(sqlSeguidores);
                ps1.setString(1, SesionUsuario.idUsuario);
            ResultSet rs1 = ps1.executeQuery();
            
            
            ps1.close();
            if (rs1.next()) {
                int seguidores = rs1.getInt(1);
                Num_Seguidores.setText(String.valueOf(seguidores));
            }
            
            } catch (SQLException ex) {
                Logger.getLogger(Perfil.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            // Contar seguidos
            String sqlSeguidos = "SELECT COUNT(*) FROM seguidores WHERE id_seguidor = ?";
            
            try {
                PreparedStatement ps2 = con.prepareStatement(sqlSeguidos);
                ps2.setString(1, SesionUsuario.idUsuario);
                ResultSet rs2 = ps2.executeQuery();
            if (rs2.next()) {
                int seguidos = rs2.getInt(1);
                Num_Siguiendo.setText(String.valueOf(seguidos));
                
                ps2.close();
            }
            } catch (SQLException ex) {
                Logger.getLogger(Perfil.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            
            
        }
        publicacionDAO = new PublicacionDAO();
        publicaciones = publicacionDAO.obtenerTodasPublicacionesUsuario(IdUsuario);
        publicacionestxt = publicacionDAO.obtenerTodasPublicacionesUsuarioTxt(IdUsuario);
        actualizarPublicacionesMultimedia();
        actualizarPublicacionesTexto();
        //Ayuda Selecciones
        SubMenu.setSelectedIndex(1);
         try {
             con.close();
         } catch (SQLException ex) {
             Logger.getLogger(Perfil.class.getName()).log(Level.SEVERE, null, ex);
         }
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
                    if (publicacionDAO.darLike(publica.getIdPublicacion(), publica.getIdUsuario())){
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
                    if (publicacionDAO.darLike(publica.getIdPublicacion(),  publica.getIdUsuario())){
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
                        Image img = icon.getImage().getScaledInstance(FotoPerfil.getWidth(), FotoPerfil.getHeight(), Image.SCALE_SMOOTH);
                        FotoPerfil.setIcon(new ImageIcon(img));
                        
                        Image img2 = icon.getImage().getScaledInstance(ImgPub1.getWidth(), ImgPub1.getHeight(), Image.SCALE_SMOOTH);
                        ImgPub1.setIcon(new ImageIcon(img2));
                        Image img3 = icon.getImage().getScaledInstance(Perfil_Img1.getWidth(), Perfil_Img1.getHeight(), Image.SCALE_SMOOTH);
                        Perfil_Img1.setIcon(new ImageIcon(img3));
                        Image img4 = icon.getImage().getScaledInstance(PerfilPic.getWidth(), PerfilPic.getHeight(), Image.SCALE_SMOOTH);
                        PerfilPic.setIcon(new ImageIcon(img4));
                    } else {
                        String url = "src\\main\\java\\Multimedia\\Img-Perfil.png";
                        ImageIcon icon = new ImageIcon(url);
                        Image img0 = icon.getImage().getScaledInstance(FotoPerfil.getWidth(), FotoPerfil.getHeight(), Image.SCALE_SMOOTH);
                        FotoPerfil.setIcon(new ImageIcon(img0));
                        
                        Image img20 = icon.getImage().getScaledInstance(ImgPub1.getWidth(), ImgPub1.getHeight(), Image.SCALE_SMOOTH);
                        ImgPub1.setIcon(new ImageIcon(img20));
                        Image img30 = icon.getImage().getScaledInstance(Perfil_Img1.getWidth(), Perfil_Img1.getHeight(), Image.SCALE_SMOOTH);
                        Perfil_Img1.setIcon(new ImageIcon(img30));
                        Image img40 = icon.getImage().getScaledInstance(PerfilPic.getWidth(), PerfilPic.getHeight(), Image.SCALE_SMOOTH);
                        PerfilPic.setIcon(new ImageIcon(img40));
                        
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
   
    public void ObtenerDatosUsuario(){
        //Obtenemos todos los datos del usuario
         try {
            Connection con = DB_Conection.conectar();
      
             String sql = "SELECT * FROM usuario WHERE id_usuario = ?";
             PreparedStatement ps = con.prepareStatement(sql);
             ps.setString(1, SesionUsuario.idUsuario);
             ResultSet rs = ps.executeQuery();
             
             if (rs.next()) {
            // Extrae valores de cada columna
            String Nombre = rs.getString("nombre");
            String Descripcion = rs.getString("Descripcion");
            String ColorBanner = rs.getString("ColorBanner");
            
            // Obtiene la fecha de la base de datos (java.sql.Date)
            java.sql.Date fechaSQL = rs.getDate("fecha_nac");
            //Crear el formato de fecha, dia, mes, año
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            //Darle el formato
            String fechaFormateada = sdf.format(fechaSQL);
            
            cargarFotoPerfil();
              // Muestra los valores en los labels
            //Comprobacion de vacio
            
            NombreText.setText(Nombre);
            FechaHora.setText(fechaFormateada);
            if (Descripcion != null){
                //Formato de texto
                DescLabel.setText("<html><p>" + Descripcion + "</html></p>");
                BioText.setText(Descripcion);
            } else {
                DescLabel.setText("Sin descripcion");
            }
            //Comprobacion de campo vacio por defecto
            if (ColorBanner == null ){               
                System.out.println("Null El banner");
                BannerAct.setBackground(new Color (59,28,50));
            } else{
                CuentaBtn3.setVisible(false);
                System.out.println(ColorBanner);
                //Asignamos color a el banner
                switch (ColorBanner) {
                    case "Azul":
                        PortadaPanel.setBackground(Color.BLUE);
                        BannerAct.setBackground(Color.BLUE);
                        BannerAct1.setBackground(Color.BLUE);
                        break;
                    case "Rojo":
                        PortadaPanel.setBackground(Color.RED);
                        BannerAct.setBackground(Color.RED);
                        BannerAct1.setBackground(Color.RED);
                        break;
                    case "Morado":
                        PortadaPanel.setBackground(Color.MAGENTA);
                        BannerAct.setBackground(Color.MAGENTA);
                        BannerAct1.setBackground(Color.MAGENTA);
                        break;
                    case "Amarillo":
                        PortadaPanel.setBackground(Color.yellow);
                        BannerAct.setBackground(Color.yellow);
                        BannerAct1.setBackground(Color.yellow);
                        break;
                    case "Verde":
                        PortadaPanel.setBackground(Color.green);
                        BannerAct.setBackground(Color.green);
                        BannerAct1.setBackground(Color.green);
                        break;
                    case "Naranja":
                        PortadaPanel.setBackground(Color.orange);
                        BannerAct.setBackground(Color.orange);
                        BannerAct1.setBackground(Color.orange);
                        break;
                    case "Rosa":
                        PortadaPanel.setBackground(Color.pink);
                        BannerAct.setBackground(Color.pink);
                        BannerAct1.setBackground(Color.pink);
                        break;
                    default:
                        break;
                }
                
            }
            
             }  else
             {
                 JOptionPane.showMessageDialog(null, "No se encontro el usuario");
             }}catch(SQLException e) {
    e.printStackTrace(); // Mostrará errores ocultos
    JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
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
        Perfil_Img1.setIcon(Icono);

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
        Image img13 = image13.getImage().getScaledInstance(90, 90, 0);
        ImageIcon Icono13 = new ImageIcon(img13);
        Y_logo.setIcon(Icono13);

        //Icono Configuracion
        String url14 = "src\\main\\java\\Multimedia\\Icono-Configuracion.png";
        ImageIcon image14 = new ImageIcon(url14);
        Image img14 = image14.getImage().getScaledInstance(34, 34, 0);
        ImageIcon Icono14 = new ImageIcon(img14);
        ConfiBtn.setIcon(Icono14);
        
         //Icono Editar 
        String urlEditar = "src\\main\\java\\Multimedia\\Icono_Editar.png";
        ImageIcon image16 = new ImageIcon(urlEditar);
        Image img16 = image16.getImage().getScaledInstance(24, 24, 0);
        ImageIcon Icono16 = new ImageIcon(img16);
        Editar1.setIcon(Icono16);
        Editar2.setIcon(Icono16);

    }  
        
    public String ColorBanner(){
            Colores.add(DefaultBanner);
            Colores.add(AzulBanner);
            Colores.add(AmarilloBanner);
            Colores.add(RojoBanner);
            Colores.add(MoradoBanner);
            Colores.add(VerdeBanner);
            Colores.add(NaranjaBanner);
            Colores.add(RosaBanner);
            if(Colores != null){
                if(AzulBanner.isSelected()){String ColorSeleccionado = "Azul"; return ColorSeleccionado;}
                if(AmarilloBanner.isSelected()){String ColorSeleccionado = "Amarillo"; return ColorSeleccionado;}
                if(RojoBanner.isSelected()){String ColorSeleccionado = "Rojo"; return ColorSeleccionado;}
                if(MoradoBanner.isSelected()){String ColorSeleccionado = "Morado"; return ColorSeleccionado;}
                if(VerdeBanner.isSelected()){String ColorSeleccionado = "Verde"; return ColorSeleccionado;}
                if(NaranjaBanner.isSelected()){String ColorSeleccionado = "Naranja"; return ColorSeleccionado;}
                if(RosaBanner.isSelected()){String ColorSeleccionado = "Rosa"; return ColorSeleccionado;}
            }
        return null; 
        }
        
    public void GuardarCambiosBanner (){
        try {
            String Selecc = ColorBanner();
            Connection con = DB_Conection.conectar(); 
            String sql = "UPDATE `usuario` SET ColorBanner = ? WHERE id_usuario = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, Selecc);
            ps.setString(2, SesionUsuario.idUsuario);     
            ps.executeUpdate();
            ObtenerDatosUsuario();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void GuardarCambios(){
        try {
            String nombre = NombreText.getText();
            String Desc = BioText.getText();  
            Connection con = DB_Conection.conectar(); 
            String sql = "UPDATE `usuario` SET Nombre = ?, Descripcion = ? WHERE id_usuario = ?";
            PreparedStatement ps = con.prepareStatement(sql);         
            ps.setString(1, nombre);
            ps.setString(2, Desc);
            ps.setString(3, SesionUsuario.idUsuario);     
            ps.executeUpdate();
            System.out.println("Gaurdados ");
            ObtenerDatosUsuario();
            
        } catch (Exception e) {
            System.out.println("Error " + e);
        }
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
    
    private void cargarDatos() {
    UsuariosDAO dao = new UsuariosDAO();
     // tu ID logueado

    List<Object[]> lista = dao.obtenerRelacionUsuarios(tipo, IdUsuario, paginaActual, tamanioPagina);

    JPanel[] paneles = {Si5, Si6, Si7, Si8}; // tus paneles
    JLabel[] nombres = {NombrePub10, NombrePub11, NombrePub12, NombrePub13};
    JButton[] usuarios = {UsuarioPub10, UsuarioPub11, UsuarioPub12, UsuarioPub13};
    JLabel[] img = {ImgPub10, ImgPub11, ImgPub12, ImgPub13};
    JLabel[] siguiendo = {NumSi5, NumSi6, NumSi7, NumSi8};
    JLabel[] seguidores = {NumSe5, NumSe6, NumSe7, NumSe8};

    for (int i = 0; i < paneles.length; i++) {
        if (i < lista.size()) {
            Object[] datos = lista.get(i);
            nombres[i].setText((String) datos[1]);
            usuarios[i].setText((String) datos[0]);
            siguiendo[i].setText(String.valueOf(datos[3]));
            seguidores[i].setText(String.valueOf(datos[4]));

            // Mostrar imagen
            if (datos[2] != null) {
                ImageIcon icon = new ImageIcon((byte[]) datos[2]);
                Image imgEscalada = icon.getImage().getScaledInstance(img[i].getHeight(), img[i].getHeight(), Image.SCALE_SMOOTH);
                img[i].setIcon(new ImageIcon(imgEscalada));
            } else {
                String url = "src\\main\\java\\Multimedia\\Img-Perfil.png";
                        ImageIcon icon = new ImageIcon(url);
                        Image img0 = icon.getImage().getScaledInstance(img[i].getWidth(), img[i].getHeight(), Image.SCALE_SMOOTH);
                        img[i].setIcon(new ImageIcon(img0));
            }

            paneles[i].setVisible(true);
        } else {
            paneles[i].setVisible(false);
        }
        
        Btn_Anterior4.setVisible(paginaActual > 1);

        // Verificar si hay más datos en la siguiente página
        List<Object[]> siguientePagina = dao.obtenerRelacionUsuarios(tipo, SesionUsuario.idUsuario, paginaActual + 1, tamanioPagina);
        Btn_Siguiente4.setVisible(!siguientePagina.isEmpty());
    }
}
    
    public void UpdateFotoPerfil() throws SQLException{
        try {
        Connection con = DB_Conection.conectar(); 
        File archivoImagen = jFileChooser.getSelectedFile();
        FileInputStream fis = new FileInputStream(archivoImagenSeleccionado);
        
            
            String sql = "UPDATE `usuario` SET foto_perfil = ? WHERE id_usuario = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setBinaryStream(1, fis, (int) archivoImagenSeleccionado.length());
            ps.setString(2, SesionUsuario.idUsuario);     
            ps.executeUpdate();
            ObtenerDatosUsuario();
            }catch (FileNotFoundException ex) {
            Logger.getLogger(Perfil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void UpdateFecha(){
        try {
        String Fecha = CB_Anio.getSelectedItem().toString() + "-" + 
                   CB_Mes.getSelectedItem().toString() + "-" + 
                   CB_Dia.getSelectedItem().toString();
            
            // Convertir a java.sql.Date
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(Fecha, formatter);
        java.sql.Date fechaSQL = java.sql.Date.valueOf(localDate);

        Connection con = DB_Conection.conectar(); 
        String sql = "UPDATE `usuario` SET fecha_nac = ? WHERE id_usuario = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setDate(1, fechaSQL);
        ps.setString(2, SesionUsuario.idUsuario);     
        ps.executeUpdate();
        FechaPanel.setVisible(false);
        ObtenerDatosUsuario();
        } catch (Exception e) {
            System.out.println("Error en la fecha " + e);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Colores = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
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
        SaveCambios = new javax.swing.JPanel();
        Save = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        Editar1 = new javax.swing.JButton();
        PerfilPic = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        BannerAct1 = new javax.swing.JPanel();
        EditarBanner = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        BioText = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        NombreText = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        FechaHora = new javax.swing.JLabel();
        Editar2 = new javax.swing.JButton();
        FechaPanel = new javax.swing.JPanel();
        L_FechaN = new javax.swing.JLabel();
        CB_Dia = new javax.swing.JComboBox<>();
        CB_Mes = new javax.swing.JComboBox<>();
        CB_Anio = new javax.swing.JComboBox<>();
        Editar3 = new javax.swing.JButton();
        SalirMenu = new javax.swing.JButton();
        Banner = new javax.swing.JPanel();
        BannerAct = new javax.swing.JPanel();
        SalvarBanner = new javax.swing.JButton();
        DefaultBanner = new javax.swing.JRadioButton();
        RojoBanner = new javax.swing.JRadioButton();
        VerdeBanner = new javax.swing.JRadioButton();
        RosaBanner = new javax.swing.JRadioButton();
        AmarilloBanner = new javax.swing.JRadioButton();
        NaranjaBanner = new javax.swing.JRadioButton();
        MoradoBanner = new javax.swing.JRadioButton();
        AzulBanner = new javax.swing.JRadioButton();
        EditarFoto = new javax.swing.JPanel();
        PanelFlotante2 = new javax.swing.JPanel();
        J_Archivos = new javax.swing.JPanel();
        jFileChooser = new javax.swing.JFileChooser();
        L_Nombre2 = new javax.swing.JLabel();
        Siguiente2 = new javax.swing.JButton();
        B_ElegirOtra = new javax.swing.JButton();
        L_Aviso11 = new javax.swing.JLabel();
        J_C_Foto = new javax.swing.JPanel();
        L_Foto = new javax.swing.JLabel();
        Seguidores = new javax.swing.JPanel();
        Si5 = new javax.swing.JPanel();
        ImgPub10 = new javax.swing.JLabel();
        NombrePub10 = new javax.swing.JLabel();
        UsuarioPub10 = new javax.swing.JButton();
        NumSe5 = new javax.swing.JLabel();
        NumSi5 = new javax.swing.JLabel();
        SeS5 = new javax.swing.JLabel();
        SiS5 = new javax.swing.JLabel();
        Si6 = new javax.swing.JPanel();
        ImgPub11 = new javax.swing.JLabel();
        UsuarioPub11 = new javax.swing.JButton();
        NombrePub11 = new javax.swing.JLabel();
        NumSe6 = new javax.swing.JLabel();
        NumSi6 = new javax.swing.JLabel();
        SeS6 = new javax.swing.JLabel();
        SiS6 = new javax.swing.JLabel();
        Si7 = new javax.swing.JPanel();
        ImgPub12 = new javax.swing.JLabel();
        NombrePub12 = new javax.swing.JLabel();
        UsuarioPub12 = new javax.swing.JButton();
        SiS7 = new javax.swing.JLabel();
        SeS7 = new javax.swing.JLabel();
        NumSe7 = new javax.swing.JLabel();
        NumSi7 = new javax.swing.JLabel();
        Si8 = new javax.swing.JPanel();
        ImgPub13 = new javax.swing.JLabel();
        NombrePub13 = new javax.swing.JLabel();
        UsuarioPub13 = new javax.swing.JButton();
        SeS8 = new javax.swing.JLabel();
        SiS8 = new javax.swing.JLabel();
        NumSi8 = new javax.swing.JLabel();
        NumSe8 = new javax.swing.JLabel();
        Btn_Anterior4 = new javax.swing.JButton();
        Btn_Siguiente4 = new javax.swing.JButton();
        EditarBtn = new javax.swing.JButton();
        DescLabel = new javax.swing.JLabel();
        MenuDeNavegacion = new javax.swing.JPanel();
        AyudaSeleccion1 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        AyudaSeleccion2 = new javax.swing.JSeparator();
        PerfilPanel = new javax.swing.JPanel();
        NombreUsuario = new javax.swing.JLabel();
        IdUsuario2 = new javax.swing.JLabel();
        Perfil_Img1 = new javax.swing.JLabel();
        ConfiBtn = new javax.swing.JButton();
        InicioBtn1 = new javax.swing.JButton();
        NotificacionesBtn = new javax.swing.JButton();
        PerfilBtn = new javax.swing.JButton();
        ExplorarBtn = new javax.swing.JButton();
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
        Num_Siguiendo = new javax.swing.JLabel();
        BtnSiguiendo = new javax.swing.JButton();
        Num_Seguidores = new javax.swing.JLabel();
        BtnSeguidores = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setLocationByPlatform(true);
        setMinimumSize(new java.awt.Dimension(1550, 890));
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setMinimumSize(new java.awt.Dimension(1550, 820));
        jPanel1.setPreferredSize(new java.awt.Dimension(1550, 890));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator1.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator1.setForeground(new java.awt.Color(153, 153, 153));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 50, -1, 1040));

        FotoPerfil.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.add(FotoPerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 130, 110, 110));

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

        jPanel1.add(PortadaPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 50, 750, 130));

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
        jPanel1.add(UsuarioComunidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 220, -1, -1));

        NombreComunidad.setFont(new java.awt.Font("Roboto Black", 1, 22)); // NOI18N
        NombreComunidad.setForeground(new java.awt.Color(204, 204, 204));
        NombreComunidad.setText("Usuario");
        jPanel1.add(NombreComunidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 190, -1, 19));

        jSeparator4.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator4.setForeground(new java.awt.Color(153, 153, 153));
        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 50, 10, 1040));

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
                .addGap(30, 30, 30)
                .addComponent(Btn_Siguiente1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(319, 319, 319))
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
        PanelTxt1.add(UsuarioPub3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 28, -1, -1));

        NombrePub3.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        NombrePub3.setForeground(new java.awt.Color(204, 204, 204));
        NombrePub3.setText("Usuario");
        PanelTxt1.add(NombrePub3, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 24, -1, -1));

        ImgPub3.setForeground(new java.awt.Color(255, 255, 255));
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
        PanelTxt2.add(UsuarioPub4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 24, -1, 20));

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
        PanelTxt3.add(UsuarioPub5, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 24, -1, 20));

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
                .addGap(330, 330, 330)
                .addComponent(Btn_Anterior2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
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

        SaveCambios.setBackground(new java.awt.Color(0, 0, 0));
        SaveCambios.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Save.setBackground(new java.awt.Color(102, 102, 102));
        Save.setForeground(new java.awt.Color(204, 204, 204));
        Save.setText("Guardar");
        Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveActionPerformed(evt);
            }
        });
        SaveCambios.add(Save, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 0, -1, -1));
        SaveCambios.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 31, 750, 10));

        jLabel1.setFont(new java.awt.Font("SansSerif", 2, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("Editar Perfil");
        SaveCambios.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 0, -1, 25));

        Editar1.setContentAreaFilled(false);
        Editar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Editar1ActionPerformed(evt);
            }
        });
        SaveCambios.add(Editar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, -1, 60));

        PerfilPic.setOpaque(true);
        SaveCambios.add(PerfilPic, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 110, 100));
        SaveCambios.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 730, 10));

        BannerAct1.setBackground(new java.awt.Color(59, 28, 50));

        EditarBanner.setFont(new java.awt.Font("SansSerif", 3, 14)); // NOI18N
        EditarBanner.setText("</ Editar Fondo >");
        EditarBanner.setContentAreaFilled(false);
        EditarBanner.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarBannerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout BannerAct1Layout = new javax.swing.GroupLayout(BannerAct1);
        BannerAct1.setLayout(BannerAct1Layout);
        BannerAct1Layout.setHorizontalGroup(
            BannerAct1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BannerAct1Layout.createSequentialGroup()
                .addContainerGap(277, Short.MAX_VALUE)
                .addComponent(EditarBanner)
                .addGap(316, 316, 316))
        );
        BannerAct1Layout.setVerticalGroup(
            BannerAct1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BannerAct1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(EditarBanner)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        SaveCambios.add(BannerAct1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 47, -1, -1));

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Fecha de Cumpleaños");
        SaveCambios.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, -1, -1));

        BioText.setBackground(new java.awt.Color(0, 0, 0));
        BioText.setForeground(new java.awt.Color(204, 204, 204));
        BioText.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        BioText.setBorder(null);
        BioText.setPreferredSize(new java.awt.Dimension(71, 20));
        SaveCambios.add(BioText, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 730, 50));

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Nombre");
        SaveCambios.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, -1, -1));

        NombreText.setBackground(new java.awt.Color(0, 0, 0));
        NombreText.setForeground(new java.awt.Color(204, 204, 204));
        NombreText.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        NombreText.setBorder(null);
        NombreText.setPreferredSize(new java.awt.Dimension(71, 20));
        SaveCambios.add(NombreText, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 730, 30));

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Biografia / Descripcion");
        SaveCambios.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, -1, -1));

        FechaHora.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        FechaHora.setForeground(new java.awt.Color(204, 204, 204));
        FechaHora.setText("00/00/0000");
        SaveCambios.add(FechaHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, -1, -1));

        Editar2.setContentAreaFilled(false);
        Editar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Editar2ActionPerformed(evt);
            }
        });
        SaveCambios.add(Editar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 420, 60, 50));

        FechaPanel.setOpaque(false);

        L_FechaN.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        L_FechaN.setForeground(new java.awt.Color(255, 255, 255));
        L_FechaN.setText("Fecha de nacimiento");

        CB_Dia.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        CB_Dia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dia", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        CB_Dia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CB_DiaActionPerformed(evt);
            }
        });

        CB_Mes.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        CB_Mes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mes", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));

        CB_Anio.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        CB_Anio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Anio", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988", "1987", "1986", "1985", "1984", "1983", "1982", "1981", "1980", "1979", "1978", "1977", "1976", "1975", "1974", "1973", "1972", "1971", "1970", "1969", "1968", "1967", "1966", "1965", "1964", "1963", "1962", "1961", "1960", "1959", "1958", "1957", "1956", "1955", "1954", "1953", "1952", "1951", "1950", "1949", "1948", "1947", "1946", "1945", "1944", "1943", "1942", "1941", "1940", "1939", "1938", "1937", "1936", "1935", "1934", "1933", "1932", "1931", "1930", "1929", "1928", "1927", "1926", "1925" }));
        CB_Anio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CB_AnioActionPerformed(evt);
            }
        });

        Editar3.setFont(new java.awt.Font("SansSerif", 0, 10)); // NOI18N
        Editar3.setForeground(new java.awt.Color(204, 204, 204));
        Editar3.setText("Guardar");
        Editar3.setContentAreaFilled(false);
        Editar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Editar3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout FechaPanelLayout = new javax.swing.GroupLayout(FechaPanel);
        FechaPanel.setLayout(FechaPanelLayout);
        FechaPanelLayout.setHorizontalGroup(
            FechaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FechaPanelLayout.createSequentialGroup()
                .addContainerGap(326, Short.MAX_VALUE)
                .addComponent(Editar3, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(FechaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(FechaPanelLayout.createSequentialGroup()
                    .addGap(7, 7, 7)
                    .addGroup(FechaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(L_FechaN)
                        .addGroup(FechaPanelLayout.createSequentialGroup()
                            .addComponent(CB_Dia, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(CB_Mes, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(CB_Anio, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(8, Short.MAX_VALUE)))
        );
        FechaPanelLayout.setVerticalGroup(
            FechaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FechaPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Editar3)
                .addContainerGap(73, Short.MAX_VALUE))
            .addGroup(FechaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(FechaPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(L_FechaN, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(FechaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(CB_Mes, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(CB_Anio, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(CB_Dia, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap()))
        );

        SaveCambios.add(FechaPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 390, 420, 100));

        SalirMenu.setBackground(new java.awt.Color(102, 102, 102));
        SalirMenu.setForeground(new java.awt.Color(204, 204, 204));
        SalirMenu.setText("Salir");
        SalirMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirMenuActionPerformed(evt);
            }
        });
        SaveCambios.add(SalirMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 0, -1, -1));

        SubMenu.addTab("Editar Perfil", SaveCambios);

        Banner.setBackground(new java.awt.Color(0, 0, 0));

        BannerAct.setBackground(new java.awt.Color(59, 28, 50));

        javax.swing.GroupLayout BannerActLayout = new javax.swing.GroupLayout(BannerAct);
        BannerAct.setLayout(BannerActLayout);
        BannerActLayout.setHorizontalGroup(
            BannerActLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        BannerActLayout.setVerticalGroup(
            BannerActLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 182, Short.MAX_VALUE)
        );

        SalvarBanner.setText("Guardar");
        SalvarBanner.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalvarBannerActionPerformed(evt);
            }
        });

        DefaultBanner.setForeground(new java.awt.Color(204, 204, 204));
        DefaultBanner.setText("Default");
        DefaultBanner.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DefaultBannerActionPerformed(evt);
            }
        });

        RojoBanner.setForeground(new java.awt.Color(204, 204, 204));
        RojoBanner.setText("Rojo");
        RojoBanner.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RojoBannerActionPerformed(evt);
            }
        });

        VerdeBanner.setForeground(new java.awt.Color(204, 204, 204));
        VerdeBanner.setText("Verde");
        VerdeBanner.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VerdeBannerActionPerformed(evt);
            }
        });

        RosaBanner.setForeground(new java.awt.Color(204, 204, 204));
        RosaBanner.setText("Rosa");
        RosaBanner.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RosaBannerActionPerformed(evt);
            }
        });

        AmarilloBanner.setForeground(new java.awt.Color(204, 204, 204));
        AmarilloBanner.setText("Amarillo");
        AmarilloBanner.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AmarilloBannerActionPerformed(evt);
            }
        });

        NaranjaBanner.setForeground(new java.awt.Color(204, 204, 204));
        NaranjaBanner.setText("Naranja");
        NaranjaBanner.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NaranjaBannerActionPerformed(evt);
            }
        });

        MoradoBanner.setForeground(new java.awt.Color(204, 204, 204));
        MoradoBanner.setText("Morado");
        MoradoBanner.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MoradoBannerActionPerformed(evt);
            }
        });

        AzulBanner.setForeground(new java.awt.Color(204, 204, 204));
        AzulBanner.setText("Azul");
        AzulBanner.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AzulBannerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout BannerLayout = new javax.swing.GroupLayout(Banner);
        Banner.setLayout(BannerLayout);
        BannerLayout.setHorizontalGroup(
            BannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BannerLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(SalvarBanner)
                .addGap(16, 16, 16))
            .addGroup(BannerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(BannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BannerAct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(BannerLayout.createSequentialGroup()
                        .addComponent(DefaultBanner)
                        .addGap(18, 18, 18)
                        .addComponent(VerdeBanner)
                        .addGap(18, 18, 18)
                        .addComponent(RojoBanner)
                        .addGap(18, 18, 18)
                        .addComponent(RosaBanner)
                        .addGap(18, 18, 18)
                        .addComponent(AmarilloBanner)
                        .addGap(18, 18, 18)
                        .addComponent(NaranjaBanner)
                        .addGap(18, 18, 18)
                        .addComponent(MoradoBanner)
                        .addGap(18, 18, 18)
                        .addComponent(AzulBanner)
                        .addGap(0, 160, Short.MAX_VALUE)))
                .addContainerGap())
        );
        BannerLayout.setVerticalGroup(
            BannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BannerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BannerAct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(BannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DefaultBanner)
                    .addComponent(VerdeBanner)
                    .addComponent(RojoBanner)
                    .addComponent(RosaBanner)
                    .addComponent(AmarilloBanner)
                    .addComponent(NaranjaBanner)
                    .addComponent(MoradoBanner)
                    .addComponent(AzulBanner))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 264, Short.MAX_VALUE)
                .addComponent(SalvarBanner)
                .addGap(17, 17, 17))
        );

        SubMenu.addTab("Banner", Banner);

        EditarFoto.setBackground(new java.awt.Color(0, 0, 0));
        EditarFoto.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelFlotante2.setBackground(new java.awt.Color(26, 26, 29));
        PanelFlotante2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jFileChooser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFileChooserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout J_ArchivosLayout = new javax.swing.GroupLayout(J_Archivos);
        J_Archivos.setLayout(J_ArchivosLayout);
        J_ArchivosLayout.setHorizontalGroup(
            J_ArchivosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(J_ArchivosLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jFileChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 462, Short.MAX_VALUE)
                .addGap(55, 55, 55))
        );
        J_ArchivosLayout.setVerticalGroup(
            J_ArchivosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(J_ArchivosLayout.createSequentialGroup()
                .addComponent(jFileChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        PanelFlotante2.add(J_Archivos, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 32, -1, -1));

        L_Nombre2.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        L_Nombre2.setForeground(new java.awt.Color(255, 255, 255));
        L_Nombre2.setText("Foto de perfil:");
        PanelFlotante2.add(L_Nombre2, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 6, -1, 20));

        Siguiente2.setBackground(new java.awt.Color(166, 77, 121));
        Siguiente2.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        Siguiente2.setForeground(new java.awt.Color(255, 255, 255));
        Siguiente2.setText("Aceptar");
        Siguiente2.setActionCommand("Siguiente");
        Siguiente2.setPreferredSize(new java.awt.Dimension(90, 25));
        Siguiente2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Siguiente2ActionPerformed(evt);
            }
        });
        PanelFlotante2.add(Siguiente2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 370, 330, 45));

        B_ElegirOtra.setBackground(new java.awt.Color(26, 26, 29));
        B_ElegirOtra.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        B_ElegirOtra.setForeground(new java.awt.Color(255, 255, 255));
        B_ElegirOtra.setText("Elegir otra foto");
        B_ElegirOtra.setActionCommand("Siguiente");
        B_ElegirOtra.setPreferredSize(new java.awt.Dimension(90, 25));
        B_ElegirOtra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_ElegirOtraActionPerformed(evt);
            }
        });
        PanelFlotante2.add(B_ElegirOtra, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 340, 147, -1));

        L_Aviso11.setBackground(new java.awt.Color(26, 26, 29));
        L_Aviso11.setForeground(new java.awt.Color(255, 51, 51));
        PanelFlotante2.add(L_Aviso11, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 387, 521, 27));

        EditarFoto.add(PanelFlotante2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, 545, 430));

        J_C_Foto.setBackground(new java.awt.Color(51, 51, 51));

        L_Foto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        L_Foto.setText("[Foto Seleccionada]");

        javax.swing.GroupLayout J_C_FotoLayout = new javax.swing.GroupLayout(J_C_Foto);
        J_C_Foto.setLayout(J_C_FotoLayout);
        J_C_FotoLayout.setHorizontalGroup(
            J_C_FotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(J_C_FotoLayout.createSequentialGroup()
                .addGap(207, 207, 207)
                .addComponent(L_Foto, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(228, Short.MAX_VALUE))
        );
        J_C_FotoLayout.setVerticalGroup(
            J_C_FotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(J_C_FotoLayout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(L_Foto, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(87, Short.MAX_VALUE))
        );

        EditarFoto.add(J_C_Foto, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -8, 750, 460));

        SubMenu.addTab("FotoPerfil", EditarFoto);

        Seguidores.setBackground(new java.awt.Color(0, 0, 0));

        Si5.setBackground(new java.awt.Color(51, 51, 51));
        Si5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ImgPub10.setBackground(new java.awt.Color(204, 98, 202));
        Si5.add(ImgPub10, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 100, 100));

        NombrePub10.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        NombrePub10.setForeground(new java.awt.Color(204, 204, 204));
        NombrePub10.setText("Usuario");
        Si5.add(NombrePub10, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, -1, 30));

        UsuarioPub10.setFont(new java.awt.Font("SansSerif", 0, 10)); // NOI18N
        UsuarioPub10.setForeground(new java.awt.Color(204, 204, 204));
        UsuarioPub10.setText("@Usuario");
        UsuarioPub10.setToolTipText("");
        UsuarioPub10.setBorder(null);
        UsuarioPub10.setBorderPainted(false);
        UsuarioPub10.setContentAreaFilled(false);
        UsuarioPub10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        UsuarioPub10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        UsuarioPub10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsuarioPub10ActionPerformed(evt);
            }
        });
        Si5.add(UsuarioPub10, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 50, -1, -1));

        NumSe5.setText("0");
        Si5.add(NumSe5, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 80, 80, -1));

        NumSi5.setText("0");
        Si5.add(NumSi5, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 80, 90, -1));

        SeS5.setForeground(new java.awt.Color(255, 255, 255));
        SeS5.setText("Seguidores : ");
        Si5.add(SeS5, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 80, 70, -1));

        SiS5.setForeground(new java.awt.Color(255, 255, 255));
        SiS5.setText("Siguiendo :");
        Si5.add(SiS5, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 80, 70, -1));

        Si6.setBackground(new java.awt.Color(51, 51, 51));
        Si6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ImgPub11.setBackground(new java.awt.Color(204, 98, 202));
        Si6.add(ImgPub11, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 100, 100));

        UsuarioPub11.setFont(new java.awt.Font("SansSerif", 0, 10)); // NOI18N
        UsuarioPub11.setForeground(new java.awt.Color(204, 204, 204));
        UsuarioPub11.setText("@Usuario");
        UsuarioPub11.setToolTipText("");
        UsuarioPub11.setBorder(null);
        UsuarioPub11.setBorderPainted(false);
        UsuarioPub11.setContentAreaFilled(false);
        UsuarioPub11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        UsuarioPub11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        UsuarioPub11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsuarioPub11ActionPerformed(evt);
            }
        });
        Si6.add(UsuarioPub11, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 50, -1, -1));

        NombrePub11.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        NombrePub11.setForeground(new java.awt.Color(204, 204, 204));
        NombrePub11.setText("Usuario");
        Si6.add(NombrePub11, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, -1, 30));

        NumSe6.setText("0");
        Si6.add(NumSe6, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 80, 80, -1));

        NumSi6.setText("0");
        Si6.add(NumSi6, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 80, 90, -1));

        SeS6.setForeground(new java.awt.Color(255, 255, 255));
        SeS6.setText("Seguidores : ");
        Si6.add(SeS6, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 80, 70, -1));

        SiS6.setForeground(new java.awt.Color(255, 255, 255));
        SiS6.setText("Siguiendo :");
        Si6.add(SiS6, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 80, 70, -1));

        Si7.setBackground(new java.awt.Color(51, 51, 51));
        Si7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ImgPub12.setBackground(new java.awt.Color(204, 98, 202));
        Si7.add(ImgPub12, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 100, 101));

        NombrePub12.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        NombrePub12.setForeground(new java.awt.Color(204, 204, 204));
        NombrePub12.setText("Usuario");
        Si7.add(NombrePub12, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, -1, 30));

        UsuarioPub12.setFont(new java.awt.Font("SansSerif", 0, 10)); // NOI18N
        UsuarioPub12.setForeground(new java.awt.Color(204, 204, 204));
        UsuarioPub12.setText("@Usuario");
        UsuarioPub12.setToolTipText("");
        UsuarioPub12.setBorder(null);
        UsuarioPub12.setBorderPainted(false);
        UsuarioPub12.setContentAreaFilled(false);
        UsuarioPub12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        UsuarioPub12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        UsuarioPub12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsuarioPub12ActionPerformed(evt);
            }
        });
        Si7.add(UsuarioPub12, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 50, -1, -1));

        SiS7.setForeground(new java.awt.Color(255, 255, 255));
        SiS7.setText("Siguiendo :");
        Si7.add(SiS7, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 80, 70, -1));

        SeS7.setForeground(new java.awt.Color(255, 255, 255));
        SeS7.setText("Seguidores : ");
        Si7.add(SeS7, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 80, 70, -1));

        NumSe7.setText("0");
        Si7.add(NumSe7, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 80, 80, -1));

        NumSi7.setText("0");
        Si7.add(NumSi7, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 80, 90, -1));

        Si8.setBackground(new java.awt.Color(51, 51, 51));
        Si8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ImgPub13.setBackground(new java.awt.Color(204, 98, 202));
        Si8.add(ImgPub13, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 100, 100));

        NombrePub13.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        NombrePub13.setForeground(new java.awt.Color(204, 204, 204));
        NombrePub13.setText("Usuario");
        Si8.add(NombrePub13, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, -1, 30));

        UsuarioPub13.setFont(new java.awt.Font("SansSerif", 0, 10)); // NOI18N
        UsuarioPub13.setForeground(new java.awt.Color(204, 204, 204));
        UsuarioPub13.setText("@Usuario");
        UsuarioPub13.setToolTipText("");
        UsuarioPub13.setBorder(null);
        UsuarioPub13.setBorderPainted(false);
        UsuarioPub13.setContentAreaFilled(false);
        UsuarioPub13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        UsuarioPub13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        UsuarioPub13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsuarioPub13ActionPerformed(evt);
            }
        });
        Si8.add(UsuarioPub13, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 50, -1, -1));

        SeS8.setForeground(new java.awt.Color(255, 255, 255));
        SeS8.setText("Seguidores : ");
        Si8.add(SeS8, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 80, 70, -1));

        SiS8.setForeground(new java.awt.Color(255, 255, 255));
        SiS8.setText("Siguiendo :");
        Si8.add(SiS8, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 80, 70, -1));

        NumSi8.setText("0");
        Si8.add(NumSi8, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 80, 90, -1));

        NumSe8.setText("0");
        Si8.add(NumSe8, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 80, 80, -1));

        Btn_Anterior4.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        Btn_Anterior4.setForeground(new java.awt.Color(255, 255, 255));
        Btn_Anterior4.setText("<");
        Btn_Anterior4.setBorderPainted(false);
        Btn_Anterior4.setContentAreaFilled(false);
        Btn_Anterior4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Anterior4ActionPerformed(evt);
            }
        });

        Btn_Siguiente4.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        Btn_Siguiente4.setForeground(new java.awt.Color(255, 255, 255));
        Btn_Siguiente4.setText(">");
        Btn_Siguiente4.setBorderPainted(false);
        Btn_Siguiente4.setContentAreaFilled(false);
        Btn_Siguiente4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Siguiente4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout SeguidoresLayout = new javax.swing.GroupLayout(Seguidores);
        Seguidores.setLayout(SeguidoresLayout);
        SeguidoresLayout.setHorizontalGroup(
            SeguidoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SeguidoresLayout.createSequentialGroup()
                .addGroup(SeguidoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SeguidoresLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(SeguidoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Si6, javax.swing.GroupLayout.PREFERRED_SIZE, 704, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(SeguidoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(Si5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Si7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Si8, javax.swing.GroupLayout.PREFERRED_SIZE, 704, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(SeguidoresLayout.createSequentialGroup()
                        .addGap(326, 326, 326)
                        .addComponent(Btn_Anterior4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Btn_Siguiente4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        SeguidoresLayout.setVerticalGroup(
            SeguidoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SeguidoresLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(SeguidoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Btn_Anterior4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Btn_Siguiente4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Si7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Si5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Si6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Si8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        SubMenu.addTab("tab3", Seguidores);

        jPanel1.add(SubMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 350, 750, 560));

        EditarBtn.setBackground(new java.awt.Color(0, 0, 0));
        EditarBtn.setForeground(new java.awt.Color(255, 255, 255));
        EditarBtn.setText("Editar perfil");
        EditarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarBtnActionPerformed(evt);
            }
        });
        jPanel1.add(EditarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 200, -1, -1));

        DescLabel.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        DescLabel.setForeground(new java.awt.Color(204, 204, 204));
        DescLabel.setText("Descripcion");
        jPanel1.add(DescLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 240, 450, 60));

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

        jPanel1.add(MenuDeNavegacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 300, 750, 40));

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

        jPanel1.add(PerfilPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 750, 320, 80));

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
        jPanel1.add(ConfiBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 430, 260, 40));

        InicioBtn1.setBackground(new java.awt.Color(26, 26, 29));
        InicioBtn1.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        InicioBtn1.setForeground(new java.awt.Color(204, 204, 204));
        InicioBtn1.setText("  Inicio");
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
        jPanel1.add(InicioBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 250, 40));

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
        jPanel1.add(NotificacionesBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 310, 250, 40));

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
        jPanel1.add(PerfilBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 370, 250, 40));

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
        jPanel1.add(ExplorarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, 250, 40));
        jPanel1.add(Y_logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 90, 80));

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

        jPanel1.add(Header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1550, 50));

        QuePasa.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        QuePasa.setForeground(new java.awt.Color(204, 204, 204));
        QuePasa.setText("Qué pasa");
        jPanel1.add(QuePasa, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 450, 90, 30));

        SeguirCuentaBtn3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        SeguirCuentaBtn3.setText("Seguir");
        SeguirCuentaBtn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SeguirCuentaBtn3ActionPerformed(evt);
            }
        });
        jPanel1.add(SeguirCuentaBtn3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1400, 310, -1, 30));

        SeguirCuentaBtn1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        SeguirCuentaBtn1.setText("Seguir");
        SeguirCuentaBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SeguirCuentaBtn1ActionPerformed(evt);
            }
        });
        jPanel1.add(SeguirCuentaBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1400, 190, -1, 30));

        SeguirCuentaBtn2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        SeguirCuentaBtn2.setText("Seguir");
        SeguirCuentaBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SeguirCuentaBtn2ActionPerformed(evt);
            }
        });
        jPanel1.add(SeguirCuentaBtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1400, 250, -1, 30));

        jSeparator6.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator6.setForeground(new java.awt.Color(153, 153, 153));
        jSeparator6.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 120, 30, 250));

        jSeparator7.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator7.setForeground(new java.awt.Color(153, 153, 153));
        jSeparator7.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 420, 10, 340));
        jPanel1.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 420, 330, 20));

        jLabel40.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(204, 204, 204));
        jLabel40.setText("Te puede interesar");
        jPanel1.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 120, 210, 30));

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
        jPanel1.add(CuentaBtn20, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 430, 80, 20));

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
        jPanel1.add(TendenciaYapBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 490, 310, 60));

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
        jPanel1.add(numreacciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 550, 70, 30));

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
        jPanel1.add(MostrarMasInteresBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1430, 350, 60, 20));

        ImgInt3.setForeground(new java.awt.Color(255, 255, 255));
        ImgInt3.setText("ImgInteres2");
        jPanel1.add(ImgInt3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 300, 60, 60));

        ImgInt1.setForeground(new java.awt.Color(255, 255, 255));
        ImgInt1.setText("ImgInteres1");
        jPanel1.add(ImgInt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 160, 60, 60));

        ImgInt2.setForeground(new java.awt.Color(255, 255, 255));
        ImgInt2.setText("ImgInteres2");
        jPanel1.add(ImgInt2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 230, 60, 60));

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
        jPanel1.add(UserInt3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 310, -1, 30));

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
        jPanel1.add(UserInt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 190, -1, 30));

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
        jPanel1.add(UserInt2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 250, -1, 30));
        jPanel1.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 120, 280, 10));

        LabelAviso2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LabelAviso2.setForeground(new java.awt.Color(166, 77, 121));
        jPanel1.add(LabelAviso2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 370, 250, 40));

        Num_Reacciones.setForeground(new java.awt.Color(204, 204, 204));
        Num_Reacciones.setText("10");
        jPanel1.add(Num_Reacciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 550, 30, 30));

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
        jPanel1.add(TendenciaYapBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 580, 310, 60));

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
        jPanel1.add(numreacciones1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 640, 70, 30));

        Num_Reacciones1.setForeground(new java.awt.Color(204, 204, 204));
        Num_Reacciones1.setText("10");
        jPanel1.add(Num_Reacciones1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 640, 30, 30));

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
        jPanel1.add(TendenciaYapBtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 670, 310, 60));

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
        jPanel1.add(numreacciones2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 730, 70, 30));

        Num_Reacciones2.setForeground(new java.awt.Color(204, 204, 204));
        Num_Reacciones2.setText("10");
        jPanel1.add(Num_Reacciones2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 730, 30, 30));
        jPanel1.add(jSeparator12, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 370, 280, 20));

        jSeparator13.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator13.setForeground(new java.awt.Color(153, 153, 153));
        jSeparator13.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator13, new org.netbeans.lib.awtextra.AbsoluteConstraints(1490, 120, 20, 250));
        jPanel1.add(jSeparator14, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 760, 330, 20));

        jSeparator15.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator15.setForeground(new java.awt.Color(153, 153, 153));
        jSeparator15.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator15, new org.netbeans.lib.awtextra.AbsoluteConstraints(1530, 420, 10, 340));

        Num_Siguiendo.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        Num_Siguiendo.setForeground(new java.awt.Color(204, 204, 204));
        Num_Siguiendo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Num_Siguiendo.setText("0");
        Num_Siguiendo.setToolTipText("");
        jPanel1.add(Num_Siguiendo, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 260, 40, 30));

        BtnSiguiendo.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        BtnSiguiendo.setForeground(new java.awt.Color(204, 204, 204));
        BtnSiguiendo.setText("Siguiendo");
        BtnSiguiendo.setBorder(null);
        BtnSiguiendo.setBorderPainted(false);
        BtnSiguiendo.setContentAreaFilled(false);
        BtnSiguiendo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnSiguiendo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BtnSiguiendo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSiguiendoActionPerformed(evt);
            }
        });
        jPanel1.add(BtnSiguiendo, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 250, 80, 50));

        Num_Seguidores.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        Num_Seguidores.setForeground(new java.awt.Color(204, 204, 204));
        Num_Seguidores.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Num_Seguidores.setText("0");
        Num_Seguidores.setToolTipText("");
        jPanel1.add(Num_Seguidores, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 260, 40, 30));

        BtnSeguidores.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        BtnSeguidores.setForeground(new java.awt.Color(204, 204, 204));
        BtnSeguidores.setText("Seguidores");
        BtnSeguidores.setBorder(null);
        BtnSeguidores.setBorderPainted(false);
        BtnSeguidores.setContentAreaFilled(false);
        BtnSeguidores.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnSeguidores.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BtnSeguidores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSeguidoresActionPerformed(evt);
            }
        });
        jPanel1.add(BtnSeguidores, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 250, 80, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1550, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 890, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CuentaBtn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CuentaBtn3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CuentaBtn3ActionPerformed

    private void UsuarioComunidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsuarioComunidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UsuarioComunidadActionPerformed

    private void B_ElegirOtraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_ElegirOtraActionPerformed
        J_Archivos.setVisible(true);
        J_C_Foto.setVisible(false);
        jFileChooser.setSelectedFile(null); // Limpiar selección previa
        L_Foto.setIcon(null);
    }//GEN-LAST:event_B_ElegirOtraActionPerformed

    private void Siguiente2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Siguiente2ActionPerformed

    }//GEN-LAST:event_Siguiente2ActionPerformed

    private void jFileChooserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFileChooserActionPerformed
        try {
            UpdateFotoPerfil();
        
        if (evt.getActionCommand().equals(jFileChooser.APPROVE_SELECTION)) {
            archivoImagenSeleccionado = jFileChooser.getSelectedFile(); // ← guardarlo aquí

            if (archivoImagenSeleccionado != null) {
                ImageIcon imagen = new ImageIcon(archivoImagenSeleccionado.getAbsolutePath());
                Image imgEscalada = imagen.getImage().getScaledInstance(L_Foto.getWidth(), L_Foto.getHeight(), Image.SCALE_SMOOTH);
                L_Foto.setIcon(new ImageIcon(imgEscalada));

                J_Archivos.setVisible(false);
                J_C_Foto.setVisible(true);
            }
        }
        } catch (SQLException ex) {
            Logger.getLogger(Perfil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jFileChooserActionPerformed

    private void AzulBannerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AzulBannerActionPerformed
        BannerAct.setBackground(Color.blue);
    }//GEN-LAST:event_AzulBannerActionPerformed

    private void MoradoBannerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MoradoBannerActionPerformed
        BannerAct.setBackground(Color.MAGENTA);
    }//GEN-LAST:event_MoradoBannerActionPerformed

    private void NaranjaBannerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NaranjaBannerActionPerformed
        BannerAct.setBackground(Color.orange);
    }//GEN-LAST:event_NaranjaBannerActionPerformed

    private void AmarilloBannerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AmarilloBannerActionPerformed
        BannerAct.setBackground(Color.yellow);
    }//GEN-LAST:event_AmarilloBannerActionPerformed

    private void RosaBannerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RosaBannerActionPerformed
        BannerAct.setBackground(Color.pink);
    }//GEN-LAST:event_RosaBannerActionPerformed

    private void VerdeBannerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VerdeBannerActionPerformed
        BannerAct.setBackground(Color.green);
    }//GEN-LAST:event_VerdeBannerActionPerformed

    private void RojoBannerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RojoBannerActionPerformed
        BannerAct.setBackground(Color.red);
    }//GEN-LAST:event_RojoBannerActionPerformed

    private void DefaultBannerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DefaultBannerActionPerformed

        BannerAct.setBackground(new Color(59,28,50));
    }//GEN-LAST:event_DefaultBannerActionPerformed

    private void SalvarBannerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalvarBannerActionPerformed

        GuardarCambiosBanner();
        SubMenu.setSelectedIndex(2);
    }//GEN-LAST:event_SalvarBannerActionPerformed

    private void EditarBannerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarBannerActionPerformed
        SubMenu.setSelectedIndex(3);
    }//GEN-LAST:event_EditarBannerActionPerformed

    private void SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveActionPerformed
        GuardarCambios();
    }//GEN-LAST:event_SaveActionPerformed

    private void Editar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Editar1ActionPerformed
        SubMenu.setSelectedIndex(4);
    }//GEN-LAST:event_Editar1ActionPerformed

    private void CB_AnioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CB_AnioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CB_AnioActionPerformed

    private void CB_DiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CB_DiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CB_DiaActionPerformed

    private void Editar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Editar2ActionPerformed
        FechaPanel.setVisible(true);
    }//GEN-LAST:event_Editar2ActionPerformed

    private void Editar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Editar3ActionPerformed
        String dia = CB_Anio.getSelectedItem().toString() ;
        String mes= CB_Mes.getSelectedItem().toString();
        String anio =CB_Dia.getSelectedItem().toString();
        if (dia != "Dia" || mes != "Mes" || anio != "Anio"){UpdateFecha();}
        
    }//GEN-LAST:event_Editar3ActionPerformed

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

    private void EditarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarBtnActionPerformed
        String selec = SubMenu.getSelectedComponent().toString();     
        if(selec != "SaveCambios"){
            EditarBtn.setVisible(false);
            SubMenu.setSelectedIndex(2);
        }
        
    }//GEN-LAST:event_EditarBtnActionPerformed

    private void SalirMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirMenuActionPerformed
       String selec = SubMenu.getSelectedComponent().toString();     
        if(selec == "SaveCambios"){
            EditarBtn.setVisible(true);
            SubMenu.setSelectedIndex(0);
        }
    }//GEN-LAST:event_SalirMenuActionPerformed

    private void NombreUsuarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NombreUsuarioMousePressed
        this.dispose();
        new Perfil().setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_NombreUsuarioMousePressed

    private void Perfil_Img1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Perfil_Img1MousePressed
        this.dispose();
        new Perfil().setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_Perfil_Img1MousePressed

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

    private void ExplorarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExplorarBtnActionPerformed
        this.dispose();
        new Explorar().setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_ExplorarBtnActionPerformed

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
            notificarSeguido(idSeguido);
                SeguirCuentaBtn3.setForeground(Color.BLACK); // Cambia el color de la letra (blanco)
                SeguirCuentaBtn3.setBackground(new java.awt.Color(255,255,255)); 
        SeguirCuentaBtn3.setText("Siguiendo");
                SeguirCuentaBtn3.setEnabled(false);
            } else {
                LabelAviso2.setText("Ya lo estás siguiendo");
            }

            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
                notificarSeguido(idSeguido);
                // Cambiar texto y colores del botón
                SeguirCuentaBtn2.setText("Siguiendo");
                SeguirCuentaBtn2.setForeground(new java.awt.Color(0,0,0)); // Cambia el color de la letra (blanco)
                SeguirCuentaBtn2.setBackground(new java.awt.Color(255,255,255)); 
                
                SeguirCuentaBtn2.setEnabled(false); 
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

    private void UsuarioPub1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsuarioPub1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UsuarioPub1ActionPerformed

    private void meGustaBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meGustaBtn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_meGustaBtn1ActionPerformed

    private void repostearBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_repostearBtn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_repostearBtn1ActionPerformed

    private void UsuarioPub2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsuarioPub2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UsuarioPub2ActionPerformed

    private void meGustaBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meGustaBtn2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_meGustaBtn2ActionPerformed

    private void repostearBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_repostearBtn2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_repostearBtn2ActionPerformed

    private void Btn_Siguiente1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Siguiente1ActionPerformed

    }//GEN-LAST:event_Btn_Siguiente1ActionPerformed

    private void Btn_Anterior1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Anterior1ActionPerformed

    }//GEN-LAST:event_Btn_Anterior1ActionPerformed

    private void UsuarioPub3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsuarioPub3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UsuarioPub3ActionPerformed

    private void meGustaBtn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meGustaBtn3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_meGustaBtn3ActionPerformed

    private void repostearBtn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_repostearBtn3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_repostearBtn3ActionPerformed

    private void meGustaBtn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meGustaBtn4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_meGustaBtn4ActionPerformed

    private void comentarBtn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comentarBtn4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comentarBtn4ActionPerformed

    private void repostearBtn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_repostearBtn4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_repostearBtn4ActionPerformed

    private void UsuarioPub4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsuarioPub4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UsuarioPub4ActionPerformed

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

    private void UsuarioPub10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsuarioPub10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UsuarioPub10ActionPerformed

    private void UsuarioPub11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsuarioPub11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UsuarioPub11ActionPerformed

    private void UsuarioPub12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsuarioPub12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UsuarioPub12ActionPerformed

    private void UsuarioPub13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsuarioPub13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UsuarioPub13ActionPerformed

    private void Btn_Anterior4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Anterior4ActionPerformed
        if (paginaActual > 1) {
            paginaActual--;
            cargarDatos();
        }
    }//GEN-LAST:event_Btn_Anterior4ActionPerformed

    private void Btn_Siguiente4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Siguiente4ActionPerformed
        paginaActual++;
        cargarDatos();
    }//GEN-LAST:event_Btn_Siguiente4ActionPerformed

    private void BtnSiguiendoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSiguiendoActionPerformed
        SubMenu.setSelectedIndex(5);
        tipo = "seguidos";
        paginaActual = 1; // Reiniciar a la primera página
        cargarDatos();
    }//GEN-LAST:event_BtnSiguiendoActionPerformed

    private void BtnSeguidoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSeguidoresActionPerformed
        SubMenu.setSelectedIndex(5);
        tipo = "seguidores";
        paginaActual = 1; // Reiniciar a la primera página
        cargarDatos();
    }//GEN-LAST:event_BtnSeguidoresActionPerformed

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
            java.util.logging.Logger.getLogger(Perfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Perfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Perfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Perfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Perfil().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton AmarilloBanner;
    private javax.swing.JSeparator AyudaSeleccion1;
    private javax.swing.JSeparator AyudaSeleccion2;
    private javax.swing.JRadioButton AzulBanner;
    private javax.swing.JButton B_ElegirOtra;
    private javax.swing.JPanel Banner;
    private javax.swing.JPanel BannerAct;
    private javax.swing.JPanel BannerAct1;
    private javax.swing.JTextField BioText;
    private javax.swing.JButton BtnSeguidores;
    private javax.swing.JButton BtnSiguiendo;
    private javax.swing.JButton Btn_Anterior1;
    private javax.swing.JButton Btn_Anterior2;
    private javax.swing.JButton Btn_Anterior4;
    private javax.swing.JButton Btn_Siguiente1;
    private javax.swing.JButton Btn_Siguiente2;
    private javax.swing.JButton Btn_Siguiente4;
    private javax.swing.JComboBox<String> CB_Anio;
    private javax.swing.JComboBox<String> CB_Dia;
    private javax.swing.JComboBox<String> CB_Mes;
    private javax.swing.ButtonGroup Colores;
    private javax.swing.JButton ConfiBtn;
    private javax.swing.JButton CuentaBtn20;
    private javax.swing.JButton CuentaBtn3;
    private javax.swing.JRadioButton DefaultBanner;
    private javax.swing.JLabel DescLabel;
    private javax.swing.JLabel DescripcionPub1;
    private javax.swing.JLabel DescripcionPub2;
    private javax.swing.JLabel DescripcionPub3;
    private javax.swing.JLabel DescripcionPub4;
    private javax.swing.JLabel DescripcionPub5;
    private javax.swing.JButton Editar1;
    private javax.swing.JButton Editar2;
    private javax.swing.JButton Editar3;
    private javax.swing.JButton EditarBanner;
    private javax.swing.JButton EditarBtn;
    private javax.swing.JPanel EditarFoto;
    private javax.swing.JLabel ExitBtn;
    private javax.swing.JPanel ExitPane;
    private javax.swing.JButton ExplorarBtn;
    private javax.swing.JLabel FechaHora;
    private javax.swing.JPanel FechaPanel;
    private javax.swing.JLabel Fecha_Label1;
    private javax.swing.JLabel Fecha_Label2;
    private javax.swing.JLabel Fecha_Label3;
    private javax.swing.JLabel Fecha_Label4;
    private javax.swing.JLabel Fecha_Label5;
    private javax.swing.JLabel FotoPerfil;
    private javax.swing.JPanel Header;
    private javax.swing.JLabel IdUsuario2;
    private javax.swing.JLabel ImgInt1;
    private javax.swing.JLabel ImgInt2;
    private javax.swing.JLabel ImgInt3;
    private javax.swing.JLabel ImgPub1;
    private javax.swing.JLabel ImgPub10;
    private javax.swing.JLabel ImgPub11;
    private javax.swing.JLabel ImgPub12;
    private javax.swing.JLabel ImgPub13;
    private javax.swing.JLabel ImgPub2;
    private javax.swing.JLabel ImgPub3;
    private javax.swing.JLabel ImgPub4;
    private javax.swing.JLabel ImgPub5;
    private javax.swing.JButton InicioBtn1;
    private javax.swing.JPanel J_Archivos;
    private javax.swing.JPanel J_C_Foto;
    private javax.swing.JLabel L_Aviso11;
    private javax.swing.JLabel L_FechaN;
    private javax.swing.JLabel L_Foto;
    private javax.swing.JLabel L_Nombre2;
    private javax.swing.JLabel LabelAviso2;
    private javax.swing.JPanel MenuDeNavegacion;
    private javax.swing.JRadioButton MoradoBanner;
    private javax.swing.JButton MostrarMasInteresBtn;
    private javax.swing.JRadioButton NaranjaBanner;
    private javax.swing.JLabel NombreComunidad;
    private javax.swing.JLabel NombrePub1;
    private javax.swing.JLabel NombrePub10;
    private javax.swing.JLabel NombrePub11;
    private javax.swing.JLabel NombrePub12;
    private javax.swing.JLabel NombrePub13;
    private javax.swing.JLabel NombrePub2;
    private javax.swing.JLabel NombrePub3;
    private javax.swing.JLabel NombrePub4;
    private javax.swing.JLabel NombrePub5;
    private javax.swing.JTextField NombreText;
    private javax.swing.JLabel NombreUsuario;
    private javax.swing.JButton NotificacionesBtn;
    private javax.swing.JLabel NumSe5;
    private javax.swing.JLabel NumSe6;
    private javax.swing.JLabel NumSe7;
    private javax.swing.JLabel NumSe8;
    private javax.swing.JLabel NumSi5;
    private javax.swing.JLabel NumSi6;
    private javax.swing.JLabel NumSi7;
    private javax.swing.JLabel NumSi8;
    private javax.swing.JLabel Num_Reacciones;
    private javax.swing.JLabel Num_Reacciones1;
    private javax.swing.JLabel Num_Reacciones2;
    private javax.swing.JLabel Num_Seguidores;
    private javax.swing.JLabel Num_Siguiendo;
    private javax.swing.JPanel PanelFlotante2;
    private javax.swing.JPanel PanelNot1;
    private javax.swing.JPanel PanelNot2;
    private javax.swing.JPanel PanelTxt1;
    private javax.swing.JPanel PanelTxt2;
    private javax.swing.JPanel PanelTxt3;
    private javax.swing.JButton PerfilBtn;
    private javax.swing.JPanel PerfilPanel;
    private javax.swing.JLabel PerfilPic;
    private javax.swing.JLabel Perfil_Img1;
    private javax.swing.JPanel PortadaPanel;
    private javax.swing.JPanel PublicacionesImagenes;
    private javax.swing.JPanel PublicacionesTexto;
    private javax.swing.JLabel QuePasa;
    private javax.swing.JRadioButton RojoBanner;
    private javax.swing.JRadioButton RosaBanner;
    private javax.swing.JButton SalirMenu;
    private javax.swing.JButton SalvarBanner;
    private javax.swing.JButton Save;
    private javax.swing.JPanel SaveCambios;
    private javax.swing.JLabel SeS5;
    private javax.swing.JLabel SeS6;
    private javax.swing.JLabel SeS7;
    private javax.swing.JLabel SeS8;
    private javax.swing.JPanel Seguidores;
    private javax.swing.JButton SeguirCuentaBtn1;
    private javax.swing.JButton SeguirCuentaBtn2;
    private javax.swing.JButton SeguirCuentaBtn3;
    private javax.swing.JPanel Si5;
    private javax.swing.JPanel Si6;
    private javax.swing.JPanel Si7;
    private javax.swing.JPanel Si8;
    private javax.swing.JLabel SiS5;
    private javax.swing.JLabel SiS6;
    private javax.swing.JLabel SiS7;
    private javax.swing.JLabel SiS8;
    private javax.swing.JButton Siguiente2;
    private javax.swing.JTabbedPane SubMenu;
    private javax.swing.JButton TendenciaYapBtn;
    private javax.swing.JButton TendenciaYapBtn1;
    private javax.swing.JButton TendenciaYapBtn2;
    private javax.swing.JButton UserInt1;
    private javax.swing.JButton UserInt2;
    private javax.swing.JButton UserInt3;
    private javax.swing.JButton UsuarioComunidad;
    private javax.swing.JButton UsuarioPub1;
    private javax.swing.JButton UsuarioPub10;
    private javax.swing.JButton UsuarioPub11;
    private javax.swing.JButton UsuarioPub12;
    private javax.swing.JButton UsuarioPub13;
    private javax.swing.JButton UsuarioPub2;
    private javax.swing.JButton UsuarioPub3;
    private javax.swing.JButton UsuarioPub4;
    private javax.swing.JButton UsuarioPub5;
    private javax.swing.JRadioButton VerdeBanner;
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
    private javax.swing.JFileChooser jFileChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator15;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
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
    private javax.swing.JButton numreacciones;
    private javax.swing.JButton numreacciones1;
    private javax.swing.JButton numreacciones2;
    private javax.swing.JButton repostearBtn1;
    private javax.swing.JButton repostearBtn2;
    private javax.swing.JButton repostearBtn3;
    private javax.swing.JButton repostearBtn4;
    private javax.swing.JButton repostearBtn5;
    // End of variables declaration//GEN-END:variables
}
