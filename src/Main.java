import airport.*;
import exceptions.*;
import interfaces.AirportUtils;
import people.Employee;
import people.Passenger;
import people.Person;

import java.time.LocalDate;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.invoke.MethodHandles;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(MethodHandles.lookup().lookupClass());

    public static void main(String[] args) {

        LocalDate birthDate = LocalDate.of(1990, 5, 15);

        Parking parking = new Parking("Extended parking", 55, 15);

        FoodCourt foodCourt = new FoodCourt("Pork Fried Rice", "Panda Express", 12);

        try (FoodCourt foodCourt1 = new FoodCourt("Pizza", "Dominoes", 12)) {
            foodCourt1.orderFood("Burger");
            LOGGER.info("Order Received!");
        } catch (InvalidFoodItemException e) {
            LOGGER.error("Error ordering food: " + e.getMessage());
        }

        Person person = new Person(birthDate, "Ryan Reynolds", "Male");
        person.eat(foodCourt);

        Passenger passenger = new Passenger(birthDate, "Ryan Reynolds", "Male", false, false, true);
        Passenger passenger1 = new Passenger(LocalDate.of(1989, 3, 12), "Jake Gyllenhal", "Male", false, false, true);

        Airline airline = new Airline("Spirit");

        Flight flight = new Flight("8:00AM", "11:00AM", 250);
        flight.addPassenger(passenger);
        flight.addPassenger(passenger1);
        flight.setAirline(airline);

        try {
            Passenger foundPassenger = flight.findPassengerById(1);
            LOGGER.info("Found: " + foundPassenger);

            Passenger removedPassenger = flight.removePassengerById(2);
            if(removedPassenger != null) {
                LOGGER.info("Passenger removed: " + removedPassenger);
            } else {
                LOGGER.error("Passenger not Found.");
            }
            LOGGER.debug("Updated Passenger List: " + flight.getPassengers());
        } catch (PassengerNotFoundException e) {
            LOGGER.error("Error: " + e.getMessage());
        }

        Employee employee = new Employee(birthDate, "Brailee Ses", "Female", "Ramp Controller", "On Shift");

        Airplane airplane = new Airplane(150, 8810);
        airplane.setFlight(flight);

        Restroom restroom = new Restroom("Male", true, true);

        try {
            restroom.useRestroom();
        } catch (RestroomUnavailableException e) {
            LOGGER.error("Error:" + e.getMessage());
        }


        Gate gate = new Gate("A123", "Available", "Regional");
        Gate gate1 = new Gate("B456", "Boarding", "Domestic");
        Airport airport = new Airport("Hobby Airport", "Houston", "International");
        airport.addEmployee(employee);
        airport.addAirline(airline);
        airport.addRestroom(restroom);
        airport.addFoodCourt(foodCourt);
        airport.addParking(parking);
        airport.addGate(gate);
        airport.addGate(gate1);
        airport.addFlight(flight);

        try {
            //Find a flight by ID
            Flight foundFlight = airport.findFlightById(1);
            LOGGER.info("Flight Found: " + foundFlight);
        } catch (FlightNotFoundException e) {
            LOGGER.error("Error:" + e.getMessage());
        }

        String desiredGateType = "Regional";

        ArrayList<Gate> availableGates = AirportUtils.findAvailableGates(airport, desiredGateType);

        for (Gate gates : availableGates) {
            LOGGER.info("Gate Number: " + gates.getGateNumber());
            LOGGER.info("Gate Status: " + gates.getGateStatus());
            LOGGER.info("Gate Type: " + gates.getGateType());

        }

        try {
            gate1.performGateOperation();
        } catch (InvalidGateException e) {
            LOGGER.error("Error handling invalid Gate: " + e.getMessage());
        }

    }
}