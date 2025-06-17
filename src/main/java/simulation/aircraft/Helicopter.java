package simulation.aircraft;

public class Helicopter extends Aircraft{
    public Helicopter(long p_id, String p_name, Coordinates p_coordinate) {
        super(p_id, p_name, p_coordinate);
        this.setType("Helicopter");
    }

    @Override
    public void updateConditions()
    {
        String weather = this.weatherTower.getWeather(coordinates);
        switch (weather) {
            case "SUN":
                coordinates.increaseLongitude(10);
                coordinates.increaseHeight(2);
                break;
            case "RAIN":
                coordinates.increaseLongitude(5);
                break;
            case "FOG":
                coordinates.increaseLongitude(1);
                break;
            case "SNOW":
                coordinates.decreaseHeight(12);
                break;
            default:
                throw new AssertionError(); //TODO ERROR DÜZENLEMESİ
        }

        LogManager.changeWeatherMessage(weather, "Helicopter", name, id);

        if (coordinates.getHeight() <= 0)
        {
            this.weatherTower.unregister(this);
            LogManager.logLanding("Helicopter", name, id);
        }
    }
}