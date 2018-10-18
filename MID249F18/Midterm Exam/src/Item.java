
public class Item {
	
	protected String brand;
	
	public Item (String br) {
		brand = br;
	}
	
	@Override
	public boolean equals(Object otherItem) {
		if (!(otherItem instanceof Item)) return false;
		else if (this.brand.equals(((Item)otherItem).brand)) {
			return (this instanceof Computer && otherItem instanceof Computer)
					|| (this instanceof Disk && otherItem instanceof Disk)
					|| (this instanceof OtherMedia && otherItem instanceof OtherMedia);
		}
		return false;
	}
	
	public String toString() {
		return brand + " product.";
	}
	

}