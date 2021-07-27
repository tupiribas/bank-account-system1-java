package model.entities;

import model.Exceptions.BusinessException;

public class Account {
	private Integer number;
	private String holder;
	private Double balance;
	private Double withdrawLimit;

	public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}

	public Integer getNumber() {
		return number;
	}

	public String getHolder() {
		return holder;
	}

	public Double getBalance() {
		return balance;
	}

	public Double getWithdrawLimit() {
		return withdrawLimit;
	}

	public void deposit(Double amount) {
		this.balance += amount;
	}

	public void withdraw(Double amount) throws BusinessException {
		if (!validate(amount)) {
			this.balance -= amount;
		}
	}
	
	public boolean validate(Double amount) throws BusinessException {
		if (amount > getWithdrawLimit()) {
			throw new BusinessException("The amount exceeds withdraw limit.");
		} 
		else if (amount > getBalance()) {
			throw new BusinessException("Not enough balace!");
		}  
		return false;
	}
	
	@Override
	public String toString() {
		return "New Balance: " + getBalance();
	}
}
