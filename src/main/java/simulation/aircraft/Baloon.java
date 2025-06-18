package src.main.java.simulation.aircraft;

import src.main.java.simulation.core.Coordinates;
import src.main.java.simulation.util.LogManager;

public class Baloon extends Aircraft{
    
    public Baloon(long p_id, String p_name, Coordinates p_coordinate) {
        super(p_id, p_name, p_coordinate);
        this.setType("Baloon");
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