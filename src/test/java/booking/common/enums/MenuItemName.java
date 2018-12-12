package booking.common.enums;

public enum MenuItemName {

    ACCOMMODATION("accommodation"),
    FLIGHTS("flights"),
    CAR_RENTALS("cars"),
    AIRPORT_TAXIS("airport_taxis");

    private String itemName;

    MenuItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getName() {
        return itemName;
    }
}