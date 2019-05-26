package my.synchronizedlock.readwrite;

public class Writer implements Runnable {

	private PriceInfo priceInfo;

	public Writer(PriceInfo priceInfo) {
		this.priceInfo = priceInfo;
	}

	@Override
	public void run() {
		for(int i=0;i<3;i++) {
			System.out.println("Writer: Attempt to modif the prices");
			priceInfo.setPrices(Math.random()*10, Math.random()*8);
			System.out.println("Writer: Prices have been modified");
			
			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
