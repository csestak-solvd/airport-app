public class Employee extends Person {
    private String position;
    private String working;

    public Employee(String position, String working, String name int age, String sex) {
        super(age, name, sex);
        this.position = position;
        this.working = working;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getWorking() {
        return working;
    }

    public void setWorking(String working) {
        this.working = working;
    }

    @Override
    public String toString() {
        return "Employees position: " + this.position + "they are: " + this.working;
    }
}