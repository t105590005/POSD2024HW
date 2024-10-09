package org.ntut.posd2024f.shapes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class FindShapeVisitor implements Visitor<List<Shape>> {
    private Predicate<Shape> predicate;
    private List<Shape> result;

    public FindShapeVisitor(Predicate<Shape> condition) {
        this.predicate = condition;
        result = new ArrayList<>();
    }

    @Override
    public void visitCircle(Circle circle) {
        if (predicate.test(circle)) {
            result.add(circle);
        }
    }

    @Override
    public void visitRectangle(Rectangle rectangle) {
        if (predicate.test(rectangle)) {
            result.add(rectangle);
        }
    }

    @Override
    public void visitTriangle(Triangle triangle) {
        if (predicate.test(triangle)) {
            result.add(triangle);
        }
    }

    @Override
    public void visitConvexPolygon(ConvexPolygon convexPolygon) {
        if (predicate.test(convexPolygon)) {
            result.add(convexPolygon);
        }

    }

    @Override
    public void visitCompoundShape(CompoundShape compoundShape) {
        if (predicate.test(compoundShape)) {
            result.add(compoundShape);
        }
        Iterator<Shape> iterator = compoundShape.iterator();
        while (iterator.hasNext()) {
            Shape shape = iterator.next();
            FindShapeVisitor visitor = new FindShapeVisitor(predicate);
            shape.accept(visitor);
            result.add(shape);
        }
    }

    @Override
    public void visitTextedShape(TextedShape textedShape) {
        if (predicate.test(textedShape)) {
            result.add(textedShape);
        }
        if (predicate.test(textedShape.getShape())) {
            result.add(textedShape.getShape());
        }
    }

    @Override
    public void visitColoredShape(ColoredShape coloredShape) {
        if (predicate.test(coloredShape)) {
            result.add(coloredShape);
        }
        if (predicate.test(coloredShape.getShape())) {
            result.add(coloredShape.getShape());
        }
    }

    public List<Shape> getResult() {
        return result;
    }
}
