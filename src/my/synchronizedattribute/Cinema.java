package my.synchronizedattribute;

public class Cinema {
	
	/*
	When you use the synchronized keyword to protect a block of code, you must pass an
	object reference as a parameter. Normally, you will use the this keyword to reference the
	object that executes the method, but you can use other object references. Normally, these
	objects will be created exclusively with this purpose. For example, if you have two independent
	attributes in a class shared by multiple threads, you must synchronize the access to each
	variable, but there is no problem if there is one thread accessing one of the attributes and
	another thread accessing the other at the same time.
	*/

	private long vacanciesCinema1;
	private long vacanciesCinema2;
	
	public long getVacanciesCinema1() {
		return vacanciesCinema1;
	}

	public long getVacanciesCinema2() {
		return vacanciesCinema2;
	}

	private final Object controlCinema1, controlCinema2;
	
	public Cinema() {
		controlCinema1 = new Object();
		controlCinema2 = new Object();
		vacanciesCinema1 = 20;
		vacanciesCinema2 = 20;
	}
	
	/*
	Implemented sellTickets1() method that is called when some tickets for the
	first cinema are sold. It uses the controlCinema1 object to control the access to
	the synchronized block of code.
	*/
	
	public boolean sellTickets1(int number) {
		synchronized(controlCinema1) {
			if(number < vacanciesCinema1) {
				vacanciesCinema1 -= number;
				return true;
			}
			return false;
		}
	}
	
	/*
	Implemented sellTickets2() method that is called when some tickets for the
	second cinema are sold. It uses the controlCinema2 object to control the access
	to the synchronized block of code.
	*/
	
	public boolean sellTickets2(int number) {
		synchronized(controlCinema2) {
			if(number < vacanciesCinema2) {
				vacanciesCinema2 -= number;
				return true;
			}
			return false;
		}
	}
	
	/*
	Implemented returnTickets1() method that is called when some tickets for the
	first cinema are returned. It uses the controlCinema1 object to control the access
	to the synchronized block of code.
	*/
	public boolean returnTickets1(int number) {
		synchronized(controlCinema1) {
			vacanciesCinema1 += number;
			return true;
		}
	}
	
	/*
	Implemented returnTickets2() method that is called when some tickets for
	the second cinema are returned. It uses the controlCinema2 object to control the
	access to the synchronized block of code.
	*/
	public boolean returnTickets2(int number) {
		synchronized(controlCinema2) {
			vacanciesCinema2 += number;
			return true;
		}
	}
}
