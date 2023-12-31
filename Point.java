public class Point extends AbstractShape implements CollisionDetector {
    private float x = 0;
    private float y = 0;
    private static int numberOfInstances;

    public Point(){}
    public Point(float x, float y) {
        this.x = x;
        this.y = y;
        numberOfInstances++;
    }

    //getter for y
    public float getX() {
        return x;
    }

    //getter for y
    public float getY() {
        return y;
    }
    public static int getNumOfInstances() {
        return numberOfInstances;
    }
    @Override
    public boolean intersect(Point point) { //simple logic
        return this.getX() == point.getX() && this.getY() == point.getY();
    }
    
    @Override
    /*public boolean intersect(LineSeg lineseg) {
        float a1 = lineseg.getBegin().getX();
        float b1 = lineseg.getBegin().getY();
        float a2 = lineseg.getEnd().getX();
        float b2 = lineseg.getEnd().getY();
    
        return (this.getX() * (b1 - b2) + a1 * (b2 - this.getY()) + a2 * (this.getY() - b1)) == 0;
    } */
    public boolean intersect(LineSeg lineseg) { //use crossproduct and dotproduct to find 
        float cp = (this.getY() - lineseg.getBegin().getY()) * (lineseg.getEnd().getX() - lineseg.getBegin().getX()) - (this.getX() - lineseg.getBegin().getX()) * (lineseg.getEnd().getY() - lineseg.getBegin().getY());
        
        if (Math.abs(cp) > 0.0001f) {
            return false;
        }
        float dp = (this.getX() - lineseg.getBegin().getX()) * (lineseg.getEnd().getX() - lineseg.getBegin().getX()) + (this.getY() - lineseg.getBegin().getY()) * (lineseg.getEnd().getY() - lineseg.getBegin().getY());
        if (dp < 0) {
            return false;
        }
        float lenSquared = (lineseg.getEnd().getX() - lineseg.getBegin().getX()) * (lineseg.getEnd().getX() - lineseg.getBegin().getX()) + (lineseg.getEnd().getY() - lineseg.getBegin().getY()) * (lineseg.getEnd().getY() - lineseg.getBegin().getY());
        if (dp > lenSquared) {
            return false;
        }
        return true;
    }
        
    
    @Override
    public boolean intersect(Rectangle rectangle) {
        // Intersection logic for points and rectangles
        return rectangle.intersect(this);
    }
    
    @Override
    public boolean intersect(Circle circle) { //distance formula 
        float x = circle.getCenter().getX();
        float y = circle.getCenter().getY();
        float distance = (float) Math.sqrt(Math.pow(x - this.getX(), 2) + Math.pow(y - this.getY(), 2));
        return distance <= circle.getRadius();
    }

}
