import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * JUnit tests for secondary methods in MechanicalSystem.
 */
public final class MechanicalSystemSecondaryTest {

    /**
     * Tolerance for comparing doubles.
     */
    private static final double EPS = 1.0e-6;

    /**
     * Checks whether two vectors have the same coordinates.
     *
     * @param expected
     *            expected vector
     * @param actual
     *            actual vector
     */
    private static void assertVectorEquals(Vector expected, Vector actual) {
        assertEquals(expected.getX(), actual.getX(), EPS);
        assertEquals(expected.getY(), actual.getY(), EPS);
    }

    @Test
    public void testAcceleration1() {
        MechanicalSystem s = new MechanicalSystem1();
        s.setMass(2.0);
        s.applyForce(new Vector2D(4.0, 6.0));

        Vector a = s.acceleration();

        assertVectorEquals(new Vector2D(2.0, 3.0), a);
    }

    @Test
    public void testAcceleration2() {
        MechanicalSystem s = new MechanicalSystem1();
        s.setMass(5.0);
        s.applyForce(new Vector2D(-10.0, 15.0));

        Vector a = s.acceleration();

        assertVectorEquals(new Vector2D(-2.0, 3.0), a);
    }

    @Test
    public void testAcceleration3() {
        MechanicalSystem s = new MechanicalSystem1();
        s.setMass(4.0);

        Vector a = s.acceleration();

        assertVectorEquals(new Vector2D(0.0, 0.0), a);
    }

    @Test
    public void testStep1() {
        MechanicalSystem s = new MechanicalSystem1();
        s.setMass(2.0);
        s.applyForce(new Vector2D(4.0, 0.0));

        s.step(1.0);

        assertVectorEquals(new Vector2D(2.0, 0.0), s.getVelocity());
        assertVectorEquals(new Vector2D(2.0, 0.0), s.getPosition());
    }

    @Test
    public void testStep2() {
        MechanicalSystem s = new MechanicalSystem1();
        s.setMass(1.0);
        s.setVelocity(new Vector2D(1.0, 2.0));
        s.applyForce(new Vector2D(0.0, 0.0));

        s.step(3.0);

        assertVectorEquals(new Vector2D(1.0, 2.0), s.getVelocity());
        assertVectorEquals(new Vector2D(3.0, 6.0), s.getPosition());
    }

    @Test
    public void testStep3() {
        MechanicalSystem s = new MechanicalSystem1();
        s.setMass(2.0);
        s.setPosition(new Vector2D(1.0, 1.0));
        s.setVelocity(new Vector2D(2.0, 0.0));
        s.applyForce(new Vector2D(2.0, 4.0));

        s.step(0.5);

        assertVectorEquals(new Vector2D(2.5, 1.0), s.getVelocity());
        assertVectorEquals(new Vector2D(2.25, 1.5), s.getPosition());
    }

    @Test
    public void testKineticEnergy1() {
        MechanicalSystem s = new MechanicalSystem1();
        s.setMass(2.0);
        s.setVelocity(new Vector2D(3.0, 4.0));

        double ke = s.kineticEnergy();

        assertEquals(25.0, ke, EPS);
    }

    @Test
    public void testKineticEnergy2() {
        MechanicalSystem s = new MechanicalSystem1();
        s.setMass(5.0);
        s.setVelocity(new Vector2D(0.0, 2.0));

        double ke = s.kineticEnergy();

        assertEquals(10.0, ke, EPS);
    }

    @Test
    public void testKineticEnergy3() {
        MechanicalSystem s = new MechanicalSystem1();
        s.setMass(10.0);

        double ke = s.kineticEnergy();

        assertEquals(0.0, ke, EPS);
    }

    @Test
    public void testIsAtRest1() {
        MechanicalSystem s = new MechanicalSystem1();

        assertTrue(s.isAtRest());
    }

    @Test
    public void testIsAtRest2() {
        MechanicalSystem s = new MechanicalSystem1();
        s.setVelocity(new Vector2D(1.0, 0.0));

        assertFalse(s.isAtRest());
    }

    @Test
    public void testIsAtRest3() {
        MechanicalSystem s = new MechanicalSystem1();
        s.setVelocity(new Vector2D(1.0e-7, 1.0e-7));

        assertTrue(s.isAtRest());
    }

    @Test
    public void testEquals1() {
        MechanicalSystem s1 = new MechanicalSystem1();
        MechanicalSystem s2 = new MechanicalSystem1();

        assertTrue(s1.equals(s2));
    }

    @Test
    public void testEquals2() {
        MechanicalSystem s1 = new MechanicalSystem1();
        MechanicalSystem s2 = new MechanicalSystem1();
        s2.setMass(3.0);

        assertFalse(s1.equals(s2));
    }

    @Test
    public void testEquals3() {
        MechanicalSystem s1 = new MechanicalSystem1();
        MechanicalSystem s2 = new MechanicalSystem1();
        s1.setPosition(new Vector2D(1.0, 2.0));
        s2.setPosition(new Vector2D(1.0, 2.0));

        assertTrue(s1.equals(s2));
    }

    @Test
    public void testHashCode1() {
        MechanicalSystem s1 = new MechanicalSystem1();
        MechanicalSystem s2 = new MechanicalSystem1();

        assertEquals(s1.hashCode(), s2.hashCode());
    }

    @Test
    public void testHashCode2() {
        MechanicalSystem s1 = new MechanicalSystem1();
        MechanicalSystem s2 = new MechanicalSystem1();
        s1.setVelocity(new Vector2D(2.0, 3.0));
        s2.setVelocity(new Vector2D(2.0, 3.0));

        assertEquals(s1.hashCode(), s2.hashCode());
    }

    @Test
    public void testHashCode3() {
        MechanicalSystem s1 = new MechanicalSystem1();
        MechanicalSystem s2 = new MechanicalSystem1();
        s1.applyForce(new Vector2D(4.0, -1.0));
        s2.applyForce(new Vector2D(4.0, -1.0));

        assertEquals(s1.hashCode(), s2.hashCode());
    }

    @Test
    public void testToString1() {
        MechanicalSystem s = new MechanicalSystem1();

        String result = s.toString();

        assertTrue(result.contains("mass=1.0"));
    }

    @Test
    public void testToString2() {
        MechanicalSystem s = new MechanicalSystem1();
        s.setMass(6.0);

        String result = s.toString();

        assertTrue(result.contains("mass=6.0"));
    }

    @Test
    public void testToString3() {
        MechanicalSystem s = new MechanicalSystem1();
        s.applyForce(new Vector2D(2.0, 3.0));

        String result = s.toString();

        assertTrue(result.contains("MechanicalSystem1"));
        assertTrue(result.contains("netForce"));
    }

}