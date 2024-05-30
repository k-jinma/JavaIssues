public class Triangle implements Shape {
    public double base;
    public double height;
    
    //コンストラクタ
    Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }
    
    @Override
    public double getArea() {
        return 0.5 * base * height;
    }
}
