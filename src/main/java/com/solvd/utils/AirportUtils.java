package com.solvd.utils;

import com.solvd.airport.Airport;
import com.solvd.airport.Gate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;

public final class AirportUtils {
    private static final Logger LOGGER = LogManager.getLogger(MethodHandles.lookup().lookupClass());
    public static final String SPECIAL_NEEDS_CATEGORY = "Special Needs";

    public static final boolean isSpecialNeedsCategory(String category) {
        return SPECIAL_NEEDS_CATEGORY.equals(category);
    }

    static {
        LOGGER.info("interfaces.AirportUtils is initializing...");
    }

    public static ArrayList<Gate> findAvailableGates(Airport airport, String desiredGateType) {
        ArrayList<Gate> availableGates = new ArrayList<>();

        ArrayList<Gate> gates = airport.getGates();

        for (Gate gate : gates) {
            if (gate.getGateStatus().equals("Available") && gate.getGateType().equals(desiredGateType)) {
                availableGates.add(gate);
            }
        }
        return availableGates;
    }
}
