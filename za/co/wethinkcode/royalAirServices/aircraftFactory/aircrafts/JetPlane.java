package za.co.wethinkcode.royalAirServices.aircraftFactory.aircrafts;

import za.co.wethinkcode.royalAirServices.aircraftFactory.Aircraft;
import za.co.wethinkcode.royalAirServices.aircraftFactory.Coordinates;
import za.co.wethinkcode.royalAirServices.interfaces.Flyable;
import za.co.wethinkcode.royalAirServices.logBook.LogBook;
import za.co.wethinkcode.royalAirServices.tower.weather.WeatherTower;

public class JetPlane extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        String weatherConditions = this.weatherTower.getWeather(coordinates);
        if (weatherConditions == "SUN") {
            this.coordinates = Coordinates.getCoordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude() + 10, this.coordinates.getHeight() + 2);
            LogBook.logs.add(String.format("JetPlane#%s(%d): A clear sky, we will reach our destination much faster.", name, id));
        } else if (weatherConditions == "RAIN") {
            this.coordinates = Coordinates.getCoordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude() + 5, this.coordinates.getHeight());
            LogBook.logs.add(String.format("JetPlane#%s(%d): Not ideal, but atleast there should be no overheating problems.", name, id));
        } else if (weatherConditions == "FOG") {
            this.coordinates = Coordinates.getCoordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude() + 1, this.coordinates.getHeight());
            LogBook.logs.add(String.format("JetPlane#%s(%d): Yay FOG!, it is not like i wanted to see the sky anyway.", name, id));
        } else if (weatherConditions == "SNOW") {
            this.coordinates = Coordinates.getCoordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 7);
            if (this.coordinates.getHeight() < 1) {
                LogBook.logs.add(String.format("JetPlane#%s(%d): Landing at Latitude:%d, Longitude:%d. Who flies in the snow anyways?", name, id, this.coordinates.getLatitude(), this.coordinates.getLongitude()));
                LogBook.logs.add(String.format("Tower says: JetPlane#%s(%d) unregisters from weather tower.", name, id));
                weatherTower.unregister(this);
            } else {
                LogBook.logs.add(String.format("JetPlane#%s(%d): Okay, i will bear this for a few moments, if this persists, we gonna have to land", name, id));
            }
        }
    }

    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        LogBook.logs.add(String.format("Tower says: JetPlane#%s(%d) registered to weather tower", name, id));
    }

    public static JetPlane generateJetPlane(String name, Coordinates coordinates) {
        return new JetPlane(name, coordinates);
    }
}