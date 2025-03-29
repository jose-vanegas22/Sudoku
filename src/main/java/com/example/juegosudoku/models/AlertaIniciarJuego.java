package com.example.juegosudoku.models;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

/**
 * This class implements AlertaIniciarJuegoInterface
 */
public class AlertaIniciarJuego implements AlertaIniciarJuegoInterface {

    @Override
    public void mostrarAlerta(String tittle, String header, String content) {

        /**
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(tittle);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
         **/
    }

    /**
     *This method that shows an alert window
     * @param tittle
     * @param header
     * @param content
     * @return true or false according to the case
     */
    //Metodo el cual muestra una ventana de alerta, es de tipo boolean para que nos pueda devolver un true o un false
    @Override
    public boolean mostrarAlertaDeConfirmacion(String tittle, String header, String content) {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(tittle);
        alert.setHeaderText(header);
        alert.setContentText(content);

        Optional<ButtonType> result = alert.showAndWait(); //Permite mostrar la alerta y espera la respuesta del usuraio

        return result.isPresent() && result.get() == ButtonType.OK; //Retorna true si el usuario presiono ok, false en el otro caso
    }
}

