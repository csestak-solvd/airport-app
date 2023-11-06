package airport;

import people.Employee;
import java.util.ArrayList;

public class Airport {

    private String name;
    private String location;
    private String type;
    private ArrayList<Airline> airlines;
    private ArrayList<Employee> employees;
    private ArrayList<Restroom> restrooms;
    private ArrayList<FoodCourt> foodCourts;
    private ArrayList<Parking> parkingLots;

    public Airport(String airportName, String airportLoc, String airportType) {
        this.name = airportName;
        this.location = airportLoc;
        this.type = airportType;
    }

    private String getName() {
        return this.name;
    }

    private String getLocation() {
        return this.location;
    }

    private String getType() {
        return this.type;
    }

    private void setName() {
        this.name = name;
    }

    private void setLocation() {
        this.location = location;
    }

    private void setType() {
        this.type = type;
    }

    @Override
    public String toString() {
        return "airport.Airport name: " + this.name + "location: " + this.location + "airport type: " + this.type;
    }
}