package FinMgmt;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Accounts {
    private static int idCounter = 1; // Static ID generator
    private int accountID;
    private String currencyType;
    private double balance;

    // Constructor for creating accounts
    public Accounts(String currencyType, double balance) {
        this.accountID = idCounter++; // Auto-generate unique account ID
        this.currencyType = currencyType;
        this.balance = balance;
    }

    // Getters
    public int getAccountID() {
        return accountID;
    }

    public String getCurrencyType() {
        return currencyType;
    }

    public double getBalance() {
        return balance;
    }

    // Add to balance
    public void addToBalance(double amount) {
        this.balance += amount;
    }

    // Subtract from balance
    public void deductFromBalance(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            this.balance -= amount;
        }
    }

    // Display account details
    public void displayAccountInfo() {
        System.out.printf("Account ID: %d | Currency: %s | Balance: %.2f%n", accountID, currencyType, balance);
    }
}
