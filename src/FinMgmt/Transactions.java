package FinMgmt;

import java.time.LocalDate;
import java.util.Comparator;

public class Transactions {
    private static int idCounter = 1; // Static ID generator for transactions
    private int transactionID;
    private LocalDate transactionDate;  // import java.util.date
    private String transactionType; // Merged field from `TransactionType`
    private Accounts account; // Reference to an account
    private double amount;
    private String remarks;

    // Constructor for creating a transaction
    public Transactions(LocalDate transactionDate, String transactionType, Accounts account, double amount, String remarks) {
        this.transactionID = idCounter++; // Auto-generate unique transaction ID
        this.transactionDate = transactionDate;
        this.transactionType = transactionType; // The type of transaction (e.g., "Food", "Taxi")
        this.account = account;
        this.amount = amount;
        this.remarks = remarks;
    }
    //Getters
    public int getTransID(){
        return transactionID;
    }

    public LocalDate getTransDate(){
        return transactionDate;
    }

    public String getTransType(){
        return transactionType;
    }

    public Accounts getTransAccounts(){
        return account;
    }

    public double getAmount(){
        return amount;
    }

    public String getRemarks(){
        return remarks;
    }

    public static Comparator<Transactions> TransDateComparator = new Comparator<Transactions>() {
        public int compare(Transactions t1, Transactions t2){
            LocalDate TransDate1 = t1.getTransDate();
            LocalDate TransDate2 = t2.getTransDate();
            return TransDate1.compareTo(TransDate2);
        }
    };

    public static Comparator<Transactions> TransTypeComparator = new Comparator<Transactions>() {
        public int compare(Transactions t1, Transactions t2){
            String TransType1 = t1.getTransType();
            String TransType2 = t2.getTransType();
            return TransType1.compareTo(TransType2);
        }
    };

    public static Comparator<Transactions> TransAccComparator = new Comparator<Transactions>() {
        public int compare(Transactions t1, Transactions t2){
            int TransAccID1 = t1.getTransAccounts().getAccountID();
            int TransAccID2 = t2.getTransAccounts().getAccountID();
            return TransAccID1 - TransAccID2;
        }
    };

    public static Comparator<Transactions> TransAmtComparator = new Comparator<Transactions>() {
        public int compare(Transactions t1, Transactions t2){
            double TransAmt1 = t1.getAmount();
            double TransAmt2 = t2.getAmount();
            return (int) (TransAmt1 - TransAmt2);
        }
    };

    public static Comparator<Transactions> TransIDComparator = new Comparator<Transactions>() {
        public int compare(Transactions t1, Transactions t2){
            int TransID1 = t1.getTransID();
            int TransID2 = t2.getTransID();
            return TransID1 - TransID2;
        }
    };

    // Display transaction details
    public void displayTransactionInfo() {
        System.out.printf(
                "Transaction ID: %d | Date: %s | Type: %s | Account ID: %d | Amount: %.2f | Remarks: %s%n",
                transactionID, transactionDate, transactionType, account.getAccountID(), amount, remarks
        );
    }
}

//Currency type?

