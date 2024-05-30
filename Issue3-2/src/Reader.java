import java.util.List;

// CSVReaderが取り出した情報をCSVItemに変換するクラス
public class Reader {
    public List<CSVItem> items;

    public Reader(List<CSVItem> items) {
        this.items = items;
    }

    public String getScientificName(String animalName) throws NotKatakanaException {
        for (CSVItem item : items) {
            if (item.getAnimalName().equals(animalName)) {
                if (!isKatakana(animalName)) {
                    throw new NotKatakanaException("Animal name should be in katakana.");
                }
                return item.getScientificName();
            }
        }
        return null;
    }

    public boolean isKatakana(String s) {
        for (char c : s.toCharArray()) {
            if (c < '\u30A0' || c > '\u30FF') {
                return false;
            }
        }
        return true;
    }
    
}
