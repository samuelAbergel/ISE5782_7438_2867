package geometries;

import primitives.*;

public class Cylinder extends Tube implements Geometry{
private double height;
    /**
     * Constructor to initialize cylinder based object with its two number values and ray
     *
     * @param axisRay first number value
     * @param radius second number value
     * @param height third number value
     */
    public Cylinder(Ray axisRay, double radius,double height) {
        super(axisRay, radius);
        this.height = height;
    }
    @Override
    public Vector getNormal(Point p){
        return null;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "Cylinder{" +
                "height=" + height +
                ", axisRay=" + axisRay +
                ", radius=" + radius +
                "} " + super.toString();
    }
}
