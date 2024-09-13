package org.ntut.posd2024f.shapes;

import java.lang.Math;

public class Triangle implements Shape {
    double a;
    double b;
    double c;

    Triangle(double a, double b, double c) throws Exception {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new Exception("It's not a triangle!");
        }
        if (a + b <= c || b + c <= a || a + c <= b) {
            throw new Exception("It's not a triangle!");
        }
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double perimeter() {
        return a + b + c;
    }

    public double area() {
        double s = perimeter() / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    public String toString() {
        return String.format("Triangle " + a + " " + b + " " + c);
    }
}
