package booking.accommodation.enums;

public enum AccommodationSortType {

    SCORE_AND_PRICE("score_and_price"),
    PRICE("price");

    private String type;

    AccommodationSortType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}