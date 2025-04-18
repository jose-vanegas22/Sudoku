package com.example.juegosudoku.models;

/**
 * This class verify if a board generated is solvable for sudoku 6x6
 * @author vaneg
 * @author Alejandro Medina García
 * @version 1.1
 */
public class BoardSolver {
    private int[][] solverBoard;

    public BoardSolver(){
        solverBoard= new int[6][6];
    }

    /**
     * Function that checks if the board can be solved
     * @return boolean value
     */
    public boolean solve() {
        for (int fila = 0; fila < 6; fila++) {
            for (int col = 0; col < 6; col++) {
                if (solverBoard[fila][col] == 0) {
                    for (int num = 1; num <= 6; num++) {
                        if (isValid(fila, col, num)) {
                            solverBoard[fila][col] = num;
                            if (solve()) return true;
                            solverBoard[fila][col] = 0; // backtrack
                        }
                    }
                    return false; // no se pudo colocar ningún número

                }
            }
        }
        return true; // se llenó todo el tablero
    }

    /**
     * This function checks if is valid to position the number there
     * @param fila: row of the board
     * @param col: column of the board
     * @param num: value to insert
     * @return boolean value
     */
    private boolean isValid(int fila, int col, int num) {
        // Verificar fila
        for (int j = 0; j < 6; j++) {
            if (solverBoard[fila][j] == num) return false;
        }

        // Verificar columna
        for (int i = 0; i < 6; i++) {
            if (solverBoard[i][col] == num) return false;
        }

        // Verificar bloque 2x3
        int bloqueFila = (fila / 2) * 2;
        int bloqueCol = (col / 3) * 3;

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                if (solverBoard[bloqueFila + i][bloqueCol + j] == num) return false;
            }
        }

        return true;
    }

    /**
     * This function checks if the initial Board doesn't have any initial problem
     * @return boolean value
     */
    public boolean isInitialBoardValid() {
        for (int fila = 0; fila < 6; fila++) {
            for (int col = 0; col < 6; col++) {
                int num = solverBoard[fila][col];
                if (num != 0) {
                    solverBoard[fila][col] = 0; // lo quitamos temporalmente para verificar
                    if (!isValid(fila, col, num)) {
                        solverBoard[fila][col] = num; // restauramos
                        return false;
                    }
                    solverBoard[fila][col] = num; // restauramos
                }
            }
        }
        return true;
    }

    /**
     * Function to create a copy or clone of a board
     * @param board: int matrix
     */
    public void cloneBoard(int[][] board){
        for (int i = 0; i<6; i++){

            solverBoard[i]=board[i].clone();
        }
    }

    public void printBoard() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.print(solverBoard[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int[][] getSolverBoard() {
        return solverBoard;
    }

    public int getBoardValue(int row, int col) {
        return solverBoard[row][col];
    }
}
