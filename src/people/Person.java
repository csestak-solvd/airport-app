package people;
import java.time.LocalDate;

public class Person {
    private LocalDate bday;
    private String name;
    private String sex;

    public Person(LocalDate bday, String name, String sex) {
        this.bday = bday;
        this.name = name;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public LocalDate getMyDate() {
        return bday;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setMyDate(LocalDate date) {
        bday = date;
    }

    @Override
    public String toString() {
        return "Person: [Name: " + name + ", bday: " + bday + ", Sex: " + sex + "]";
    }
}