public class Restroom {
    private String sex;
    private boolean clean;
    private boolean available;

    public Restroom(String MoF, boolean isItClean, boolean avail) {
        this.sex = MoF;
        this.available = avail;
        this.clean = isItClean;
    }
}