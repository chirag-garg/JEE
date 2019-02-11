package com.cg.mra.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cg.mra.beans.Account;
import com.cg.mra.dao.AccountDao;
import com.cg.mra.dao.AccountDaoImpl;
import com.cg.mra.exception.MobileRechargeException;

public class AccountServiceImpl implements AccountService {

	AccountDao dao;
	
	public AccountServiceImpl() {
		// TODO Auto-generated constructor stub
		dao = new AccountDaoImpl();
	}
	
	@Override
	public Account getAccountDetails(String mobileNo)
			throws MobileRechargeException {
		// TODO Auto-generated method stub
		return dao.getAccountDetails(mobileNo);
	}

	@Override
	public double rechargeAccount(String mobileNo, double rechargeAmount)
			throws MobileRechargeException {
		// TODO Auto-generated method stub
		return dao.rechargeAccount(mobileNo, rechargeAmount);
	}

	@Override
	public boolean validateMobileNo(String mobileNo)
			throws MobileRechargeException {
		// TODO Auto-generated method stub
		if (mobileNo == null)
			throw new MobileRechargeException("Mobile Number cannot be null");
		else {
			Pattern pat = Pattern.compile("[9][0-9]{10}");
			Matcher mat = pat.matcher(mobileNo);
			return mat.matches();
		}
	}

	@Override
	public boolean validateRechargeAmount(Double rechargeAmount)
			throws MobileRechargeException {
		// TODO Auto-generated method stub
		if (rechargeAmount == null)
			throw new MobileRechargeException("Recharge Cannot be null");
		else { 
			String sal = rechargeAmount.toString();
			Pattern pat = Pattern.compile("\\d{4,9}\\.\\d{0,4}");
			Matcher mat = pat.matcher(sal);
			return mat.matches();
		}
	}

}
