public class Airline {
    private String company;
    private String arrival;
    private String departure;
    private float price;

    public Airline(String airlineCompany, String depCity, String arrCity, float ticketPrice) {
        this.company = airlineCompany;
        this.arrival = arrCity;
        this.departure = depCity;
        this.price = ticketPrice;
    }

    private String getCompany() {
        return this.company;
    }

    private String getArrival() {
        return this.arrival;
    }

    private String getDeparture() {
        return this.departure;
    }

    private float getPrice() {
        return this.price;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "The Airline is " + this.company;
    }
}