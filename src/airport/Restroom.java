package airport;

public class Restroom {
    private String sex;
    private boolean clean;
    private boolean available;

    public Restroom(String MoF, boolean isItClean, boolean avail) {
        this.sex = MoF;
        this.available = avail;
        this.clean = isItClean;
    }

    public String getSex() {
        return sex;
    }

    public boolean isAvailable() {
        return available;
    }

    public boolean isClean() {
        return clean;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void setClean(boolean clean) {
        this.clean = clean;
    }

    public void useRestroom() {
        System.out.println("Restroom is available for use");
    }

    @Override
    public String toString() {
        return "The" + this.sex + "restroom is clean:" + this.clean + "and is available" + this.available + ".";
    }
}