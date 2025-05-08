/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyect_y;

import java.sql.Timestamp;

/**
 *
 * @author dafmo
 * comentario
 */
public class Comentarios {
    private int id_comentario;
    private String id_usuario;
    private int id_publicacion;
    private String texto;
    private byte[] Multimedia;
    private int NumeroReacciones;
    private int numCompartidos;
    private int NumeroRespuestas;
    private Timestamp fechaHora;
     private byte[] fotoPerfilUsuario;
    
    //Constructor
    public Comentarios (int id_c, String id_u, int id_p, String Contenido, byte[] multi, int num_l, int num_c, Timestamp fecha){
        id_comentario = id_c;
        id_usuario = id_u;
        id_publicacion = id_p;
        texto = Contenido;
        Multimedia = multi;
        NumeroReacciones = num_l;
        numCompartidos = num_c;
        fechaHora = fecha;
    }
    
    //Getter y Setters
    
    public byte[] getFotoPerfilUsuario(){
        return fotoPerfilUsuario;
    }
    
    public void setFotoPerfilUsuario(byte[] fotoPerfilUsuario){
        this.fotoPerfilUsuario = fotoPerfilUsuario;
    }
    
    public int getid_comentario() { return id_comentario; }
    public void setid_comentario(int id_comentario) { this.id_comentario = id_comentario; }
    
    public int getid_publicacion() { return id_publicacion; }
    public void setid_publicacion(int id_publicacion) { this.id_publicacion = id_publicacion; }
    
    public String getTexto() { return texto; }
    public void setTexto(String texto) { this.texto = texto; }
    
    public byte[] getMultimedia() { return Multimedia; }
    public void setMultimedia(byte[] Multimedia) { this.Multimedia = Multimedia; }
    
    public Timestamp getFechaHora() { return fechaHora; }
    public void setFechaHora(Timestamp fechaHora) { this.fechaHora = fechaHora; }
    
    public int getNumeroReacciones() { return NumeroReacciones; }
    public void setNumeroReacciones(int NumeroReacciones) { this.NumeroReacciones = NumeroReacciones; }
    
    public int getNumCompartidos() { return numCompartidos; }
    public void setNumCompartidos(int numCompartidos) { this.numCompartidos = numCompartidos; }
    
    public String getIdUsuario() { return id_usuario; }
    public void setIdUsuario(String id_usuario) { this.id_usuario = id_usuario; }
    
    
    
    
}
