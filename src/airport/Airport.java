package airport;

import interfaces.IAnnouncement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import people.Employee;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;

public class Airport implements IAnnouncement {

    private static final Logger LOGGER = LogManager.getLogger(MethodHandles.lookup().lookupClass());
    private final String OPERATING_HOURS = "0500-2200";
    private String name;
    private String location;
    private String type;
    private ArrayList<Airline> airlines;
    private ArrayList<Employee> employees;
    private ArrayList<Restroom> restrooms;
    private ArrayList<FoodCourt> foodCourts;
    private ArrayList<Parking> parkingLots;
    private ArrayList<Gate> gates;

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

    public ArrayList<Airline> getAirlines() {
        return airlines;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public ArrayList<Restroom> getRestrooms() {
        return restrooms;
    }

    public ArrayList<FoodCourt> getFoodCourts() {
        return foodCourts;
    }

    public ArrayList<Parking> getParkingLots() {
        return parkingLots;
    }

    public ArrayList<Gate> getGates() {
        return gates;
    }

    public void setGates(ArrayList<Gate> gates) {
        this.gates = gates;
    }

    public void addAirline(Airline airline) {
        airlines.add(airline);
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void addRestroom(Restroom restroom) {
        restrooms.add(restroom);
    }

    public void addFoodCourt(FoodCourt foodCourt) {
        foodCourts.add(foodCourt);
    }

    public void addParking(Parking parking) {
        parkingLots.add(parking);
    }

    public void addGate(Gate gate) {
        gates.add(gate);
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

    @Override
    public void gateAnnouncement() {
        LOGGER.debug("Gate: " + this.gates.get(0) + "is now boarding");
    }

    @Override
    public void lotAnnouncement() {
        LOGGER.error("Parking lot:" + this.parkingLots.get(0) + " is now full");
    }

    @Override
    public void employeeAnnouncement() {
        LOGGER.info("Would employee: " + this.employees.get(0) + "please return to" + this.employees.get(0).getPosition());
    }
}