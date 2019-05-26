package my.synchronizedconditions.producerconsumer;

import java.util.Date;
import java.util.LinkedList;

public class EventStorage {
	
	/*
	A classic problem in concurrent programming is the producer-consumer problem. We have
	a data buffer, one or more producers of data that save it in the buffer and one or more
	consumers of data that take it from the buffer.
	
	As the buffer is a shared data structure, we have to control the access to it using a
	synchronization mechanism such as the synchronized keyword, but we have more
	limitations. A producer can't save data in the buffer if it's full and the consumer can't take
	data from the buffer if it's empty.
	
	For these types of situations, Java provides the wait(), notify(), and notifyAll()
	methods implemented in the Object class. A thread can call the wait() method inside a
	synchronized block of code. If it calls the wait() method outside a synchronized block
	of code, the JVM throws an IllegalMonitorStateException exception. When the thread
	calls the wait() method, the JVM puts the thread to sleep and releases the object that
	controls the synchronized block of code that it's executing and allows the other threads to
	execute other blocks of synchronized code protected by that object. To wake up the thread,
	you must call the notify() or notifyAll() method inside a block of code protected by the
	same object.
	*/
	
	private int maxSize;
	private LinkedList<Date> storage;
	
	public EventStorage() {
		maxSize = 10;
		storage = new LinkedList<Date>();
	}
	
	/*
	Implemented synchronized method set() to store an event in the storage.
	First, check if the storage is full or not. If it's full, it calls the wait() method until
	the storage has empty space. At the end of the method, we call the notifyAll()
	method to wake up all the threads that are sleeping in the wait() method.
	*/
	public synchronized void set() {
		while(storage.size()==maxSize) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		storage.offer(new Date());
		System.out.println("Produce: "+storage.size());
		notifyAll();
	}
	
	/*
	Implemented synchronized method get() to get an event for the storage.
	First, check if the storage has events or not. If it has no events, it calls the wait()
	method until the storage has some events. At the end of the method, we call the
	notifyAll() method to wake up all the threads that are sleeping in the wait()
	method.
	*/
	public synchronized void get() {
		while(storage.size()==0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Consume: "+storage.size()+" value = "+storage.poll());
		notifyAll();
	}
}
