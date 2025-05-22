/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gisel
 */
public class DB_Conection {
   private static final String URL = "jdbc:mysql://localhost:3306/y_bd?zeroDateTimeBehavior=CONVERT_TO_NULL";
private static final String USUARIO = "Abril"; // Cambia según tu usuario
    private static final String CONTRASEÑA = "pass"; // Cambia según tu contraseña

    // Método para conectar a la base de datos
    public static Connection conectar() {
        try {
            Connection cn = DriverManager.getConnection(URL, USUARIO, CONTRASEÑA);
            System.out.println("Conexión exitosa");
            return cn;
        } catch (SQLException ex) {
            Logger.getLogger(DB_Conection.class.getName()).log(Level.SEVERE, "No se pudo conectar", ex);
            return null;
        }
  
    }

    public PreparedStatement prepareStatement(String query) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
