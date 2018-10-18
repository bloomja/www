import java.io.Serializable;

public class Date implements Serializable {
	
	private String month;
	private int day;
	private int year;
	
	public Date (String monthString, int day, int year) {
		setDate (monthString, day, year);
	}
	
	public Date (Date aDate) {
		if (aDate == null) {
			System.out.println("Fatal Error");
			System.exit(0);
		}
		month = aDate.month;
		day = aDate.day;
		year = aDate.year;
	}
	
	public void setDate (String monthString, int day, int year) {
		if (dateOK(monthString, day, year)) {
			this.month = monthString;
			this.day = day;
			this.year = year;
		} else {
			System.out.println("Fatal Error");
			System.exit(0);
		}
	}
	
	public void setYear (int year) {
		if (year < 1000 || year > 9999) {
			System.out.println("Fatal Error");
			System.exit(0);
		} else {
			this.year = year;
		}
	}
	
	public int getAge(Date today) {
		if (!this.precedes(today)) {
			System.out.println("Negative age. Aborting.");
			System.exit(0);
		}
		int yearDiff = today.year - this.year;
		Date fakeDate = new Date(today.month, today.day, this.year);
		if (fakeDate.precedes(this)) {
			return yearDiff - 1;
		} else {
			return yearDiff;
		}
	}
	
	public String toString() {
		return month + " " + day + ", " + year;
	}
	
	public boolean equals(Date otherDate) {
		return this.month.equals(otherDate.month) && this.day == otherDate.day && this.year == otherDate.year;
	}
	
	public boolean precedes (Date otherDate) {
		if (this.year < otherDate.year) return true;
		if (this.year > otherDate.year) return false;
		if (this.month.equals(otherDate.month)) {
			if (this.day < otherDate.day) return true;
			if (this.day > otherDate.day) return false;
		}
		int thisMonth = 0;
		int thatMonth = 0;
		if (this.month.equals("January")) thisMonth = 1;
		if (this.month.equals("February")) thisMonth = 2;
		if (this.month.equals("March")) thisMonth = 3;
		if (this.month.equals("April")) thisMonth = 4;
		if (this.month.equals("May")) thisMonth = 5;
		if (this.month.equals("June")) thisMonth = 6;
		if (this.month.equals("July")) thisMonth = 7;
		if (this.month.equals("August")) thisMonth = 8;
		if (this.month.equals("September")) thisMonth = 9;
		if (this.month.equals("October")) thisMonth = 10;
		if (this.month.equals("November")) thisMonth = 11;
		if (this.month.equals("December")) thisMonth = 12;
		if (otherDate.month.equals("January")) thatMonth = 1;
		if (otherDate.month.equals("February")) thatMonth = 2;
		if (otherDate.month.equals("March")) thatMonth = 3;
		if (otherDate.month.equals("April")) thatMonth = 4;
		if (otherDate.month.equals("May")) thatMonth = 5;
		if (otherDate.month.equals("June")) thatMonth = 6;
		if (otherDate.month.equals("July")) thatMonth = 7;
		if (otherDate.month.equals("August")) thatMonth = 8;
		if (otherDate.month.equals("September")) thatMonth = 9;
		if (otherDate.month.equals("October")) thatMonth = 10;
		if (otherDate.month.equals("November")) thatMonth = 11;
		if (otherDate.month.equals("December")) thatMonth = 12;
		if (thisMonth < thatMonth) return true;
		return false;
	}
	
	public boolean dateOK (String monthString, int dayInt, int yearInt) {
		if (yearInt < 1000 || yearInt > 9999) return false;
		if (monthString.equals("January")) {
			if (dayInt > 31) return false;
		} else if (monthString.equals("February")) {
			if (dayInt > 29) return false;
			if (yearInt % 4 != 0 && dayInt > 28) return false;
		} else if (monthString.equals("March")) {
			if (dayInt > 31) return false;
		} else if (monthString.equals("April")) {
			if (dayInt > 30) return false;
		} else if (monthString.equals("May")) {
			if (dayInt > 31) return false;
		} else if (monthString.equals("June")) {
			if (dayInt > 30) return false;
		} else if (monthString.equals("July")) {
			if (dayInt > 31) return false;
		} else if (monthString.equals("August")) {
			if (dayInt > 31) return false;
		} else if (monthString.equals("September")) {
			if (dayInt > 30) return false;
		} else if (monthString.equals("October")) {
			if (dayInt > 31) return false;
		} else if (monthString.equals("November")) {
			if (dayInt > 30) return false;
		} else if (monthString.equals("December")) {
			if (dayInt > 31) return false;
		} else {
			return false;
		}
		return true;
	}
	
}
