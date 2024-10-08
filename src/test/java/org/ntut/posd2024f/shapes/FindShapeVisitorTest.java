package org.ntut.posd2024f.shapes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class FindShapeVisitorTest {

    @Test
    public void testFindShapeVistitorCompoundShape() {
        CompoundShape compoundShape = new CompoundShape();
        FindShapeVisitor findShapeVisitor = new FindShapeVisitor(shape -> shape instanceof Circle);
        compoundShape.accept(findShapeVisitor);
        assertEquals(0, findShapeVisitor.getResult().size());
    }

}
