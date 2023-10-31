public class Main {
    public static void main(String[] args) {

        Parking parking = new Parking("Extended parking", 55, 15);
        parking.setLot("Extended Parking");
        parking.setStall(55);
        parking.setPrice(15);



        Airline airline = new Airline("Spirit", "Los Angeles", "Naples", 450);
        airline.setCompany("Spirit");
        airline.setArrival("Los Angeles");
        airline.setDeparture("Naples");
        airline.setPrice(450);

        Airline[] airlines = new Airline[5];
        airlines[0] = new Airline("American", "Houston", "Dallas", 200) ;
        airlines[1] = new Airline("SouthWest", "Fort Meyers", "Atlanta", 300);
        airlines[2] = new Airline("United", "Casper", "New York", 400);
        airlines[3] = new Airline("Virgin", "Tahoe", "San Diego", 250);
        airlines[4] = new Airline("Frontier", "Sacramento", "New Orleans", 350);
    }
}