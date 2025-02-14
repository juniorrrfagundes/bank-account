package view;

import presenter.AccountPresenter;

import javax.swing.*;

public class Gui {
    private String name;
    private JFrame frame;
    private JTextField textField;
    private JButton submitButton;
    private JLabel label;

    public Gui(){
        frame = new JFrame("Bank model.Account");
        frame.setLayout(null);
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        label = new JLabel("Welcome to your Bank Accout!");
        label.setBounds(150,20,200, 120);
        frame.add(label);

        label = new JLabel("Enter your name below.");
        label.setBounds(170,50,200, 120);
        frame.add(label);

        textField = new JTextField();
        textField.setBounds(170, 130, 140, 25);
        frame.add(textField);

        submitButton = new JButton("submit");
        submitButton.setBounds(190, 170, 100, 20);
        frame.add(submitButton);

        frame.setVisible(true);

        submitButton.addActionListener(e -> {
            this.name = textField.getText();
            if (this.name != null && !this.name.isEmpty()){
                frame.dispose();
                new AccountPresenter(this.name);
            } else {
                JOptionPane.showMessageDialog(frame,"Enter your name!");
            }
        });

    }

}
