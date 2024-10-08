package org.ntut.posd2024f.shapes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Vector;
import java.util.Iterator;

import org.junit.jupiter.api.Test;

public class CompoundShapeTest {

    @Test
    public void testCompoundShapeArea() throws ShapeException {
        List<TwoDimensionalVector> vectors = new Vector<>();
        List<TwoDimensionalVector> vectors1 = new Vector<>();

        vectors.add(new TwoDimensionalVector(0, 0));
        vectors.add(new TwoDimensionalVector(4, 0));
        vectors.add(new TwoDimensionalVector(0, 3));

        vectors1.add(new TwoDimensionalVector(0, 0));
        vectors1.add(new TwoDimensionalVector(4, 0));
        vectors1.add(new TwoDimensionalVector(4, 3));
        vectors1.add(new TwoDimensionalVector(0, 3));
        ConvexPolygon polygon = new ConvexPolygon(vectors1);

        CompoundShape compoundShape = new CompoundShape();

        compoundShape.add(new Rectangle(4, 8));
        compoundShape.add(new Triangle(vectors));
        compoundShape.add(polygon);

        assertEquals(50, compoundShape.area(), 0.001);
    }

    @Test
    public void testCompoundShapePerimeter() throws ShapeException {
        List<TwoDimensionalVector> vectors = new Vector<>();
        List<TwoDimensionalVector> vectors1 = new Vector<>();

        vectors.add(new TwoDimensionalVector(0, 0));
        vectors.add(new TwoDimensionalVector(4, 0));
        vectors.add(new TwoDimensionalVector(0, 3));

        vectors1.add(new TwoDimensionalVector(0, 0));
        vectors1.add(new TwoDimensionalVector(4, 0));
        vectors1.add(new TwoDimensionalVector(4, 3));
        vectors1.add(new TwoDimensionalVector(0, 3));
        ConvexPolygon polygon = new ConvexPolygon(vectors1);

        CompoundShape compoundShape = new CompoundShape();

        compoundShape.add(new Rectangle(4, 8));
        compoundShape.add(new Triangle(vectors));
        compoundShape.add(polygon);

        assertEquals(50, compoundShape.perimeter(), 0.001);
    }

    @Test
    public void testCompoundShapeIterator() {
        List<TwoDimensionalVector> vectors = new Vector<>();
        List<TwoDimensionalVector> vectors1 = new Vector<>();

        vectors.add(new TwoDimensionalVector(0, 0));
        vectors.add(new TwoDimensionalVector(4, 0));
        vectors.add(new TwoDimensionalVector(0, 3));

        vectors1.add(new TwoDimensionalVector(0, 0));
        vectors1.add(new TwoDimensionalVector(4, 0));
        vectors1.add(new TwoDimensionalVector(4, 3));
        vectors1.add(new TwoDimensionalVector(0, 3));
        ConvexPolygon polygon = new ConvexPolygon(vectors1);

        CompoundShape compoundShape = new CompoundShape();

        compoundShape.add(new Rectangle(4, 8));
        compoundShape.add(new Triangle(vectors));
        compoundShape.add(polygon);

        Iterator<Shape> iterator = compoundShape.iterator();
        assertNotNull(iterator.next());
        assertNotNull(iterator.next());
        assertNotNull(iterator.next());
        assertFalse(iterator.hasNext());
    }
}
