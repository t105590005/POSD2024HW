package org.ntut.posd2024f.shapes;

public class Rectangle implements Shape {
    double length;
    double width;

    public Rectangle(double length, double width) throws ShapeException {
        if (length <= 0 || width <= 0) {
            throw new ShapeException("It's not a rectangle!");
        }
        this.length = length;
        this.width = width;
    }

    public double area() {
        return length * width;
    }

    public double perimeter() {
        return (length + width) * 2;
    }
}