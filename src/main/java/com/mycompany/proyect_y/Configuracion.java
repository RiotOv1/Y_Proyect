/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.proyect_y;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author dafmo
 */
public class Configuracion extends javax.swing.JFrame {

    /**
     * Creates new form Configuracion
     */
    public Configuracion() {
        initComponents();
        this.setLocationRelativeTo(null);
        Img();
        OcultoInicializar();
    }

    //Metodo para ocultar los objetos invisibles al inicio 
    public void OcultoInicializar() {
        //Ocultar todos los elementos invisibles al inicio
        BuscarBtn.setVisible(false);
        CambioContraseña.setVisible(false);
        ContraseñaActualizada.setVisible(false);
        DefinirGenero.setVisible(false);
        EditarPanel1.setVisible(false);
        EditarPanel2.setVisible(false);
        EditarPanel3.setVisible(false);
        EditarPanel4.setVisible(false);
        EditarPanel5.setVisible(false);
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
        FotoPerfil.setIcon(Icono);

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
        ExplorarBtn1.setIcon(Icono2);
        BuscadorImagen.setIcon(Icono2);

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

        //IconoBuscarMas
        String url7 = "src\\main\\java\\Multimedia\\Icon-BusMas.png";
        ImageIcon image7 = new ImageIcon(url7);
        Image img7 = image7.getImage().getScaledInstance(24, 24, 0);
        ImageIcon Icono7 = new ImageIcon(img7);
        BuscadorImagen.setIcon(Icono7);

        //IconoAtrasBtn
        String url8 = "src\\main\\java\\Multimedia\\Icon-Atras.png";
        ImageIcon image8 = new ImageIcon(url8);
        Image img8 = image8.getImage().getScaledInstance(30, 30, 0);
        ImageIcon Icono8 = new ImageIcon(img8);
        AtrasBtn.setIcon(Icono8);
        AtrasBtn1.setIcon(Icono8);
        AtrasBtn2.setIcon(Icono8);
        AtrasTPostBtn.setIcon(Icono8);
        AtrasContVesBtn.setIcon(Icono8);

        //Icono SubMenu Usuario
        String url9 = "src\\main\\java\\Multimedia\\Icon-Sub-Usuario.png";
        ImageIcon image9 = new ImageIcon(url9);
        Image img9 = image9.getImage().getScaledInstance(24, 24, 0);
        ImageIcon Icono9 = new ImageIcon(img9);
        SubUsuario.setIcon(Icono9);

        //Icono Siguiente
        String url10 = "src\\main\\java\\Multimedia\\Icon-Siguiente.png";
        ImageIcon image10 = new ImageIcon(url10);
        Image img10 = image10.getImage().getScaledInstance(24, 24, 0);
        ImageIcon Icono10 = new ImageIcon(img10);
        Sig1.setIcon(Icono10);
        Sig2.setIcon(Icono10);
        Sig3.setIcon(Icono10);
        Sig4.setIcon(Icono10);
        Sig5.setIcon(Icono10);
        Sig6.setIcon(Icono10);
        Sig7.setIcon(Icono10);
        
            //Iconos siguientes de privacidad, notificaciones, etc son labels
            L_sig.setIcon(Icono10);
            L_sig_tusPosts.setIcon(Icono10);
            L_sig_ContVes.setIcon(Icono10);
            L_sig_filtros.setIcon(Icono10);
            L_sig_pref.setIcon(Icono10);
            L_sig_AddInfPo.setIcon(Icono10);
            L_sig_CSTemas.setIcon(Icono10);
            L_sig_CSExplorarC.setIcon(Icono10);
            L_sig_CSInte.setIcon(Icono10);
            L_sig_CSConfigBus.setIcon(Icono10);
            

        //Icono SubMenu Llave
        String url11 = "src\\main\\java\\Multimedia\\Icon-Sub-Llave.png";
        ImageIcon image11 = new ImageIcon(url11);
        Image img11 = image11.getImage().getScaledInstance(24, 24, 0);
        ImageIcon Icono11 = new ImageIcon(img11);
        SubLlave.setIcon(Icono11);

        //Icono SubMenu Desactivar Cuenta
        String url12 = "src\\main\\java\\Multimedia\\Icon-Desc.png";
        ImageIcon image12 = new ImageIcon(url12);
        Image img12 = image12.getImage().getScaledInstance(24, 24, 0);
        ImageIcon Icono12 = new ImageIcon(img12);
        SubDesc.setIcon(Icono12);

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

        //Icono EnviarContraseña
        String url15 = "src\\main\\java\\Multimedia\\Listo_Gris.png";
        ImageIcon image15 = new ImageIcon(url15);
        Image img15 = image15.getImage().getScaledInstance(24, 24, 0);
        ImageIcon Icono15 = new ImageIcon(img15);
        EnviarContraseña.setIcon(Icono15);

        //Icono Editar 
        String urlEditar = "src\\main\\java\\Multimedia\\Icono_Editar.png";
        ImageIcon image16 = new ImageIcon(urlEditar);
        Image img16 = image16.getImage().getScaledInstance(24, 24, 0);
        ImageIcon Icono16 = new ImageIcon(img16);
        Editar1.setIcon(Icono16);
        Editar2.setIcon(Icono16);
        Editar3.setIcon(Icono16);
        Editar4.setIcon(Icono16);
        Editar5.setIcon(Icono16);
        Editar6.setIcon(Icono16);

        //Icono Guardar
        String urlSalvar = "src\\main\\java\\Multimedia\\Icono_Guardar.png";
        ImageIcon image17 = new ImageIcon(urlSalvar);
        Image img17 = image17.getImage().getScaledInstance(24, 24, 0);
        ImageIcon Icono17 = new ImageIcon(img17);
        Save_Icono1.setIcon(Icono17);
        Save_Icono2.setIcon(Icono17);
        Save_Icono3.setIcon(Icono17);
        Save_Icono4.setIcon(Icono17);
        Save_Icono5.setIcon(Icono17);
        
        //Icono post
        String urlPost_ed = "src\\main\\java\\Multimedia\\edit-pencil-Icon.png";
        ImageIcon image18 = new ImageIcon(urlPost_ed);
        Image img18 = image18.getImage().getScaledInstance(24,24,0);
        ImageIcon Icono18 = new ImageIcon(img18);
        TusPostBtn.setIcon(Icono18);
        
        //Icono contenido que ves
         String urlContenido_ves="src\\main\\java\\Multimedia\\Post-Icon.png";
         ImageIcon image19 = new ImageIcon(urlContenido_ves);
         Image img19 = image19.getImage().getScaledInstance(24, 24, 0);
         ImageIcon Icono19 = new ImageIcon(img19);
         ContenidoVesBtn.setIcon(Icono19);
        
       //Icono Silenciar y bloquear
       String urlSileBloq="src\\main\\java\\Multimedia\\Mute-and-Block-Icon.png";
       ImageIcon image20 = new ImageIcon(urlSileBloq);
       Image img20 = image20.getImage().getScaledInstance(24, 24, 0);
       ImageIcon Icono20 = new ImageIcon(img20);
       SilenciarYBloquearBtn.setIcon(Icono20);
       
       //Icono Filtros de notificaciones
       String urlFilNot="src\\main\\java\\Multimedia\\Filters-Config-Icon.png";
       ImageIcon image21 = new ImageIcon(urlFilNot);
       Image img21 = image21.getImage().getScaledInstance(50, 50, 0);
       ImageIcon Icono21 = new ImageIcon(img21);
       FiltrosNotConfBtn.setIcon(Icono21);
       
       //Icono Preferencias de notificaciones
       String urlPref="src\\main\\java\\Multimedia\\Preferences-Icon.png";
       ImageIcon image22 = new ImageIcon(urlPref);
       Image img22 = image22.getImage().getScaledInstance(50, 50, 0);
       ImageIcon Icono22 = new ImageIcon(img22);
       PreferenciasBtn.setIcon(Icono22);
       
    }

    //Metodo para controlar que la contraseña sea igual a la de la base de datos.
    public void ControlContraseñaNueva() {
        String contra = ContraseñaActual.getText();
        if (contra.equals("User1")) {
            CambioContraseña.setVisible(true);

        } else {
            ContraseñaActual.setText("Contraseña incorrecta");

            //Icono EnviarContraseña
            String url15 = "src\\main\\java\\Multimedia\\Listo_Error.png";
            ImageIcon image15 = new ImageIcon(url15);
            Image img15 = image15.getImage().getScaledInstance(24, 24, 0);
            ImageIcon Icono15 = new ImageIcon(img15);
            EnviarContraseña.setIcon(Icono15);
        }
    }

