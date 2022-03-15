package geometries;
import primitives.*;

import javax.swing.*;
import java.util.*;
/**
 * composite class for all geometries object
 */
public class Geometries implements Intersectable {

    private List<Intersectable> _intersectables;

    public Geometries(){
        _intersectables = new LinkedList<Intersectable>();
    }

    public Geometries(Intersectable... intersectables) {
        _intersectables = new LinkedList<Intersectable>();
        Collections.addAll(_intersectables, intersectables);
    }

    public void add(Intersectable... intersectables){
        Collections.addAll(_intersectables, intersectables);
    }

    @Override
    public List<Point> findIntersections(Ray ray) {
        List<Point> result = null;
        for (var item : _intersectables) {
            List<Point> itemList = item.findIntersections(ray);
            if(itemList != null){
                result.addAll(itemList);
            }
            else{
                result = new LinkedList<>();
            }
        }
    return result;
    }
}
