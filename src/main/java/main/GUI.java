package main;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;


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
            JPanel panel = new JPanel(new GridLayout(0, 2, 10, 10));

            JTextField nameField = new JTextField();

            JSpinner dobSpinner = new JSpinner(new SpinnerDateModel());

            dobSpinner.setEditor(new JSpinner.DateEditor(dobSpinner, "dd/MM/yyyy"));

            // Multi-line text area for address
            JTextArea addressArea = new JTextArea(3, 20);

            // Other text fields for state , pin, phone number
            JTextField stateField = new JTextField();
            JTextField pinField = new JTextField();
            JTextField phoneField = new JTextField();
            
            // Dropdown fo marital status with two options
            String[] statusOptions = {"Unmarried", "Married"};
            JComboBox<String> maritalStatusBox = new JComboBox<>(statusOptions);

            JTextField depositField = new JTextField();

            // Add each label and input field to the panel
            panel.add(new JLabel("Full Name:"));
            panel.add(nameField);

            panel.add(new JLabel("Date of Birth: "));
            panel.add(dobSpinner);

            panel.add(new JLabel("Address:"));
            panel.add(new JScrollPane(addressArea)); // wrap text area in scroll pane

            panel.add(new JLabel("State:"));
            panel.add(stateField);

            panel.add(new JLabel("Pin Code:"));
            panel.add(pinField);

            panel.add(new JLabel("Phone No:"));
            panel.add(phoneField);


            panel.add(new JLabel("Marital Status:"));
            panel.add(maritalStatusBox);

            panel.add(new JLabel("Initial Deposit:"));
            panel.add(depositField);

            // Show confirmation dialog with form panel and OK/Cancel buttons
            int result = JOptionPane.showConfirmDialog(
                null, 
                panel,
                "Create Account",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE
            );

            // If user clicked OK
            if (result == JOptionPane.OK_OPTION) {
                try {
                    // Read values from input fields and conver them as needed
                    String name = nameField.getText().trim();

                    String dob = new java.text.SimpleDateFormat("dd/MM/yyyy")
                        .format(dobSpinner.getValue());

                    String address = addressArea.getText().trim();
                    String state = stateField.getText().trim();
                    String pin = pinField.getText().trim();
                    String phone = phoneField.getText().trim();
                    String maritalStatus = (String) maritalStatusBox.getSelectedItem();
                    // Convert deposit string to double
                    double deposit = Double.parseDouble(depositField.getText().trim());

                    Account newAcc = bank.createAccount(name, deposit, dob, address, state, pin, phone, maritalStatus);

                    MongoUtil.saveAccount(newAcc);


                    // Create confirmation message with account number
                    JOptionPane.showMessageDialog(null, 
                        "Account Created!\nAccount No: " + newAcc.getAccountNumber(),
                        "Success", 
                        JOptionPane.INFORMATION_MESSAGE);
                    
                } catch (Exception ex) {
                    ex.printStackTrace(); // 🔍 This will show exact error in console/log
                    JOptionPane.showMessageDialog(null,
                        "Please fill all fields correctly!",
                        "Error",
                        JOptionPane.INFORMATION_MESSAGE);
                    }
            }
            

        });


        // View Accounts Button Logic
        viewBtn.addActionListener(e -> {
            List<Account> accounts = MongoUtil.getAllAccounts();

            if (accounts.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "No accounts found.");
                return;
            }

            StringBuilder message = new StringBuilder("Accounts:\n\n");
            for (Account acc : accounts) {
                message.append("Account No: ").append(acc.getAccountNumber()).append("\n")
                    .append("Name: ").append(acc.getName()).append("\n")
                    .append("Balance: ").append(acc.getBalance()).append("\n")
                    .append("Phone: ").append(acc.getPhone()).append("\n\n");
            }

            JTextArea textArea = new JTextArea(message.toString());
            textArea.setEditable(false);
            JScrollPane scrollPane = new JScrollPane(textArea);
            scrollPane.setPreferredSize(new Dimension(400, 300));
            JOptionPane.showMessageDialog(frame, scrollPane, "All Accounts", JOptionPane.INFORMATION_MESSAGE);
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
