package com.cloudsuite.core.aop.services.implementations;

import java.util.Map;
import java.util.Map;
import java.util.HashMap;

public class PaymentService {
    private Map<String, Double> accounts;

    public PaymentService() {
        this.accounts = new HashMap<>();
    }


    public void recordAccountCreation(String accountId, double initialBalance) {
        if (!accounts.containsKey(accountId)) {
            accounts.put(accountId, initialBalance);
            System.out.println("Account created successfully for " + accountId);
        } else {
            System.out.println("Account already exists for " + accountId);
        }
    }


    public void recordPayment(String fromAccount, String toAccount, double amount) {
        // Payment recording logic can be added here, if needed
        // For simplicity, let's print a message
        System.out.println("Payment recorded: $" + amount + " from " + fromAccount + " to " + toAccount);
    }

    // Method to add an account with initial balance
    public void addAccount(String accountId, double initialBalance) {
        if (!accounts.containsKey(accountId)) {
            accounts.put(accountId, initialBalance);
            recordAccountCreation(accountId, initialBalance); // Call method from ContractService
        } else {
            System.out.println("Account already exists for " + accountId);
        }
    }

    // Method to make a payment from one account to another
    public void makePayment(String fromAccount, String toAccount, double amount) {
        if (accounts.containsKey(fromAccount) && accounts.containsKey(toAccount)) {
            double fromBalance = accounts.get(fromAccount);
            double toBalance = accounts.get(toAccount);

            if (fromBalance >= amount) {
                fromBalance -= amount;
                toBalance += amount;

                accounts.put(fromAccount, fromBalance);
                accounts.put(toAccount, toBalance);

                System.out.println("Payment of $" + amount + " from " + fromAccount + " to " + toAccount + " successful.");
                recordPayment(fromAccount, toAccount, amount); // Call method from ContractService
            } else {
                System.out.println("Insufficient funds in account " + fromAccount);
            }
        } else {
            System.out.println("One or both accounts do not exist.");
        }
    }

    // Method to get account balance
    public double getAccountBalance(String accountId) {
        if (accounts.containsKey(accountId)) {
            return accounts.get(accountId);
        } else {
            System.out.println("Account " + accountId + " does not exist.");
            return -1; // or throw an exception
        }
    }

    public static void main(String[] args) {
        PaymentService paymentService = new PaymentService();

        // Example usage
        paymentService.addAccount("A123", 1000);
        paymentService.addAccount("B456", 500);

        paymentService.makePayment("A123", "B456", 200);

        double balanceA = paymentService.getAccountBalance("A123");
        double balanceB = paymentService.getAccountBalance("B456");

        System.out.println("Account A123 balance: $" + balanceA);
        System.out.println("Account B456 balance: $" + balanceB);
    }

}
