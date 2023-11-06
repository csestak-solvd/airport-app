package people;

import interfaces.IEat;
import airport.FoodCourt;

import java.time.LocalDate;

public class Passenger extends Person implements IEat {
    
    private boolean assistance;
    private boolean guardian;
    private boolean security;
    private FoodCourt food;

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

    @Override
    public void eat() {
        System.out.println("Im hungry for" + FoodCourt.foodType + "from" + FoodCourt.restaurantName + "and the price is" + FoodCourt.price);
    }
    @Override
    public String toString() {
        return "Passenger: " + super.toString() +
                ", Assistance: " + assistance +
                ", Guardian: " + guardian +
                ", Security: " + security;
    }
}