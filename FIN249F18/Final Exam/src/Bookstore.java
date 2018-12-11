public class Bookstore extends Notifiable {
	
	private int numSold = 0;
	
	public Bookstore (int interval) {
		super(interval);
	}
	
	public Bookstore (int interval, int numSold) {
		super(interval);
		this.numSold = numSold;
	}
	
	@Override
	public void doAlarm() {
		if (numSold == 0) {
			System.out.println("This is a book store, number of books sold unknown.");
		} else {
			System.out.println("This is a book store, we've sold " + numSold + " books.");
		}
	}
	
}
