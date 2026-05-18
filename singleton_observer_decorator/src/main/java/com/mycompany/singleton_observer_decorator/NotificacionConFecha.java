/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.singleton_observer_decorator;

/**
 *
 * @author dseva
 */
import java.time.LocalDateTime;

public class NotificacionConFecha extends NotificacionDecorator {

    public NotificacionConFecha(Notificacion notificacion) {
        super(notificacion);
    }

    @Override
    public String getMensaje() {
        return notificacion.getMensaje()
                + " | Fecha: " + LocalDateTime.now();
    }
}