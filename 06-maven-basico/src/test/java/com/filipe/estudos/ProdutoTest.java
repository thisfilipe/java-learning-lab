package com.filipe.estudos;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertEquals;

public class ProdutoTest {
    private Produto produto;

    @Before
    public void setUp() {
        produto = new Produto("Produto A", 10.0, 5);
    }

    @Test
    public void testValorTotal() {
        assertEquals("Valor total do produto deve ser 50.0", 50.0, produto.valorTotal(), 0.0);
    }

    @Test
    public void testTotalCriados() {
        int totalAntes = Produto.getTotalCriados();
        new Produto("Produto B", 20.0, 3);
        assertEquals("Total de produtos criados deve aumentar em 1", totalAntes + 1, Produto.getTotalCriados());
    }
}
