package royal_air_services;

public class Coordinates {
    
    private int longitude;
    private int latitude;
    private int height;

    // for the Coordinates() method, i'm not yet clear how to handle "~", so i'm gonna leave like it is and hope the default access modifier rules apply.
    Coordinates(int longitude, int latitude, int height) {
        // longitude, latitude and height can never be less than zero, so:
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
        return this.longitude;
    }

    public int getLatitude() {

        return this.latitude;
    }

    public int getHeight() {

        return this.height;
    }
}