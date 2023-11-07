package people;
import airport.Luggage;

import airport.FoodCourt;

import java.time.LocalDate;

public class Passenger extends Person {
    
    private boolean assistance;
    private boolean guardian;
    private boolean security;
    private Luggage luggage;

    public Passenger(LocalDate bday, String name, String sex, boolean assistance, boolean guardian, boolean security) {
        super(bday, name, sex);
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

    public void setAssistance(boolean assistance) {
        this.assistance = assistance;
    }

    public void setGuardian(boolean guardian) {
        this.guardian = guardian;
    }

    public void setSecurity(boolean security) {
        this.security = security;
    }

    if()

    @Override
    public String toString() {
        return "Passenger: " + super.toString() +
                ", Assistance: " + assistance +
                ", Guardian: " + guardian +
                ", Security: " + security;
    }
}