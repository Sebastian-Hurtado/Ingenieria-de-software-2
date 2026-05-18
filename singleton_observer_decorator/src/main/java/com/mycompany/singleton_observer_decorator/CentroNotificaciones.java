/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.singleton_observer_decorator;

/**
 *
 * @author dseva
 */
import java.util.ArrayList;
import java.util.List;

public class CentroNotificaciones {

    private static CentroNotificaciones instancia;

    private List<Observador> usuarios;

    private CentroNotificaciones() {
        usuarios = new ArrayList<>();
    }

    public static CentroNotificaciones getInstancia() {
        if (instancia == null) {
            instancia = new CentroNotificaciones();
        }

        return instancia;
    }

    public void agregarUsuario(Observador usuario) {
        usuarios.add(usuario);
    }

    public void eliminarUsuario(Observador usuario) {
        usuarios.remove(usuario);
    }

    public void enviarNotificacion(Notificacion notificacion) {
        for (Observador usuario : usuarios) {
            usuario.actualizar(notificacion.getMensaje());
        }
    }
}