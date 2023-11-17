package people;

import airport.CarryOnBag;
import airport.Luggage;

import java.time.LocalDate;
import java.util.LinkedList;

public class Passenger<T> extends Person {

    private static int passengerIdCounter = 1;

    private int passengerId;
    private boolean assistance;
    private boolean guardian;
    private boolean security;
    private LinkedList<T> luggageList;

    public Passenger(LocalDate bday, String name, String sex, boolean assistance, boolean guardian, boolean security) {
        super(bday, name, sex);
        this.passengerId = passengerIdCounter++;
        this.assistance = assistance;
        this.guardian = guardian;
        this.security = security;
        this.luggageList = new LinkedList<>();
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

    public LinkedList<T> getLuggageList() {
        return luggageList;
    }

    public int getPassengerId() {
        return passengerId;
    }

    public void addLuggage(T luggage) {
        luggageList.add(luggage);
    }

    public void addCarryOnBag(int bagCount, int weight) {
        CarryOnBag carryOnBag = new CarryOnBag(bagCount, weight);
        luggageList.add((T) carryOnBag); //cast to T
    }

    public void removeLuggage(T luggage) {
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
        StringBuilder luggageDetails = new StringBuilder("Luggage Details: [");//constructs string rep of luggage details and is initialized with luggage details[
        for (T luggage : luggageList) {//for each
            luggageDetails.append(luggage.toString()).append(", ");//appends luggage details string to be followed by comma
        }
        if (!luggageList.isEmpty()) {//checks if not empty, if not removes the trailing comma and space
            luggageDetails.delete(luggageDetails.length() - 2, luggageDetails.length()); //remove last comma and space
        }
        luggageDetails.append("]");//finalizes it by adding ] to the end
        return "Passenger: " + super.toString() +
                ", Assistance: " + assistance +
                ", Guardian: " + guardian +
                ", Security: " + security +
                ", Passenger ID: " + passengerId +
                ", " + luggageDetails.toString();
    }
}