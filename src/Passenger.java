public class Passenger extends Person implements Eat {
    private boolean assistance;
    private boolean guardian;
    private boolean security;

    public Passenger(int age, String name, String sex, boolean assistance, boolean guardian, boolean security) {
        super(age, name, sex);
        this.assistance = assistance;
        this.guardian = guardian;
        this.security = security;
    }


    public boolean isAssistanceNeeded() {
        return assistance;
    }


    public boolean hasGuardian() {
        return guardian;
    }

    public boolean hasSecurity() {
        return security;
    }

    public void setAssistance(boolean assistance) {
        this.assistance = assistance;
    }

    public void setGuardian(boolean guardian) {
        this.guardian = guardian;
    }

    public void setSecurity(boolean security) {
        this.security = security;
    }

    @Override
    public void eat() {
        System.out.println("Im hungry for" + this.foodType + "from" + this.restaurantName + "and the price is" + this.price);
    }
    @Override
    public String toString() {
        return "Passenger: " + super.toString() +
                ", Assistance: " + assistance +
                ", Guardian: " + guardian +
                ", Security: " + security;
    }
}