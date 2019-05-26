package my.synchronizedconditions.producerconsumer;

public class MainThread {

	public static void main(String[] args) {
		EventStorage storage = new EventStorage();
		
		Producer producer = new Producer(storage);
		Consumer consumer = new Consumer(storage);
		
		Thread producerThread = new Thread(producer);
		Thread consumerThread = new Thread(consumer);
		
		producerThread.start();
		consumerThread.start();
		
	}

}
