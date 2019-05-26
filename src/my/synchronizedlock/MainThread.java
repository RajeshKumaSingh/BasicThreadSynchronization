package my.synchronizedlock;

public class MainThread {

	public static void main(String[] args) {
		
		/*
		Java provides another mechanism for the synchronization of blocks of code. It's a more
		powerful and flexible mechanism than the synchronized keyword. It's based on the Lock
		interface and classes that implement it (as ReentrantLock). This mechanism presents
		some advantages, which are as follows:
		
		1. It allows the structuring of synchronized blocks in a more flexible way. With the
		synchronized keyword, you have to get and free the control over a synchronized
		block of code in a structured way. The Lock interfaces allow you to get more complex
		structures to implement your critical section.
		
		2. The Lock interfaces provide additional functionalities over the synchronized
		keyword. One of the new functionalities is implemented by the tryLock() method.
		This method tries to get the control of the lock and if it can't, because it's used by
		other thread, it returns the lock. With the synchronized keyword, when a thread
		(A) tries to execute a synchronized block of code, if there is another thread (B)
		executing it, the thread (A) is suspended until the thread (B) finishes the execution
		of the synchronized block. With locks, you can execute the tryLock() method. This
		method returns a Boolean value indicating if there is another thread running the
		code protected by this lock.
		
		3. The Lock interfaces allow a separation of read and write operations having multiple
		readers and only one modifier.
		
		4. The Lock interfaces offer better performance than the synchronized keyword.
		*/
		
		PrintQueue printQueue = new PrintQueue();
		Job job = new Job(printQueue);
		
		Thread[] threads = new Thread[10];
		for(int i=0;i<10;i++) {
			threads[i] = new Thread(job, "Thread-"+i);
		}
		for(int i=0;i<10;i++) {
			threads[i].start();
		}
	}

}
