package org.ntut.posd2024f.shapes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Vector;

import org.junit.jupiter.api.Test;

public class NullIteratorTest {

    @Test
    public void testNulliteratorHasNextReturn() {
        NullIterator nullIterator = new NullIterator();
        assertFalse(nullIterator.hasNext());
    }

    @Test
    public void testNullIteratorCircleNext() {
        NoSuchElementException thrown = assertThrows(NoSuchElementException.class, () -> {
            Circle c = new Circle(4.0);
            c.iterator().next();
        });
        assertEquals("Null iterator does not point to any element", thrown.getMessage());
    }

    @Test
    public void testNullIteratorRectangleNext() {
        NoSuchElementException thrown = assertThrows(NoSuchElementException.class, () -> {
            Rectangle r = new Rectangle(3, 4);
            r.iterator().next();
        });
        assertEquals("Null iterator does not point to any element", thrown.getMessage());
    }

    @Test
    public void testNullIteratorTriangleNext() {
        TwoDimensionalVector a = new TwoDimensionalVector(0, 0);
        TwoDimensionalVector b = new TwoDimensionalVector(3, 0);
        TwoDimensionalVector c = new TwoDimensionalVector(0, 4);
        List<TwoDimensionalVector> vectors = new Vector<TwoDimensionalVector>();
        vectors.add(a);
        vectors.add(b);
        vectors.add(c);
        NoSuchElementException thrown = assertThrows(NoSuchElementException.class, () -> {
            Triangle t = new Triangle(vectors);
            t.iterator().next();
        });
        assertEquals("Null iterator does not point to any element", thrown.getMessage());
    }

    public void testNullIteratorConvexPolygonNext() {
        List<TwoDimensionalVector> vectors = new Vector<>();
        vectors.add(new TwoDimensionalVector(0, 0));
        vectors.add(new TwoDimensionalVector(4, 0));
        vectors.add(new TwoDimensionalVector(4, 3));
        vectors.add(new TwoDimensionalVector(0, 3));
        NoSuchElementException thrown = assertThrows(NoSuchElementException.class, () -> {
            ConvexPolygon convexPolygon = new ConvexPolygon(vectors);
            convexPolygon.iterator().next();
        });
        assertEquals("Null iterator does not point to any element", thrown.getMessage());
    }

    @Test
    public void testNullIteratorCircleHasNext() {
        Circle c = new Circle(4.0);
        assertFalse(c.iterator().hasNext());
    }

    @Test
    public void testNullIteratorRectangleHasNext() {
        Rectangle r = new Rectangle(3, 4);
        assertFalse(r.iterator().hasNext());
    }

    @Test
    public void testNullIteratorTriangleHasNext() {
        TwoDimensionalVector a = new TwoDimensionalVector(0, 0);
        TwoDimensionalVector b = new TwoDimensionalVector(3, 0);
        TwoDimensionalVector c = new TwoDimensionalVector(0, 4);
        List<TwoDimensionalVector> vectors = new Vector<TwoDimensionalVector>();
        vectors.add(a);
        vectors.add(b);
        vectors.add(c);
        Triangle t = new Triangle(vectors);
        assertFalse(t.iterator().hasNext());
    }

    @Test
    public void testNullIteratorConvexPolygonHasNext() {
        List<TwoDimensionalVector> vectors = new Vector<>();
        vectors.add(new TwoDimensionalVector(0, 0));
        vectors.add(new TwoDimensionalVector(4, 0));
        vectors.add(new TwoDimensionalVector(4, 3));
        vectors.add(new TwoDimensionalVector(0, 3));
        ConvexPolygon convexPolygon = new ConvexPolygon(vectors);
        assertFalse(convexPolygon.iterator().hasNext());
    }
}
