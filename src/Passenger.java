public class Passenger extends Person {
    private boolean assistance;
    private boolean guardian;
    private boolean security;

    public Passenger(boolean assistance, boolean guardian, boolean security, String name int age, String sex) {
        super(age, name, sex);
        this.assistance = assistance;
        this.guardian = guardian;
        this.security = security;
    }

    public void setAssistance(boolean assistance) {
        this.assistance = assistance;
    }

    public boolean getAssistance() {
        return assistance;
    }

    public void setGuardian(boolean guardian) {
        this.guardian = guardian;
    }

    public boolean getGuardian() {
        return guardian;
    }

    public void setSecurity(boolean security) {
        this.security = security;
    }

    public boolean getSecurity() {
        return security;
    }

}