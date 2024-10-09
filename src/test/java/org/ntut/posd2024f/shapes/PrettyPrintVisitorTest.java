package org.ntut.posd2024f.shapes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Vector;

import org.junit.jupiter.api.Test;

public class PrettyPrintVisitorTest {

    @Test
    public void testPrettyPrintVisitorCircle() {
        Circle circle = new Circle(4);
        PrettyPrintVisitor prettyPrintVisitor = new PrettyPrintVisitor();
        circle.accept(prettyPrintVisitor);
        assertEquals("Circle 4.0", prettyPrintVisitor.getResult());
    }

    @Test
    public void testPrettyPrintVisitorRectangle() {
        Rectangle rectangle = new Rectangle(4, 8);
        PrettyPrintVisitor prettyPrintVisitor = new PrettyPrintVisitor();
        rectangle.accept(prettyPrintVisitor);
        assertEquals("Rectangle 4.0 8.0", prettyPrintVisitor.getResult());
    }

    @Test
    public void testPrettyPrintVisitorTriangle() {
        TwoDimensionalVector a = new TwoDimensionalVector(0, 0);
        TwoDimensionalVector b = new TwoDimensionalVector(3, 0);
        TwoDimensionalVector c = new TwoDimensionalVector(0, 4);
        List<TwoDimensionalVector> vectors = new Vector<TwoDimensionalVector>();
        vectors.add(a);
        vectors.add(b);
        vectors.add(c);
        Triangle triangle = new Triangle(vectors);
        PrettyPrintVisitor prettyPrintVisitor = new PrettyPrintVisitor();
        triangle.accept(prettyPrintVisitor);
        assertEquals("Triangle [0,0] [3,0] [0,4]", prettyPrintVisitor.getResult());
    }

    @Test
    public void testPrettyPrintVisitorConvexPolygon() {
        List<TwoDimensionalVector> vectors = new Vector<>();
        vectors.add(new TwoDimensionalVector(0, 3));
        vectors.add(new TwoDimensionalVector(-5, 3));
        vectors.add(new TwoDimensionalVector(-5, -3));
        vectors.add(new TwoDimensionalVector(0, -3));
        vectors.add(new TwoDimensionalVector(4, 0));
        ConvexPolygon polygon = new ConvexPolygon(vectors);
        PrettyPrintVisitor prettyPrintVisitor = new PrettyPrintVisitor();
        polygon.accept(prettyPrintVisitor);
        assertEquals("ConvexPolygon [0,3] [-5,3] [-5,-3] [0,-3] [4,0]", prettyPrintVisitor.getResult());
    }

    @Test
    public void testPrettyPrintVisitorCompoundShapeEmpty() {
        CompoundShape compoundShape = new CompoundShape();
        PrettyPrintVisitor prettyPrintVisitor = new PrettyPrintVisitor();
        compoundShape.accept(prettyPrintVisitor);
        assertEquals("CompoundShape {}", prettyPrintVisitor.getResult());
    }

    @Test
    public void testPrettyPrintVisitorCompoundShapeNotEmpty() {
        CompoundShape compoundShape = new CompoundShape();
        compoundShape.add(new Rectangle(4, 8));
        compoundShape.add(new Circle(4));
        PrettyPrintVisitor prettyPrintVisitor = new PrettyPrintVisitor();
        compoundShape.accept(prettyPrintVisitor);
        assertEquals("CompoundShape {\n  Rectangle 4.0 8.0\n  Circle 4.0\n}", prettyPrintVisitor.getResult());
    }

    @Test
    public void testPrettyPrintVisitorCirclehasColor() {
        Circle circle = new Circle(4);
        ColoredShape coloredShape = new ColoredShape(circle, "RED");
        PrettyPrintVisitor prettyPrintVisitor = new PrettyPrintVisitor();
        coloredShape.accept(prettyPrintVisitor);
        assertEquals("\u001B[31mCircle 4.0\u001B[0m", prettyPrintVisitor.getResult());
    }

    @Test
    public void testPrettyPrintVisitorRectanglehasColor() {
        Rectangle rectangle = new Rectangle(4, 8);
        ColoredShape coloredShape = new ColoredShape(rectangle, "RED");
        PrettyPrintVisitor prettyPrintVisitor = new PrettyPrintVisitor();
        coloredShape.accept(prettyPrintVisitor);
        assertEquals("\u001B[31mRectangle 4.0 8.0\u001B[0m", prettyPrintVisitor.getResult());
    }

    @Test
    public void testPrettyPrintVisitorTrianglehasColor() {
        TwoDimensionalVector a = new TwoDimensionalVector(0, 0);
        TwoDimensionalVector b = new TwoDimensionalVector(3, 0);
        TwoDimensionalVector c = new TwoDimensionalVector(0, 4);
        List<TwoDimensionalVector> vectors = new Vector<TwoDimensionalVector>();
        vectors.add(a);
        vectors.add(b);
        vectors.add(c);
        Triangle triangle = new Triangle(vectors);
        ColoredShape coloredShape = new ColoredShape(triangle, "RED");
        PrettyPrintVisitor prettyPrintVisitor = new PrettyPrintVisitor();
        coloredShape.accept(prettyPrintVisitor);
        assertEquals("\u001B[31mTriangle [0,0] [3,0] [0,4]\u001B[0m", prettyPrintVisitor.getResult());
    }

    @Test
    public void testPrettyPrintVisitorConvexPolygonhasColor() {
        List<TwoDimensionalVector> vectors = new Vector<>();
        vectors.add(new TwoDimensionalVector(0, 3));
        vectors.add(new TwoDimensionalVector(-5, 3));
        vectors.add(new TwoDimensionalVector(-5, -3));
        vectors.add(new TwoDimensionalVector(0, -3));
        vectors.add(new TwoDimensionalVector(4, 0));
        ConvexPolygon polygon = new ConvexPolygon(vectors);
        ColoredShape coloredShape = new ColoredShape(polygon, "RED");
        PrettyPrintVisitor prettyPrintVisitor = new PrettyPrintVisitor();
        coloredShape.accept(prettyPrintVisitor);
        assertEquals("\u001B[31mConvexPolygon [0,3] [-5,3] [-5,-3] [0,-3] [4,0]\u001B[0m",
                prettyPrintVisitor.getResult());
    }

    @Test
    public void testPrettyPrintVisitorCompoundhasColor() {
        CompoundShape compoundShape = new CompoundShape();
        compoundShape.add(new Rectangle(4, 8));
        compoundShape.add(new Circle(4));
        ColoredShape coloredShape = new ColoredShape(compoundShape, "RED");
        PrettyPrintVisitor prettyPrintVisitor = new PrettyPrintVisitor();
        coloredShape.accept(prettyPrintVisitor);
        assertEquals("\u001B[31mCompoundShape {\n" + //
                "  Rectangle 4.0 8.0\n" + //
                "  Circle 4.0\n" + //
                "}\u001B[0m",
                prettyPrintVisitor.getResult());

    }
}
