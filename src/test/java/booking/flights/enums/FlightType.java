package booking.flights.enums;

public enum FlightType {

    ROUND_TRIP("roundtrip"),
    MULTI_CITY("multicity"),
    ONE_WAY("oneway");

    private String name;

    FlightType(String name) {
        this.name = name;
    }

    public String getValue() {
        return name;
    }
}