package com.solvd.airport;

import com.solvd.enums.FlightType;
import com.solvd.enums.GateStatus;
import com.solvd.enums.GateType;
import com.solvd.exceptions.InvalidGateException;

public class Gate {

    private String gateNumber;
    private GateStatus gateStatus;
    private GateType gateType;

    public Gate(String gateNumber, GateStatus gateStatus, GateType gateType) {
        this.gateNumber = gateNumber;
        this.gateStatus = gateStatus;
        this.gateType = gateType;
    }

    public String getGateNumber() {
        return gateNumber;
    }

    public GateStatus getGateStatus() {
        return gateStatus;
    }

    public GateType getGateType() {
        return gateType;
    }

    public void setGateNumber(String gateNumber) {
        this.gateNumber = gateNumber;
    }

    public void setGateStatus(GateStatus gateStatus) {
        this.gateStatus = gateStatus;
    }

    public void setGateType(GateType gateType) {
        this.gateType = gateType;
    }

    public void performGateOperation() throws InvalidGateException {
        if (!isValidGateNumber(gateNumber)) {
            throw new InvalidGateException("Invalid gate number: " + gateNumber);
        }
    }

    private boolean isValidGateNumber(String gateNumber) {
        return gateNumber.startsWith("A");
    }

    @Override
    public String toString() {
        return "Gate number: " + this.gateNumber + "Gate Status: " + this.gateStatus + "Gate Type: " + this.gateType;
    }
}