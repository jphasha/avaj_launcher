package za.co.wethinkcode.royalAirServices.aircraftFactory;

public abstract class Aircraft {
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    private static long idCounter;

    static {
        idCounter = 0;
    }

    protected Aircraft(String name, Coordinates coordinates) {
        this.name = name;
        this.coordinates = coordinates;
        this.id = nextId();
    }
    private long nextId() {
        this.id = ++idCounter;
        return this.id;
    }
}