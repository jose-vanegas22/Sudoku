package com.example.juegosudoku.views;

import com.example.juegosudoku.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * This class run de file instrucciones.fxml with a extends Stage
 *
 * @author vaneg
 * @author Alejandro Mendina
 * @version 1.0
 */
public class InstruccionesView extends Stage {

    public InstruccionesView() throws IOException {
        FXMLLoader loader = new FXMLLoader(
                Main.class.getResource("/com/example/juegosudoku/instrucciones.fxml")
        );
        Scene scene = new Scene(loader.load());
        this.setTitle("Instrucciones Sudoku!!!");
        this.setScene(scene);
    }

    /**
     * Singleton pattern
     * This metod return an instance, it checks if the instance exist for created, else return the
     * existing window
     * @return
     * @throws IOException
     */
    public static InstruccionesView getInstance() throws IOException {
        if (InstruccionesView.InstruccionesViewHolder.INSTANCE == null) {
            InstruccionesView.InstruccionesViewHolder.INSTANCE = new InstruccionesView();
            return InstruccionesView.InstruccionesViewHolder.INSTANCE;
        } else {
            return InstruccionesView.InstruccionesViewHolder.INSTANCE;
        }
    }

    /**
     * This inner class contains the only instance
     */
    public static class InstruccionesViewHolder {
        private static InstruccionesView INSTANCE;
    }
}
