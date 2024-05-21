public class Point {
    private int x;
    private int y;

    // コンストラクタ
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // 別のポイントとの距離を返すメソッド
    public int[] distance(Point other) {
        int dx = other.x - this.x;
        int dy = other.y - this.y;
        return new int[]{dx, dy};
    }

    // toString メソッドをオーバーライド
    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}
