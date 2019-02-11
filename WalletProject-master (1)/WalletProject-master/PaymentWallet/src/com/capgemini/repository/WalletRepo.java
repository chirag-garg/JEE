package com.capgemini.repository;

import com.capgemini.beans.Customer;

public interface WalletRepo {
	public boolean save(Customer customer);

	public Customer findone(String mobileNumber);

}
