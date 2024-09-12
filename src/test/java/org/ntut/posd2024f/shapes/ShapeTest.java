package org.ntut.posd2024f.shapes;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.ArrayList;

public class ShapeTest {
    @Test
    public void testShapeInterface() throws Exception {
        Shape circle = new Circle(2);
        Shape rectangle = new Rectangle(2, 3);
        Shape triangle = new Triangle(3, 4, 5);

        ArrayList<Shape> shapes = new ArrayList<>();
        shapes.add(circle);
        shapes.add(rectangle);
        shapes.add(triangle);

        for (Shape shape : shapes) {
            assertTrue(shape.area() > 0);
            assertTrue(shape.perimeter() > 0);
            assertNotNull(shape.toString());
        }
    }
}