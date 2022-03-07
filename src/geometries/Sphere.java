package geometries;
import primitives.*;

public class Sphere implements  Geometry{
    private Point _center;
    private double _radius;

    /**
     * Constructor to initialize Sphere based object with its point and number
     *
     * @param c first number value
     * @param r second number value
     */
    public Sphere(Point c,double r){
        this._center = c;
        this._radius = r;

    }
    @Override
    public Vector getNormal(Point p){
        return  null;
    }

    public Point getCenter() {
        return _center;
    }

    @Override
    public String toString() {
        return "Sphere{" +
                "center=" + _center +
                ", radius=" + _radius +
                '}';
    }
}
