import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        World world = new World();

        System.out.println("World");
        System.out.println("正解の単語を当ててください。");
        
        // デバッグ用
        // System.out.println(world.getAnswer());

        int attempts = 0;
        while (attempts < 6) {
            System.out.print("入力 -> ");
            String guess = scanner.nextLine().toUpperCase();
            String result = world.checkWord(guess);
            System.out.println("出力 -> " + result);

            if (result.equals("○○○○○")) {
                System.out.println("正解です！");
                scanner.close();
                return;
            }
            attempts++;
        }

        System.out.println("正解は" + world.getAnswer() + "です。");
        scanner.close();
    }
}
