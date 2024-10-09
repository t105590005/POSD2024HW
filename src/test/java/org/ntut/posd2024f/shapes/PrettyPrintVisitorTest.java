package org.ntut.posd2024f.shapes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Vector;

import org.junit.jupiter.api.Test;

public class PrettyPrintVisitorTest {

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
        assertEquals("CompoundShape {  \n  Rectangle 4.0 8.0  \n  Circle 4.0\n}", prettyPrintVisitor.getResult());
    }

    @Test
    public void testPrettyPrintVisitorCirclehasColor() {
        Circle circle = new Circle(4);
        ColoredShape coloredShape = new ColoredShape(circle, "RED");
        PrettyPrintVisitor prettyPrintVisitor = new PrettyPrintVisitor();
        coloredShape.accept(prettyPrintVisitor);
        assertEquals("\033[0;31mCircle 4.0\033[0m", prettyPrintVisitor.getResult());
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
        Triangle t = new Triangle(vectors);
        PrettyPrintVisitor prettyPrintVisitor = new PrettyPrintVisitor();
        t.accept(prettyPrintVisitor);
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
}
