package org.ntut.posd2024f.shapes;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class SortTest {

    @Test
    public void testSortByAreaAscending() throws Exception {
        List<TwoDimensionalVector> vectors = new Vector<>();
        vectors.add(new TwoDimensionalVector(0, 0));
        vectors.add(new TwoDimensionalVector(4, 0));
        vectors.add(new TwoDimensionalVector(0, 3));

        ArrayList<Shape> shapes = new ArrayList<>();
        shapes.add(new Circle(4.8));
        shapes.add(new Rectangle(4, 8));
        shapes.add(new Triangle(vectors));

        Collections.sort(shapes, Sort.BY_AREA_ASCENDING);

        for (int i = 0; i < shapes.size() - 1; i++) {
            assertTrue(shapes.get(i).area() <= shapes.get(i + 1).area());
        }
    }

    @Test
    public void testSortByAreaDescending() throws Exception {
        List<TwoDimensionalVector> vectors = new Vector<>();
        vectors.add(new TwoDimensionalVector(0, 0));
        vectors.add(new TwoDimensionalVector(4, 0));
        vectors.add(new TwoDimensionalVector(0, 3));

        ArrayList<Shape> shapes = new ArrayList<>();
        shapes.add(new Circle(4.8));
        shapes.add(new Rectangle(4, 8));
        shapes.add(new Triangle(vectors));

        Collections.sort(shapes, Sort.BY_AREA_DESCENDING);

        for (int i = 0; i < shapes.size() - 1; i++) {
            assertTrue(shapes.get(i).area() >= shapes.get(i + 1).area());
        }
    }

    @Test
    public void testSortByPerimeterAscending() throws Exception {
        List<TwoDimensionalVector> vectors = new Vector<>();
        vectors.add(new TwoDimensionalVector(0, 0));
        vectors.add(new TwoDimensionalVector(4, 0));
        vectors.add(new TwoDimensionalVector(0, 3));

        ArrayList<Shape> shapes = new ArrayList<>();
        shapes.add(new Circle(4.8));
        shapes.add(new Rectangle(4, 8));
        shapes.add(new Triangle(vectors));

        Collections.sort(shapes, Sort.BY_PERIMETER_ASCENDING);

        for (int i = 0; i < shapes.size() - 1; i++) {
            assertTrue(shapes.get(i).perimeter() <= shapes.get(i + 1).perimeter());
        }
    }

    @Test
    public void testSortByPerimeterDescending() throws Exception {
        List<TwoDimensionalVector> vectors = new Vector<>();
        vectors.add(new TwoDimensionalVector(0, 0));
        vectors.add(new TwoDimensionalVector(4, 0));
        vectors.add(new TwoDimensionalVector(0, 3));

        ArrayList<Shape> shapes = new ArrayList<>();
        shapes.add(new Circle(4.8));
        shapes.add(new Rectangle(4, 8));
        shapes.add(new Triangle(vectors));

        Collections.sort(shapes, Sort.BY_PERIMETER_DESCENDING);

        for (int i = 0; i < shapes.size() - 1; i++) {
            assertTrue(shapes.get(i).perimeter() >= shapes.get(i + 1).perimeter());
        }
    }
}