package com.solvd.airport;

import com.solvd.enums.RestroomType;
import com.solvd.exceptions.RestroomUnavailableException;
import com.solvd.interfaces.IFacility;
import com.solvd.interfaces.IRestroomAvailability;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.invoke.MethodHandles;

public class Restroom implements IRestroomAvailability, IFacility {

    private static final Logger LOGGER = LogManager.getLogger(MethodHandles.lookup().lookupClass());
    private RestroomType restroomType;
    private boolean clean;
    private boolean available;

    public Restroom(RestroomType restroomType, boolean isItClean, boolean avail) {
        this.restroomType = restroomType;
        this.available = avail;
        this.clean = isItClean;
    }

    public RestroomType getSex() {
        return restroomType;
    }

    public boolean isRestroomAvailable() {
        return available;
    }

    public boolean isClean() {
        return clean;
    }

    public void setSex(RestroomType restroomType) {
        this.restroomType = restroomType;
    }

    public void isAvailable(boolean available) {
        this.available = available;
    }

    public void setClean(boolean clean) {
        this.clean = clean;
    }

    public void useRestroom() throws RestroomUnavailableException {
        if (!isRestroomAvailable()) {
            throw new RestroomUnavailableException("Restroom is currently unavailable");
        }
        LOGGER.info("Restroom is available for use");
    }

    @Override
    public String getName() {
        switch (restroomType) {
            case MALE:
                return "Male";
            case FEMALE:
                return "Female";
            default:
                return "Neutral";
        }
    }

    @Override
    public void checkAvailability() {
        LOGGER.info("The" + restroomType + "bathroom is clean:" + clean + "and is ready to use:" + available);
    }
    
    @Override
    public String toString() {
        return "The" + this.restroomType + "restroom is clean:" + this.clean + "and is available" + this.available + ".";
    }
}