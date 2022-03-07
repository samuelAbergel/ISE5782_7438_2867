package primitives;

import org.junit.jupiter.api.Test;

import static java.lang.System.out;
import static org.junit.jupiter.api.Assertions.*;
import static primitives.Util.isZero;

class VectorTest {

    Vector v1 = new Vector(1, 2, 3);
    Vector v2 = new Vector(-2, -4, -6);
    Vector v3 = new Vector(0, 3, -2);
    Point p1 = new Point(1, 2, 3);


    @Test
    void testAdd() {

        assertEquals((p1.add(new Vector(-1, -2, -3))),new Point(0, 0, 0),"ERROR: Point + Vector does not work correctly");
    }

    @Test
    void testSubtract() {
        assertEquals(new Vector(1, 1, 1),new Point(2, 3, 4).subtract(p1),"ERROR: Point - Point does not work correctly");
    }

    @Test
    void testScale() {
    }

    @Test
    void testLengthSquared() {

        // test length..
        assertEquals(14.0001,v1.lengthSquared(),0.0001,"ERROR: lengthSquared() wrong value");
    }

    @Test
    void testLength() {

        assertEquals(5.0001,new Vector(0, 3, 4).length(),0.0001,"ERROR: length() wrong value");
    }

    @Test
    void testDotProduct() {
        assertEquals(v1.dotProduct(v3),0.0001,0.0001,"ERROR: dotProduct() for orthogonal vectors is not zero");
        assertEquals(-28.0001,v1.dotProduct(v2),0.0001,"ERROR: dotProduct() wrong value");
    }

    /**
     * Test method for {@link primitives.Vector#crossProduct(primitives.Vector)}.
     */
    @Test
    public void testCrossProduct() {
        Vector v1 = new Vector(1, 2, 3);

        // ============ Equivalence Partitions Tests ==============
        Vector v2 = new Vector(0, 3, -2);
        Vector vr = v1.crossProduct(v2);

        // TC01: Test that length of cross-product is proper (orthogonal vectors taken
        // for simplicity)
        assertEquals( v1.length() * v2.length(), vr.length(), 0.00001,"crossProduct() wrong result length");

        // TC02: Test cross-product result orthogonality to its operands
        assertTrue( isZero(vr.dotProduct(v1)),"crossProduct() result is not orthogonal to 1st operand");
        assertTrue( isZero(vr.dotProduct(v2)),"crossProduct() result is not orthogonal to 2nd operand");

        // =============== Boundary Values Tests ==================
        // TC11: test zero vector from cross-productof co-lined vectors
        Vector v3 = new Vector(-2, -4, -6);
        assertThrows(IllegalArgumentException.class, () -> v1.crossProduct(v3),
                "crossProduct() for parallel vectors does not throw an exception");

    }


    @Test
    void testNormalize() {
        assertEquals(1.0001,new Vector(1, 2, 3).normalize().length(),0.0001,"ERROR: the normalized vector is not a unit vector");
        assertFalse(v1.dotProduct(v1.normalize())<0,"ERROR: the normalized vector is opposite to the original one");
        try {
            v1.crossProduct(v1.normalize());
        } catch (Exception e) {
            assertTrue(true);
        }

    }
}