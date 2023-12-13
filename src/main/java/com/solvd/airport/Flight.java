package com.solvd.airport;

import com.solvd.enums.FlightStatus;
import com.solvd.enums.FlightType;
import com.solvd.exceptions.PassengerNotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.solvd.people.Passenger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.Optional;

public class Flight {

    private static final Logger LOGGER = LogManager.getLogger(MethodHandles.lookup().lookupClass());
    private static int flightIdCounter = 1;
    private int flightId;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private int price;
    private ArrayList<Passenger> passengers;
    private Airline airline;
    private FlightStatus flightStatus;
    private FlightType flightType;

    public Flight(LocalDateTime departureTime, LocalDateTime arrivalTime, int price, FlightType flightType) {
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.price = price;
        this.passengers = new ArrayList<>();
        this.flightType = flightType;
        this.flightId = flightIdCounter++;
    }

    public void addPassenger(Passenger passenger) {
        passengers.add(passenger);
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public FlightType getFlightType() {
        return flightType;
    }

    public void setFlightType() {
        this.flightType = flightType;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public FlightStatus getFlightStatus() {
        return flightStatus;
    }

    public void setFlightStatus(FlightStatus flightStatus) {
        this.flightStatus = flightStatus;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Airline getAirline() {
        return airline;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }

    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(ArrayList<Passenger> passengers) {
        this.passengers = passengers;
    }

    //finding passenger from the arraylist with unique id. if found returns it. if not throws
    public Passenger findPassengerById(int passengerId) throws PassengerNotFoundException {
        Optional<Passenger> passengerOptional = passengers.stream()
                .filter(passenger -> passenger.getPassengerId() == passengerId)
                .findFirst();

        return passengerOptional.orElseThrow(() ->
                new PassengerNotFoundException("Passenger with the ID: " + passengerId + " not found.")
        );
    }

    public void removePassengerById(int passengerId) {
        try {
            Passenger passengerToRemove = findPassengerById(passengerId);
            LOGGER.info("Passenger Removed." + passengerToRemove);
            passengers.remove(passengerToRemove);

        } catch (PassengerNotFoundException e) {
            LOGGER.error("Error: " + e.getMessage());
        }
    }

    public void displayStatusMessage() {
        switch (flightStatus) {
            case ON_TIME:
                LOGGER.info("The flight is on time.");
                break;
            case DELAYED:
                LOGGER.info("The flight is delayed.");
                break;
            case BOARDING:
                LOGGER.info("Boarding is in progress.");
                break;
            case IN_FLIGHT:
                LOGGER.info("The flight is currently in progress.");
                break;
            case LANDED:
                LOGGER.info("The flight has arrived.");
                break;
            case CANCELLED:
                LOGGER.info("The flight has been canceled.");
                break;
            default:
                LOGGER.info("Unknown flight status.");
        }
    }

    @Override
    public String toString() {
        //format LocalDatetime using DateTimeFormatter
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDepartureTime = departureTime.format(formatter);
        String formattedArrivalTime = arrivalTime.format(formatter);
        return "Flight departure time: " + formattedDepartureTime + ", arrival time: " + formattedArrivalTime + ", price: " + price + ", flight ID: " + flightId + ", Passenger List: " + passengers;
    }
}