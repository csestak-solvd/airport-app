package com.solvd.people;

import com.solvd.enums.PassengerStatus;
import com.solvd.enums.SecurityLevel;
import com.solvd.linkedlist.CustomLinkedList;
import com.solvd.airport.CarryOnBag;
import com.solvd.airport.Luggage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.invoke.MethodHandles;
import java.time.LocalDate;
import java.time.Period;

public class Passenger extends Person {

    private static final Logger LOGGER = LogManager.getLogger(MethodHandles.lookup().lookupClass());
    private static int passengerIdCounter = 1;
    private int passengerId;
    private boolean assistance;
    private boolean guardian;
    private boolean security;
    private CustomLinkedList<Luggage> luggageList;
    private PassengerStatus passengerStatus;
    private SecurityLevel securityLevel;

    public Passenger(LocalDate bday, String name, String sex, boolean assistance, boolean guardian, boolean security) {
        super(bday, name, sex);
        this.passengerId = passengerIdCounter++;
        this.assistance = assistance;
        this.guardian = guardian;
        this.security = security;
        this.luggageList = new CustomLinkedList<>();
    }

    public PassengerStatus getPassengerStatus() {
        return passengerStatus;
    }

    public boolean isAssistanceNeeded() {
        return assistance;
    }

    public boolean hasGuardian() {
        return guardian;
    }

    public boolean hasSecurity() {
        return security;
    }

    public CustomLinkedList<Luggage> getLuggageList() {
        return luggageList;
    }

    public int getPassengerId() {
        return passengerId;
    }

    public void addLuggage(Luggage luggage) {
        luggageList.add(luggage);
    }

    public void addCarryOnBag(int bagCount, int weight) {
        CarryOnBag carryOnBag = new CarryOnBag(bagCount, weight);
        luggageList.add(carryOnBag);
    }

    public void removeLuggage(Luggage luggage) {
        luggageList.remove(luggage);
    }

    public void setAssistance(boolean assistance) {
        this.assistance = assistance;
    }

    public void setPassengerStatus(PassengerStatus passengerStatus) {
        this.passengerStatus = passengerStatus;
    }

    public SecurityLevel getSecurityLevel() {
        return securityLevel;
    }

    public void setSecurityLevel(SecurityLevel securityLevel) {
        this.securityLevel = securityLevel;
    }

    public void setGuardian(boolean guardian) {
        this.guardian = guardian;
    }

    public void setSecurity(boolean security) {
        this.security = security;
    }

    public int calculateAge() {
        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(getBday(), currentDate);
        return period.getYears();
    }

    public boolean isVIP() {
        return calculateAge() >= 65;
    }

    @Override
    public String toString() {
        StringBuilder luggageDetails = new StringBuilder("Luggage Details: [");
        // Iterate over each luggage in the luggageList and append its string representation.
        for (Luggage luggage : luggageList.getAll()) {
            luggageDetails.append(luggage).append(", ");
        }
        // Check if the luggageDetails is not empty before removing the trailing comma and space.
        if (!luggageList.isEmpty()) {
            luggageDetails.delete(luggageDetails.length() - 2, luggageDetails.length());
        }
        luggageDetails.append("]");
        // Return the complete string representation of the Passenger object.
        return "Passenger: " + super.toString() +
                ", Assistance: " + assistance +
                ", Guardian: " + guardian +
                ", Security: " + security +
                ", Passenger ID: " + passengerId +
                ", Status: " + (passengerStatus != null ? passengerStatus.getStatus() : "N/A") +
                ", " + luggageDetails.toString();
    }
}