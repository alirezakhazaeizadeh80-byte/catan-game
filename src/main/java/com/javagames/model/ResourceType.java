package com.javagames.model;

public enum ResourceType {
    TALENT("🎓", "Talent"),
    CAPITAL("💰", "Capital"),
    CLOUD("☁️", "Cloud"),
    PATENT("📜", "Patent"),
    DATA("📊", "Data");
    
    private final String icon;
    private final String displayName;
    
    ResourceType(String icon, String displayName) {
        this.icon = icon;
        this.displayName = displayName;
    }
    
    public String getIcon() { return icon; }
    public String getDisplayName() { return displayName; }
}