package primitives;


public class Vector extends Point{

    final public static Double3 ZERO = new Double3(0d, 0d, 0d);
    /**
     * Constructor to initialize Vector based object with its three number values
     *
     * @param x first number value
     * @param y second number value
     * @param z third number value
     */

    public Vector(double x, double y, double z) {
        super(x,y,z);
        if (getXyz().equals(ZERO))
            throw new IllegalArgumentException("cannot create Vector to Point(0,0,0)");
    }

    /**
     * sum of two vector
     * @param v right handle side operand for addition
     * @return sum of addition
     */
    public Vector add(Vector v){
        return new Vector(getXyz().d1+v.getXyz().d1,getXyz().d2+v.getXyz().d2,getXyz().d3+v.getXyz().d3);
    }

    /**
     * substract two vector
     * @param v right handle side operand for addition
     * @return sum of substraction
     */
    public Vector subtract(Vector v){
        return new Vector(getXyz().d1-v.getXyz().d1,getXyz().d2-v.getXyz().d2,getXyz().d3-v.getXyz().d3);
    }

    /**
     * mult vector with a number
     * @param a right handle side operand for addition
     * @return sum of multiplication
     */
    public Vector scale(double a){
        return new Vector(getXyz().d1*a,getXyz().d2*a,getXyz().d3*a);
    }

    /**
     * we calculate the lenght of a squared vector
     * @return lenghtsquared of a vector
     */
    public double lengthSquared() {
        return ((getXyz().d1* getXyz().d1)+(getXyz().d2* getXyz().d2)+(getXyz().d3* getXyz().d3));
    }


    public double length() {
        return Math.sqrt(lengthSquared());
    }

    /**
     * we calculate dotproduct of two vector
     * @param v3  right handle side operand for dot product
     * @return sum of dot product
     */
    public double dotProduct(Vector v3) {
        return (getXyz().d1*v3.getXyz().d1 + getXyz().d2*v3.getXyz().d2 + getXyz().d3*v3.getXyz().d3);
    }

    /**
     * we calc the cross product of two vector
     * @param v2 right handle side operand for cross product
     * @return vector of cross product
     */
    public Vector crossProduct(Vector v2) {
        return new Vector(getXyz().d2*v2.getXyz().d3- getXyz().d3*v2.getXyz().d2 ,getXyz().d3*v2.getXyz().d1- getXyz().d1*v2.getXyz().d3,getXyz().d1*v2.getXyz().d2- getXyz().d2*v2.getXyz().d1);
    }

    /**
     * A normalization operation that returns a new vector normalized in the same direction as the original vector
     * @return the vector normalize
     */
    public Vector normalize() {
        double m = length();
        return new Vector(getXyz().d1/m,getXyz().d2/m,getXyz().d3/m);
    }

    @Override
    public String toString() {
        return "Vector{} " + super.toString();
    }

}
