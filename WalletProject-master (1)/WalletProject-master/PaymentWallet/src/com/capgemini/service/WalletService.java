package com.capgemini.service;

import java.math.BigDecimal;

import com.capgemini.beans.Customer;
import com.capgemini.exceptions.DuplicateMobileNumberExistException;
import com.capgemini.exceptions.InsufficientBalanceException;
import com.capgemini.exceptions.MobileDoesNotExistException;
import com.capgemini.exceptions.NameShouldNotBeNull;

public interface WalletService {

	public Customer createAccount(String name, String mobileNumber, BigDecimal amount) throws DuplicateMobileNumberExistException, NameShouldNotBeNull;

	public Customer showBalance(String mobileNumber);

	public Customer fundTransfer(String sourceMobileNumber, String targetMobileNumber, BigDecimal amount) throws InsufficientBalanceException, MobileDoesNotExistException;

	public Customer depositAmount(String mobileNumber, BigDecimal amount) throws MobileDoesNotExistException;

	public Customer withDrawAmount(String mobileNumber, BigDecimal amount) throws InsufficientBalanceException, MobileDoesNotExistException;
}
