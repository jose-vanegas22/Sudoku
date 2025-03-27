package com.example.juegosudoku.controllers;

import javafx.fxml.FXML;
import javafx.scene.layout.VBox;

/**
 * Controller for the instrucciones.fxml
 * This class help a show the user the game instructions
 *
 * @author vaneg
 * @author Alejandro Mendina
 * @version 1.0
 */
public class InstruccionesController {

    @FXML
    private VBox vBoxInstrucciones;

    /**
     * this method executes when the app runs and shows it the image
     */
    @FXML
    public void initialize(){
        String imagePath = getClass().getResource("/com/example/juegosudoku/Imagenes/imagenInicio.jpg").toExternalForm();
        vBoxInstrucciones.setStyle("-fx-background-image: url('" + imagePath + "'); -fx-background-size: cover;");
    }
}
