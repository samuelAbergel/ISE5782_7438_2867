package geometries;

import primitives.*;

public class Tube implements Geometry {
    protected Ray axisRay;
    protected double radius;

    /**
     * Constructor to initialize Double3 based object with its ray and number
     *
     * @param axisRay first number value
     * @param radius second number value
     */
    public Tube(Ray axisRay,double radius){
      this.axisRay = axisRay;
      this.radius = radius;
    }
    @Override
    public Vector getNormal(Point p){
      return null;
    }

    public Ray getAxisRay() {
        return axisRay;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public String toString() {
        return "Tube{" +
                "axisRay=" + axisRay +
                ", radius=" + radius +
                '}';
    }
}
