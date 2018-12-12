package booking.flights.enums;

public enum DateType {

    DEPART("depart"),
    RETURN("return"),
    FIRST_DEPART("departDate0"),
    FIRST_RETURN("returnDate0"),
    NEXT_DEPART("departDate1"),
    NEXT_RETURN("returnDate1"),
    LAST_DEPART("departDate2"),
    LAST_RETURN("returnDate2");

    private String date;

    DateType(String date) {
        this.date = date;
    }

    public String getValue() {
        return date;
    }
}