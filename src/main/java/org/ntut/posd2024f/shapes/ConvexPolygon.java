package org.ntut.posd2024f.shapes;

import java.util.List;

public class ConvexPolygon implements Shape {
    List<TwoDimensionalVector> vectors;

    public ConvexPolygon(List<TwoDimensionalVector> vectors) {
        if (!isSorted(vectors)) {
            throw new ShapeException("It's not a convex polygon!");
        }
        this.vectors = vectors;
    }

    public double area() {

        double area = 0;
        int n = vectors.size();

        for (int i = 0; i < n; i++) {
            TwoDimensionalVector current = vectors.get(i);
            TwoDimensionalVector next = vectors.get((i + 1) % n);
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

    private boolean isSorted(List<TwoDimensionalVector> vectors) {
        if (vectors.size() < 3) {
            return false;
        }
        boolean gotPositive = false;
        boolean gotNegative = false;
        for (int i = 0; i < vectors.size(); i++) {
            TwoDimensionalVector a = vectors.get(i);
            TwoDimensionalVector b = vectors.get((i + 1) % vectors.size());
            TwoDimensionalVector c = vectors.get((i + 2) % vectors.size());

            TwoDimensionalVector ab = b.subtract(a);
            TwoDimensionalVector bc = c.subtract(b);

            int crossProduct = ab.dot(bc);

            if (crossProduct > 0) {
                gotPositive = true;
            } else if (crossProduct < 0) {
                gotNegative = true;
            }

            if (gotPositive && gotNegative) {
                return false;
            }
        }

        return true;
    }

}
