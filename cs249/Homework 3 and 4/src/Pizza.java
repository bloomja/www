
public class Pizza {
	
	private String size;
	private int numCheese;
	private int numPep;
	private int numHam;
	
	// Constructors
	public Pizza (String size, int cheese, int pep, int ham) {
		this.size = size;
		this.numCheese = cheese;
		this.numPep = pep;
		this.numHam = ham;
	}
	
	public Pizza (Pizza p) {
		this.size = p.getSize();
		this.numCheese = p.getCheese();
		this.numPep = p.getPepperoni();
		this.numHam = p.getHam();
	}
	
	// Getter methods
	public String getSize()   { return this.size; }
	public int getCheese() 	  { return this.numCheese; }
	public int getPepperoni() { return this.numPep; }
	public int getHam() 	  { return this.numHam; }
	
	// Setter methods
	public void setSize(String size)  { this.size = size; }
	public void setCheese(int cheese) { this.numCheese = cheese; }
	public void setPepperoni(int pep) { this.numPep = pep; }
	public void setHam(int ham) 	  { this.numHam = ham; }
	
	public double calcCost() {
		if (size.equals("small")) {
			return 10 + 2*numCheese + 2*numPep + 2*numHam;
		} else if (size.equals("medium")) {
			return 12 + 2*numCheese + 2*numPep + 2*numHam;
		} else {
			return 14 + 2*numCheese + 2*numPep + 2*numHam;
		}
	}
	
	public String getDescription() {
		return "A "+size+" pizza with "+numCheese+" cheese, "+numPep+" pepperoni, and "+numHam+" ham for $"+calcCost();
	}
	
	public static void main(String[] args) {
		Pizza a = new Pizza("large", 1, 1, 2);
		Pizza b = new Pizza("medium", 1, 1, 0);
		Pizza c = new Pizza("large", 2, 3, 0);
		
		System.out.println(a.getDescription());
		System.out.println(b.getDescription());
		System.out.println(c.getDescription());
	}
	
}
