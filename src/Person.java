public class Person {
    private Date bday;
    private String name;
    private String sex;

    public Person(Date bday, String name, String sex) {
        this.age = age;
        this.name = name;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person: [Name: " + name + ", Age: " + age + ", Sex: " + sex + "]";
    }
}