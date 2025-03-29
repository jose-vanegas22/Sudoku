package com.example.juegosudoku.models;

public class ReglasSudoku {

    private static final int sizeTablero = 6;

    public boolean validarNumero(String numero){
        return numero.matches("[1-6]?"); //Solo permite numero del 1 al 6 o estar vacio
    }
}
