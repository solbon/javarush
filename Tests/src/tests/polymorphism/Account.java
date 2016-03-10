package tests.polymorphism;

/**
 * Created by admin on 02.02.2016.
 */
public class Account {
	public void deposit(Double amount) {
		System.out.println("depositing " + amount);
	}

	public static void main(String[] args) {
		Account account = new SavingAccount();
		account.deposit(5.0);
	}

	public static class SavingAccount extends Account {
		@Override
		public void deposit(Double amount) {
			super.deposit(amount);
			System.out.println("additional calculating on SavingAccount");
		}
	}

}
