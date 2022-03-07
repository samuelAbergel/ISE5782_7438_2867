package geometries;

import primitives.Point;
import primitives.Vector;

public class Plane implements Geometry{
    private Point _q0;
    private Vector _normal;
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
        _normal = N;
        this._q0 = p1;
    }

    /**
     * Constructor to initialize plane based object with its point and vector
     *
     * @param p first number value
     * @param normal second number value
     */
    public Plane(Point p,Vector normal){
        super();
        this._normal = normal;
        this._q0 = _q0;
    }
    public Vector getNormal() {
        return _normal;
    }

    public Point getQ0() {
        return _q0;
    }

    @Override
    public String toString() {
        return "Plane{" +
                "q0=" + _q0 +
                ", normal=" + _normal +
                '}';
    }

    @Override
    public Vector getNormal(Point point) {
        return _normal;
    }
}
