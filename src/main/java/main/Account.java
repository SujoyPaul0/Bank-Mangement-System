package main;

public class Account {
    private String name;
    private int accountNumber;
    private double balance;

    // 🆕 New fields
    private String dob;
    private String address;
    private String state;
    private String pinCode;
    private String phone;
    private String maritalStatus;

    // Constructor with all fields
    public Account(String name, int accountNumber, double balance,
                   String dob, String address, String state,
                   String pinCode, String phone, String maritalStatus) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.dob = dob;
        this.address = address;
        this.state = state;
        this.pinCode = pinCode;
        this.phone = phone;
        this.maritalStatus = maritalStatus;
    }

    // Deposit method
    public void deposit(double amount) {
        balance += amount;
    }

    // Withdraw method
    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public String getDob() {
        return dob;
    }

    public String getAddress() {
        return address;
    }

    public String getState() {
        return state;
    }

    public String getPinCode() {
        return pinCode;
    }

    public String getPhone() {
        return phone;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    // toString override to display basic account info
    public String toString() {
        return "Account No: " + accountNumber +
               ", Name: " + name +
               ", Balance: ₹" + balance;
    }
}
