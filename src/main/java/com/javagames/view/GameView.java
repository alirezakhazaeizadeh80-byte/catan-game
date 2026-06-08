package com.javagames.view;

import com.javagames.controller.GameController;
import com.javagames.model.Sector;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class GameView {
    private final GameController controller;
    private final GridPane gameGrid;
    private final BorderPane root;
    private final Label statusLabel;
    private final Label turnLabel;
    private final Label scoreLabel;
    private SectorNode[][] sectorNodes;
    
    public GameView(GameController controller) {
        this.controller = controller;
        this.gameGrid = new GridPane();
        this.root = new BorderPane();
        this.statusLabel = new Label("Ready to play!");
        this.turnLabel = new Label("Turn: Player 1");
        this.scoreLabel = new Label("Victory Points: 0");
        this.sectorNodes = new SectorNode[GameController.MAP_SIZE][GameController.MAP_SIZE];
        
        initializeUI();
    }
    
    private void initializeUI() {
        // Style the root
        root.setStyle("-fx-background-color: #2c3e50;");
        
        // Setup grid
        gameGrid.setPadding(new Insets(20));
        gameGrid.setHgap(10);
        gameGrid.setVgap(10);
        gameGrid.setAlignment(javafx.geometry.Pos.CENTER);
        
        // Status bar at bottom
        statusLabel.setStyle("-fx-text-fill: white; -fx-font-size: 14px;");
        statusLabel.setPadding(new Insets(10));
        
        // Title at top
        Label titleLabel = new Label("Silicon Valley: The Tech Cartel");
        titleLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        titleLabel.setTextFill(Color.WHITE);
        titleLabel.setPadding(new Insets(20));
        
        BorderPane topPane = new BorderPane();
        topPane.setLeft(titleLabel);
        topPane.setRight(createInfoPanel());
        topPane.setStyle("-fx-background-color: #34495e;");
        
        root.setTop(topPane);
        root.setCenter(gameGrid);
        root.setBottom(statusLabel);
    }
    
    private VBox createInfoPanel() {
        VBox infoBox = new VBox(5);
        infoBox.setPadding(new Insets(10));
        infoBox.setAlignment(javafx.geometry.Pos.CENTER_RIGHT);
        
        turnLabel.setTextFill(Color.WHITE);
        turnLabel.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");
        
        scoreLabel.setTextFill(Color.WHITE);
        scoreLabel.setStyle("-fx-font-size: 12px;");
        
        infoBox.getChildren().addAll(turnLabel, scoreLabel);
        return infoBox;
    }
    
    public void renderMap(Sector[][] map) {
        gameGrid.getChildren().clear();
        
        for (int row = 0; row < GameController.MAP_SIZE; row++) {
            for (int col = 0; col < GameController.MAP_SIZE; col++) {
                Sector sector = map[row][col];
                SectorNode node = new SectorNode(sector);
                sectorNodes[row][col] = node;
                gameGrid.add(node, col, row);
            }
        }
        
        // Make columns and rows resize equally
        for (int i = 0; i < GameController.MAP_SIZE; i++) {
            gameGrid.getColumnConstraints().add(new ColumnConstraints(100));
            gameGrid.getRowConstraints().add(new RowConstraints(100));
        }
    }
    
    public void updateStatus(String message) {
        statusLabel.setText(message);
    }
    
    public void updateTurn(String playerName) {
        turnLabel.setText("Turn: " + playerName);
    }
    
    public void updateScore(int points) {
        scoreLabel.setText("Victory Points: " + points);
    }
    
    public BorderPane getRoot() { return root; }
}