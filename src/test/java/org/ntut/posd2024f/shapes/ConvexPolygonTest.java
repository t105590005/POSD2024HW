package org.ntut.posd2024f.shapes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Vector;

import org.junit.jupiter.api.Test;

public class ConvexPolygonTest {

    @Test
    public void testConvexPolygonConstructorFail() {
        List<TwoDimensionalVector> vectors = new Vector<>();
        vectors.add(new TwoDimensionalVector(0, 0));
        vectors.add(new TwoDimensionalVector(4, 0));
        vectors.add(new TwoDimensionalVector(4, 3));
        vectors.add(new TwoDimensionalVector(0, 3));
        vectors.add(new TwoDimensionalVector(1, 1));
        ShapeException exception = assertThrows(ShapeException.class, () -> {
            new ConvexPolygon(vectors);
        });
        assertEquals("It's not a convex polygon!", exception.getMessage());
    }

    @Test
    public void testConvexPolygonConstructorSuccess() {
        List<TwoDimensionalVector> vectors = new Vector<>();
        vectors.add(new TwoDimensionalVector(0, 3));
        vectors.add(new TwoDimensionalVector(-5, 3));
        vectors.add(new TwoDimensionalVector(-5, -3));
        vectors.add(new TwoDimensionalVector(0, -3));
        vectors.add(new TwoDimensionalVector(4, 0));
        new ConvexPolygon(vectors);
    }

    @Test
    public void testConvexPolygonArea() {
        List<TwoDimensionalVector> vectors = new Vector<>();
        vectors.add(new TwoDimensionalVector(0, 0));
        vectors.add(new TwoDimensionalVector(4, 0));
        vectors.add(new TwoDimensionalVector(4, 3));
        vectors.add(new TwoDimensionalVector(0, 3));
        ConvexPolygon polygon = new ConvexPolygon(vectors);
        assertEquals(12, polygon.area(), 0.001);
    }

    @Test
    public void testConvexPolygonPerimeter() {
        List<TwoDimensionalVector> vectors = new Vector<>();
        vectors.add(new TwoDimensionalVector(0, 0));
        vectors.add(new TwoDimensionalVector(4, 0));
        vectors.add(new TwoDimensionalVector(4, 3));
        vectors.add(new TwoDimensionalVector(0, 3));
        ConvexPolygon polygon = new ConvexPolygon(vectors);
        assertEquals(14, polygon.perimeter(), 0.001);
    }

    @Test
    public void testConvexPolygonGetVectors() {
        List<TwoDimensionalVector> vectors = new Vector<>();
        vectors.add(new TwoDimensionalVector(0, 0));
        vectors.add(new TwoDimensionalVector(4, 0));
        vectors.add(new TwoDimensionalVector(4, 3));
        vectors.add(new TwoDimensionalVector(0, 3));
        ConvexPolygon polygon = new ConvexPolygon(vectors);
        assertEquals(vectors, polygon.getVectors());
    }

}
