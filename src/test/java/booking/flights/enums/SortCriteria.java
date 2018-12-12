package booking.flights.enums;

public enum SortCriteria {

    CHEAPEST(0),
    RECOMMENDED(1),
    QUICKEST(2);

    private int number;

    SortCriteria(int number) {
        this.number = number;
    }

    public int getValue() {
        return number;
    }
}