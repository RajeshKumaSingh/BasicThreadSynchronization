package my.synchronizedlock.fairness;

public class MainThread {

	public static void main(String[] args) {
		PrintQueue printQueue = new PrintQueue();
		Job job = new Job(printQueue);
		
		Thread[] threads = new Thread[10];
		for(int i=0;i<10;i++) {
			threads[i] = new Thread(job, "Thread-"+i);
		}
		for(int i=0;i<10;i++) {
			threads[i].start();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	/*
	All threads are created with a difference of 0.1 seconds. The first thread that requests the
	control of the lock is Thread 0, then Thread 1, and so on. While Thread 0 is running the
	first block of code protected by the lock, we have nine threads waiting to execute that block
	of code. When Thread 0 releases the lock, immediately, it requests the lock again, so we
	have 10 threads trying to get the lock. As the fair mode is enabled, the Lock interface will
	choose Thread 1, so it's the thread that has been waiting for more time for the lock. Then, it
	chooses Thread 2, then, Thread 3, and so on. Until all the threads have passed the first block
	protected by the lock, none of them will execute the second block protected by the lock.
	Once all the threads have executed the first block of code protected by the lock, it's the turn of
	Thread 0 again. Then, it's the turn of Thread 1, and so on.
	*/
}
