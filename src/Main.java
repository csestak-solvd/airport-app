import airport.*;
import people.Employee;
import people.Passenger;
import people.Person;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        LocalDate birthDate = LocalDate.of(1990, 5, 15);

        Parking parking = new Parking("Extended parking", 55, 15);

        Person person = new Person(birthDate, "Ryan Reynolds", "Male");

        Passenger passenger = new Passenger(birthDate, "Ryan Reynolds", "Male", false, false, true);

        Employee employee = new Employee(birthDate, "Brailee Ses", "Female", "Ramp Controller", "On Shift");

        Airline airline = new Airline("Spirit");

        Airplane airplane = new Airplane(150, 8810);

        Airport airport = new Airport("Hobby Airport", "Houston", "International");

        FoodCourt foodCourt = new FoodCourt("Pizza", "Dominoes", 12);

        Restroom restroom = new Restroom("Male", true, true);

        Gate gate = new Gate("A123", "Boarding", "Regional");
    }
}