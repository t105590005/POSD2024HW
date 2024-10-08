package org.ntut.posd2024f.shapes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.junit.jupiter.api.Test;

public class ShapeTest {
    @Test
    public void testShapeInterface() throws ShapeException {
        List<TwoDimensionalVector> vectors = new Vector<>();
        vectors.add(new TwoDimensionalVector(0, 0));
        vectors.add(new TwoDimensionalVector(4, 0));
        vectors.add(new TwoDimensionalVector(0, 3));

        List<TwoDimensionalVector> vectors1 = new Vector<>();
        vectors1.add(new TwoDimensionalVector(0, 0));
        vectors1.add(new TwoDimensionalVector(4, 0));
        vectors1.add(new TwoDimensionalVector(4, 3));
        vectors1.add(new TwoDimensionalVector(0, 3));

        Shape circle = new Circle(4.8);
        Shape rectangle = new Rectangle(4, 8);
        Shape triangle = new Triangle(vectors);
        Shape convexpolygon = new ConvexPolygon(vectors1);

        ArrayList<Shape> shapes = new ArrayList<>();
        shapes.add(circle);
        shapes.add(rectangle);
        shapes.add(triangle);
        shapes.add(convexpolygon);

        for (Shape shape : shapes) {
            assertTrue(shape.area() > 0);
            assertTrue(shape.perimeter() > 0);
        }
    }
}