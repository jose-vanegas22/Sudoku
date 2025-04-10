package com.example.juegosudoku.models;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Board {
    private int[][] board;
    private static final int boardLength=6;
    private static final int boardWidth=6;

    public Board() {

        board=new int[boardLength][boardWidth];
        System.out.println(Arrays.deepToString(board));
    }

    public void generateNumber(int i) {
        int fila = (int) (Math.random() * 6);
        int columna = (int) (Math.random() * 6);
        int number = (int) (Math.random() * 6) + 1;
        if(i == 0)
        {
            System.out.println(Arrays.deepToString(board));
        }
//        else if (checkZeroCell(columna, fila) == true) {
//            System.out.println("La casilla esta ocupada");
//
//        }
        else {
            board[columna][fila] = number;
            generateNumber(i-1);
        }
    }

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


}
