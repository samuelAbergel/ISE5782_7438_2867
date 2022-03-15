package geometries;

import primitives.*;
import java.util.List;

/**
 * interface for finding intersection points
*/
public interface Intersectable {

    /**
     *
     * @param ray {@link Ray} pointing toward the object
     * @return list of intersection point {@link Point}
     */
     List<Point> findIntersections(Ray ray);
}
