package org.example;

import org.example.model.Candy;
import org.example.model.Snack;
import org.example.model.Soda;
import org.example.model.VendingMachine;

public class Main {
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();

        Snack snackChips = new Snack("Pringles Paprika", 29);
        Snack nuts = new Snack("Cashew nuts", 35);
        Candy candy = new Candy("Bilar Skum", 15);
        Soda soda = new Soda("Coca cola", 15);

        vendingMachine.addProductsToMachine(snackChips);
        vendingMachine.addProductsToMachine(nuts);
        vendingMachine.addProductsToMachine(candy);
        vendingMachine.addProductsToMachine(soda);

        vendingMachine.printAllProducts();

        vendingMachine.addCurrency(10);
        vendingMachine.addCurrency(30);


    }
}