package za.co.wethinkcode.royalAirServices.interfaces;

import za.co.wethinkcode.royalAirServices.tower.weather.WeatherTower;

public interface Flyable {
    public void updateConditions();
    public void registerTower(WeatherTower weatherTower);
}