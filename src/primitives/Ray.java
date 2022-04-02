package primitives;

import java.util.List;
import java.util.Objects;

import static primitives.Util.isZero;

public class Ray {
    private final Point p0;
    private final Vector dir;

    public Ray(Point p0, Vector dir) {
        this.p0 = p0;
        this.dir = dir;
    }

    public Point getP0() {
        return p0;
    }

    public Vector getVec() {
        return dir;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ray ray = (Ray) o;
        return p0.equals(ray.p0) && dir.equals(ray.dir);
    }

    @Override
    public int hashCode() {
        return Objects.hash(p0, dir);
    }

    @Override
    public String toString() {
        return "Ray{" +
                "p0=" + p0 +
                ", dir=" + dir +
                '}';
    }

    public Point getPoint(double delta ){
        if (isZero(delta)){
            return  p0;
        }
        return p0.add(dir.scale(delta));
    }

}
