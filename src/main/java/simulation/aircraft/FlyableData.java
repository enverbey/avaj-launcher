package src.main.java.simulation.aircraft;

public class FlyableData {
    public String type;
    public String name;
    public int longitude;
    public int latitude;
    public int height;

    public FlyableData(String type, String name, int longitude, int latitude, int height) {
        this.type = type;
        this.name = name;
        this.longitude = longitude;
        this.latitude = latitude;
        this.height = height;
    }
}
