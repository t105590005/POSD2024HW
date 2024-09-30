package org.ntut.posd2024f.shapes;

import static org.junit.Assert.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Vector;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class NullIteratorTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testNulliteratorHasNextReturn() {
        NullIterator nullIterator = new NullIterator();
        assertFalse(nullIterator.hasNext());
    }

    @Test
    public void testNullIteratorCircleNext() {
        thrown.expect(NoSuchElementException.class);
        thrown.expectMessage("Null iterator does not point to any element.");
        Circle c = new Circle(4.0);
        c.iterator().next();
    }

    @Test
    public void testNullIteratorRectangleNext() {
        thrown.expect(NoSuchElementException.class);
        thrown.expectMessage("Null iterator does not point to any element.");
        Rectangle r = new Rectangle(3, 4);
        r.iterator().next();
    }

    @Test
    public void testNullIteratorTriangleNext() {
        thrown.expect(NoSuchElementException.class);
        thrown.expectMessage("Null iterator does not point to any element.");
        TwoDimensionalVector a = new TwoDimensionalVector(0, 0);
        TwoDimensionalVector b = new TwoDimensionalVector(3, 0);
        TwoDimensionalVector c = new TwoDimensionalVector(0, 4);
        List<TwoDimensionalVector> vectors = new Vector<TwoDimensionalVector>();
        vectors.add(a);
        vectors.add(b);
        vectors.add(c);
        Triangle t = new Triangle(vectors);
        t.iterator().next();
    }

    public void testNullIteratorConvexPolygonNext() {
        thrown.expect(NoSuchElementException.class);
        thrown.expectMessage("Null iterator does not point to any element.");
        List<TwoDimensionalVector> vectors = new Vector<>();
        vectors.add(new TwoDimensionalVector(0, 0));
        vectors.add(new TwoDimensionalVector(4, 0));
        vectors.add(new TwoDimensionalVector(4, 3));
        vectors.add(new TwoDimensionalVector(0, 3));
        ConvexPolygon convexPolygon = new ConvexPolygon(vectors);
        convexPolygon.iterator().next();
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
