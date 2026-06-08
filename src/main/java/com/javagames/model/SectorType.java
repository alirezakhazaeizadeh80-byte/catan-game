package com.javagames.model;

public enum SectorType {
    AI_HUB("AI Hub", "#4A90E2", ResourceType.TALENT),
    FINTECH("FinTech", "#50E3C2", ResourceType.CAPITAL),
    CLOUD_CAMPUS("Cloud Campus", "#F5A623", ResourceType.CLOUD),
    IP_QUARTER("IP Quarter", "#D0021B", ResourceType.PATENT),
    DATA_VALLEY("Data Valley", "#8B572A", ResourceType.DATA),
    REGULATORY("Regulatory", "#9B9B9B", ResourceType.PATENT);
    
    private final String displayName;
    private final String colorHex;
    private final ResourceType primaryResource;
    
    SectorType(String displayName, String colorHex, ResourceType primaryResource) {
        this.displayName = displayName;
        this.colorHex = colorHex;
        this.primaryResource = primaryResource;
    }
    
    public String getDisplayName() { return displayName; }
    public String getColorHex() { return colorHex; }
    public ResourceType getPrimaryResource() { return primaryResource; }
}