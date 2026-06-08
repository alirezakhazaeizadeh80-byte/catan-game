package com.javagames.view;

import com.javagames.model.Sector;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class SectorNode extends StackPane {
    private final Sector sector;
    private final Label typeLabel;
    private final Label numberLabel;
    private final Label resourceIcon;
    
    public SectorNode(Sector sector) {
        this.sector = sector;
        
        // Create UI elements
        typeLabel = new Label(sector.getType().getDisplayName());
        numberLabel = new Label(String.valueOf(sector.getActivationNumber()));
        resourceIcon = new Label(sector.getType().getPrimaryResource().getIcon());
        
        // Style labels
        typeLabel.setStyle("-fx-font-size: 11px; -fx-text-fill: white; -fx-font-weight: bold;");
        numberLabel.setStyle("-fx-font-size: 18px; -fx-text-fill: white; -fx-font-weight: bold;");
        resourceIcon.setStyle("-fx-font-size: 24px;");
        
        // Layout - vertical box
        VBox content = new VBox(5);
        content.setAlignment(Pos.CENTER);
        content.getChildren().addAll(resourceIcon, numberLabel, typeLabel);
        
        // Style the tile
        this.getChildren().add(content);
        this.setStyle(String.format(
            "-fx-background-color: %s; " +
            "-fx-border-color: #ffffff; " +
            "-fx-border-width: 2px; " +
            "-fx-border-radius: 5px; " +
            "-fx-background-radius: 5px; " +
            "-fx-padding: 10px; " +
            "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.3), 5, 0, 2, 2);",
            sector.getType().getColorHex()
        ));
        
        this.setPrefSize(100, 100);
        this.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        
        // Hover effect
        this.setOnMouseEntered(e -> {
            this.setStyle(this.getStyle() + "-fx-scale-x: 1.05; -fx-scale-y: 1.05;");
        });
        this.setOnMouseExited(e -> {
            this.setStyle(this.getStyle().replace("-fx-scale-x: 1.05; -fx-scale-y: 1.05;", ""));
        });
        
        // Click handler (placeholder)
        this.setOnMouseClicked(e -> {
            System.out.println("Clicked: " + sector);
        });
    }
    
    public void updateDisplay() {
        typeLabel.setText(sector.getType().getDisplayName());
        numberLabel.setText(String.valueOf(sector.getActivationNumber()));
        resourceIcon.setText(sector.getType().getPrimaryResource().getIcon());
    }
    
    public Sector getSector() { return sector; }
}