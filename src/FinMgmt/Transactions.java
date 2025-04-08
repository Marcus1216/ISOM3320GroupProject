package FinMgmt;

import java.util.Date;
import java.time.LocalDate;
import java.util.Comparator;

public class Transactions {
    private static int idCounter = 1; // Static ID generator for transactions
    private int transactionID;
    private String transactionDate;  // import java.util.date
    private String transactionType; // Merged field from `TransactionType`
    private Accounts account; // Reference to an account
    private double amount;
    private String remarks;

    // Constructor for creating a transaction
    public Transactions(String transactionDate, String transactionType, Accounts account, double amount, String remarks) {
        this.transactionID = idCounter++; // Auto-generate unique transaction ID
        this.transactionDate = transactionDate;
        this.transactionType = transactionType; // The type of transaction (e.g., "Food", "Taxi")
        this.account = account;
        this.amount = amount;
        this.remarks = remarks;
    }
    //Getters


    // Display transaction details
    public void displayTransactionInfo() {
        System.out.printf(
                "Transaction ID: %d | Date: %s | Type: %s | Account ID: %d | Amount: %.2f | Remarks: %s%n",
                transactionID, transactionDate, transactionType, account.getAccountID(), amount, remarks
        );
    }
}

//Currency type?

