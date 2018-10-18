
public class Dog extends Pet {
	
	// Constructors
	public Dog() {
		super();
	}
	
	public Dog (String name, int age, double weight) {
		super(name, age, weight);
	}
	
	public Dog (String name) {
		super(name);
	}
	
	public Dog (int age) {
		super(age);
	}
	
	public Dog (double weight) {
		super(weight);
	}
	
	// Other Methods
	public double acepromazine() {
		double mgPerMl = 10;
		double mgPerKg = 0.03;
		return weight / 2.2 * mgPerKg / mgPerMl;
	}
	
	public double carprofen() {
		double mgPerMl = 12;
		double mgPerKg = 0.5;
		return weight / 2.2 * mgPerKg / mgPerMl;
	}
	
}
