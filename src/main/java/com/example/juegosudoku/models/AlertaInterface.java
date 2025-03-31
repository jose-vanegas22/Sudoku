package com.example.juegosudoku.models;

/**
 * This interface has a contract for an alert
 */
public interface AlertaInterface {

    void mostrarAlerta(String tittle, String header, String content); //titulo, encabezado y contenido de la alerta
    boolean mostrarAlertaDeConfirmacion(String tittle, String header, String content);
}
