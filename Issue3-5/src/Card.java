public class Card {
    public static final String SPADE = "♠";
    public static final String HEART = "♥";
    public static final String CLUB = "♣";
    public static final String DIAMOND = "♦";

    private String suit;
    private int number;

    public Card(String suit, int number) {
        this.suit = suit;
        this.number = number;
    }

    public String getSuit() {
        return suit;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return suit + number;
    }
}
