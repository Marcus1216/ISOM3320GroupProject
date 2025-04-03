package FinMgmt;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {
    private static ArrayList<Accounts> accountsList = new ArrayList<>(); // ArrayList to store accounts
    private static ArrayList<Transactions> transactionsList = new ArrayList<>(); // ArrayList to store transactions

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nFinance Management System");
            System.out.println("1. Create Account");
            System.out.println("2. Create Transaction");
            System.out.println("3. Display Accounts");
            System.out.println("4. Display Transactions");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> createAccount();
                case 2 -> createTransaction();
                case 3 -> displayAccounts();
                case 4 -> displayTransactions();
                case 5 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    // Method to create a new account
    public static void createAccount() {
        System.out.println("\nEnter the currency type (e.g., HKD, USD): ");
        String currencyType = scanner.next();
        System.out.println("Enter the initial balance: ");
        double balance = scanner.nextDouble();

        Accounts account = new Accounts(currencyType, balance);
        accountsList.add(account); // Add the new account to the ArrayList

        System.out.println("Account created successfully!");
        account.displayAccountInfo();
    }

    // Method to create a new transaction
    public static void createTransaction() {
        System.out.println("\nEnter the transaction date (e.g., YYYY-MM-DD): ");
        String date = scanner.next();
        System.out.println("Enter the transaction type (e.g., Food, Taxi): ");
        String type = scanner.next();
        System.out.println("Enter the account ID: ");
        int accountID = scanner.nextInt();
        System.out.println("Enter the transaction amount: ");
        double amount = scanner.nextDouble();
        System.out.println("Enter remarks for the transaction: ");
        scanner.nextLine(); // Clear the newline
        String remarks = scanner.nextLine();

        // Find the account by ID
        Accounts account = findAccountByID(accountID);
        if (account != null) {
            account.deductFromBalance(amount);
            Transactions transaction = new Transactions(date, type, account, amount, remarks);
            transactionsList.add(transaction); // Add the new transaction to the ArrayList

            System.out.println("Transaction created successfully!");
            transaction.displayTransactionInfo();
        } else {
            System.out.println("Account not found!");
        }
    }

    // Method to display all accounts
    public static void displayAccounts() {
        System.out.println("\nAccounts:");
        for (Accounts account : accountsList) {
            account.displayAccountInfo();
        }
    }

    // Method to display all transactions
    public static void displayTransactions() {
        System.out.println("\nTransactions:");
        for (Transactions transaction : transactionsList) {
            transaction.displayTransactionInfo();
        }
    }

    // Utility method to find an account by ID
    private static Accounts findAccountByID(int accountID) {
        for (Accounts account : accountsList) {
            if (account.getAccountID() == accountID) {
                return account;
            }
        }
        return null;
    }
}
// rundown for how the process should work
// choose (possible) option
//1) create account
//2) create transaction
//3) display with sorting func (talk at friday)
