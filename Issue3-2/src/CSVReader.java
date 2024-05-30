import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// CSVから動物の名前と学名を取り出すクラス
public class CSVReader {
    public String filename;

    public CSVReader(String filename) {
        this.filename = filename;
    }

    public List<CSVItem> readCSV() {
        List<CSVItem> items = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    items.add(new CSVItem(parts[0], parts[1]));
                } else {
                    throw new IOException("Invalid CSV format");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return items;
    }
}
