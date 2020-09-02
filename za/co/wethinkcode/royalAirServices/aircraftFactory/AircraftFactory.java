package za.co.wethinkcode.royalAirServices.aircraftFactory;

import za.co.wethinkcode.royalAirServices.aircraftFactory.aircrafts.Baloon;
import za.co.wethinkcode.royalAirServices.aircraftFactory.aircrafts.Helicopter;
import za.co.wethinkcode.royalAirServices.aircraftFactory.aircrafts.JetPlane;
import za.co.wethinkcode.royalAirServices.interfaces.Flyable;

public abstract class AircraftFactory {
    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {
        Coordinates coordinates = new Coordinates(longitude, latitude, height);
        String aircraftType = type.toLowerCase();
        if (aircraftType.equalsIgnoreCase("helicopter")) {
            Helicopter helicopter = Helicopter.generateHelicopter(name, coordinates);
            return helicopter;
        } else if (aircraftType.equalsIgnoreCase("jetPlane")) {
            JetPlane jetPlane = JetPlane.generateJetPlane(name, coordinates);
            return jetPlane;
        } else if (aircraftType.equalsIgnoreCase("baloon")) {
            Baloon baloon = Baloon.generateBaloon(name, coordinates);
            return baloon;
        }
        return null;
    }
}