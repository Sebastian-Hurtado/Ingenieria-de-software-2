/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.singleton_observer_decorator;

/**
 *
 * @author dseva
 */
public class Singleton_observer_decorator {

    public static void main(String[] args) {
        CentroNotificaciones centro =
                CentroNotificaciones.getInstancia();

        Observador usuario1 = new Usuario("Carlos");
        Observador usuario2 = new Usuario("Ana");
        Observador usuario3 = new Usuario("Luis");

        centro.agregarUsuario(usuario1);
        centro.agregarUsuario(usuario2);
        centro.agregarUsuario(usuario3);

        Notificacion notificacion =
                new NotificacionBase("Hay una nueva actualizacion del sistema");

        notificacion =
                new NotificacionUrgente(notificacion);

        notificacion =
                new NotificacionConFecha(notificacion);

        centro.enviarNotificacion(notificacion);
    }
}
