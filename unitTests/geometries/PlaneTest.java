package geometries;

import org.junit.jupiter.api.Test;
import primitives.*;

import static org.junit.jupiter.api.Assertions.*;

class PlaneTest {

    @Test
    public void testConstructor() {
    }

    @Test
    void testGetNormal() {
        Vector v = new Vector(2.0,2.0,2.0);
        Plane test = new Plane(new Point(1.0,1.0,1.0),new Vector(2.0,2.0,2.0));
        assertEquals(v.getXyz(),test.getNormal().getXyz());

    }
}