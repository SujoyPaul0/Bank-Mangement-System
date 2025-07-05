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
            

        exitBtn.addActionListener(e -> System.exit(0));

        frame.add(createBtn);
        frame.add(viewBtn);
        frame.add(depositeBtn);
        frame.add(withdrawBtn);
        frame.add(exitBtn);
        
        frame.setVisible(true);
    }
}
