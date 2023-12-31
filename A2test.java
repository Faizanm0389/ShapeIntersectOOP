import org.junit.*;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class A2test {

    @Test
    public void testPointIntersectsWithPoint() {
        Point point1 = new Point(1, 2);
        Point point2 = new Point(1, 2);
        Point point3 = new Point(3, 4);

        assertTrue(point1.intersect(point2)); 
        assertFalse(point1.intersect(point3)); 
    }

    @Test
    public void testPointIntersectsWithLineSeg() {
        Point point = new Point(1, 1);
        Point point2 = new Point(0, 0);
        LineSeg lineSeg1 = new LineSeg(new Point(0, 0), new Point(2, 2));
        LineSeg lineSeg3 = new LineSeg(new Point(2, 2), new Point(3, 3));

        assertTrue(point.intersect(lineSeg1)); 
        assertFalse(point.intersect(lineSeg3)); 
        assertTrue(point2.intersect(lineSeg1)); 
    }

    @Test
    public void testPointIntersectsWithRectangle() {
        assertTrue(new Point(2, 2).intersect(new Rectangle(1, 3, 3, 1)));
        assertFalse(new Point(2, 4).intersect(new Rectangle(1, 3, 3, 1)));
        assertTrue(new Point(1,3).intersect(new Rectangle(1, 3, 3, 1)));
    }

    @Test
    public void testPointIntersectsWithCircle() {
        Point point1 = new Point(1, 1);
        Point point2 = new Point(3, 3);
        Circle circle = new Circle(new Point(2, 2), 1);

        assertTrue(point1.intersect(circle)); 
        assertFalse(point2.intersect(circle)); 
    }
//line 
    @Test
    public void testLineSegIntersectsWithPoint() {
        Point point1 = new Point(1, 1);
        Point point3 = new Point(3, 3);

        LineSeg lineSeg = new LineSeg(new Point(0, 0), new Point(2, 2));

        assertTrue(lineSeg.intersect(point1)); 
        assertFalse(lineSeg.intersect(point3)); 
    }

    @Test
    public void testLineSegIntersectsWithLineSeg() {
        LineSeg lineSeg1 = new LineSeg(new Point(0, 0), new Point(2, 2));
        LineSeg lineSeg2 = new LineSeg(new Point(2, 2), new Point(3, 3));
        LineSeg lineSeg3 = new LineSeg(new Point(3, 2), new Point(4, 2));

        assertTrue(lineSeg1.intersect(lineSeg2)); 
        assertFalse(lineSeg2.intersect(lineSeg3)); 
    }


    @Test
    public void testLineSegIntersectsWithRectangle() {
        LineSeg lineSeg1 = new LineSeg(new Point(0, 0), new Point(3, 3));
        LineSeg lineSeg3 = new LineSeg(new Point(0, 0), new Point(0, 3));
        LineSeg lineSeg4 = new LineSeg(new Point(3, 3), new Point(4, 3));

        assertTrue(lineSeg1.intersect(new Rectangle(0, 3, 3, 0)));
        assertFalse(lineSeg3.intersect(new Rectangle(1, 3, 3, 1)));
        assertTrue(lineSeg4.intersect(new Rectangle(1, 3, 3, 01)));
    }
    


    @Test
    public void testLineSegIntersectsWithCircle() {
        LineSeg lineSeg1 = new LineSeg(new Point(0, 0), new Point(2, 2));
        LineSeg lineSeg2 = new LineSeg(new Point(2, 2), new Point(3, 3));
        Circle circle = new Circle(new Point(1, 1), 1);

        assertTrue(lineSeg1.intersect(circle)); // t
        assertFalse(lineSeg2.intersect(circle)); 
    }

    // circle ---
    @Test
    public void testCircleIntersectsWithPoint() {
        Point point1 = new Point(2, 1);
        Point point2 = new Point(4, 4);
       Circle circle = new Circle(new Point(2, 2), 1);

        assertTrue(circle.intersect(point1)); 
        assertFalse(circle.intersect(point2)); 
    }

    @Test
    public void testCircleIntersectsWithLineSeg() {
        LineSeg lineSeg1 = new LineSeg(new Point(0, 0), new Point(2, 2));
        LineSeg lineSeg2 = new LineSeg(new Point(4, 4), new Point(4, 1));
        Circle circle = new Circle(new Point(2, 2), 1);

        assertTrue(circle.intersect(lineSeg1)); 
        assertFalse(circle.intersect(lineSeg2)); 
    }

    @Test
    public void testCircleIntersectsWithRectangle() {
        assertTrue(new Circle(new Point(0, 0), 3f).intersect(new Rectangle(1, 3, 3, 1)));
        assertFalse(new Circle(new Point(0, 0), 1).intersect(new Rectangle(1, 3, 3, 1)));
    }



    @Test
    public void testCircleIntersectsWithCircle() {
        Circle circle1 = new Circle(new Point(1, 1), 2);
        Circle circle2 = new Circle(new Point(1, 1), 2);
        Circle circle3 = new Circle(new Point(4, 4), 2);

        assertTrue(circle1.intersect(circle2)); 
        assertFalse(circle1.intersect(circle3)); 
    }

    //rectangle 
    @Test
    public void testRectangleIntersectWithPoint() {
        Rectangle rectangle = new Rectangle(0, 2, 2, 0);
        Point p1 = new Point(1, 1); 
        Point p2 = new Point(3, 3); 

        assertTrue(rectangle.intersect(p1));
        assertFalse(rectangle.intersect(p2)); 
    }

    @Test
    public void testRectangleIntersectWithLineSeg() {
        Rectangle rectangle = new Rectangle(0, 2, 2, 0);
        LineSeg Line1 = new LineSeg(new Point(1, 1), new Point(3, 1)); 
        LineSeg Line2 = new LineSeg(new Point(3, 3), new Point(4, 4)); 

        assertTrue(rectangle.intersect(Line1)); 
        assertFalse(rectangle.intersect(Line2)); 
    }

    @Test
    public void testRectangleIntersectWithRectangle() {
        Rectangle rectangle1 = new Rectangle(1, 3, 3, 1);
        Rectangle rectangle2 = new Rectangle(2, 4, 4, 2); 
        Rectangle rectangle3 = new Rectangle(5, 6, 6, 5); 

        assertTrue(rectangle1.intersect(rectangle2)); 
        assertFalse(rectangle1.intersect(rectangle3)); 
    }

    @Test
    public void testRectangleIntersectWithCircle() {
        Rectangle rectangle = new Rectangle(1, 3, 3, 1);
        Circle circle1 = new Circle(new Point(2, 2), 2f); 
        Circle circle2 = new Circle(new Point(5, 5), 1); 

        assertTrue(rectangle.intersect(circle1)); 
        assertFalse(rectangle.intersect(circle2)); 
    }
    
}


