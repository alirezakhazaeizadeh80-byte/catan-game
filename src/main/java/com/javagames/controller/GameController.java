package com.javagames.controller;

import com.javagames.model.*;
import com.javagames.view.GameView;
import java.util.*;

public class GameController {
    public static final int MAP_SIZE = 5;
    private final Sector[][] gameMap;
    private final List<Player> players;
    private final Random random;
    private GameView view;
    private int currentPlayerIndex;
    
    public GameController() {
        this.gameMap = new Sector[MAP_SIZE][MAP_SIZE];
        this.players = new ArrayList<>();
        this.random = new Random();
        this.currentPlayerIndex = 0;
        
        initializeMap();
        initializePlayers();
    }
    
    private void initializeMap() {
        List<SectorType> allTypes = Arrays.asList(SectorType.values());
        
        // Temporary list to hold all sectors
        List<Sector> tempSectors = new ArrayList<>();
        
        // Ensure each sector type appears at least once
        for (SectorType type : allTypes) {
            int activation = getRandomActivationNumber();
            tempSectors.add(new Sector(0, 0, type, activation));
        }
        
        // Fill remaining sectors with random types
        int remaining = (MAP_SIZE * MAP_SIZE) - allTypes.size();
        for (int i = 0; i < remaining; i++) {
            SectorType randomType = allTypes.get(random.nextInt(allTypes.size()));
            int activation = getRandomActivationNumber();
            tempSectors.add(new Sector(0, 0, randomType, activation));
        }
        
        // Shuffle to randomize positions
        Collections.shuffle(tempSectors);
        
        // Place into 2D array with correct coordinates
        int index = 0;
        for (int row = 0; row < MAP_SIZE; row++) {
            for (int col = 0; col < MAP_SIZE; col++) {
                Sector sector = tempSectors.get(index++);
                // Create new sector with correct coordinates
                gameMap[row][col] = new Sector(row, col, sector.getType(), sector.getActivationNumber());
            }
        }
    }
    
    private int getRandomActivationNumber() {
        // Weighted distribution for dice rolls (2-12)
        // 7 is most common in 2d6
        int[] numbers = {2,3,4,5,6,7,8,9,10,11,12};
        int[] weights = {1,2,3,4,5,6,5,4,3,2,1};  // Probability distribution for 2d6
        
        int totalWeight = Arrays.stream(weights).sum();
        int randomWeight = random.nextInt(totalWeight);
        
        int cumulative = 0;
        for (int i = 0; i < numbers.length; i++) {
            cumulative += weights[i];
            if (randomWeight < cumulative) {
                return numbers[i];
            }
        }
        return 7; // Default to most common
    }
    
    private void initializePlayers() {
        // Create 2 players for now
        players.add(new Player("Alice", javafx.scene.paint.Color.BLUE));
        players.add(new Player("Bob", javafx.scene.paint.Color.RED));
    }
    
    public void setView(GameView view) {
        this.view = view;
        if (view != null) {
            view.renderMap(gameMap);
        }
    }
    
    public Sector[][] getGameMap() {
        return gameMap;
    }
    
    public List<Player> getPlayers() {
        return players;
    }
    
    public void rollDice() {
        int die1 = random.nextInt(6) + 1;
        int die2 = random.nextInt(6) + 1;
        int total = die1 + die2;
        
        String currentPlayer = players.get(currentPlayerIndex).getName();
        String rollMessage = String.format("%s rolled %d + %d = %d", currentPlayer, die1, die2, total);
        
        // Find activated sectors
        List<Sector> activated = new ArrayList<>();
        for (int row = 0; row < MAP_SIZE; row++) {
            for (int col = 0; col < MAP_SIZE; col++) {
                if (gameMap[row][col].getActivationNumber() == total) {
                    activated.add(gameMap[row][col]);
                }
            }
        }
        
        if (activated.isEmpty()) {
            view.updateStatus(rollMessage + " - No sectors activated!");
        } else {
            view.updateStatus(String.format("%s - %d sector(s) activated!", rollMessage, activated.size()));
            // TODO: Distribute resources in Phase 2
        }
        
        // Switch turns
        currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
        view.updateTurn(players.get(currentPlayerIndex).getName());
    }
    
    public Player getCurrentPlayer() {
        return players.get(currentPlayerIndex);
    }
}