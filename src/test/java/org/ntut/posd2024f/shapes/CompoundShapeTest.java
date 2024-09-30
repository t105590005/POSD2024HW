package org.ntut.posd2024f.shapes;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Vector;

import org.junit.Test;

public class CompoundShapeTest {

    @Test
    public void testCompoundShapeArea() throws Exception {
        List<TwoDimensionalVector> vectors = new Vector<>();
        vectors.add(new TwoDimensionalVector(0, 0));
        vectors.add(new TwoDimensionalVector(4, 0));
        vectors.add(new TwoDimensionalVector(0, 3));

        CompoundShape compoundShape = new CompoundShape();

        compoundShape.add(new Rectangle(4, 8));
        compoundShape.add(new Triangle(vectors));

        assertEquals(38, compoundShape.area(), 0.001);
    }

}
