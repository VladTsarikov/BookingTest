package booking.common.entities;

public class Date {

    private int year;
    private int monthIndex;
    private int day;
    private String time;

    public Date(int year, int monthIndex, int day, String time) {
        this.year = year;
        this.monthIndex = monthIndex;
        this.day = day;
        this.time = time;
    }

    public Date(int year, int monthIndex, int day) {
        this.year = year;
        this.monthIndex = monthIndex;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public int getMonthIndex() {
        return monthIndex;
    }

    public int getDay() {
        return day;
    }

    public String getTime() {
        return time;
    }
}