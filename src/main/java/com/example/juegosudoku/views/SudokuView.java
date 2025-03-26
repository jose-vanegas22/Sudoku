package com.example.juegosudoku.views;

import com.example.juegosudoku.Main;
import com.example.juegosudoku.controllers.SudokuController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 *This class run the file sudoku.fxml with a extends Stage
 *
 * @author vaneg
 * @author Alejandro Medina
 * @version 1.0
 */
public class SudokuView extends Stage {

    private SudokuController controller;

    public SudokuView() throws IOException {
        FXMLLoader loader = new FXMLLoader(
                Main.class.getResource("/com/example/juegosudoku/sudoku.fxml")
        );
        Scene scene = new Scene(loader.load());
        this.controller = loader.getController();
        this.setTitle("Juego Sudoku!!!");
        this.setScene(scene);
    }

    /**
     *
     * @return
     */
    public SudokuController getController() {

        return controller; //Este metodo devuelve el controlador de la vista Sudoku, permite realizar cambios en su
                           //interfaz permitiendo acceder a sus metodos, permite actualizar la interfaz desde cualquier parte del codigo
    }


    /**
     * Singleton pattern
     * This metod return an instance, it checks if the instance exist for created, else return
     * existing window
     * @return
     * @throws IOException
     */
    public static SudokuView getInstance() throws IOException {
        if (SudokuViewHolder.INSTANCE == null){
            SudokuViewHolder.INSTANCE = new SudokuView();
            return SudokuViewHolder.INSTANCE;
        } else {
            return SudokuViewHolder.INSTANCE;
        }

    }


    /**
     * This inner class contains the only instance
     */
    public static class SudokuViewHolder {
        private static SudokuView INSTANCE;
    }
}