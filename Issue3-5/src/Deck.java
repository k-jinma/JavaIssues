import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Card> deck;

    public Deck() {
        setDeck();
        shuffle();
    }

    private void setDeck() {
        deck = new ArrayList<>();
        String[] suits = {Card.SPADE, Card.HEART, Card.CLUB, Card.DIAMOND};
        for (String suit : suits) {
            for (int i = 1; i <= 13; i++) {
                deck.add(new Card(suit, i));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(deck);
    }

    public Card draw() {
        return deck.remove(0);
    }
}
