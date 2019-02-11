package com.cg.mra.dao;

import java.util.HashMap;
import java.util.Map;

import com.cg.mra.beans.Account;
import com.cg.mra.exception.MobileRechargeException;

public class AccountDaoImpl implements AccountDao {
	
	Map<String, Account> accountEntry;
	public AccountDaoImpl() {
		// TODO Auto-generated constructor stub
		
		accountEntry = new HashMap<>();
		accountEntry.put("9010210131", new Account("Prepaid", "Vaishali", 200));
		accountEntry.put("9823920123", new Account("Prepaid", "Megha", 453));
		accountEntry.put("9932012345", new Account("Prepaid", "Vikas", 631));
		accountEntry.put("9010210132", new Account("Prepaid", "Anju", 521));
		accountEntry.put("9010210133", new Account("Prepaid", "Tushar", 632));
		
	}
	@Override
	public Account getAccountDetails(String mobileNo) throws MobileRechargeException {
		// TODO Auto-generated method stub
		Account account = accountEntry.get(mobileNo);
		if (account == null)
			throw new MobileRechargeException("No Record Found !!! ");
		else 
			return account;
	}
	@Override
	public double rechargeAccount(String mobileNo, double rechargeAmount) throws MobileRechargeException{
		// TODO Auto-generated method stub
		double accBalance = 0;
		Account account = new Account();
		account = accountEntry.get(mobileNo);
		if(account == null)
			throw new MobileRechargeException("No Record Found !!!");
		else {
			
			accBalance = account.getAccountBalance();
			accBalance += rechargeAmount;
			return accBalance;
		}
	}
}
