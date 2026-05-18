/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.adapter_strategy;

/**
 *
 * @author dseva
 */
public class ExportadorExcelAdapter
        implements ExportadorStrategy {

    private LibreriaExcel excel;

    public ExportadorExcelAdapter() {

        excel = new LibreriaExcel();

    }

    @Override
    public void exportar(String contenido) {

        excel.crearArchivoExcel(contenido);

    }

}
