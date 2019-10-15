package com.ge.exercise3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Bank {

    private static final Logger logger = LogManager.getLogger(Bank.class);
    private Map<String, Account> accountMap;

    public Bank() {
        accountMap = new HashMap<>();
    }

    public Account getAccount(String accountNumber) {
        return accountMap.get(accountNumber);
    }

    public void addAccount(Account account) {
        accountMap.put(account.getAccountNumber(), account);
    }

    public void depositToAccount(String accountNumber, float amount) {
        getAccount(accountNumber).deposit(amount);
    }

    public void withdrawFromAccount(String accountNumber, float amount) {
        getAccount(accountNumber).withdraw(amount);
    }

    public int numAccounts() {
        return accountMap.size();
    }
    
    public double currentHoldings() {
    	double sum=0;

    	Iterator itr = accountMap.entrySet().iterator();
        Account acc;
        
        while (itr.hasNext()) {
        	Map.Entry pair = (Map.Entry)itr.next();
        	acc = (Account)pair.getValue();
        	sum = sum + acc.getBalance();
        }	
		return sum;
    	
    }
    
    public double bankProfitLoss(double currentHold) {
    	double profit=0, nextMonthVal=0;
    	
    	Iterator itr = accountMap.entrySet().iterator();
        Account acc;
        
        while (itr.hasNext()) {
        	Map.Entry pair = (Map.Entry)itr.next();
        	acc = (Account)pair.getValue();
        	nextMonthVal = nextMonthVal + acc.valueNextMonth();
        }
        
        profit = currentHold - nextMonthVal;
        if(profit > 0)
        	System.out.println("Bank is in Profit by value = $"+ (profit));
        else
        	System.out.println("Bank is in Loss by value = $"+(-profit) );
        
    	return profit;
    }
}
