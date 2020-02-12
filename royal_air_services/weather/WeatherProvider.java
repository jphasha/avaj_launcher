package royal_air_services.weather;

import royal_air_services.Coordinates;

public class    WeatherProvider {

    private static WeatherProvider weatherProvider;
    private static string[] weather = {"RAIN", "FOG", "SUN", "SNOW"};

    private WeatherProvider() {
        // we will talk.
    }

    public static WeatherProvider getProvider() {}
}