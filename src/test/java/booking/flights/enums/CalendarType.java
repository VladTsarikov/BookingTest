package booking.flights.enums;

public enum CalendarType {

    CHECK_IN(2),
    CHECK_OUT(3);

    private int index;

    CalendarType(int index){
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
}