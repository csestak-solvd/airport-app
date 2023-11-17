package airport;

import exceptions.BagOverweightException;
import interfaces.ILuggageWeightCheck;
import org.apache.logging.log4j.LogManager;

import java.lang.invoke.MethodHandles;
import java.util.logging.Logger;

public class Luggage implements ILuggageWeightCheck {

    private static final org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger(MethodHandles.lookup().lookupClass());
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