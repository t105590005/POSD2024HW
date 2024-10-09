package org.ntut.posd2024f.shapes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
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
    public void testFindeShapeVisitorCirclehasText() {
        Circle circle = new Circle(4);
        TextedShape textedShape = new TextedShape(circle, "this is a circle");
        FindShapeVisitor findShapeVisitor = new FindShapeVisitor(shape -> shape.area() > 10);
        textedShape.accept(findShapeVisitor);
        assertEquals(2, findShapeVisitor.getResult().size());
    }

    @Test
    public void testFindeShapeVisitorCirclehasColor() {
        Circle circle = new Circle(4);
        ColoredShape coloredShape = new ColoredShape(circle, "BLUE");
        FindShapeVisitor findShapeVisitor = new FindShapeVisitor(shape -> shape.area() > 10);
        coloredShape.accept(findShapeVisitor);
        assertEquals(2, findShapeVisitor.getResult().size());
    }

    @Test
    public void testFindeShapeVisitorCirclehasTextandColor() {
        Circle circle = new Circle(4);
        ColoredShape coloredShape = new ColoredShape(circle, "BLUE");
        TextedShape textedShape = new TextedShape(coloredShape, "this is a circle with blue color");
        FindShapeVisitor findShapeVisitor = new FindShapeVisitor(shape -> shape.area() > 10);
        textedShape.accept(findShapeVisitor);
        assertEquals(3, findShapeVisitor.getResult().size());
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
    public void testFindShapeVisitorComplexCompoundShape() {
        ArrayList<TwoDimensionalVector> vectors = new ArrayList<TwoDimensionalVector>();
        vectors.add(new TwoDimensionalVector(4, 0));
        vectors.add(new TwoDimensionalVector(4, 3));
        vectors.add(new TwoDimensionalVector(0, 3));
        CompoundShape compound = new CompoundShape();
        compound.add(new Triangle(vectors));
        CompoundShape compound1 = new CompoundShape();
        compound1.add(compound);
        ColoredShape colorShape1 = new ColoredShape(new Rectangle(3.0, 4.0), "BLUE");
        TextedShape textShape = new TextedShape(colorShape1, "this is a rectanglewith blue color");
        compound1.add(textShape);
        ColoredShape colorShape2 = new ColoredShape(compound1, "GREEN");
        CompoundShape compound2 = new CompoundShape();
        compound2.add(new Circle(3.0));
        compound2.add(colorShape2);

        FindShapeVisitor findShapeVisitor = new FindShapeVisitor(shape -> shape.area() > 10);
        compound2.accept(findShapeVisitor);
        assertEquals(7, findShapeVisitor.getResult().size());

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
