package people;

import airport.Luggage;

import java.time.LocalDate;

public class Passenger extends Person {

    private static int passengerIdCounter = 1;

    private int passengerId;
    private boolean assistance;
    private boolean guardian;
    private boolean security;
    private Luggage luggage;

    public Passenger(LocalDate bday, String name, String sex, boolean assistance, boolean guardian, boolean security) {
        super(bday, name, sex);
        this.passengerId = passengerIdCounter++;
        this.assistance = assistance;
        this.guardian = guardian;
        this.security = security;
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

    public Luggage getLuggage() {
        return luggage;
    }

    public int getPassengerId() {
        return passengerId;
    }

    public void setLuggage(Luggage luggage) {
        this.luggage = luggage;
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
        return "Passenger: " + super.toString() +
                ", Assistance: " + assistance +
                ", Guardian: " + guardian +
                ", Security: " + security +
                ", Passenger ID: " + passengerId;
    }
}