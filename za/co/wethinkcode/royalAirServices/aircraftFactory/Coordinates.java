package za.co.wethinkcode.royalAirServices.aircraftFactory;

public class Coordinates {
    private int longitude, latitude, height;

    Coordinates(int longitude, int latitude, int height) {
        if (longitude < 0) {
            this.longitude = 0;
        } else {
            this.longitude = longitude;
        }

        if (latitude < 0) {
            this.latitude = 0;
        } else {
            this.latitude = latitude;
        }

        if (height < 0) {
            this.height = 0;
        } else {
            this.height = height;
        }
    }

    public int getLongitude() {
        return longitude;
    }

    public int getLatitude() {
        return latitude;
    }

    public int getHeight() {
        return height;
    }
}