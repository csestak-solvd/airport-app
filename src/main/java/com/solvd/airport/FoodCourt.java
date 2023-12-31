package com.solvd.airport;

import com.solvd.exceptions.InvalidFoodItemException;
import com.solvd.interfaces.IFacility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.invoke.MethodHandles;
import java.util.Arrays;
import java.util.List;

public class FoodCourt implements IFacility {

    private static final Logger LOGGER = LogManager.getLogger(MethodHandles.lookup().lookupClass());
    private String foodType;
    private String restaurantName;
    private double price;

    public FoodCourt(String food, String place, double fPrice) {
        this.foodType = food;
        this.restaurantName = place;
        this.price = fPrice;
    }

    public String getFoodType() {
        return foodType;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public double getPrice() {
        return price;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void orderFood(String foodItem) throws InvalidFoodItemException {
        if (!isValidFoodItem(foodItem)) {
            throw new InvalidFoodItemException("Invalid food Item: " + foodItem);
        }
        LOGGER.info("Food Ordered: " + foodItem);

    }

    private boolean isValidFoodItem(String foodItem) {
        List<String> validFoodItems = Arrays.asList("Pizza", "Burger", "Salad");
        return validFoodItems.contains(foodItem);
    }

    @Override
    public String getName() {
        return restaurantName;
    }
}