package com.example.juegosudoku.views;

import com.example.juegosudoku.HelloApplication;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class IniciarSudokuView extends Stage {

    public IniciarSudokuView() throws IOException {
        FXMLLoader loader = new FXMLLoader(
                HelloApplication.class.getResource("/com/example/juegosudoku/iniciarSudoku.fxml")
        );
        Scene scene = new Scene(loader.load());
        this.setTitle("Juego Sudoku!!!");
        this.setScene(scene);
    }


    public static IniciarSudokuView getInstance() throws IOException {
        if (IniciarSudokuView.IniciarSudokuViewHolder.INSTANCE == null){
            IniciarSudokuView.IniciarSudokuViewHolder.INSTANCE = new IniciarSudokuView();
            return IniciarSudokuView.IniciarSudokuViewHolder.INSTANCE;
        } else {
            return IniciarSudokuView.IniciarSudokuViewHolder.INSTANCE;
        }

    }


    public static class IniciarSudokuViewHolder {
        private static IniciarSudokuView INSTANCE;
    }
}
