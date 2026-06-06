package com.javagames;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

public class GameSetupController {

    static int PlayerCount;

    @FXML
    private ComboBox<String> playerCountComboBox;

    @FXML
    private Button startGameButton;
    
    @FXML
    public void initialize() {
        playerCountComboBox.getItems().addAll("2 Player", "3 Players", "4 Players");
    }

    @FXML
    public void GetPlayerCount(ActionEvent e) {
        PlayerCount = playerCountComboBox.getSelectionModel().getSelectedItem().charAt(0) - '0';
        System.out.println("Selected Player Count: " + PlayerCount);
    }

    @FXML
    public void StartGame(ActionEvent e) {
        System.out.println("Starting game with " + PlayerCount + " players...");
        // transition to the main game scene
    }
    
}
