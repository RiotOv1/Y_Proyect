/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyect_y;

import Conection.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author irami
 */
public class UsuariosDAO {
    private Connection connection;
    private String search;
    
    public UsuariosDAO(){
        //dbConnection = new DBConnection();
        connection = new DBConnection().getConnection();
    }
    
    /*public void getSearch(String search){
        this.search = search; 
    }*/
    
    public List<Usuarios> buscarUsuarios(String searchT, int page, int pagesize){
        List<Usuarios> usuarios = new ArrayList<>();
        String sql = "Select u.* FROM usuario u " + 
                "WHERE u.id_usuario LIKE ? OR u.correo LIKE ? " + 
                "ORDER BY u.id_usuario ASC " + 
                "LIMIT ? OFFSET ?";
        
        try(PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setString(1, "%" + searchT + "%");
            stmt.setString(2, "%" + searchT + "%");
            stmt.setInt(3, pagesize);
            stmt.setInt(4,(page-1)*pagesize);
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()){
                Usuarios usuario  = new Usuarios(
                        rs.getString("id_usuario"),
                        rs.getString("correo"),
                        rs.getBytes("foto_perfil")
                );
                usuarios.add(usuario);
            }
            rs.close();
        }
        catch(SQLException ex){
            ex.printStackTrace(); 
            }
           return usuarios;
        }
    
    
    
    }

