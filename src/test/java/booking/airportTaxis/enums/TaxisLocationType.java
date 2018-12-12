package booking.airportTaxis.enums;

public enum TaxisLocationType {

    PICK_UP("pickup"),
    DROP_OFF("dropoff");

    private String name;

    TaxisLocationType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}