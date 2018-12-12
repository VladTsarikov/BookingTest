package booking.common.enums;

public enum HeaderMenuItem {

    CURRENCY("Currency"),
    COUNTRY("Country");

    private String name;

    HeaderMenuItem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}