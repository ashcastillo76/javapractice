
public class BankAccount {
	public String account;
	public double checkingBalance;
	public double savingsBalance;
	public static int numberOfAccounts= 0;
	public static int amountOfFunds = 0;
	
	public BankAccount() {
		account = accountNumber();
		
		numberOfAccounts++;
	}
	
	private long accountNumber() {
		long accountNumber = (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
		return accountNumber;
	}
	
	public static int accountCount() {
		return numberOfAccounts;
	}
	
	public static int funds() {
		return amountOfFunds;
	}
}
