package za.co.wethinkcode.royalAirServices.aircraftFactory.aircrafts;

import za.co.wethinkcode.royalAirServices.aircraftFactory.Aircraft;
import za.co.wethinkcode.royalAirServices.aircraftFactory.Coordinates;
import za.co.wethinkcode.royalAirServices.interfaces.Flyable;
import za.co.wethinkcode.royalAirServices.tower.weather.WeatherTower;

public class JetPlane extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    public JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        String weatherConditions = this.weatherTower.getWeather(coordinates);
        if (weatherConditions == "SUN") {
            this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude() + 10, this.coordinates.getHeight() + 2);
        } else if (weatherConditions == "RAIN") {
            this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude() + 5, this.coordinates.getHeight());
        } else if (weatherConditions == "FOG") {
            this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude() + 1, this.coordinates.getHeight());
        } else if (weatherConditions == "SNOW") {
            this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 7);
        }
    }

    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        System.out.println("Registration successful");
    }
}