/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyect_y;
import Conection.DB_Conection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author gisel
 */
public class NotificacionesDAO {

    Connection conn =  DB_Conection.conectar(); 

    public NotificacionesDAO() {
        
    }

public List<Object[]> obtenerNotificaciones(String idUsuarioReceptor, int pagina, int cantidad, String tipoFiltro) {
    List<Object[]> lista = new ArrayList<>();
    String sql = "SELECT n.*, u.foto_perfil FROM notificacion n JOIN usuario u ON n.id_usuario_emisor = u.id_usuario WHERE n.id_usuario_receptor = ?";
    
    if (!tipoFiltro.equals("todas")) {
        if (tipoFiltro.equals("leidas")) {
            sql += " AND n.visto = 1";
        } else if (tipoFiltro.equals("no leidas")) {
            sql += " AND n.visto = 0";
        }
    }
    
    sql += " ORDER BY n.fecha DESC LIMIT ? OFFSET ?";

    try (Connection con = DB_Conection.conectar();
         PreparedStatement ps = con.prepareStatement(sql)) {
        
        ps.setString(1, idUsuarioReceptor);
        ps.setInt(2, cantidad);
        ps.setInt(3, pagina * cantidad);
        
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
            Object[] fila = new Object[7];
            fila[0] = rs.getString("id_usuario_emisor");
            fila[1] = rs.getString("tipo");
            fila[2] = rs.getTimestamp("fecha");
            fila[3] = rs.getInt("visto"); // <= Aquí se trata como BIT
            fila[4] = rs.getBytes("foto_perfil");
            fila[5] = rs.getObject("id_publicacion") != null ? rs.getInt("id_publicacion") : null;
            fila[6] = rs.getObject("id_comentario") != null ? rs.getInt("id_comentario") : null;
            lista.add(fila);
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return lista;
}


public void marcarComoVista(String idUsuarioReceptor, String idUsuarioEmisor, Timestamp fecha) {
    String sql = "UPDATE notificacion SET visto = 1 WHERE id_usuario_receptor = ? AND id_usuario_emisor = ? AND fecha = ?";
    try (Connection con = DB_Conection.conectar();
         PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setString(1, idUsuarioReceptor);
        ps.setString(2, idUsuarioEmisor);
        ps.setTimestamp(3, fecha);
        ps.executeUpdate();
    } catch (Exception e) {
        e.printStackTrace();
    }
}

    
    public void insertarNotificacion(String idReceptor, String idEmisor, String idPublicacion, String idComentario, String tipo) {
    String query = "INSERT INTO notificacion (id_usuario_receptor, id_usuario_emisor, id_publicacion, id_comentario, tipo, visto, fecha) VALUES (?, ?, ?, ?, ?, 0, NOW())";
    try (PreparedStatement ps = conn.prepareStatement(query)) {
        ps.setString(1, idReceptor);
        ps.setString(2, idEmisor);
        ps.setString(3, idPublicacion);
        if (idComentario != null) {
            ps.setString(4, idComentario);
        } else {
            ps.setNull(4, java.sql.Types.INTEGER);
        }
        ps.setString(5, tipo);
        ps.executeUpdate();
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
}


}
