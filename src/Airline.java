public class Airline {

    private String company;

    public Airline(String airlineCompany) {
        this.company = airlineCompany;
    }

    private String getCompany() {
        return this.company;
    }


    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "The Airline is " + this.company;
    }
}