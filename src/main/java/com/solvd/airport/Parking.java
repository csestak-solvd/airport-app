package com.solvd.airport;

import com.solvd.interfaces.IFacility;

public class Parking implements IFacility {

    private String lot;
    private int stall;
    private int price;

    public Parking(String parkingLot, int stallNumber, int parkPrice) {
        this.lot = parkingLot;
        this.stall = stallNumber;
        this.price = parkPrice;
    }

    public String getLot() {
        return lot;
    }

    public int getStall() {
        return stall;
    }

    public int getPrice() {
        return price;
    }

    public void setLot(String lot) {
        this.lot = lot;
    }

    public void setStall(int stall) {
        this.stall = stall;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String getName() {
        return lot;
    }
}