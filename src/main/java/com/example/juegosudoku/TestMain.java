package com.example.juegosudoku;

import com.example.juegosudoku.models.Board;
import com.example.juegosudoku.models.BoardSolver;
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
            Board tablero = new Board();
            tablero.generateNumber(12);
        });
        Button button2 = new Button("Test board gen 2");
        button2.setOnAction(e -> {
            Board tablero = new Board();
//            board.generateNumberPerSection();
//            board.printBoard();
            BoardSolver solver = new BoardSolver(tablero.getBoard());
            aaaa(tablero, solver);
//            if (solver.solve()){
//                System.out.println("Board solved");
//            }
//            else{
//                System.out.println("Board not solved");
//            }
//            solver.printBoard();

        });
        VBox root = new VBox();
        root.getChildren().addAll(title, button, button2);
        testStage.setResizable(false);

        Scene scene = new Scene(root);
        testStage.setScene(scene);
        testStage.show();

    }

    public void aaaa(Board board, BoardSolver solver) {
        board.generateNumberPerSection();
        solver.setBoard(board.getBoard());
        board.printBoard();
        System.out.println();
        if(solver.solve()){
            solver.printBoard();
            board.printBoard();
            System.out.println("Solved");
        }
        else{
            aaaa(board, solver);
        }
    }
}
