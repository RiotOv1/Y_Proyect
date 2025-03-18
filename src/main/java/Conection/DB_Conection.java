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
    public String connectionstring = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=CONVERT_TO_NULL"; //Buscar el Connection String en su DBMS
    
    Connection cn;
    
    public void DB_Conection_o(Connection cn)
    {
        try {
            cn = DriverManager.getConnection(connectionstring, "Abril", "pass");
            System.out.print("Si se pudo");
        } catch (SQLException ex) {
            Logger.getLogger(DB_Conection.class.getName()).log(Level.SEVERE, null, ex);
            System.out.print("No se pudo conectar");
        }
        
        
    }

    
}
