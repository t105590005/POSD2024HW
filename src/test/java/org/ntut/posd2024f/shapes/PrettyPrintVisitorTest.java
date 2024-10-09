package org.ntut.posd2024f.shapes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
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
        assertEquals("\u001B[0;31mCircle 4.0\u001B[0m", prettyPrintVisitor.getResult());
    }

    @Test
    public void testPrettyPrintVisitorRectanglehasColor() {
        Rectangle rectangle = new Rectangle(4, 8);
        ColoredShape coloredShape = new ColoredShape(rectangle, "RED");
        PrettyPrintVisitor prettyPrintVisitor = new PrettyPrintVisitor();
        coloredShape.accept(prettyPrintVisitor);
        assertEquals("\u001B[0;31mRectangle 4.0 8.0\u001B[0m", prettyPrintVisitor.getResult());
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
        assertEquals("\u001B[0;31mTriangle [0,0] [3,0] [0,4]\u001B[0m", prettyPrintVisitor.getResult());
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
        assertEquals("\u001B[0;31mConvexPolygon [0,3] [-5,3] [-5,-3] [0,-3] [4,0]\u001B[0m",
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
        assertEquals("\u001B[0;31mCompoundShape {\n" + //
                "  Rectangle 4.0 8.0\n" + //
                "  Circle 4.0\n" + //
                "}\u001B[0m",
                prettyPrintVisitor.getResult());

    }

    @Test
    public void testPrettyPrintVistorTripleCompoundShape() {
        ArrayList<TwoDimensionalVector> vectors = new ArrayList<TwoDimensionalVector>();
        vectors.add(new TwoDimensionalVector(4, 0));
        vectors.add(new TwoDimensionalVector(4, 3));
        vectors.add(new TwoDimensionalVector(0, 3));
        CompoundShape compound = new CompoundShape();
        compound.add(new Triangle(vectors));
        CompoundShape comCompound = new CompoundShape();
        comCompound.add(compound);
        ColoredShape colorShape1 = new ColoredShape(new Rectangle(3.0, 4.0), "BLUE");
        TextedShape textShape = new TextedShape(colorShape1, "this is a rectangle with blue color");
        comCompound.add(textShape);
        ColoredShape colorShape2 = new ColoredShape(comCompound, "GREEN");
        CompoundShape comComCompound = new CompoundShape();
        comComCompound.add(new Circle(3.0));
        comComCompound.add(colorShape2);

        PrettyPrintVisitor vistor = new PrettyPrintVisitor();
        comComCompound.accept(vistor);

        assertEquals("CompoundShape {\n" +
                "  Circle 3.0\n" +
                "  \u001B[0;32mCompoundShape {\n" +
                "    CompoundShape {\n" +
                "      Triangle [4,0] [4,3] [0,3]\n" +
                "    }\n" +
                "    \u001B[0;34mRectangle 3.0 4.0\u001B[0m, text: this is a rectangle with blue color\n" +
                "  }\u001B[0m\n" +
                "}", vistor.getResult());
    }

}
