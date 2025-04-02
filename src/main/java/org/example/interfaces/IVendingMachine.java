package org.example.interfaces;

import org.example.model.Product;

public interface IVendingMachine {
    void addCurrency(double amount);

    int getBalance();

    Product request(int id);

    int endSession();

    String getDescription(int id);

    Product[] getProducts();
}
