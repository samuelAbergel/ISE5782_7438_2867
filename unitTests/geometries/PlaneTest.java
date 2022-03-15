package geometries;

import org.junit.jupiter.api.Test;
import primitives.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlaneTest {
    Plane pl = new Plane(new Point(0, 0, 1), new Vector(1, 1, 1));


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


    @Test
    void testFindIntersections() {
        // ============ Equivalence Partitions Tests ==============
        // TC01: Ray into plane
        assertEquals(List.of(new Point(1, 0, 0)),
                pl.findIntersections(new Ray(new Point(0.5, 0, 0), new Vector(1, 0, 0))),
                "Bad plane intersection");
        // TC02: Ray out of plane
        assertNull(pl.findIntersections(new Ray(new Point(2, 0, 0),
                        new Vector(1, 0, 0))),
                "Must not be plane intersection");

        // =============== Boundary Values Tests ==================
        // TC11: Ray parallel to plane
        assertNull(pl.findIntersections(new Ray(new Point(1, 1, 1),
                        new Vector(0, 1, -1))),
                "Must not be plane intersection");

        // TC12: Ray in plane
        assertNull(pl.findIntersections(new Ray(new Point(0, 0.5, .5),
                        new Vector(0, 1, -1))),
                "Must not be plane intersection");


        // TC13: Orthogonal ray into plane
        assertEquals(List.of(new Point(1d / 3, 1d / 3, 1d / 3)),
                pl.findIntersections(new Ray(new Point(1, 1, 1), new Vector(-1, -1, -1))),
                "Bad plane intersection");

        // TC14: Orthogonal ray out of plane
        assertNull(pl.findIntersections(new Ray(new Point(1, 1, 1),
                        new Vector(1, 1, 1))),
                "Must not be plane intersection");

        // TC15: Orthogonal ray out of plane
        assertNull(pl.findIntersections(new Ray(new Point(1, 1, 1),
                        new Vector(1, 1, 1))),
                "Must not be plane intersection");

        // TC16: Orthogonal ray from plane
        assertNull(pl.findIntersections(new Ray(new Point(0, 0.5, 0.5),
                        new Vector(1, 1, 1))),
                "Must not be plane intersection");

        // TC17: Ray from plane
        assertNull(pl.findIntersections(new Ray(new Point(0, 0.5, 0.5),
                        new Vector(1, 1, 0))),
                "Must not be plane intersection");

        // TC18: Ray from plane's Q point
        assertNull(pl.findIntersections(new Ray(new Point(0, 0, 1),
                        new Vector(1, 1, 0))),
                "Must not be plane intersection");

    }
}