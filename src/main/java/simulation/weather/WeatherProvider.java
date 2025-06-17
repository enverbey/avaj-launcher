package simulation.weather;

import simulation.core.Coordinates;

public class WeatherProvider
{
    private String[] weather;
    private static WeatherProvider wProvider = null;

    private WeatherProvider()
    {
        this.weather = new String[] {"RAIN", "FOG", "SUN", "SNOW"};

    }

    public static WeatherProvider getInstance()
    {
        if (WeatherProvider.wProvider == null)
        {
            WeatherProvider.wProvider = new WeatherProvider();
        }
        return (WeatherProvider.wProvider);
    }

    public String getCurrentWeather(Coordinates p_coordinates)
    {
        long total = Math.abs(p_coordinates.getLongitude() + p_coordinates.getLatitude() + p_coordinates.getHeight());
        return (this.weather[Math.floorMod(total, weather.length)]);
    }
}