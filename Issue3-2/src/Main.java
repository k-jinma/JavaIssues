import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            // CSVファイルを読み込み
            CSVReader csvReader = new CSVReader("動物名.csv");
            List<CSVItem> items = csvReader.readCSV();

            // Readerクラスに渡して動物名と学名を取得
            Reader reader = new Reader(items);

            // ユーザーからの入力を受け付ける
            java.util.Scanner scanner = new java.util.Scanner(System.in);
            System.out.print("動物名を入力してください:");
            String animalName = scanner.nextLine();

            // カタカナ以外の入力に対する例外処理
            if (!reader.isKatakana(animalName)) {
                throw new NotKatakanaException("Animal name should be in katakana.");
            }

            // 学名を取得して出力
            String scientificName = reader.getScientificName(animalName);
            if (scientificName != null) {
                System.out.println("動物の学名は" + scientificName + "です。");
            } else {
                System.out.println("該当する動物が見つかりませんでした。");
            }
        } catch (IOException e) {
            System.out.println("ファイルの読み込みに失敗しました: " + e.getMessage());
        } catch (NotKatakanaException e) {
            System.out.println("カタカナ以外の文字が入力されました: " + e.getMessage());
        }
    }
}
