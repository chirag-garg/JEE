package com.capgemini.view;

import java.math.BigDecimal;
import java.util.Scanner;
import java.util.regex.Pattern;

import com.capgemini.exceptions.DuplicateMobileNumberExistException;
import com.capgemini.exceptions.InsufficientBalanceException;
import com.capgemini.exceptions.MobileDoesNotExistException;
import com.capgemini.exceptions.NameShouldNotBeNull;
import com.capgemini.service.WalletService;
import com.capgemini.service.WalletServiceImpl;

public class MainApp {
	static Scanner sc=new Scanner(System.in);
	static WalletService walletService = new WalletServiceImpl();

	public static void main(String[] args) throws DuplicateMobileNumberExistException, NameShouldNotBeNull, MobileDoesNotExistException, InsufficientBalanceException {
		// TODO Auto-generated method stub
		WalletService walletService = new WalletServiceImpl();
		
	
		while(true)
		{
		System.out.println("1:Create Account"+"\n"+"2:ShowBalance"+"\n"+"3:DepositAmount"+"\n"+"4:WithDrawAmount"+"\n"+"5:Fund Transfer"+"\n"+"6:Exit");
		System.out.println("Enter your Choice");
		int n=sc.nextInt();
		sc.nextLine();
		
		switch(n)
		
		{
		case 1:createAccount();
                
				break;
		case 2:showAmount();
		break;
		case 3:deposiAmount();
		break;
		case 4:withDrawAmount();
		break;
		case 5:fundTransfer();
		break;
		case 6:System.exit(0);
		break;
		default:System.out.println("you enterd Wrong Choice");
                
		}}	
		

//		walletService.createAccount("Ravi", "1", new BigDecimal("2000.0"));
//		walletService.createAccount("Saurabh", "2", new BigDecimal("3000.0"));
//
//		System.out.println("Customer Name: " + walletService.showBalance("1").getName() + " Balance: "+ walletService.showBalance("2").getWallet().getBalance());
//		System.out.println("Customer Name: " + walletService.showBalance("2").getName() + " Balance: "+ walletService.showBalance("2").getWallet().getBalance());
//
//		walletService.depositAmount("1", new BigDecimal("2000"));
//		walletService.depositAmount("2", new BigDecimal("5000"));
//
//		System.out.println("Customer Name:" + walletService.showBalance("1").getName() + " Balance"+ walletService.showBalance("1").getWallet().getBalance());
//
//		walletService.withDrawAmount("2", new BigDecimal("3000"));
//		System.out.println("Customer Name:" + walletService.showBalance("2").getName() + " Balance"+ walletService.showBalance("2").getWallet().getBalance());
//		walletService.fundTransfer("1", "2", new BigDecimal("1000"));
//		System.out.println("Customer Name:" + walletService.showBalance("2").getName() + " Balance"+ walletService.showBalance("2").getWallet().getBalance());
//		System.out.println("Customer Name:" + walletService.showBalance("1").getName() + " Balance"+ walletService.showBalance("1").getWallet().getBalance());

	}

	private static void fundTransfer() throws InsufficientBalanceException, MobileDoesNotExistException {
		// TODO Auto-generated method stub
		System.out.print("Enter your SourceNumber: ");
		String snumber=sc.nextLine();
		System.out.println("Enter your TargetNumber");
		String tnumber=sc.nextLine();
		System.out.println("Enter your Amount");
		BigDecimal amount=sc.nextBigDecimal();
		walletService.fundTransfer(snumber, tnumber, amount);
		
	}

	private static void withDrawAmount() throws InsufficientBalanceException, MobileDoesNotExistException {
		// TODO Auto-generated method stub
		System.out.print("Enter your MobileNumber for WithDraw: ");
		String mnumber=sc.nextLine();
		System.out.print("Enter your Amount: ");
		BigDecimal amount=sc.nextBigDecimal();
		walletService.withDrawAmount("2", new BigDecimal("3000"));
		System.out.println("your Amount Withdrawn Successully");
		
	}

	private static void deposiAmount() throws MobileDoesNotExistException {
		// TODO Auto-generated method stub
		System.out.print("Enter your MobileNumber for Deposit: ");
		String mnumber=sc.nextLine();
		System.out.print("Enter your Amount: ");
		BigDecimal amount=sc.nextBigDecimal();
	walletService.depositAmount(mnumber, amount);
	System.out.println("your Amount Deposited Successully");


		
		
	}

	private static void showAmount() {
		// TODO Auto-generated method stub
		System.out.println("Enter your MobileNumber to show Amount");
		String mnumber=sc.nextLine();
		System.out.println("Customer Name: " + walletService.showBalance(mnumber).getName() + " Balance: "+ walletService.showBalance(mnumber).getWallet().getBalance());
		
		
		
		
	}

	private static void createAccount() throws DuplicateMobileNumberExistException, NameShouldNotBeNull {
		// TODO Auto-generated method stub
		String name="1";
		String mnumber="12";
		while(Pattern.compile("[0-9]").matcher(name).find())
		{
			System.out.println("Please Enter a Name without numeric character");
			name=sc.nextLine();
		}
		while(mnumber.length()!=10)
		{
			System.out.println("Please Enter a 10 Digit number");
			mnumber=sc.nextLine();
		}
		System.out.print("Enter your Amount: ");
		BigDecimal amount=sc.nextBigDecimal();
		walletService.createAccount(name, mnumber, amount);
		System.out.println("your Account created Successully");
		
				

		
		
		
	}

}