    //Metodo para verificar el cambio de contraseña
    //Comprobacion de que no sea igual que la actual
    //Comprobacion de que el cambio sea igual en ambos campos
    //Hacer visible el boton
    public void VerificarCambioContraseña() {
        //Obtenemos los valores de los campos de texto
        String Coontraseña = ContraseñaActual.getText();
        String ContraseñaNueva = ContraseñaNueva1.getText();
        String ContraseñaCambio = ConfirmarContraseña.getText();
        //Comprobamos que si contraseña antigua es diferente a contraseña nueva
        if (!Coontraseña.equals(ContraseñaCambio)) {
            //Comprobamos que la contraseña a cambiar y la confirmacion sean iguales
            if (ContraseñaNueva.equals(ContraseñaCambio)) {
                //Mostramos boton
                ContraseñaActualizada.setVisible(true);
                System.out.println("Cambio en Proceso");
            } else {
                System.err.println("Error Contraseña Distinta, Comprueba que sea igual");
            }
        } else {
            System.err.println("Error Contraseña Igual");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane2 = new javax.swing.JTabbedPane();
        jLabel44 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        PostearBtn = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        PerfilPanel = new javax.swing.JPanel();
        Perfil_Img = new javax.swing.JLabel();
        NombreUsuario = new javax.swing.JLabel();
        IdUsuario = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        JPanelGeneraPanel = new javax.swing.JTabbedPane();
        InformacionCuentaPanel = new javax.swing.JPanel();
        PanelCuenta = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        UsuarioLabel5 = new javax.swing.JLabel();
        Sig6 = new javax.swing.JLabel();
        CambiarPassBtn = new javax.swing.JButton();
        SubLlave = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        Sig1 = new javax.swing.JLabel();
        UsuarioLabel1 = new javax.swing.JLabel();
        InfCuentaBtn = new javax.swing.JButton();
        SubUsuario = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        UsuarioLabel6 = new javax.swing.JLabel();
        Sig7 = new javax.swing.JLabel();
        DesactivarCuentaBtn = new javax.swing.JButton();
        SubDesc = new javax.swing.JLabel();
        InfCuenta = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        AtrasBtn = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        Editar1 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        UsuarioLabel = new javax.swing.JLabel();
        EditarPanel1 = new javax.swing.JPanel();
        NombreUsuarioEditar = new javax.swing.JTextField();
        Save_Icono1 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        Editar3 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        EditarPanel3 = new javax.swing.JPanel();
        CorreoEditar = new javax.swing.JTextField();
        Save_Icono3 = new javax.swing.JButton();
        CorreoLabel = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        TelefonoLabel = new javax.swing.JLabel();
        Editar2 = new javax.swing.JButton();
        EditarPanel2 = new javax.swing.JPanel();
        TelefonoEditar = new javax.swing.JTextField();
        Save_Icono2 = new javax.swing.JButton();
        Pais = new javax.swing.JComboBox<>();
        BanderaLabel = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        jPanel7 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        Editar6 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        PaisLabel = new javax.swing.JLabel();
        Editar4 = new javax.swing.JButton();
        EditarPanel4 = new javax.swing.JPanel();
        Save_Icono4 = new javax.swing.JButton();
        PaisComboBox = new javax.swing.JComboBox<>();
        BanderaLabel1 = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        jPanel9 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        Editar5 = new javax.swing.JButton();
        EditarPanel5 = new javax.swing.JPanel();
        Save_Icono5 = new javax.swing.JButton();
        GeneroComboBox = new javax.swing.JComboBox<>();
        DefinirGenero = new javax.swing.JTextField();
        GeneroLabel = new javax.swing.JLabel();
        PassPanel = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        AtrasBtn2 = new javax.swing.JButton();
        jLabel94 = new javax.swing.JLabel();
        jPanel24 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        ContraseñaActual = new javax.swing.JTextField();
        EnviarContraseña = new javax.swing.JButton();
        CambioContraseña = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        ContraseñaNueva1 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        ConfirmarContraseña = new javax.swing.JTextField();
        ContraseñaActualizada = new javax.swing.JButton();
        jSeparator11 = new javax.swing.JSeparator();
        DesactivarPanel = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        AtrasBtn1 = new javax.swing.JButton();
        jSeparator12 = new javax.swing.JSeparator();
        jPanel10 = new javax.swing.JPanel();
        FotoPerfil = new javax.swing.JLabel();
        NombreUsuario1 = new javax.swing.JLabel();
        IdUsuario1 = new javax.swing.JLabel();
        jSeparator13 = new javax.swing.JSeparator();
        jLabel16 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        DesactivarBtn = new javax.swing.JButton();
        SeguridadPanel = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        UsuarioLabel2 = new javax.swing.JLabel();
        UsuarioLabel4 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        UsuarioLabel3 = new javax.swing.JLabel();
        Sig8 = new javax.swing.JLabel();
        Sig9 = new javax.swing.JLabel();
        Sig10 = new javax.swing.JLabel();
        PrivacidadTabPane = new javax.swing.JPanel();
        L_PS_Title = new javax.swing.JLabel();
        SilenciarYBloquearBtn = new javax.swing.JButton();
        jLabel40 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        L_sig = new javax.swing.JLabel();
        TusPostBtn = new javax.swing.JButton();
        L_sig_tusPosts = new javax.swing.JLabel();
        ContenidoVesBtn = new javax.swing.JButton();
        L_sig_ContVes = new javax.swing.JLabel();
        NotificacionesTabPane = new javax.swing.JPanel();
        L_PS_Title1 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        PreferenciasBtn = new javax.swing.JButton();
        FiltrosNotConfBtn = new javax.swing.JButton();
        L_sig_pref = new javax.swing.JLabel();
        L_sig_filtros = new javax.swing.JLabel();
        TusPostTabPane = new javax.swing.JPanel();
        L_PS_Title2 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        AnadeInfBtn = new javax.swing.JButton();
        AtrasTPostBtn = new javax.swing.JButton();
        L_sig_AddInfPo = new javax.swing.JLabel();
        ContVesTabPane = new javax.swing.JPanel();
        L_PS_Title3 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        TemasBtn = new javax.swing.JButton();
        InteresesBtn = new javax.swing.JButton();
        ExpoConfigBtn = new javax.swing.JButton();
        BusqConfigBtn = new javax.swing.JButton();
        jCheckBox2 = new javax.swing.JCheckBox();
        AtrasContVesBtn = new javax.swing.JButton();
        L_sig_CSTemas = new javax.swing.JLabel();
        L_sig_CSExplorarC = new javax.swing.JLabel();
        L_sig_CSInte = new javax.swing.JLabel();
        L_sig_CSConfigBus = new javax.swing.JLabel();
        CuentaBtn = new javax.swing.JButton();
        NotiFicacionesBtn = new javax.swing.JButton();
        jSeparator9 = new javax.swing.JSeparator();
        SeguridadYAccesoBtn = new javax.swing.JButton();
        jSeparator10 = new javax.swing.JSeparator();
        PrivacidadYSeguridadBtn = new javax.swing.JButton();
        ConBus = new javax.swing.JLabel();
        Buscador = new javax.swing.JTextField();
        BuscarBtn = new javax.swing.JButton();
        BuscadorImagen = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        Sig3 = new javax.swing.JLabel();
        Sig2 = new javax.swing.JLabel();
        Sig4 = new javax.swing.JLabel();
        Sig5 = new javax.swing.JLabel();
        ConfiBtn = new javax.swing.JButton();
        InicioBtn1 = new javax.swing.JButton();
        ComunidadesBtn = new javax.swing.JButton();
        NotificacionesBtn = new javax.swing.JButton();
        GuardadoBtn = new javax.swing.JButton();
        PerfilBtn = new javax.swing.JButton();
        ExplorarBtn1 = new javax.swing.JButton();
        Y_logo = new javax.swing.JLabel();

        jLabel44.setText("jLabel44");
        jTabbedPane2.addTab("tab1", jLabel44);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(26, 26, 29));
        setLocationByPlatform(true);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jPanel1.add(PostearBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 650, 200, 40));

