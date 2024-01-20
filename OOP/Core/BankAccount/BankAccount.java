package bankAcc;

public class BankAccount {
	private double checkingBalance;
	private double savingsBalance;
	private static int accounts;
	private static double totalMoney;
	
	public BankAccount() {
		this.checkingBalance = 0.0;
		this.savingsBalance = 0.0;
		accounts++;
		totalMoney = checkingBalance + savingsBalance;
	}
	
	public double getCheckingBalance() {
		return checkingBalance;
	}
	
	public double getSavingsBalance() {
		return savingsBalance;
	}
	
	public static int getAccounts() {
		return BankAccount.accounts;
	}
	
	public static double getTotalMoney() {
		return BankAccount.totalMoney;
	}
	
	public void deposit(String depositType , double amount) {
		if(depositType.equals("saving")) {
			savingsBalance += amount;
			totalMoney += amount;
		} else if (depositType.equals("checking")) {
			checkingBalance += amount;
			totalMoney += amount;
		} else {
			System.out.println("Insufficient funds.");
		}
	}
	
	public void withdraw(String withdrawType, double amount) {
		if(withdrawType.equals("saving") && savingsBalance >= amount) {
			savingsBalance -= amount;
			totalMoney -= amount;
		} else if (withdrawType.equals("checking") && checkingBalance >= amount) {
			checkingBalance -= amount;
			totalMoney -= amount;
		} else {
			System.out.println("Insufficient funds.");
		}
	}
	
	public double getBalance() {
		return totalMoney;
	}

}
