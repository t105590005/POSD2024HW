package org.ntut.posd2024f.shapes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Vector;

import org.junit.jupiter.api.Test;

public class FindShapeVisitorTest {

    @Test
    public void testFindeShapeVisitorCircle() {
        Circle circle = new Circle(4);
        FindShapeVisitor findShapeVisitor = new FindShapeVisitor(shape -> shape.area() > 10);
        circle.accept(findShapeVisitor);
        assertEquals(1, findShapeVisitor.getResult().size());
    }

    @Test
    public void testFindShapeVisitorRectangle() {
        Rectangle rectangle = new Rectangle(4, 8);
        FindShapeVisitor findShapeVisitor = new FindShapeVisitor(shape -> shape.area() > 10);
        rectangle.accept(findShapeVisitor);
        assertEquals(1, findShapeVisitor.getResult().size());
    }

    @Test
    public void testFindShapeVisitorTriangle() {
        TwoDimensionalVector a = new TwoDimensionalVector(0, 0);
        TwoDimensionalVector b = new TwoDimensionalVector(6, 0);
        TwoDimensionalVector c = new TwoDimensionalVector(0, 8);
        List<TwoDimensionalVector> vectors = new Vector<TwoDimensionalVector>();
        vectors.add(a);
        vectors.add(b);
        vectors.add(c);
        Triangle triangle = new Triangle(vectors);
        FindShapeVisitor findShapeVisitor = new FindShapeVisitor(shape -> shape.area() > 10);
        triangle.accept(findShapeVisitor);
        assertEquals(1, findShapeVisitor.getResult().size());
    }

    @Test
    public void testFindShapeVistitorConvexPolygon() {
        List<TwoDimensionalVector> vectors = new Vector<>();
        vectors.add(new TwoDimensionalVector(0, 3));
        vectors.add(new TwoDimensionalVector(-5, 3));
        vectors.add(new TwoDimensionalVector(-5, -3));
        vectors.add(new TwoDimensionalVector(0, -3));
        vectors.add(new TwoDimensionalVector(4, 0));
        ConvexPolygon convexPolygon = new ConvexPolygon(vectors);
        FindShapeVisitor findShapeVisitor = new FindShapeVisitor(shape -> shape.area() > 10);
        convexPolygon.accept(findShapeVisitor);
        assertEquals(1, findShapeVisitor.getResult().size());
    }

    @Test
    public void testFindShapeVisitorCompoundShape() {
        CompoundShape compoundShape = new CompoundShape();
        compoundShape.add(new Rectangle(4, 8));
        compoundShape.add(new Circle(4));
        FindShapeVisitor findShapeVisitor = new FindShapeVisitor(shape -> shape.area() > 10);
        compoundShape.accept(findShapeVisitor);
        assertEquals(3, findShapeVisitor.getResult().size());
    }

    @Test
    public void testFindShapeVisitorCompoundShapehasCompoundShape() {
        CompoundShape compoundShape = new CompoundShape();
        CompoundShape compoundShape1 = new CompoundShape();
        compoundShape1.add(new Rectangle(4, 8));
        compoundShape1.add(new Circle(4));
        compoundShape.add(compoundShape1);
        FindShapeVisitor findShapeVisitor = new FindShapeVisitor(shape -> shape.area() > 10);
        compoundShape.accept(findShapeVisitor);
        assertEquals(3, findShapeVisitor.getResult().size());
    }

    @Test
    public void FindShapeVisitorTextedShape() {
        TextedShape textedShape = new TextedShape(new Circle(4), "Circle");
        FindShapeVisitor findShapeVisitor = new FindShapeVisitor(shape -> shape.area() > 10);
        textedShape.accept(findShapeVisitor);
        assertEquals(2, findShapeVisitor.getResult().size());
    }

    @Test
    public void FindShapeVisitorColoredShape() {
        ColoredShape coloredShape = new ColoredShape(new Circle(4), "RED");
        FindShapeVisitor findShapeVisitor = new FindShapeVisitor(shape -> shape.area() > 10);
        coloredShape.accept(findShapeVisitor);
        assertEquals(2, findShapeVisitor.getResult().size());
    }
}
