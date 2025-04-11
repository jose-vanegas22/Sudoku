package com.example.juegosudoku.controllers;

import com.example.juegosudoku.models.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;


/**
 * Controller for the sudoku.fxml
 * This class handles(maneja) the interaction between(entre) the user and inteface
 * the variable SizeSudoku is the size of the grid, the variable SizeCeldas is the size of the cells in the grid
 * the variable celdas is the matrix of the grid
 *
 * @author vaneg
 * @author Alejandro Medina
 * @version 1.0
 */
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

    @FXML
    private Label mensajeValorLabel;

    @FXML
    private Label mensajeIncorrectoLabel;

    @FXML
    private Button playAgainButton;

    private Jugador jugador; //Se crea una instancia de la clase Jugador para poder usar el nombre

    ReglasSudoku reglas = new ReglasSudoku(); //Instancio la clase para poder usarla aqui

    Board board = new Board();
    BoardSolver solver = new BoardSolver();

    /**
     * This metod runs when the interface open and shows a image
     * There are two nested(anidados) for, they go through(a traves de) the matrix, both(tanto) its columns and rows
     * Created a TextField in each(cada) cell and a style is applied according(segun) the case
     *
     */
    public void initialize(){

        String imagePath = getClass().getResource("/com/example/juegosudoku/Imagenes/imagenInicio.jpg").toExternalForm();
        borderPane.setStyle("-fx-background-image: url('" + imagePath + "'); -fx-background-size: cover;");

        generateSudokuTable(board, solver);

        for (int filas = 0; filas < SizeSudoku; filas++) { //Este for recorre todas las filas
            for (int columnas = 0; columnas < SizeSudoku; columnas++) { //Este for recorre las columnas, primero recorre todas las columnas
                                                                        //de una fila y luego pasa a la siguiente fila
                TextField celda = new TextField(); //Cada que pasa por aqui crea una celda
                celda.setPrefSize(SizeCeldas, SizeCeldas); //Le da tamaño a la celda 50px x 50px

                //------------------------------------------------------------------------------------------------------
                //Solo permite ingresar numero del 1 al 6 de lo contrario los borra automaticamente,
                // textProperty () metodo de TextField detecta un cambio y hace algo en respuesta, addListener funciona
                //como sensor cuando se cambia algo ejecuta codigo, obs permite saber que se esta cambiando
                celda.textProperty().addListener((obs, oldValue, newValue) -> {

                    if (!reglas.validarNumero(newValue)) { //Si es valido no entra (!true se vuelve false)
                        celda.setText(oldValue); // Si no es válido, vuelve al valor anterior o sea vacio
                    }

                    //Se hace validacion de no repetir numeros en filas, columnas y cuadrantes
                    if (!newValue.isEmpty()) { //Solo si se ingreso un nuevo valor (newValue)
                        int [][] sudoku = convertirCeldasStringANumericas(); //Se crea matriz y se guarda el resultado de covertir datos String a enteros
                        int filaActual = GridPane.getRowIndex(celda); //Guarda el indice de la fila en donde el usuario quiere colocar el numero, en donde señana y da click con el raton
                        int columnaActual = GridPane.getColumnIndex(celda); //Guarda el indice de la columna en donde el usuario quiere color el numero, en donde señala y da click con el raton
                        int numero = Integer.parseInt(newValue); //Convierte ese nuevo valor ingresado de String a int y lo guada en la variable numero

                        if (!reglas.numeroValido(sudoku, filaActual, columnaActual, numero)) { //Si no se cumplen las condiciones de numeroValido muestra unos mensajes
                            mensajeValorLabel.setText("Valor");
                            mensajeIncorrectoLabel.setText("Incorrecto");
                        } else { //De lo contrario cuando si se cumplen borra los mensajes
                            mensajeValorLabel.setText(" ");
                            mensajeIncorrectoLabel.setText(" ");
                        }
                    }
                });
                //------------------------------------------------------------------------------------------------------

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
                        "-fx-border-width: " + borderWidth + "; -fx-text-fill: black; -fx-background-color: white;");//Se aplica el estilo de las celdas

                celdas[filas][columnas] = celda; //Se guardan en la matriz
                celdasSudoku.add(celda, columnas, filas); //Metodo predifinido del GridPane donde añadimos la celda que es un
                                                          //TextField por cada cuadro, añadimos la columna y la fina, cuando pase
                                                          //por aqui la primera vez añade un TextField en 0, 0
            }
        }

//        for (int filas = 0; filas < SizeSudoku; filas++){
//            for (int columnas = 0; columnas < SizeSudoku; columnas++){
//                int valorInicial = board.getBoardValue(filas, columnas);
//                if(valorInicial != 0){
//                    celda.setText(String.valueOf(valorInicial));
//                    celda.setDisable(true);
//                }
//            }
//        }
    }

    /**
     *This method converts the values inside a matrix of String to int values
     * @return
     */
    private int[][] convertirCeldasStringANumericas(){

        int [][] sudoku = new int[SizeSudoku][SizeSudoku]; //Se crea la matriz numerica de tamaño 6x6 y se llama sudoku

        for (int filas = 0; filas < SizeSudoku; filas++) {
            for (int columnas = 0; columnas < SizeSudoku; columnas++){
                String texto = celdas[filas][columnas].getText(); //Se obtiene el texto del TextField segun la fila y columna en la que este, se guarda en la variable texto

                if (texto.isEmpty()){
                    sudoku[filas][columnas] = 0; //Si esta vacio pone 0
                } else {
                    sudoku[filas][columnas] = Integer.parseInt(texto); //De lo contrario convierte el texto en entero y lo pone en es posicion
                }
            }
        }
        return sudoku; //Al final retorna la matriz bidimencional sudoku
    }


    /**
     * This metod save an object of the Jugador and it allows(permite) to show it in the interface
     * @param jugador
     */
    public void setJugador(Jugador jugador) {

        this.jugador = jugador;
    }

    /**
     * This metod update name of the jugador in the label nombreLabel
     */
    public void mostrarNombreLabel(){

        nombreLabel.setText(jugador.getNombre());
    }

    @FXML
    void onActionPlayAgainButton(ActionEvent event) {
        RetryAlert alert = new RetryAlert();

        boolean confirmation = alert.mostrarAlertaDeConfirmacion("Alerta de reiniciar juego", "Esta es una ventana de alerta", "Deseas iniciar otro tablero?");
        if (confirmation){
            generateSudokuTable(board, solver);

        }
    }


    public void readSudokuTable(Board board) {


    }


    /**
     * Function to generate and check the suitability of a board for the game
     * @param board: board to play on
     * @param solver: board solved to check its suitability
     */
    public void generateSudokuTable(Board board, BoardSolver solver){
        board.generateNumberPerSection();
        solver.cloneBoard(board.getBoard());
//        board.printBoard();
//        System.out.println();
        if(solver.isInitialBoardValid()){
            if (solver.solve()) {
//                solver.printBoard();
//                System.out.println();
//                board.printBoard();
//                System.out.println();
                System.out.println("Solved");
            } else {
                generateSudokuTable(board, solver);
            }
        }
        else{
            generateSudokuTable(board, solver);
        }
    }

}
