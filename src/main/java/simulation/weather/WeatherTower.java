package src.main.java.simulation.weather;

import src.main.java.simulation.core.Coordinates;

public class WeatherTower extends Tower{
    public String getWeather(Coordinates p_coordinates) {
        WeatherProvider wp = WeatherProvider.getInstance();
        return wp.getCurrentWeather(p_coordinates);
    }

    public void changeWeather() {
        conditionChanged();
    }
} 