public class Airport implements Arrive, Depart {
    private String name;
    private String location;
    private String type;

    public Airport(String airportName, String airportLoc, String airportType) {
        this.name = airportName;
        this.location = airportLoc;
        this.type = airportType;
    }

    private String getName() {
        return this.name;
    }

    private String getLocation() {
        return this.location;
    }

    private String getType() {
        return this.type;
    }

    private void setName() {
        this.name = name;
    }

    private void setLocation() {
        this.location = location;
    }

    private void setType() {
        this.type = type;
    }

    @Override
    public void depart() {
        System.out.println("I departed on a " + depPlane);
    }

    @Override
    public void arrive() {
        System.out.println("I arrived on a " + arrPlane);
    }

    @Override
    public String toString() {
        return "Airport name: " + this.name + "location: " + this.location + "airport type: " + this.type;
    }
}