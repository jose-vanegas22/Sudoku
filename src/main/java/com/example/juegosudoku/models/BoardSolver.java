package com.example.juegosudoku.models;

public class BoardSolver {
    private int[][] board;

    public BoardSolver(int[][] board){
        this.board = board;
    }

    public boolean solve() {
        for (int fila = 0; fila < 6; fila++) {
            for (int col = 0; col < 6; col++) {
                if (board[fila][col] == 0) {
                    for (int num = 1; num <= 6; num++) {
                        if (isValid(fila, col, num)) {
                            board[fila][col] = num;
                            if (solve()) return true;
                            board[fila][col] = 0; // backtrack
                        }
                    }
                    return false; // no se pudo colocar ningún número

                }
            }
        }
        return true; // se llenó todo el tablero
    }

    private boolean isValid(int fila, int col, int num) {
        // Verificar fila
        for (int j = 0; j < 6; j++) {
            if (board[fila][j] == num) return false;
        }

        // Verificar columna
        for (int i = 0; i < 6; i++) {
            if (board[i][col] == num) return false;
        }

        // Verificar bloque 2x3
        int bloqueFila = (fila / 2) * 2;
        int bloqueCol = (col / 3) * 3;

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[bloqueFila + i][bloqueCol + j] == num) return false;
            }
        }

        return true;
    }
}
