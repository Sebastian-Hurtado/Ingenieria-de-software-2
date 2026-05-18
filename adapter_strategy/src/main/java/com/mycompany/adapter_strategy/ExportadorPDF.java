/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.adapter_strategy;

/**
 *
 * @author dseva
 */
public class ExportadorPDF implements ExportadorStrategy {

    @Override
    public void exportar(String contenido) {

        System.out.println(
                "Exportando PDF: " + contenido
        );

    }

}