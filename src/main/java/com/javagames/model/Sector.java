package com.javagames.model;

public class Sector {
    private final int x;
    private final int y;
    private SectorType type;
    private int activationNumber;  // 2-12 (dice roll)
    // private CompanyStructure builtStructure;  // For future expansion
    // private Player owner;
    
    // Future expansion for Vertex/Edge system
    private boolean[] vertices;    // 4 corners where structures can be built
    private boolean[] edges;       // 4 sides between vertices
    
    public Sector(int x, int y, SectorType type, int activationNumber) {
        this.x = x;
        this.y = y;
        this.type = type;
        this.activationNumber = activationNumber;
        this.vertices = new boolean[4];  // Top, Right, Bottom, Left
        this.edges = new boolean[4];
        // this.builtStructure = null;
        // this.owner = null;
    }
    
    // Getters
    public int getX() { return x; }
    public int getY() { return y; }
    public SectorType getType() { return type; }
    public int getActivationNumber() { return activationNumber; }
    // public CompanyStructure getBuiltStructure() { return builtStructure; }
    // public Player getOwner() { return owner; }
    public boolean[] getVertices() { return vertices; }
    public boolean[] getEdges() { return edges; }
    
    // Setters
    public void setType(SectorType type) { this.type = type; }
    public void setActivationNumber(int activationNumber) { this.activationNumber = activationNumber; }
    
    // public void setBuiltStructure(CompanyStructure structure, Player player) {
    //     this.builtStructure = structure;
    //     this.owner = player;
    // }
    
    // public boolean canBuildStructure() {
    //     return builtStructure == null;
    // }
    
    @Override
    public String toString() {
        return String.format("Sector[%d,%d]: %s (Activate: %d)", x, y, type.getDisplayName(), activationNumber);
    }
}