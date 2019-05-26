package my.synchronizedlock.fairness;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintQueue {
	
	/*
	The constructor of the ReentrantLock and ReentrantReadWriteLock classes admits
	a boolean parameter named fair that allows you to control the behavior of both classes.
	The false value is the default value and it's called the non-fair mode. In this mode, when
	there are some threads waiting for a lock (ReentrantLock or ReentrantReadWriteLock)
	and the lock has to select one of them to get the access to the critical section, it selects one
	without any criteria. The true value is called the fair mode. In this mode, when there are
	some threads waiting for a lock (ReentrantLock or ReentrantReadWriteLock) and the
	lock has to select one to get access to a critical section, it selects the thread that has been
	waiting for the most time. Take into account that the behavior explained previously is only
	used with the lock() and unlock() methods. As the tryLock() method doesn't put the
	thread to sleep if the Lock interface is used, the fair attribute doesn't affect its functionality.
	*/
	
	private final Lock queueLock = new ReentrantLock(true);  // fair mode, pick up most waited thread
	
	public void printJob(Object document) {
		queueLock.lock();
		try {
			Long duration = (long)(Math.random()*10000);
			System.out.println(Thread.currentThread().getName()+" PrintQueue: Printing a job during "+(duration/1000)+" seconds");
			Thread.sleep(10);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}finally {
			queueLock.unlock();
		}
		
		queueLock.lock();
		try {
			Long duration = (long)(Math.random()*10000);
			System.out.println(Thread.currentThread().getName()+" PrintQueue: Printing a job during "+(duration/1000)+" seconds");
			Thread.sleep(10);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}finally {
			queueLock.unlock();
		}
	}
}
