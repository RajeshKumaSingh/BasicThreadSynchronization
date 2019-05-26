package my.synchronizedlock.readwrite;

public class MainThread {

	public static void main(String[] args) {
		
		/*
		One of the most significant improvements offered by locks is the ReadWriteLock interface
		and the ReentrantReadWriteLock class, the unique one that implements it. This class
		has two locks, one for read operations and one for write operations. There can be more than
		one thread using read operations simultaneously, but only one thread can be using write
		operations. When a thread is doing a write operation, there can't be any thread doing
		read operations.
		*/
		
		PriceInfo priceInfo = new PriceInfo();
		
		Thread[] readerThreads = new Thread[5];
		for(int i=0;i<5;i++) {
			readerThreads[i] = new Thread(new Reader(priceInfo));
		}
		
		Thread writerThread = new Thread(new Writer(priceInfo));
		
		for(int i=0;i<5;i++) {
			readerThreads[i].start();
		}
		writerThread.start();
		
		/*
		As we mentioned previously, the ReentrantReadWriteLock class has two locks, one for
		read operations and one for write operations. The lock used in read operations is obtained
		with the readLock() method declared in the ReadWriteLock interface. This lock is an
		object that implements the Lock interface, so we can use the lock(), unlock(), and
		tryLock() methods. The lock used in write operations is obtained with the writeLock()
		method declared in the ReadWriteLock interface. This lock is an object that implements the
		Lock interface, so we can use the lock(), unlock(), and tryLock() methods. It is the
		responsibility of the programmer to ensure the correct use of these locks, using them with the
		same purposes for which they were designed.When you get the read lock of a Lock interface,
		you can't modify the value of the variable. Otherwise, you probably will have inconsistency
		data errors.
		*/
		
	}

}
