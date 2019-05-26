package my.synchronizemethod;

public class Account {
	
	private double balance;

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	/*
	Implemented method called addAmount() that increments the value of the balance
	in a certain amount that is passed to the method. Only one thread should change the
	value of the balance, so use the synchronized keyword to convert this method into
	a critical section.
	*/
	public synchronized void addAmount(double amount) {
		double tmp =balance;
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		tmp+=amount;
		balance = tmp;
	}
	
	/*
	Implemented method called subtractAmount() that decrements the value of the
	balance in a certain amount that is passed to the method. Only one thread should
	change the value of the balance, so use the synchronized keyword to convert this
	method into a critical section.
	*/
	
	public synchronized void subtractAmount(double amount) {
		double tmp =balance;
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		tmp-=amount;
		balance = tmp;
	}
}
