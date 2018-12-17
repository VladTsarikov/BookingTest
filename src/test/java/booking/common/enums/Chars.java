package booking.common.enums;

public enum Chars {

    HYPHEN("-"),
    COMMA(","),
    EMPTY_STRING(""),
    COLON(":");

    private String character;

    Chars(String character) {
        this.character = character;
    }

    public String getCharacter() {
        return character;
    }
}