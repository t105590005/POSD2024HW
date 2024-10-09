package org.ntut.posd2024f.shapes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class TextedShapeTest {

    @Test
    public void testTextedShapeConstructor() {
        TextedShape textedShape = new TextedShape(new Rectangle(4.0, 8.0), "Hello");
        assertEquals("Hello", textedShape.getText());
    }

    @Test
    public void testTextedShapeGetShape() {
        Rectangle rectangle = new Rectangle(4.0, 8.0);
        TextedShape textedShape = new TextedShape(rectangle, "Hello");
        assertEquals(rectangle, textedShape.getShape());
    }

    @Test
    public void testTextedShapeArea() {
        Rectangle rectangle = new Rectangle(4.0, 8.0);
        TextedShape textedShape = new TextedShape(rectangle, "Hello");
        assertEquals(32, textedShape.area(), 0.001);
    }

    @Test
    public void testTextedShapePerimeter() {
        Rectangle rectangle = new Rectangle(4.0, 8.0);
        TextedShape textedShape = new TextedShape(rectangle, "Hello");
        assertEquals(24, textedShape.perimeter(), 0.001);
    }
}
