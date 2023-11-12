package interfaces;

import airport.Airport;
import airport.Gate;

import java.util.ArrayList;

public final class AirportUtils {

    public static final String SPECIAL_NEEDS_CATEGORY = "Special Needs";

    public static final boolean isSpecialNeedsCategory(String category) {
        return SPECIAL_NEEDS_CATEGORY.equals(category);
    }

    static {
        System.out.println("interfaces.AirportUtils is initializing...");
    }

    public static ArrayList<Gate> findAvailableGates(Airport airport, String desiredGateType) {
        ArrayList<Gate> availableGates = new ArrayList<>();

        ArrayList<Gate> gates = airport.getGates();

        for (Gate gate : gates) {
            if(gate.getGateStatus().equals("Available") && gate.getGateType().equals(desiredGateType)) {
                availableGates.add(gate);
            }
        }
        return availableGates;
    }
}
