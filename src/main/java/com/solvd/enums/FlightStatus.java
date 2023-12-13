package com.solvd.enums;

public enum FlightStatus {
    ON_TIME("On Time"),
    DELAYED("Delayed"),
    BOARDING("Boarding"),
    IN_FLIGHT("In Flight"),
    LANDED("Landed"),
    CANCELLED("Cancelled");

    private final String status;

    FlightStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