        jSeparator1.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator1.setForeground(new java.awt.Color(153, 153, 153));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(427, 0, -1, 820));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 110, 450, -1));

        jLabel2.setFont(new java.awt.Font("Roboto Black", 0, 22)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("Configuración");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, 170, 30));

        PerfilPanel.setBackground(new java.awt.Color(0, 0, 0));
        PerfilPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        PerfilPanel.add(Perfil_Img, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 50, 40));

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

        jPanel1.add(PerfilPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 720, 270, 60));

        jSeparator4.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator4.setForeground(new java.awt.Color(153, 153, 153));
        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 0, 10, 820));
        jPanel1.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 210, 450, 10));

        JPanelGeneraPanel.setBackground(new java.awt.Color(153, 153, 255));

        InformacionCuentaPanel.setBackground(new java.awt.Color(0, 0, 0));

        PanelCuenta.setBackground(new java.awt.Color(0, 0, 0));
        PanelCuenta.setPreferredSize(new java.awt.Dimension(610, 820));
        PanelCuenta.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setText("Tu Cuenta");
        PanelCuenta.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jLabel4.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setText("Ve la información de la cuenta, u obtén más información acerca de las opciones ");
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        PanelCuenta.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 510, 30));

        jPanel20.setBackground(new java.awt.Color(0, 0, 0));
        jPanel20.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel20.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        UsuarioLabel5.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        UsuarioLabel5.setForeground(new java.awt.Color(204, 204, 204));
        UsuarioLabel5.setText("Cambia tu contraseña en cualquier momento");
        jPanel20.add(UsuarioLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, -1, -1));

        Sig6.setFont(new java.awt.Font("Roboto Mono ExtraLight", 0, 24)); // NOI18N
        Sig6.setForeground(new java.awt.Color(204, 204, 204));
        Sig6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Sig6MouseClicked(evt);
            }
        });
        jPanel20.add(Sig6, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 0, 50, 60));

        CambiarPassBtn.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        CambiarPassBtn.setForeground(new java.awt.Color(204, 204, 204));
        CambiarPassBtn.setText("Cambiar la Contraseña");
        CambiarPassBtn.setBorderPainted(false);
        CambiarPassBtn.setContentAreaFilled(false);
        CambiarPassBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        CambiarPassBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CambiarPassBtnActionPerformed(evt);
            }
        });
        jPanel20.add(CambiarPassBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 520, 50));
        jPanel20.add(SubLlave, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 50, 60));

        PanelCuenta.add(jPanel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 610, 60));

        jPanel19.setBackground(new java.awt.Color(0, 0, 0));
        jPanel19.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel19.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Sig1.setBackground(new java.awt.Color(0, 0, 0));
        Sig1.setFont(new java.awt.Font("Roboto Mono ExtraLight", 0, 24)); // NOI18N
        jPanel19.add(Sig1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 0, 50, 60));

        UsuarioLabel1.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        UsuarioLabel1.setForeground(new java.awt.Color(204, 204, 204));
        UsuarioLabel1.setText("Ve la informacion de tu cuenta, como el numero de telefono y la direccion de correo electronico");
        jPanel19.add(UsuarioLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, -1, -1));

        InfCuentaBtn.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        InfCuentaBtn.setForeground(new java.awt.Color(204, 204, 204));
        InfCuentaBtn.setText("Informacion de la cuenta");
        InfCuentaBtn.setBorderPainted(false);
        InfCuentaBtn.setContentAreaFilled(false);
        InfCuentaBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        InfCuentaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InfCuentaBtnActionPerformed(evt);
            }
        });
        jPanel19.add(InfCuentaBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 520, 50));
        jPanel19.add(SubUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 50, 60));

        PanelCuenta.add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 610, 60));

        jLabel5.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel5.setText("de desactivación de la cuenta");
        PanelCuenta.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 290, 30));

        jPanel22.setBackground(new java.awt.Color(0, 0, 0));
        jPanel22.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel22.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        UsuarioLabel6.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        UsuarioLabel6.setForeground(new java.awt.Color(204, 204, 204));
        UsuarioLabel6.setText("Averigua como desactivar tu cuenta");
        jPanel22.add(UsuarioLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, -1, -1));

        Sig7.setFont(new java.awt.Font("Roboto Mono ExtraLight", 0, 24)); // NOI18N
        Sig7.setForeground(new java.awt.Color(204, 204, 204));
        jPanel22.add(Sig7, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 0, 50, 60));

        DesactivarCuentaBtn.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        DesactivarCuentaBtn.setForeground(new java.awt.Color(204, 204, 204));
        DesactivarCuentaBtn.setText("Desactivar Cuenta");
        DesactivarCuentaBtn.setBorderPainted(false);
        DesactivarCuentaBtn.setContentAreaFilled(false);
        DesactivarCuentaBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        DesactivarCuentaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DesactivarCuentaBtnActionPerformed(evt);
            }
        });
        jPanel22.add(DesactivarCuentaBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 520, 50));
        jPanel22.add(SubDesc, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 50, 60));

        PanelCuenta.add(jPanel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, -1, -1));

        InformacionCuentaPanel.add(PanelCuenta);

        JPanelGeneraPanel.addTab("Cuenta", InformacionCuentaPanel);

        InfCuenta.setBackground(new java.awt.Color(0, 0, 0));
        InfCuenta.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 204, 204));
        jLabel9.setText("Informacion Cuenta");
        InfCuenta.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, 40));

        AtrasBtn.setBackground(new java.awt.Color(204, 204, 204));
        AtrasBtn.setFont(new java.awt.Font("Roboto Mono ExtraLight", 0, 24)); // NOI18N
        AtrasBtn.setForeground(new java.awt.Color(255, 255, 255));
        AtrasBtn.setBorderPainted(false);
        AtrasBtn.setContentAreaFilled(false);
        AtrasBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AtrasBtnActionPerformed(evt);
            }
        });
        InfCuenta.add(AtrasBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 50, 40));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Editar1.setBorderPainted(false);
        Editar1.setContentAreaFilled(false);
        Editar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Editar1ActionPerformed(evt);
            }
        });
        jPanel2.add(Editar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 0, 50, 60));

        jLabel10.setBackground(new java.awt.Color(0, 0, 0));
        jLabel10.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(204, 204, 204));
        jLabel10.setText("Nombre de Usuario");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 20));

        UsuarioLabel.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        UsuarioLabel.setForeground(new java.awt.Color(204, 204, 204));
        UsuarioLabel.setText("@Usuario");
        jPanel2.add(UsuarioLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        EditarPanel1.setBackground(new java.awt.Color(204, 204, 204));
        EditarPanel1.setOpaque(false);
        EditarPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        NombreUsuarioEditar.setBackground(new java.awt.Color(0, 0, 0));
        NombreUsuarioEditar.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        NombreUsuarioEditar.setForeground(new java.awt.Color(204, 204, 204));
        NombreUsuarioEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NombreUsuarioEditarActionPerformed(evt);
            }
        });
        EditarPanel1.add(NombreUsuarioEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 40));

        Save_Icono1.setBackground(new java.awt.Color(0, 0, 0));
        Save_Icono1.setBorderPainted(false);
        Save_Icono1.setContentAreaFilled(false);
        Save_Icono1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Save_Icono1ActionPerformed(evt);
            }
        });
        EditarPanel1.add(Save_Icono1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, 40, 40));

        jPanel2.add(EditarPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 250, 40));

        InfCuenta.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 610, 60));

        jPanel6.setBackground(new java.awt.Color(102, 102, 102));
        jPanel6.setOpaque(false);
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Editar3.setBorderPainted(false);
        Editar3.setContentAreaFilled(false);
        Editar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Editar3ActionPerformed(evt);
            }
        });
        jPanel6.add(Editar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 0, 50, 60));

        jLabel17.setBackground(new java.awt.Color(0, 0, 0));
        jLabel17.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(204, 204, 204));
        jLabel17.setText("Correo Electronico");
        jPanel6.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 20));

        EditarPanel3.setBackground(new java.awt.Color(204, 204, 204));
        EditarPanel3.setOpaque(false);
        EditarPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CorreoEditar.setBackground(new java.awt.Color(0, 0, 0));
        CorreoEditar.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        CorreoEditar.setForeground(new java.awt.Color(204, 204, 204));
        CorreoEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CorreoEditarActionPerformed(evt);
            }
        });
        EditarPanel3.add(CorreoEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 40));

        Save_Icono3.setBackground(new java.awt.Color(0, 0, 0));
        Save_Icono3.setBorderPainted(false);
        Save_Icono3.setContentAreaFilled(false);
        Save_Icono3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Save_Icono3ActionPerformed(evt);
            }
        });
        EditarPanel3.add(Save_Icono3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, 40, 40));

        jPanel6.add(EditarPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 250, 40));

        CorreoLabel.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        CorreoLabel.setForeground(new java.awt.Color(204, 204, 204));
        jPanel6.add(CorreoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 130, 20));

        InfCuenta.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 610, 60));

        jPanel5.setBackground(new java.awt.Color(102, 102, 102));
        jPanel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel5.setOpaque(false);
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setBackground(new java.awt.Color(0, 0, 0));
        jLabel14.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(204, 204, 204));
        jLabel14.setText("Telefono");
        jPanel5.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 20));

        TelefonoLabel.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        TelefonoLabel.setForeground(new java.awt.Color(204, 204, 204));
        TelefonoLabel.setText(" 656 123 4567");
        jPanel5.add(TelefonoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, -1, 20));

        Editar2.setBorderPainted(false);
        Editar2.setContentAreaFilled(false);
        Editar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Editar2ActionPerformed(evt);
            }
        });
        jPanel5.add(Editar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 0, 50, 60));

        EditarPanel2.setBackground(new java.awt.Color(204, 204, 204));
        EditarPanel2.setOpaque(false);
        EditarPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TelefonoEditar.setBackground(new java.awt.Color(0, 0, 0));
        TelefonoEditar.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        TelefonoEditar.setForeground(new java.awt.Color(204, 204, 204));
        TelefonoEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TelefonoEditarActionPerformed(evt);
            }
        });
        EditarPanel2.add(TelefonoEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 200, 40));

        Save_Icono2.setBackground(new java.awt.Color(0, 0, 0));
        Save_Icono2.setBorderPainted(false);
        Save_Icono2.setContentAreaFilled(false);
        Save_Icono2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Save_Icono2ActionPerformed(evt);
            }
        });
        EditarPanel2.add(Save_Icono2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 40, 40));

        Pais.setBackground(new java.awt.Color(0, 0, 0));
        Pais.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        Pais.setForeground(new java.awt.Color(204, 204, 204));
        Pais.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "...", "+52", "+1" }));
        Pais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PaisActionPerformed(evt);
            }
        });
        EditarPanel2.add(Pais, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 60, 40));

        jPanel5.add(EditarPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 310, 40));
        jPanel5.add(BanderaLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 30, 20));

        InfCuenta.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 610, 60));
        InfCuenta.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 490, 640, 10));

        jPanel3.setOpaque(false);
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(204, 204, 204));
        jLabel18.setText("00 / 00 / 0000");
        jPanel3.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        jLabel19.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(204, 204, 204));
        jLabel19.setText("Creacion de la Cuenta");
        jPanel3.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        InfCuenta.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 650, 70));
        InfCuenta.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 640, -1));

        jPanel7.setBackground(new java.awt.Color(51, 51, 51));
        jPanel7.setOpaque(false);
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel21.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(204, 204, 204));
        jLabel21.setText("Fecha de nacimiento");
        jPanel7.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel25.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(204, 204, 204));
        jLabel25.setText("00 / 00 / 0000");
        jPanel7.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        jLabel12.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(204, 204, 204));
        jLabel12.setText("Actualiza tu fecha de nacimiento desde ");
        jPanel7.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, -1, -1));

        jLabel13.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(102, 0, 102));
        jLabel13.setText("Perfil");
        jPanel7.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 40, -1, -1));

        InfCuenta.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, 610, 60));

        jPanel8.setBackground(new java.awt.Color(51, 51, 51));
        jPanel8.setOpaque(false);
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel22.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(204, 204, 204));
        jLabel22.setText("Edad");
        jPanel8.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel28.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(166, 77, 121));
        jLabel28.setText("18");
        jPanel8.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 20, -1));

        Editar6.setBorderPainted(false);
        Editar6.setContentAreaFilled(false);
        Editar6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Editar6ActionPerformed(evt);
            }
        });
        jPanel8.add(Editar6, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 0, 50, 60));

        InfCuenta.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 490, 610, 60));

        jPanel4.setBackground(new java.awt.Color(51, 51, 51));
        jPanel4.setOpaque(false);
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(204, 204, 204));
        jLabel11.setText("País");
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        PaisLabel.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        PaisLabel.setForeground(new java.awt.Color(204, 204, 204));
        PaisLabel.setText("Indefinido");
        jPanel4.add(PaisLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, 20));

        Editar4.setBorderPainted(false);
        Editar4.setContentAreaFilled(false);
        Editar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Editar4ActionPerformed(evt);
            }
        });
        jPanel4.add(Editar4, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 0, 50, 60));

        EditarPanel4.setBackground(new java.awt.Color(204, 204, 204));
        EditarPanel4.setOpaque(false);
        EditarPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Save_Icono4.setBackground(new java.awt.Color(0, 0, 0));
        Save_Icono4.setBorderPainted(false);
        Save_Icono4.setContentAreaFilled(false);
        Save_Icono4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Save_Icono4ActionPerformed(evt);
            }
        });
        EditarPanel4.add(Save_Icono4, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, 40, 40));

        PaisComboBox.setBackground(new java.awt.Color(0, 0, 0));
        PaisComboBox.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        PaisComboBox.setForeground(new java.awt.Color(204, 204, 204));
        PaisComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Indefinido", "Mexico", "Estados Unidos" }));
        EditarPanel4.add(PaisComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 40));

        jPanel4.add(EditarPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 250, 40));

        BanderaLabel1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jPanel4.add(BanderaLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 30, 20));

        InfCuenta.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 610, 60));
        InfCuenta.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 640, 10));

        jPanel9.setBackground(new java.awt.Color(51, 51, 51));
        jPanel9.setOpaque(false);
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel26.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(204, 204, 204));
        jLabel26.setText("Género");
        jPanel9.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        Editar5.setBorderPainted(false);
        Editar5.setContentAreaFilled(false);
        Editar5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Editar5ActionPerformed(evt);
            }
        });
        jPanel9.add(Editar5, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 0, 50, 60));

        EditarPanel5.setBackground(new java.awt.Color(204, 204, 204));
        EditarPanel5.setOpaque(false);
        EditarPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Save_Icono5.setBackground(new java.awt.Color(0, 0, 0));
        Save_Icono5.setBorderPainted(false);
        Save_Icono5.setContentAreaFilled(false);
        Save_Icono5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Save_Icono5ActionPerformed(evt);
            }
        });
        EditarPanel5.add(Save_Icono5, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, 40, 40));

        GeneroComboBox.setBackground(new java.awt.Color(0, 0, 0));
        GeneroComboBox.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        GeneroComboBox.setForeground(new java.awt.Color(204, 204, 204));
        GeneroComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Indefinido", "Hombre", "Mujer ", "Agregar tu genero" }));
        GeneroComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GeneroComboBoxActionPerformed(evt);
            }
        });
        EditarPanel5.add(GeneroComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 40));

        DefinirGenero.setBackground(new java.awt.Color(0, 0, 0));
        DefinirGenero.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        DefinirGenero.setForeground(new java.awt.Color(204, 204, 204));
        DefinirGenero.setText("Define tu genero");
        DefinirGenero.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DefinirGeneroMouseClicked(evt);
            }
        });
        EditarPanel5.add(DefinirGenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 0, 150, 40));

        jPanel9.add(EditarPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 410, 40));

        GeneroLabel.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        GeneroLabel.setForeground(new java.awt.Color(204, 204, 204));
        GeneroLabel.setText("Indefinido");
        jPanel9.add(GeneroLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, 20));

        InfCuenta.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 610, 60));

        JPanelGeneraPanel.addTab("InfCuenta", InfCuenta);

        PassPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel23.setBackground(new java.awt.Color(0, 0, 0));
        jPanel23.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        AtrasBtn2.setBackground(new java.awt.Color(204, 204, 204));
        AtrasBtn2.setFont(new java.awt.Font("Roboto Mono ExtraLight", 0, 24)); // NOI18N
        AtrasBtn2.setForeground(new java.awt.Color(255, 255, 255));
        AtrasBtn2.setBorderPainted(false);
        AtrasBtn2.setContentAreaFilled(false);
        AtrasBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AtrasBtn2ActionPerformed(evt);
            }
        });
        jPanel23.add(AtrasBtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 50, 40));

        jLabel94.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel94.setForeground(new java.awt.Color(204, 204, 204));
        jLabel94.setText("Actualizar Contaseña");
        jPanel23.add(jLabel94, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, 40));

        jPanel24.setOpaque(false);
        jPanel24.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("Contaseña Actual");
        jPanel24.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        ContraseñaActual.setBackground(new java.awt.Color(0, 0, 0));
        ContraseñaActual.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        ContraseñaActual.setForeground(new java.awt.Color(204, 204, 204));
        ContraseñaActual.setText("Contaseña Actual");
        ContraseñaActual.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(204, 204, 204)));
        ContraseñaActual.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ContraseñaActualMouseClicked(evt);
            }
        });
        ContraseñaActual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContraseñaActualActionPerformed(evt);
            }
        });
        ContraseñaActual.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ContraseñaActualKeyReleased(evt);
            }
        });
        jPanel24.add(ContraseñaActual, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 480, 40));

        EnviarContraseña.setBackground(new java.awt.Color(0, 0, 0));
        EnviarContraseña.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        EnviarContraseña.setForeground(new java.awt.Color(204, 204, 204));
        EnviarContraseña.setText("Enviar");
        EnviarContraseña.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        EnviarContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EnviarContraseñaActionPerformed(evt);
            }
        });
        jPanel24.add(EnviarContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 30, 110, 40));

        CambioContraseña.setBackground(new java.awt.Color(0, 0, 0));
        CambioContraseña.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 204, 204));
        jLabel6.setText("Cambio de contraseña");
        CambioContraseña.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, 20));

        jLabel7.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 204, 204));
        jLabel7.setText("Contraseña Nueva");
        CambioContraseña.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        ContraseñaNueva1.setBackground(new java.awt.Color(0, 0, 0));
        ContraseñaNueva1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        ContraseñaNueva1.setForeground(new java.awt.Color(204, 204, 204));
        ContraseñaNueva1.setText("Contraseña Nueva");
        ContraseñaNueva1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ContraseñaNueva1MouseClicked(evt);
            }
        });
        ContraseñaNueva1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContraseñaNueva1ActionPerformed(evt);
            }
        });
        CambioContraseña.add(ContraseñaNueva1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 470, 40));

        jLabel8.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 204, 204));
        jLabel8.setText("Confirmar cambio de contraseña");
        CambioContraseña.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        ConfirmarContraseña.setBackground(new java.awt.Color(0, 0, 0));
        ConfirmarContraseña.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        ConfirmarContraseña.setForeground(new java.awt.Color(204, 204, 204));
        ConfirmarContraseña.setText("Confirmar la contraseña");
        ConfirmarContraseña.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ConfirmarContraseñaMouseClicked(evt);
            }
        });
        ConfirmarContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmarContraseñaActionPerformed(evt);
            }
        });
        ConfirmarContraseña.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ConfirmarContraseñaKeyReleased(evt);
            }
        });
        CambioContraseña.add(ConfirmarContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 470, 40));

        ContraseñaActualizada.setBackground(new java.awt.Color(0, 0, 0));
        ContraseñaActualizada.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        ContraseñaActualizada.setForeground(new java.awt.Color(204, 204, 204));
        ContraseñaActualizada.setText("Cambiar Contraseña");
        ContraseñaActualizada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContraseñaActualizadaActionPerformed(evt);
            }
        });
        CambioContraseña.add(ContraseñaActualizada, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 200, 160, 40));
        CambioContraseña.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 640, 20));

        jPanel24.add(CambioContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 640, 250));

        jPanel23.add(jPanel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 660, 330));

        PassPanel.add(jPanel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 760));

        JPanelGeneraPanel.addTab("Pass", PassPanel);

        DesactivarPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel11.setBackground(new java.awt.Color(0, 0, 0));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(204, 204, 204));
        jLabel15.setText("Que mas debes saber");
        jPanel11.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, -1, 40));

        AtrasBtn1.setBackground(new java.awt.Color(204, 204, 204));
        AtrasBtn1.setFont(new java.awt.Font("Roboto Mono ExtraLight", 0, 24)); // NOI18N
        AtrasBtn1.setForeground(new java.awt.Color(255, 255, 255));
        AtrasBtn1.setBorderPainted(false);
        AtrasBtn1.setContentAreaFilled(false);
        AtrasBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AtrasBtn1ActionPerformed(evt);
            }
        });
        jPanel11.add(AtrasBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 50, 40));
        jPanel11.add(jSeparator12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 53, 640, 10));

        jPanel10.setOpaque(false);
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel10.add(FotoPerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 60));

        NombreUsuario1.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        NombreUsuario1.setForeground(new java.awt.Color(204, 204, 204));
        NombreUsuario1.setText("Usuario Ejemplo");
        jPanel10.add(NombreUsuario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, -1));

        IdUsuario1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        IdUsuario1.setForeground(new java.awt.Color(106, 30, 85));
        IdUsuario1.setText("@Usuario1");
        jPanel10.add(IdUsuario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, -1, -1));

        jPanel11.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 630, 60));
        jPanel11.add(jSeparator13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 640, 10));

        jLabel16.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(204, 204, 204));
        jLabel16.setText("de su desactivación.");
        jPanel11.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, -1, -1));

        jLabel20.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(204, 204, 204));
        jLabel20.setText("Si tu cuenta de Y se desactivó por error o accidentalmente, tienes un plazo de 30 días para restaurarla después");
        jPanel11.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, -1, -1));

        jLabel24.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(204, 204, 204));
        jLabel24.setText("Desactivar Cuenta");
        jPanel11.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, 40));

        jLabel27.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(204, 204, 204));
        jLabel27.setText(" Esta acción desactivará tu cuenta");
        jPanel11.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, 40));

        jLabel31.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(204, 204, 204));
        jLabel31.setText("Estás por iniciar el proceso de desactivación de tu cuenta. Tu nombre visible, tu @nombre de usuario y tu perfil ");
        jPanel11.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        jLabel32.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(204, 204, 204));
        jLabel32.setText("publico ya no se podra ver en Y.");
        jPanel11.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        DesactivarBtn.setBackground(new java.awt.Color(245, 242, 193));
        DesactivarBtn.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        DesactivarBtn.setForeground(new java.awt.Color(255, 0, 51));
        DesactivarBtn.setText("Desactivar Cuenta");
        DesactivarBtn.setAlignmentY(0.0F);
        DesactivarBtn.setBorder(null);
        DesactivarBtn.setBorderPainted(false);
        DesactivarBtn.setContentAreaFilled(false);
        DesactivarBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DesactivarBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                DesactivarBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                DesactivarBtnMouseExited(evt);
            }
        });
        jPanel11.add(DesactivarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 650, 40));

        DesactivarPanel.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 760));

        JPanelGeneraPanel.addTab("Desactivar", DesactivarPanel);

        SeguridadPanel.setBackground(new java.awt.Color(0, 0, 0));
        SeguridadPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel23.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(204, 204, 204));
        jLabel23.setText("Administra la seguridad de tu cuenta y lleva un control de su uso, incluidas las aplicaciones ");
        jLabel23.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        SeguridadPanel.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, 510, 30));

        jLabel29.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(204, 204, 204));
        jLabel29.setText("que conectaste a ella.");
        SeguridadPanel.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 290, 30));

        jLabel30.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(204, 204, 204));
        jLabel30.setText("Seguridad y acceso a la cuenta");
        SeguridadPanel.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 25, 300, -1));

        jPanel14.setBackground(new java.awt.Color(0, 0, 0));
        jPanel14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel33.setBackground(new java.awt.Color(0, 0, 0));
        jLabel33.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(204, 204, 204));
        jLabel33.setText("Aplicaciones y sesiones");
        jPanel14.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, -1, 20));

        UsuarioLabel2.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        UsuarioLabel2.setForeground(new java.awt.Color(204, 204, 204));
        UsuarioLabel2.setText("cuenta y las aplicaciones que conectaste con ella.");
        jPanel14.add(UsuarioLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, -1, -1));

        UsuarioLabel4.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        UsuarioLabel4.setForeground(new java.awt.Color(204, 204, 204));
        UsuarioLabel4.setText("Consulta la informacion sobre cuando iniciaste sesion en tu ");
        jPanel14.add(UsuarioLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, -1));

        SeguridadPanel.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 580, 60));

        jPanel15.setBackground(new java.awt.Color(0, 0, 0));
        jPanel15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel35.setBackground(new java.awt.Color(0, 0, 0));
        jLabel35.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(204, 204, 204));
        jLabel35.setText("Seguridad");
        jPanel15.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, 20));

        UsuarioLabel3.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        UsuarioLabel3.setForeground(new java.awt.Color(204, 204, 204));
        UsuarioLabel3.setText("Administra la seguridad de tu cuenta");
        jPanel15.add(UsuarioLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, -1, -1));

        SeguridadPanel.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 570, 60));

        Sig8.setBackground(new java.awt.Color(255, 255, 0));
        Sig8.setFont(new java.awt.Font("Roboto Mono ExtraLight", 0, 24)); // NOI18N
        Sig8.setOpaque(true);
        SeguridadPanel.add(Sig8, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 270, 50, 60));

        Sig9.setFont(new java.awt.Font("Roboto Mono ExtraLight", 0, 24)); // NOI18N
        Sig9.setForeground(new java.awt.Color(204, 204, 204));
        Sig9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Sig9MouseClicked(evt);
            }
        });
        SeguridadPanel.add(Sig9, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 270, 50, 60));

        Sig10.setFont(new java.awt.Font("Roboto Mono ExtraLight", 0, 24)); // NOI18N
        Sig10.setForeground(new java.awt.Color(204, 204, 204));
        SeguridadPanel.add(Sig10, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 270, 50, 60));

        JPanelGeneraPanel.addTab("Seguridad", SeguridadPanel);

        PrivacidadTabPane.setBackground(new java.awt.Color(0, 0, 0));
        PrivacidadTabPane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        L_PS_Title.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        L_PS_Title.setForeground(new java.awt.Color(204, 204, 204));
        L_PS_Title.setText("Privacidad y seguridad");
        PrivacidadTabPane.add(L_PS_Title, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 25, 300, -1));

        SilenciarYBloquearBtn.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        SilenciarYBloquearBtn.setForeground(new java.awt.Color(204, 204, 204));
        SilenciarYBloquearBtn.setText("<html><p style=\"font-size: 12px; padding:  0px 0px 0px 30px;\"> Silenciar y bloquear</p>\n<br> <p style=\"font-size: 9 px; padding: 0px 0px 0px 30px; color: rgba(255,255,255,0.5);\"> Administra las cuentas y notificaciones que has silenciado o bloqueado</p>\n </html>");
        SilenciarYBloquearBtn.setBorderPainted(false);
        SilenciarYBloquearBtn.setContentAreaFilled(false);
        SilenciarYBloquearBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        SilenciarYBloquearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SilenciarYBloquearBtnActionPerformed(evt);
            }
        });
        PrivacidadTabPane.add(SilenciarYBloquearBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 630, 60));

        jLabel40.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(204, 204, 204));
        jLabel40.setText("Administra qué información ves y compartes en Y.");
        jLabel40.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        PrivacidadTabPane.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, 510, 30));

        jLabel39.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText(">");
        PrivacidadTabPane.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 210, 20, 50));

        L_sig.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        L_sig.setForeground(new java.awt.Color(255, 255, 255));
        L_sig.setText(">");
        PrivacidadTabPane.add(L_sig, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 250, 20, 50));

        TusPostBtn.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        TusPostBtn.setForeground(new java.awt.Color(204, 204, 204));
        TusPostBtn.setText("<html><p style=\"font-size: 12px; padding:  0px 0px 0px 30px;\"> Tus publicaciones</p> <br> <p style=\"font-size: 9 px; padding: 0px 0px 0px 30px; color: rgba(255,255,255,0.5);\"> Administra la información asociada a tus publicaciones</p>  </html>");
        TusPostBtn.setBorderPainted(false);
        TusPostBtn.setContentAreaFilled(false);
        TusPostBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        TusPostBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TusPostBtnActionPerformed(evt);
            }
        });
        PrivacidadTabPane.add(TusPostBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 580, 60));

        L_sig_tusPosts.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        L_sig_tusPosts.setForeground(new java.awt.Color(255, 255, 255));
        L_sig_tusPosts.setText(">");
        PrivacidadTabPane.add(L_sig_tusPosts, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 110, 20, 50));

        ContenidoVesBtn.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        ContenidoVesBtn.setForeground(new java.awt.Color(204, 204, 204));
        ContenidoVesBtn.setText("<html><p style=\"font-size: 12px; padding:  0px 0px 0px 30px;\"> Contenido que ves</p>\n<br> <p style=\"font-size: 9 px; padding: 0px 0px 0px 30px; color: rgba(255,255,255,0.5);\"> Decide lo que ves en Y según tus preferencias, como temas e intereses.</p>\n </html>");
        ContenidoVesBtn.setBorderPainted(false);
        ContenidoVesBtn.setContentAreaFilled(false);
        ContenidoVesBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ContenidoVesBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContenidoVesBtnActionPerformed(evt);
            }
        });
        PrivacidadTabPane.add(ContenidoVesBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 630, 60));

        L_sig_ContVes.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        L_sig_ContVes.setForeground(new java.awt.Color(255, 255, 255));
        L_sig_ContVes.setText(">");
        PrivacidadTabPane.add(L_sig_ContVes, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 180, 20, 50));

        JPanelGeneraPanel.addTab("Privacidad", PrivacidadTabPane);

        NotificacionesTabPane.setBackground(new java.awt.Color(0, 0, 0));
        NotificacionesTabPane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        L_PS_Title1.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        L_PS_Title1.setForeground(new java.awt.Color(204, 204, 204));
        L_PS_Title1.setText("Notificaciones");
        NotificacionesTabPane.add(L_PS_Title1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 25, 300, -1));

        jLabel46.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(204, 204, 204));
        jLabel46.setText("Selecciona los tipos de notificaciones que recibes sobre tus actividades, intereses y recomendaciones.");
        jLabel46.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        NotificacionesTabPane.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, 560, 30));

        PreferenciasBtn.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        PreferenciasBtn.setForeground(new java.awt.Color(204, 204, 204));
        PreferenciasBtn.setText("<html><p style=\"font-size: 12px; padding:  0px 0px 0px 30px;\">Preferencias</p> <br> <p style=\"font-size: 9 px; padding: 0px 0px 0px 30px; color: rgba(255,255,255,0.5);\">Seleccione sus preferencias por tipo de notificación.</p>  </html>");
        PreferenciasBtn.setBorderPainted(false);
        PreferenciasBtn.setContentAreaFilled(false);
        PreferenciasBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        PreferenciasBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PreferenciasBtnActionPerformed(evt);
            }
        });
        NotificacionesTabPane.add(PreferenciasBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 640, 60));

        FiltrosNotConfBtn.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        FiltrosNotConfBtn.setForeground(new java.awt.Color(204, 204, 204));
        FiltrosNotConfBtn.setText("<html><p style=\"font-size: 12px; padding:  0px 0px 0px 30px;\"> Filtros</p> <br> <p style=\"font-size: 9 px; padding: 0px 0px 0px 30px; color: rgba(255,255,255,0.5);\">Elige las notificaciones que deseas ver y las que no.</p>  </html>");
        FiltrosNotConfBtn.setBorderPainted(false);
        FiltrosNotConfBtn.setContentAreaFilled(false);
        FiltrosNotConfBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        FiltrosNotConfBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FiltrosNotConfBtnActionPerformed(evt);
            }
        });
        NotificacionesTabPane.add(FiltrosNotConfBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 580, 60));

        L_sig_pref.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        L_sig_pref.setForeground(new java.awt.Color(255, 255, 255));
        L_sig_pref.setText(">");
        NotificacionesTabPane.add(L_sig_pref, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 180, 20, 50));

        L_sig_filtros.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        L_sig_filtros.setForeground(new java.awt.Color(255, 255, 255));
        L_sig_filtros.setText(">");
        NotificacionesTabPane.add(L_sig_filtros, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 110, 20, 50));

        JPanelGeneraPanel.addTab("Notificaciones", NotificacionesTabPane);

        TusPostTabPane.setBackground(new java.awt.Color(0, 0, 0));
        TusPostTabPane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        L_PS_Title2.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        L_PS_Title2.setForeground(new java.awt.Color(204, 204, 204));
        L_PS_Title2.setText("Tus publicaciones");
        TusPostTabPane.add(L_PS_Title2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, 300, -1));

        jLabel48.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(204, 204, 204));
        jLabel48.setText("Administra la información asociada a tus publicaciones.");
        jLabel48.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        TusPostTabPane.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 510, 30));

        jCheckBox1.setForeground(new java.awt.Color(204, 204, 204));
        jCheckBox1.setText("<html>         \n<p style=\"font-size: 11px; padding:  0px 0px 0px 30px;\">Marca los medios que publicas como que tienen material que puede ser confidencial</p>\n<br> <p style=\"font-size: 8px; padding: -1px -1px -1px 30px; color: rgba(255,255,255,0.5);\">Cuando esta opción está habilitada, las imágenes y los videos que publiques se marcarán \n<br>como confidenciales para las personas que no quieran ver contenido confidencial.</p>\n</html>");
        jCheckBox1.setContentAreaFilled(false);
        jCheckBox1.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        jCheckBox1.setIconTextGap(70);
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        TusPostTabPane.add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 620, -1));

        AnadeInfBtn.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        AnadeInfBtn.setForeground(new java.awt.Color(204, 204, 204));
        AnadeInfBtn.setText("Añade información de ubicación a tus publicaciones\n ");
        AnadeInfBtn.setBorderPainted(false);
        AnadeInfBtn.setContentAreaFilled(false);
        AnadeInfBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        AnadeInfBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnadeInfBtnActionPerformed(evt);
            }
        });
        TusPostTabPane.add(AnadeInfBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, 530, 60));

        AtrasTPostBtn.setBackground(new java.awt.Color(204, 204, 204));
        AtrasTPostBtn.setFont(new java.awt.Font("Roboto Mono ExtraLight", 0, 24)); // NOI18N
        AtrasTPostBtn.setForeground(new java.awt.Color(255, 255, 255));
        AtrasTPostBtn.setBorderPainted(false);
        AtrasTPostBtn.setContentAreaFilled(false);
        AtrasTPostBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AtrasTPostBtnActionPerformed(evt);
            }
        });
        TusPostTabPane.add(AtrasTPostBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 50, 40));

        L_sig_AddInfPo.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        L_sig_AddInfPo.setForeground(new java.awt.Color(255, 255, 255));
        L_sig_AddInfPo.setText(">");
        TusPostTabPane.add(L_sig_AddInfPo, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 190, 20, 50));

        JPanelGeneraPanel.addTab("Tus Posts", TusPostTabPane);

        ContVesTabPane.setBackground(new java.awt.Color(0, 0, 0));
        ContVesTabPane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        L_PS_Title3.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        L_PS_Title3.setForeground(new java.awt.Color(204, 204, 204));
        L_PS_Title3.setText("Contenido que ves");
        ContVesTabPane.add(L_PS_Title3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 300, -1));

        jLabel50.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(204, 204, 204));
        jLabel50.setText("Decide lo que ves en Y según tus preferencias, como temas e intereses.");
        jLabel50.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        ContVesTabPane.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, 510, 30));

        TemasBtn.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        TemasBtn.setForeground(new java.awt.Color(204, 204, 204));
        TemasBtn.setText("Temas");
        TemasBtn.setBorderPainted(false);
        TemasBtn.setContentAreaFilled(false);
        TemasBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        TemasBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TemasBtnActionPerformed(evt);
            }
        });
        ContVesTabPane.add(TemasBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 600, 60));

        InteresesBtn.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        InteresesBtn.setForeground(new java.awt.Color(204, 204, 204));
        InteresesBtn.setText("Intereses ");
        InteresesBtn.setBorderPainted(false);
        InteresesBtn.setContentAreaFilled(false);
        InteresesBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        InteresesBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InteresesBtnActionPerformed(evt);
            }
        });
        ContVesTabPane.add(InteresesBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 600, 60));

        ExpoConfigBtn.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        ExpoConfigBtn.setForeground(new java.awt.Color(204, 204, 204));
        ExpoConfigBtn.setText("Explorar configuraciones ");
        ExpoConfigBtn.setBorderPainted(false);
        ExpoConfigBtn.setContentAreaFilled(false);
        ExpoConfigBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ExpoConfigBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExpoConfigBtnActionPerformed(evt);
            }
        });
        ContVesTabPane.add(ExpoConfigBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 600, 60));

        BusqConfigBtn.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        BusqConfigBtn.setForeground(new java.awt.Color(204, 204, 204));
        BusqConfigBtn.setText("Configuración de búsqueda");
        BusqConfigBtn.setBorderPainted(false);
        BusqConfigBtn.setContentAreaFilled(false);
        BusqConfigBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BusqConfigBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BusqConfigBtnActionPerformed(evt);
            }
        });
        ContVesTabPane.add(BusqConfigBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 600, 60));

        jCheckBox2.setBackground(new java.awt.Color(0, 0, 0));
        jCheckBox2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jCheckBox2.setForeground(new java.awt.Color(204, 204, 204));
        jCheckBox2.setText("Mostrar medios que puedan contener contenido sensible");
        jCheckBox2.setContentAreaFilled(false);
        jCheckBox2.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        jCheckBox2.setIconTextGap(230);
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });
        ContVesTabPane.add(jCheckBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 620, -1));

        AtrasContVesBtn.setBackground(new java.awt.Color(204, 204, 204));
        AtrasContVesBtn.setFont(new java.awt.Font("Roboto Mono ExtraLight", 0, 24)); // NOI18N
        AtrasContVesBtn.setForeground(new java.awt.Color(255, 255, 255));
        AtrasContVesBtn.setBorderPainted(false);
        AtrasContVesBtn.setContentAreaFilled(false);
        AtrasContVesBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AtrasContVesBtnActionPerformed(evt);
            }
        });
        ContVesTabPane.add(AtrasContVesBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 50, 40));

        L_sig_CSTemas.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        L_sig_CSTemas.setForeground(new java.awt.Color(255, 255, 255));
        L_sig_CSTemas.setText(">");
        ContVesTabPane.add(L_sig_CSTemas, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 140, 20, 50));

        L_sig_CSExplorarC.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        L_sig_CSExplorarC.setForeground(new java.awt.Color(255, 255, 255));
        L_sig_CSExplorarC.setText(">");
        ContVesTabPane.add(L_sig_CSExplorarC, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 200, 20, 50));

        L_sig_CSInte.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        L_sig_CSInte.setForeground(new java.awt.Color(255, 255, 255));
        L_sig_CSInte.setText(">");
        ContVesTabPane.add(L_sig_CSInte, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 260, 20, 50));

        L_sig_CSConfigBus.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        L_sig_CSConfigBus.setForeground(new java.awt.Color(255, 255, 255));
        L_sig_CSConfigBus.setText(">");
        ContVesTabPane.add(L_sig_CSConfigBus, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 320, 20, 50));

        JPanelGeneraPanel.addTab("Contenido que ves", ContVesTabPane);

        jPanel1.add(JPanelGeneraPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 0, 670, 820));

        CuentaBtn.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        CuentaBtn.setForeground(new java.awt.Color(204, 204, 204));
        CuentaBtn.setText("  Cuenta");
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
        jPanel1.add(CuentaBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 110, 450, 50));

        NotiFicacionesBtn.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        NotiFicacionesBtn.setForeground(new java.awt.Color(204, 204, 204));
        NotiFicacionesBtn.setText("  Notificaciones ");
        NotiFicacionesBtn.setToolTipText("");
        NotiFicacionesBtn.setBorder(null);
        NotiFicacionesBtn.setBorderPainted(false);
        NotiFicacionesBtn.setContentAreaFilled(false);
        NotiFicacionesBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        NotiFicacionesBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        NotiFicacionesBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NotiFicacionesBtnActionPerformed(evt);
            }
        });
        jPanel1.add(NotiFicacionesBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 260, 450, 50));
        jPanel1.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 260, 450, 10));

        SeguridadYAccesoBtn.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        SeguridadYAccesoBtn.setForeground(new java.awt.Color(204, 204, 204));
        SeguridadYAccesoBtn.setText("  Seguridad y acceso a la cuenta ");
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
        jPanel1.add(SeguridadYAccesoBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 160, 450, 50));
        jPanel1.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 160, 450, 10));

        PrivacidadYSeguridadBtn.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        PrivacidadYSeguridadBtn.setForeground(new java.awt.Color(204, 204, 204));
        PrivacidadYSeguridadBtn.setText("  Privacidad y seguridad ");
        PrivacidadYSeguridadBtn.setToolTipText("");
        PrivacidadYSeguridadBtn.setBorder(null);
        PrivacidadYSeguridadBtn.setBorderPainted(false);
        PrivacidadYSeguridadBtn.setContentAreaFilled(false);
        PrivacidadYSeguridadBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PrivacidadYSeguridadBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        PrivacidadYSeguridadBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrivacidadYSeguridadBtnActionPerformed(evt);
            }
        });
        jPanel1.add(PrivacidadYSeguridadBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 210, 450, 50));

        ConBus.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        ConBus.setForeground(new java.awt.Color(153, 153, 153));
        ConBus.setText("Configuracion de Busqueda");
        jPanel1.add(ConBus, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 60, -1, -1));

        Buscador.setBackground(new java.awt.Color(0, 0, 0));
        Buscador.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        Buscador.setForeground(new java.awt.Color(204, 204, 204));
        Buscador.setBorder(null);
        Buscador.setHighlighter(null);
        Buscador.setVerifyInputWhenFocusTarget(false);
        Buscador.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                BuscadorMouseDragged(evt);
            }
        });
        Buscador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BuscadorMouseClicked(evt);
            }
        });
        Buscador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BuscadorKeyPressed(evt);
            }
        });
        jPanel1.add(Buscador, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 50, 320, 40));

        BuscarBtn.setBackground(new java.awt.Color(0, 0, 0));
        BuscarBtn.setForeground(new java.awt.Color(204, 204, 204));
        BuscarBtn.setText("Buscar");
        BuscarBtn.setBorderPainted(false);
        BuscarBtn.setContentAreaFilled(false);
        jPanel1.add(BuscarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 50, -1, 40));
        jPanel1.add(BuscadorImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 50, 40, 40));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 90, 420, 10));

        Sig3.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        Sig3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(Sig3, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 112, 20, 50));

        Sig2.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        Sig2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(Sig2, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 260, 20, 50));

        Sig4.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        Sig4.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(Sig4, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 160, 20, 50));

        Sig5.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        Sig5.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(Sig5, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 210, 20, 50));

        ConfiBtn.setBackground(new java.awt.Color(26, 26, 29));
        ConfiBtn.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
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
        jPanel1.add(ConfiBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 500, 260, 40));

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
        jPanel1.add(InicioBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 250, 40));

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
        jPanel1.add(ComunidadesBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 320, 250, 40));

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
        jPanel1.add(GuardadoBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 380, 250, 40));

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
        jPanel1.add(PerfilBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 440, 250, 40));

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

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1550, 820));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PostearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PostearBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PostearBtnActionPerformed

    private void CuentaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CuentaBtnActionPerformed
        JPanelGeneraPanel.setSelectedIndex(0);
    }//GEN-LAST:event_CuentaBtnActionPerformed

    //Notificaciones del JTabbedPanel
    private void NotiFicacionesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NotiFicacionesBtnActionPerformed
        JPanelGeneraPanel.setSelectedIndex(6);
    }//GEN-LAST:event_NotiFicacionesBtnActionPerformed

    private void SeguridadYAccesoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeguridadYAccesoBtnActionPerformed
        JPanelGeneraPanel.setSelectedIndex(4);
    }//GEN-LAST:event_SeguridadYAccesoBtnActionPerformed

    //Privacidad y seguridad
    private void PrivacidadYSeguridadBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrivacidadYSeguridadBtnActionPerformed
        // TODO add your handling code here:
        JPanelGeneraPanel.setSelectedIndex(5);
    }//GEN-LAST:event_PrivacidadYSeguridadBtnActionPerformed

    private void BuscadorMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BuscadorMouseDragged

    }//GEN-LAST:event_BuscadorMouseDragged

    private void BuscadorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BuscadorMouseClicked
        ConBus.setVisible(false);
    }//GEN-LAST:event_BuscadorMouseClicked

    private void BuscadorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BuscadorKeyPressed

        //Declaracion de variables para que el boton del buscador sea en tiempo real
        var busc = Buscador.getText();
        int bus = busc.length();
        //Comprobacion, si tiene algo se mostrara
        if (bus != 0) {
            BuscarBtn.setVisible(true);
        } //Si es igual que 0, o nada se ocultara
        else {
            BuscarBtn.setVisible(false);
        }
        System.out.println("no");

    }//GEN-LAST:event_BuscadorKeyPressed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void BusqConfigBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BusqConfigBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BusqConfigBtnActionPerformed

    private void ExpoConfigBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExpoConfigBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ExpoConfigBtnActionPerformed

    private void InteresesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InteresesBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InteresesBtnActionPerformed

    private void TemasBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TemasBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TemasBtnActionPerformed

    private void AnadeInfBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnadeInfBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AnadeInfBtnActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void FiltrosNotConfBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FiltrosNotConfBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FiltrosNotConfBtnActionPerformed

    private void PreferenciasBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PreferenciasBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PreferenciasBtnActionPerformed

    private void ContenidoVesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContenidoVesBtnActionPerformed
        // TODO add your handling code here:
        JPanelGeneraPanel.setSelectedIndex(8);
    }//GEN-LAST:event_ContenidoVesBtnActionPerformed

    private void TusPostBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TusPostBtnActionPerformed
        // TODO add your handling code here:
        JPanelGeneraPanel.setSelectedIndex(7);
    }//GEN-LAST:event_TusPostBtnActionPerformed

    private void SilenciarYBloquearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SilenciarYBloquearBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SilenciarYBloquearBtnActionPerformed

    private void ContraseñaActualizadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContraseñaActualizadaActionPerformed
        //Icono EnviarContraseñaVerde
        String url16 = "src\\main\\java\\Multimedia\\Listo_Verde.png";
        ImageIcon image16 = new ImageIcon(url16);
        Image img16 = image16.getImage().getScaledInstance(24, 24, 0);
        ImageIcon Icono16 = new ImageIcon(img16);
        ContraseñaActualizada.setIcon(Icono16);
    }//GEN-LAST:event_ContraseñaActualizadaActionPerformed

    private void ConfirmarContraseñaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ConfirmarContraseñaKeyReleased

        //LLamamos al metodo
        VerificarCambioContraseña();
        //Definimos variables
        String ContraseñaNueva = ContraseñaNueva1.getText();
        String ContraseñaCambio = ConfirmarContraseña.getText();
        //Comprovamos la diferencia entre el cambio y la confirmacion
        if (!ContraseñaNueva.equals(ContraseñaCambio)) {
            ContraseñaActualizada.setVisible(false);
        }
    }//GEN-LAST:event_ConfirmarContraseñaKeyReleased

    private void ConfirmarContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmarContraseñaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ConfirmarContraseñaActionPerformed

    private void ConfirmarContraseñaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ConfirmarContraseñaMouseClicked
        ConfirmarContraseña.setText("");
    }//GEN-LAST:event_ConfirmarContraseñaMouseClicked

    private void ContraseñaNueva1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ContraseñaNueva1MouseClicked
        ContraseñaNueva1.setText("");
    }//GEN-LAST:event_ContraseñaNueva1MouseClicked

    private void EnviarContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EnviarContraseñaActionPerformed
        ControlContraseñaNueva();
    }//GEN-LAST:event_EnviarContraseñaActionPerformed

    private void ContraseñaActualMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ContraseñaActualMouseClicked
        ContraseñaActual.setText("");
    }//GEN-LAST:event_ContraseñaActualMouseClicked

    private void AtrasBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AtrasBtn2ActionPerformed
        JPanelGeneraPanel.setSelectedIndex(0);
    }//GEN-LAST:event_AtrasBtn2ActionPerformed

    private void Save_Icono2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Save_Icono2ActionPerformed
     
        //Icono Banderas Mexico
        String Ban1 = "src\\main\\java\\Multimedia\\Icono_Bandera_Mexico.png";
        ImageIcon imageBan1 = new ImageIcon(Ban1);
        Image imgBan1 = imageBan1.getImage().getScaledInstance(16, 16, 0);
        ImageIcon IconoBan1 = new ImageIcon(imgBan1);
       
        
        //Icono Banderas Estados Unidos
        String Ban2 = "src\\main\\java\\Multimedia\\Icono_Bandera_USA.png";
        ImageIcon imageBan2 = new ImageIcon(Ban2);
        Image imgBan2 = imageBan2.getImage().getScaledInstance(24, 24, 0);
        ImageIcon IconoBan2 = new ImageIcon(imgBan2);
       
        
        //Declaramos Variables
        String Telefono = TelefonoLabel.getText();
        String TelefonoCambio = TelefonoEditar.getText();
        
        int Defecto = Pais.getSelectedIndex();
        //Comprobamos si es diferente a el nombre anterior
        if (!Telefono.equals(TelefonoCambio) 
                && Pais.getSelectedIndex() == Defecto){
            //Ocultamos panel de edicion
            EditarPanel2.setVisible(false);
            //Mostramos el boton de edicion
            Editar2.setVisible(true);
            //Guardamos Nuevo Valor
            TelefonoLabel.setText(TelefonoCambio);
            //Esta comprobacion depende de que valor entre 0 y 1 tome dependiendo es este (Valor obtenido de comboBox)
            //Cambiara el icono de la bandera
            if(Pais.getSelectedIndex()==1){
            BanderaLabel.setIcon(IconoBan1);
            }else if(Pais.getSelectedIndex()==2){
                BanderaLabel.setIcon(IconoBan2);
            }
        } else{
            //En caso de que no se pueda, mandara un mensaje a consola
            System.err.println("No se puede hacer el cambio ya que es igual");
        }
    }//GEN-LAST:event_Save_Icono2ActionPerformed

    private void TelefonoEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TelefonoEditarActionPerformed
        
    }//GEN-LAST:event_TelefonoEditarActionPerformed

    private void Editar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Editar2ActionPerformed
        //Mostramos panel de edicion
        EditarPanel2.setVisible(true);
        //Declaramos Variables
        String Telefono = TelefonoLabel.getText();
        //Traemos el nombre antiguo
        TelefonoEditar.setText(Telefono);
        //Ocultamos el boton de edicion
        Editar2.setVisible(false);

    }//GEN-LAST:event_Editar2ActionPerformed

    private void Editar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Editar3ActionPerformed
        //Mostramos panel de edicion
        EditarPanel3.setVisible(true);
        //Declaramos Variables
        String Correo = CorreoLabel.getText();
        //Traemos el nombre antiguo
        CorreoEditar.setText(Correo);
        //Ocultamos el boton de edicion
        Editar3.setVisible(false);
    }//GEN-LAST:event_Editar3ActionPerformed

    private void Save_Icono1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Save_Icono1ActionPerformed

