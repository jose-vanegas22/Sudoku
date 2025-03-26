package com.example.juegosudoku.models;

/**
 * This class Jugador contains(contiene) the name and getter and setter methods
 *
 * @author vaneg
 * @author Alejandro Medina
 * @version 1.0
 */
public class Jugador {

    private String nombre;


    public String getNombre() {

        return nombre; //Permite mostrar o devolver el nombre
    }

    public void setNombre(String nombre) {

        this.nombre = nombre; //Permite modificar el nombre desde cualquier parte del codigo
    }
}
