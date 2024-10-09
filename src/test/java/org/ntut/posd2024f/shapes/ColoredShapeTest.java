package org.ntut.posd2024f.shapes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ColoredShapeTest {

    @Test
    public void testColoredShapeGetColor() {
        ColoredShape coloredShape = new ColoredShape(new Rectangle(4.0, 8.0), "RED");
        assertEquals("RED", coloredShape.getColor());
    }

    @Test
    public void testColoredShapeGetShape() {
        Rectangle rectangle = new Rectangle(4.0, 8.0);
        ColoredShape coloredShape = new ColoredShape(rectangle, "RED");
        assertEquals(rectangle, coloredShape.getShape());
    }

    @Test
    public void testColoredShapeArea() {
        Rectangle rectangle = new Rectangle(4.0, 8.0);
        ColoredShape coloredShape = new ColoredShape(rectangle, "RED");
        assertEquals(32, coloredShape.area(), 0.001);
    }

    @Test
    public void testColoredShapePerimeter() {
        Rectangle rectangle = new Rectangle(4.0, 8.0);
        ColoredShape coloredShape = new ColoredShape(rectangle, "RED");
        assertEquals(24, coloredShape.perimeter(), 0.001);
    }
}
