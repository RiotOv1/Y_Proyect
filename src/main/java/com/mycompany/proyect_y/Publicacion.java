/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyect_y;

import java.sql.Timestamp;

/**
 *
 * @author irami
 */
public class Publicacion {
    private int idPublicacion;
    private String texto;
    private byte[] multimediaPubli;
    private Timestamp fechaHora;
    private int numReacciones;
    private int numCompartidos;
    private String idUsuario;
    private byte[] fotoPerfilUsuario;
    
    //Constructor extendido
    public Publicacion(int idPub,String tex, byte[] multi, Timestamp fecha, int numR, int numC, String idUs){
        idPublicacion = idPub;
        texto = tex;
        multimediaPubli = multi;
        fechaHora = fecha;
        numReacciones = numR;
        numCompartidos = numC;
        idUsuario = idUs;
    }
    
    // Getters y Setters
    public byte[] getFotoPerfilUsuario(){
        return fotoPerfilUsuario;
    }
    
    public void setFotoPerfilUsuario(byte[] fotoPerfilUsuario){
        this.fotoPerfilUsuario = fotoPerfilUsuario;
    }
    
    public int getIdPublicacion() { return idPublicacion; }
    public void setIdPublicacion(int idPublicacion) { this.idPublicacion = idPublicacion; }
    
    public String getTexto() { return texto; }
    public void setTexto(String texto) { this.texto = texto; }
    
    public byte[] getMultimediaPubli() { return multimediaPubli; }
    public void setMultimediaPubli(byte[] multimediaPubli) { this.multimediaPubli = multimediaPubli; }
    
    public Timestamp getFechaHora() { return fechaHora; }
    public void setFechaHora(Timestamp fechaHora) { this.fechaHora = fechaHora; }
    
    public int getNumReacciones() { return numReacciones; }
    public void setNumReacciones(int numReacciones) { this.numReacciones = numReacciones; }
    
    public int getNumCompartidos() { return numCompartidos; }
    public void setNumCompartidos(int numCompartidos) { this.numCompartidos = numCompartidos; }
    
    public String getIdUsuario() { return idUsuario; }
    public void setIdUsuario(String idUsuario) { this.idUsuario = idUsuario; }
    
}
