import airport.*;
import interfaces.AirportUtils;
import people.Employee;
import people.Passenger;
import people.Person;
import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        LocalDate birthDate = LocalDate.of(1990, 5, 15);

        Parking parking = new Parking("Extended parking", 55, 15);

        FoodCourt foodCourt = new FoodCourt("Pizza", "Dominoes", 12);

        Person person = new Person(birthDate, "Ryan Reynolds", "Male");
        person.eat(foodCourt);

        Passenger passenger = new Passenger(birthDate, "Ryan Reynolds", "Male", false, false, true);

        Airline airline = new Airline("Spirit");

        Flight flight = new Flight("8:00AM", "11:00AM", 250);
        flight.addPassenger(passenger);
        flight.setAirline(airline);

        Employee employee = new Employee(birthDate, "Brailee Ses", "Female", "Ramp Controller", "On Shift");


        Airplane airplane = new Airplane(150, 8810);
        airplane.setFlight(flight);

        Restroom restroom = new Restroom("Male", true, true);

        Gate gate = new Gate("A123", "Available", "Regional");

        Airport airport = new Airport("Hobby Airport", "Houston", "International");
        airport.addEmployee(employee);
        airport.addAirline(airline);
        airport.addRestroom(restroom);
        airport.addFoodCourt(foodCourt);
        airport.addParking(parking);
        airport.addGate(gate);

        String desiredGateType = "Regional";

        ArrayList<Gate> availableGates = AirportUtils.findAvailableGates(airport, desiredGateType);

        for (Gate gates : availableGates) {
            System.out.println("Gate Number: " + gates.getGateNumber());
            System.out.println("Gate Status: " + gates.getGateStatus());
            System.out.println("Gate Type: " + gates.getGateType());
            System.out.println(); // Add a separator between gates
        }

    }
}