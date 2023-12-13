package com.solvd.airport;

import com.solvd.enums.FlightStatus;
import com.solvd.exceptions.FlightNotFoundException;
import com.solvd.exceptions.InvalidGateException;
import com.solvd.interfaces.IAnnouncement;
import com.solvd.interfaces.IFacility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.solvd.people.Employee;

import java.lang.invoke.MethodHandles;
import java.util.*;
import java.util.stream.Collectors;

public class Airport implements IAnnouncement {

    private static final Logger LOGGER = LogManager.getLogger(MethodHandles.lookup().lookupClass());
    private final String OPERATING_HOURS = "0500-2200";
    private String name;
    private String location;
    private String type;
    private Map<String, IFacility> airportFacilitiesMap;
    private ArrayList<Airline> airlines;
    private ArrayList<Employee> employees;
    private ArrayList<Gate> gates;
    private ArrayList<Flight> flights;

    public Airport(String airportName, String airportLoc, String airportType) {
        this.name = airportName;
        this.location = airportLoc;
        this.type = airportType;
        this.airportFacilitiesMap = new HashMap<>();
        this.airlines = new ArrayList<>();
        this.employees = new ArrayList<>();
        this.gates = new ArrayList<>();
        this.flights = new ArrayList<>();
    }

    public void addAirline(Airline airline) {
        airlines.add(airline);
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void addRestroom(Restroom restroom) {
        airportFacilitiesMap.put(restroom.getName(), restroom);
    }

    public void addFoodCourt(FoodCourt foodCourt) {
        airportFacilitiesMap.put(foodCourt.getName(), foodCourt);
    }

    public void addParking(Parking parking) {
        airportFacilitiesMap.put(parking.getName(), parking);
    }

    public IFacility getFacilityByName(String facilityName) {
        return airportFacilitiesMap.get(facilityName);
    }

    public void addGate(Gate gate) {
        gates.add(gate);
    }

    public void addFlight(Flight flight) {
        flights.add(flight);
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

    public List<Flight> getFlights() {
        return flights;
    }

    public List<Flight> getDelayedFlights() {
        return flights.stream()
                .filter(flight -> flight.getFlightStatus() == FlightStatus.DELAYED)
                .collect(Collectors.toList());
    }

    public ArrayList<Gate> getGates() {
        return gates;
    }

    public void setGates(ArrayList<Gate> gates) {
        this.gates = gates;
    }

    public Optional<Flight> findFlightById(int flightId) throws FlightNotFoundException {
        return flights.stream()
                .filter(flight -> flight.getFlightId() == flightId)
                .findFirst();
    }

    public void performAirportOperation() {
        gates.forEach(gate -> {
            try {
                gate.performGateOperation();
            } catch (InvalidGateException e) {
                handleInvalidGateException(e);
            }
        });
    }

    private void handleInvalidGateException(InvalidGateException e) {
        LOGGER.error("Airport-level error: " + e.getMessage());
    }


    @Override
    public void gateAnnouncement() {
        LOGGER.debug("Gate: " + this.gates.get(0) + "is now boarding");
    }

    @Override
    public void lotAnnouncement() {
        String parkingLotName = "Extended parking";
        IFacility facility = airportFacilitiesMap.get(parkingLotName);
        if (facility instanceof Parking) {
            Parking parkingLot = (Parking) facility;
            LOGGER.error("Parking lot:" + parkingLot + " is now full");
        } else {
            LOGGER.error("Parking lot not found");
        }
    }

    @Override
    public void employeeAnnouncement() {
        LOGGER.info("Would employee: " + this.employees.get(0) + " please return to " + this.employees.get(0).getPosition());
    }

    @Override
    public String toString() {
        return "Airport name: " + this.name + "operating hours: " + OPERATING_HOURS + ", location: " + this.location + ", airport type: " + this.type;
    }
}
