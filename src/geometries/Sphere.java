package geometries;
import primitives.*;

public class Sphere implements  Geometry{
    private Point center;
    private double radius;

    /**
     * Constructor to initialize Sphere based object with its point and number
     *
     * @param c first number value
     * @param r second number value
     */
    public Sphere(Point c,double r){
        this.center = c;
        this.radius = r;

    }
    @Override
    public Vector getNormal(Point p){
        return  null;
    }

    public Point getCenter() {
        return center;
    }

    @Override
    public String toString() {
        return "Sphere{" +
                "center=" + center +
                ", radius=" + radius +
                '}';
    }
}
