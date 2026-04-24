import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * JUnit tests for MechanicalSystem1.
 */
public final class MechanicalSystem1Test {

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
    public void testConstructorInitialState1() {
        MechanicalSystem s = new MechanicalSystem1();

        assertEquals(1.0, s.getMass(), EPS);
        assertVectorEquals(new Vector2D(0.0, 0.0), s.getPosition());
        assertVectorEquals(new Vector2D(0.0, 0.0), s.getVelocity());
        assertVectorEquals(new Vector2D(0.0, 0.0), s.getNetForce());
    }

    @Test
    public void testConstructorInitialState2() {
        MechanicalSystem s = new MechanicalSystem1();

        assertEquals(1.0, s.getMass(), EPS);
        assertVectorEquals(new Vector2D(0.0, 0.0), s.getPosition());
    }

    @Test
    public void testConstructorInitialState3() {
        MechanicalSystem s = new MechanicalSystem1();

        assertVectorEquals(new Vector2D(0.0, 0.0), s.getVelocity());
        assertVectorEquals(new Vector2D(0.0, 0.0), s.getNetForce());
    }

    @Test
    public void testSetMass1() {
        MechanicalSystem s = new MechanicalSystem1();

        s.setMass(2.0);

        assertEquals(2.0, s.getMass(), EPS);
    }

    @Test
    public void testSetMass2() {
        MechanicalSystem s = new MechanicalSystem1();

        s.setMass(10.5);

        assertEquals(10.5, s.getMass(), EPS);
        assertVectorEquals(new Vector2D(0.0, 0.0), s.getPosition());
    }

    @Test
    public void testSetMass3() {
        MechanicalSystem s = new MechanicalSystem1();

        s.setMass(0.25);

        assertEquals(0.25, s.getMass(), EPS);
        assertVectorEquals(new Vector2D(0.0, 0.0), s.getVelocity());
        assertVectorEquals(new Vector2D(0.0, 0.0), s.getNetForce());
    }

    @Test
    public void testSetPosition1() {
        MechanicalSystem s = new MechanicalSystem1();

        s.setPosition(new Vector2D(3.0, 4.0));

        assertVectorEquals(new Vector2D(3.0, 4.0), s.getPosition());
    }

    @Test
    public void testSetPosition2() {
        MechanicalSystem s = new MechanicalSystem1();

        s.setPosition(new Vector2D(-2.0, 5.0));

        assertVectorEquals(new Vector2D(-2.0, 5.0), s.getPosition());
        assertEquals(1.0, s.getMass(), EPS);
    }

    @Test
    public void testSetPosition3() {
        MechanicalSystem s = new MechanicalSystem1();

        s.setPosition(new Vector2D(0.0, -7.5));

        assertVectorEquals(new Vector2D(0.0, -7.5), s.getPosition());
        assertVectorEquals(new Vector2D(0.0, 0.0), s.getVelocity());
        assertVectorEquals(new Vector2D(0.0, 0.0), s.getNetForce());
    }

    @Test
    public void testSetVelocity1() {
        MechanicalSystem s = new MechanicalSystem1();

        s.setVelocity(new Vector2D(1.0, 2.0));

        assertVectorEquals(new Vector2D(1.0, 2.0), s.getVelocity());
    }

    @Test
    public void testSetVelocity2() {
        MechanicalSystem s = new MechanicalSystem1();

        s.setVelocity(new Vector2D(-3.0, 6.0));

        assertVectorEquals(new Vector2D(-3.0, 6.0), s.getVelocity());
        assertEquals(1.0, s.getMass(), EPS);
    }

    @Test
    public void testSetVelocity3() {
        MechanicalSystem s = new MechanicalSystem1();

        s.setVelocity(new Vector2D(0.5, -0.5));

        assertVectorEquals(new Vector2D(0.5, -0.5), s.getVelocity());
        assertVectorEquals(new Vector2D(0.0, 0.0), s.getPosition());
        assertVectorEquals(new Vector2D(0.0, 0.0), s.getNetForce());
    }

    @Test
    public void testApplyForce1() {
        MechanicalSystem s = new MechanicalSystem1();

        s.applyForce(new Vector2D(2.0, 3.0));

        assertVectorEquals(new Vector2D(2.0, 3.0), s.getNetForce());
    }

    @Test
    public void testApplyForce2() {
        MechanicalSystem s = new MechanicalSystem1();

        s.applyForce(new Vector2D(-1.0, 4.0));

        assertVectorEquals(new Vector2D(-1.0, 4.0), s.getNetForce());
        assertEquals(1.0, s.getMass(), EPS);
    }

    @Test
    public void testApplyForce3() {
        MechanicalSystem s = new MechanicalSystem1();

        s.applyForce(new Vector2D(0.0, -8.0));

        assertVectorEquals(new Vector2D(0.0, -8.0), s.getNetForce());
        assertVectorEquals(new Vector2D(0.0, 0.0), s.getPosition());
        assertVectorEquals(new Vector2D(0.0, 0.0), s.getVelocity());
    }

