/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.tallerpatterns;

/**
 *
 * @author dseva
 */


public class Tallerpatterns {

    public static void main(String[] args) {

        ConexionBD conexion1 = ConexionBD.getInstancia();
        ConexionBD conexion2 = ConexionBD.getInstancia();

        if (conexion1 == conexion2) {

            System.out.println("Es la misma instancia de conexion");

        } else {

            System.out.println("Son instancias diferentes");

        }

    }

}
