
public class Cat extends Pet {
	
	// Constructors
	public Cat() {
		super();
	}
	
	public Cat (String name) {
		super(name);
	}
	
	public Cat (int age) {
		super(age);
	}
	
	public Cat (double weight) {
		super(weight);
	}
	
	public Cat (String name, int age, double weight) {
		super(name, age, weight);
	}
	
	// Other Methods
	public double acepromazine() {
		double mgPerMl = 10;
		double mgPerKg = 0.002;
		return weight / 2.2 * mgPerKg / mgPerMl;
	}
	
	public double carprofen() {
		double mgPerMl = 12;
		double mgPerKg = 0.25;
		return weight / 2.2 * mgPerKg / mgPerMl;
	}
	
}
