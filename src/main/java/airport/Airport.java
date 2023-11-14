package airport;

import exceptions.FlightNotFoundException;
import exceptions.InvalidGateException;
import interfaces.IAnnouncement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import people.Employee;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Airport implements IAnnouncement {

    private static final Logger LOGGER = LogManager.getLogger(MethodHandles.lookup().lookupClass());
    private final String OPERATING_HOURS = "0500-2200";
    private String name;
    private String location;
    private String type;

    private Map<String, Airline> airlinesMap;
    private Map<String, Employee> employeesMap;
    private Map<String, Restroom> restroomsMap;
    private Map<String, FoodCourt> foodCourtsMap;
    private Map<String, Parking> parkingLotsMap;
    private Map<String, Gate> gatesMap;
    private Map<Integer, Flight> flightsMap;

    private ArrayList<Airline> airlines;
    private ArrayList<Employee> employees;
    private ArrayList<Restroom> restrooms;
    private ArrayList<FoodCourt> foodCourts;
    private ArrayList<Parking> parkingLots;
    private ArrayList<Gate> gates;
    private ArrayList<Flight> flights;

    public Airport(String airportName, String airportLoc, String airportType) {
        this.name = airportName;
        this.location = airportLoc;
        this.type = airportType;
        this.airlinesMap = new HashMap<>();
        this.employeesMap = new HashMap<>();
        this.restroomsMap = new HashMap<>();
        this.foodCourtsMap = new HashMap<>();
        this.parkingLotsMap = new HashMap<>();
        this.gatesMap = new HashMap<>();
        this.flightsMap = new HashMap<>();
        this.airlines = new ArrayList<>();
        this.employees = new ArrayList<>();
        this.restrooms = new ArrayList<>();
        this.foodCourts = new ArrayList<>();
        this.parkingLots = new ArrayList<>();
        this.gates = new ArrayList<>();
        this.flights = new ArrayList<>();
    }

    public void addAirline(Airline airline) {
        airlinesMap.put(airline.getName(), airline);
        airlines.add(airline);
    }

    public void addEmployee(Employee employee) {
        employeesMap.put(employee.getName(), employee);
        employees.add(employee);
    }

    public void addRestroom(Restroom restroom) {
        restroomsMap.put(restroom.getSex(), restroom);
        restrooms.add(restroom);
    }

    public void addFoodCourt(FoodCourt foodCourt) {
        foodCourtsMap.put(foodCourt.getRestaurantName(), foodCourt);
        foodCourts.add(foodCourt);
    }

    public void addParking(Parking parking) {
        parkingLotsMap.put(parking.getLot(), parking);
        parkingLots.add(parking);
    }

    public void addGate(Gate gate) {
        gatesMap.put(gate.getGateNumber(), gate);
        gates.add(gate);
    }

    public void addFlight(Flight flight) {
        flightsMap.put(flight.getFlightId(), flight);
        flights.add(flight);
    }

    // Methods to get entities from the HashMaps

    public Airline getAirlineByName(String airlineName) {
        return airlinesMap.get(airlineName);
    }

    public Employee getEmployeeByName(String employeeName) {
        return employeesMap.get(employeeName);
    }

    public Restroom getRestroomBySex(String sex) {
        return restroomsMap.get(sex);
    }

    public FoodCourt getFoodCourtByName(String restaurantName) {
        return foodCourtsMap.get(restaurantName);
    }

    public Parking getParkingByName(String parkingName) {
        return parkingLotsMap.get(parkingName);
    }

    public Gate getGateByNumber(String gateNumber) {
        return gatesMap.get(gateNumber);
    }

    public Flight getFlightById(int flightId) {
        return flightsMap.get(flightId);
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

    public ArrayList<Flight> getFlights() {
        return flights;
    }

    public ArrayList<Gate> getGates() {
        return gates;
    }

    public void setGates(ArrayList<Gate> gates) {
        this.gates = gates;
    }

    public Flight findFlightById(int flightId) throws FlightNotFoundException {
        for (Flight flight : flights) {
            if (flight.getFlightId() == flightId) {
                return flight;
            }
        }

        throw new FlightNotFoundException("Flight ID:" + flightId + "not found.");
    }

    public void performAirportOperation() {
        for (Gate gate : gates) {
            try {
                gate.performGateOperation();
            } catch (InvalidGateException e) {
                handleInvalidGateException(e);
            }
        }
    }

    private void handleInvalidGateException(InvalidGateException e) {
        LOGGER.error("Airport-level error: " + e.getMessage());
    }

    @Override
    public String toString() {
        return "Airport name: " + this.name + ", location: " + this.location + ", airport type: " + this.type;
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
        LOGGER.info("Would employee: " + this.employees.get(0) + " please return to " + this.employees.get(0).getPosition());
    }
}