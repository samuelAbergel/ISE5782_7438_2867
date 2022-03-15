package geometries;
import primitives.*;

/**
 * this interface will serve all geometric classes
 */
public interface Geometry extends Intersectable{
    /**
     *
     * @param point {@link Point}
     * @return the normal to the vector in specific point
     */
    Vector getNormal(Point point);
}
