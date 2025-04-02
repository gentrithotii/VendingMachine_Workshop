package org.example.model;

import org.example.interfaces.IVendingMachine;

public class VendingMachine implements IVendingMachine {
    private Product[] products;
    private int depositPool;
    private int[] validAmountOfMoney = {1, 2, 5, 10, 20, 50, 100, 200, 500, 1000};

    public VendingMachine() {
        this(new Product[0]);
    }

    public VendingMachine(Product[] products) {
        setDepositPool(depositPool);
        setProducts(products != null ? products : new Product[0]);
    }

    public void addProductsToMachine(Product productToAdd) {
        Product[] newProductArray = new Product[this.products.length + 1];
        for (int i = 0; i < this.products.length; i++) {
            newProductArray[i] = this.products[i];
        }
        newProductArray[newProductArray.length - 1] = productToAdd;

        setProducts(newProductArray);
    }

    private void setProducts(Product[] products) {
        this.products = products;
    }

    public void setDepositPool(int depositPool) {
        this.depositPool = depositPool;
    }

    public void printAllProducts() {
        int counter = 0;
        for (Product product : this.products) {
            System.out.println(product);
            counter++;
        }
        System.out.println("Number of things: " + counter);
    }

    @Override
    public void addCurrency(int amount) {
        boolean found = false;
        amount += getBalance();
        for (int i = 0; i < validAmountOfMoney.length; i++) {
            if (validAmountOfMoney[i] == amount) {
                setDepositPool(amount);
                found = true;
                break;
            }
        }
        String result = found ? "The balance is: " + getBalance() : "Wrong Amount machine only accepts 1, 2, 5, 10, 20, 50, 100, 200, 500, 1000 ";

        System.out.println(result);
    }

    @Override
    public int getBalance() {
        return depositPool;
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
    public String[] getProducts() {
        return new String[0];
    }
}
