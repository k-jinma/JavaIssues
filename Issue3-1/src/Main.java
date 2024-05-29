public class Main {
    public static void main(String[] args) {
        Triangle triangle = new Triangle(10, 3);
        Circle circle = new Circle(10);
        
        Shape shape1 = triangle;
        Shape shape2 = circle;
        
        System.out.println((int)shape1.getArea());
        System.out.println((int)shape2.getArea());
    }
}
