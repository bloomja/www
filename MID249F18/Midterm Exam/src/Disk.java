
public class Disk extends Item {
	
	public Disk (String br) {
		super(br);
	}
	
	@Override
	public boolean equals(Object otherItem) {
		if (!(otherItem instanceof Disk)) return false;
		return this.brand.equals(((Disk)otherItem).brand);
	}
	
	@Override
	public String toString() {
		return brand + " disk";
	}
	
}
