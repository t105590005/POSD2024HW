package org.ntut.posd2024f.shapes;

public class Rectangle implements Shape {
    double length;
    double width;

    public Rectangle(double length, double width) throws Exception {
        if (width <= 0 || length <= 0) {
            throw new Exception("Width and length must be positive");
        }
        this.width = width;
        this.length = length;
    }

    @Override
    public double area() {
        return width * length;
    }

    @Override
    public double perimeter() {
        return (width + length) * 2;
    }

    @Override
    public String toString() {
        return String.format("Rectangle " + width + " " + length);
    }
}