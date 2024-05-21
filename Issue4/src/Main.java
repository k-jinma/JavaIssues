import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.print("生成するパスワードの数を入力してください: ");
        int numberOfPasswords = scanner.nextInt();

        System.out.print("生成するパスワードの長さを入力してください: ");
        int lengthOfPasswords = scanner.nextInt();

        PasswordGenerator generator = new PasswordGenerator();
        List<String> passwords = new ArrayList<>();

        // ランダムなパスワードを生成し、有効なパスワードかどうかを確認する
        for (int i = 0; i < numberOfPasswords; i++) {
            // ランダムなパスワードを生成
            String password = generator.generatePassword(lengthOfPasswords);
            // 有効なパスワードかどうかを確認
            while (!generator.isValidPassword(password)) {
                // 無効なパスワードであれば、再度ランダムなパスワードを生成
                password = generator.generatePassword(lengthOfPasswords);
            }
            // リストにパスワードを追加
            passwords.add(password);
        }

        System.out.println(passwords);

        scanner.close();
    }
}
