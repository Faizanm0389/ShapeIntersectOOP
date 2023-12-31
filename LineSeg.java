public class LineSeg extends AbstractShape implements CollisionDetector{

    private Point begin;
    private Point end;
    private static int numberOfInstances;

    public LineSeg(Point x, Point y) {

        try{
            if (x.intersect(y)){
                throw new ShapeArgumentException("LineSeg");
            }
        }
        catch(ShapeArgumentException e){
            System.err.println("ShapeArgumentException in constructing  "+ e.getMessage());
        }

        begin = x;
        end = y;
        numberOfInstances++;
    }

    public Point getBegin() {
        return begin;
    }

    public Point getEnd() {
        return end;
    }

    public static int getNumOfInstances() {
        return numberOfInstances;
    }

    @Override
    public boolean intersect(Point point) {
        return point.intersect(this);
    }

    @Override
    public boolean intersect(LineSeg lineseg) { //compare slope and intersections (special case for overlapping) 
        float m = (this.getEnd().getY() - this.getBegin().getY()) / (this.getEnd().getX() - this.getBegin().getX());
        float n = (lineseg.getEnd().getY() - lineseg.getBegin().getY()) / (lineseg.getEnd().getX() - lineseg.getBegin().getX());
        
        float interA = this.getBegin().getY() - m * this.getBegin().getX();
        float interB = lineseg.getBegin().getY() - n * lineseg.getBegin().getX();

        if (m == n) {
            float a1 = this.getBegin().getX();
            float a2 = this.getEnd().getX();
            float a3 = lineseg.getBegin().getX();
            float a4 = lineseg.getEnd().getX();
            
            return (a1 >= a3 && a1 <= a4) || (a3 >= a1 && a3 <= a2);
        }

        float inter = (interB - interA) / (m - n);

        return (inter >= this.getBegin().getX() && inter <= this.getEnd().getX())
                && (inter >= lineseg.getBegin().getX() && inter <= lineseg.getEnd().getX());
    }

    @Override
    public boolean intersect(Rectangle rectangle) {
        return rectangle.intersect(this);
    }

    @Override
    public boolean intersect(Circle circle) {
        return circle.intersect(this);
    }
     
}
