package com.ge.exercise3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BankTest {

    Bank bank;
    double holdings=0;

    @Before
    public void setUp() {
        bank = new Bank();
    }

    @Test
    public void addAccountTest() {
        Account account = new Account("001");
        bank.addAccount(account);
        assertEquals(1, bank.numAccounts());
    }

    @Test
    public void getAccountTest() {
        Account account = new Account("002", "Checking", 100.0f);
        bank.addAccount(account);
        assertEquals(account, bank.getAccount("002"));
    }

    @Test
    public void depositToAccountTest() {
        Account account = new Account("003", "Checking", 100.0f);
        bank.addAccount(account);
        bank.depositToAccount("003", 100.0f);
        assertEquals(200.0f, account.getBalance(), 0.01);
    }

    @Test
    public void withdrawFromAccountTest() {
        Account account = new Account("004", "Checking", 100.0f);
        bank.addAccount(account);
        bank.withdrawFromAccount("004", 100.0f);
        assertEquals(100.0f, account.getBalance(), 0.01);
    }
    
    @Test
    public void currentHoldingsTest() {
    	//double holdings = 0;
    	Account checkingAccount = new Account("001", "Checking", 500);
    	checkingAccount.setMonthlyFee(20);
    	bank.addAccount(checkingAccount);
    	
    	Account ac2 = new Account("004", "Checking", 400);
    	bank.addAccount(ac2);
    	
		Account savingsAccount = new Account("002", "Savings", 300);
		bank.addAccount(savingsAccount);
		
		Account ac3 = new Account("003", "Savings", 1000);
		ac3.setMonthlyFee(20);
		bank.addAccount(ac3);
		
		bank.depositToAccount("001", 10);
		bank.depositToAccount("002", 10);
		bank.depositToAccount("003", 10);
        
		holdings = bank.currentHoldings();
		assertEquals(2230.0f, bank.currentHoldings(), 0.01);
    }
    
    @Test
    public void bankProfitLossTest() {
    	currentHoldingsTest();
		assertEquals(26.80f, bank.bankProfitLoss(holdings), 0.01);
    }
}