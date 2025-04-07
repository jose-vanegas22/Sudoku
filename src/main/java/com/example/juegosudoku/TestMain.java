package com.example.juegosudoku;

import com.example.juegosudoku.models.Board;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TestMain extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Stage testStage = new Stage();
        testStage.setTitle("Test");
        Label title = new Label("Test");
        Button button = new Button("Test board gen");
        button.setOnAction(e -> {
            Board board = new Board();
            board.generateNumber(6);
        });
        VBox root = new VBox();
        root.getChildren().addAll(title, button);
        testStage.setResizable(false);

        Scene scene = new Scene(root);
        testStage.setScene(scene);
        testStage.show();

    }
}
