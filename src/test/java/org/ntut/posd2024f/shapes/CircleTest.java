package org.ntut.posd2024f.shapes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CircleTest {
    @Test
    public void testCircleConstructorPositiveRadius() throws ShapeException {
        Circle c = new Circle(4.0);
        assertEquals(4.0, c.getRadius(), 0.01);
    }

    @Test
    public void testCircleConstructorZeroRadius() throws ShapeException {
        ShapeException exception = assertThrows(ShapeException.class, () -> {
            new Circle(0);
        });
        assertEquals("It's not a circle!", exception.getMessage());
    }

    @Test
    public void testCircleConstructorNegativeRadius() throws ShapeException {
        ShapeException exception = assertThrows(ShapeException.class, () -> {
            new Circle(-4.0);
        });
        assertEquals("It's not a circle!", exception.getMessage());
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