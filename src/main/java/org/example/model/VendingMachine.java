package org.example.model;

import org.example.interfaces.IVendingMachine;

public class VendingMachine implements IVendingMachine {
    private Product[] products;
    private int depositPool;


    @Override
    public void addCurrency(double amount) {

    }

    @Override
    public int getBalance() {
        return 0;
    }

    @Override
    public Product request(int id) {
        return null;
    }

    @Override
    public int endSession() {
        return 0;
    }

    @Override
    public String getDescription(int id) {
        return "";
    }

    @Override
    public Product[] getProducts() {
        return new Product[0];
    }
}
