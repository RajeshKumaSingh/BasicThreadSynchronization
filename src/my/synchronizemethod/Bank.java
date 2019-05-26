package my.synchronizemethod;

public class Bank implements Runnable {
	
	/*
	Implement a class that simulates an ATM. It will use the subtractAmount()
	method to decrement the balance of an account. This class must implement the
	Runnable interface to be executed as a thread.
	*/
	
	private Account account;
	
	public Bank(Account account) {
		this.account = account;
	}

	@Override
	public void run() {
		for(int i=0;i<100;i++) {
			account.subtractAmount(1000);
		}
	}

}
