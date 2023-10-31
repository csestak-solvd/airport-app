public class Passenger extends Person {
    private boolean assistance;
    private boolean guardian;
    private boolean security;

    public Passenger(boolean assistance, boolean guardian, boolean security) {
        super(35, "Jane Smith", "Female");
        this.assistance = assistance;
        this.guardian = guardian;
        this.security = security;
    }
}