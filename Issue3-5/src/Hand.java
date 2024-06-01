import java.util.ArrayList;
import java.util.List;

public class Hand {
    private List<Card> hand = new ArrayList<>();
    private String role;

    public void addCard(int index, Card card) {
        if (hand.size() > index) {
            hand.set(index, card);
        } else {
            hand.add(card);
        }
    }

    public void discardCard(int index) {
        hand.set(index, null);
    }

    public boolean[] notRoleIndex() {
        // 仮実装、実際の役判定ロジックを実装する必要があります
        return new boolean[]{true, true, true, true, true};
    }

    public String getRole() {
        // 仮実装、実際の役判定ロジックを実装する必要があります
        return "ハイカード";
    }

    public int getRoleRank() {
        // 仮実装、役のランクを返すロジックを実装する必要があります
        return 1;
    }

    @Override
    public String toString() {
        return hand.toString();
    }
}
