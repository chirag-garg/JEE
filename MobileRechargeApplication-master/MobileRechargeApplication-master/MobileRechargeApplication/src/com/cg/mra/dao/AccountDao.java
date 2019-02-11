package com.cg.mra.dao;



import com.cg.mra.beans.Account;
import com.cg.mra.exception.MobileRechargeException;

public interface AccountDao {
	
	public Account getAccountDetails(String mobileNo) throws MobileRechargeException;
	
	public double rechargeAccount(String mobileNo, double rechargeAmount) throws MobileRechargeException;
}
