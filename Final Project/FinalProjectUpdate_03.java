import java.util.HashMap;
import java.util.Scanner;
//Bank Account ATM Management System class
class Account {
    private String customerName;
    private int customerID;
    private double balance;

    public Account(String customerName, int customerID) {
        this.customerName = customerName;
        this.customerID = customerID;
        this.balance = 0.0;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) { //Withdraw function
        if (balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    public void transfer(Account toAccount, double amount) {
        if (balance >= amount) {
            withdraw(amount);
            toAccount.deposit(amount);
        } else {
            System.out.println("Insufficient funds for the transfer.");
        }
    }
}
//Checking account
class CheckingAccount extends Account {
    public CheckingAccount(String customerName, int customerID) {
        super(customerName, customerID);
    }
