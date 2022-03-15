package geometries;
import primitives.*;

import java.util.List;

import static primitives.Util.alignZero;

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
        return  _center.subtract(p).normalize();
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

    @Override
    public List<Point> findIntersections(Ray ray) {
        Point P0 = ray.getPoint();
        Vector v = ray.getVec();

        if (P0.equals(_center)) {
            return List.of(_center.add(v.scale(_radius)));
        }

        Vector U = _center.subtract(P0);

        double tm = alignZero(v.dotProduct(U));
        double d = alignZero(Math.sqrt(U.lengthSquared() - tm * tm));

        // no intersections : the ray direction is above the sphere
        if (d >= _radius) {
            return null;
        }

        double th = alignZero(Math.sqrt(_radius * _radius - d * d));
        double t1 = alignZero(tm - th);
        double t2 = alignZero(tm + th);

        if (t1 > 0 && t2 > 0) {
//            Point P1 = P0.add(v.scale(t1));
//            Point P2 = P0.add(v.scale(t2));
            Point P1 =ray.getPoint(t1);
            Point P2 =ray.getPoint(t2);
            return List.of(P1, P2);
        }
        if (t1 > 0) {
//            Point P1 = P0.add(v.scale(t1));
            Point P1 =ray.getPoint(t1);
            return List.of(P1);
        }
        if (t2 > 0) {
//            Point P2 = P0.add(v.scale(t2));
            Point P2 =ray.getPoint(t2);
            return List.of(P2);
        }
        return null;
    }
}
