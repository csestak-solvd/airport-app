import java.util.Date;
public class Person {
    private Date bday;
    private String name;
    private String sex;

    public Person(Date bday, String name, String sex) {
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

    public Date getBday() {
        return bday;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setBday(Date bday) {
        this.bday = bday;
    }

    @Override
    public String toString() {
        return "Person: [Name: " + name + ", Age: " + bday + ", Sex: " + sex + "]";
    }
}