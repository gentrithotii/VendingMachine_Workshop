package org.example.model;

import java.util.Scanner;

public class VendingMachineMenu {
    private VendingMachine vendingMachine;
    private final Scanner sc;
    private boolean machineOn = true;
    private int returnAmount;
    private Product productItem;

    public VendingMachineMenu() {
        sc = new Scanner(System.in);
    }

    public Product getProductItem() {
        return productItem;
    }

    public void setProductItem(Product productItem) {
            this.productItem = productItem;
    }

    public int getReturnAmount() {
        return returnAmount;
    }

    public void setReturnAmount(int returnAmount) {
        this.returnAmount = returnAmount;
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

    private void printReturnAmount() {
        System.out.println("Amount returned: " + getReturnAmount());
        setReturnAmount(0);
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
        System.out.println("5  Clear item from cart");
        System.out.println("0. Exit");
        System.out.println(" ");
        if (getReturnAmount() != 0) {
            printReturnAmount();
        }
        System.out.println(printProductInCart());
        System.out.println(printCurrentBalance());

    }

    private int productToBuy() {

        System.out.print("Enter the product id of the product you want to buy: ");
        return sc.nextInt();
    }

    private int addAmount() {
        machineInfo();
        System.out.print("Enter the amount you want to add: ");
        return sc.nextInt();
    }

    private void resetProductChoice() {

    }

    private int userMenuChoice() {
        System.out.print("Enter your choice: ");
        return sc.nextInt();
    }

    private String printProductInCart() {
        return getProductItem() == null ? "No items in cart" : "This product is waiting to be purchased: " + getProductItem();
    }

    private void vendingMachineMenu() {
        int menuChoice = userMenuChoice();
        switch (menuChoice) {
            case 1:
                getVendingMachine().addCurrency(addAmount());
                break;
            case 2:
//                Product tempProd = getVendingMachine().request(productToBuy());
                printProductsToUser();
                setProductItem(getVendingMachine().request(productToBuy()));
                break;
            case 3:
                setProductItem(null);
                setReturnAmount(getVendingMachine().endSession());
                break;
            case 4:
                printProductsToUser();
                break;
            case 5:
                getVendingMachine().addCurrency((int) getProductItem().getPrice());
                setProductItem(null);
                break;
            case 0:
                setReturnAmount(getVendingMachine().endSession());
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