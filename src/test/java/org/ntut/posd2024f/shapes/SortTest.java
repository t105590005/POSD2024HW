package org.ntut.posd2024f.shapes;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Collections;

public class SortTest {
    @Test
    public void testSortByAreaAscending() throws Exception {
        ArrayList<Shape> shapes = new ArrayList<>();
        shapes.add(new Circle(2));
        shapes.add(new Rectangle(2, 3));
        shapes.add(new Triangle(3, 4, 5));

        Collections.sort(shapes, Sort.BY_AREA_ASCENDING);

        for (int i = 0; i < shapes.size() - 1; i++) {
            assertTrue(shapes.get(i).area() <= shapes.get(i + 1).area());
        }
    }

    @Test
    public void testSortByPerimeterDescending() throws Exception {
        ArrayList<Shape> shapes = new ArrayList<>();
        shapes.add(new Circle(2));
        shapes.add(new Rectangle(2, 3));
        shapes.add(new Triangle(3, 4, 5));

        Collections.sort(shapes, Sort.BY_PERIMETER_DESCENDING);

        for (int i = 0; i < shapes.size() - 1; i++) {
            assertTrue(shapes.get(i).perimeter() >= shapes.get(i + 1).perimeter());
        }
    }
}