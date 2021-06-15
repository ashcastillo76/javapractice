package com.ashley;

public class BankAccountTest {

	public static void main(String[] args) {
		BankAccount b1 = new BankAccount();
		BankAccount b2 = new BankAccount();
		BankAccount b3 = new BankAccount();
		
		long accountNumber = b1.getAccountNumber();
		System.out.println(accountNumber);
		
		long accNumber = b2.getAccountNumber();
		System.out.println(accNumber);
		
		long accNum = b3.getAccountNumber();
		System.out.println(accNum);
		
		
		b1.funds();
		b1.setCheckingBalance(100);
		b1.setSavingsBalance(200);
		b1.funds();
		
		b2.setCheckingBalance(500);
		b2.setSavingsBalance(1000);
		

	}

}
