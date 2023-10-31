public class Airplane extends Passenger {
    private int capacity;
    private int tailNumber;

    public Airplane(int capacity, int tailNumber) {
        super(false, false, true)
        this.capacity = capacity;
        this.tailNumber = tailNumber;
    }
}