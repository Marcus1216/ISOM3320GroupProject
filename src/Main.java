//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
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

    public void setBalance(double balance){
        this.balance = balance;
    }

    public int getID(){
        int id;
        id = this.accountID;
        return id;
    }

    // more function for this class Accounts
    // some one need to come up with possible function for this

    // get, set methods
    //
}

public class Transactions {
    int transactionID;
    String transactionDate;
    String transactionType;
    Accounts otherAccount; //need ammend
    double amount;
    String remarks;

    public Transactions(int transactionID , String transactionDate ,
                        String transactionType, int accountID,
                        double amount , String remarks){
        this.transactionID = transactionID;
        this.transactionDate = transactionDate;
        this.transactionType = transactionType;
        this.accountID = accountID;
        this.amount = amount;
        this.remarks = remarks;
    }
    public void displayTransactionInfo(){
        System.out.printf("Transaction information:\nID:%d\nDate:%s\nType:%s\nThe acount Id this transaction belong:%d\nAmount:%.2f\nRemarks:%s",
                this.transactionID , this.transactionDate , this.transactionType,
                this.accountID , this.amount , this.remarks)
    }
    // more function for this class Transaction
    // some one need to come up with possible function for this
}
public class Main {
    public static Accounts createDummyAccounts(){

    }
    public static void main(String[] args) {
        // rundown for how the process should work
        // choose (possible) option
        //1) create account
        // input type, input bal, id then gen
        //2) create transaction
        //3) display with sorting func (talk at friday)
    }
}
