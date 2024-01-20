package bankAcc;

public class BankTest {

	public static void main(String[] args) {
		BankAccount account1 = new BankAccount();
		BankAccount account2 = new BankAccount();
		BankAccount account3 = new BankAccount();
		
		account1.deposit("saving", 520);
		System.out.println("Savings Balance is: " + account1.getSavingsBalance() + "$");
		account1.deposit("checking", 600);
		account1.deposit("checking", 340);
		System.out.println("Checking Balance is: " + account1.getCheckingBalance() + "$");
		
		account2.deposit("saving", 99);
		account2.deposit("saving", 500);
		System.out.println("Savings Balance is: " + account2.getSavingsBalance() + "$");
		account2.deposit("checking", 1250);
		System.out.println("Checking Balance is: " + account2.getCheckingBalance() + "$");
		
		account3.deposit("saving", 400);
		account3.deposit("saving", 180);
		System.out.println("Savings Balance is: " + account3.getSavingsBalance() + "$");
		account3.deposit("checking", 1050);
		account3.deposit("checking", 170);
		System.out.println("Checking Balance is: " + account3.getCheckingBalance() + "$");
		
		account1.withdraw("saving", 20);
		System.out.println("Savings Balance after withdrawal is: " + account1.getSavingsBalance() + "$");
		
		account2.withdraw("checking", 140);
		System.out.println("Checking Balance after withdrawal is: " + account2.getCheckingBalance() + "$");
		
		
		account3.withdraw("checking", 250);
		System.out.println("Checking Balance after withdrawal is: " + account3.getCheckingBalance() + "$");
		
		System.out.println("Number of accounts: " + BankAccount.getAccounts());
		System.out.println("Total: " + BankAccount.getTotalMoney() + "$");
		
	}

}
