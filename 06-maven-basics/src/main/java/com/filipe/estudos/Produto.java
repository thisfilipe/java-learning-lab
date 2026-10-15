package com.filipe.estudos;

public class Produto {
    private String nome;
    private double preco;
    private int quantidade;

    private static int totalCriados = 0;

    public Produto(String nome, double preco, int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        totalCriados++;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double valorTotal() {
        return preco * quantidade;
    }

    public static int getTotalCriados() {
        return totalCriados;
    }
}
