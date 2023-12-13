package com.solvd.enums;

public enum GateStatus {
    AVAILABLE("Available"),
    BOARDING("Boarding"),
    CLOSED("Closed");

    private final String status;

    GateStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
