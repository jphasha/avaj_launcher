package royal_air_services.weather;

import royal_air_services.Coordinates;

public class    WeatherProvider {

    private static WeatherProvider weatherProvider;
    private static string[] weather = {"RAIN", "FOG", "SUN", "SNOW"};

    private WeatherProvider() {
//        a constructor so i can't ignore it.
        return ;
    }

    public static WeatherProvider getProvider() {
        // get the WeatherProvider instance.
        weatherProvider = new WeatherProvider();
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        // we will give content later when i have a better understanding of what i am doing.
    }
}