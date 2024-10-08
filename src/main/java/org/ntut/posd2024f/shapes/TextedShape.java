package org.ntut.posd2024f.shapes;

import java.util.Iterator;

public class TextedShape implements Shape {
    private Shape shape;
    private String text;

    public TextedShape(Shape shape, String text) {
        this.text = text;
        this.shape = shape;
    }

    @Override
    public double area() {
        return getShape().area();
    }

    @Override
    public double perimeter() {
        return getShape().perimeter();
    }

    @Override
    public void add(Shape shape) {
        this.shape.add(shape);
    }

    @Override
    public Iterator<Shape> iterator() {
        return shape.iterator();
    }

    public Shape getShape() {
        return shape;
    }

    public String getText() {
        return text;
    }

    @Override
    public <T> void accept(Visitor<T> visitor) {
        visitor.visitTextedShape(this);
    }
}
