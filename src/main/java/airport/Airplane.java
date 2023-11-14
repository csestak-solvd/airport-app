package airport;

import interfaces.IPlane;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.invoke.MethodHandles;

public class Airplane implements IPlane {

    private static final Logger LOGGER = LogManager.getLogger(MethodHandles.lookup().lookupClass());
    private int capacity;
    private int tailNumber;
    private Flight flight;

    public Airplane(int capacity, int tailNumber) {
        this.capacity = capacity;
        this.tailNumber = tailNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getTailNumber() {
        return tailNumber;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setTailNumber(int tailNumber) {
        this.tailNumber = tailNumber;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    @Override
    public void boardingTime() {
        LOGGER.info("Plane boards in 30 minutes");
    }

    @Override
    public void boardingStatus() {
        LOGGER.info("Plane has been boarded.");
    }

    @Override
    public void depart() {
        LOGGER.info("I departed on a Boeing 747");
    }

    @Override
    public void arrive() {
        LOGGER.info("I arrived on a Boeing 757");
    }

    @Override
    public String toString() {
        return "this planes capacity is:" + this.capacity + "tail number: " + this.tailNumber;
    }
}