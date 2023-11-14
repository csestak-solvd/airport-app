package airport;

import exceptions.FlightNotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import people.Passenger;
import exceptions.PassengerNotFoundException;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;

public class Flight {

    private static final Logger LOGGER = LogManager.getLogger(MethodHandles.lookup().lookupClass());

    private static int flightIdCounter = 1;
    private int flightId;
    private String departureTime;
    private String arrivalTime;
    private int price;
    private ArrayList<Passenger> passengers;
    private Airline airline;

    public Flight(String departureTime, String arrivalTime, int price) {
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.price = price;
        this.passengers = new ArrayList<>();
        this.flightId = flightIdCounter++;
    }

    public void addPassenger(Passenger passenger) {
        passengers.add(passenger);
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
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

    public int getFlightId(){
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
        for (Passenger passenger : passengers) {
            if (passenger.getPassengerId() == passengerId) {
                return passenger;
            }
        }

        throw new PassengerNotFoundException("Passenger with the ID: " + passengerId + " not found.");
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

    @Override
    public String toString() {
        return "Flight departure time: " + departureTime + ", arrivale time: " + arrivalTime + ", price: " + price + ", flight ID: " + flightId + ", Passenger List: " + passengers;
    }
}