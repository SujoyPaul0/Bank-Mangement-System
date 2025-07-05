import java.util.*;

public class Bank {
    // List to store all created Account objects
    private List<Account> accounts = new ArrayList<>();

    // var to generate unique acct number, from 1001
    private int nextAccountNumber = 1001;

    // Method to create a new acct
    public Account createAccount(String name, double initialDeposit) {
        // new act object
        Account acc = new Account(name, nextAccountNumber++, initialDeposit);
        
        accounts.add(acc);
        return acc;
    }

    // Method to return the list of all accounts
    public List<Account> getAllAccoutnts() {
        return accounts;
    }

    // Method to find a specific account by account number
    public Account findAccount(int accountNumber) {
        for (Account acc: accounts) {
            if (acc.getAccountNumber() == accountNumber) {
                return acc;
            }
        }
        return null;
    }

    // Method to deposit money
    public boolean depositToAccount(int accountNumber, double amount) {
        Account acc = findAccount(accountNumber);

        if (acc != null) {
            acc.deposit(amount);
            return true;
        }
        return false;
    }

    // Method to withdraw money from a specific account
    public boolean withdrawFromAccount(int accountNumber, double amount) {
        Account acc = findAccount(accountNumber);

        if (acc != null) {
            return acc.withdraw(amount);
        }
        return false; 
    }
}

    