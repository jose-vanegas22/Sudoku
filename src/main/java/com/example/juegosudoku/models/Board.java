package com.example.juegosudoku.models;

public class Board {
    private int[][] board;
    private static final int boardLength=6;
    private static final int boardWidth=6;

    public Board() {

        board=new int[boardLength][boardWidth] = null;
    }

    public void generateNumber(int i) {
        int fila = (int) (Math.random() * 6) + 1;
        int columna = (int) (Math.random() * 6) + 1;
        int number = (int) (Math.random() * 6) + 1;
        if(i == 0)
        {
            System.out.println(board);
        } else if (checkEmptyCell(columna, fila) == false) {
            System.out.println("La casilla esta ocupada");

        } else {
            board[columna][fila] = number;
            generateNumber(i-1);
        }
    }

    public boolean checkEmptyCell(int fila, int columna){
        if (board[columna][fila] == null;){
            return true;
        }
    }


}
