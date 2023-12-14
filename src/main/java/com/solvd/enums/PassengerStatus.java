package com.solvd.enums;

public enum PassengerStatus {
    CHECKED_IN("Checked in"),
    BOARDING("Boarding"),
    IN_FLIGHT("In Flight"),
    ARRIVED("Arrived"),
    CUSTOM("Custom Status");

    private final String description;

    PassengerStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public boolean hasArrived() {
        return this == ARRIVED;
    }

    public String getStatus() {
        switch (this) {
            case CHECKED_IN:
                return "Checked-in";
            case BOARDING:
                return "Boarding";
            case IN_FLIGHT:
                return "In Flight";
            case ARRIVED:
                return "Arrived";
            default:
                return "Custom Status";

        }
    }
}
