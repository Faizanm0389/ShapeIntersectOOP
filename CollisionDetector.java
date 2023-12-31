public interface CollisionDetector {
    
    public boolean intersect(Point point);
    public boolean intersect(LineSeg lineseg);
    public boolean intersect(Rectangle rectangle);
    public boolean intersect(Circle circle);
}