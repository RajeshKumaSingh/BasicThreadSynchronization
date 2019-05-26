package my.synchronizedattribute;

public class MainThread {
	
	public static void main(String[] args) {
		
		/*
		In this example, we have an object that controls access to the
		vacanciesCinema1 attribute, so only one thread can modify
		this attribute each time, and another object controls access to the
		vacanciesCinema2 attribute, so only one thread can modify
		this attribute each time. But there may be two threads running
		simultaneously, one modifying the vacancesCinema1 attribute and
		the other one modifying the vacanciesCinema2 attribute.
		*/
		
		Cinema cinema = new Cinema();
		
		TicketOffice1 ticketOffice1= new TicketOffice1(cinema);
		TicketOffice2 ticketOffice2= new TicketOffice2(cinema);
		
		Thread thread1 = new Thread(ticketOffice1);
		Thread thread2 = new Thread(ticketOffice2);
		
		thread1.start();
		thread2.start();
		
		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Room 1 Vacancies: "+cinema.getVacanciesCinema1());
		System.out.println("Room 2 Vacancies: "+cinema.getVacanciesCinema2());
	}
}
