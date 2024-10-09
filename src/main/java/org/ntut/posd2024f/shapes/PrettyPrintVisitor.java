package org.ntut.posd2024f.shapes;

import java.util.Iterator;

/*The PrettyPrintVisitor class is to print the shape in a pretty format.


 */
public class PrettyPrintVisitor implements Visitor<String> {

    private String result = "";

    public static String trimEnd(String value) {
        String END_SPACES_REGEX = "\\s+$";
        String EMPTY_STRING = "";
        return value.replaceFirst(END_SPACES_REGEX, EMPTY_STRING);
    }

    @Override
    public void visitCircle(Circle circle) {
        result += "Circle " + circle.getRadius();
    }

    @Override
    public void visitRectangle(Rectangle rectangle) {
        result += "Rectangle " + rectangle.getLength() + " " + rectangle.getWidth();
    }

    @Override
    public void visitTriangle(Triangle triangle) {
        result += "Triangle ";
        for (int i = 0; i < triangle.getVectors().size(); i++) {
            result += triangle.getVectors().get(i).toString() + " ";
        }
        result = trimEnd(result);
    }

    @Override
    public void visitConvexPolygon(ConvexPolygon convexPolygon) {
        result += "ConvexPolygon ";
        for (int i = 0; i < convexPolygon.getVectors().size(); i++) {
            result += convexPolygon.getVectors().get(i).toString() + " ";
        }
        result = trimEnd(result);
    }

    @Override
    public void visitCompoundShape(CompoundShape compoundShape) {
        Iterator<Shape> iterator = compoundShape.iterator();
        if (!iterator.hasNext()) {
            result += "CompoundShape {}";
        } else {
            result += "CompoundShape {";
            while (iterator.hasNext()) {
                Shape shape = iterator.next();
                String temp = "";
                PrettyPrintVisitor visitor = new PrettyPrintVisitor();
                shape.accept(visitor);
                if (shape.iterator().hasNext()) {
                    temp = "\n" + visitor.getResult();
                    temp = temp.replace("\n", "\n  ");
                    result += temp;

                } else {
                    result += "\n  " + visitor.getResult();
                }
            }
            result += "\n}";
        }
    }

    @Override
    public void visitTextedShape(TextedShape textedShape) {
        textedShape.getShape().accept(this);
        result += ", text: " + textedShape.getText();
    }

    @Override
    public void visitColoredShape(ColoredShape coloredShape) {
        switch (coloredShape.getColor()) {
            case "RED":
                result += "\u001B[0;31m";
                break;
            case "GREEN":
                result += "\u001B[0;32m";
                break;
            case "BLUE":
                result += "\u001B[0;34m";
                break;
        }
        coloredShape.getShape().accept(this);
        result += "\u001B[0m";
    }

    @Override
    public String getResult() {
        return result;
    }

}
