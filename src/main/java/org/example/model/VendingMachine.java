package org.example.model;

import org.example.interfaces.IVendingMachine;

import java.util.Optional;

public class VendingMachine implements IVendingMachine {
    private Product[] products;
    private int depositPool;
    private final int[] validAmountOfMoney = {1, 2, 5, 10, 20, 50, 100, 200, 500, 1000};

    public VendingMachine(Product[] products) {
        setDepositPool(depositPool);
        setProducts(products != null ? products : new Product[0]);
    }

    public VendingMachine() {
        this(new Product[0]);
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

    private void setDepositPool(int depositPool) {
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
        int currentBalance = getBalance();
        for (int j : validAmountOfMoney) {
            if (amount == j) {
                setDepositPool(currentBalance + amount);
                found = true;
            }
        }
        String result = found ? "The balance is: " + getBalance() : "Wrong Amount machine only accepts 1, 2, 5, 10, 20, 50, 100, 200, 500, 1000 your current amount is: " + currentBalance;

        System.out.println(result);
    }

    @Override
    public int getBalance() {
        return depositPool;
    }

    @Override
    public Product request(int id) {
        int totalBalance = getBalance();
        Product newProd = null;
        for (int i = 0; i < this.products.length; i++) {
            if (this.products[i].getId() == id) {
                if (totalBalance >= this.products[i].getPrice()) {

                    setDepositPool(totalBalance -= (int) this.products[i].getPrice());
                    newProd = this.products[i];
                } else {

                    throw new ArithmeticException("You don't have enough balance you balance is:  " + getBalance());
                }
            }
        }
        return newProd;
    }

    //TODO Checkoverthis
    @Override
    public int endSession() {
        int oldBalance = getBalance();
        setDepositPool(0);
        if (oldBalance != 0) {
            return oldBalance;
        }
        return getBalance();
    }

    @Override
    public String getDescription(int id) {
        for (Product product : this.products) {
            if (product.getId() == id) {
                return product.toString();
            }
        }
        return "Product not found";
    }

    @Override
    public String[] getProducts() {
        return new String[0];
    }
}
