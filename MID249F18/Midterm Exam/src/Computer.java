
public class Computer extends Item {
	
	public Computer (String br) {
		super(br);
	}
	
	@Override
	public boolean equals(Object otherItem) {
		if (!(otherItem instanceof Computer)) return false;
		return (this.brand.equals(((Computer)otherItem).brand));
	}
	
	@Override
	public String toString() {
		return brand + " computer";
	}
	
}
