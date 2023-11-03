import airport.*;
import people.Employee;
import people.Passenger;
import people.Person;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        LocalDate birthDate = LocalDate.of(1990, 5, 15);

        Parking parking = new Parking("Extended parking", 55, 15);
        parking.setLot("Extended Parking");
        parking.setStall(55);
        parking.setPrice(15);

        Person person = new Person(birthDate, "Ryan Reynolds", "Male");
//        person.setAge(35);
//        person.setName("Ryan Reynolds");
//        person.setSex("Male");

        Passenger passenger = new Passenger(birthDate, "Ryan Reynolds", "Male", false, false, true);
//        passenger.setAssistance(false);
//        passenger.setGuardian(false);
//        passenger.setSecurity(true);

//        Passenger[] passengers = new Passenger[5];
//        passengers[0] = new Passenger(43, "Tony Montana", "Male", false, false, true);
//        passengers[1] = new Passenger(44, "Taylor Jacobs", "Female", true, false, true);
//        passengers[2] = new Passenger(45, "Kris Griffin", "Male", false, false, true);
//        passengers[3] = new Passenger(46, "Kyle Kyle", "Male", true, false, true);
//        passengers[4] = new Passenger(47, "Enrique", "Male", false, false, true);

        Employee employee = new Employee(birthDate, "Brailee Ses", "Female", "Ramp Controller", "On Shift");
//        Employee[] employees = new Employee[5];
//        employees[0] = new Employee(48, "Samsonite", "Male", "TSA", "Off");
//        employees[1] = new Employee(49, "Jacob", "Male", "Security", "On shift");
//        employees[2] = new Employee(50, "Kris", "Male", "Tower Controller", "Off");
//        employees[3] = new Employee(51, "Kyle", "Male", "Concierge", "Off");
//        employees[4] = new Employee(52, "Estrada", "Male", "Radar Controller", "On Shift");

        Airline airline = new Airline("Spirit");
//        Airline[] airlines = new Airline[5];
//        airlines[0] = new Airline("American", "Houston", "Dallas", 200);
//        airlines[1] = new Airline("SouthWest", "Fort Meyers", "Atlanta", 300);
//        airlines[2] = new Airline("United", "Casper", "New York", 400);
//        airlines[3] = new Airline("Virgin", "Tahoe", "San Diego", 250);
//        airlines[4] = new Airline("Frontier", "Sacramento", "New Orleans", 350);

//        Airplane airplane = new Airplane(150, 8810);
//        airplane.setCapacity(150);
//        airplane.setTailNumber(8810);

        Airport airport = new Airport("Hobby Airport", "Houston", "International");
//        airport.setName("Hobby Airport");
//        airport.setLocation("Houston");
//        airport.setType("International");

//        FoodCourt[] foodCourt = new FoodCourt[5];
//        foodCourt[0] = new FoodCourt("Pizza", "Dominoes", 12.99);
//        foodCourt[1] = new FoodCourt("Burgers", "Red Robin", 10.99);
//        foodCourt[2] = new FoodCourt("Sandwich", "Subway", 5.99);
//        foodCourt[3] = new FoodCourt("Cookies", "Cookie Monsters", 4.99);
//        foodCourt[4] = new FoodCourt("Fries", "McDonalds", 2.50);
//        food.setFoodType("Pizza");
//        food.setRestaurantName("Dominoes");
//        food.setPrice(12.99);

        Restroom restroom = new Restroom("Male", true, true);
//        restroom.setSex("Male");
//        restroom.setClean(true);
//        restroom.setAvailable(true);

        Gate gate = new Gate("A123", "Boarding", "Regional");
//        gate.setGateNumber("A123");
//        gate.setGateStatus("Boarding");
//        gate.setGateType("Regional");
    }
}