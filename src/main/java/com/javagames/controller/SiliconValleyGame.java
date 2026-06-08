package com.javagames.controller;

import com.javagames.view.GameView;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class SiliconValleyGame extends Application {
    private GameController controller;
    private GameView view;
    
    @Override
    public void start(Stage primaryStage) {
        // Initialize controller (Model)
        controller = new GameController();
        
        // Initialize view (View)
        view = new GameView(controller);
        controller.setView(view);
        
        // Create control panel
        HBox controls = createControls();
        
        // Add controls to the view
        BorderPane root = view.getRoot();
        root.setBottom(controls);
        
        // Setup scene
        Scene scene = new Scene(root, 900, 700);
        scene.getStylesheets().add(getClass().getResource("/com/javagames/view/styles.css").toExternalForm());
        
        primaryStage.setTitle("Silicon Valley: The Tech Cartel");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        view.updateStatus("Game initialized! " + controller.getPlayers().size() + " players ready.");
    }
    
    private HBox createControls() {
        HBox controlBox = new HBox(10);
        controlBox.setStyle("-fx-padding: 10; -fx-background-color: #34495e;");
        controlBox.setAlignment(javafx.geometry.Pos.CENTER);
        
        Button rollButton = new Button("🎲 Roll Dice");
        rollButton.setStyle("-fx-font-size: 14px; -fx-padding: 10;");
        rollButton.setOnAction(e -> controller.rollDice());
        
        Button endTurnButton = new Button("⏭️ End Turn");
        endTurnButton.setStyle("-fx-font-size: 14px; -fx-padding: 10;");
        
        Button resetButton = new Button("🔄 Reset Game");
        resetButton.setStyle("-fx-font-size: 14px; -fx-padding: 10;");
        
        controlBox.getChildren().addAll(rollButton, endTurnButton, resetButton);
        return controlBox;
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}