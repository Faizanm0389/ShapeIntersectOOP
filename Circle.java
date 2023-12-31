public class Circle extends AbstractShape implements CollisionDetector {
    private Point center;
    private float radius;
    private static int numberOfInstances;

    public Circle() {
        // Default constructor
    }

    public Circle(Point c, float r) {
        try{
            if (r <= 0){
                throw new ShapeArgumentException("Circle");
            }
        }
        catch(ShapeArgumentException e){
            System.err.println("ShapeArgumentException in constructing Cirle "+e.getMessage());
        }
        center = c;
        radius = r;
        numberOfInstances++;
    }

    public Point getCenter() {
        return center;
    }

    public float getRadius() {
        return radius;
    }

    public static int getNumOfInstances() {
        return numberOfInstances;
    }

    @Override
    public boolean intersect(Point point) {
        return point.intersect(this);
    }
    
    @Override
    public boolean intersect(LineSeg lineseg) { //find prependicular distance and the centrer of circle. if distance <= radius and if projection then true 
        // (a1x + b1y + c1 = 0)
        float a1 = lineseg.getEnd().getY() - lineseg.getBegin().getY();
        float b1 = lineseg.getBegin().getX() - lineseg.getEnd().getX();
        float c1 = (lineseg.getBegin().getX() * lineseg.getEnd().getY()) - (lineseg.getEnd().getX() * lineseg.getBegin().getY());
        float distance = Math.abs((a1 * center.getX() + b1 * center.getY() + c1) / (float) Math.sqrt(a1 * a1 + b1 * b1));
        //condition
        if (distance <= radius) {
            // projection part
            float projX = ((b1 * b1 * center.getX()) - (a1 * b1 * center.getY()) - (a1 * c1)) / (float) (a1 * a1 + b1 * b1);
            float projY = ((a1 * a1 * center.getY()) - (a1 * b1 * center.getX()) - (b1 * c1)) / (float) (a1 * a1 + b1 * b1);
            if ((projX >= lineseg.getBegin().getX() && projX <= lineseg.getEnd().getX() || projX >= lineseg.getEnd().getX() && projX <= lineseg.getBegin().getX()) &&
                (projY >= lineseg.getBegin().getY() && projY <= lineseg.getEnd().getY() || projY >= lineseg.getEnd().getY() && projY <= lineseg.getBegin().getY())) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public boolean intersect(Rectangle rectangle) {
        return rectangle.intersect(this);
    }
    
    @Override
    public boolean intersect(Circle circle) {
        float distanceBetweenCenters = (float) Math.sqrt(Math.pow(this.center.getX() - circle.getCenter().getX(), 2) +
                                                         Math.pow(this.center.getY() - circle.getCenter().getY(), 2));
        return distanceBetweenCenters <= (this.radius + circle.getRadius());
    }
    
}
