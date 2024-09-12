package org.ntut.posd2024f.shapes;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CircleTest {
    // e.g. Circle c = new Circle(...)
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testCircleConstructorPositiveRadius() throws Exception {
        Circle c = new Circle(5.0);
        assertEquals(5.0, c.radius, 0.01);
    }

    @Test
    public void testCircleConstructorZeroRadius() throws Exception {
        thrown.expect(Exception.class);
        thrown.expectMessage("Radius must be positive");
        new Circle(0);
    }

    @Test
    public void testCircleConstructorNegativeRadius() throws Exception {
        thrown.expect(Exception.class);
        thrown.expectMessage("Radius must be positive");
        new Circle(-5.0);
    }

    @Test
    public void testArea() throws Exception {
        Circle c = new Circle(1.0);
        assertEquals(Math.PI, c.area(), 0.01);
    }

    @Test
    public void testPerimeter() throws Exception {
        Circle c = new Circle(1.0);
        assertEquals(2 * Math.PI, c.perimeter(), 0.01);
    }

    @Test
    public void testToString() throws Exception {
        Circle c = new Circle(1.0);
        assertEquals("Circle " + c.radius, c.toString());
    }
}