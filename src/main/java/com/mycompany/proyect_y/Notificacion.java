/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyect_y;

import java.sql.Timestamp;

/**
 *
 * @author gisel
 */
public class Notificacion {
    private int idNotificacion;
    private String idUsuarioReceptor;
    private String idUsuarioEmisor;
    private Integer idPublicacion;
    private Integer idComentario;
    private String tipo;
    private boolean visto;
    private Timestamp fecha;

    // Constructor vacío
    public Notificacion() {}

    // Constructor completo (puedes hacer uno con menos parámetros si lo prefieres)
    public Notificacion(String receptor, String emisor, Integer publicacion, Integer comentario, String tipo) {
        this.idUsuarioReceptor = receptor;
        this.idUsuarioEmisor = emisor;
        this.idPublicacion = publicacion;
        this.idComentario = comentario;
        this.tipo = tipo;
        this.visto = false;
    }

    // Getters y Setters
    public String getIdUsuarioReceptor() { return idUsuarioReceptor; }
    public void setIdUsuarioReceptor(String idUsuarioReceptor) { this.idUsuarioReceptor = idUsuarioReceptor; }

    public String getIdUsuarioEmisor() { return idUsuarioEmisor; }
    public void setIdUsuarioEmisor(String idUsuarioEmisor) { this.idUsuarioEmisor = idUsuarioEmisor; }

    public Integer getIdPublicacion() { return idPublicacion; }
    public void setIdPublicacion(Integer idPublicacion) { this.idPublicacion = idPublicacion; }

    public Integer getIdComentario() { return idComentario; }
    public void setIdComentario(Integer idComentario) { this.idComentario = idComentario; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public boolean isVisto() { return visto; }
    public void setVisto(boolean visto) { this.visto = visto; }
    public Timestamp getFecha() {
    return fecha;
}

public void setFecha(Timestamp fecha) {
    this.fecha = fecha;
}

}
