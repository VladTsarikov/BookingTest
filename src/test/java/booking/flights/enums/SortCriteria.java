package booking.flights.enums;

public enum SortCriteria {

    CHEAPEST(1),
    RECOMMENDED(2),
    QUICKEST(3);

    private int number;

    SortCriteria(int number) {
        this.number = number;
    }

    public int getValue() {
        return number;
    }
}