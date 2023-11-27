package com.solvd.airport;

import com.solvd.exceptions.BagOverweightException;
import com.solvd.interfaces.ILuggageWeightCheck;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.invoke.MethodHandles;

public class Luggage implements ILuggageWeightCheck {

    private static final Logger LOGGER = LogManager.getLogger(MethodHandles.lookup().lookupClass());
    private int count;
    private int weight;

    public Luggage(int bagCount, int weight) {
        this.count = bagCount;
        this.weight = weight;
    }

    public int getCount() {
        return count;
    }

    public int getWeight() {
        return weight;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public void weightCheck() throws BagOverweightException {
        if (this.weight > 20) {
            throw new BagOverweightException("Bag is too heavy and will cost you more");
        } else {
            LOGGER.info("Bag is Checked");
        }
    }

    @Override
    public String toString() {
        return "Luggage{" + "count=" + count + ", weight=" + weight + "}";
    }
}