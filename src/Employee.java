public class Employee extends Person {
    private String position;
    private String working;

    public Employee(int age, String name, String sex,String position, String working) {
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