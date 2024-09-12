package org.ntut.posd2024f.shapes;

public class Circle implements Shape {
    double radius;

    public Circle(double radius) throws Exception {
        if (radius <= 0) {
            throw new Exception("It's not a circle!");
        }
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public double perimeter() {
        return Math.PI * radius * 2;
    }

    @Override
    public String toString() {
        return String.format("Circle " + radius);
    }
}
