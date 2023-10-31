public class Main {
    public static void main(String[] args) {

        Parking parking = new Parking("Extended parking", 55, 15);
        parking.setLot("Extended Parking");
        parking.setStall(55);
        parking.setPrice(15);

        Person person = new Person(35, "Ryan Reynolds", "Male");
        person.setAge(35);
        person.setName("Ryan Reynolds");
        person.setSex("Male")

        Passenger passenger = new Passenger(false, false, true);
        passenger.setAssistance(false);
        passenger.setGuardian(false);
        passenger.setSecurity(true);

        Employee employee = new Employee("Ramp Controller", "On Shift");
        employee.setPosition("Ramp Controller");
        employee.setWorking("On Shift");

        Airline airline = new Airline("Spirit", "Los Angeles", "Naples", 450);
        airline.setCompany("Spirit");
        airline.setArrival("Los Angeles");
        airline.setDeparture("Naples");
        airline.setPrice(450);

        Airline[] airlines = new Airline[5];
        airlines[0] = new Airline("American", "Houston", "Dallas", 200);
        airlines[1] = new Airline("SouthWest", "Fort Meyers", "Atlanta", 300);
        airlines[2] = new Airline("United", "Casper", "New York", 400);
        airlines[3] = new Airline("Virgin", "Tahoe", "San Diego", 250);
        airlines[4] = new Airline("Frontier", "Sacramento", "New Orleans", 350);

        Airplane airplane = new Airplane(150, 8810);
        airplane.setCapacity(150);
        airplane.setTailNumber(8810);

        Airport airport = new Airport("Hobby Airport", "Houston", "International");
        airport.setName("Hobby Airport");
        airport.setLocation("Houston");
        airport.setType("International");

        FoodCourt[] foodCourt = new FoodCourt[5];
        food[0] = new FoodCourt("Pizza", "Dominoes", 12.99);
        food[1] = new FoodCourt("Burgers", "Red Robin", 10.99);
        food[2] = new FoodCourt("Sandwich", "Subway", 5.99);
        food[3] = new FoodCourt("Cookies", "Cookie Monsters", 4.99);
        food[4] = new FoodCourt("Fries", "McDonalds", 2.50);
        food.setFoodType("Pizza");
        food.setRestaurantName("Dominoes");
        food.setPrice(12.99);

        Restroom restroom = new Restroom("Male", true, true);
        restroom.setSex("Male");
        restroom.setClean(true);
        restroom.setAvailable(true);

        Gate gate = new Gate("A123", "Boarding", "Regional");
        gate.setGateNumber("A123");
        gate.setGateStatus("Boarding");
        gate.setGateType("Regional");
    }
}