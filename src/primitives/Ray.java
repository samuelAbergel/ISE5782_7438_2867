package primitives;

public class Ray {
    private Point p0;
    private Vector dir;

    /**
     * Constructor to initialize Ray based object with its vector and point
     *
     * @param p first number value
     * @param v second number value
     */
    public Ray(Point p,Vector v){
        if(this.dir.normalize() == this.dir){
            this.p0 = p;
            this.dir = v;
        }
        else{
            this.dir.normalize();
            this.p0 = p;
            this.dir = v;
        }
    }
    public Vector getVec(){
        return dir;
    }
    public Point getPoint(){
        return p0;
    }

}
