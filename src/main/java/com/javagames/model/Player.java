package com.javagames.model;

import javafx.scene.paint.Color;
import java.util.HashMap;
import java.util.Map;

public class Player {
    private final String name;
    private final Color color;
    private final Map<ResourceType, Integer> resources;
    private int victoryPoints;
    
    public Player(String name, Color color) {
        this.name = name;
        this.color = color;
        this.resources = new HashMap<>();
        this.victoryPoints = 0;
        
        // Initialize resources to 0
        for (ResourceType rt : ResourceType.values()) {
            resources.put(rt, 0);
        }
    }
    
    public void addResource(ResourceType type, int amount) {
        resources.put(type, resources.getOrDefault(type, 0) + amount);
    }
    
    public boolean spendResource(ResourceType type, int amount) {
        int current = resources.getOrDefault(type, 0);
        if (current >= amount) {
            resources.put(type, current - amount);
            return true;
        }
        return false;
    }
    
    public void addVictoryPoints(int points) {
        this.victoryPoints += points;
    }
    
    // Getters
    public String getName() { return name; }
    public Color getColor() { return color; }
    public Map<ResourceType, Integer> getResources() { return resources; }
    public int getVictoryPoints() { return victoryPoints; }
    
    @Override
    public String toString() {
        return String.format("Player{name='%s', points=%d, resources=%s}", 
                            name, victoryPoints, resources);
    }
}