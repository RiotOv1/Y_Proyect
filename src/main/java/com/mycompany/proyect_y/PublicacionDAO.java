    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyect_y;

import Conection.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author irami
 */
public class PublicacionDAO {
    private Connection connection;
    //private DBConnection dbConnection;
    
    public PublicacionDAO(){
        //dbConnection = new DBConnection();
        connection = new DBConnection().getConnection();
    }
   
    
   public List<Publicacion> obtenerTodasPublicaciones() {
        List<Publicacion> publicaciones = new ArrayList<>();
        String sql = "SELECT p.*, u.foto_perfil FROM Publicacion p " +
                     "JOIN Usuario u ON p.id_usuario = u.id_usuario " +
                     "ORDER BY p.fecha_hora DESC";
        
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                Publicacion publi = new Publicacion(
                    rs.getInt("id_publicacion"),
                    rs.getString("texto"),
                    rs.getBytes("multimedia_publi"),
                    rs.getTimestamp("fecha_hora"),
                    rs.getInt("num_reacciones"),
                    rs.getInt("num_compartidos"),
                    rs.getString("id_usuario")
                );
                publi.setFotoPerfilUsuario(rs.getBytes("foto_perfil"));
                publicaciones.add(publi);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return publicaciones;
    }

    public boolean darLike(int idPublicacion) {
        String sql = "UPDATE Publicacion SET num_reacciones = num_reacciones + 1 WHERE id_publicacion = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, idPublicacion);
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean repostear(int idPublicacion) {
        String sql = "UPDATE Publicacion SET num_compartidos = num_compartidos + 1 WHERE id_publicacion = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, idPublicacion);
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
}
