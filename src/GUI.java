import java.awt.*;
import javax.swing.*;

public class GUI {
    private Bank bank;
    public GUI(Bank bank) {
        this.bank = bank;
    }

    // Method to create and display the mani GUI window
    public void createAndShowGUI() {
        JFrame frame = new JFrame("Bank Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(5, 1, 10, 10));

        JButton createBtn = new JButton("Create Account");
        JButton viewBtn = new JButton("View Accounts");
        JButton depositeBtn = new JButton("Deposit");
        JButton withdrawBtn = new JButton("Withdraw");
        JButton exitBtn = new JButton("Exit");


        // Add cllick event to create Accoun button
        createBtn.addActionListener(e -> {
            // Prompt user to enter their name
            String name = JOptionPane.showInputDialog(frame, "Enter your name:");

            // if user cancels or enters nothing
            if (name == null || name.trim().isEmpty()) return;


            // Prompt user to enter initial deposit
            String depositStr = JOptionPane.showInputDialog(frame, "Enter initial deposit:");

            // If user cancels or enters nothing, exit early
            if (depositStr == null || depositStr.trim().isEmpty()) return;

            try {
                // Convert input to double
                double deposit = Double.parseDouble(depositStr);
                Account newAcc = bank.createAccount(name, deposit);

                JOptionPane.showMessageDialog(frame, "Account Created!\nAccount Number: " + newAcc.getAccountNumber(), "Success", JOptionPane.INFORMATION_MESSAGE);
            } catch ( NumberFormatException ex ) {
                // If the user enters not-numeric deposit, show error message
                JOptionPane.showMessageDialog(frame,
                        "Invalid deposit amount!",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        });


        // View Accounts Button Logic
        viewBtn.addActionListener(e -> {
            // Get all accounts from the bank
            java.util.List<Account> allAccounts = bank.getAllAccoutnts();

            // If no accounts exist, show message
            if (allAccounts.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No accounts available.");
                return;
            }

            // Use StringBuilder to prepare a formatted list
            StringBuilder sb = new StringBuilder("List of Accounts:\n\n");
            for (Account acc : allAccounts) {
                sb.append(acc.toString()).append("\n");
            }

            // Show the list in a scrollable message dialog
            JTextArea textArea = new JTextArea(sb.toString());
            textArea.setEditable(false);
            JScrollPane scrollPane = new JScrollPane(textArea);
            scrollPane.setPreferredSize(new Dimension(350, 200));
            JOptionPane.showMessageDialog(null, scrollPane, "Accounts", JOptionPane.INFORMATION_MESSAGE);
        });


        depositeBtn.addActionListener(e -> {
            // Ask for account number
            String accNoStr = JOptionPane.showInputDialog(null, "Enter account number:");

            //validate input
            if (accNoStr == null || accNoStr.trim().isEmpty()) return;

            String amountStr = JOptionPane.showInputDialog(null, "Enter deposit amount:");

            if (amountStr == null || amountStr.trim().isEmpty()) return;

            try {
                int accNo = Integer.parseInt(accNoStr);
                double amount = Double.parseDouble(amountStr);

                boolean success = bank.depositToAccount(accNo, amount);

                if (success) {
                    JOptionPane.showMessageDialog(null, "₹" + amount + " deposited to Account No: " + accNo, "Deposit Successful", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, 
                        "Account not found!",
                        "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, 
                "Invalid input! Please enter numeric values.",
                "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        withdrawBtn.addActionListener(e -> {
            // Ask for account Number
            String accNoStr = JOptionPane.showInputDialog(null, "Enter account number:");

            if (accNoStr == null || accNoStr.trim().isEmpty()) return;

            // ask for amount
            String amountStr = JOptionPane.showInputDialog(null, "Enter Withdraw and amount:");
            
            if (amountStr == null || amountStr.trim().isEmpty()) return;

            try {
                int accNo = Integer.parseInt(accNoStr);
                double amount = Double.parseDouble(amountStr);

                // Perform withdrawal
                boolean success = bank.withdrawFromAccount(accNo, amount);

                if (success) {
                    JOptionPane.showMessageDialog(null, 
                        "₹" + amount + " withdrawn from Account No: " + accNo,
                        "Withdraw Successful", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    // If withdrawl fails, show an error message
                    JOptionPane.showMessageDialog(
                        null,
                        "Withdraw failed! Either account doesn't exist or insufficient balance.",
                        "Error",                             
                        JOptionPane.ERROR_MESSAGE             
                    );
                }

            } catch ( NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, 
                    "Invalid input! Please enter numeric values.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            }

        });
            

        exitBtn.addActionListener(e -> System.exit(0));

        frame.add(createBtn);
        frame.add(viewBtn);
        frame.add(depositeBtn);
        frame.add(withdrawBtn);
        frame.add(exitBtn);
        frame.setVisible(true);
    }
}
