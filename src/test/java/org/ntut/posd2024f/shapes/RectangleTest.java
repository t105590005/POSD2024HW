package org.ntut.posd2024f.shapes;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class RectangleTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testRectangleConstructorPositiveDimensions() throws ShapeException {
        Rectangle r = new Rectangle(4.0, 8.0);
        assertEquals(4.0, r.getLength(), 0.01);
        assertEquals(8.0, r.getWidth(), 0.01);
    }

    @Test
    public void testRectangleConstructorZeroWidth() throws ShapeException {
        thrown.expect(ShapeException.class);
        thrown.expectMessage("It's not a rectangle!");
        new Rectangle(0, 8.0);
    }

    @Test
    public void testRectangleConstructorZeroHeight() throws ShapeException {
        thrown.expect(ShapeException.class);
        thrown.expectMessage("It's not a rectangle!");
        new Rectangle(4.0, 0);
    }

    @Test
    public void testRectangleConstructorNegativeWidth() throws ShapeException {
        thrown.expect(ShapeException.class);
        thrown.expectMessage("It's not a rectangle!");
        new Rectangle(-4.0, 8.0);
    }

    @Test
    public void testRectangleConstructorNegativeLength() throws ShapeException {
        thrown.expect(ShapeException.class);
        thrown.expectMessage("It's not a rectangle!");
        new Rectangle(4.0, -8.0);
    }

    @Test
    public void testArea() throws ShapeException {
        Rectangle r = new Rectangle(4.0, 8.0);
        assertEquals(32.0, r.area(), 0.01);
    }

    @Test
    public void testPerimeter() throws ShapeException {
        Rectangle r = new Rectangle(4.0, 8.0);
        assertEquals(24.0, r.perimeter(), 0.01);
    }
}