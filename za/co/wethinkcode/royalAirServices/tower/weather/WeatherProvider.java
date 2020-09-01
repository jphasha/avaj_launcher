package za.co.wethinkcode.royalAirServices.tower.weather;

import za.co.wethinkcode.royalAirServices.aircraftFactory.Coordinates;

public class WeatherProvider {
    private static WeatherProvider weatherProvider = new WeatherProvider();
    private static String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};

    private WeatherProvider() {}

    public static WeatherProvider getProvider() {
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        int coordinateSum = coordinates.getHeight() + coordinates.getLatitude() + coordinates.getLongitude();
        int weatherIndex = coordinateSum % 4;
        String weatherConditions = null;

        weatherConditions = weather[weatherIndex];
        return weatherConditions;
    }
}