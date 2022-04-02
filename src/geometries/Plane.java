package geometries;

import primitives.*;


import java.util.List;

import static primitives.Util.alignZero;
import static primitives.Util.isZero;

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
        this._normal = normal;
        this._q0 = p;
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

    @Override
    public List<Point> findIntersections(Ray ray) {
        Point p0 = ray.getP0();
        Vector v = ray.getVec();
        Vector n = _normal;

        if(_q0.equals(p0)){
            return null;
        }

        double nv = alignZero(n.dotProduct(v));
        //ray is lying in the play axis
        if (isZero(nv)){
            return null;
        }
        Vector Q0P0 = _q0.subtract(p0);
        //numerator
        double nQMinusP0 = alignZero(n.dotProduct(Q0P0));
        //t should > 0
        if(isZero(nQMinusP0)){
            return null;
        }
        double t = alignZero(nQMinusP0/nv);
       // t sould >0
        if(t<= 0){
            return  null;
        }
        return List.of(ray.getPoint(t));
    }
}
