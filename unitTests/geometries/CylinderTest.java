package geometries;

import org.junit.jupiter.api.Test;
import primitives.*;

import static org.junit.jupiter.api.Assertions.*;

class CylinderTest {

    @Test
    public void testConstructor() {

        // ============ Equivalence Partitions Tests ==============

        // TC01: Correct construct plane
        try {
            new Cylinder(
                    new Ray(new Point(0,0,0),
                            new Vector(1,1,0)),
                    2.0,2.0);
        } catch (IllegalArgumentException e) {
            fail("Failed constructing a correct plane");
        }


    }
    @Test
    void testGetNormal() {
        Cylinder test = new Cylinder(new Ray(new Point(0,0,0),new Vector(1,1,0)),2.0,2.0);
        Vector Normaltest = test.getNormal(new Point(1.0,1.0,1.0));
        Vector Expected = new Point(0,0,1.0).subtract(new Point(0,0,0)).normalize();
        assertEquals(Expected.getXyz(),Normaltest.getXyz());
    }
}