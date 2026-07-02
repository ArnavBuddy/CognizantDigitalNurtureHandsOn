package com.bank.calculator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

/**
 * First JUnit test class, created to verify that JUnit has been set up
 * correctly in the project and that Calculator behaves as expected.
 */
public class CalculatorTest {

    private Calculator calculator;

    @Before
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void testAdd() {
        assertEquals(5, calculator.add(2, 3));
    }

    @Test
    public void testSubtract() {
        assertEquals(1, calculator.subtract(4, 3));
    }

    @Test
    public void testMultiply() {
        assertEquals(12, calculator.multiply(3, 4));
    }

    @Test
    public void testDivide() {
        assertEquals(2.5, calculator.divide(5, 2), 0.0001);
    }

    @Test
    public void testDivideByZeroThrowsException() {
        assertThrows(ArithmeticException.class, () -> calculator.divide(5, 0));
    }
}
