package booking.flights.enums;

public enum Chars {

    HYPHEN("-"),
    COLON(":");

    private String character;

    Chars(String character) {
        this.character = character;
    }

    public String getCharacter() {
        return character;
    }
}