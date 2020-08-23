package za.co.wethinkcode.royalAirServices.tower.weather;

import za.co.wethinkcode.royalAirServices.aircraftFactory.Coordinates;
import za.co.wethinkcode.royalAirServices.tower.Tower;

public class WeatherTower extends Tower {
    public String getWeather(Coordinates coordinates) {
        WeatherProvider weather = WeatherProvider.getProvider();
        return weather.getCurrentWeather(coordinates);
    }
    public void changeWeather() {
        conditionsChanged();
    };
}