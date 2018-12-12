package booking.accommodation.enums;

public enum PriceFilterIndex {

    FIRST_FILTER("1"),
    SECOND_FILTER("2");

    private String itemName;

    PriceFilterIndex(String itemName) {
        this.itemName = itemName;
    }

    public String getIndex() {
        return new StringBuilder("pri-").append(itemName).toString();
    }
}