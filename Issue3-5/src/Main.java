import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;

        while (playAgain) {
            GameManager gameManager = new GameManager();
            gameManager.start();

            System.out.println("もう一度プレイしますか？ 1: Yes, 2: No");
            int choice = scanner.nextInt();
            playAgain = (choice == 1);
        }

        scanner.close();
    }
}
