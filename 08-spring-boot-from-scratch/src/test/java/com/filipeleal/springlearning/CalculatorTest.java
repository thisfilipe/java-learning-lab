package com.filipeleal.springlearning;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
    private Calculator calculator = new Calculator();

    @Test
    public void testAdd() {
        int result = calculator.add(2, 3);
        assertEquals(5, result);
    }
}
