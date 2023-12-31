public class Rectangle extends AbstractShape implements CollisionDetector{
    private float left;
    private float right;
    private float top;
    private float bottom;
    private static int numberOfInstances;

    public Rectangle(){} 

    public Rectangle(float l, float r, float t, float b) {

        try{
            if (l >= r || b >=t){
                throw new ShapeArgumentException("rectangle");
            }
        }
        catch(ShapeArgumentException e){
            System.err.println("ShapeArgumentException in constructing rectangle "+e.getMessage());
        }

        left = l;
        right = r;
        top = t;
        bottom = b;
        numberOfInstances++;
    }

    public float getLeft() {
        return left;
    }

    public float getRight() {
        return right;
    }

    public float getTop() {
        return top;
    }

    public float getBottom() {
        return bottom;
    }

    public static int getNumOfInstances() {
        return numberOfInstances;
    }

    @Override
    public boolean intersect(Point point) { //simple logiv 
        if (this.getLeft() < point.getX() && this.getRight() > point.getX() && this.getBottom() < point.getY() && this.getTop() > point.getY()) {
            return true;
        }
        return false;
        
    }
    
    public boolean intersect(LineSeg lineseg) { //find if line intersects with the 4 sides (use a function to check a side)

        float a1 = lineseg.getBegin().getX();
        float b1 = lineseg.getBegin().getY();
        float a2 = lineseg.getEnd().getX();
        float b2 = lineseg.getEnd().getY();
    
        // check intersection of all 4 sides 
        if (helper(a1, b1, a2, b2, left, top, right, top) || helper(a1, b1, a2, b2, right, top, right, bottom) || helper(a1, b1, a2, b2, right, bottom, left, bottom) || helper(a1, b1, a2, b2, left, bottom, left, top)) {
            return true;
        }
        return false;
    }
    
    //check for intersection 
    private boolean helper(float a1, float b1, float a2, float b2, float a3, float b3, float a4, float b4) {
        // special case of parallel lines 
        if ((a1 - a2) * (b3 - b4) - (b1 - b2) * (a3 - a4) == 0) {
            return false;
        }
        
        float t = ((a1 - a3) * (b3 - b4) - (b1 - b3) * (a3 - a4)) / (a1 - a2) * (b3 - b4) - (b1 - b2) * (a3 - a4);
        float u = -((a1 - a2) * (b1 - b3) - (b1 - b2) * (a1 - a3)) / (a1 - a2) * (b3 - b4) - (b1 - b2) * (a3 - a4);
        
        // bound 
        return t >= 0 && t <= 1 && u >= 0 && u <= 1;
    }
    
    

    @Override
    public boolean intersect(Rectangle rectangle) {   //simple logng logic  
        return (this.right >= rectangle.getLeft() && this.left <= rectangle.getRight()) && (this.top >= rectangle.getBottom() && this.bottom <= rectangle.getTop());
    }
    

    @Override
    public boolean intersect(Circle circle) { //if distance^2 < radius^2 then it intersects 
        float x, y;
        if ( circle.getCenter().getX() < this.left) {
            x = this.left;
        } else if ( circle.getCenter().getX() > this.right) {
            x = this.right;
        } else {
            x =  circle.getCenter().getX();
        }
    
        if ( circle.getCenter().getY() < this.bottom) {
            y = this.bottom;
        } else if ( circle.getCenter().getY() > this.top) {
            y = this.top;
        } else {
            y =  circle.getCenter().getY();
        }

        float distance = ((circle.getCenter().getX() - x) * (circle.getCenter().getX() - x)) + ((circle.getCenter().getY() - y) * (circle.getCenter().getY() - y));
    
        return distance <= (circle.getRadius() * circle.getRadius());
    }

    
    



}
