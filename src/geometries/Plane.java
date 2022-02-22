package geometries;

import primitives.Point;
import primitives.Vector;

public class Plane implements Geometry{
    private Point q0;
    private Vector normal;
    /**
     * Constructor to initialize plane based object with its three number values
     *
     * @param p1 first number value
     * @param p2 second number value
     * @param p3 third number value
     */
    public Plane(Point p1, Point p2, Point p3) {
        Vector U = p2.subtract(p1);
        Vector V = p3.subtract(p1);

        Vector N = U.crossProduct(V);
        N.normalize();
        normal = N;
        this.q0 = p1;
    }
    /**
     * Constructor to initialize plane based object with its point and vector
     *
     * @param p first number value
     * @param normal second number value
     */
    public Plane(Point p,Vector normal){
        this.normal = normal;
        this.q0 = q0;
    }
    public Vector getNormal() {
        return normal;
    }

    public Point getQ0() {
        return q0;
    }

    @Override
    public String toString() {
        return "Plane{" +
                "q0=" + q0 +
                ", normal=" + normal +
                '}';
    }

    @Override
    public Vector getNormal(Point point) {
        return null;
    }
}
