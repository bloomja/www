
public abstract class Notifiable {
	
	private int wakeUpInterval;
	
	public Notifiable(int interval) {
		setAlarm(interval);
	}
	
	public abstract void doAlarm();
	
	public void setAlarm(int numTicks) {
		wakeUpInterval = numTicks;
	}
	
	public int getWakeUpInterval() {
		return wakeUpInterval;
	}
	
}
