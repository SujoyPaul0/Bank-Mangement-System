public class Account {
    
    private String name;
    private int accountNumber;
    private double balance;

    // Constructor to initialize the account with name, number and initial balance
    public Account(String name, int accountNumber, double balance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    // Get the account holder's name
    public String getName() {
        return name;
    }

    // Get the account number
    public int getAccountNumber() {
        return accountNumber;
    }

    // Get the account holder's current balance
    public double  getBalance() {
        return balance;
    }

    // Method -> deposit money
    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public String toString() {
        return "Account No: " + accountNumber + ", Name: " + name + ", Balance: ₹" + balance;
    }
}
