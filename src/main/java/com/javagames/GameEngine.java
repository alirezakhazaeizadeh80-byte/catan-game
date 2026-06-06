package com.javagames;

import java.util.List;


public class GameEngine {
    private static GameEngine instance;

    private GameMap gameMap;
    private List<Player> players;
    private int currentTurnIndex;

    private GameEngine() {
        this.gameMap = new GameMap();
        this.currentTurnIndex = 0;
    }

    public static synchronized GameEngine getInstance() {
        if (instance == null) {
            instance = new GameEngine(); 
        }
        return instance;
    }

    public void nextTurn() { /* ... */ }
}