package org.ntut.posd2024f.shapes;

import java.lang.Math;
import java.util.List;

public class Triangle implements Shape {
    private TwoDimensionalVector v1;
    private TwoDimensionalVector v2;
    private TwoDimensionalVector v3;

    private List<TwoDimensionalVector> vectors;

    public Triangle(List<TwoDimensionalVector> vectors) throws ShapeException {
        if (vectors.size() != 3) {
            throw new ShapeException("It's not a triangle!");
        } else {
            v1 = vectors.get(0);
            v2 = vectors.get(1);
            v3 = vectors.get(2);
            double length1 = v1.subtract(v2).length();
            double length2 = v2.subtract(v3).length();
            double length3 = v3.subtract(v1).length();
            if (length1 + length2 > length3 && length2 + length3 > length1 && length3 + length1 > length2) {
                this.v1 = vectors.get(0);
                this.v2 = vectors.get(1);
                this.v3 = vectors.get(2);
                this.vectors = vectors;
            } else {
                throw new ShapeException("It's not a triangle!");
            }
        }

    }

    public double perimeter() {
        return v1.subtract(v2).length() + v2.subtract(v3).length() + v3.subtract(v1).length();

    }

    public double area() {
        double a = v1.subtract(v2).length();
        double b = v2.subtract(v3).length();
        double c = v3.subtract(v1).length();
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    public TwoDimensionalVector getV1() {
        return v1;
    }

    public TwoDimensionalVector getV2() {
        return v2;
    }

    public TwoDimensionalVector getV3() {
        return v3;
    }

    public List<TwoDimensionalVector> getVectors() {
        return vectors;
    }
}
