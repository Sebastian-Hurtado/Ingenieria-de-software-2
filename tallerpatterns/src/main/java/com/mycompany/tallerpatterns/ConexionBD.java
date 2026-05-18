/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tallerpatterns;

/**
 *
 * @author dseva
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    private static ConexionBD instancia;
    private Connection conexion;

    private static final String URL = "jdbc:mysql://localhost:3310/mi_base";
    private static final String USUARIO = "root";
    private static final String PASSWORD = "1234";

    private ConexionBD() {
        try {
            conexion = DriverManager.getConnection(URL, USUARIO, PASSWORD);
            System.out.println("Conexion creada correctamente");
        } catch (SQLException e) {
            System.out.println("Error al conectar: " + e.getMessage());
        }
    }

    public static ConexionBD getInstancia() {
        if (instancia == null) {
            instancia = new ConexionBD();
        }
        return instancia;
    }

    public Connection getConexion() {
        return conexion;
    }
}
