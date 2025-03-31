package com.example.juegosudoku.models;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public class RetryAlert implements AlertaInterface {
    @Override
    public void mostrarAlerta(String tittle, String header, String content) {

    }

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
