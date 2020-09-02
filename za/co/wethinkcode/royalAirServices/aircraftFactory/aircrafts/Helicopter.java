package za.co.wethinkcode.royalAirServices.aircraftFactory.aircrafts;

import za.co.wethinkcode.royalAirServices.aircraftFactory.Aircraft;
import za.co.wethinkcode.royalAirServices.aircraftFactory.Coordinates;
import za.co.wethinkcode.royalAirServices.interfaces.Flyable;
import za.co.wethinkcode.royalAirServices.logBook.LogBook;
import za.co.wethinkcode.royalAirServices.tower.weather.WeatherTower;

public class Helicopter extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        String weatherConditions = this.weatherTower.getWeather(coordinates);
        if (weatherConditions == "SUN") {
            this.coordinates = Coordinates.getCoordinates(this.coordinates.getLongitude() + 10, this.coordinates.getLatitude(), this.coordinates.getHeight() + 2);
            LogBook.logs.add(String.format("Helicopter#%s(%d): nothing like the SUN for that warmth and a killer view.", name, id));
        } else if (weatherConditions == "RAIN") {
            this.coordinates = Coordinates.getCoordinates(this.coordinates.getLongitude() + 5, this.coordinates.getLatitude(), this.coordinates.getHeight());
            LogBook.logs.add(String.format("Helicopter#%s(%d): It is just a little RAIN, we are not afraid to get a little wet, are we?", name, id));
        } else if (weatherConditions == "FOG") {
            this.coordinates = Coordinates.getCoordinates(this.coordinates.getLongitude() + 1, this.coordinates.getLatitude(), this.coordinates.getHeight());
            LogBook.logs.add(String.format("Helicopter#%s(%d): Damn, let's hope I do not run into a mountain or something.", name, id));
        } else if (weatherConditions == "SNOW") {
            this.coordinates = Coordinates.getCoordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 12);
            if (coordinates.getHeight() < 1) {
                LogBook.logs.add(String.format("Helicopter#%s(%d): Okay folks, That SNOW done did it for us. We will be crashlanding at longitude: %d, latitude: %d.", name, id, this.coordinates.getLongitude(), this.coordinates.getLatitude()));
                LogBook.logs.add(String.format("Tower says: Helicopter#%s(%d) unregisters from weather tower.", name, id));
                weatherTower.unregister(this);
            } else {
                LogBook.logs.add(String.format("Helicopter#%s(%d): The rotor has slowed down. We need better weather conditions, otherwise we are done for.", name, id));
            }
        }
    }

    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        LogBook.logs.add(String.format("Tower says: Helicopter#%s(%d) registered to weather tower", name, id));
    }

    public static Helicopter generateHelicopter(String name, Coordinates coordinates) {
        return new Helicopter(name, coordinates);
    }
}