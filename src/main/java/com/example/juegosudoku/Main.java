package com.example.juegosudoku;

import com.example.juegosudoku.views.IniciarSudokuView;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {


    public void start(Stage primaryStage) throws IOException {

        IniciarSudokuView iniciarSudokuView = IniciarSudokuView.getInstance();
        iniciarSudokuView.show();
    }


    public static void main(String[] args) {
        launch();
    }
}