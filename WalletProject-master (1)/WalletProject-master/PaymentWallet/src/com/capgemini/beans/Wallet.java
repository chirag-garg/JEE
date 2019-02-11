package com.capgemini.beans;

import java.math.BigDecimal;

public class Wallet {
	private BigDecimal balance;

	public Wallet(BigDecimal balance) {
		super();
		this.balance = balance;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public Wallet() {
		super();
	}

	@Override
	public String toString() {
		return "Wallet [balance=" + balance + "]";
	}

}
