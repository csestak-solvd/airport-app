package com.solvd.enums;

public enum FlightType {
    INTERNATIONAL("International"),
    DOMESTIC("Domestic"),
    REGIONAL("Regional");

    private final String type;

    FlightType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return type;
    }
}
