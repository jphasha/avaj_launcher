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

        if (height > 0) {
            if (height > 100) {
                this.height = 100;
            } else {
                this.height = height;
            }
        } else {
            this.height = 0;
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

    public static Coordinates getCoordinates(int longitude, int latitude, int height) {
        return new Coordinates(longitude, latitude, height);
    }
}