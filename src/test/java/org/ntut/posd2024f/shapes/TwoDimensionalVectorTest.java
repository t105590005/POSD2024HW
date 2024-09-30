package org.ntut.posd2024f.shapes;

import static org.junit.Assert.*;

import org.junit.Test;

public class TwoDimensionalVectorTest {

    @Test
    public void testTwoDimensionalVectorLength() {
        TwoDimensionalVector vector = new TwoDimensionalVector(3, 4);
        assertEquals(5, vector.length(), 0.001);
    }

    @Test
    public void testTwoDimensionalVectorDot() {
        TwoDimensionalVector vector1 = new TwoDimensionalVector(3, 4);
        TwoDimensionalVector vector2 = new TwoDimensionalVector(5, 6);
        assertEquals(39, vector1.dot(vector2), 0.001);
    }

    @Test
    public void testTwoDimensionalVectorCross() {
        TwoDimensionalVector vector1 = new TwoDimensionalVector(3, 4);
        TwoDimensionalVector vector2 = new TwoDimensionalVector(5, 6);
        assertEquals(-2, vector1.cross(vector2), 0.001);
    }

    @Test
    public void testTwoDimensionalVectorsubtract() {
        TwoDimensionalVector vector1 = new TwoDimensionalVector(3, 4);
        TwoDimensionalVector vector2 = new TwoDimensionalVector(5, 6);
        TwoDimensionalVector vector3 = vector1.subtract(vector2);
        assertEquals(-2, vector3.getX(), 0.001);
        assertEquals(-2, vector3.getY(), 0.001);
    }

}
