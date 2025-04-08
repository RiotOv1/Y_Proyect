/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gisel
 */
public class DB_Conection {
    public static Connection conectar(){
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/y_bd?useSSL=false&serverTimezone=UTC", "root", "");
            System.out.println("Conexión exitosa");
            return cn;
        } catch (SQLException ex) {
            Logger.getLogger(DB_Conection.class.getName()).log(Level.SEVERE, "No se pudo conectar", ex);
            return null;
        }
    }

    
}
