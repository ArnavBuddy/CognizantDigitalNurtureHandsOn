package com.bank.assertions;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

/**
 * Demonstrates the most commonly used JUnit 4 assertions.
 */
public class AssertionsTest {

    @Test
    public void testAssertions() {
        // Assert equals
        assertEquals(5, 2 + 3);

        // Assert true
        assertTrue(5 > 3);

        // Assert false
        assertFalse(5 < 3);

        // Assert null
        assertNull(null);

        // Assert not null
        assertNotNull(new Object());
    }

    @Test
    public void testMoreAssertions() {
        String a = "junit";
        String b = "junit";
        Object obj = new Object();

        // Assert equals with a delta, for floating point comparisons
        assertEquals(0.3, 0.1 + 0.2, 0.0001);

        // Assert array equals
        assertArrayEquals(new int[] {1, 2, 3}, new int[] {1, 2, 3});

        // Assert same: both references point to the same interned String object
        assertSame(a, b);

        // Assert not same: two distinct Object instances are never the same reference
        assertNotSame(obj, new Object());
    }
}
