package booking.common.enums;

public enum RegExp {

    MONTH("([A-Z]+[a-z]*)"),
    YEAR("([0-9]{4})"),
    HOUR("^(\\d{1,})"),
    MINUTES(".([0-9]{1,})"),
    TIME_FOR_SELECT("(^[0-9]{1,2})"),
    RENTAL_CAR_PRICE("([0-9]{1,}.?[0-9]{1,})"),
    ACCOMMODATION_PRICE(":\\s\\w{1,}\\s([0-9]{1,},?[0-9]{0,})"),
    ACCOMMODATION_COUNT("([0-9]{1,},?[0-9]{0,})");

    private String regularExpression;

    RegExp(String regularExpression) {
        this.regularExpression = regularExpression;
    }

    public String getRegExp() {
        return regularExpression;
    }
}