package booking.carsRental.enums;

public enum RentalMenuItemName {

    CURRENCY("currency"),
    LANGUAGE("language");

    private String itemName;

    RentalMenuItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getName() {
        return itemName;
    }
}