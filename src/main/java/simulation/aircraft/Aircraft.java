package src.main.java.simulation.aircraft;

import src.main.java.simulation.core.Coordinates;

public class Aircraft extends Flyable {
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

    @Override
    public long getID() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Coordinates getCoordinates() {
        return coordinates;
    }

    @Override
    public String getType() {
        return type;
    }

    //Setter for type
    protected void setType(String _type) {
        this.type = _type;
    }

    @Override
    public void updateConditions()
    {
        // This method should be implemented in subclasses
        // to update the aircraft's conditions based on the weather.
        // It is left abstract here to enforce implementation in subclasses.
        System.out.println("Update conditions not implemented for " + type);
    }
}