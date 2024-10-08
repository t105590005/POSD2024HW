package org.ntut.posd2024f.shapes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ColoredShapeTest {

    @Test
    public void testColoredShapeConstructor() {
        ColoredShape coloredShape = new ColoredShape(new Rectangle(4.0, 8.0), "RED");
        assertEquals("RED", coloredShape.getColor());
    }

}
