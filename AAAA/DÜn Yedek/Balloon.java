import aircraft.Aircraft;

public class Balloon extends Aircraft{
    
    public Balloon(long p_id, String p_name, Coordinates p_coordinate) {
        super(p_id, p_name, p_coordinate);
    }

    @Override
    public void updateConditions()
    {
        String weather = this.weatherTower.getWeather(coordinates);
        switch (weather) {
            case "SUN":
                coordinates.increaseLongitude(2);
                coordinates.increaseHeight(4);
                break;
            case "RAIN":
                coordinates.decreaseHeight(5);
                break;
            case "FOG":
                coordinates.decreaseHeight(3);
                break;
            case "SNOW":
                coordinates.decreaseHeight(15);
                break;
            default:
                System.err.println("Unknown weather condition: " + weather);
                throw new AssertionError(); //TODO ERROR DÜZENLEMESİ
                
        }

        LogManager.changeWeatherMessage(weather, "Balloon", name, id);

        if (coordinates.getHeight() <= 0)
        {
            this.weatherTower.unregister(this);
            LogManager.logLanding("Balloon", name, id);
        }
    }
}