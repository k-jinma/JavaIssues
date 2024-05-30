// 動物の名前と学名を1セットとして持つクラス
public class CSVItem {
    public String animalName;
    public String scientificName;

    public CSVItem(String animalName, String scientificName) {
        this.animalName = animalName;
        this.scientificName = scientificName;
    }

    public String getAnimalName() {
        return animalName;
    }

    public String getScientificName() {
        return scientificName;
    }
}
