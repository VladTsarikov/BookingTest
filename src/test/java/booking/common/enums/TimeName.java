package booking.common.enums;

public enum TimeName {

    DAY("Day"),
    MONTH("Month"),
    HOUR("Hour"),
    MINUTE("Minute");

    private String name;

    TimeName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}