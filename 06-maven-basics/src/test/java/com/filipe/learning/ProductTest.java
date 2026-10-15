package com.filipe.learning;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertEquals;

public class ProdutoTest {
    private Product product;

    @Before
    public void setUp() {
        product = new Product("Product A", 10.0, 5);
    }

    @Test
    public void testTotalValue() {
        assertEquals("Valor total do product deve ser 50.0", 50.0, product.totalValue(), 0.0);
    }

    @Test
    public void testTotalCreated() {
        int totalBefore = Product.getTotalCreated();
        new Product("Product B", 20.0, 3);
        assertEquals("Created product count should increase by 1", totalBefore + 1, Product.getTotalCreated());
    }
}
