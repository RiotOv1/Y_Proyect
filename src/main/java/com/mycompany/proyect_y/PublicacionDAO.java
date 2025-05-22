    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyect_y;

import Conection.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    
    public static int idPubicacion = 0;
    public static void PublicacionSeleccionada(int id) {
        idPubicacion = id;
    }

    public static void cerrarSesion() {
        idPubicacion = 0;
    }
   
    public Publicacion obtenerPublicacionPorId(int idPublicacion) {
    Publicacion publi = null;
    String sql = "SELECT p.*, u.foto_perfil FROM Publicacion p " +
                 "JOIN Usuario u ON p.id_usuario = u.id_usuario " +
                 "WHERE p.id_publicacion = ?";

    try (PreparedStatement stmt = connection.prepareStatement(sql)) {
        stmt.setInt(1, idPublicacion);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            publi = new Publicacion(
                rs.getInt("id_publicacion"),
                rs.getString("texto"),
                rs.getBytes("multimedia_publi"),
                rs.getTimestamp("fecha_hora"),
                rs.getInt("num_reacciones"),
                rs.getInt("num_compartidos"),
                rs.getString("id_usuario")
            );
            publi.setFotoPerfilUsuario(rs.getBytes("foto_perfil"));
        }
        rs.close();
    } catch (SQLException ex) {
        ex.printStackTrace();
    }

    return publi;
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
   
public List<Object[]> obtenerTop3Publicaciones() {
    List<Object[]> publicaciones = new ArrayList<>();
    String sql = "SELECT id_publicacion, texto, num_reacciones " +
                 "FROM Publicacion " +
                 "ORDER BY num_reacciones DESC " +
                 "LIMIT 3";
    
    try (Statement stmt = connection.createStatement();
         ResultSet rs = stmt.executeQuery(sql)) {
        
        while (rs.next()) {
            Object[] datos = new Object[3];
            datos[0] = rs.getInt("id_publicacion");
            datos[1] = rs.getString("texto");
            datos[2] = rs.getInt("num_reacciones");
            publicaciones.add(datos);
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    return publicaciones;
}
   
   public List<Publicacion> obtenerPublicacionesDeSeguidos(List<String> idsSeguidos) {
    List<Publicacion> publicaciones = new ArrayList<>();
    if (idsSeguidos == null || idsSeguidos.isEmpty()) {
        return publicaciones; // no hay seguidos, no hay publicaciones
    }

    String placeholders = idsSeguidos.stream().map(id -> "?").collect(Collectors.joining(","));
    String sql = "SELECT p.*, u.foto_perfil FROM Publicacion p " +
                 "JOIN Usuario u ON p.id_usuario = u.id_usuario " +
                 "WHERE p.id_usuario IN (" + placeholders + ") " +
                 "ORDER BY p.fecha_hora DESC";

    try (PreparedStatement stmt = connection.prepareStatement(sql)) {
        for (int i = 0; i < idsSeguidos.size(); i++) {
            stmt.setString(i + 1, idsSeguidos.get(i));
        }

        ResultSet rs = stmt.executeQuery();
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
        rs.close();
    } catch (SQLException ex) {
        ex.printStackTrace();
    }

    return publicaciones;
}
   
   public List<Publicacion> obtenerTodasPublicacionesUsuario(String idUsuario) {
        List<Publicacion> publicaciones = new ArrayList<>();
        String sql = "SELECT p.*, u.foto_perfil FROM Publicacion p " +
                "JOIN Usuario u ON p.id_usuario = u.id_usuario " + 
                "WHERE p.id_usuario = ? AND multimedia_publi IS NOT NULL " +
                "ORDER BY fecha_hora DESC;";
        
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, idUsuario);
            ResultSet rs = ps.executeQuery();
        
            
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
                publicaciones.add(publi);
                publi.setFotoPerfilUsuario(rs.getBytes("foto_perfil"));
            
}} catch (SQLException ex) {
            ex.printStackTrace();
        }
        return publicaciones;
    }
   
   public List<Publicacion> obtenerTodasPublicacionesUsuarioTxt(String idUsuario) {
        List<Publicacion> publicacionestxt = new ArrayList<>();
        String sql = "SELECT p.*, u.foto_perfil FROM Publicacion p " +
                "JOIN Usuario u ON p.id_usuario = u.id_usuario " + 
                "WHERE p.id_usuario = ? AND multimedia_publi IS NULL " +
                "ORDER BY fecha_hora DESC;";
        
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, idUsuario);
            ResultSet rs = ps.executeQuery();
        
            
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
                publicacionestxt.add(publi);
                 publi.setFotoPerfilUsuario(rs.getBytes("foto_perfil"));
               
            
}} catch (SQLException ex) {
            ex.printStackTrace();
        }
        return publicacionestxt;
    }
   
   //Metodos de reacciones

    public boolean darLike(int idPublicacion, String U2) {
        NotificacionesDAO NDAO = new NotificacionesDAO();
        String sql = "UPDATE Publicacion SET num_reacciones = num_reacciones + 1 WHERE id_publicacion = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, idPublicacion);
            NDAO.insertarNotificacion(U2,SesionUsuario.idUsuario,String.valueOf(idPublicacion), null,"reaccion_post");
            
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    public boolean quitarLike(int idPublicacion){
        String sql = "UPDATE comentarios SET num_reacciones = num_reacciones - 1 WHERE id_publicacion = ?";
        try(PreparedStatement ps = connection.prepareCall(sql)){
            ps.setInt(1,idPublicacion);
            return ps.executeUpdate() > 0;
        }catch(SQLException ex){
            ex.printStackTrace();
            return false;
        }
    }

    public boolean repostear(int idPublicacion) {
        String sql = "UPDATE comentarios SET num_compartidos = num_compartidos + 1 WHERE id_publicacion = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, idPublicacion);
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    public boolean quitarRepost(int idPublicacion){
        String sql = "UPDATE comentarios SET num_compartidos = num_compartidos - 1 WHERE id_publicacion = ?";
        try(PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setInt(1, idPublicacion);
            return ps.executeUpdate() > 0;
        } catch(SQLException ex){
            ex.printStackTrace();
            return false;
        }
    }
    
    
    public List<Publicacion> buscarPublicacionesResult(String searchT, int page, int pagesize){
        List<Publicacion> publicaciones = new ArrayList<>();
        String sql = "SELECT p.*, u.foto_perfil FROM Publicacion p "+" JOIN Usuario u ON p.id_usuario = u.id_usuario " + "WHERE p.texto LIKE ? "
                + "ORDER BY p.fecha_hora DESC " + "LIMIT ? OFFSET ?";
        
        try(PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setString(1, "%"+searchT+"%");
            stmt.setInt(2, pagesize);
            stmt.setInt(3, (page-1)*pagesize);
            
            
            System.out.println("Ejecutanto consulta de SQL: " + stmt.toString());
            //ResultSet rs = stmt.executeQuery();
            try(ResultSet rs = stmt.executeQuery()){
                while(rs.next()){
                    Publicacion publi = new Publicacion(
                        rs.getInt("id_publicacion"),
                        rs.getString("texto"),
                        rs.getBytes("multimedia_publi"),
                        rs.getTimestamp("fecha_hora"),
                        rs.getInt("num_reacciones"),
                        rs.getInt("num_compartidos"),
                        rs.getString("id_usuario")
                    );
                    publicaciones.add(publi);
                }
                rs.close();
            }
        } catch(SQLException ex){
            ex.printStackTrace();
        }
        return publicaciones;
    }
    
}
