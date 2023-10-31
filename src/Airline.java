public class Airline {
    private String company;
    private String arrival;
    private String departure;
    private float price;

    public Airline(String airlineCompany, String depCity, String arrCity, float ticketPrice){
        this.company = airlineCompany;
        this.arrival = arrCity;
        this.departure = depCity;
        this.price = ticketPrice;
    }
    private String getCompany(){
        return this.company;
    }
    private String getArrival(){
        return this.arrival;
    }
    private String getDeparture(){
        return this.departure;
    }
    private float getPrice(){
        return this.price;
    }
    void setCompany(String company){
        this.company = company;
    }
    void setArrival(String arrival){
        this.arrival = arrival;
    }
    void setDeparture(String departure){
        this.departure = departure;
    }
    void setPrice(float price){
        this.price = price;
    }

    public String toString(){
        return "this Airline is " + this.company;
    }
}