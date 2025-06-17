package simulation.aircraft;

public class JetPlane extends Aircraft{
    
    public JetPlane(long p_id, String p_name, Coordinates p_coordinate) {
        super(p_id, p_name, p_coordinate);
        this.setType("JetPlane");
    }

    @Override
    public void updateConditions()
    {
        String weather = this.weatherTower.getWeather(coordinates);
        switch (weather) {
            case "SUN":
                coordinates.increaseLatitude(10);
                coordinates.increaseHeight(2);
                break;
            case "RAIN":
                coordinates.increaseLatitude(5);
                break;
            case "FOG":
                coordinates.increaseLatitude(1);
                break;
            case "SNOW":
                coordinates.decreaseHeight(7);
                break;
            default:
                throw new AssertionError(); //TODO ERROR DÜZENLEMESİ
        }

        LogManager.changeWeatherMessage(weather, type, name, id);

        if (coordinates.getHeight() <= 0)
        {
            this.weatherTower.unregister(this);
            LogManager.logLanding(type, name, id);
        }
    }
}