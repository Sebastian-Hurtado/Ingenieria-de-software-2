/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.adapter_strategy;

/**
 *
 * @author dseva
 */
public class Adapter_strategy {

    public static void main(String[] args) {
        SistemaReportes sistema =
                new SistemaReportes();

        // PDF
        sistema.setEstrategia(
                new ExportadorPDF()
        );

        sistema.generarReporte(
                "Reporte de ventas"
        );

        // Excel
        sistema.setEstrategia(
                new ExportadorExcelAdapter()
        );

        sistema.generarReporte(
                "Reporte financiero"
        );

        // Word
        sistema.setEstrategia(
                new ExportadorWordAdapter()
        );

        sistema.generarReporte(
                "Reporte administrativo"
        );

    }
}

