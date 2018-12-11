
public class Student extends Notifiable {
	
	private double latitude = 0.0;
	private double longitude = 0.0;
	
	public Student (int interval) {
		super(interval);
	}
	
	public Student(int interval, double lat, double lon) {
		super(interval);
		this.latitude = lat;
		this.longitude = lon;
	}
	
	@Override
	public void doAlarm() {
		if (latitude == 0.0 && longitude == 0.0) {
			System.out.println("I am a student, coordinates unknown.");
		} else {
			System.out.println("I am a student with GPS coordinates at (" + latitude + ", " + longitude + ").");
		}
	}
	
}
