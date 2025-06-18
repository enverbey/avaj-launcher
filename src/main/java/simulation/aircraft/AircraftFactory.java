package src.main.java.simulation.aircraft;

import src.main.java.simulation.core.Coordinates;

public class AircraftFactory
{
    private static long id = 0;
    private static AircraftFactory instance = null;

    private AircraftFactory() {
        
    }

    public static AircraftFactory getInstance()
    {
        if (AircraftFactory.instance == null)
        {
            AircraftFactory.instance = new AircraftFactory();
        }
        return (AircraftFactory.instance);
    }
    
    public Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates)
    {
        id++;
        switch (p_type.toLowerCase())
        {
            case "baloon":
                return new Baloon(id, p_name, p_coordinates);
            case "helicopter":
                return new Helicopter(id, p_name, p_coordinates);
            case "jetplane":
                return new JetPlane(id, p_name, p_coordinates);
            default:
                throw new IllegalArgumentException("Unknown aircraft type: " + p_type);
        }
    }

}
//HER AİRCRAFT FARKLI ID YE SAHİP OLMALI