//Declaramos Variables
        String Usuario = UsuarioLabel.getText();
        String UsuarioCambio = NombreUsuarioEditar.getText();
        //Comprobamos si es diferente a el nombre anterior
        if (!Usuario.equals(UsuarioCambio)) {
            //Colocamos el nuevo nombre de usuario en el label
            UsuarioLabel.setText(UsuarioCambio);
            //Ocultamos panel de edicion
            EditarPanel1.setVisible(false);
            //Mostramos el boton de edicion
            Editar1.setVisible(true);
        } else {
            System.err.println("No se puede hacer el cambio ya que es igual");
        }

    }//GEN-LAST:event_Save_Icono1ActionPerformed

    private void NombreUsuarioEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NombreUsuarioEditarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NombreUsuarioEditarActionPerformed

    private void Editar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Editar1ActionPerformed
        //Mostramos panel de edicion
        EditarPanel1.setVisible(true);
        //Declaramos Variables
        String Usuario = UsuarioLabel.getText();
        //Traemos el nombre antiguo
        NombreUsuarioEditar.setText(Usuario);
        //Ocultamos el boton de edicion
        Editar1.setVisible(false);

    }//GEN-LAST:event_Editar1ActionPerformed

    private void AtrasBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AtrasBtnActionPerformed
        JPanelGeneraPanel.setSelectedIndex(0);
    }//GEN-LAST:event_AtrasBtnActionPerformed

    private void DesactivarCuentaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DesactivarCuentaBtnActionPerformed
        JPanelGeneraPanel.setSelectedIndex(3);
    }//GEN-LAST:event_DesactivarCuentaBtnActionPerformed

    private void InfCuentaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InfCuentaBtnActionPerformed
        JPanelGeneraPanel.setSelectedIndex(1);
    }//GEN-LAST:event_InfCuentaBtnActionPerformed

    private void CambiarPassBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CambiarPassBtnActionPerformed
        JPanelGeneraPanel.setSelectedIndex(2);
    }//GEN-LAST:event_CambiarPassBtnActionPerformed

    private void Sig6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Sig6MouseClicked
        JPanelGeneraPanel.setSelectedIndex(3);
    }//GEN-LAST:event_Sig6MouseClicked

    private void PaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PaisActionPerformed
            if(Pais.getSelectedIndex()==0){
            System.err.println("0");
            }else if(Pais.getSelectedIndex()==1){
                System.out.println("1");
            }
    }//GEN-LAST:event_PaisActionPerformed

    private void CorreoEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CorreoEditarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CorreoEditarActionPerformed

    private void Save_Icono3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Save_Icono3ActionPerformed
       
        //Declaramos Variables
        String Correo = CorreoLabel.getText();
        String CorreoCambio = CorreoEditar.getText();
        //Comprobamos si es diferente a el nombre anterior
        if (!Correo.equals(CorreoCambio)) {
            //Colocamos el nuevo nombre de usuario en el label
            CorreoLabel.setText(CorreoCambio);
            //Ocultamos panel de edicion
            EditarPanel3.setVisible(false);
            //Mostramos el boton de edicion
            Editar3.setVisible(true);
        } else {
            System.err.println("No se puede hacer el cambio ya que es igual");
        }

    }//GEN-LAST:event_Save_Icono3ActionPerformed

    private void Editar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Editar4ActionPerformed
         //Mostramos panel de edicion
        EditarPanel4.setVisible(true);
        //Ocultamos el boton de edicion
        Editar4.setVisible(false);
    }//GEN-LAST:event_Editar4ActionPerformed

    private void Save_Icono4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Save_Icono4ActionPerformed

        
        //Icono Banderas Mexico
        String Ban1 = "src\\main\\java\\Multimedia\\Icono_Bandera_Mexico.png";
        ImageIcon imageBan1 = new ImageIcon(Ban1);
        Image imgBan1 = imageBan1.getImage().getScaledInstance(16, 16, 0);
        ImageIcon IconoBan1 = new ImageIcon(imgBan1);
       
        
        //Icono Banderas Estados Unidos
        String Ban2 = "src\\main\\java\\Multimedia\\Icono_Bandera_USA.png";
        ImageIcon imageBan2 = new ImageIcon(Ban2);
        Image imgBan2 = imageBan2.getImage().getScaledInstance(24, 24, 0);
        ImageIcon IconoBan2 = new ImageIcon(imgBan2);
       
        //Declaramos variables 
        int PaisSelect = PaisComboBox.getSelectedIndex();
        
        //Esta comprobacion depende de que valor entre 0,1 y 2 tome dependiendo es este (Valor obtenido de comboBox)
        //Cambiara el icono de la bandera
        //Cambiar a swich para mas paises//
        switch (PaisSelect) {
            case 1:
                BanderaLabel1.setIcon(IconoBan1);
                PaisLabel.setText("Mexico");
                 //Ocultamos panel de edicion
        EditarPanel4.setVisible(false);
        //Mostramos el boton de edicion
        Editar4.setVisible(true);
                break;
            case 2:
                BanderaLabel1.setIcon(IconoBan2);
                PaisLabel.setText("Estados Unidos");
                 //Ocultamos panel de edicion
        EditarPanel4.setVisible(false);
        //Mostramos el boton de edicion
        Editar4.setVisible(true);
                break;
            default:
                BanderaLabel1.setIcon(null);
                PaisLabel.setText("Indefinido");
                EditarPanel4.setVisible(false);
                //Mostramos el boton de edicion
                Editar4.setVisible(true);
                break;
        }
       
        
    }//GEN-LAST:event_Save_Icono4ActionPerformed

    private void Editar5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Editar5ActionPerformed
        //Mostramos panel de edicion
        EditarPanel5.setVisible(true);
        //Ocultamos el boton de edicion
        Editar5.setVisible(false);
    }//GEN-LAST:event_Editar5ActionPerformed

    private void Editar6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Editar6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Editar6ActionPerformed

    private void ContraseñaActualKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ContraseñaActualKeyReleased
         //Icono EnviarContraseñaVerde
        String url16 = "src\\main\\java\\Multimedia\\Listo_Verde.png";
        ImageIcon image16 = new ImageIcon(url16);
        Image img16 = image16.getImage().getScaledInstance(24, 24, 0);
        ImageIcon Icono16 = new ImageIcon(img16);
        //Icono enviar Contraseña gris
        String url15 = "src\\main\\java\\Multimedia\\Listo_Gris.png";
        ImageIcon image15 = new ImageIcon(url15);
        Image img15 = image15.getImage().getScaledInstance(24, 24, 0);
        ImageIcon Icono15 = new ImageIcon(img15);
        //Obtenemos el valor de contraseña actual
        String Con = ContraseñaActual.getText();
        //Contamos los caracteres
        int contra = Con.length();
        //Comprobamos que sea diferente a 0
        if(contra != 0){
            //Ponemos icono verde
            EnviarContraseña.setIcon(Icono16);
        } else {
            //Ponemos icono Gris
        EnviarContraseña.setIcon(Icono15);
        }
    }//GEN-LAST:event_ContraseñaActualKeyReleased

    private void Save_Icono5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Save_Icono5ActionPerformed
        //Obtenemos el texto de combo box
        String Genero = GeneroComboBox.getSelectedItem().toString();
        //Obtenemos el index del combo box
        int GeneroSelected = GeneroComboBox.getSelectedIndex();
        //Serie de intruscciones dependiendo de cual sea la opcion elegida
        switch (GeneroSelected){
            
            case 0:
                //Ocultamos el panel
                EditarPanel5.setVisible(false);
                //Mostramos icono de Edicion
                Editar5.setVisible(true);
                //Obtenemos el texto del genero seleccionado
                GeneroLabel.setText(Genero);
                break;
            
            case 1: 
                //Ocultamos el panel
                EditarPanel5.setVisible(false);
                //Mostramos icono de Edicion
                Editar5.setVisible(true);
                //Obtenemos el texto del genero seleccionado
                GeneroLabel.setText(Genero);
                break;
            
            case 2:
                //Ocultamos el panel
                EditarPanel5.setVisible(false);
                //Mostramos icono de Edicion
                Editar5.setVisible(true);
                //Obtenemos el texto del genero seleccionado
                GeneroLabel.setText(Genero);
                break;
                
            case 3:
                //Ocultamos el panel
                EditarPanel5.setVisible(false);
                //Mostramos icono de Edicion
                Editar5.setVisible(true);
                //Obtenemos el texto del genero seleccionado
                String GeneroUsuario = DefinirGenero.getText();
                //Mostramos el recuadro de texto
                GeneroLabel.setText(GeneroUsuario);
                break;
                
            default:
                //Obtenemos el texto del genero seleccionado
                GeneroLabel.setText("Indefinido");
                break;
            
            
        }
        
    }//GEN-LAST:event_Save_Icono5ActionPerformed

    private void GeneroComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GeneroComboBoxActionPerformed
        //Obtenemos el index del combo box
        int GeneroSelected = GeneroComboBox.getSelectedIndex();
        if (GeneroSelected==3){
            DefinirGenero.setVisible(true);   
        }else{
            DefinirGenero.setVisible(false);
        }
    }//GEN-LAST:event_GeneroComboBoxActionPerformed

    private void DefinirGeneroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DefinirGeneroMouseClicked
        DefinirGenero.setText("");
    }//GEN-LAST:event_DefinirGeneroMouseClicked

    private void AtrasBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AtrasBtn1ActionPerformed
        JPanelGeneraPanel.setSelectedIndex(0);
    }//GEN-LAST:event_AtrasBtn1ActionPerformed

    private void DesactivarBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DesactivarBtnMouseEntered
        //Para el cambio de color de fondo cuando el mouse entre en el elemento
        DesactivarBtn.setContentAreaFilled(true);
    }//GEN-LAST:event_DesactivarBtnMouseEntered

    private void DesactivarBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DesactivarBtnMouseExited
        //Para el cambio de color de fondo cuando el mouse salga del elemento
        DesactivarBtn.setContentAreaFilled(false);
    }//GEN-LAST:event_DesactivarBtnMouseExited

    private void Sig9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Sig9MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Sig9MouseClicked

    private void AtrasContVesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AtrasContVesBtnActionPerformed
        // TODO add your handling code here:
        JPanelGeneraPanel.setSelectedIndex(5);
    }//GEN-LAST:event_AtrasContVesBtnActionPerformed

    private void AtrasTPostBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AtrasTPostBtnActionPerformed
        // TODO add your handling code here:
        JPanelGeneraPanel.setSelectedIndex(5);
    }//GEN-LAST:event_AtrasTPostBtnActionPerformed

    private void ContraseñaActualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContraseñaActualActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ContraseñaActualActionPerformed

    private void ContraseñaNueva1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContraseñaNueva1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ContraseñaNueva1ActionPerformed

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
        new Guardados().setVisible(true);
    }//GEN-LAST:event_GuardadoBtnActionPerformed

    private void PerfilBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PerfilBtnActionPerformed
        this.dispose();
        new Perfil().setVisible(true);
    }//GEN-LAST:event_PerfilBtnActionPerformed

    private void ExplorarBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExplorarBtn1ActionPerformed
        this.dispose();
        new Explorar().setVisible(true);
    }//GEN-LAST:event_ExplorarBtn1ActionPerformed

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
            java.util.logging.Logger.getLogger(Configuracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Configuracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Configuracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Configuracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Configuracion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AnadeInfBtn;
    private javax.swing.JButton AtrasBtn;
    private javax.swing.JButton AtrasBtn1;
    private javax.swing.JButton AtrasBtn2;
    private javax.swing.JButton AtrasContVesBtn;
    private javax.swing.JButton AtrasTPostBtn;
    private javax.swing.JLabel BanderaLabel;
    private javax.swing.JLabel BanderaLabel1;
    private javax.swing.JTextField Buscador;
    private javax.swing.JLabel BuscadorImagen;
    private javax.swing.JButton BuscarBtn;
    private javax.swing.JButton BusqConfigBtn;
    private javax.swing.JButton CambiarPassBtn;
    private javax.swing.JPanel CambioContraseña;
    private javax.swing.JButton ComunidadesBtn;
    private javax.swing.JLabel ConBus;
    private javax.swing.JButton ConfiBtn;
    private javax.swing.JTextField ConfirmarContraseña;
    private javax.swing.JPanel ContVesTabPane;
    private javax.swing.JButton ContenidoVesBtn;
    private javax.swing.JTextField ContraseñaActual;
    private javax.swing.JButton ContraseñaActualizada;
    private javax.swing.JTextField ContraseñaNueva1;
    private javax.swing.JTextField CorreoEditar;
    private javax.swing.JLabel CorreoLabel;
    private javax.swing.JButton CuentaBtn;
    private javax.swing.JTextField DefinirGenero;
    private javax.swing.JButton DesactivarBtn;
    private javax.swing.JButton DesactivarCuentaBtn;
    private javax.swing.JPanel DesactivarPanel;
    private javax.swing.JButton Editar1;
    private javax.swing.JButton Editar2;
    private javax.swing.JButton Editar3;
    private javax.swing.JButton Editar4;
    private javax.swing.JButton Editar5;
    private javax.swing.JButton Editar6;
    private javax.swing.JPanel EditarPanel1;
    private javax.swing.JPanel EditarPanel2;
    private javax.swing.JPanel EditarPanel3;
    private javax.swing.JPanel EditarPanel4;
    private javax.swing.JPanel EditarPanel5;
    private javax.swing.JButton EnviarContraseña;
    private javax.swing.JButton ExplorarBtn1;
    private javax.swing.JButton ExpoConfigBtn;
    private javax.swing.JButton FiltrosNotConfBtn;
    private javax.swing.JLabel FotoPerfil;
    private javax.swing.JComboBox<String> GeneroComboBox;
    private javax.swing.JLabel GeneroLabel;
    private javax.swing.JButton GuardadoBtn;
    private javax.swing.JLabel IdUsuario;
    private javax.swing.JLabel IdUsuario1;
    private javax.swing.JPanel InfCuenta;
    private javax.swing.JButton InfCuentaBtn;
    private javax.swing.JPanel InformacionCuentaPanel;
    private javax.swing.JButton InicioBtn1;
    private javax.swing.JButton InteresesBtn;
    private javax.swing.JTabbedPane JPanelGeneraPanel;
    private javax.swing.JLabel L_PS_Title;
    private javax.swing.JLabel L_PS_Title1;
    private javax.swing.JLabel L_PS_Title2;
    private javax.swing.JLabel L_PS_Title3;
    private javax.swing.JLabel L_sig;
    private javax.swing.JLabel L_sig_AddInfPo;
    private javax.swing.JLabel L_sig_CSConfigBus;
    private javax.swing.JLabel L_sig_CSExplorarC;
    private javax.swing.JLabel L_sig_CSInte;
    private javax.swing.JLabel L_sig_CSTemas;
    private javax.swing.JLabel L_sig_ContVes;
    private javax.swing.JLabel L_sig_filtros;
    private javax.swing.JLabel L_sig_pref;
    private javax.swing.JLabel L_sig_tusPosts;
    private javax.swing.JLabel NombreUsuario;
    private javax.swing.JLabel NombreUsuario1;
    private javax.swing.JTextField NombreUsuarioEditar;
    private javax.swing.JButton NotiFicacionesBtn;
    private javax.swing.JButton NotificacionesBtn;
    private javax.swing.JPanel NotificacionesTabPane;
    private javax.swing.JComboBox<String> Pais;
    private javax.swing.JComboBox<String> PaisComboBox;
    private javax.swing.JLabel PaisLabel;
    private javax.swing.JPanel PanelCuenta;
    private javax.swing.JPanel PassPanel;
    private javax.swing.JButton PerfilBtn;
    private javax.swing.JPanel PerfilPanel;
    private javax.swing.JLabel Perfil_Img;
    private javax.swing.JButton PostearBtn;
    private javax.swing.JButton PreferenciasBtn;
    private javax.swing.JPanel PrivacidadTabPane;
    private javax.swing.JButton PrivacidadYSeguridadBtn;
    private javax.swing.JButton Save_Icono1;
    private javax.swing.JButton Save_Icono2;
    private javax.swing.JButton Save_Icono3;
    private javax.swing.JButton Save_Icono4;
    private javax.swing.JButton Save_Icono5;
    private javax.swing.JPanel SeguridadPanel;
    private javax.swing.JButton SeguridadYAccesoBtn;
    private javax.swing.JLabel Sig1;
    private javax.swing.JLabel Sig10;
    private javax.swing.JLabel Sig2;
    private javax.swing.JLabel Sig3;
    private javax.swing.JLabel Sig4;
    private javax.swing.JLabel Sig5;
    private javax.swing.JLabel Sig6;
    private javax.swing.JLabel Sig7;
    private javax.swing.JLabel Sig8;
    private javax.swing.JLabel Sig9;
    private javax.swing.JButton SilenciarYBloquearBtn;
    private javax.swing.JLabel SubDesc;
    private javax.swing.JLabel SubLlave;
    private javax.swing.JLabel SubUsuario;
    private javax.swing.JTextField TelefonoEditar;
    private javax.swing.JLabel TelefonoLabel;
    private javax.swing.JButton TemasBtn;
    private javax.swing.JButton TusPostBtn;
    private javax.swing.JPanel TusPostTabPane;
    private javax.swing.JLabel UsuarioLabel;
    private javax.swing.JLabel UsuarioLabel1;
    private javax.swing.JLabel UsuarioLabel2;
    private javax.swing.JLabel UsuarioLabel3;
    private javax.swing.JLabel UsuarioLabel4;
    private javax.swing.JLabel UsuarioLabel5;
    private javax.swing.JLabel UsuarioLabel6;
    private javax.swing.JLabel Y_logo;
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTabbedPane jTabbedPane2;
    // End of variables declaration//GEN-END:variables
}
