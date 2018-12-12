package booking.flights.enums;

public enum Direction {

    ORIGIN("origin"),
    DESTINATION("destination"),
    FIRST_ORIGIN("origin0"),
    FIRST_DESTINATION("destination0"),
    NEXT_OIGIN("origin1"),
    NEXT_DESTINATION("destination1"),
    LAST_OIGIN("origin2"),
    LAST_DESTINATION("destination2");

    private String direction;

    Direction(String direction) {
        this.direction = direction;
    }

    public String getValue() {
        return direction;
    }
}