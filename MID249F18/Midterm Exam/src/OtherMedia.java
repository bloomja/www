
public class OtherMedia extends Item {
	
	public OtherMedia (String br) {
		super(br);
	}
	
	@Override
	public boolean equals(Object otherItem) {
		if (!(otherItem instanceof OtherMedia)) return false;
		return this.brand.equals(((OtherMedia)otherItem).brand);
	}
	
	@Override
	public String toString() {
		return brand + " media device";
	}
	
}
