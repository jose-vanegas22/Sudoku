package com.example.juegosudoku.controlls;

import com.example.juegosudoku.models.Jugador;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class SudokuController {

    private static final int SizeSudoku = 6; //Aqui defino el tamaño del sudoku 6x6
    private static final int SizeCeldas = 50; //Tamaño de las celdas 50px x 50px

    private TextField[][] celdas = new TextField[SizeSudoku][SizeSudoku]; //Matriz para almacenar las celdas

    @FXML
    private BorderPane borderPane;

    @FXML
    private GridPane celdasSudoku;

    @FXML
    private Label nombreLabel;

    private Jugador jugador;


    public void initialize(){

        for (int filas = 0; filas < SizeSudoku; filas++) { //Este for recorre todas las filas
            for (int columnas = 0; columnas < SizeSudoku; columnas++) { //Este ford recorre las columnas, primero recorre todas las columnas
                                                                        //de una fila y luego pasa a la siguiente fila
                TextField celda = new TextField(); //Cada que pasa por aqui crea una celda
                celda.setPrefSize(SizeCeldas, SizeCeldas); //Le da tamaño a la celda 50px x 50px
                String borderWidth = "1px"; // Borde base, por defecto todos tendran un tamaño de 1 px sino se cumplen unas condiciones

                if ((columnas + 1) % 3 == 0 && columnas != SizeSudoku - 1) {
                    borderWidth = "1px 3px 1px 1px"; // Aumenta borde de la derecha cada 3 columnas y omite el ultimo borde derecho,
                                                     // columnas !=5 debido a que se integra en una matriz
                }

                if ((filas + 1) % 2 == 0 && filas != SizeSudoku - 1) {
                    borderWidth = "1px 1px 3px 1px"; // Aumenta borde inferior cada 2 filas
                    if ((filas + 1) % 2 == 0 && filas != SizeSudoku - 1 && columnas == 2){
                        borderWidth = "1px 3px 3px 1px"; //aumenta el borde inferior y el de la derecha, esto se hace para especificar que
                                                         // puede existir el caso de arriba donde el borde de la derecha no se debe de modificar y otros casos como este donde si se debe modificar
                    }
                } else if(filas == 6){
                    borderWidth = "1px 3px 1px 1px"; //Existe este otro caso cuando la fila es igual a la ultima fila solo se debe de modificar
                                                     //el borde derecho y no el de abajo
                }

                celda.setStyle("-fx-font-size: 18px; -fx-alignment: center; -fx-border-color: black; " +
                        "-fx-border-width: " + borderWidth + "; -fx-text-fill: black; -fx-background-color: #FFFACD;");//Se aplica el estilo de las celdas

                celdas[columnas][filas] = celda; //Se guardan en la matriz
                celdasSudoku.add(celda, columnas, filas); //Metodo predifinido del GridPane donde añadimos la celda que es un
                                                          //TextField por cada cuadro, añadimos la columna y la fina, cuando pase
                                                          //por aqui la primera vez añade un TextField en 0, 0
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
