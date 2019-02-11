package com.capgemini.repository;

import java.util.LinkedList;
import java.util.ListIterator;

import com.capgemini.beans.Customer;

public class WalletRepoImpl implements WalletRepo {

	LinkedList<Customer> list = new LinkedList<>();

	@Override
	public boolean save(Customer customer) {

		// TODO Auto-generated method stub

		return list.add(customer);

	}

	@Override
	public Customer findone(String mobileNumber) {
		// TODO Auto-generated method stub
		ListIterator<Customer> lt = list.listIterator();
		while (lt.hasNext()) {
			Customer c = lt.next();
			if (c.getMobileNumber().equals(mobileNumber))
				return c;
		}

		return null;
	}

}
