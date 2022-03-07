package geometries;

import primitives.*;

public class Cylinder extends Tube implements Geometry{
private double _height;
    /**
     * Constructor to initialize cylinder based object with its two number values and ray
     *
     * @param axisRay first number value
     * @param radius second number value
     * @param height third number value
     */
    public Cylinder(Ray axisRay, double radius,double height) {
        super(axisRay, radius);
        this._height = height;
    }
    @Override
    public Vector getNormal(Point p){
        return super.getNormal(p);
    }

    public double getHeight() {
        return _height;
    }

    @Override
    public String toString() {
        return "Cylinder{" +
                "height=" + _height +
                ", axisRay=" + _axisRay +
                ", radius=" + _radius +
                "} " + super.toString();
    }
}
