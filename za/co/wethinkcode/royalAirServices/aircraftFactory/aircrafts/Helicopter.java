package za.co.wethinkcode.royalAirServices.aircraftFactory.aircrafts;

import za.co.wethinkcode.royalAirServices.aircraftFactory.Aircraft;
import za.co.wethinkcode.royalAirServices.aircraftFactory.Coordinates;
import za.co.wethinkcode.royalAirServices.interfaces.Flyable;
import za.co.wethinkcode.royalAirServices.tower.weather.WeatherTower;

public class Helicopter extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    public Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {}
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
    }
}