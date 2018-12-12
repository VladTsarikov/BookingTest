package booking.accommodation.enums;

public enum UserMenuItemName {

    CURRENCY("currency"),
    LANGUAGE("popover");

    private String itemName;

    UserMenuItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getName() {
        return itemName;
    }
}