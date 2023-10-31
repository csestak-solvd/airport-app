public class Luggage {
    int count;
    int weight;

    public Luggage(int bagCount, int weight) {
        this.count = bagCount;
        this.weight = weight;
    }

    public int getCount() {
        return count;
    }

    public int getWeight() {
        return weight;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}