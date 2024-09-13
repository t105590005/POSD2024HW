package org.ntut.posd2024f.shapes;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TriangleTest {
    // Triangle t = new Triangle(...)
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testTriangleConstructorPositiveDimensions() throws Exception {
        Triangle t = new Triangle(3.0, 4.0, 5.0);
        assertEquals(3.0, t.a, 0.01);
        assertEquals(4.0, t.b, 0.01);
        assertEquals(5.0, t.c, 0.01);
    }

    @Test
    public void testTriangleConstructorZeroSidea() throws Exception {
        thrown.expect(Exception.class);
        thrown.expectMessage("It's not a triangle!");
        new Triangle(0, 4.0, 5.0);
    }

    @Test
    public void testTriangleConstructorZeroSideb() throws Exception {
        thrown.expect(Exception.class);
        thrown.expectMessage("It's not a triangle!");
        new Triangle(3.0, 0, 5.0);
    }

    @Test
    public void testTriangleConstructorZeroSidec() throws Exception {
        thrown.expect(Exception.class);
        thrown.expectMessage("It's not a triangle!");
        new Triangle(3.0, 4.0, 0);
    }

    @Test
    public void testTriangleConstructorNegativeSidea() throws Exception {
        thrown.expect(Exception.class);
        thrown.expectMessage("It's not a triangle!");
        new Triangle(-3.0, 4.0, 5.0);
    }

    @Test
    public void testTriangleConstructorNegativeSideb() throws Exception {
        thrown.expect(Exception.class);
        thrown.expectMessage("It's not a triangle!");
        new Triangle(3.0, -4.0, 5.0);
    }

    @Test
    public void testTriangleConstructorNegativeSidec() throws Exception {
        thrown.expect(Exception.class);
        thrown.expectMessage("It's not a triangle!");
        new Triangle(-3.0, 4.0, -5.0);
    }

    @Test
    public void testArea() throws Exception {
        Triangle t = new Triangle(3.0, 4.0, 5.0);
        assertEquals(6.0, t.area(), 0.01);
    }

    @Test
    public void testPerimeter() throws Exception {
        Triangle t = new Triangle(3.0, 4.0, 5.0);
        assertEquals(12.0, t.perimeter(), 0.01);
    }

    @Test
    public void testToString() throws Exception {
        Triangle t = new Triangle(3.0, 4.0, 5.0);
        assertEquals("Triangle " + t.a + " " + t.b + " " + t.c, t.toString());
    }
}