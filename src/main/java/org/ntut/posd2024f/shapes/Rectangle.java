package org.ntut.posd2024f.shapes;

public class Rectangle implements Shape {
    double length;
    double width;

    public Rectangle(double length, double width) throws Exception {
        if (length <= 0 || width <= 0) {
            throw new Exception("It's not a rectangle!");
        }
        this.length = length;
        this.width = width;
    }

    @Override
    public double area() {
        return length * width;
    }

    @Override
    public double perimeter() {
        return (length + width) * 2;
    }

    @Override
    public String toString() {
        return String.format("Rectangle " + length + " " + width);
    }
}