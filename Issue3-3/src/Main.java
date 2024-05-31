import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the file name:");
        String fileName = scanner.nextLine();
        
        Archiver archiver = new Archiver();
        
        if (fileName.endsWith(".zip")) {
            archiver.decompressFile(fileName);
            System.out.println("File decompressed successfully.");
        } else if (fileName.endsWith(".CSV")) {
            archiver.compressFile(fileName);
            System.out.println("File compressed successfully.");
        } else {
            System.out.println("Unsupported file format.");
        }
        
        scanner.close();
    }
}
