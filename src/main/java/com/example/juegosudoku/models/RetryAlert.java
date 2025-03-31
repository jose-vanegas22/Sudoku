package com.example.juegosudoku.models;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

/**
 * This class contains a retry alert implementing AlertaInterface
 */
public class RetryAlert implements AlertaInterface {
    @Override
    public void mostrarAlerta(String tittle, String header, String content) {

    }

    /**
     * This method shows the alert window
     * @param tittle
     * @param header
     * @param content
     * @return true or false according to the option chosen by the user
     */
    @Override
    public boolean mostrarAlertaDeConfirmacion(String tittle, String header, String content) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(tittle);
        alert.setHeaderText(header);
        alert.setContentText(content);

        Optional<ButtonType> result = alert.showAndWait();

        return result.isPresent() && result.get() == ButtonType.OK;
    }
}
