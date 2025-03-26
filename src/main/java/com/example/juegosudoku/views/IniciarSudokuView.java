package com.example.juegosudoku.views;

import com.example.juegosudoku.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * This class run the file iniciarSudoku.fxml with a extends Stage
 */
public class IniciarSudokuView extends Stage {

    public IniciarSudokuView() throws IOException {
        FXMLLoader loader = new FXMLLoader(
                Main.class.getResource("/com/example/juegosudoku/iniciarSudoku.fxml")
        );
        Scene scene = new Scene(loader.load());
        this.setTitle("Juego Sudoku!!!");
        this.setScene(scene);
    }


    /**
     * Singleton pattern
     * This metod returns an instance, it checks if the instance exist for created, else return the
     * existing window
     * @return
     * @throws IOException
     */
    public static IniciarSudokuView getInstance() throws IOException {
        if (IniciarSudokuView.IniciarSudokuViewHolder.INSTANCE == null){ //sino existe una ventana la abre
            IniciarSudokuView.IniciarSudokuViewHolder.INSTANCE = new IniciarSudokuView();
            return IniciarSudokuView.IniciarSudokuViewHolder.INSTANCE;
        } else {
            return IniciarSudokuView.IniciarSudokuViewHolder.INSTANCE; //de lo contrario devuelve la misma que se esta ejecutando
        }

    }


    /**
     *This inner class contains the only instance
     */
    public static class IniciarSudokuViewHolder {
        private static IniciarSudokuView INSTANCE; //Clase interna que contiene la unica instancia para abrir una ventana
    }
}
