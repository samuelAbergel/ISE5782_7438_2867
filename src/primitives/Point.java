package primitives;

import java.util.Objects;
import primitives.*;

public class Point {

    protected Double3 xyz;

    /**
     * Constructor to initialize point based object with its three number values
     *
     * @param x first number value
     * @param y second number value
     * @param z third number value
     */
    public Point(double x, double y , double z) {
       xyz = new Double3(x,y,z);
    }

    @Override
    public String toString() {
        return xyz.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Objects.equals(xyz, point.xyz);
    }

    public Double3 getXyz() {
        return xyz;
    }
    /**
     * sum of two points
     * @param v right handle side operand for addition
     * @return sum of addition
     */
    public Point add(Vector v) {
        return new Point(xyz.d1+v.xyz.d1,xyz.d2+v.xyz.d2,xyz.d3+v.xyz.d3);

    }
    /**
     * subtract two point
     * @param p1 right handle side operand for addition
     * @return sum of subtraction
     */
    public Vector subtract(Point p1) {
        if (p1.equals(this))
            throw new IllegalArgumentException("cannot create Vector to Point(0,0,0)");

        return new Vector(xyz.d1 - p1.xyz.d1,xyz.d2-p1.xyz.d2,xyz.d3-p1.xyz.d3);
    }
    /**
     * we calculate the distance of a squared point
     * @return distanceSquared of a point
     */
    public double distanceSquared(Point p){
        return((p.xyz.d1-xyz.d1)*(p.xyz.d1-xyz.d1)+(p.xyz.d2-xyz.d2)*(p.xyz.d2-xyz.d2)+(p.xyz.d3-xyz.d3)*(p.xyz.d3-xyz.d3));
    }
    /**
     * we calc the distance of point
     * @return distance of point
     */
    public double distance(Point p){
        return Math.sqrt(distanceSquared(p));
    }

}
