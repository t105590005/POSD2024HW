package org.ntut.posd2024f.shapes;

import static org.junit.jupiter.api.Assertions.*;

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
        assertEquals("CompoundShape {\n  Rectangle 4.0 8.0\n  Circle 4.0\n}", prettyPrintVisitor.getResult());
    }

    @Test
    public void testPrettyPrintVisitorCirclehasColor() {
        Circle circle = new Circle(4);
        ColoredShape coloredShape = new ColoredShape(circle, "RED");
        PrettyPrintVisitor prettyPrintVisitor = new PrettyPrintVisitor();
        coloredShape.accept(prettyPrintVisitor);
        assertEquals("\033[0;31mCircle 4.0\033[0m", prettyPrintVisitor.getResult());
    }
}
