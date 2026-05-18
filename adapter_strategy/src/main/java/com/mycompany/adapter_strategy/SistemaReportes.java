/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.adapter_strategy;

/**
 *
 * @author dseva
 */
public class SistemaReportes {

    private ExportadorStrategy estrategia;

    public void setEstrategia(
            ExportadorStrategy estrategia
    ) {

        this.estrategia = estrategia;

    }

    public void generarReporte(String contenido) {

        estrategia.exportar(contenido);

    }

}
