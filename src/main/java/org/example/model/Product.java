package org.example.model;

public abstract class Product {
    private static int sequencer;
    private final int id;
    private double price;
    private String productName;


    public Product() {
        this.id = getNextId();
    }

    public int getId() {
        return id;
    }

    private int getNextId() {
        return ++sequencer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    abstract String examine();

    abstract String use();
}
