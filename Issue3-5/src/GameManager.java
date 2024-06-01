import java.util.Scanner;

public class GameManager {
    private Deck deck;
    private Hand playerHand;
    private Hand enemyHand;
    private Scanner scanner;

    public GameManager() {
        deck = new Deck();
        playerHand = new Hand();
        enemyHand = new Hand();
        scanner = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            playerHand.addCard(i, deck.draw());
            enemyHand.addCard(i, deck.draw());
        }
    }

    public void play() {
        System.out.println("現在の手札: " + playerHand);
        System.out.println("どのカードを捨てますか？捨てるカード番号を入力してください (例: 123)");

        String input = scanner.nextLine();
        for (char c : input.toCharArray()) {
            int index = Character.getNumericValue(c) - 1;
            playerHand.discardCard(index);
            playerHand.addCard(index, deck.draw());
        }
        System.out.println("新しい手札: " + playerHand);
        System.out.println("役: " + playerHand.getRole());
    }

    public void enemyPlay() {
        boolean[] notRoleIndex = enemyHand.notRoleIndex();
        int discardCount = 0;

        for (int i = 0; i < notRoleIndex.length; i++) {
            if (!notRoleIndex[i]) {
                enemyHand.discardCard(i);
                enemyHand.addCard(i, deck.draw());
                discardCount++;
            }
        }

        System.out.println("コンピューターは" + discardCount + "枚捨てました");
    }

    public void checkHand() {
        System.out.println("プレイヤー: " + playerHand);
        System.out.println("役: " + playerHand.getRole());

        System.out.println("コンピューター: " + enemyHand);
        System.out.println("役: " + enemyHand.getRole());

        int playerRank = playerHand.getRoleRank();
        int enemyRank = enemyHand.getRoleRank();

        if (playerRank > enemyRank) {
            System.out.println("プレイヤーの勝ちです！");
        } else if (playerRank < enemyRank) {
            System.out.println("コンピューターの勝ちです！");
        } else {
            System.out.println("引き分けです！");
        }
    }

    public void start() {
        int playerTurns = 0;

        while (playerTurns < 3) {
            play();
            playerTurns++;

            if (playerTurns < 3) {
                System.out.println("もう一度引き直しますか？ 1: Yes, 2: No");
                int choice = scanner.nextInt();
                scanner.nextLine(); // consume newline
                if (choice != 1) {
                    break;
                }
            }
        }

        enemyPlay();

        System.out.println("ポーカーを終了して互いのカードと手役を出力します。");
        checkHand();
    }
}
