package com.filipe.estudos;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class CalculadoraTest {
    private Calculadora calculadora;

    @Before
    public void setUp() {
        calculadora = new Calculadora();
    }

    @Test
    public void testSomar() {
        int resultado = calculadora.somar(2, 3);
        assertEquals(5, resultado);
    }

    @Test
    public void testDividir() {
        assertEquals(5, calculadora.dividir(10, 2));
    }

    @Test(expected = ArithmeticException.class)
    public void testeDividirPorZero() {
        calculadora.dividir(10, 0);
    }
}
