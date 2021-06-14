package com.ashley;

public class BankAccount {
	private long accountNumber;
	private double checkingBalance;
	private double savingsBalance;
	private static int numberOfAccounts= 0;
	private static int totalFunds = 0;
	
	public BankAccount() {
		this.accountNumber = this.setAccountNumber();
		this.setCheckingBalance(0.00);
		this.setSavingsBalance(0.00);
		numberOfAccounts++;
	}
	
//	getter to get checking balance
	public double getCheckingBalance() {
		return this.checkingBalance;
	}
//	getter to get savings account balance
	public double getSavingsBalance() {
		return this.savingsBalance;
	}
//	setter to create a random 10 digit account number
	public long setAccountNumber() {
		long accountNumber = (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
		return accountNumber;
	}
	
	public long getAccountNumber() {
		return accountNumber;
	}
	
//	setter to set checking balance
	public void setCheckingBalance(double deposit) {
		this.checkingBalance += deposit;
		totalFunds += deposit;
	}
//	setter to set savings balance
	public void setSavingsBalance(double deposit) {
		this.savingsBalance += deposit;
		totalFunds += deposit;
	}
	
	
//	a method to count the number of accounts created
	public int accountCount() {
		return numberOfAccounts;
	}
	
//	a method to determine the balance
	public int funds() {
		System.out.println(totalFunds);
		return totalFunds;
	}

//	a method to withdraw money from an account only if there are sufficient funds
	public void withdrawSavings(double out) {
		if(out < this.savingsBalance) {
		this.savingsBalance -= out;
		totalFunds -= out;
		}else {
			System.out.println("There are insufficient funds for this transaction,");
		}
	}
	
	public void withdrawChecking(double out) {
		if(out < this.checkingBalance) {
		this.checkingBalance -= out;
		totalFunds -= out;
		}else {
			System.out.println("There are insufficient funds for this transaction,");
		}
	}
	

	
}
