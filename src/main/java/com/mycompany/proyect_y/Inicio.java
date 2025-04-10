/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.proyect_y;
import Conection.DB_Conection;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.Icon;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author gisel
 */
public class Inicio extends javax.swing.JFrame {

    private File archivoImagenSeleccionado;
    /**
     * Creates new form 
     */
    
    public Inicio() {
        initComponents();
        DB_Conection db = new DB_Conection();
        //db.DB_Conection_o(); //Donde me da el error 
        String url="src/main/java/Multimedia/YSinFondo.png";
        ImageIcon image = new ImageIcon(url);
        Image img = image.getImage().getScaledInstance(550,550, Image.SCALE_DEFAULT );
        ImageIcon icono = new ImageIcon(img);
        L_in.setIcon(icono);
        
    }


            
    public void autenticarUsuario() {
        String usuario = TP_Correo.getText(); // Obtiene usuario, correo o teléfono
        String password = new String(TP_Contra.getPassword()); // Obtiene la contraseña

        String idUsuario = verificarUsuario(usuario, password); // o usar el que ya tienes
        if (idUsuario != null) {
            L_Aviso.setText("entrA if");
            SesionUsuario.iniciarSesion(idUsuario); // Guardar el ID globalmente
            L_Aviso.setText(SesionUsuario.idUsuario);
            
            new Perfil().setVisible(true);
            L_Aviso.setText("perfil");
            this.dispose();
        } else {
            L_Aviso.setText("Usuario o contraseña incorrectos");
        }
    }
  
