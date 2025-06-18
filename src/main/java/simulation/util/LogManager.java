package src.main.java.simulation.util;

public class LogManager {

    public static final String DEFAULT_SUN_MESSAGE = "Lanet olsun çok sıcak!!";
    public static final String DEFAULT_RAIN_MESSAGE = "Yağmur yağıyor, yükseklik düşmeli.";
    public static final String DEFAULT_FOG_MESSAGE = "Sis var, karşıdaki bir ejderya mı ?!.";
    public static final String DEFAULT_SNOW_MESSAGE = "Kar yağıyor, Susamıştım bu iyi oldu.";  

    public static void changeWeatherMessage(
        String TYPE,
        String NAME,
        long ID,
        String MESSAGE)
    {
        System.out.println(
            TYPE + "#" + NAME + "(" + ID + ")" + ": " + MESSAGE);
    }

    public static void changeWeatherMessage(
        String WEATHER,
        String TYPE,
        String NAME,
        long ID)
    {
        switch (WEATHER) 
        {
            case "SUN":
            LogManager.changeWeatherMessage(TYPE, NAME, ID, LogManager.DEFAULT_SUN_MESSAGE);
                break;
            case "RAIN":
            LogManager.changeWeatherMessage(TYPE, NAME, ID, LogManager.DEFAULT_RAIN_MESSAGE);
                break;
            case "FOG":
            LogManager.changeWeatherMessage(TYPE, NAME, ID, LogManager.DEFAULT_FOG_MESSAGE);
                break;
            case "SNOW":
            LogManager.changeWeatherMessage(TYPE, NAME, ID, LogManager.DEFAULT_SNOW_MESSAGE);
                break;
            default:
                throw new AssertionError();
        }
    }

    public static void logLanding(
        String TYPE,
        String NAME,
        long ID)
    {
        System.out.println(TYPE + "#" + NAME + "(" + ID + ")" + " landing.");
    }

    public static void towerLog(
        String TYPE,
        String NAME,
        long ID,
        String MESSAGE)
    {
        System.out.println("Tower says: " + TYPE + "#" + NAME + "(" + ID + ")" + MESSAGE);
    }

    public static void towerRegisterLog(
        String TYPE,
        String NAME,
        long ID)
    {
        LogManager.towerLog(TYPE, NAME, ID, " registered to weather tower.");
    }

    public static void towerUnregisterLog(
        String TYPE,
        String NAME,
        long ID)
    {
        LogManager.towerLog(TYPE, NAME, ID, " unregistered from weather tower.");
    }
    


}
