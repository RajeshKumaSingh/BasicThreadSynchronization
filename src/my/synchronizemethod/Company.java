package my.synchronizemethod;

public class Company implements Runnable {
	
	/*
	Implement a class that simulates a company and uses the addAmount() method
	of the Account class to increment the balance of the account. This class must
	implement the Runnable interface to be executed as a thread.
	*/
	
	private Account account;

	public Company(Account account) {
		this.account = account;
	}

	@Override
	public void run() {
		for(int i=0;i<100;i++) {
			account.addAmount(1000);
		}
	}

}
