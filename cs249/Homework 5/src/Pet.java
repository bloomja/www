
public abstract class Pet {
	
	protected String name;
	protected int age; // in years
	protected double weight; // in pounds
	
	// Constructors
	public Pet() {
		name = "No name yet.";
		age = 0;
		weight = 0;
	}
	
	public Pet (String initialName, int initialAge, double initialWeight) {
		name = initialName;
		if (initialAge < 0 || initialWeight < 0) {
			System.out.println("Error: Negative age or weight.");
			System.exit(0);
		} else {
			age = initialAge;
			weight = initialWeight;
		}
	}
	
	public Pet (String initialName) {
		name = initialName;
		age = 0;
		weight = 0;
	}
	
	public Pet (int initialAge) {
		name = "No name yet.";
		weight = 0;
		if (initialAge < 0) {
			System.out.println("Error: Negative age.");
			System.exit(0);
		} else {
			age = initialAge;
		}
	}
	
	public Pet (double initialWeight) {
		name = "No name yet.";
		age = 0;
		if (initialWeight < 0) {
			System.out.println("Error: Negative weight.");
			System.exit(0);
		} else {
			weight = initialWeight;
		}
	}
	
	// Setter Methods
	public void set (String newName, int newAge, double newWeight) {
		name = newName;
		if (newAge < 0 || newWeight < 0) {
			System.out.println("Error: Negative age or weight.");
			System.exit(0);
		} else {
			age = newAge;
			weight = newWeight;
		}
	}

	public void setName (String newName) {
		name = newName;
	}
	
	public void setAge(int newAge) {
		if (newAge < 0) {
			System.out.println("Error: Negative age.");
			System.exit(0);
		} else {
			age = newAge;
		}
	}
	
	public void setWeight (double newWeight) {
		if (newWeight < 0) {
			System.out.println("Error: Negative weight.");
			System.exit(0);
		} else {
			weight = newWeight;
		}
	}
	
	// Getter Methods
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	public double getWeight() {
		return weight;
	}
	
	// Abstract Methods
	public abstract double acepromazine();
	public abstract double carprofen();
	
	// Other Methods
	public String toString() {
		return "Name: " + name + " Age: " + age + " years" + "\nWeight: " + weight + " pounds";
	}
	
}
