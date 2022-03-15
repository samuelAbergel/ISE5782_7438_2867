package primitives;

import static primitives.Util.isZero;

public class Ray {
    private Point _p0;
    private Vector _dir;

    /**
     * Constructor to initialize Ray based object with its vector and point
     *
     * @param p first number value
     * @param v second number value
     */
    public Ray(Point p,Vector v){
        this._dir = v;
        if(this._dir.normalize() == this._dir){
            this._p0 = p;
            this._dir = v;
        }
        else{
            this._dir.normalize();
            this._p0 = p;
            this._dir = v;
        }
    }
    public Vector getVec(){
        return _dir;
    }
    public Point getPoint(){
        return _p0;
    }

    /**
     *
     * get point at specific distance
     *
     * @param t distance for reaching new point
     * @return new {@link Point}
     */
    public Point getPoint(double t) {
        if(isZero(t)){
            throw new IllegalArgumentException("t equal 0 cause illegal vector 0");
        }
        return _p0.add(_dir.scale(t));
    }
}
