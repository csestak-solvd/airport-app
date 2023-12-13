package com.solvd.enums;

public enum PassengerStatus {
    CHECKED_IN("Checked in"),
    BOARDING("Boarding"),
    IN_FLIGHT("In Flight"),
    ARRIVED("Arrived"),
    CUSTOM("Custom Status") {
        @Override
        public String getDescription() {
            return "this is custom.";
        }
    };

    private final String description;

    PassengerStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    /*
     * check if passenger has completed journey.
     * return true if passenger has arrived, otherwise false.
     * */
    public boolean hasArrived() {
        return this == ARRIVED;
    }

    /*
     * get status of passenger
     * return status rep
     */
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
