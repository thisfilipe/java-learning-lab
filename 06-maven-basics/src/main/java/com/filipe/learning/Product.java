package com.filipe.learning;

public class Product {
    private String name;
    private double price;
    private int quantity;

    private static int totalCreated = 0;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        totalCreated++;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public double totalValue() {
        return price * quantity;
    }

    public static int getTotalCreated() {
        return totalCreated;
    }
}
