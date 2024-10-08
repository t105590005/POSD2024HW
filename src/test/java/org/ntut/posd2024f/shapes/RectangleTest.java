package org.ntut.posd2024f.shapes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class RectangleTest {

    @Test
    public void testRectangleConstructorPositiveDimensions() throws ShapeException {
        Rectangle r = new Rectangle(4.0, 8.0);
        assertEquals(4.0, r.getLength(), 0.01);
        assertEquals(8.0, r.getWidth(), 0.01);
    }

    @Test
    public void testRectangleConstructorZeroWidth() throws ShapeException {
        ShapeException exception = assertThrows(ShapeException.class, () -> {
            new Rectangle(0, 8.0);
        });
        assertEquals("It's not a rectangle!", exception.getMessage());
    }

    @Test
    public void testRectangleConstructorZeroHeight() throws ShapeException {
        ShapeException exception = assertThrows(ShapeException.class, () -> {
            new Rectangle(4.0, 0);
        });
        assertEquals("It's not a rectangle!", exception.getMessage());
    }

    @Test
    public void testRectangleConstructorNegativeWidth() throws ShapeException {
        ShapeException exception = assertThrows(ShapeException.class, () -> {
            new Rectangle(4.0, -8.0);
        });
        assertEquals("It's not a rectangle!", exception.getMessage());
    }

    @Test
    public void testRectangleConstructorNegativeLength() throws ShapeException {
        ShapeException exception = assertThrows(ShapeException.class, () -> {
            new Rectangle(-4.0, 8.0);
        });
        assertEquals("It's not a rectangle!", exception.getMessage());
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