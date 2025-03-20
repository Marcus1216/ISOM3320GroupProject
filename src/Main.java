//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;
public class Accounts {
    int accountID;
    String currencyType;
    double balance;
    //transaction history (does not need)
    public Accounts(int accountID, String currencyType, double balance) {
        this.accountID = accountID; //may need change as ID can be generated here
        this.currencyType = currencyType;
        this.balance = balance;
        //transaction history set upperlimit to intMax, use array(?   (does not need)
    }
    public void displayAccountInfo(){
        System.out.printf("The account ID is %d, the currency type is %s, and the balance is %.2d" ,
                this.accountID , this.currencyType , this.balance)
    }
    public void addToBalance(double amount){
        this.balance += amount;
    }

    // more function for this class Accounts
    // some one need to come up with possible function for this
}

public class Transactions {
    private static int transactionCounter = 0; //Counter inside class
    private final String transactionID;
    String transactionDate;
    String transactionType;
    int otherAccountID; //need ammend
    double amount;
    String remarks;

    public Transactions(String transactionDate ,
                        String transactionType, int otherAccountID,
                        double amount , String remarks){
        transactionCounter++;
        this.transactionID = String.format("%07d", transactionCount); //Covert to 0000001 , String
        this.transactionDate = transactionDate;
        this.transactionType = transactionType;
        Accounts otherAccount = //get  Account from AccountID;
        this.otherAccount = otherAccount
        this.amount = amount;
        this.remarks = remarks;
    }
    public void displayTransactionInfo(){
        System.out.printf("Transaction information:\nID:%s\nDate:%s\nType:%s\nThe other acount Id this transaction affect:%d\nAmount:%.2f\nRemarks:%s",
                this.transactionID , this.transactionDate , this.transactionType,
                this.otherAccount.accountID; , this.amount , this.remarks);
    }
    // more function for this class Transaction
    // some one need to come up with possible function for this
    public void completeTransactionForOtherAccount(){
        this.otherAccount.addToBalance(-this.amount);
    }
}
public class Main {
    public static Accounts createDummyAccounts(){

    }
    public static Transactions createTransactions(Scanner sc){
        System.out.println("Please enter your transaction details in the following format");
        System.out.print("transactionDate , transactionType, Other Account ID, amount , remarks :");
        String transactionInput = sc.nextLine(); //read input
        String[] detailsArray = transactionInput.split(",")
        while (detailsArray.length != 5){
            System.out.print("please enter all five transaction details:");
            transactionInput = sc.nextLine(); //read input
            detailsArray = transactionInput.split(",")
        }
        // get all respective details
        String transactionDate = detailsArray[0].trim();
        String transactionType = detailsArray[1].trim();
        int accountID = Integer.parseInt(detailsArray[2].trim());
        double amount = Double.parseDouble(detailsArray[3].trim());
        String remarks = detailsArray[4].trim();
        //create Transactions class
        Transactions newTransaction = new Transactions(transactionDate, transactionType, accountID, amount, remarks);
        return newTransaction;
    }
    public static void completeTransaction(Accounts currentAccount, Transactions thisTransaction){}
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // rundown for how the process should work
        // choose (possible) option
        //1) create account
        //2) create transaction
        //3) display with sorting func (talk at friday)
        }
    }