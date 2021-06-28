package com.tms.TZ;

import javax.script.ScriptContext;
import java.util.*;
import java.util.stream.Collectors;

public class Test {

    List<Transport> transportCollection = Arrays.asList(
            new Transport(234567, "Boeing-737", 943, 130, 10, new AirType("Passenger plane"), 5),
            new Transport(234567, "Boeing-737", 945, 130, 10, new AirType("Passenger plane"), 5),

            new Transport(234564, "Руслан", 860, 5, 120, new AirType("Cargo plane"), 50),
            new Transport(123567, "AirBus A330", 900, 350, 15, new AirType("Cargo plane"), 20),
            new Transport(999567, "High Cube", 100, 5, 200, new MarineType("Cargo container ship"), 12),
            new Transport(234567, "Action F", 80, 10, 300, new MarineType("Cargo container ship"), 15),
            new Transport(234567, "Titanic", 70, 2000, 6, new MarineType("Passenger ship"), 10),
            new Transport(234567, "Man", 90, 2, 10, new GroundType("Cargo truck"), 1),
            new Transport(234567, "Mercedes", 90, 20, 1, new GroundType("Passenger minibus"), 1),
            new Transport(234567, "Tatra", 90, 30, 1, new GroundType("Passenger minibus"), 1)
    );
    List<City> cityCollection = Arrays.asList(
            new City(3784623, "Moscow", 37.61556, 55.7522, true, false),
            new City(1284623, "Berlin", 13.4105300, 52.5243700, true, false),
            new City(9084623, "London", -0.12574, 51.5085, true, false),
            new City(3424623, "Nacodka", 132.873, 42.8138, false, true),
            new City(454623, "Vladivastok", 131.88692, 43.11981, false, true),
            new City(9284623, "New York", -74.00594, 40.71424, true, true),
            new City(344623, "Tokyo", 139.69171, 35.6895, true, true),
            new City(1114623, "Los Angeles", 118.224, 34.0522, true, true)
    );


    public int distanceCalculate(String cityFrom, String cityWhereTo) {
        List<City> city = cityCollection.stream().filter(n -> n.getName().contains(cityFrom)).collect(Collectors.toList());
        List<City> city2 = cityCollection.stream().filter(n -> n.getName().contains(cityWhereTo)).collect(Collectors.toList());
        double d;
        int distance;
        double latitudeFrom = city.get(0).getLatitude();
        double latitudeWhereTo = city2.get(0).getLatitude();
        double longitudeFrom = city.get(0).getLongitude();
        double longitudeWhereTo = city2.get(0).getLongitude();
        int earthRadius = 6371;
        double latFrom = latitudeFrom * Math.PI / 180;
        double latWhereTo = latitudeWhereTo * Math.PI / 180;
        double longFrom = longitudeFrom * Math.PI / 180;
        double longWhereTo = longitudeWhereTo * Math.PI / 180;
        d = Math.acos(Math.sin(latFrom) * Math.sin(latWhereTo) + Math.cos(latFrom) * Math.cos(latWhereTo) * Math.cos(longFrom - longWhereTo));
        distance = (int) (d * earthRadius);
        return distance;
    }

    public int calculationOfDeliveryTimeInHours(int speed, int distance) {
        int rez = distance / speed;
        return rez;
    }

    public int calculationOfDeliveryTimeInMinutes(int speed, int distance) {
        int rez = distance / speed;
        double rez2 = distance / speed;
        int rez3 = (int) ((rez2 - rez) * 60);
        return rez3;
    }

    private List<Transport> sortingTransportBySuitable(int numberOfPassengers, int weightOfCargo) {
        List<Transport> passengerTransport = transportCollection.stream()
                .filter(n -> n.getNumberOfAccommodatedPeople() >= numberOfPassengers && n.getNumberOfAccommodatedCargo() >= weightOfCargo)
                .filter(n -> n.getTypeOfTransport().toString().contains("Passenger"))
                .collect(Collectors.toList());
        if (numberOfPassengers < 11 && weightOfCargo > 10) {
            List<Transport> cargoTransports = transportCollection.stream()
                    .filter(n -> n.getNumberOfAccommodatedPeople() >= numberOfPassengers && n.getNumberOfAccommodatedCargo() >= weightOfCargo)
                    .filter(n -> n.getTypeOfTransport().toString().contains("Cargo"))
                    .collect(Collectors.toList());
            return cargoTransports;
        } else {
            return passengerTransport;
        }

    }


    private List<Transport> vehiclesBySuitableCategory(String cityFrom, String cityWhereTo, int numberOfPassengers, int weightOfCargo) {
        List<City> cityFr = cityCollection.stream().filter(n -> n.getName().contains(cityFrom)).collect(Collectors.toList());
        List<City> cityWhere = cityCollection.stream().filter(n -> n.getName().contains(cityWhereTo)).collect(Collectors.toList());
        boolean availabilityOfAirportsInTheCityFromWhere = cityFr.get(0).isAirportAvailability();
        boolean availabilityOfAirportsInTheCityWhere = cityWhere.get(0).isAirportAvailability();
        boolean thePresenceOfSeaportsInTheCityFromWhere = cityFr.get(0).isAvailabilityOfASeaport();
        boolean thePresenceOfSeaportsInTheCityWhere = cityWhere.get(0).isAvailabilityOfASeaport();

        if (availabilityOfAirportsInTheCityFromWhere == true && availabilityOfAirportsInTheCityWhere == true) {
            List<Transport> aitTypeTransportCollection = sortingTransportBySuitable(numberOfPassengers, weightOfCargo)
                    .stream().filter(n -> n.getTypeOfTransport().toString().contains("Air")).collect(Collectors.toList());
            return aitTypeTransportCollection;
        } else if (thePresenceOfSeaportsInTheCityFromWhere == true && thePresenceOfSeaportsInTheCityWhere == true) {
            List<Transport> marineTypeTransportCollection = sortingTransportBySuitable(numberOfPassengers, weightOfCargo)
                    .stream().filter(n -> n.getTypeOfTransport().toString().contains("Marine")).collect(Collectors.toList());
            return marineTypeTransportCollection;
        } else {
            List<Transport> groundTypeTransportCollection = sortingTransportBySuitable(numberOfPassengers, weightOfCargo)
                    .stream().filter(n -> n.getTypeOfTransport().toString().contains("Ground")).collect(Collectors.toList());
            return groundTypeTransportCollection;
        }
    }

    public List<Transport> bestTypeTransport( String cityFrom, String cityWhereTo, int numberOfPassengers, int weightOfCargo) {
        List<Double> collection = new ArrayList<>();
        for (Transport item : vehiclesBySuitableCategory(cityFrom, cityWhereTo, numberOfPassengers, weightOfCargo)) {
            double rez = item.getSpeed() / 3.6 - item.getPricePerKilometer() / 2.52;
            collection.add(rez);
        }
        Double i2 = Collections.max(collection);
        List<Transport> idealTransport = transportCollection.stream().filter((n) -> n.getSpeed() / 3.6 - n.getPricePerKilometer() / 2.52 == i2).collect(Collectors.toList());

      return idealTransport;
    }


}
