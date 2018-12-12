package booking.flights.enums;

public enum TimeNumber {

    FIRST_TIME("0"),
    NEXT_TIME("1"),
    LAST_TIME("2");

    private String number;

    TimeNumber(String number) {
        this.number = number;
    }

    public String getValue() {
        return number;
    }
}