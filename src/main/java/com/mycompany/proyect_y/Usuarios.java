/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyect_y;

/**
 * Clase de usuarios para cuando se busquen en la pestaña de "Explorar" salgan los usuarios que hay dentro de la base de datos
 * @author irami
 */
public class Usuarios {
    private String user_name;
    private String correo_user;
    private byte[] imagen_perfil_usuario;
    
    //Constructor extendido
    public Usuarios(String use, String corr, byte[] image_pe_u){
        user_name = use;
        correo_user = corr;
        imagen_perfil_usuario = image_pe_u;
    }
    
    //Getters y setters
    public byte[] getImagenPerfil(){
        return imagen_perfil_usuario;
    }
    
    public void setImagenPerfil(byte[] img){
        imagen_perfil_usuario = img;
    }
    
   public String getUserName(){
       return user_name;
   }
   
   public void setUserName(String user_name){
       this.user_name = user_name;
   }
   
   public String getCorreoEle(){
       return correo_user;
   }
   
   public void setCorreoEle(String correo_user){
       this.correo_user = correo_user;
   }
   
   
}
