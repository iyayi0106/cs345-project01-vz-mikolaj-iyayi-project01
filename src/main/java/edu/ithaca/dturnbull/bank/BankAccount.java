package edu.ithaca.dturnbull.bank;

public class BankAccount {

    private String email;
    private double balance;

    /**
     * @throws IllegalArgumentException if email is invalid
     */
    public BankAccount(String email, double startingBalance) throws IllegalArgumentException{
        if(!isAmountValid(startingBalance)){
            throw new IllegalArgumentException("invalid amount entered");
        }
        else if (isEmailValid(email)){
            this.email = email;
            this.balance = startingBalance;
        }
        else {
            throw new IllegalArgumentException("Email address: " + email + " is invalid, cannot create account");
        }
    }

    public double getBalance(){
        return balance;
    }

    public String getEmail(){
        return email;
    }

    /**
     * @post reduces the balance by amount if amount is non-negative and smaller than balance
     */
    public void withdraw (double amount) throws InsufficientFundsException{
        if(!isAmountValid(amount)){
            throw new IllegalArgumentException("amount cannot be negative or have more than 2 decimal places");

        }
        else if (amount <= balance){
            balance -= amount;
        }
        else {
            throw new InsufficientFundsException("Not enough money");
        }
    }


    public static boolean isEmailValid(String email){
        if (email.indexOf('@') == -1){
            return false;
        }
        else if(email.length() <= 3){
            return false;
        }
        else if(email.isEmpty()){
                return false;
        }
        else if(email.indexOf('@') == 0 || email.indexOf('.') == 0 ){ 
            return false;
        }
        else if(!Character.isLetter(email.charAt(email.indexOf('@') - 1))){ 
            return false;
        }
        else if(email.contains("$") || email.contains("!") || email.contains("#")){ 
            return false;
        }
        else if(email.charAt(email.indexOf('.')) == email.charAt(email.indexOf('.') + 1)){ 
            return false;
        }
        else if(email.lastIndexOf('.')+ 2 >= email.length()){
            return false;    
        }
        else{
            return true;
        }
    }

    public void deposit(double amount) throws IllegalArgumentException {
        if (!isAmountValid(amount)) {
            throw new IllegalArgumentException("amount cannot be negative or have more than 2 decimal places");
        }
        else {
            balance = balance + amount;
        } 
    }

    /**
    * @return true if the amount is positive and has two decimal points or less, and false otherwise
    */
    public static boolean  isAmountValid(double amount){
        String doubleStr = Double.toString(amount);

        if(amount < 0){
            return false;
            
        }
        else if(doubleStr.substring(doubleStr.lastIndexOf('.'), doubleStr.length() - 1).length() > 2){ //check if amount has 5 or more digits (possibility that there is 3 decimals) 300.67 , 30.678
            return false;
        }
        else{
            return true;
        }


    }

   
}