package org.ntut.posd2024f.shapes;

import java.util.ArrayList;
import java.util.Iterator;

public class CompoundShape implements Shape {
    private ArrayList<Shape> shapes = new ArrayList<Shape>();

    public CompoundShape() {
    }

    public double area() {
        double totalArea = 0;
        for (Shape shape : shapes) {
            totalArea += shape.area();
        }
        return totalArea;
    }

    public double perimeter() {
        double totalPerimeter = 0;
        for (Shape shape : shapes) {
            totalPerimeter += shape.perimeter();
        }
        return totalPerimeter;
    }

    @Override
    public void add(Shape shape) {
        shapes.add(shape);
    }

    @Override
    public Iterator<Shape> iterator() {
        return shapes.iterator();
    }

    @Override
    public <T> void accept(Visitor<T> visitor) {
        visitor.visitCompoundShape(this);
    }
}
