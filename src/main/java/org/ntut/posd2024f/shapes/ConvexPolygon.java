package org.ntut.posd2024f.shapes;

import java.util.List;

public class ConvexPolygon implements Shape {
    List<TwoDimensionalVector> vectors;

    public ConvexPolygon(List<TwoDimensionalVector> vectors) {
        if (!isConvex(vectors)) {
            throw new ShapeException("It's not a convex polygon!");
        }
        this.vectors = vectors;
    }

    public double area() {

        double area = 0;

        for (int i = 0; i < vectors.size(); i++) {
            TwoDimensionalVector current = vectors.get(i);
            TwoDimensionalVector next = vectors.get((i + 1) % vectors.size());
            area += current.getX() * next.getY() - current.getY() * next.getX();
        }

        area = Math.abs(area) / 2.0;
        return area;

    }

    public double perimeter() {
        double perimeter = 0;
        for (int i = 0; i < vectors.size(); i++) {
            TwoDimensionalVector a = vectors.get(i);
            TwoDimensionalVector b = vectors.get((i + 1) % vectors.size());
            perimeter += a.subtract(b).length();
        }
        return perimeter;
    }

    private boolean isConvex(List<TwoDimensionalVector> vectors) {
        if (vectors.size() < 3) {
            return false;
        }
        boolean clockwise = false;
        boolean counterclockwise = false;

        for (int i = 0; i < vectors.size(); i++) {
            TwoDimensionalVector a = vectors.get(i);
            TwoDimensionalVector b = vectors.get((i + 1) % vectors.size());
            TwoDimensionalVector c = vectors.get((i + 2) % vectors.size());

            int crossProduct = crossProduct(a, b, c);

            if (crossProduct > 0) {
                clockwise = true;
            } else if (crossProduct < 0) {
                counterclockwise = true;
            }

            if (clockwise && counterclockwise) {
                return false;
            }
        }

        return true;
    }

    private int crossProduct(TwoDimensionalVector a, TwoDimensionalVector b, TwoDimensionalVector c) {
        TwoDimensionalVector ab = a.subtract(b);
        TwoDimensionalVector bc = b.subtract(c);
        int crossProduct = ab.cross(bc);
        return crossProduct;
    }

}
