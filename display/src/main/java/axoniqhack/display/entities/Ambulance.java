package axoniqhack.display.entities;

public class Ambulance {

    public final String id;
    public final Location location;
    public final String name;

    private Ambulance(String id, Location location, String name) {
        this.id = id;
        this.location = location;
        this.name = name;
    }

}
