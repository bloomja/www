import java.util.ArrayList;

public class Notifier {
	
	public int count = -1;
	public ArrayList<Notifiable> subjects = new ArrayList<Notifiable>();
	
	public Notifier(int t0) {
		this.count = t0;
	}
	
	public void tick() {
		check();
		System.out.println("Count: " + (count + 1));
		count++;
	}
	
	public void registerObject(Notifiable newObject) {
		subjects.add(newObject);
	}
	
	private void check() {
		for (int i = 0; i < subjects.size(); i++) {
			if (count % subjects.get(i).getWakeUpInterval() == 0) {
				subjects.get(i).doAlarm();
			}
		}
	}
	
}
