package org.ntut.posd2024f.shapes;

import java.util.Iterator;

/*The PrettyPrintVisitor class is to print the shape in a pretty format.


 */
public class PrettyPrintVisitor implements Visitor<String> {

    private StringBuilder result = new StringBuilder();

    @Override
    public void visitCircle(Circle circle) {
        result.append("Circle " + circle.getRadius());
    }

    @Override
    public void visitRectangle(Rectangle rectangle) {
        result.append("Rectangle " + rectangle.getLength() + " " + rectangle.getWidth());
    }

    @Override
    public void visitTriangle(Triangle triangle) {
        result.append("Triangle " + triangle.getVectors().toString());
    }

    @Override
    public void visitConvexPolygon(ConvexPolygon convexPolygon) {
        result.append("ConvexPolygon " + convexPolygon.getVectors().toString());
    }

    @Override
    public void visitCompoundShape(CompoundShape compoundShape) {
        Iterator<Shape> iterator = compoundShape.iterator();
        if (!iterator.hasNext()) {
            result.append("CompoundShape {}");
        } else {
            result.append("CompoundShape {");
            result.append("\n");
            while (iterator.hasNext()) {
                result.append("  ");
                iterator.next().accept(this);
                result.append("\n");
            }
            result.append("}");
        }
    }

    /* TextedShape: "Circle 1.0, text: Hello" */
    @Override
    public void visitTextedShape(TextedShape textedShape) {
        result.append("\"");
        textedShape.getShape().accept(this);
        result.append(", text: " + textedShape.getText() + "\"");
    }

    /* ColoredShape: \033[0;31mCircle 1.0\033[0m */
    @Override
    public void visitColoredShape(ColoredShape coloredShape) {
        result.append("\033[0;");
        switch (coloredShape.getColor()) {
            case "RED":
                result.append("31m");
                break;
            case "GREEN":
                result.append("32m");
                break;
            case "BLUE":
                result.append("34m");
                break;
        }
        coloredShape.getShape().accept(this);
        result.append("\033[0m");
    }

    @Override
    public String getResult() {
        return result.toString();
    }

}
