package org.ntut.posd2024f.shapes;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Vector;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TriangleTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test

    public void testTriangleConstructorFail() throws Exception {

        TwoDimensionalVector a = new TwoDimensionalVector(0, 0);
        TwoDimensionalVector b = new TwoDimensionalVector(1, 0);
        TwoDimensionalVector c = new TwoDimensionalVector(2, 0);
        List<TwoDimensionalVector> vectors = new Vector<TwoDimensionalVector>();
        vectors.add(a);
        vectors.add(b);
        vectors.add(c);
        thrown.expect(ShapeException.class);
        thrown.expectMessage("It's not a triangle!");
        new Triangle(vectors);
    }

    @Test
    public void testTriangleConstructorSucess() throws Exception {

        TwoDimensionalVector a = new TwoDimensionalVector(0, 0);
        TwoDimensionalVector b = new TwoDimensionalVector(3, 0);
        TwoDimensionalVector c = new TwoDimensionalVector(0, 4);
        List<TwoDimensionalVector> vectors = new Vector<TwoDimensionalVector>();
        vectors.add(a);
        vectors.add(b);
        vectors.add(c);
        Triangle t = new Triangle(vectors);
        t.v1 = a;
        t.v2 = b;
        t.v3 = c;
        assertEquals(a, t.v1);
        assertEquals(b, t.v2);
        assertEquals(c, t.v3);
    }

    @Test
    public void testArea() throws Exception {
        TwoDimensionalVector a = new TwoDimensionalVector(0, 0);
        TwoDimensionalVector b = new TwoDimensionalVector(3, 0);
        TwoDimensionalVector c = new TwoDimensionalVector(0, 4);
        List<TwoDimensionalVector> vectors = new Vector<TwoDimensionalVector>();
        vectors.add(a);
        vectors.add(b);
        vectors.add(c);
        Triangle t = new Triangle(vectors);
        assertEquals(6.0, t.area(), 0.01);
    }

    @Test
    public void testPerimeter() throws Exception {
        TwoDimensionalVector a = new TwoDimensionalVector(0, 0);
        TwoDimensionalVector b = new TwoDimensionalVector(-3, 0);
        TwoDimensionalVector c = new TwoDimensionalVector(0, 4);
        List<TwoDimensionalVector> vectors = new Vector<TwoDimensionalVector>();
        vectors.add(a);
        vectors.add(b);
        vectors.add(c);
        Triangle t = new Triangle(vectors);
        assertEquals(12.0, t.perimeter(), 0.01);
    }

}