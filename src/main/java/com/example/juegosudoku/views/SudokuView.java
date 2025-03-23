package com.example.juegosudoku.views;

import com.example.juegosudoku.HelloApplication;
import com.example.juegosudoku.controlls.SudokuController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SudokuView extends Stage {

    private SudokuController controller;

    public SudokuView() throws IOException {
        FXMLLoader loader = new FXMLLoader(
                HelloApplication.class.getResource("/com/example/juegosudoku/sudoku.fxml")
        );
        Scene scene = new Scene(loader.load());
        this.controller = loader.getController();
        this.setTitle("Juego Sudoku!!!");
        this.setScene(scene);
    }

    public SudokuController getController() {
        return controller;
    }


    public static SudokuView getInstance() throws IOException {
        if (SudokuViewHolder.INSTANCE == null){
            SudokuViewHolder.INSTANCE = new SudokuView();
            return SudokuViewHolder.INSTANCE;
        } else {
            return SudokuViewHolder.INSTANCE;
        }

    }


    public static class SudokuViewHolder {
        private static SudokuView INSTANCE;
    }
}