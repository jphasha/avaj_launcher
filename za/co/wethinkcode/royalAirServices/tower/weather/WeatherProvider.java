package za.co.wethinkcode.royalAirServices.tower.weather;

import za.co.wethinkcode.royalAirServices.aircraftFactory.Coordinates;

public class WeatherProvider {
    private static WeatherProvider weatherProvider = new WeatherProvider();
    private static String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};

    public WeatherProvider() {}

    public static WeatherProvider getProvider() {
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        int heightWeatherCoordinate = coordinates.getHeight() % 4;
        int latiWeatherCoordinate = (1 + coordinates.getLatitude()) % 4;
        int longiWeatherCoordinate = (2 + coordinates.getLongitude()) % 4;
        String weatherConditions = null;

        if ((heightWeatherCoordinate == latiWeatherCoordinate) || (heightWeatherCoordinate == longiWeatherCoordinate)) {
            weatherConditions = weather[heightWeatherCoordinate];
        } else if ((latiWeatherCoordinate == longiWeatherCoordinate)) {
            weatherConditions = weather[latiWeatherCoordinate];
        } else {
            for(int i = 0; i < 4; i++) {
                if ((i != heightWeatherCoordinate) && (i != latiWeatherCoordinate) && (i != longiWeatherCoordinate)) {
                    weatherConditions = weather[i];
                }
            }
        }
        return weatherConditions;
    }
}