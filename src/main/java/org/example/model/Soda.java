package org.example.model;

public class Soda extends Product {

    public Soda(String productName, double price) {
        setProductName(productName);
        setPrice(price);
    }

    public String examine() {
        return "Examining";
    }

    public String use() {
        return "Using";
    }

    public String toString() {
        return "Id: " + getId() + " Product Name: " + getProductName() + " Price: " + getPrice();
    }
}
