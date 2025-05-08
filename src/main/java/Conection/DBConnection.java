/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conection;

/*Imports*/
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/*Final de Imports*/


/**
 *
 * @author irami
 */
public class DBConnection{
    private static final String DB_URL = "jdbc:mysql://localhost:3306/y_bd?zeroDateTimeBehavior=CONVERT_TO_NULL";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";
    private Connection connection;
    private static final Logger LOGGER = Logger.getLogger(DBConnection.class.getName());
    
    /*Constructor para inicializar la conexión*/
    public DBConnection(){
        initializeConnection(); 
    }
    
    /*Inicializar conexión a la base de datos*/
    public void initializeConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            if(connection != null){
                LOGGER.log(Level.INFO,"Conexion establecida correctamente");
            }
            else{
                LOGGER.log(Level.SEVERE,"No se pudo establecer la conexion");
            }
        }catch (ClassNotFoundException ex){
            LOGGER.log(Level.SEVERE,"Error al cargar el driver JDBC", ex);
        } catch (SQLException ex){
            LOGGER.log(Level.SEVERE, "Error al conectar a la base de datos", ex);
        }
    }
    //Obtener la conexion a la base de datos
    public Connection getConnection(){
        try{
            if(connection==null || connection.isClosed()){
                initializeConnection();
            }
        }catch(SQLException ex){
            LOGGER.log(Level.SEVERE,"Error al verificar al estado de la conexion", ex);
        }
        return this.connection;
    }
    
    //Cerrar conexion a la base de datos 
    public void closeConnection(){
        if(connection !=null){
            try{
                connection.close();
                connection = null;
                LOGGER.log(Level.INFO, "Conexion establecida correctamente");
            }catch(SQLException ex){
                LOGGER.log(Level.SEVERE,"Error al cerrarla conexion",ex);
            }
        }
    }
    //Funcion main para comprobar que la conexion a la base de datos sea exitosa
    /*public static void main(String[] args) {
        DBConnection dbConnection = new DBConnection();
        Connection conn = dbConnection.getConnection();

        try {
            if (conn != null && !conn.isClosed()) {
                System.out.println("Conexion exitosa a la base de datos!");

                // Opcional: ejecutar una consulta simple para verificar
                try (var stmt = conn.createStatement();
                     var rs = stmt.executeQuery("SELECT 1")) {
                    if (rs.next()) {
                        System.out.println("Consulta de prueba ejecutada correctamente. Valor recibido: " + rs.getInt(1));
                    }
                }
            } else {
                System.out.println("No se pudo establecer la conexión");
            }
        } catch (SQLException ex) {
            System.err.println("Error al verificar la conexión: " + ex.getMessage());
        } finally {
            dbConnection.closeConnection();
        }
    }*/ 
    
}
