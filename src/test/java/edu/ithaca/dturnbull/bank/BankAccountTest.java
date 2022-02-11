package edu.ithaca.dturnbull.bank;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class BankAccountTest {

    @Test
    void getBalanceTest() {
        BankAccount bankAccount = new BankAccount("a@b.com", 200);

        assertEquals(200, bankAccount.getBalance(), 0.001);

    }

    @Test
    void withdrawTest() throws InsufficientFundsException{
        BankAccount bankAccount = new BankAccount("a@b.com", 200);
        bankAccount.withdraw(100);

        assertEquals(100, bankAccount.getBalance(), 0.001);
        assertThrows(InsufficientFundsException.class, () -> bankAccount.withdraw(300));
       
        BankAccount bankAccount2 = new BankAccount("a@b.com", 200);
        assertThrows(IllegalArgumentException.class, () -> bankAccount2.withdraw(-300));

        BankAccount bankAccount3 = new BankAccount("a@b.com", 3000);
        assertThrows(IllegalArgumentException.class, () -> bankAccount3.withdraw(-300.376)); //false case
        assertThrows(IllegalArgumentException.class, () -> bankAccount3.withdraw(300.376)); //false case
    }
    @Test
    void depositTest() throws IllegalArgumentException{ // or insuffieient funds exception ?
         BankAccount bankAccount = new BankAccount("a@b.com", 350);
         bankAccount.deposit(100);
         assertEquals(450, bankAccount.getBalance(), 0.001);
         assertThrows(IllegalArgumentException.class, () -> bankAccount.deposit(-300));

         BankAccount bankAccount2 = new BankAccount("a@b.com", 350);
         //assertThrows(IllegalArgumentException.class, () -> bankAccount2.deposit(60.970));
         assertThrows(IllegalArgumentException.class, ()-> bankAccount2.deposit(60.975));
    }

    @Test
    void isAmountValidTest(){
        // Testing for decimal places and positive numbers
        assertTrue(BankAccount.isAmountValid(300.00));
        assertTrue(BankAccount.isAmountValid(30.50));
        assertFalse(BankAccount.isAmountValid(70.345));
        assertFalse(BankAccount.isAmountValid(-70.00));
        assertTrue(BankAccount.isAmountValid(70));

    }

    @Test
    void isEmailValidTest(){
        assertTrue(BankAccount.isEmailValid( "a@b.com"));   // valid email address
        assertFalse( BankAccount.isEmailValid(""));         // empty string

        
    }

    @Test
    void constructorTest() {
        BankAccount bankAccount = new BankAccount("a@b.com", 200);

        assertEquals("a@b.com", bankAccount.getEmail());
        assertEquals(200, bankAccount.getBalance(), 0.001);
        //check for exception thrown correctly
        assertThrows(IllegalArgumentException.class, ()-> new BankAccount("", 100));

        BankAccount bankAccount2 = new BankAccount("a@b.com", 3000);
        assertThrows(IllegalArgumentException.class, () -> new BankAccount("",-300.376)); 
        assertThrows(IllegalArgumentException.class, () -> new BankAccount("",300.376)); 

        assertThrows(IllegalArgumentException.class, () -> new BankAccount("2@",67.37)); //false case
        assertThrows(IllegalArgumentException.class, () -> new BankAccount("abc@gmail.com",-900)); //false case

    }

}