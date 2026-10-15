package com.filipeleal.springbootaprendizado;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculadoraTest {
    private Calculadora calculadora = new Calculadora();

    @Test
    public void testSomar() {
        int resultado = calculadora.somar(2, 3);
        assertEquals(5, resultado);
    }
}
