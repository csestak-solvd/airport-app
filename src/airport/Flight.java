package airport;

import people.Passenger;

import java.util.ArrayList;

public class Flight {
    
    private String departureTime;
    private String arrivalTime;
    private int price;
    private ArrayList<Passenger> passengers;
    private Airline airline;

    public Flight (String departureTime, String arrivalTime, int price){
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.price = price;
    }
}