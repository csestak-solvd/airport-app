import com.solvd.airport.*;
import com.solvd.enums.*;
import com.solvd.exceptions.*;
import com.solvd.interfaces.ISecurityService;
import com.solvd.utils.AirportUtils;
import com.solvd.people.Employee;
import com.solvd.people.Passenger;
import com.solvd.people.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.invoke.MethodHandles;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(MethodHandles.lookup().lookupClass());

    public static void main(String[] args) {
        Parking parking = new Parking("Extended parking", 55, 15);

        FoodCourt foodCourt = new FoodCourt("Pork Fried Rice", "Panda Express", 12);

        try (Scanner scanner = new Scanner(System.in)) {
            LOGGER.info("Enter the food Item: ");
            String foodItem = scanner.nextLine();
            foodCourt.orderFood(foodItem);
            LOGGER.info("Order Received!");
        } catch (InvalidFoodItemException e) {
            LOGGER.error("Error ordering food: " + e.getMessage());
        }

        Person person = new Person(LocalDate.of(1990, 5, 15), "Ryan Reynolds", "Male");
        person.eat(foodCourt);

        Passenger passengerRyan = new Passenger(LocalDate.of(1991, 2, 4), "Ryan Reynolds", "Male", false, false, true);
        Passenger passengerJake = new Passenger(LocalDate.of(1989, 3, 12), "Jake Gyllenhal", "Male", false, false, true);

        ISecurityService<Passenger> passengerSecurityService = passenger -> {
            int age = passenger.calculateAge();
            if (age >= 65) {
                return SecurityLevel.HIGH;
            } else if (age >= 18) {
                return SecurityLevel.MEDIUM;
            } else {
                return SecurityLevel.LOW;
            }
        };

        SecurityLevel assignedSecurityLevel = passengerSecurityService.assignSecurityLevel(passengerJake);
        passengerJake.setSecurityLevel(assignedSecurityLevel);
        LOGGER.info("Security Level: " + passengerJake.getSecurityLevel());

        Airline airline = new Airline("Spirit");

        // Create Flight instance
        Flight flight = new Flight(LocalDateTime.of(2023, 12, 1, 8, 0, 0), LocalDateTime.of(2023, 12, 1, 11, 0, 0), 250, FlightType.DOMESTIC);
        flight.addPassenger(passengerRyan);
        flight.addPassenger(passengerJake);
        flight.setAirline(airline);
        // Set the FlightStatus
        flight.setFlightStatus(FlightStatus.ON_TIME);
        // Print the Flight details
        LOGGER.info(flight);

        try {
            //creating luggage below weight 20
            Luggage luggage1 = new Luggage(1, 15);
            Luggage luggage2 = new Luggage(2, 18);
            //creating luggage over 20 weight to throw BagOverweightException
            Luggage luggage3 = new Luggage(3, 25);

            //creating passenger to add luggage
            Passenger passengerLug = new Passenger(LocalDate.of(1957, 1, 7), "Geroge Ses", "Male", false, false, false);
            //adding luggage to passengerLug luggage list
            passengerLug.addLuggage(luggage1);
            passengerLug.addLuggage(luggage2);
            passengerLug.addLuggage(luggage3);//this will throw BagOverweightException
            passengerLug.addCarryOnBag(1, 5);
            flight.addPassenger(passengerLug);

            //check the weight for each luggage in the passengers list
            for (Luggage luggage : passengerLug.getLuggageList().getAll()) {
                luggage.weightCheck();
            }
        } catch (BagOverweightException e) {
            LOGGER.error("Error:" + e.getMessage());
        }


        Employee employee = new Employee(LocalDate.of(1993, 8, 1), "Brailee Ses", "Female", "Ramp Controller", "On Shift");

        Airplane airplane = new Airplane(150, 8810);
        airplane.setFlight(flight);

        Restroom restroom = new Restroom(RestroomType.MALE, true, true);

        try {
            restroom.useRestroom();
        } catch (RestroomUnavailableException e) {
            LOGGER.error("Error:" + e.getMessage());
        }

        Gate gate = new Gate("A123", GateStatus.AVAILABLE,GateType.DOMESTIC);
        Gate gate1 = new Gate("B456", GateStatus.BOARDING, GateType.REGIONAL);
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
            LOGGER.info("Enter a flight Id");

            Scanner scanner = new Scanner(System.in);
            // Check if the next token is a valid integer
            if (scanner.hasNextInt()) {
                int targetFlightId = scanner.nextInt();

                // Consume the newline character left
                scanner.nextLine();

                try {
                    Optional<Flight> optionalFlight = airport.findFlightById(targetFlightId);

                    optionalFlight.ifPresent(foundFlight -> {
                        // Flight with the specified ID was found
                        LOGGER.info("Flight found: " + foundFlight);
                    });

                    if (optionalFlight.isEmpty()) {
                        // No flight with the specified ID was found
                        LOGGER.error("No flight found with ID: " + targetFlightId);
                    }
                } catch (FlightNotFoundException e) {
                    // Handle FlightNotFoundException
                    LOGGER.error("Error: " + e.getMessage());
                }
            } else {
                // Consume the invalid input
                scanner.nextLine();
                LOGGER.error("Invalid input. Please enter a valid input");
            }
        } catch (NoSuchElementException e) {
            LOGGER.error("Error: " + e.getMessage());
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

        try {
            Class<?> flightClass = Class.forName("com.solvd.airport.Flight");
            Constructor<?> constructor = flightClass.getDeclaredConstructor(
                    LocalDateTime.class, LocalDateTime.class, int.class, FlightType.class);
            Object newFlight = constructor.newInstance(
                    LocalDateTime.now(), // departureTime
                    LocalDateTime.now().plusHours(3), // arrivalTime
                    500, // price
                    Enum.valueOf(FlightType.class, "DOMESTIC")  // flightType
            );
            Method setFlightStatusMethod = flightClass.getDeclaredMethod("setFlightStatus", FlightStatus.class);
            Enum<?> flightStatusEnum = Enum.valueOf(FlightStatus.class, "ON_TIME");
            setFlightStatusMethod.invoke(newFlight, flightStatusEnum);
            LOGGER.info("Newly created Flight: " + newFlight);
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException |
                 IllegalAccessException | InvocationTargetException e) {
            LOGGER.error(e.getMessage());
        }

    }
}