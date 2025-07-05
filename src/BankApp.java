public class BankApp {
    public static void main(String[] args) {
        Bank bank = new Bank();
        GUI gui = new GUI(bank);
        gui.createAndShowGUI();
    }
}
