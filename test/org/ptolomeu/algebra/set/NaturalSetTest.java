package org.ptolomeu.algebra.set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.ptolomeu.algebra.AlgebraException;

public class NaturalSetTest {

    private final NaturalSet a = NaturalSet.newInstance(15, 16, 17, 301, 302, 303);

    private final NaturalSet b = NaturalSet.newInstance(15, 16, 17);

    @Test(expected = AlgebraException.class)
    public void naturalNumericSetShouldNotHaveNegativeNumbers() {
        NaturalSet.newInstance(-1, -2, 3, 4, 5, 6, 7);
    }

    @Test
    public void testIsEmpty() {
        final NaturalSet empty = NaturalSet.newInstance();
        assertTrue(empty.isEmpty());
        assertFalse(a.isEmpty());
    }

    @Test
    public void testHas() {
        assertTrue(a.has(15));
        assertFalse(a.has(55));
    }

    @Test
    public void testContains() {
        assertTrue(a.contains(b));
        assertFalse(b.contains(a));
        assertFalse(a.contains(NaturalSet.newInstance(1, 2, 1981)));
    }

    @Test
    public void testUpper() {
        assertTrue(303 == a.upper());
    }

    @Test
    public void testLower() {
        assertTrue(15 == a.lower());
    }

    @Test
    public void testEqualsSimetry() {
        final NaturalSet a = NaturalSet.newInstance(10, 110, 1010);
        final NaturalSet b = NaturalSet.newInstance(10, 110, 1010);
        final NaturalSet c = NaturalSet.newInstance(82);
        assertEquals(a, b);
        assertEquals(b, a);
        assertFalse(a.equals(c));
        assertFalse(c.equals(a));
        assertFalse(b.equals(c));
        assertFalse(c.equals(b));
    }

}