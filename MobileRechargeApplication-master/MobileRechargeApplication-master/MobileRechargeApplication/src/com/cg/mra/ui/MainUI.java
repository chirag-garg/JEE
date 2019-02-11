package com.cg.mra.ui;

import java.util.Scanner;

import com.cg.mra.beans.Account;
import com.cg.mra.service.AccountService;
import com.cg.mra.service.AccountServiceImpl;

public class MainUI {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AccountService service = new AccountServiceImpl();
		Scanner sc = new Scanner(System.in);
		int ch = 0;
		String mobile;
		double rechargeAmount;
		
		do{
			System.out.println(" 1. Account Balance Enquiry ");
			System.out.println(" 2. Recharge Account ");
			System.out.println(" 3. Exit ");
			System.out.println(" Enter your choice : ");
			ch = sc.nextInt();
			
			switch (ch) {
			case 1:
				 	do
				 	{
				 		System.out.println("Enter the Mobile No: ");
				 		mobile = sc.next();
				 	}while(service.validateMobileNo(mobile));
				 	
				 	Account account = service.getAccountDetails(mobile);
				 	double bal = account.getAccountBalance();
				 	System.out.println(" Your Current Balance is Rs. " + bal);
				break;
			
			case 2:
				do
				{
					System.out.println(" Enter the Mobile No: ");
					mobile = sc.next();
					System.out.println(" Enter Recharge Amount : ");
					rechargeAmount = sc.nextDouble();
				}while(service.validateMobileNo(mobile) && service.validateRechargeAmount(rechargeAmount));
				
					double newbal = service.rechargeAccount(mobile, rechargeAmount);
					Account account1 = new Account();
					account1.setAccountBalance(newbal);
					String name = account1.getCustomerName();
					System.out.println("Your Account Recharged Successfully");
					System.out.println(" Hello " + name + " , Available balance is " + newbal);
				 break;
				
			}
		}while(ch != 3);
		
		System.out.println(" Program Ended !!! ");
	}

}
