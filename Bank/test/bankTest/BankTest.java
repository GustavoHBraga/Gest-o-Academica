/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankTest;

import bank.Bank;
import bank.BankAccount;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author phfar
 */
public class BankTest {

    @Test
    public void testDefaultConstrutor() {
        Bank banco = new Bank();
        assertEquals(0, banco.getLast());  
        assertNotNull(banco.getAccounts());    
    }

    @Test
    public void testAddAccount() {
        Bank banco = new Bank();
        BankAccount c1 = new BankAccount("Ana", 500.00);
        banco.addAccount(c1);
        Assert.assertEquals("Ana", banco.getAccounts()[0].getOwner());
        Assert.assertEquals(1, banco.getLast());
        Assert.assertEquals(500.0, banco.getAccounts()[0].getBalance(), 0.01);
    }

    @Test
    public void testGetTotalBalance() {
        Bank banco = new Bank();

        BankAccount c1 = new BankAccount("Ana", 500.00);
        banco.addAccount(c1);

        banco.addAccount(new BankAccount("Marcos", 600.00));

        Assert.assertEquals("Ana", banco.getAccounts()[0].getOwner());
        Assert.assertEquals("Marcos", banco.getAccounts()[1].getOwner());
        Assert.assertEquals(500.0, banco.getAccounts()[0].getBalance(), 0.01);
        Assert.assertEquals(600.0, banco.getAccounts()[1].getBalance(), 0.01);
        Assert.assertEquals(2, banco.getLast());

        Assert.assertEquals(1100.0, banco.getTotalBalance(), 0.01);

    }
}
