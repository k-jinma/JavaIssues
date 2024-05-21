import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        // 文字列操作クラスのインスタンスを作成する

        // ユーザーから入力を受け付ける
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        
        StringManipulator sm = new StringManipulator();
        // 文字列操作クラスを使い文字数を出力する
        System.out.println( sm.countStringLenght(input) );

        // 文字列操作クラスを使い回文かどうかを判定し、結果を出力する
        boolean b = sm.isKaibun(input);
        if( b ) {
            System.out.println("入力された文章は回文です");
        }else{
            System.out.println("入力された文章は回文ではありません");
        }

        // Scannerを閉じる
        scanner.close();

    }
}