    public String verificarUsuario(String usuario, String password) {
        Connection con = DB_Conection.conectar();
        if (con != null) {
            try {
                // Buscar por usuario, correo o teléfono con la contraseña
                String sql = "SELECT * FROM usuario WHERE (id_usuario = ? OR correo = ? OR telefono = ?) AND contrasena = ?";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, usuario);
                ps.setString(2, usuario);
                ps.setString(3, usuario);
                ps.setString(4, password);
                ResultSet rs = ps.executeQuery();
                
                if (rs.next()) {
                    L_Aviso.setText("antes del return");
                    return rs.getString("id_usuario");
                }
                
            } 
            catch (SQLException e) {
                 e.printStackTrace(); // Muestra errores en consola
            }
        }
        return null;
    }



    public void registrarUsuario() throws FileNotFoundException {
        
        String idUsuario = TP_Usuario.getText();
        String contrasena = new String(TP_Contasenia.getPassword());
        String correo = TP_CorreoC.getText();
        String nombre = TP_Nombre.getText();
        String apellido = TP_Apellido.getText();
        String pais = CB_Pais.getSelectedItem().toString(); 
        String telefono = CB_Lada.getSelectedItem().toString()+TP_Telefono.getText();
        String seleccion = CB_Sexo.getSelectedItem().toString(); 
        char sexo = seleccion.charAt(0);
        String Fecha = CB_Anio.getSelectedItem().toString() + "-" + 
                   CB_Mes.getSelectedItem().toString() + "-" + 
                   CB_Dia.getSelectedItem().toString();
       
        File archivoImagen = jFileChooser.getSelectedFile();

        
        // Convertir a java.sql.Date
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(Fecha, formatter);
        java.sql.Date fechaSQL = java.sql.Date.valueOf(localDate);

        Connection con = DB_Conection.conectar();   
        if (con == null) {
            L_Aviso2.setText("Error: La conexión a la base de datos no está funcionando.");
            return;
        } else {
            L_Aviso2.setText("Conexión exitosa a la base de datos.");
        }
        
        try {
            // Consulta SQL para insertar un nuevo usuario
            String sql = "INSERT INTO usuario (id_usuario, contrasena, sexo, correo, telefono, fecha_nac , nombre, apellido, pais, foto_perfil) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, idUsuario);
            ps.setString(2, contrasena);
            ps.setString(3, String.valueOf(sexo));
            ps.setString(4, correo);
            ps.setString(5, telefono);
            ps.setDate(6, fechaSQL);
            ps.setString(7, nombre);
            ps.setString(8, apellido);
            ps.setString(9, pais);

            
FileInputStream fis = new FileInputStream(archivoImagenSeleccionado);
ps.setBinaryStream(10, fis, (int) archivoImagenSeleccionado.length());
            
            int filasInsertadas = ps.executeUpdate();// Ejecutar la consulta
            SeleccionesCheckBox();
        
            if (filasInsertadas > 0) {
                SesionUsuario.iniciarSesion(idUsuario);
                L_Aviso.setText("guarda");
                new Perfil().setVisible(true);
                L_Aviso.setText("perfil");
                this.dispose();
            } else {
                L_Aviso2.setText( "Error al registrar usuario");
            }
        } catch (SQLException e) {
            L_Aviso2.setText( "Error al registrar usuario: " + e.getMessage());
        }
    }
    
    
    public void SeleccionesCheckBox(){
        //identificar a los chekc box con un valor unico
        Check_Musica.putClientProperty("Musica", 1);
        Check_Deporte.putClientProperty("Deporte", 2);
        Check_Arte.putClientProperty("Arte", 3);
        Check_Fotografia.putClientProperty("Fotografia", 4);
        Check_Famosos.putClientProperty("Famosos", 5);
        Check_Anime.putClientProperty("Anime", 6);
        Check_Series.putClientProperty("Series", 7);
        Check_Peliculas.putClientProperty("Peliculas", 8);
        Check_Manualidades.putClientProperty("Manualidades", 9);
        Check_Espacio.putClientProperty("Espacio", 10);
        Check_Astrologia.putClientProperty("Astrologia", 11);
        Check_VideoJuegos.putClientProperty("Videojuegos", 12);
        Check_Cine.putClientProperty("Cine", 13);
        Check_Animales.putClientProperty("Animales", 14);
        Check_Tecnologia.putClientProperty("Tecnologia", 15);
        Check_Noticias.putClientProperty("Noticias", 16);
        Check_Viaje.putClientProperty("Viaje", 17);
        Check_Cocina.putClientProperty("Cocina", 18);
        Check_Moda.putClientProperty("Moda", 19);
        Check_Teatro.putClientProperty("Teatro", 20);
        Check_Programacion.putClientProperty("Programacion", 21);
        
        //Obtener los valores del check box       
        //Arreglo para los valores obtenidos de los checkbox
        int [] checkBoxArreglo = new int [22];
        
        int indice = 0; // Contador para posiciones válidas del arreglo

        if (Check_Musica.isSelected()) {
        checkBoxArreglo[indice] = (int) Check_Musica.getClientProperty("Musica");
        indice++;
        }
        if (Check_Deporte.isSelected()) {
        checkBoxArreglo[indice] = (int) Check_Deporte.getClientProperty("Deporte");
        indice++;
        }
        if (Check_Arte.isSelected()) {
        checkBoxArreglo[indice] = (int) Check_Arte.getClientProperty("Arte");
        indice++;
        }
        if (Check_Fotografia.isSelected()) {
        checkBoxArreglo[indice] = (int) Check_Fotografia.getClientProperty("Fotografia");
        indice++;
        }
        if (Check_Famosos.isSelected()) {
        checkBoxArreglo[indice] = (int) Check_Famosos.getClientProperty("Famosos");
        indice++;
        }
        if (Check_Anime.isSelected()) {
        checkBoxArreglo[indice] = (int) Check_Anime.getClientProperty("Anime");
        indice++;
        }
        if (Check_Series.isSelected()) {
        checkBoxArreglo[indice] = (int) Check_Series.getClientProperty("Series");
        indice++;
        }
        if (Check_Peliculas.isSelected()) {
        checkBoxArreglo[indice] = (int) Check_Peliculas.getClientProperty("Peliculas");
        indice++;
        }
        if (Check_Manualidades.isSelected()) {
        checkBoxArreglo[indice] = (int) Check_Manualidades.getClientProperty("Manualidades");
        indice++;
        }
        if (Check_Espacio.isSelected()) {
        checkBoxArreglo[indice] = (int) Check_Espacio.getClientProperty("Espacio");
        indice++;
        }
        if (Check_Astrologia.isSelected()) {
        checkBoxArreglo[indice] = (int) Check_Astrologia.getClientProperty("Astrologia");
        indice++;
        }
        if (Check_VideoJuegos.isSelected()) {
        checkBoxArreglo[indice] = (int) Check_VideoJuegos.getClientProperty("Videojuegos");
        indice++;
        }
        if (Check_Cine.isSelected()) {
        checkBoxArreglo[indice] = (int) Check_Cine.getClientProperty("Cine");
        indice++;
        }
        if (Check_Animales.isSelected()) {
        checkBoxArreglo[indice] = (int) Check_Animales.getClientProperty("Animales");
        indice++;
        }
        if (Check_Tecnologia.isSelected()) {
        checkBoxArreglo[indice] = (int) Check_Tecnologia.getClientProperty("Tecnologia");
        indice++;
        }
        if (Check_Noticias.isSelected()) {
        checkBoxArreglo[indice] = (int) Check_Noticias.getClientProperty("Noticias");
        indice++;
        }
        if (Check_Viaje.isSelected()) {
        checkBoxArreglo[indice] = (int) Check_Viaje.getClientProperty("Viaje");
        indice++;
        }
        if (Check_Cocina.isSelected()) {
        checkBoxArreglo[indice] = (int) Check_Cocina.getClientProperty("Cocina");
        indice++;
        }
        if (Check_Moda.isSelected()) {
        checkBoxArreglo[indice] = (int) Check_Moda.getClientProperty("Moda");
        indice++;
        }
        if (Check_Teatro.isSelected()) {
        checkBoxArreglo[indice] = (int) Check_Teatro.getClientProperty("Teatro");
        indice++;
        }
        if (Check_Programacion.isSelected()) {
        checkBoxArreglo[indice] = (int) Check_Programacion.getClientProperty("Programacion");
        indice++;
        }

        Connection con = DB_Conection.conectar();     
        try{
            for(int i=0;i<=indice;i++){
                String sql = "INSERT INTO usuario_intereses (usuario_id, interest_id) VALUES (?,?)";
                PreparedStatement st = con.prepareStatement(sql);
                st.setString(1, TP_Usuario.getText());
                st.setInt(2, checkBoxArreglo[i]); // Usa el valor del arreglo
                st.executeUpdate();
            } 
            JOptionPane.showConfirmDialog(null, "Datos aceptados");
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        
    }
    
    public boolean Comprobar1() {
        
        String idUsuario = TP_Usuario.getText();
        String contrasena = new String(TP_Contasenia.getPassword());
        String nombre = TP_Nombre.getText();
        String apellido = TP_Apellido.getText();
        String Aviso="";
        int i=0;
        L_Aviso3.setText("");
        L_Aviso4.setText("");
        L_Aviso5.setText("");       
        
        //Validaciones
        if (idUsuario.isEmpty() || contrasena.isEmpty() || nombre.isEmpty() || apellido.isEmpty()) {
            Aviso+= "Falta de: ";
            if (nombre.isEmpty()){Aviso= "Nombre, ";}
            if (apellido.isEmpty()){Aviso= Aviso + "Apellido, ";}
            if (idUsuario.isEmpty()){Aviso += "Usuario, ";}
            if (contrasena.isEmpty()){Aviso += "Contrasenia, ";}
            
            L_Aviso3.setText(Aviso);
            i=1;
        }
        
        if (contrasena.length()<8){L_Aviso5.setText(" La contrasenia debe de tener al menos 8 caracteres"); i=1;}
        if (idUsuario.length()<6){L_Aviso4.setText(" El nombre de usuario debe de tener al menos 6 caracteres"); i=1;}  
        
        if (i==1){return false;}
        
        return true;
        
   }
    
    public boolean Comprobar2() {
        
        String correo = TP_CorreoC.getText();
        String pais = CB_Pais.getSelectedItem().toString(); 
        String telefono = TP_Telefono.getText();
        String seleccion = CB_Sexo.getSelectedItem().toString(); 
        String dia = CB_Anio.getSelectedItem().toString() ;
        String mes= CB_Mes.getSelectedItem().toString();
        String anio =CB_Dia.getSelectedItem().toString();
        L_Aviso6.setText("");
        L_Aviso7.setText("");
        L_Aviso8.setText(""); 
        L_Aviso9.setText("");
        L_Aviso10.setText("");
        L_Aviso11.setText(""); 

        String Aviso="";
        int i=0;
        
        
        //Validaciones
        if (telefono.length()!=10){L_Aviso8.setText(" Ingrese un numero de celular Valido"); i=1;}
        if (!correo.contains("@") ||!correo.contains(".com")){L_Aviso6.setText(" Ingrese un Correo valido y que termine en '.com'"); i=1;}  
        
        
        if (dia=="Dia" || mes =="Mes"|| anio=="Anio"){L_Aviso9.setText(" Ingrese una fecha valida"); i=1;}
        if (seleccion == "Seleccionar"){L_Aviso10.setText("Seleccione un tipo de Sexo Valido"); i=1;}  
        if (pais == "Seleccionar"){L_Aviso7.setText("Seleccione un Pais"); i=1;}  
        if (i==1){return false;}
        
        return true;
        
   }
    
 

         
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        J_Inicioinicio = new javax.swing.JPanel();
        L_LoQuePAsa = new javax.swing.JLabel();
        B_CreaCuenta = new javax.swing.JButton();
        LabelOR = new javax.swing.JLabel();
        SeparadorDer = new javax.swing.JSeparator();
        SeparadorIzq = new javax.swing.JSeparator();
        L_UneteHoy = new javax.swing.JLabel();
        L_PrivCookies = new javax.swing.JLabel();
        L_YaCuenta = new javax.swing.JLabel();
        B_IniciaS = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        L_in = new javax.swing.JLabel();
        J_InicioS = new javax.swing.JPanel();
        PanelFLotante = new javax.swing.JPanel();
        L_Inicia = new javax.swing.JLabel();
        SeparadorDer1 = new javax.swing.JSeparator();
        L_YaCuenta1 = new javax.swing.JLabel();
        SeparadorIzq1 = new javax.swing.JSeparator();
        LabelOR1 = new javax.swing.JLabel();
        B_Siguiente = new javax.swing.JButton();
        L_Correo = new javax.swing.JLabel();
        L_Contra = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TP_Correo = new javax.swing.JTextPane();
        B_Registrate = new javax.swing.JButton();
        L_Aviso = new javax.swing.JLabel();
        TP_Contra = new javax.swing.JPasswordField();
        J_CreaCuenta = new javax.swing.JPanel();
        PanelFlotante = new javax.swing.JPanel();
        L_Crea = new javax.swing.JLabel();
        L_Usuario = new javax.swing.JLabel();
        L_Contra1 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        TP_Nombre = new javax.swing.JTextPane();
        L_Nombre = new javax.swing.JLabel();
        Siguiente = new javax.swing.JButton();
        L_YaCuenta2 = new javax.swing.JLabel();
        B_IniciaSesionCreaCuenta = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        TP_Usuario = new javax.swing.JTextPane();
        jScrollPane6 = new javax.swing.JScrollPane();
        TP_Apellido = new javax.swing.JTextPane();
        L_Nombre1 = new javax.swing.JLabel();
        TP_Contasenia = new javax.swing.JPasswordField();
        L_Aviso3 = new javax.swing.JLabel();
        L_Aviso4 = new javax.swing.JLabel();
        L_Aviso5 = new javax.swing.JLabel();
        J_CreaCuenta1 = new javax.swing.JPanel();
        PanelFlotante2 = new javax.swing.JPanel();
        L_Crea2 = new javax.swing.JLabel();
        J_Conteiner = new javax.swing.JPanel();
        J_Archivos = new javax.swing.JPanel();
        jFileChooser = new javax.swing.JFileChooser();
        J_C_Foto = new javax.swing.JPanel();
        L_Foto = new javax.swing.JLabel();
        L_Nombre2 = new javax.swing.JLabel();
        Siguiente2 = new javax.swing.JButton();
        B_Volver = new javax.swing.JButton();
        B_ElegirOtra = new javax.swing.JButton();
        L_Aviso11 = new javax.swing.JLabel();
        Intereses = new javax.swing.JPanel();
        PanelFlotante3 = new javax.swing.JPanel();
        L_Crea3 = new javax.swing.JLabel();
        B_Terminar = new javax.swing.JButton();
        L_Seleccione = new javax.swing.JLabel();
        Check_Deporte = new javax.swing.JCheckBox();
        Check_Arte = new javax.swing.JCheckBox();
        Check_Musica = new javax.swing.JCheckBox();
        Check_Fotografia = new javax.swing.JCheckBox();
        Check_Famosos = new javax.swing.JCheckBox();
        Check_Anime = new javax.swing.JCheckBox();
        Check_Series = new javax.swing.JCheckBox();
        Check_Peliculas = new javax.swing.JCheckBox();
        Check_Manualidades = new javax.swing.JCheckBox();
        Check_Espacio = new javax.swing.JCheckBox();
        Check_Astrologia = new javax.swing.JCheckBox();
        Check_VideoJuegos = new javax.swing.JCheckBox();
        Check_Cine = new javax.swing.JCheckBox();
        Check_Animales = new javax.swing.JCheckBox();
        Check_Tecnologia = new javax.swing.JCheckBox();
        Check_Noticias = new javax.swing.JCheckBox();
        Check_Viaje = new javax.swing.JCheckBox();
        Check_Cocina = new javax.swing.JCheckBox();
        Check_Moda = new javax.swing.JCheckBox();
        Check_Teatro = new javax.swing.JCheckBox();
        Check_Programacion = new javax.swing.JCheckBox();
        B_Volver1 = new javax.swing.JButton();
        L_Aviso2 = new javax.swing.JLabel();
        J_CreaCuenta2 = new javax.swing.JPanel();
        PanelFlotante1 = new javax.swing.JPanel();
        L_Crea1 = new javax.swing.JLabel();
        L_CorreoC = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        TP_CorreoC = new javax.swing.JTextPane();
        Siguiente1 = new javax.swing.JButton();
        CB_Mes = new javax.swing.JComboBox<>();
        CB_Lada = new javax.swing.JComboBox<>();
        CB_Anio = new javax.swing.JComboBox<>();
        L_FechaN = new javax.swing.JLabel();
        B_RegresarCC2 = new javax.swing.JButton();
        jScrollPane13 = new javax.swing.JScrollPane();
        TP_Telefono = new javax.swing.JTextPane();
        L_Telefono = new javax.swing.JLabel();
        CB_Sexo = new javax.swing.JComboBox<>();
        CB_Pais = new javax.swing.JComboBox<>();
        L_Pais = new javax.swing.JLabel();
        CB_Dia = new javax.swing.JComboBox<>();
        L_Pais1 = new javax.swing.JLabel();
        L_Aviso6 = new javax.swing.JLabel();
        L_Aviso7 = new javax.swing.JLabel();
        L_Aviso8 = new javax.swing.JLabel();
        L_Aviso9 = new javax.swing.JLabel();
        L_Aviso10 = new javax.swing.JLabel();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setSize(new java.awt.Dimension(1920, 1080));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        J_Inicioinicio.setBackground(new java.awt.Color(0, 0, 0));
        J_Inicioinicio.setAlignmentX(188.0F);
        J_Inicioinicio.setAlignmentY(48.0F);
        J_Inicioinicio.setPreferredSize(new java.awt.Dimension(1920, 1080));

        L_LoQuePAsa.setFont(new java.awt.Font("Arial Black", 1, 64)); // NOI18N
        L_LoQuePAsa.setForeground(new java.awt.Color(255, 255, 255));
        L_LoQuePAsa.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        L_LoQuePAsa.setText("<html>Lo que está pasando ahora <html> ");

        B_CreaCuenta.setBackground(new java.awt.Color(166, 77, 121));
        B_CreaCuenta.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        B_CreaCuenta.setForeground(new java.awt.Color(255, 255, 255));
        B_CreaCuenta.setActionCommand("Crea una Cuenta");
        B_CreaCuenta.setLabel("Crea una cuenta");
        B_CreaCuenta.setPreferredSize(new java.awt.Dimension(90, 25));
        B_CreaCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_CreaCuentaActionPerformed(evt);
            }
        });

        LabelOR.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        LabelOR.setForeground(new java.awt.Color(255, 255, 255));
        LabelOR.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelOR.setText("o");

        L_UneteHoy.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        L_UneteHoy.setForeground(new java.awt.Color(255, 255, 255));
        L_UneteHoy.setText("Únete Hoy");

        L_PrivCookies.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        L_PrivCookies.setForeground(new java.awt.Color(255, 255, 255));
        L_PrivCookies.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        L_PrivCookies.setText("<html>Al registrarte, aceptas los Términos de servicio y la Política de privacidad, incluida la política de Uso de Cookies. <html>");

        L_YaCuenta.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        L_YaCuenta.setForeground(new java.awt.Color(255, 255, 255));
        L_YaCuenta.setText("Ya tienes una cuenta?");

        B_IniciaS.setBackground(new java.awt.Color(26, 26, 29));
        B_IniciaS.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        B_IniciaS.setForeground(new java.awt.Color(166, 77, 121));
        B_IniciaS.setActionCommand("Crea una Cuenta");
        B_IniciaS.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(166, 77, 121)));
        B_IniciaS.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        B_IniciaS.setLabel("Inicia Sesion");
        B_IniciaS.setPreferredSize(new java.awt.Dimension(90, 25));
        B_IniciaS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_IniciaSActionPerformed(evt);
            }
        });

        jLabel7.setForeground(new java.awt.Color(204, 204, 204));
        jLabel7.setText("© 2025 Y Corp.");

        L_in.setText("jLabel1");

        javax.swing.GroupLayout J_InicioinicioLayout = new javax.swing.GroupLayout(J_Inicioinicio);
        J_Inicioinicio.setLayout(J_InicioinicioLayout);
        J_InicioinicioLayout.setHorizontalGroup(
            J_InicioinicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(J_InicioinicioLayout.createSequentialGroup()
                .addGroup(J_InicioinicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(J_InicioinicioLayout.createSequentialGroup()
                        .addGap(175, 175, 175)
                        .addComponent(L_in, javax.swing.GroupLayout.PREFERRED_SIZE, 509, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(212, 212, 212)
                        .addGroup(J_InicioinicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(L_LoQuePAsa, javax.swing.GroupLayout.PREFERRED_SIZE, 601, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(L_YaCuenta)
                            .addComponent(L_PrivCookies, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(B_CreaCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(L_UneteHoy)
                            .addGroup(J_InicioinicioLayout.createSequentialGroup()
                                .addComponent(SeparadorIzq, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(LabelOR, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(SeparadorDer, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(B_IniciaS, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(J_InicioinicioLayout.createSequentialGroup()
                        .addGap(724, 724, 724)
                        .addComponent(jLabel7)))
                .addContainerGap(147, Short.MAX_VALUE))
        );
        J_InicioinicioLayout.setVerticalGroup(
            J_InicioinicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, J_InicioinicioLayout.createSequentialGroup()
                .addGap(0, 122, Short.MAX_VALUE)
                .addComponent(L_in, javax.swing.GroupLayout.PREFERRED_SIZE, 499, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(130, 130, 130)
                .addComponent(jLabel7)
                .addGap(33, 33, 33))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, J_InicioinicioLayout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(L_LoQuePAsa, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(L_UneteHoy)
                .addGap(31, 31, 31)
                .addComponent(B_CreaCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(L_PrivCookies, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(J_InicioinicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(J_InicioinicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(SeparadorIzq, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(SeparadorDer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(LabelOR, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(L_YaCuenta)
                .addGap(12, 12, 12)
                .addComponent(B_IniciaS, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        B_CreaCuenta.getAccessibleContext().setAccessibleName("Crea una Cuenta");

        jTabbedPane1.addTab("tab1", J_Inicioinicio);

        J_InicioS.setBackground(new java.awt.Color(0, 0, 0));

        PanelFLotante.setBackground(new java.awt.Color(26, 26, 29));

        L_Inicia.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        L_Inicia.setForeground(new java.awt.Color(255, 255, 255));
        L_Inicia.setText("Inicia Sesión en Y");

        L_YaCuenta1.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        L_YaCuenta1.setForeground(new java.awt.Color(255, 255, 255));
        L_YaCuenta1.setText("Aún no tienes una cuenta?");

        LabelOR1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        LabelOR1.setForeground(new java.awt.Color(255, 255, 255));
        LabelOR1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelOR1.setText("o");

        B_Siguiente.setBackground(new java.awt.Color(166, 77, 121));
        B_Siguiente.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        B_Siguiente.setForeground(new java.awt.Color(255, 255, 255));
        B_Siguiente.setText("Iniciar Sesion");
        B_Siguiente.setActionCommand("Siguiente");
        B_Siguiente.setPreferredSize(new java.awt.Dimension(90, 25));
        B_Siguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_SiguienteActionPerformed(evt);
            }
        });

        L_Correo.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        L_Correo.setForeground(new java.awt.Color(255, 255, 255));
        L_Correo.setText("Télefono, correo o nombre de usuario");

        L_Contra.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        L_Contra.setForeground(new java.awt.Color(255, 255, 255));
        L_Contra.setText("Contraseña");

        TP_Correo.setBackground(new java.awt.Color(26, 26, 29));
        TP_Correo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        TP_Correo.setContentType("email"); // NOI18N
        TP_Correo.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        TP_Correo.setForeground(new java.awt.Color(166, 77, 121));
        TP_Correo.setToolTipText("");
        TP_Correo.setName("Télefono"); // NOI18N
        jScrollPane2.setViewportView(TP_Correo);

        B_Registrate.setBackground(new java.awt.Color(26, 26, 29));
        B_Registrate.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        B_Registrate.setForeground(new java.awt.Color(166, 77, 121));
        B_Registrate.setText("Registrate aquí");
        B_Registrate.setActionCommand("Siguiente");
        B_Registrate.setPreferredSize(new java.awt.Dimension(90, 25));
        B_Registrate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_RegistrateActionPerformed(evt);
            }
        });

        L_Aviso.setBackground(new java.awt.Color(26, 26, 29));
        L_Aviso.setForeground(new java.awt.Color(255, 0, 51));

        TP_Contra.setBackground(new java.awt.Color(26, 26, 29));
        TP_Contra.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        TP_Contra.setForeground(new java.awt.Color(166, 77, 121));
        TP_Contra.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        javax.swing.GroupLayout PanelFLotanteLayout = new javax.swing.GroupLayout(PanelFLotante);
        PanelFLotante.setLayout(PanelFLotanteLayout);
        PanelFLotanteLayout.setHorizontalGroup(
            PanelFLotanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelFLotanteLayout.createSequentialGroup()
                .addContainerGap(107, Short.MAX_VALUE)
                .addGroup(PanelFLotanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelFLotanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelFLotanteLayout.createSequentialGroup()
                            .addComponent(L_Inicia)
                            .addGap(176, 176, 176))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelFLotanteLayout.createSequentialGroup()
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(98, 98, 98)))
                    .addGroup(PanelFLotanteLayout.createSequentialGroup()
                        .addGroup(PanelFLotanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelFLotanteLayout.createSequentialGroup()
                                .addComponent(SeparadorIzq1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(LabelOR1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(SeparadorDer1, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE))
                            .addComponent(B_Registrate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(PanelFLotanteLayout.createSequentialGroup()
                                .addComponent(L_YaCuenta1)
                                .addGap(105, 105, 105))
                            .addComponent(L_Contra, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(L_Correo, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(B_Siguiente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
                            .addComponent(L_Aviso, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(TP_Contra, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(98, 98, 98))))
        );
        PanelFLotanteLayout.setVerticalGroup(
            PanelFLotanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelFLotanteLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(L_Inicia)
                .addGap(62, 62, 62)
                .addComponent(L_Correo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(L_Contra, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TP_Contra, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(L_Aviso, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(B_Siguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(PanelFLotanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(LabelOR1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SeparadorIzq1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SeparadorDer1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addComponent(L_YaCuenta1)
                .addGap(18, 18, 18)
                .addComponent(B_Registrate, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(83, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout J_InicioSLayout = new javax.swing.GroupLayout(J_InicioS);
        J_InicioS.setLayout(J_InicioSLayout);
        J_InicioSLayout.setHorizontalGroup(
            J_InicioSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(J_InicioSLayout.createSequentialGroup()
                .addGap(470, 470, 470)
                .addComponent(PanelFLotante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(564, Short.MAX_VALUE))
        );
        J_InicioSLayout.setVerticalGroup(
            J_InicioSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(J_InicioSLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(PanelFLotante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(120, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab3", J_InicioS);

        J_CreaCuenta.setBackground(new java.awt.Color(0, 0, 0));

        PanelFlotante.setBackground(new java.awt.Color(26, 26, 29));

        L_Crea.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        L_Crea.setForeground(new java.awt.Color(255, 255, 255));
        L_Crea.setText("Crea tu cuenta en Y");

        L_Usuario.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        L_Usuario.setForeground(new java.awt.Color(255, 255, 255));
        L_Usuario.setText("Nombre de usuario");

        L_Contra1.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        L_Contra1.setForeground(new java.awt.Color(255, 255, 255));
        L_Contra1.setText("Contraseña");

        TP_Nombre.setBackground(new java.awt.Color(26, 26, 29));
        TP_Nombre.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        TP_Nombre.setContentType("email"); // NOI18N
        TP_Nombre.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        TP_Nombre.setForeground(new java.awt.Color(166, 77, 121));
        TP_Nombre.setToolTipText("");
        TP_Nombre.setMaximumSize(new java.awt.Dimension(70, 30));
        TP_Nombre.setMinimumSize(new java.awt.Dimension(70, 30));
        TP_Nombre.setName("Nombre"); // NOI18N
        TP_Nombre.setPreferredSize(new java.awt.Dimension(62, 20));
        jScrollPane5.setViewportView(TP_Nombre);

        L_Nombre.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        L_Nombre.setForeground(new java.awt.Color(255, 255, 255));
        L_Nombre.setText("Nombre");

        Siguiente.setBackground(new java.awt.Color(166, 77, 121));
        Siguiente.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        Siguiente.setForeground(new java.awt.Color(255, 255, 255));
        Siguiente.setActionCommand("Siguiente");
        Siguiente.setLabel("Siguiente");
        Siguiente.setPreferredSize(new java.awt.Dimension(90, 25));
        Siguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SiguienteActionPerformed(evt);
            }
        });

        L_YaCuenta2.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        L_YaCuenta2.setForeground(new java.awt.Color(255, 255, 255));
        L_YaCuenta2.setText("Ya tienes una cuenta?");

        B_IniciaSesionCreaCuenta.setBackground(new java.awt.Color(26, 26, 29));
        B_IniciaSesionCreaCuenta.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        B_IniciaSesionCreaCuenta.setForeground(new java.awt.Color(166, 77, 121));
        B_IniciaSesionCreaCuenta.setText("Inicia Sesion");
        B_IniciaSesionCreaCuenta.setActionCommand("Siguiente");
        B_IniciaSesionCreaCuenta.setPreferredSize(new java.awt.Dimension(90, 25));
        B_IniciaSesionCreaCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_IniciaSesionCreaCuentaActionPerformed(evt);
            }
        });

        TP_Usuario.setBackground(new java.awt.Color(26, 26, 29));
        TP_Usuario.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        TP_Usuario.setContentType("email"); // NOI18N
        TP_Usuario.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        TP_Usuario.setForeground(new java.awt.Color(166, 77, 121));
        TP_Usuario.setToolTipText("");
        TP_Usuario.setName("Télefono"); // NOI18N
        jScrollPane7.setViewportView(TP_Usuario);

        TP_Apellido.setBackground(new java.awt.Color(26, 26, 29));
        TP_Apellido.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        TP_Apellido.setContentType("email"); // NOI18N
        TP_Apellido.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        TP_Apellido.setForeground(new java.awt.Color(166, 77, 121));
        TP_Apellido.setToolTipText("");
        TP_Apellido.setMaximumSize(new java.awt.Dimension(70, 30));
        TP_Apellido.setMinimumSize(new java.awt.Dimension(70, 30));
        TP_Apellido.setName("Nombre"); // NOI18N
        TP_Apellido.setPreferredSize(new java.awt.Dimension(62, 20));
        jScrollPane6.setViewportView(TP_Apellido);

        L_Nombre1.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        L_Nombre1.setForeground(new java.awt.Color(255, 255, 255));
        L_Nombre1.setText("Apellido");

        TP_Contasenia.setBackground(new java.awt.Color(26, 26, 29));
        TP_Contasenia.setForeground(new java.awt.Color(166, 77, 121));

        L_Aviso3.setBackground(new java.awt.Color(26, 26, 29));
        L_Aviso3.setForeground(new java.awt.Color(255, 51, 51));

        L_Aviso4.setBackground(new java.awt.Color(26, 26, 29));
        L_Aviso4.setForeground(new java.awt.Color(255, 51, 51));

        L_Aviso5.setBackground(new java.awt.Color(26, 26, 29));
        L_Aviso5.setForeground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout PanelFlotanteLayout = new javax.swing.GroupLayout(PanelFlotante);
        PanelFlotante.setLayout(PanelFlotanteLayout);
        PanelFlotanteLayout.setHorizontalGroup(
            PanelFlotanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelFlotanteLayout.createSequentialGroup()
                .addGroup(PanelFlotanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelFlotanteLayout.createSequentialGroup()
                        .addGap(174, 174, 174)
                        .addComponent(L_Crea))
                    .addGroup(PanelFlotanteLayout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addGroup(PanelFlotanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane7)
                            .addComponent(jScrollPane6)
                            .addComponent(L_Nombre)
                            .addComponent(L_Contra1)
                            .addComponent(L_Usuario)
                            .addComponent(L_Nombre1)
                            .addComponent(jScrollPane5)
                            .addComponent(TP_Contasenia, javax.swing.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
                            .addComponent(L_Aviso3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(L_Aviso4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(L_Aviso5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(102, Short.MAX_VALUE))
            .addGroup(PanelFlotanteLayout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addGroup(PanelFlotanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Siguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelFlotanteLayout.createSequentialGroup()
                        .addComponent(L_YaCuenta2)
                        .addGap(18, 18, 18)
                        .addComponent(B_IniciaSesionCreaCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 145, Short.MAX_VALUE))
        );
        PanelFlotanteLayout.setVerticalGroup(
            PanelFlotanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelFlotanteLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(L_Crea)
                .addGap(31, 31, 31)
                .addComponent(L_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(L_Nombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(L_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(L_Aviso4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(L_Contra1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TP_Contasenia, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                .addGap(8, 8, 8)
                .addComponent(L_Aviso5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(L_Aviso3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Siguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(PanelFlotanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(L_YaCuenta2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B_IniciaSesionCreaCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout J_CreaCuentaLayout = new javax.swing.GroupLayout(J_CreaCuenta);
        J_CreaCuenta.setLayout(J_CreaCuentaLayout);
        J_CreaCuentaLayout.setHorizontalGroup(
            J_CreaCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(J_CreaCuentaLayout.createSequentialGroup()
                .addGap(470, 470, 470)
                .addComponent(PanelFlotante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(564, Short.MAX_VALUE))
        );
        J_CreaCuentaLayout.setVerticalGroup(
            J_CreaCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(J_CreaCuentaLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(PanelFlotante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(119, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab3", J_CreaCuenta);

        J_CreaCuenta1.setBackground(new java.awt.Color(0, 0, 0));

        PanelFlotante2.setBackground(new java.awt.Color(26, 26, 29));

        L_Crea2.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        L_Crea2.setForeground(new java.awt.Color(255, 255, 255));
        L_Crea2.setText("Crea tu cuenta en Y");

        J_Conteiner.setBackground(new java.awt.Color(26, 26, 29));
        J_Conteiner.setLayout(new javax.swing.OverlayLayout(J_Conteiner));

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
                .addComponent(jFileChooser, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                .addGap(55, 55, 55))
        );
        J_ArchivosLayout.setVerticalGroup(
            J_ArchivosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(J_ArchivosLayout.createSequentialGroup()
                .addComponent(jFileChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );

        J_Conteiner.add(J_Archivos);

        J_C_Foto.setBackground(new java.awt.Color(26, 26, 29));

        L_Foto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        L_Foto.setText("[Foto Seleccionada]");

        javax.swing.GroupLayout J_C_FotoLayout = new javax.swing.GroupLayout(J_C_Foto);
        J_C_Foto.setLayout(J_C_FotoLayout);
        J_C_FotoLayout.setHorizontalGroup(
            J_C_FotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(J_C_FotoLayout.createSequentialGroup()
                .addGap(183, 183, 183)
                .addComponent(L_Foto, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(187, Short.MAX_VALUE))
        );
        J_C_FotoLayout.setVerticalGroup(
            J_C_FotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(J_C_FotoLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(L_Foto, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(64, Short.MAX_VALUE))
        );

        J_Conteiner.add(J_C_Foto);

        L_Nombre2.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        L_Nombre2.setForeground(new java.awt.Color(255, 255, 255));
        L_Nombre2.setText("Foto de perfil:");

        Siguiente2.setBackground(new java.awt.Color(166, 77, 121));
        Siguiente2.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        Siguiente2.setForeground(new java.awt.Color(255, 255, 255));
        Siguiente2.setActionCommand("Siguiente");
        Siguiente2.setLabel("Siguiente");
        Siguiente2.setPreferredSize(new java.awt.Dimension(90, 25));
        Siguiente2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Siguiente2ActionPerformed(evt);
            }
        });

        B_Volver.setBackground(new java.awt.Color(26, 26, 29));
        B_Volver.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        B_Volver.setForeground(new java.awt.Color(166, 77, 121));
        B_Volver.setText("Regresar");
        B_Volver.setActionCommand("Siguiente");
        B_Volver.setPreferredSize(new java.awt.Dimension(90, 25));
        B_Volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_VolverActionPerformed(evt);
            }
        });

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

        L_Aviso11.setBackground(new java.awt.Color(26, 26, 29));
        L_Aviso11.setForeground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout PanelFlotante2Layout = new javax.swing.GroupLayout(PanelFlotante2);
        PanelFlotante2.setLayout(PanelFlotante2Layout);
        PanelFlotante2Layout.setHorizontalGroup(
            PanelFlotante2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelFlotante2Layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addGroup(PanelFlotante2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Siguiente2, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelFlotante2Layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(B_Volver, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(PanelFlotante2Layout.createSequentialGroup()
                .addGroup(PanelFlotante2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelFlotante2Layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(L_Nombre2))
                    .addGroup(PanelFlotante2Layout.createSequentialGroup()
                        .addGap(232, 232, 232)
                        .addComponent(B_ElegirOtra, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelFlotante2Layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addGroup(PanelFlotante2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(L_Aviso11, javax.swing.GroupLayout.PREFERRED_SIZE, 521, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelFlotante2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelFlotante2Layout.createSequentialGroup()
                            .addComponent(L_Crea2)
                            .addGap(181, 181, 181))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelFlotante2Layout.createSequentialGroup()
                            .addComponent(J_Conteiner, javax.swing.GroupLayout.PREFERRED_SIZE, 532, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(43, 43, 43)))))
        );
        PanelFlotante2Layout.setVerticalGroup(
            PanelFlotante2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelFlotante2Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(L_Crea2)
                .addGap(28, 28, 28)
                .addComponent(L_Nombre2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(J_Conteiner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(B_ElegirOtra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(L_Aviso11, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Siguiente2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(B_Volver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        javax.swing.GroupLayout J_CreaCuenta1Layout = new javax.swing.GroupLayout(J_CreaCuenta1);
        J_CreaCuenta1.setLayout(J_CreaCuenta1Layout);
        J_CreaCuenta1Layout.setHorizontalGroup(
            J_CreaCuenta1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(J_CreaCuenta1Layout.createSequentialGroup()
                .addGap(470, 470, 470)
                .addComponent(PanelFlotante2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(564, Short.MAX_VALUE))
        );
        J_CreaCuenta1Layout.setVerticalGroup(
            J_CreaCuenta1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(J_CreaCuenta1Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(PanelFlotante2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(114, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab3", J_CreaCuenta1);

        Intereses.setBackground(new java.awt.Color(0, 0, 0));

        PanelFlotante3.setBackground(new java.awt.Color(26, 26, 29));

        L_Crea3.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        L_Crea3.setForeground(new java.awt.Color(255, 255, 255));
        L_Crea3.setText("Intereses");

        B_Terminar.setBackground(new java.awt.Color(166, 77, 121));
        B_Terminar.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        B_Terminar.setForeground(new java.awt.Color(255, 255, 255));
        B_Terminar.setText("Terminar");
        B_Terminar.setActionCommand("Siguiente");
        B_Terminar.setPreferredSize(new java.awt.Dimension(90, 25));
        B_Terminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_TerminarActionPerformed(evt);
            }
        });

        L_Seleccione.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        L_Seleccione.setForeground(new java.awt.Color(255, 255, 255));
        L_Seleccione.setText("Seleccione 5 intereses de su agrado:");

        Check_Deporte.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        Check_Deporte.setForeground(new java.awt.Color(255, 255, 255));
        Check_Deporte.setText("   Deporte");
        Check_Deporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Check_DeporteActionPerformed(evt);
            }
        });

        Check_Arte.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        Check_Arte.setForeground(new java.awt.Color(255, 255, 255));
        Check_Arte.setText("   Arte");
        Check_Arte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Check_ArteActionPerformed(evt);
            }
        });

        Check_Musica.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        Check_Musica.setForeground(new java.awt.Color(255, 255, 255));
        Check_Musica.setText("   Musica");
        Check_Musica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Check_MusicaActionPerformed(evt);
            }
        });

        Check_Fotografia.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        Check_Fotografia.setForeground(new java.awt.Color(255, 255, 255));
        Check_Fotografia.setText("   Fotografia");

        Check_Famosos.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        Check_Famosos.setForeground(new java.awt.Color(255, 255, 255));
        Check_Famosos.setText("   Famosos");
        Check_Famosos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Check_FamososActionPerformed(evt);
            }
        });

        Check_Anime.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        Check_Anime.setForeground(new java.awt.Color(255, 255, 255));
        Check_Anime.setText("   Anime");
        Check_Anime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Check_AnimeActionPerformed(evt);
            }
        });

        Check_Series.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        Check_Series.setForeground(new java.awt.Color(255, 255, 255));
        Check_Series.setText("   Series");

        Check_Peliculas.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        Check_Peliculas.setForeground(new java.awt.Color(255, 255, 255));
        Check_Peliculas.setText("   Peliculas");
        Check_Peliculas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Check_PeliculasActionPerformed(evt);
            }
        });

        Check_Manualidades.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        Check_Manualidades.setForeground(new java.awt.Color(255, 255, 255));
        Check_Manualidades.setText("   Manualidades");
        Check_Manualidades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Check_ManualidadesActionPerformed(evt);
            }
        });

        Check_Espacio.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        Check_Espacio.setForeground(new java.awt.Color(255, 255, 255));
        Check_Espacio.setText("   Espacio");

        Check_Astrologia.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        Check_Astrologia.setForeground(new java.awt.Color(255, 255, 255));
        Check_Astrologia.setText("   Astrologia");
        Check_Astrologia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Check_AstrologiaActionPerformed(evt);
            }
        });

        Check_VideoJuegos.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        Check_VideoJuegos.setForeground(new java.awt.Color(255, 255, 255));
        Check_VideoJuegos.setText("   Videojuegos");
        Check_VideoJuegos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Check_VideoJuegosActionPerformed(evt);
            }
        });

        Check_Cine.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        Check_Cine.setForeground(new java.awt.Color(255, 255, 255));
        Check_Cine.setText("   Cine");

        Check_Animales.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        Check_Animales.setForeground(new java.awt.Color(255, 255, 255));
        Check_Animales.setText("   Animales");
        Check_Animales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Check_AnimalesActionPerformed(evt);
            }
        });

        Check_Tecnologia.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        Check_Tecnologia.setForeground(new java.awt.Color(255, 255, 255));
        Check_Tecnologia.setText("   Tecnologia");
        Check_Tecnologia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Check_TecnologiaActionPerformed(evt);
            }
        });

        Check_Noticias.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        Check_Noticias.setForeground(new java.awt.Color(255, 255, 255));
        Check_Noticias.setText("   Noticias");

        Check_Viaje.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        Check_Viaje.setForeground(new java.awt.Color(255, 255, 255));
        Check_Viaje.setText("   Viajes");
        Check_Viaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Check_ViajeActionPerformed(evt);
            }
        });

        Check_Cocina.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        Check_Cocina.setForeground(new java.awt.Color(255, 255, 255));
        Check_Cocina.setText("   Cocina");
        Check_Cocina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Check_CocinaActionPerformed(evt);
            }
        });

        Check_Moda.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        Check_Moda.setForeground(new java.awt.Color(255, 255, 255));
        Check_Moda.setText("   Moda");
        Check_Moda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Check_ModaActionPerformed(evt);
            }
        });

        Check_Teatro.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        Check_Teatro.setForeground(new java.awt.Color(255, 255, 255));
        Check_Teatro.setText("   Teatro");
        Check_Teatro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Check_TeatroActionPerformed(evt);
            }
        });

        Check_Programacion.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        Check_Programacion.setForeground(new java.awt.Color(255, 255, 255));
        Check_Programacion.setText("   Programacion");
        Check_Programacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Check_ProgramacionActionPerformed(evt);
            }
        });

        B_Volver1.setBackground(new java.awt.Color(26, 26, 29));
        B_Volver1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        B_Volver1.setForeground(new java.awt.Color(166, 77, 121));
        B_Volver1.setText("Regresar");
        B_Volver1.setActionCommand("Siguiente");
        B_Volver1.setPreferredSize(new java.awt.Dimension(90, 25));
        B_Volver1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_Volver1ActionPerformed(evt);
            }
        });

        L_Aviso2.setBackground(new java.awt.Color(26, 26, 29));
        L_Aviso2.setForeground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout PanelFlotante3Layout = new javax.swing.GroupLayout(PanelFlotante3);
        PanelFlotante3.setLayout(PanelFlotante3Layout);
        PanelFlotante3Layout.setHorizontalGroup(
            PanelFlotante3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelFlotante3Layout.createSequentialGroup()
                .addGroup(PanelFlotante3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelFlotante3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(PanelFlotante3Layout.createSequentialGroup()
                            .addGap(68, 68, 68)
                            .addGroup(PanelFlotante3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(L_Seleccione, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(PanelFlotante3Layout.createSequentialGroup()
                                    .addGroup(PanelFlotante3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(Check_Series, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Check_Fotografia, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Check_Musica, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Check_Moda, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Check_Noticias, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Check_Cine, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Check_Espacio, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(PanelFlotante3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(Check_Peliculas, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Check_Famosos, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Check_Deporte, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Check_Teatro, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Check_Viaje, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Check_Animales, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Check_Astrologia, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(PanelFlotante3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(Check_Arte, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Check_Programacion, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Check_Cocina, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Check_Tecnologia, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Check_VideoJuegos, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(PanelFlotante3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(Check_Manualidades, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Check_Anime, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(PanelFlotante3Layout.createSequentialGroup()
                                    .addGap(188, 188, 188)
                                    .addComponent(L_Crea3))))
                        .addGroup(PanelFlotante3Layout.createSequentialGroup()
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(L_Aviso2, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(PanelFlotante3Layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addGroup(PanelFlotante3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(B_Terminar, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(PanelFlotante3Layout.createSequentialGroup()
                                .addGap(114, 114, 114)
                                .addComponent(B_Volver1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        PanelFlotante3Layout.setVerticalGroup(
            PanelFlotante3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelFlotante3Layout.createSequentialGroup()
                .addContainerGap(83, Short.MAX_VALUE)
                .addComponent(L_Crea3)
                .addGap(26, 26, 26)
                .addComponent(L_Seleccione, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(PanelFlotante3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PanelFlotante3Layout.createSequentialGroup()
                        .addComponent(Check_Musica, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(Check_Fotografia, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(Check_Series, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(Check_Espacio, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(Check_Cine, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(Check_Noticias, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(Check_Moda, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelFlotante3Layout.createSequentialGroup()
                        .addComponent(Check_Deporte, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(Check_Famosos, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(Check_Peliculas, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(Check_Astrologia, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(Check_Animales, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(Check_Viaje, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(Check_Teatro, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelFlotante3Layout.createSequentialGroup()
                        .addComponent(Check_Arte, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(Check_Anime, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(Check_Manualidades, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(Check_VideoJuegos, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(Check_Tecnologia, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(Check_Cocina, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(Check_Programacion, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(L_Aviso2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(B_Terminar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(B_Volver1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout InteresesLayout = new javax.swing.GroupLayout(Intereses);
        Intereses.setLayout(InteresesLayout);
        InteresesLayout.setHorizontalGroup(
            InteresesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InteresesLayout.createSequentialGroup()
                .addGap(470, 470, 470)
                .addComponent(PanelFlotante3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(564, Short.MAX_VALUE))
        );
        InteresesLayout.setVerticalGroup(
            InteresesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InteresesLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(PanelFlotante3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(120, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab3", Intereses);

        J_CreaCuenta2.setBackground(new java.awt.Color(0, 0, 0));

        PanelFlotante1.setBackground(new java.awt.Color(26, 26, 29));

        L_Crea1.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        L_Crea1.setForeground(new java.awt.Color(255, 255, 255));
        L_Crea1.setText("Crea tu cuenta en Y");

        L_CorreoC.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        L_CorreoC.setForeground(new java.awt.Color(255, 255, 255));
        L_CorreoC.setText("Correo electronico");

        TP_CorreoC.setBackground(new java.awt.Color(26, 26, 29));
        TP_CorreoC.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        TP_CorreoC.setContentType("email"); // NOI18N
        TP_CorreoC.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        TP_CorreoC.setForeground(new java.awt.Color(166, 77, 121));
        TP_CorreoC.setToolTipText("");
        TP_CorreoC.setName("Télefono"); // NOI18N
        jScrollPane9.setViewportView(TP_CorreoC);

        Siguiente1.setBackground(new java.awt.Color(166, 77, 121));
        Siguiente1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        Siguiente1.setForeground(new java.awt.Color(255, 255, 255));
        Siguiente1.setActionCommand("Siguiente");
        Siguiente1.setLabel("Siguiente");
        Siguiente1.setPreferredSize(new java.awt.Dimension(90, 25));
        Siguiente1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Siguiente1ActionPerformed(evt);
            }
        });

        CB_Mes.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        CB_Mes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mes", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));

        CB_Lada.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        CB_Lada.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "+52", "+1", "+57", "+54", "+51", "+58", "+56", "+593", "+502", "+53" }));

        CB_Anio.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        CB_Anio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Anio", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988", "1987", "1986", "1985", "1984", "1983", "1982", "1981", "1980", "1979", "1978", "1977", "1976", "1975", "1974", "1973", "1972", "1971", "1970", "1969", "1968", "1967", "1966", "1965", "1964", "1963", "1962", "1961", "1960", "1959", "1958", "1957", "1956", "1955", "1954", "1953", "1952", "1951", "1950", "1949", "1948", "1947", "1946", "1945", "1944", "1943", "1942", "1941", "1940", "1939", "1938", "1937", "1936", "1935", "1934", "1933", "1932", "1931", "1930", "1929", "1928", "1927", "1926", "1925" }));
        CB_Anio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CB_AnioActionPerformed(evt);
            }
        });

        L_FechaN.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        L_FechaN.setForeground(new java.awt.Color(255, 255, 255));
        L_FechaN.setText("Fecha de nacimiento");

        B_RegresarCC2.setBackground(new java.awt.Color(26, 26, 29));
        B_RegresarCC2.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        B_RegresarCC2.setForeground(new java.awt.Color(166, 77, 121));
        B_RegresarCC2.setText("Regresar");
        B_RegresarCC2.setActionCommand("Siguiente");
        B_RegresarCC2.setPreferredSize(new java.awt.Dimension(90, 25));
        B_RegresarCC2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_RegresarCC2ActionPerformed(evt);
            }
        });

        TP_Telefono.setBackground(new java.awt.Color(26, 26, 29));
        TP_Telefono.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        TP_Telefono.setContentType("email"); // NOI18N
        TP_Telefono.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        TP_Telefono.setForeground(new java.awt.Color(166, 77, 121));
        TP_Telefono.setToolTipText("");
        TP_Telefono.setName("Télefono"); // NOI18N
        jScrollPane13.setViewportView(TP_Telefono);

        L_Telefono.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        L_Telefono.setForeground(new java.awt.Color(255, 255, 255));
        L_Telefono.setText("Telefono Celular");

        CB_Sexo.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        CB_Sexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Masculino", "Femenino", "No Binario", "Otro" }));

        CB_Pais.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        CB_Pais.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "México", "Estados Unidos", "Colombia", "Argentina", "Perú", "Venezuela", "Chile", "Ecuador", "Guatemala", "Cuba" }));

        L_Pais.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        L_Pais.setForeground(new java.awt.Color(255, 255, 255));
        L_Pais.setText("Pais");

        CB_Dia.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        CB_Dia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dia", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        L_Pais1.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        L_Pais1.setForeground(new java.awt.Color(255, 255, 255));
        L_Pais1.setText("Sexo");

        L_Aviso6.setBackground(new java.awt.Color(26, 26, 29));
        L_Aviso6.setForeground(new java.awt.Color(255, 51, 51));

        L_Aviso7.setBackground(new java.awt.Color(26, 26, 29));
        L_Aviso7.setForeground(new java.awt.Color(255, 51, 51));

        L_Aviso8.setBackground(new java.awt.Color(26, 26, 29));
        L_Aviso8.setForeground(new java.awt.Color(255, 51, 51));

        L_Aviso9.setBackground(new java.awt.Color(26, 26, 29));
        L_Aviso9.setForeground(new java.awt.Color(255, 51, 51));

        L_Aviso10.setBackground(new java.awt.Color(26, 26, 29));
        L_Aviso10.setForeground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout PanelFlotante1Layout = new javax.swing.GroupLayout(PanelFlotante1);
        PanelFlotante1.setLayout(PanelFlotante1Layout);
        PanelFlotante1Layout.setHorizontalGroup(
            PanelFlotante1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelFlotante1Layout.createSequentialGroup()
                .addGroup(PanelFlotante1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelFlotante1Layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addGroup(PanelFlotante1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(L_FechaN)
                            .addComponent(L_Telefono)
                            .addGroup(PanelFlotante1Layout.createSequentialGroup()
                                .addGroup(PanelFlotante1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CB_Lada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(L_Pais))
                                .addGap(18, 18, 18)
                                .addGroup(PanelFlotante1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CB_Pais, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(L_CorreoC, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(L_Aviso6, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(L_Aviso7, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(L_Aviso8, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(L_Aviso9, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(PanelFlotante1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(L_Aviso10, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(PanelFlotante1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(PanelFlotante1Layout.createSequentialGroup()
                                        .addComponent(L_Pais1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(CB_Sexo, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(PanelFlotante1Layout.createSequentialGroup()
                                        .addComponent(CB_Dia, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(CB_Mes, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(CB_Anio, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(PanelFlotante1Layout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addGroup(PanelFlotante1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Siguiente1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(PanelFlotante1Layout.createSequentialGroup()
                                .addGap(85, 85, 85)
                                .addComponent(B_RegresarCC2, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(105, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelFlotante1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(L_Crea1)
                .addGap(174, 174, 174))
        );
        PanelFlotante1Layout.setVerticalGroup(
            PanelFlotante1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelFlotante1Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(L_Crea1)
                .addGap(18, 18, 18)
                .addComponent(L_Telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelFlotante1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(CB_Lada, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addComponent(L_Aviso8, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelFlotante1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CB_Pais, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(L_Pais))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(L_Aviso7, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(L_CorreoC, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(L_Aviso6, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(L_FechaN, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PanelFlotante1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CB_Mes, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CB_Anio, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CB_Dia, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addComponent(L_Aviso9, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelFlotante1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CB_Sexo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(L_Pais1))
                .addGap(7, 7, 7)
                .addComponent(L_Aviso10, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Siguiente1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(B_RegresarCC2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout J_CreaCuenta2Layout = new javax.swing.GroupLayout(J_CreaCuenta2);
        J_CreaCuenta2.setLayout(J_CreaCuenta2Layout);
        J_CreaCuenta2Layout.setHorizontalGroup(
            J_CreaCuenta2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(J_CreaCuenta2Layout.createSequentialGroup()
                .addGap(470, 470, 470)
                .addComponent(PanelFlotante1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(564, Short.MAX_VALUE))
        );
        J_CreaCuenta2Layout.setVerticalGroup(
            J_CreaCuenta2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(J_CreaCuenta2Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(PanelFlotante1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(115, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab3", J_CreaCuenta2);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -33, 1644, 900));

        pack();
    }// </editor-fold>//GEN-END:initComponents
        //
    private void B_SiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_SiguienteActionPerformed
        autenticarUsuario();
        
    }//GEN-LAST:event_B_SiguienteActionPerformed

    private void SiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SiguienteActionPerformed
        
        if (Comprobar1())
        {
            jTabbedPane1.setSelectedIndex(5);
        }
        
        
        
    }//GEN-LAST:event_SiguienteActionPerformed

    private void B_RegistrateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_RegistrateActionPerformed
        jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_B_RegistrateActionPerformed

    private void Siguiente2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Siguiente2ActionPerformed
       if (archivoImagenSeleccionado != null) {
            jTabbedPane1.setSelectedIndex(4);
        }
        L_Aviso.setText("Seleccione una imagen");
       
    }//GEN-LAST:event_Siguiente2ActionPerformed

    private void B_IniciaSesionCreaCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_IniciaSesionCreaCuentaActionPerformed
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_B_IniciaSesionCreaCuentaActionPerformed

    private void B_TerminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_TerminarActionPerformed

        try {
            registrarUsuario();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_B_TerminarActionPerformed

    private void Check_DeporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Check_DeporteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Check_DeporteActionPerformed

    private void Check_ArteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Check_ArteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Check_ArteActionPerformed

    private void Check_FamososActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Check_FamososActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Check_FamososActionPerformed

    private void Check_AnimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Check_AnimeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Check_AnimeActionPerformed

    private void Check_PeliculasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Check_PeliculasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Check_PeliculasActionPerformed

    private void Check_ManualidadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Check_ManualidadesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Check_ManualidadesActionPerformed

    private void Check_AstrologiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Check_AstrologiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Check_AstrologiaActionPerformed

    private void Check_VideoJuegosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Check_VideoJuegosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Check_VideoJuegosActionPerformed

    private void Check_AnimalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Check_AnimalesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Check_AnimalesActionPerformed

    private void Check_TecnologiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Check_TecnologiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Check_TecnologiaActionPerformed

    private void Check_ViajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Check_ViajeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Check_ViajeActionPerformed

    private void Check_CocinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Check_CocinaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Check_CocinaActionPerformed

    private void Check_TeatroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Check_TeatroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Check_TeatroActionPerformed

    private void Check_ProgramacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Check_ProgramacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Check_ProgramacionActionPerformed

    private void Check_MusicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Check_MusicaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Check_MusicaActionPerformed

    private void Check_ModaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Check_ModaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Check_ModaActionPerformed

    private void B_IniciaSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_IniciaSActionPerformed
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_B_IniciaSActionPerformed

    private void B_CreaCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_CreaCuentaActionPerformed
        jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_B_CreaCuentaActionPerformed

    private void jFileChooserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFileChooserActionPerformed
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

    }//GEN-LAST:event_jFileChooserActionPerformed

    private void B_VolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_VolverActionPerformed
       jTabbedPane1.setSelectedIndex(5);
    }//GEN-LAST:event_B_VolverActionPerformed

    private void B_Volver1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_Volver1ActionPerformed
        jTabbedPane1.setSelectedIndex(3);
    }//GEN-LAST:event_B_Volver1ActionPerformed

    private void B_ElegirOtraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_ElegirOtraActionPerformed
        J_Archivos.setVisible(true);
    J_C_Foto.setVisible(false);
    jFileChooser.setSelectedFile(null); // Limpiar selección previa
    L_Foto.setIcon(null); 
    }//GEN-LAST:event_B_ElegirOtraActionPerformed

    private void Siguiente1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Siguiente1ActionPerformed
        if (Comprobar2())
        {
            jTabbedPane1.setSelectedIndex(3);
        }
        
    }//GEN-LAST:event_Siguiente1ActionPerformed

    private void B_RegresarCC2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_RegresarCC2ActionPerformed
        jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_B_RegresarCC2ActionPerformed

    private void CB_AnioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CB_AnioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CB_AnioActionPerformed

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
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new Inicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton B_CreaCuenta;
    private javax.swing.JButton B_ElegirOtra;
    private javax.swing.JButton B_IniciaS;
    private javax.swing.JButton B_IniciaSesionCreaCuenta;
    private javax.swing.JButton B_Registrate;
    private javax.swing.JButton B_RegresarCC2;
    private javax.swing.JButton B_Siguiente;
    private javax.swing.JButton B_Terminar;
    private javax.swing.JButton B_Volver;
    private javax.swing.JButton B_Volver1;
    private javax.swing.JComboBox<String> CB_Anio;
    private javax.swing.JComboBox<String> CB_Dia;
    private javax.swing.JComboBox<String> CB_Lada;
    private javax.swing.JComboBox<String> CB_Mes;
    private javax.swing.JComboBox<String> CB_Pais;
    private javax.swing.JComboBox<String> CB_Sexo;
    private javax.swing.JCheckBox Check_Animales;
    private javax.swing.JCheckBox Check_Anime;
    private javax.swing.JCheckBox Check_Arte;
    private javax.swing.JCheckBox Check_Astrologia;
    private javax.swing.JCheckBox Check_Cine;
    private javax.swing.JCheckBox Check_Cocina;
    private javax.swing.JCheckBox Check_Deporte;
    private javax.swing.JCheckBox Check_Espacio;
    private javax.swing.JCheckBox Check_Famosos;
    private javax.swing.JCheckBox Check_Fotografia;
    private javax.swing.JCheckBox Check_Manualidades;
    private javax.swing.JCheckBox Check_Moda;
    private javax.swing.JCheckBox Check_Musica;
    private javax.swing.JCheckBox Check_Noticias;
    private javax.swing.JCheckBox Check_Peliculas;
    private javax.swing.JCheckBox Check_Programacion;
    private javax.swing.JCheckBox Check_Series;
    private javax.swing.JCheckBox Check_Teatro;
    private javax.swing.JCheckBox Check_Tecnologia;
    private javax.swing.JCheckBox Check_Viaje;
    private javax.swing.JCheckBox Check_VideoJuegos;
    private javax.swing.JPanel Intereses;
    private javax.swing.JPanel J_Archivos;
    private javax.swing.JPanel J_C_Foto;
    private javax.swing.JPanel J_Conteiner;
    private javax.swing.JPanel J_CreaCuenta;
    private javax.swing.JPanel J_CreaCuenta1;
    private javax.swing.JPanel J_CreaCuenta2;
    private javax.swing.JPanel J_InicioS;
    private javax.swing.JPanel J_Inicioinicio;
    private javax.swing.JLabel L_Aviso;
    private javax.swing.JLabel L_Aviso10;
    private javax.swing.JLabel L_Aviso11;
    private javax.swing.JLabel L_Aviso2;
    private javax.swing.JLabel L_Aviso3;
    private javax.swing.JLabel L_Aviso4;
    private javax.swing.JLabel L_Aviso5;
    private javax.swing.JLabel L_Aviso6;
    private javax.swing.JLabel L_Aviso7;
    private javax.swing.JLabel L_Aviso8;
    private javax.swing.JLabel L_Aviso9;
    private javax.swing.JLabel L_Contra;
    private javax.swing.JLabel L_Contra1;
    private javax.swing.JLabel L_Correo;
    private javax.swing.JLabel L_CorreoC;
    private javax.swing.JLabel L_Crea;
    private javax.swing.JLabel L_Crea1;
    private javax.swing.JLabel L_Crea2;
    private javax.swing.JLabel L_Crea3;
    private javax.swing.JLabel L_FechaN;
    private javax.swing.JLabel L_Foto;
    private javax.swing.JLabel L_Inicia;
    private javax.swing.JLabel L_LoQuePAsa;
    private javax.swing.JLabel L_Nombre;
    private javax.swing.JLabel L_Nombre1;
    private javax.swing.JLabel L_Nombre2;
    private javax.swing.JLabel L_Pais;
    private javax.swing.JLabel L_Pais1;
    private javax.swing.JLabel L_PrivCookies;
    private javax.swing.JLabel L_Seleccione;
    private javax.swing.JLabel L_Telefono;
    private javax.swing.JLabel L_UneteHoy;
    private javax.swing.JLabel L_Usuario;
    private javax.swing.JLabel L_YaCuenta;
    private javax.swing.JLabel L_YaCuenta1;
    private javax.swing.JLabel L_YaCuenta2;
    private javax.swing.JLabel L_in;
    private javax.swing.JLabel LabelOR;
    private javax.swing.JLabel LabelOR1;
    private javax.swing.JPanel PanelFLotante;
    private javax.swing.JPanel PanelFlotante;
    private javax.swing.JPanel PanelFlotante1;
    private javax.swing.JPanel PanelFlotante2;
    private javax.swing.JPanel PanelFlotante3;
    private javax.swing.JSeparator SeparadorDer;
    private javax.swing.JSeparator SeparadorDer1;
    private javax.swing.JSeparator SeparadorIzq;
    private javax.swing.JSeparator SeparadorIzq1;
    private javax.swing.JButton Siguiente;
    private javax.swing.JButton Siguiente1;
    private javax.swing.JButton Siguiente2;
    private javax.swing.JTextPane TP_Apellido;
    private javax.swing.JPasswordField TP_Contasenia;
    private javax.swing.JPasswordField TP_Contra;
    private javax.swing.JTextPane TP_Correo;
    private javax.swing.JTextPane TP_CorreoC;
    private javax.swing.JTextPane TP_Nombre;
    private javax.swing.JTextPane TP_Telefono;
    private javax.swing.JTextPane TP_Usuario;
    private javax.swing.JFileChooser jFileChooser;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
