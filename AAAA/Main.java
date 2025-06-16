class Main {

    /*
     * Baloon B1 2 3 20
Baloon B2 1 8 66
JetPlane J1 23 44 32
Helicopter H1 654 33 20
Helicopter H2 22 33 44
Helicopter H3 98 68 99
Baloon B3 102 22 34
JetPlane J2 11 99 768
Helicopter H4 223 23 54
     */
    public static void main(String[] args) {
        Flyable[] flyables = new Flyable[10];
        AircraftFactory factory = AircraftFactory.getInstance();
        WeatherTower weatherTower = new WeatherTower();
        

        flyables[0] = factory.newAircraft("Baloon", "B1", new Coordinates(2, 3, 20));
        flyables[1] = factory.newAircraft("Baloon", "B2", new Coordinates(1, 8, 66));
        flyables[2] = factory.newAircraft("JetPlane", "J1", new Coordinates(23, 44, 32));
        flyables[3] = factory.newAircraft("Helicopter", "H1", new Coordinates(654, 33, 20));
        flyables[4] = factory.newAircraft("Helicopter", "H2", new Coordinates(22, 33, 44));
        flyables[5] = factory.newAircraft("Helicopter", "H3", new Coordinates(98, 68, 99));
        flyables[6] = factory.newAircraft("Baloon", "B3", new Coordinates(102, 22, 34));
        flyables[7] = factory.newAircraft("JetPlane", "J2", new Coordinates(11, 99, 768));
        flyables[8] = factory.newAircraft("Helicopter", "H4", new Coordinates(223, 23, 54));

        weatherTower.register(flyables[0]);
        weatherTower.register(flyables[1]);
        weatherTower.register(flyables[2]);
        weatherTower.register(flyables[3]);
        weatherTower.register(flyables[4]);
        weatherTower.register(flyables[5]);
        weatherTower.register(flyables[6]);
        weatherTower.register(flyables[7]);
        weatherTower.register(flyables[8]);
        flyables[0].registerTower(weatherTower);
        flyables[1].registerTower(weatherTower);
        flyables[2].registerTower(weatherTower);
        flyables[3].registerTower(weatherTower);
        flyables[4].registerTower(weatherTower);
        flyables[5].registerTower(weatherTower);
        flyables[6].registerTower(weatherTower);
        flyables[7].registerTower(weatherTower);
        flyables[8].registerTower(weatherTower);

        for (int i = 0; i < 25; i++)
        {
            for (Flyable flyable : flyables)
            {
                weatherTower.changeWeather();
                flyable.updateConditions();
            }
        }
    }
}