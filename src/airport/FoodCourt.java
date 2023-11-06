package airport;

public class FoodCourt {
    
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

}