package model;

public class Account {
    private String name;
    private double balance;

    public Account(String name, double initialBalance){
        this.name = name;
        this.balance = (initialBalance > 0.0) ? initialBalance : 0.0;
    }

    public Account(String name){
        this(name, 0.0);
    }

    public void deposit(double amount){
        if (amount > 0.0){
            this.balance += amount;
        }
    }

    public void withdraw(double amount){
        if(this.balance > amount){
            this.balance -= amount;
        }
    }

    public double getBalance(){
        return this.balance;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}
