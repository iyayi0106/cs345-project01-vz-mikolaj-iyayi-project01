package edu.ithaca.dturnbull.bank;
/**
 * BankCustomer
 * This class will help users to make, manage and look over their accounts
 */
public class BankCustomer {

    private String firstName;
    private String lastName;
    private int accountID;
    private String email;
    public int id;

    BankAccount savings;
    BankAccount checking;

    double checkingsBalance;
    double savingsBalance;

    public BankCustomer(String firstName, String lastName, double checkingsBalance, double savingsBalance) {
        this.firstName = firstName;
        this.lastName = lastName;
        savings = new BankAccount(email, savingsBalance);
        checking = new BankAccount(email, checkingsBalance);
    }

    public void depositChecking(double amount) {
        checking.deposit(amount);
    }


    public void depositSavings(double amount) {
        savings.deposit(amount);
    }

    // public boolean withdrawChecking(double amount) {
    //     return checking.withdraw(amount);
    // }

    // public boolean withdrawSavings(double amount) {
    //     return savings.withdraw(amount);
    // }
    public double getCheckingBalance() {
        return checking.getBalance();
    }

    public double getSavingsBalance() {
        return savings.getBalance();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAccountId() {
        return id;
    }



    
}
