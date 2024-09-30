package org.ntut.posd2024f.shapes;

import static org.junit.Assert.*;

import org.junit.Test;

public class NullIteratorTest {

    @Test
    public void testNulliteratorHasNextReturn() {
        NullIterator nullIterator = new NullIterator();
        assertFalse(nullIterator.hasNext());
    }
}
