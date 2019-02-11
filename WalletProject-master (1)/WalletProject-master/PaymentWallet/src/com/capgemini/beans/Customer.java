package com.capgemini.beans;

public class Customer {

	private String name;
	private String mobileNumber;
	private Wallet wallet;

	@Override
	public String toString() {
		return "Customer [name=" + name + ", mobileNumber=" + mobileNumber + ", wallet=" + wallet + "]";
	}

	public Customer(String name, String mobileNumber, Wallet wallet) {
		super();
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.wallet = wallet;
	}

	public String getName() {
		return name;
	}

	public Customer() {
		super();
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public Wallet getWallet() {
		return wallet;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}

}
