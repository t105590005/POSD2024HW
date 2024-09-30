package org.ntut.posd2024f.shapes;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CircleTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testCircleConstructorPositiveRadius() throws ShapeException {
        Circle c = new Circle(4.0);
        assertEquals(4.0, c.getRadius(), 0.01);
    }

    @Test
    public void testCircleConstructorZeroRadius() throws ShapeException {
        thrown.expect(ShapeException.class);
        thrown.expectMessage("It's not a circle!");
        new Circle(0);
    }

    @Test
    public void testCircleConstructorNegativeRadius() throws ShapeException {
        thrown.expect(ShapeException.class);
        thrown.expectMessage("It's not a circle!");
        new Circle(-4.0);
    }

    @Test
    public void testArea() throws ShapeException {
        Circle c = new Circle(4.0);
        assertEquals(Math.PI * 4 * 4, c.area(), 0.01);
    }

    @Test
    public void testPerimeter() throws ShapeException {
        Circle c = new Circle(4.0);
        assertEquals(Math.PI * 4 * 2, c.perimeter(), 0.01);
    }

}