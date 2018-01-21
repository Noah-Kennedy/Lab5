/*
 * SE1021
 * Winter 2018
 * Lab 5 Game Of Life
 * Name: Noah Kennedy
 * Created 1/11/2018
 */

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * The driver class for the Lab5 Conway's Game of Life application.
 *
 * @author Noah Kennedy
 * @version 1.0
 */
public class Lab5 extends Application {

    private static final int SCENE_WIDTH = 500;
    private static final int SCENE_HEIGHT = 500;
    private static final int HGAP = 10;
    private static final int VGAP = 10;
    private static final int TOP_INSET = 25;
    private static final int RIGHT_INSET = 25;
    private static final int BOTTOM_INSET = 25;
    private static final int LEFT_INSET = 25;
    private static final int HBOX_SPACING = 10;
    private static final int GAME_PANE_HEIGHT = 200;
    private static final int GAME_PANE_WIDTH = 200;

    public static void main(String[] args) {
        launch(args);
    }


    /**
     * Starts the JavaFX application.
     * @param primaryStage The Stage for the application.
     */
    public void start(Stage primaryStage) {
        //declarations
        Scene scene;
        Button randomButton;
        Button stepButton;
        Label livingCellCountLabel;
        Label deadCellCountLabel;
        Text livingCellCountTarget;
        Text deadCellCountTarget;
        BorderPane rootPane;
        GridPane analysisPane;
        HBox buttonPane;
        Pane gamePane;
        LifeGrid lifeGrid;

        //button initialization
        randomButton = new Button("Randomize");
        stepButton = new Button("Step");

        //label initialization
        livingCellCountLabel = new Label("Living Cells:");
        deadCellCountLabel = new Label("Dead Cells:");

        //target initializations
        livingCellCountTarget = new Text();
        deadCellCountTarget = new Text();

        analysisPane = new GridPane();
        analysisPane.setAlignment(Pos.TOP_LEFT);
        analysisPane.setHgap(HGAP);
        analysisPane.setVgap(VGAP);
        analysisPane.setPadding(new Insets(TOP_INSET, RIGHT_INSET, BOTTOM_INSET, LEFT_INSET));

        analysisPane.add(livingCellCountLabel, 0, 0);
        analysisPane.add(deadCellCountLabel, 0, 1);
        analysisPane.add(livingCellCountTarget, 1, 0);
        analysisPane.add(deadCellCountTarget, 1, 1);

        gamePane = new Pane();
        gamePane.setPrefHeight(GAME_PANE_HEIGHT);
        gamePane.setPrefWidth(GAME_PANE_WIDTH);
        lifeGrid = new LifeGrid(gamePane);

        //handle buttons
        randomButton.setOnAction(event -> {
            lifeGrid.randomize();
            livingCellCountTarget.setText(Integer.toString(lifeGrid.getLivingCells()));
            deadCellCountTarget.setText(Integer.toString(lifeGrid.getDeadCells()));
        });

        stepButton.setOnAction(event -> {
            lifeGrid.iterate();
            livingCellCountTarget.setText(Integer.toString(lifeGrid.getLivingCells()));
            deadCellCountTarget.setText(Integer.toString(lifeGrid.getDeadCells()));
        });

        buttonPane = new HBox(HBOX_SPACING);
        buttonPane.setAlignment(Pos.BOTTOM_LEFT);
        buttonPane.getChildren().add(randomButton);
        buttonPane.getChildren().add(stepButton);

        rootPane = new BorderPane();
        rootPane.setRight(analysisPane);
        rootPane.setCenter(gamePane);
        rootPane.setBottom(buttonPane);

        primaryStage.setTitle("Conway's Game of Life");

        scene = new Scene(rootPane, SCENE_WIDTH, SCENE_HEIGHT);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
