package geometries;

import org.junit.jupiter.api.Test;
import primitives.*;

import static org.junit.jupiter.api.Assertions.*;

class SphereTest {

    @Test
    public void testConstructor() {
        // ============ Equivalence Partitions Tests ==============

        // TC01: Correct construct Sphere
        try {
            new Sphere(
                    new Point(0, 0, 1),5);
        } catch (IllegalArgumentException e) {
            fail("Failed constructing a correct sphere");
        }
    }

    @Test
    void testGetNormal() {

        Point centerTest = new Point(1, 0, 1);
        Sphere Stest = new Sphere(new Point(2, 0, 2), 1.0);
        Vector result = Stest.getNormal(centerTest);
        Vector test = new Vector(1, 0, 1).normalize();
        assertEquals(result.getXyz(), test.getXyz());
    }
}