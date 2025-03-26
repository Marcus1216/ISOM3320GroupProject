package FinMgmt;

public class TransactionType {
    private String typeName;

    // Constructor
    public TransactionType(String typeName) {
        this.typeName = typeName;
    }

    // Getter
    public String getTypeName() {
        return typeName;
    }

    // Display transaction type
    public void displayType() {
        System.out.println("Transaction Type: " + typeName);
    }
}