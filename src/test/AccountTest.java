package test;

import model.Account;

public class AccountTest {

    public static void main(String[] args){
        Account account = new Account("Sam Sulek", 50.0);
        System.out.printf("Welcome %s! For your first model.Account!%n", account.getName());
        System.out.printf("Your Balance is $%.2f%n", account.getBalance());

        account.deposit(50.0);
        System.out.printf("Now, Your Balance is $%.2f%n", account.getBalance());

        account.withdraw(30.0);
        System.out.printf("Now, Your Balance is $%.2f%n", account.getBalance());
    }

}