    @Test
    public void testClearForces1() {
        MechanicalSystem s = new MechanicalSystem1();
        s.applyForce(new Vector2D(5.0, 6.0));

        s.clearForces();

        assertVectorEquals(new Vector2D(0.0, 0.0), s.getNetForce());
    }

    @Test
    public void testClearForces2() {
        MechanicalSystem s = new MechanicalSystem1();
        s.applyForce(new Vector2D(-3.0, 1.0));

        s.clearForces();

        assertVectorEquals(new Vector2D(0.0, 0.0), s.getNetForce());
        assertEquals(1.0, s.getMass(), EPS);
    }

    @Test
    public void testClearForces3() {
        MechanicalSystem s = new MechanicalSystem1();
        s.setPosition(new Vector2D(4.0, 4.0));
        s.applyForce(new Vector2D(9.0, 9.0));

        s.clearForces();

        assertVectorEquals(new Vector2D(0.0, 0.0), s.getNetForce());
        assertVectorEquals(new Vector2D(4.0, 4.0), s.getPosition());
    }

    @Test
    public void testReset1() {
        MechanicalSystem s = new MechanicalSystem1();
        s.setMass(8.0);

        s.reset();

        assertEquals(1.0, s.getMass(), EPS);
    }

    @Test
    public void testReset2() {
        MechanicalSystem s = new MechanicalSystem1();
        s.setPosition(new Vector2D(7.0, -2.0));

        s.reset();

        assertVectorEquals(new Vector2D(0.0, 0.0), s.getPosition());
    }

    @Test
    public void testReset3() {
        MechanicalSystem s = new MechanicalSystem1();
        s.setVelocity(new Vector2D(1.0, 1.0));
        s.applyForce(new Vector2D(2.0, 2.0));

        s.reset();

        assertVectorEquals(new Vector2D(0.0, 0.0), s.getVelocity());
        assertVectorEquals(new Vector2D(0.0, 0.0), s.getNetForce());
    }

    @Test
    public void testClear1() {
        MechanicalSystem s = new MechanicalSystem1();
        s.setMass(3.0);

        s.clear();

        assertEquals(1.0, s.getMass(), EPS);
    }

    @Test
    public void testClear2() {
        MechanicalSystem s = new MechanicalSystem1();
        s.setPosition(new Vector2D(5.0, 5.0));

        s.clear();

        assertVectorEquals(new Vector2D(0.0, 0.0), s.getPosition());
    }

    @Test
    public void testClear3() {
        MechanicalSystem s = new MechanicalSystem1();
        s.setVelocity(new Vector2D(6.0, -6.0));
        s.applyForce(new Vector2D(4.0, 3.0));

        s.clear();

        assertVectorEquals(new Vector2D(0.0, 0.0), s.getVelocity());
        assertVectorEquals(new Vector2D(0.0, 0.0), s.getNetForce());
    }

    @Test
    public void testNewInstance1() {
        MechanicalSystem s = new MechanicalSystem1();

        MechanicalSystem t = s.newInstance();

        assertTrue(t instanceof MechanicalSystem1);
    }

    @Test
    public void testNewInstance2() {
        MechanicalSystem s = new MechanicalSystem1();

        MechanicalSystem t = s.newInstance();

        assertNotSame(s, t);
    }

    @Test
    public void testNewInstance3() {
        MechanicalSystem s = new MechanicalSystem1();

        MechanicalSystem t = s.newInstance();

        assertEquals(1.0, t.getMass(), EPS);
        assertVectorEquals(new Vector2D(0.0, 0.0), t.getPosition());
        assertVectorEquals(new Vector2D(0.0, 0.0), t.getVelocity());
        assertVectorEquals(new Vector2D(0.0, 0.0), t.getNetForce());
    }

    @Test
    public void testTransferFrom1() {
        MechanicalSystem target = new MechanicalSystem1();
        MechanicalSystem source = new MechanicalSystem1();
        source.setMass(4.0);

        target.transferFrom(source);

        assertEquals(4.0, target.getMass(), EPS);
        assertEquals(1.0, source.getMass(), EPS);
    }

    @Test
    public void testTransferFrom2() {
        MechanicalSystem target = new MechanicalSystem1();
        MechanicalSystem source = new MechanicalSystem1();
        source.setPosition(new Vector2D(3.0, 9.0));

        target.transferFrom(source);

        assertVectorEquals(new Vector2D(3.0, 9.0), target.getPosition());
        assertVectorEquals(new Vector2D(0.0, 0.0), source.getPosition());
    }

    @Test
    public void testTransferFrom3() {
        MechanicalSystem target = new MechanicalSystem1();
        MechanicalSystem source = new MechanicalSystem1();
        source.setVelocity(new Vector2D(-1.0, 2.0));
        source.applyForce(new Vector2D(6.0, -3.0));

        target.transferFrom(source);

        assertVectorEquals(new Vector2D(-1.0, 2.0), target.getVelocity());
        assertVectorEquals(new Vector2D(6.0, -3.0), target.getNetForce());
        assertVectorEquals(new Vector2D(0.0, 0.0), source.getVelocity());
        assertVectorEquals(new Vector2D(0.0, 0.0), source.getNetForce());
    }

}