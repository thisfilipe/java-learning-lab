package com.filipeleal.springbootaprendizado;

import org.springframework.stereotype.Service;

@Service
public class Calculadora {
    public int somar(int a, int b) {
        return a + b;
    }
}
