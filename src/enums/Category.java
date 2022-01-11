package enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Category {

    @JsonProperty("Board Games")
    BOARD_GAMES("Board Games"),

    @JsonProperty("Books")
    BOOKS("Books"),

    @JsonProperty("Clothes")
    CLOTHES("Clothes"),

    @JsonProperty("Sweets")
    SWEETS("Sweets"),

    @JsonProperty("Technology")
    TECHNOLOGY("Technology"),

    @JsonProperty("Toys")
    TOYS("Toys");

    private final String value;

    Category(final String value) {
        this.value = value;
    }

    /**
     * In functie de sirul de caractere primit ca parametru aceasta
     * metoda intoarce categoria corespunzatoare respectivului String
     *
     * @param category Sirul de caractere pentru care trebuie identificata categoria
     * @return Se returneaza categoria corespunzatoare sau IllegalArgumentException in cazul
     * in care sirul nu poate fi identificat ca apartinand unei categorii.
     */
    public static Category findCategory(final String category) {
        switch (category) {
            case "Board Games" -> {
                return BOARD_GAMES;
            }
            case "Books" -> {
                return BOOKS;
            }
            case "Clothes" -> {
                return CLOTHES;
            }
            case "Sweets" -> {
                return SWEETS;
            }
            case "Technology" -> {
                return TECHNOLOGY;
            }
            case "Toys" -> {
                return TOYS;
            }
            default -> {
                throw new IllegalArgumentException("Category" + category
                        + "is not recognized!");
            }
        }
    }

}
