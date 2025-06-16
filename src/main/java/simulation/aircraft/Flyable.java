package simulation.aircraft;

abstract public class Flyable {
    protected WeatherTower weatherTower;

    public abstract void updateConditions();
    public abstract long getID();
    public abstract String getName();
    public abstract String getType();
    public abstract Coordinates getCoordinates();

    public void registerTower(WeatherTower p_tower)
    {
        weatherTower = p_tower;
        p_tower.register(this);
    }

}

