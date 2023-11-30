package com.solvd.people;

import com.solvd.linkedlist.CustomLinkedList;
import com.solvd.airport.CarryOnBag;
import com.solvd.airport.Luggage;

import java.time.LocalDate;

public class Passenger extends Person {

    private static int passengerIdCounter = 1;
    private int passengerId;
    private boolean assistance;
    private boolean guardian;
    private boolean security;
    private CustomLinkedList<Luggage> luggageList;

    public Passenger(LocalDate bday, String name, String sex, boolean assistance, boolean guardian, boolean security) {
        super(bday, name, sex);
        this.passengerId = passengerIdCounter++;
        this.assistance = assistance;
        this.guardian = guardian;
        this.security = security;
        this.luggageList = new CustomLinkedList<>();
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

    public void setGuardian(boolean guardian) {
        this.guardian = guardian;
    }

    public void setSecurity(boolean security) {
        this.security = security;
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
                ", " + luggageDetails.toString();
    }
}