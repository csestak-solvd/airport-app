package com.solvd.enums;

public enum GateType {
    INTERNATIONAL("International"),
    DOMESTIC("Domestic"),
    REGIONAL("Regional");

    private final String type;

    GateType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return type;
    }
}
