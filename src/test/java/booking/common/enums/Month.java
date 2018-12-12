package booking.common.enums;

public enum Month {

    JANUARY("January",0),
    FEBRUARY("February",1),
    MARCH("March",2),
    APRIL("April",3),
    MAY("May",4),
    JUNE("June",5),
    JULY("July",6),
    AUGUST("August",7),
    SEPTEMBER("September",8),
    OCTOBER("October",9),
    NOVEMBER("November",10),
    DECEMBER("December",11);

    private String month;
    private int index;

    Month(String month, int index) {
        this.month = month;
        this.index = index;
    }

    public String getMonth() {
        return month;
    }
    public int getIndex() {
        return index;
    }
}