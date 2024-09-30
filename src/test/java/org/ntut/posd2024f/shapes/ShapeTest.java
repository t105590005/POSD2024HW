package org.ntut.posd2024f.shapes;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class ShapeTest {
    @Test
    public void testShapeInterface() throws ShapeException {
        List<TwoDimensionalVector> vectors = new Vector<>();
        vectors.add(new TwoDimensionalVector(0, 0));
        vectors.add(new TwoDimensionalVector(4, 0));
        vectors.add(new TwoDimensionalVector(0, 3));

        Shape circle = new Circle(4.8);
        Shape rectangle = new Rectangle(4, 8);
        Shape triangle = new Triangle(vectors);
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