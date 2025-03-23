package com.example.juegosudoku.controlls;

import com.example.juegosudoku.models.Jugador;
import com.example.juegosudoku.views.SudokuView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class IniciarSudokuController {

    @FXML
    private TextField nombreTextField;

    @FXML
    private VBox vBox;

    @FXML
    void onActionIniciarBoton(ActionEvent actionEvent) throws IOException {

        String nombre = nombreTextField.getText();
        Jugador jugador = new Jugador();
        jugador.setNombre(nombre);

        SudokuView sudokuView = SudokuView.getInstance();
        sudokuView.show();
        sudokuView.getController().setJugador(jugador);
        sudokuView.getController().mostrarNombreLabel();



    }

    @FXML
    public void initialize() {
        // Verificar la ruta de la imagen
        String imagePath = getClass().getResource("/com/example/juegosudoku/Imagenes/imagenInicio.jpg").toExternalForm();
        vBox.setStyle("-fx-background-image: url('" + imagePath + "'); -fx-background-size: cover;");
    }
}


