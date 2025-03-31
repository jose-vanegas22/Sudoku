package com.example.juegosudoku.models;

public class GenerateBoard {
    private int[][] board;
    private static final int boardLength=6;
    private static final int boardWidth=6;

    public GenerateBoard() {
        board=new int[boardLength][boardWidth];
    }

    public void generateNumber(){
        int fila = (int) (Math.random() * 6) + 1;
        int columna = (int) (Math.random() * 6) + 1;
        int number = (int) (Math.random() * 6) + 1;
        if(checkEmprtyCell(fila, columna))
        {
            board[fila][columna] = number;
        }
        else {
            generateNumber();
        }
    }

    public boolean checkEmprtyCell(int fila, int columna){
        return board[fila][columna]==0;
    }
}
