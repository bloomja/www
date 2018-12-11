public class Driver {
	
	private static final long TICK_TIME = 50;
	
	public static void main(String[] args) {
		
		// Set notifier to start at time 0
		Notifier notifier = new Notifier(0);
		
		// Registering items to give a starting point for the program.
		Student bloomja = new Student(13, -43.1009, -75.2327);
		notifier.registerObject(bloomja);
		notifier.registerObject(new Faculty(12, "(315)-1092-9332"));
		notifier.registerObject(new Bookstore(10, 1296));
		
		// The loop that constantly ticks on, also registering objects sometimes.
		while(true) {
			notifier.tick();
			try {
				Thread.sleep(TICK_TIME);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
			// The following will randomly add objects to the notifier over time, and also has a chance to stop the program.
			// This is necessary since we are in an infinite loop.
			double d = Math.random();
			
			if (d < 0.01) {
				System.exit(0);
			} else if (d < .11) {
				notifier.registerObject(new Student((int)(20*Math.random()+5)));
			} else if (d < .21) {
				notifier.registerObject(new Faculty((int)(20*Math.random()+5)));
			} else if (d < .31) {
				notifier.registerObject(new Bookstore((int)(20*Math.random()+5)));
			}
			
		}	
	}
	
}
