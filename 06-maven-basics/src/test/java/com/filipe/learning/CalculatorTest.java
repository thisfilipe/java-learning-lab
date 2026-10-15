package com.filipe.learning;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
    private Calculator calculator;

    @Before
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void testAdd() {
        int result = calculator.add(2, 3);
        assertEquals(5, result);
    }

    @Test
    public void testDivide() {
        assertEquals(5, calculator.divide(10, 2));
    }

    @Test(expected = ArithmeticException.class)
    public void testDivideByZero() {
        calculator.divide(10, 0);
    }
}
