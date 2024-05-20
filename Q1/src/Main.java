import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
            
        Scanner scanner = new Scanner(System.in);

        // 最初のポイントを作成
        System.out.print("入力 -> ");
        String input1 = scanner.nextLine();
        String[] coords1 = input1.split(",");
        int x1 = Integer.parseInt(coords1[0]);
        int y1 = Integer.parseInt(coords1[1]);
        Point p1 = new Point(x1, y1);

        // p1の座標を出力
        System.out.println("出力 -> " + p1);

        // ２個目のポイントを作成
        System.out.print("入力 -> ");
        String input2 = scanner.nextLine();
        String[] coords2 = input2.split(",");
        int x2 = Integer.parseInt(coords2[0]);
        int y2 = Integer.parseInt(coords2[1]);
        Point p2 = new Point(x2, y2);

        // p2の座標を出力
        System.out.println("出力 -> " + p2);

        // 距離を計算して出力
        int[] distance = p1.distance(p2);
        System.out.println("出力 -> (" + distance[0] + "," + distance[1] + ")");

        scanner.close();

    }
}
