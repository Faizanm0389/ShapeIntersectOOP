public class Main {
    public static void main(String[] args) {
        Point p1 = new Point(23.2f, 111.1f);
        Point p2 = new Point(23.2f, 111.1f);
        
        AbstractShape l1 = new LineSeg(p1, p2);
        AbstractShape c1 = new Circle(p1, 0);
        AbstractShape r1 = new Rectangle(5, 4, 9, 1);
        AbstractShape r2 = new Rectangle(2, 4, 5, 8);
    }
}