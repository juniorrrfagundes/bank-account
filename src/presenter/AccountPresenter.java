package presenter;

import view.SecondGui;
import view.Gui;
import model.Account;

public class AccountPresenter {
    private Account account;

    public AccountPresenter(String name){
        this.account = new Account(name);
        SecondGui secondGui = new SecondGui(this);
    }

    public void depositAmount(double amount){
        this.account.deposit(amount);
    }

    public void withdrawAmount(double amount){
        this.account.withdraw(amount);
    }

    public double getBalanceAccount(){
        return this.account.getBalance();
    }

    public String getNameAccount(){
        return this.account.getName();
    }

}
