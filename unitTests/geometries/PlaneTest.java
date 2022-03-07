package geometries;

import org.junit.jupiter.api.Test;
import primitives.*;

import static org.junit.jupiter.api.Assertions.*;

class PlaneTest {

    @Test
    public void testConstructor() {
        // ============ Equivalence Partitions Tests ==============

        // TC01: Correct construct plane
        try {
            new Plane(
                    new Point(0, 0, 1),
                    new Point(1, 0, 0),
                    new Point(0, 1, 0));
        } catch (IllegalArgumentException e) {
            fail("Failed constructing a correct plane");
        }
        // =============== Boundary Values Tests ==================

        // TC11: The first and second points merge
        assertThrows(IllegalArgumentException.class, //
                () -> new Plane(
                        new Point(0, 0, 1),
                        new Point(0, 0, 1),
                        new Point(0, 1, 0)),
                "Constructed a Plane with The first and second points merge");

        // TC12: Ttubehe points are on the same line
        assertThrows(IllegalArgumentException.class, //
                () -> new Plane(
                        new Point(5, 2, 4),
                        new Point(1, 1, 1),
                        new Point(9, 3, 7)),
                "Constructed a plane with the points are on the same line");
    }

    @Test
    void testGetNormal() {
        Vector v = new Vector(2.0,2.0,2.0);
        Plane test = new Plane(new Point(1.0,1.0,1.0),new Vector(2.0,2.0,2.0));
        assertEquals(v.getXyz(),test.getNormal().getXyz());
    }
}