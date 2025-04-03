package org.example.model;

import java.util.Scanner;

public class VendingMachineMenu {
    private VendingMachine vendingMachine;
    private final Scanner sc;
    private boolean machineOn = true;

    public VendingMachineMenu() {
        sc = new Scanner(System.in);
    }

    public void setVendingMachine(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    public VendingMachine getVendingMachine() {
        return vendingMachine;
    }

    public void startMachineUi() {
        while (machineOn) {
            printChoiceMenu();
            vendingMachineMenu();
        }
    }

    private void machineInfo() {
        System.out.println("The machine only takes these kind of money ( 1, 2, 5, 10, 20, 50, 100, 200, 500, 1000 ");
    }

    private String printCurrentBalance() {
        return "Your current have : " + getVendingMachine().getBalance() + " money in the machine.";
    }

    private void printProductsToUser() {
        for (String products : getVendingMachine().getProducts()) {
            System.out.println(products);
        }
    }

    private void printChoiceMenu() {
        System.out.println("1. Add money ");
        System.out.println("2. Request to buy with given id");
        System.out.println("3. Buy the thing you wanted");
        System.out.println("4. Print all products");
        System.out.println("0. Exit");
        System.out.println(" ");
        System.out.println(printCurrentBalance());
    }

    private int productToBuy() {
        printProductsToUser();
        System.out.print("Enter the product you want to buy");
        return sc.nextInt();
    }

    private int addAmount() {
        machineInfo();
        System.out.print("Enter the amount you want to add: ");
        return sc.nextInt();
    }

    private int userMenuChoice() {
        System.out.print("Enter your choice: ");
        return sc.nextInt();
    }

    private void vendingMachineMenu() {
        int menuChoice = userMenuChoice();
        switch (menuChoice) {
            case 1:
                getVendingMachine().addCurrency(addAmount());
                break;
            case 2:
                getVendingMachine().request(productToBuy());
                break;
            case 3:
                getVendingMachine().endSession();
            case 4:
                printProductsToUser();
                break;
            case 0:
                machineOn = false;
                break;
            default:
                System.out.println("Wrong menu choice");
        }
        if (menuChoice == 0) {
            System.out.println("Bye have a great time ");
        }
    }
}