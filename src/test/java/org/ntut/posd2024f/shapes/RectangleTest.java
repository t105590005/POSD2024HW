package org.ntut.posd2024f.shapes;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class RectangleTest {
    // e.g. Rectangle r = new rectangle(...)
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testRectangleConstructorPositiveDimensions() throws Exception {
        Rectangle r = new Rectangle(5.0, 6.0);
        assertEquals(5.0, r.length, 0.01);
        assertEquals(6.0, r.width, 0.01);
    }

    @Test
    public void testRectangleConstructorZeroWidth() throws Exception {
        thrown.expect(Exception.class);
        thrown.expectMessage("It's not a rectangle!");
        new Rectangle(0, 6.0);
    }

    @Test
    public void testRectangleConstructorZeroHeight() throws Exception {
        thrown.expect(Exception.class);
        thrown.expectMessage("It's not a rectangle!");
        new Rectangle(5.0, 0);
    }

    @Test
    public void testRectangleConstructorNegativeWidth() throws Exception {
        thrown.expect(Exception.class);
        thrown.expectMessage("It's not a rectangle!");
        new Rectangle(-5.0, 6.0);
    }

    @Test
    public void testRectangleConstructorNegativeLength() throws Exception {
        thrown.expect(Exception.class);
        thrown.expectMessage("It's not a rectangle!");
        new Rectangle(5.0, -6.0);
    }

    @Test
    public void testArea() throws Exception {
        Rectangle r = new Rectangle(5.0, 6.0);
        assertEquals(30.0, r.area(), 0.01);
    }

    @Test
    public void testPerimeter() throws Exception {
        Rectangle r = new Rectangle(5.0, 6.0);
        assertEquals(22.0, r.perimeter(), 0.01);
    }

    @Test
    public void testToString() throws Exception {
        Rectangle r = new Rectangle(5.0, 6.0);
        assertEquals("Rectangle " + r.length + " " + r.width, r.toString());
    }
}