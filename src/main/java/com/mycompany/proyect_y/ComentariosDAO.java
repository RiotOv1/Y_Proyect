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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author dafmo
 */
public class ComentariosDAO {
    private Connection connection;
    //private DBConnection dbConnection;
    int indiceComentarios = 0;
    public ComentariosDAO(){
        //dbConnection = new DBConnection();
        connection = new DBConnection().getConnection();
    }
    //Comentarios totales
    public List<Comentarios> obtenerTodosComentarios(int idPublicacion) {
        List<Comentarios> ListaComentarios = new ArrayList<>();
        String sql =  """
                     SELECT c.*, u.foto_perfil,p.multimedia_publi FROM comentarios c JOIN
                         Usuario u ON c.id_usuario = u.id_usuario
                     JOIN
                         publicacion p ON c.id_publicacion = p.id_publicacion
                     WHERE
                         c.id_publicacion = ?
                         AND p.multimedia_publi IS NOT NULL
                     ORDER BY    c.fecha_hora DESC;""";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, PublicacionDAO.idPubicacion);
            ResultSet rs = stmt.executeQuery();
            
            
            while (rs.next()) {
                Comentarios coment = new Comentarios(
                    rs.getInt("id_comentario"),
                    rs.getString("id_usuario"),
                    rs.getInt("id_publicacion"),
                    rs.getString("texto"),
                    rs.getBytes("Multimedia_com"),
                    rs.getInt("num_reacciones"),
                    rs.getInt("num_compartidos"),
                    rs.getTimestamp("fecha_hora")
                );
                
                coment.setFotoPerfilUsuario(rs.getBytes("foto_perfil"));
                ListaComentarios.add(coment);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ListaComentarios;
    }
    
    //Metodos de reacciones

    public boolean darLike(int idcomentario, String U2) {
        NotificacionesDAO NDAO = new NotificacionesDAO();
        String sql = "UPDATE comentarios SET num_reacciones = num_reacciones + 1 WHERE id_publicacion = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, idcomentario);
            NDAO.insertarNotificacion(U2,SesionUsuario.idUsuario,null, String.valueOf(idcomentario),"reaccion_comentario");
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    public boolean quitarLike(int idcomentario){
        String sql = "UPDATE Publicacion SET num_reacciones = num_reacciones - 1 WHERE id_publicacion = ?";
        try(PreparedStatement ps = connection.prepareCall(sql)){
            ps.setInt(1,idcomentario);
            return ps.executeUpdate() > 0;
        }catch(SQLException ex){
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
    
    public boolean quitarRepost(int idcomentario){
        String sql = "UPDATE Publicacion SET num_compartidos = num_compartidos - 1 WHERE id_publicacion = ?";
        try(PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setInt(1, idcomentario);
            return ps.executeUpdate() > 0;
        } catch(SQLException ex){
            ex.printStackTrace();
            return false;
        }
    }
    
}
