package com.tms.TZ;

public class City {
    int id;
    String name;
    double longitude;
    double latitude;
    boolean airportAvailability;
    boolean availabilityOfASeaport;

    public City(int id, String name, double longitude, double latitude, boolean airportAvailability, boolean availabilityOfASeaport) {
        this.id = id;
        this.name = name;
        this.longitude = longitude;
        this.latitude = latitude;
        this.airportAvailability = airportAvailability;
        this.availabilityOfASeaport = availabilityOfASeaport;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public boolean isAirportAvailability() {
        return airportAvailability;
    }

    public void setAirportAvailability(boolean airportAvailability) {
        this.airportAvailability = airportAvailability;
    }

    public boolean isAvailabilityOfASeaport() {
        return availabilityOfASeaport;
    }

    public void setAvailabilityOfASeaport(boolean availabilityOfASeaport) {
        this.availabilityOfASeaport = availabilityOfASeaport;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", airportAvailability=" + airportAvailability +
                ", availabilityOfASeaport=" + availabilityOfASeaport +
                '}';
    }
}
