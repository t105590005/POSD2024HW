package org.ntut.posd2024f.shapes;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CircleTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testCircleConstructorPositiveRadius() throws Exception {
        Circle c = new Circle(4.8);
        assertEquals(4.8, c.radius, 0.01);
    }

    @Test
    public void testCircleConstructorZeroRadius() throws Exception {
        thrown.expect(ShapeException.class);
        thrown.expectMessage("It's not a circle!");
        new Circle(0);
    }

    @Test
    public void testCircleConstructorNegativeRadius() throws Exception {
        thrown.expect(ShapeException.class);
        thrown.expectMessage("It's not a circle!");
        new Circle(-4.8);
    }

    @Test
    public void testArea() throws Exception {
        Circle c = new Circle(4.8);
        assertEquals(Math.PI * 4.8 * 4.8, c.area(), 0.01);
    }

    @Test
    public void testPerimeter() throws Exception {
        Circle c = new Circle(4.8);
        assertEquals(2 * 4.8 * Math.PI, c.perimeter(), 0.01);
    }

    @Test
    public void testToString() throws Exception {
        Circle c = new Circle(4.8);
        assertEquals("Circle " + c.radius, c.toString());
    }
}