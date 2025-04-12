package com.example.juegosudoku.models;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * This class board generates a board suitable for sudoku 6x6
 * @author vaneg
 * @author Alejandro Medina García
 * @version 1.1
 */
public class Board {
    private int[][] board;
    private static final int boardLength=6;
    private static final int boardWidth=6;

    public Board() {

        board=new int[boardLength][boardWidth];
        System.out.println(Arrays.deepToString(board));
    }

    /**
     * Function that generates numbers for a board, being specific to add only 2 numbers per Board section
     */
    public void generateNumberPerSection(){


        for (int section = 0; section < 6; section++) {
            int fila = (section/2)*2;
            int columna = (section%2)*3;

            Set<Integer> positions = new HashSet<Integer>();
            while(positions.size() < 2) {
                positions.add(new Random().nextInt(6));
            }

            int index = 0;
            for (int fil = 0; fil < 2; fil++) {
                for (int column = 0; column < 3; column++) {
                    if (positions.contains(index)) {
                        int number = (int)  (Math.random() * 6)+1;
                        board[fila + fil][columna + column]=number;
                    }
                    else {
                        board[fila + fil][columna + column]=0;
                    }
                    index++;
                }
            }
        }
    }

    public void printBoard() {
        for (int i = 0; i < boardLength; i++) {
            for (int j = 0; j < boardWidth; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }


    public int[][] getBoard() {
        return board;
    }

    public int getBoardValue(int row, int column) {
        return board[row][column];
    }

    public void setBoardValue(int row, int column, int value) {
        board[row][column] = value;
    }

    public int numbers3Left(){
        int number3left = 0;
        int counter = 0;
        for (int row = 0; row < boardLength; row++){
            for (int column = 0; column < boardWidth; column++){
                if(board[row][column]==3){
                    counter++;
                    number3left = 6- counter;
                }

            }
        }
        System.out.print(number3left + "");
        return number3left;
    }

    public int num5CurrentQty(){
        int num5Qty = 0;
        for (int row = 0; row < boardLength; row++){
            for (int column = 0; column < boardWidth; column++){
                if(board[row][column]==5){
                    num5Qty++;
                }

            }
        }
        return num5Qty;
    }


}
