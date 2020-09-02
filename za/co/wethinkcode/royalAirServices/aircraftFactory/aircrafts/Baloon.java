package za.co.wethinkcode.royalAirServices.aircraftFactory.aircrafts;

import za.co.wethinkcode.royalAirServices.aircraftFactory.Aircraft;
import za.co.wethinkcode.royalAirServices.aircraftFactory.Coordinates;
import za.co.wethinkcode.royalAirServices.interfaces.Flyable;
import za.co.wethinkcode.royalAirServices.logBook.LogBook;
import za.co.wethinkcode.royalAirServices.tower.weather.WeatherTower;

public class Baloon extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        String weatherConditions = this.weatherTower.getWeather(coordinates);
        if (weatherConditions == "SUN") {
            this.coordinates = Coordinates.getCoordinates(this.coordinates.getLongitude() + 2, this.coordinates.getLatitude(), this.coordinates.getHeight() + 4);
            LogBook.logs.add(String.format("Baloon#%s(%d): man it is hot!", name, id));
        } else if (weatherConditions == "RAIN") {
            this.coordinates = Coordinates.getCoordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 5);
            if (coordinates.getHeight() < 1) {
                LogBook.logs.add(String.format("Baloon#%s(%d): The rain extinguished that little ember we had left. We gonna crash land at Latitude:%d, Longitude:%d.", name, id, coordinates.getLatitude(), coordinates.getLongitude()));
                LogBook.logs.add(String.format("Tower says: Baloon#%s(%d) unregistered from weather tower.", name, id));
                weatherTower.unregister(this);
            } else {
                LogBook.logs.add(String.format("Baloon#%s(%d): rain is getting in my eyes.", name, id));
            }
        } else if (weatherConditions == "FOG") {
            this.coordinates = Coordinates.getCoordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 3);
            if (coordinates.getHeight() < 1) {
                LogBook.logs.add(String.format("Baloon#%s(%d): The fog suffocated my fire. We gonna crash land at Latitude:%d, Longitude:%d.", name, id, coordinates.getLatitude(), coordinates.getLongitude()));
                LogBook.logs.add(String.format("Tower says: Baloon#%s(%d) unregistered from weather tower.", name, id));
                weatherTower.unregister(this);
            } else {
                LogBook.logs.add(String.format("Baloon#%s(%d): Man I can't see shit in this fog.", name, id));
            }
        } else if (weatherConditions == "SNOW") {
            this.coordinates = Coordinates.getCoordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 15);
            if (coordinates.getHeight() < 1) {
                LogBook.logs.add(String.format("Baloon#%s(%d): The snow has frozen our fuel. We gonna crash land at Latitude:%d, Longitude:%d.", name, id, coordinates.getLatitude(), coordinates.getLongitude()));
                LogBook.logs.add(String.format("Tower says: Baloon#%s(%d) unregistered from weather tower.", name, id));
                weatherTower.unregister(this);
            } else {
                LogBook.logs.add(String.format("Baloon#%s(%d): This is a bad time to be balooning. the snow freezing even the fire.", name, id));
            }
        }
    }

    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        LogBook.logs.add(String.format("Tower says: Baloon#%s(%d) registered to weather tower", name, id));
    }

    public static Baloon generateBaloon(String name, Coordinates coordinates) {
        return new Baloon(name, coordinates);
    }
}