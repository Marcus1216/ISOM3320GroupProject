package FinMgmt;

import java.util.ArrayList;
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
        System.out.println("\nSelect the currency type:");
        System.out.println("1. HKD");
        System.out.println("2. USD");
        System.out.println("3. EUR");
        System.out.print("Enter your choice (1-3): ");
        int currencyChoice = scanner.nextInt();

        String currencyType;
        switch (currencyChoice) {
            case 1:
                currencyType = "HKD";
                break;
            case 2:
                currencyType = "USD";
                break;
            case 3:
                currencyType = "EUR";
                break;
            default:
                System.out.println("Invalid currency! Defaulting to 'HKD'.");
                currencyType = "HKD";
        }

        System.out.println("Enter the initial balance: ");
        double balance = scanner.nextDouble();
        if (balance < 0) {
            System.out.println("Initial balance cannot be negative! Setting to 0.");
            balance = 0;
        }

        Accounts account = new Accounts(currencyType, balance);
        accountsList.add(account); // Add the new account to the ArrayList

        System.out.println("Account created successfully!");
        account.displayAccountInfo();
    }

    // Method to create a new transaction
    public static void createTransaction() {
        if (accountsList.isEmpty()) {
            System.out.println("No accounts exist! Please create an account first.");
            return;
        }

        System.out.println("\nEnter the transaction date (e.g., YYYY-MM-DD): ");
        String date = scanner.next();

        // Display transaction type options
        System.out.println("Select the transaction type:");
        System.out.println("1. Education");
        System.out.println("2. Transportation");
        System.out.println("3. Food");
        System.out.println("4. Other");
        System.out.println("5. Shopping");
        System.out.print("Enter your choice (1-5): ");
        int typeChoice = scanner.nextInt();

        String type;
        switch (typeChoice) {
            case 1:
                type = "Education";
                break;
            case 2:
                type = "Transportation";
                break;
            case 3:
                type = "Food";
                break;
            case 4:
                type = "Other";
                break;
            case 5:
                type = "Shopping";
                break;
            default:
                System.out.println("Invalid choice! Defaulting to 'Other'.");
                type = "Other";
        }

        System.out.println("Enter the account ID: ");
        int accountID = scanner.nextInt();

        // Check if account exists
        Accounts account = findAccountByID(accountID);
        if (account == null) {
            System.out.println("Error: Account with ID " + accountID + " does not exist!");
            return;
        }

        System.out.println("Enter the transaction amount: ");
        double amount = scanner.nextDouble();
        if (amount <= 0) {
            System.out.println("Error: Transaction amount must be positive!");
            return;
        }

        // Check if balance is sufficient
        if (amount > account.getBalance()) {
            System.out.println("Error: Transaction amount (" + amount + ") exceeds account balance (" + account.getBalance() + ")!");
            return;
        }

        System.out.println("Enter remarks for the transaction: ");
        scanner.nextLine(); // Clear the newline
        String remarks = scanner.nextLine();

        // Deduct from balance and create transaction
        account.deductFromBalance(amount); // This already has its own insufficient balance check, but we checked earlier too
        Transactions transaction = new Transactions(date, type, account, amount, remarks);
        transactionsList.add(transaction); // Add the new transaction to the ArrayList

        System.out.println("Transaction created successfully!");
        transaction.displayTransactionInfo();
    }

    // Method to display all accounts
    public static void displayAccounts() {
        if (accountsList.isEmpty()) {
            System.out.println("\nNo accounts to display.");
        } else {
            System.out.println("\nAccounts:");
            for (Accounts account : accountsList) {
                account.displayAccountInfo();
            }
        }
    }

    // Method to display all transactions
    public static void displayTransactions() {
        if (transactionsList.isEmpty()) {
            System.out.println("\nNo transactions to display.");
        } else {
            System.out.println("\nTransactions:");
            for (Transactions transaction : transactionsList) {
                transaction.displayTransactionInfo();
            }
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