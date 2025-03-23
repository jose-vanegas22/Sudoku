package com.example.juegosudoku;

import com.example.juegosudoku.views.IniciarSudokuView;
import com.example.juegosudoku.views.SudokuView;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {


    public void start(Stage primaryStage) throws IOException {

        IniciarSudokuView iniciarSudokuView = IniciarSudokuView.getInstance();
        iniciarSudokuView.show();
    }


    public static void main(String[] args) {
        launch();
    }
}