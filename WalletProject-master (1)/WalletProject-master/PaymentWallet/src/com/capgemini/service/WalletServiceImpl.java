package com.capgemini.service;

import java.math.BigDecimal;

import com.capgemini.beans.Customer;
import com.capgemini.beans.Wallet;
import com.capgemini.exceptions.DuplicateMobileNumberExistException;
import com.capgemini.exceptions.InsufficientBalanceException;
import com.capgemini.exceptions.MobileDoesNotExistException;
import com.capgemini.exceptions.NameShouldNotBeNull;
import com.capgemini.repository.WalletRepo;
import com.capgemini.repository.WalletRepoImpl;

public class WalletServiceImpl implements WalletService {

	WalletRepo walletRepo = new WalletRepoImpl();

	public WalletServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Customer createAccount(String name, String mobileNumber, BigDecimal amount) throws DuplicateMobileNumberExistException, NameShouldNotBeNull {
		// TODO Auto-generated method stub
		
		if(name==null)
		{
			
			throw new NameShouldNotBeNull();
		}
		if(walletRepo.findone(mobileNumber)!=null)
		{
			
			throw new DuplicateMobileNumberExistException();
		}

		Wallet wallet = new Wallet(amount);
		Customer customer = new Customer(name, mobileNumber, wallet);
		walletRepo.save(customer);
		return customer;

	}

	@Override
	public Customer showBalance(String mobileNumber) {
		// TODO Auto-generated method stub

		return walletRepo.findone(mobileNumber);
	}

	@Override
	public Customer fundTransfer(String sourceMobileNumber, String targetMobileNumber, BigDecimal amount) throws InsufficientBalanceException, MobileDoesNotExistException {
		// TODO Auto-generated method stub
		this.depositAmount(targetMobileNumber, amount);
		this.withDrawAmount(sourceMobileNumber, amount);
		return walletRepo.findone(sourceMobileNumber);

	}

	@Override
	public Customer depositAmount(String mobileNumber, BigDecimal amount) throws MobileDoesNotExistException {
		// TODO Auto-generated method stub
		if(walletRepo.findone(mobileNumber)==null)
		{
			throw new MobileDoesNotExistException();
		}
		Customer customer = walletRepo.findone(mobileNumber);
		Wallet wallet = customer.getWallet();
		wallet.setBalance(wallet.getBalance().add(amount));
		return customer;
	}

	@Override
	public Customer withDrawAmount(String mobileNumber, BigDecimal amount) throws InsufficientBalanceException, MobileDoesNotExistException
	{
		// TODO Auto-generated method stub
		if(walletRepo.findone(mobileNumber)==null)
		{
			throw new MobileDoesNotExistException();
		}
		Customer customer = walletRepo.findone(mobileNumber);
		Wallet wallet = customer.getWallet();
		int a=wallet.getBalance().compareTo(amount);
		if(a==-1)
		{
			throw new InsufficientBalanceException();
		}
		wallet.setBalance(wallet.getBalance().subtract(amount));
		return customer;
	}

}
