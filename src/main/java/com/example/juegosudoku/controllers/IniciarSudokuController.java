package com.example.juegosudoku.controllers;

import com.example.juegosudoku.models.Jugador;
import com.example.juegosudoku.views.InstruccionesView;
import com.example.juegosudoku.views.SudokuView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.io.IOException;

/**
 *Controller for the iniciarSudoku.fxml
 *This class help the user start the Sudoku game
 *
 * @author vaneg
 * @author Alejandro Medina
 * @version 1.0
 */
public class IniciarSudokuController {

    @FXML
    private TextField nombreTextField;

    @FXML
    private VBox vBox;

    @FXML
    private Label errorNombreLabel;

    /**
     *onActionIniciarBoton handles(maneja) the action when you press start
     * A jugador object is created and the name is assigned to it
     *Created an instace of the class SudokuView and showed it
     * @param actionEvent
     * @throws IOException
     */
    @FXML
    void onActionIniciarBoton(ActionEvent actionEvent) throws IOException {

        String nombre = nombreTextField.getText().trim(); //El trim() se usa para eliminar espacios antes y despues
        nombreTextField.setText("");

        if (nombre.isEmpty()) {
            errorNombreLabel.setText("El nombre es obligatorio.");
            return;
        }
        errorNombreLabel.setText(""); //Limpia el label del mensaje de error cuando ingresa correctamente un nombre

        Jugador jugador = new Jugador();
        jugador.setNombre(nombre);


        SudokuView sudokuView = SudokuView.getInstance(); //Se crea una instancia, es la clase la cual se encarga de mostrar la ventana
        sudokuView.show();
        sudokuView.getController().setJugador(jugador); //Permite pasar el nombre del jugador ingresado en esta clase a SudokuController
        sudokuView.getController().mostrarNombreLabel(); //Llama a un metodo de SudokuController que permite mostrar el nombre en la otra interfaz
    }


    /**
     * onActionInstruccionesBoton handles the action when you press Instrucciones
     * Created an instance of the class InstruccionesView and showed it
     * @param actionEvent
     * @throws IOException
     */
    @FXML
    void onActionInstruccionesBoton(ActionEvent actionEvent) throws IOException {
        InstruccionesView instruccionesView = InstruccionesView.getInstance();
        instruccionesView.show();
    }

    /**
     * This method runs when the app starts and shows an image
     */
    @FXML
    public void initialize() {
        // Verificar la ruta de la imagen
        String imagePath = getClass().getResource("/com/example/juegosudoku/Imagenes/imagenInicio.jpg").toExternalForm();
        vBox.setStyle("-fx-background-image: url('" + imagePath + "'); -fx-background-size: cover;");
    }
}


