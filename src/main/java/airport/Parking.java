package airport;

public class Parking {
    
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
}