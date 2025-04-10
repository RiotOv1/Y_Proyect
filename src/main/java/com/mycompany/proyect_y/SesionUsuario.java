/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyect_y;

/**
 *
 * @author gisel
 */
public class SesionUsuario {
    public static String idUsuario = null;

    public static void iniciarSesion(String id) {
        idUsuario = id;
    }

    public static void cerrarSesion() {
        idUsuario = null;
    }
}