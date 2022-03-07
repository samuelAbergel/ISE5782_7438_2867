package geometries;

import primitives.*;

public class Tube implements Geometry {
    protected Ray _axisRay;
    protected double _radius;

    /**
     * Constructor to initialize Double3 based object with its ray and number
     *
     * @param axisRay first number value
     * @param radius second number value
     */
    public Tube(Ray axisRay,double radius){
      this._axisRay = axisRay;
      this._radius = radius;
    }
    @Override
    public Vector getNormal(Point temp){
        double t = _axisRay.getVec().dotProduct(temp.subtract(_axisRay.getPoint()));
        Point o = _axisRay.getPoint().add(_axisRay.getVec().scale(t));
        return temp.subtract(o).normalize();
    }

    public Ray getAxisRay() {
        return _axisRay;
    }

    public double getRadius() {
        return _radius;
    }

    @Override
    public String toString() {
        return "Tube{" +
                "axisRay=" + _axisRay +
                ", radius=" + _radius +
                '}';
    }
}
