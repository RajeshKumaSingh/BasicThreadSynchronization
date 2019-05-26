package my.synchronizemethod;

public class MainThread {

	public static void main(String[] args) {
		Account account = new Account();
		account.setBalance(1000);
		
		Bank bank = new Bank(account);
		Company company = new Company(account);
		
		Thread bankThread = new Thread(bank);
		Thread companyThread= new Thread(company);
		
		System.out.println("Account :  Initial balance: "+account.getBalance());
		
		companyThread.start();
		bankThread.start();
		
		try {
			companyThread.join();
			bankThread.join();
			System.out.println("Account :  Final balance: "+account.getBalance());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		/*
		If we want to see the problems of concurrent access to shared data, we can delete the
		synchronized keyword of the addAmount() and subtractAmount() methods and run
		the program. Without the synchronized keyword, while a thread is sleeping after reading
		the value of the account's balance, another method will read the account's balance, so both
		the methods will modify the same balance and one of the operations won't be reflected in the
		final result.
		*/
	}

}
