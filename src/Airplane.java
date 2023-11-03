public class Airplane implements Board, Arrive, Depart {
    private int capacity;
    private int tailNumber;
    private Flight flight;

    public Airplane(int capacity, int tailNumber) {
        this.capacity = capacity;
        this.tailNumber = tailNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getTailNumber() {
        return tailNumber;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setTailNumber(int tailNumber) {
        this.tailNumber = tailNumber;
    }

    @Override
    public void boardingTime() {
        System.out.println("Plane boards in 30 minutes");
    }

    @Override
    public void boardingStatus() {
        System.out.println("Plane has been boarded.");
    }

    @Override
    public void depart() {
        System.out.println("I departed on a " + depPlane);
    }

    @Override
    public void arrive() {
        System.out.println("I arrived on a " + arrPlane);
    }

    @Override
    public String toString() {
        return "this planes capacity is:" + this.capacity + "tail number: " + this.tailNumber;
    }
}