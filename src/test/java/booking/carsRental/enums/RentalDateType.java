package booking.carsRental.enums;

public enum RentalDateType {

    PICK_UP("pu"),
    DROP_OFF("do");

    private String shortName;

    RentalDateType(String shortName) {
        this.shortName = shortName;
    }

    public String getShortName() {
        return shortName;
    }
}