public class Employee extends Person {
    private String position;
    private String working;

    public Employee(String position, String working) {
        super(29, "Eric Estrada", "Male");
        this.position = position;
        this.working = working;
    }
}