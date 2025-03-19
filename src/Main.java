//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public class Accounts {
        int accountID;
        String currencyType;
        double balance;
        //transaction history
        public Accounts(int accountID, String currencyType, double balance) {
            this.accountID = accountID;
            this.currencyType = currencyType;
            this.balance = balance;
            //transaction history
        }
        public void displayAccountInfo(){
            System.out.printf("The account ID is %d, the currency type is %s, and the balance is %.2d" ,
                    this.accountID , this.currencyType , this.balance)
        }
        public void addToBalance(double amount){
            this.balance += amount;
        }
    }

    public static void main(String[] args) {
        }
    }