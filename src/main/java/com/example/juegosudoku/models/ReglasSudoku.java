package com.example.juegosudoku.models;

/**
 *This class contains the methods of the sudoku rules
 *
 * @author vaneg
 * @author Alejandro Medina
 * @version 1.0
 */
public class ReglasSudoku {

    private static final int sizeSudoku = 6;

    /**
     *This method validates that only nymbers 1-6
     * @param numero
     * @return numbers 1-6
     */
    public boolean validarNumero(String numero){
        return numero.matches("[1-6]?"); //Solo permite numero del 1 al 6 o estar vacio
    }

    /**
     * This method validates that equal numbers are not entered in the row,
     * column and quadrant
     * @param sudoku
     * @param fila
     * @param columna
     * @param valor
     * @return false or true as the case may be
     */
    public boolean numeroValido(int [][] sudoku, int fila, int columna, int valor){
        return validarFila(sudoku,fila, columna, valor) &&
              validarColumna(sudoku, fila, columna, valor) &&
                validarCuadrante(sudoku, fila, columna, valor);
    }

    /**
     *This method validates that equals numbers are not entered in the row
     * @param sudoku
     * @param fila
     * @param valor
     * @return
     */
    public boolean validarFila(int[][] sudoku, int fila, int columnaActual, int valor){
        for (int columna = 0; columna < sizeSudoku; columna++) { //Recorre una fila en todas las columnas
            if (columna != columnaActual && sudoku[fila][columna] == valor) {
                return false;  // Número repetido en la fila (excepto en la celda en evaluación)
            }
        }
        return true;
    }

    /**
     *This method validates that equals numbers are not entered in the column
     * @param sudoku
     * @param columna
     * @param valor
     * @return
     */
    public boolean validarColumna(int[][] sudoku, int filaActual, int columna, int valor){
        for (int fila = 0; fila < sizeSudoku; fila++){
            if (fila != filaActual && sudoku[fila][columna] == valor){ //Si es diferente a la fila que se esta validando y el valor se encuentra en la columna retorna falso
                return false;
            }
        }
        return true; //De lo contrario retorna verdadero lo que significa que no hay un numero igual y lo deja colocar
    }

    /**
     *This method validates that equals numbers are not entered in the quadrant
     * @param sudoku
     * @param fila
     * @param columna
     * @param valor
     * @return
     */
    public boolean validarCuadrante(int[][] sudoku, int fila, int columna, int valor){
        int inicioFila = (fila / 2) * 2;
        int inicioColumna = (columna / 3) * 3; //Estas dos variables permite encontrar la ubicacion izquierda superior de cada cuadrante

        for (int i = inicioFila; i < inicioFila + 2; i++){  //Hace que solo llegue 2 filas desde donde inicia
            for (int j = inicioColumna; j < inicioColumna + 3; j++){ //Hace que solo llegue a 3 columnas desde donde inicia
                if (i == fila && j == columna) { //Si llega a la fila y columna que estamos evaluando hace que el bucle ignore esta celda y continua con el bucle
                    continue;  // Ignorar la celda actual
                }
                if (sudoku[i][j] == valor){ //Si lo que esta en la ubicacion es igual al valor lo que hace es retornar falso y que no se pueda escribir el numero porque se repite
                    return false;  // Número repetido en el cuadrante
                }
            }
        }
        return true; //Si el numero no se encuentra repetido en el cuadrante retorna true y permite que si se escriba
    }

}
