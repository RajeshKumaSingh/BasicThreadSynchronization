package my.synchronizedlock.readwrite;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class PriceInfo {
	
	/*
	One of the most significant improvements offered by locks is the ReadWriteLock interface
	and the ReentrantReadWriteLock class, the unique one that implements it. This class
	has two locks, one for read operations and one for write operations. There can be more than
	one thread using read operations simultaneously, but only one thread can be using write
	operations. When a thread is doing a write operation, there can't be any thread doing
	read operations.
	*/

	private double price1;
	private double price2;
	
	private ReadWriteLock lock ;
	
	public PriceInfo() {
		price1= 1.0;
		price2= 2.0;
		lock = new ReentrantReadWriteLock();
	}

	/*
	Implemented getPrice1() method that returns the value of the price1 attribute.
	It uses the read lock to control the access to the value of this attribute.
	*/
	public double getPrice1() {
		lock.readLock().lock();
		double value= price1;
		lock.readLock().unlock();
		return value;
	}
	
	/*
	Implemented getPrice2() method that returns the value of the price2 attribute.
	It uses the read lock to control the access to the value of this attribute.
	*/
	public double getPrice2() {
		lock.readLock().lock();
		double value= price2;
		lock.readLock().unlock();
		return value;
	}

	/*
	Implemented setPrices() method that establishes the values of the two
	attributes. It uses the write lock to control access to them.
	*/
	public void setPrices(double price1, double price2) {
		lock.writeLock().lock();
		this.price1 = price1;
		this.price2 = price2;
		lock.writeLock().unlock();
	}
	
	
}
