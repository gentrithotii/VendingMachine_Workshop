package org.example.model;

public abstract class Product {
    private int id;
    private double price;
    private String productName;



    public int getId() {
        return id;
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
