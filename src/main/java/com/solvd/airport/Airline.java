package com.solvd.airport;

public class Airline {

    private String companyName;

    public Airline(String airlineCompany) {
        this.companyName = airlineCompany;
    }

    public String getName() {
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