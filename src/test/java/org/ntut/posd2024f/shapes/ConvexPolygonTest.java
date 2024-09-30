package org.ntut.posd2024f.shapes;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ConvexPolygonTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testConvexPolygonConstructorFail() {
        List<TwoDimensionalVector> vectors = new Vector<>();
        vectors.add(new TwoDimensionalVector(0, 0));
        vectors.add(new TwoDimensionalVector(4, 0));
        vectors.add(new TwoDimensionalVector(4, 3));
        vectors.add(new TwoDimensionalVector(0, 3));
        vectors.add(new TwoDimensionalVector(1, 1));
        thrown.expect(ShapeException.class);
        thrown.expectMessage("It's not a convex polygon!");
        new ConvexPolygon(vectors);

    }

    @Test
    public void testConvexPolygonConstructorSuccess() {
        List<TwoDimensionalVector> vectors = new Vector<>();
        vectors.add(new TwoDimensionalVector(0, 0));
        vectors.add(new TwoDimensionalVector(4, 0));
        vectors.add(new TwoDimensionalVector(4, 3));
        vectors.add(new TwoDimensionalVector(0, 3));
        new ConvexPolygon(vectors);
    }

    @Test
    public void testArea() {
        List<TwoDimensionalVector> vectors = new Vector<>();
        vectors.add(new TwoDimensionalVector(0, 0));
        vectors.add(new TwoDimensionalVector(4, 0));
        vectors.add(new TwoDimensionalVector(4, 3));
        vectors.add(new TwoDimensionalVector(0, 3));
        ConvexPolygon polygon = new ConvexPolygon(vectors);
        assertEquals(12, polygon.area(), 0.001);
    }

    @Test
    public void testPerimeter() {
        List<TwoDimensionalVector> vectors = Arrays.asList(
                new TwoDimensionalVector(0, 0),
                new TwoDimensionalVector(4, 0),
                new TwoDimensionalVector(4, 3),
                new TwoDimensionalVector(0, 3));
        ConvexPolygon polygon = new ConvexPolygon(vectors);
        assertEquals(14, polygon.perimeter(), 0.001);
    }

}
