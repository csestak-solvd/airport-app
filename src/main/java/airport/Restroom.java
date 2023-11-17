package airport;

import exceptions.RestroomUnavailableException;
import interfaces.IFacility;
import interfaces.IRestroomAvailability;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.invoke.MethodHandles;

public class Restroom implements IRestroomAvailability, IFacility {

    private static final Logger LOGGER = LogManager.getLogger(MethodHandles.lookup().lookupClass());

    private String sex;
    private boolean clean;
    private boolean available;

    public Restroom(String MoF, boolean isItClean, boolean avail) {
        this.sex = MoF;
        this.available = avail;
        this.clean = isItClean;
    }

    public String getSex() {
        return sex;
    }

    public boolean isRestroomAvailable() {
        return available;
    }

    public boolean isClean() {
        return clean;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setAvailable(boolean available) {
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
    public String getName(){
        return sex;
    }

    @Override
    public String toString() {
        return "The" + this.sex + "restroom is clean:" + this.clean + "and is available" + this.available + ".";
    }

    @Override
    public void checkAvailability() {
        LOGGER.info("The" + sex + "bathroom is clean:" + clean + "and is ready to use:" + available);
    }
}