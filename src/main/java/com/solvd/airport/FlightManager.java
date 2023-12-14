package com.solvd.airport;

import com.solvd.enums.FlightStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FlightManager {
    public static List<Flight> filterFlightsByStatus(ArrayList<Flight> flights, FlightStatus flightStatus) {
        return flights.stream()
                .filter(flight -> flight.getFlightStatus() == flightStatus)
                .collect(Collectors.toList());
    }

    public List<Flight> filterFlights(List<Flight> flights, Predicate<Flight> condition) {
        return flights.stream()
                .filter(condition)
                .collect(Collectors.toList());
    }

    public void displayFlightStatusMessages(List<Flight> flights) {
        for( Flight flight : flights) {
            flight.displayStatusMessage();
        }
    }
}
