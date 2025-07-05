import java.awt.GridLayout;
import javax.swing.*;

public class GUI {
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

        exitBtn.addActionListener(e -> System.exit(0));

        frame.add(createBtn);
        frame.add(viewBtn);
        frame.add(depositeBtn);
        frame.add(withdrawBtn);
        frame.add(exitBtn);
        
        frame.setVisible(true);
    }
}
