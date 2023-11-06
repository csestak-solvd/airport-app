package airport;

public class Airline {

    private String companyName;

    public Airline(String airlineCompany) {
        this.companyName = airlineCompany;
    }

    private String getCompanyName() {
        return this.companyName;
    }


    public void setCompanyName(String company) {
        this.companyName = company;
    }

    @Override
    public String toString() {
        return "The airport.Airline is " + this.companyName;
    }
}