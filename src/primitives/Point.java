package primitives;

import java.util.Objects;

public class Point {

    protected Double3 _xyz;

    /**
     * Constructor to initialize point based object with its three number values
     *
     * @param x first number value
     * @param y second number value
     * @param z third number value
     */
    public Point(double x, double y , double z) {
       _xyz = new Double3(x,y,z);
    }

    @Override
    public String toString() {
        return _xyz.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Objects.equals(_xyz, point._xyz);
    }

    public Double3 getXyz() {
        return _xyz;
    }
    /**
     * sum of two points
     * @param v right handle side operand for addition
     * @return sum of addition
     */
    public Point add(Vector v) {
        return new Point(_xyz._d1 +v._xyz._d1, _xyz._d2 +v._xyz._d2, _xyz._d3 +v._xyz._d3);

    }
    /**
     * subtract two point
     * @param p1 right handle side operand for addition
     * @return sum of subtraction
     */
    public Vector subtract(Point p1) {
        if (p1.equals(this))
            throw new IllegalArgumentException("cannot create Vector to Point(0,0,0)");

        return new Vector(_xyz._d1 - p1._xyz._d1, _xyz._d2 -p1._xyz._d2, _xyz._d3 -p1._xyz._d3);
    }
    /**
     * we calculate the distance of a squared point
     * @return distanceSquared of a point
     */
    public double distanceSquared(Point p){
        return((p._xyz._d1 - _xyz._d1)*(p._xyz._d1 - _xyz._d1)+(p._xyz._d2 - _xyz._d2)*(p._xyz._d2 - _xyz._d2)+(p._xyz._d3 - _xyz._d3)*(p._xyz._d3 - _xyz._d3));
    }
    /**
     * we calc the distance of point
     * @return distance of point
     */
    public double distance(Point p){
        return Math.sqrt(distanceSquared(p));
    }

}
