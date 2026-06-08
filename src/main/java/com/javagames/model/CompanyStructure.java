package com.javagames.model;

public abstract class CompanyStructure {
    protected String name;
    protected Player owner;
    protected int victoryPoints;
    
    public CompanyStructure(String name, Player owner, int victoryPoints) {
        this.name = name;
        this.owner = owner;
        this.victoryPoints = victoryPoints;
    }
    
    public abstract ResourceType[] getCost();
    public abstract int getVictoryPoints();
    
    public String getName() { return name; }
    public Player getOwner() { return owner; }
}
