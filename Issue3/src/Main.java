import java.util.Scanner;

public class Main {
    private static Decorater decorater;

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.println("装飾する文字を番号で選んでください");
        System.out.println("1.アスタリスク");
        System.out.println("2.ハイフン");
        System.out.println("3.スラッシュ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        switch (choice) {
            case 1:
                decorater = new AstaDecorater();
                break;
            case 2:
                decorater = new HyphenDecorater();
                break;
            case 3:
                decorater = new SlashDecorater();
                break;
            default:
                System.out.println("無効な選択です。");
                scanner.close();
                return;
        }

        System.out.println("文字列を入力してください:");
        String input = scanner.nextLine();

        String result = decorater.decorate(input);
        System.out.println(result);

        scanner.close();
    }
}
