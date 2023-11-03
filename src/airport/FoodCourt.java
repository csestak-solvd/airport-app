package airport;

public class FoodCourt {
    public static String foodType;
    public static String restaurantName;
    public static float price;

    public FoodCourt(String food, String place, float fPrice) {
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

    public float getPrice() {
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