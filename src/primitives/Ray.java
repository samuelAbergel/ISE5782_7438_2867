package primitives;

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

}
