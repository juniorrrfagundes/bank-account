package view;

import presenter.AccountPresenter;

import javax.swing.*;


public class SecondGui {
    private String name;
    private JFrame frame;
    private JLabel label;
    private JTextField textField;
    private JButton depositButton;
    private JButton withdrawButton;
    private JButton getBalanceButton;
    private AccountPresenter accountPresenter;


    public SecondGui(AccountPresenter accountPresenter){
        this.accountPresenter = accountPresenter;

        frame = new JFrame("Bank model.Account");
        frame.setLayout(null);
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        label = new JLabel(String.format("%s, welcome to your bank account", accountPresenter.getNameAccount()));
        label.setBounds(130,20,250, 120);
        frame.add(label);

        label = new JLabel("Select One Option");
        label.setBounds(180, 50, 240, 120);
        frame.add(label);

        depositButton = new JButton("Deposit");
        depositButton.setBounds(180, 130, 100, 25);
        frame.add(depositButton);

        withdrawButton = new JButton("Withdraw");
        withdrawButton.setBounds(180, 170, 100, 25);
        frame.add(withdrawButton);

        getBalanceButton = new JButton("View Balance");
        getBalanceButton.setBounds(170, 210, 120, 25);
        frame.add(getBalanceButton);

        depositButton.addActionListener(e -> depositAction());
        withdrawButton.addActionListener(e -> withdrawAction());
        getBalanceButton.addActionListener(e -> getBalanceAction());

        frame.setVisible(true);
    }

    public void depositAction(){
        String input = JOptionPane.showInputDialog(frame, "Enter deposit amount: ");
        if (input != null && !input.isEmpty()){
            try {
                double amount = Double.parseDouble(input);
                if (amount > 0.0){
                    accountPresenter.depositAmount(amount);
                    JOptionPane.showMessageDialog(frame, "Amount deposited!");
                } else {
                    JOptionPane.showMessageDialog(frame, "The amount need be greater than 0.0");
                }
            } catch (NumberFormatException e){
                JOptionPane.showMessageDialog(frame, "Invalid amount!");
            }
        }
    }

    public void withdrawAction(){
        String input = JOptionPane.showInputDialog(frame, "Enter withdraw amount: ");
        if ( input != null && !input.isEmpty()){
            try {
                double amount = Double.parseDouble(input);
                if (amount > 0.0 && amount <= accountPresenter.getBalanceAccount()){
                    accountPresenter.withdrawAmount(amount);
                    JOptionPane.showMessageDialog(frame, "Amount withdrew");
                } else {
                    JOptionPane.showMessageDialog(frame, "The amount need be greater than 0.0 and your balance!");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(frame, "Invalid amount!");
            }
        }
    }

    public void getBalanceAction(){
        JOptionPane.showMessageDialog(frame, String.format("Your Balance is $%s", accountPresenter.getBalanceAccount()));
    }

}
