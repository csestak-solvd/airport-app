package airport;

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
    public void weightCheck() {
        if (this.weight > 20) {
            LOGGER.info("Bag is too heavy and will cost you more");
        } else {
            LOGGER.info("Bag is Checked");
        }
    }
}