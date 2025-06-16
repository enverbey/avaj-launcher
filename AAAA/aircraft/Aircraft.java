package aircraft;
import Coordinates;
import Flyable;

public abstract class Aircraft extends Flyable{
    protected long id;
    protected String name;
    protected String type;
    protected Coordinates coordinates;

    protected Aircraft(long p_id, String p_name, Coordinates p_coordinate)
    {
        this.id = p_id;
        this.name = p_name;
        this.coordinates = p_coordinate;
    }

    // Getters
    public long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public Coordinates getCoordinates() {
        return coordinates;
    }
    public String getType() {
        return type;
    }

    //Setters
    protected void setType(String _type) {
        this.type = _type;
    }
}