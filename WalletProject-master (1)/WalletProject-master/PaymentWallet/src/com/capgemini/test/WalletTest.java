package com.capgemini.test;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import com.capgemini.exceptions.DuplicateMobileNumberExistException;
import com.capgemini.exceptions.InsufficientBalanceException;
import com.capgemini.exceptions.MobileDoesNotExistException;
import com.capgemini.exceptions.NameShouldNotBeNull;
import com.capgemini.service.WalletService;
import com.capgemini.service.WalletServiceImpl;

public class WalletTest {
	WalletService walletSeviceTest=new WalletServiceImpl();
	@Before
	public void setUp() throws Exception {
	
	
	}

	@Test(expected=com.capgemini.exceptions.InsufficientBalanceException.class)
	public void test() throws InsufficientBalanceException, DuplicateMobileNumberExistException, MobileDoesNotExistException, NameShouldNotBeNull {
		walletSeviceTest.createAccount("Ravi","1",new BigDecimal("2000"));
		walletSeviceTest.withDrawAmount("1", new BigDecimal("3000"));
	}
	
	@Test(expected=com.capgemini.exceptions.DuplicateMobileNumberExistException.class)
	public void test1() throws InsufficientBalanceException, DuplicateMobileNumberExistException, NameShouldNotBeNull {
		walletSeviceTest.createAccount("Ravi","1",new BigDecimal("2000"));
		walletSeviceTest.createAccount("krishan","1",new BigDecimal("3000"));
	}
	
	@Test(expected=com.capgemini.exceptions.MobileDoesNotExistException.class)
	public void test2() throws InsufficientBalanceException, DuplicateMobileNumberExistException, MobileDoesNotExistException, NameShouldNotBeNull {
		walletSeviceTest.createAccount("Ravi","1",new BigDecimal("2000"));
		walletSeviceTest.withDrawAmount("2", new BigDecimal("3000"));
	}

	@Test(expected=com.capgemini.exceptions.NameShouldNotBeNull.class)
	public void test3() throws InsufficientBalanceException, DuplicateMobileNumberExistException, MobileDoesNotExistException, NameShouldNotBeNull {
		walletSeviceTest.createAccount(null,"1",new BigDecimal("2000"));
		
	}
}
