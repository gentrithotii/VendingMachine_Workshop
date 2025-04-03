package org.example;

import org.example.model.*;

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

        VendingMachineMenu machineMenu = new VendingMachineMenu();
        machineMenu.setVendingMachine(vendingMachine);
        machineMenu.startMachineUi();

        //Machine only accepts 1, 2, 5, 10, 20, 50, 100, 200, 500, 1000
//        vendingMachine.addCurrency(1000);
//        System.out.println(vendingMachine.getBalance());
//        vendingMachine.addCurrency(50);
//        System.out.println(vendingMachine.getBalance());
//        vendingMachine.request(2);
//        vendingMachine.endSession();
//        System.out.println(vendingMachine.getBalance());
    }
}