
public class Faculty extends Notifiable {
	
	private String phoneNumber = "(000)-000-0000";
	
	public Faculty (int interval) {
		super(interval);
	}
	
	public Faculty (int interval, String num) {
		super(interval);
		this.phoneNumber = num;
	}
	
	@Override
	public void doAlarm() {
		if (phoneNumber.equals("(000)-000-0000")) {
			System.out.println("I am a faculty member, phone number unknown.");
		} else {
			System.out.println("I am a faculty member, whose phone number is " + phoneNumber+".");
		}
	}
	
}
