
public class PetDemo {
	
	public static void main(String[] args) {
		Pet[] pets = new Pet[] {new Dog("Luna", 2, 60), new Dog("Brutus", 10, 100), new Cat("Princess", 7, 20), new Cat("Jonah", 14, 35)};
		for (int i = 0; i < pets.length; i++) {
			System.out.println(pets[i].getName()+"'s recommended acepromazine dosage is "+pets[i].acepromazine());
			System.out.println(pets[i].getName()+"'s recommended carprofen dosage is "+pets[i].carprofen());
			System.out.println();
		}
	}
	
}
