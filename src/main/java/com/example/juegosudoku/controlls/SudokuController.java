package com.example.juegosudoku.controlls;

import com.example.juegosudoku.models.Jugador;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class SudokuController {

    private static final int SizeSudoku = 6; //Aqui defino el tamaño del sudoku 6x6
    private static final int SizeCeldas = 50; //Tamaño de las celdas 50px x 50px

    private TextField[][] celdas = new TextField[SizeSudoku][SizeSudoku]; //Matriz para almacenar las celdas

    @FXML
    private GridPane celdasSudoku;

    @FXML
    private Label nombreLabel;

    private Jugador jugador;


    public void initialize(){
        for (int filas = 0; filas < SizeSudoku; filas++) { //Este for recorre todas las filas
            for (int columnas = 0; columnas < SizeSudoku; columnas++) { //Este ford recorre las columnas
                TextField celda = new TextField(); //Cada que pasa por aqui crea una celda
                celda.setPrefSize(SizeCeldas, SizeCeldas); //Le da tamaño a la celda 50px x 50px
                celda.setStyle("-fx-font-size: 18px; -fx-alignment: center;"); //Le da tamaño a los numeros y alineacion

                celdas[filas][columnas] = celda; //Se guardan en la matriz
                celdasSudoku.add(celda, filas, columnas);
            }
        }
    }


    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public void mostrarNombreLabel(){
        nombreLabel.setText(jugador.getNombre());
    }




}
