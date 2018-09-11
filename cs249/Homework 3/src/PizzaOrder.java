
public class PizzaOrder {
	
	private Pizza pizza1;
	private Pizza pizza2;
	private Pizza pizza3;
	private int numPizzas;
	
	// Constructors
	public PizzaOrder() {} // Default Constructor
	
	public PizzaOrder(PizzaOrder po) {
		this.numPizzas = po.getNumPizzas();
		this.pizza1 = new Pizza(po.getPizza1().getSize(), po.getPizza1().getCheese(), po.getPizza1().getPepperoni(), po.getPizza1().getHam());
		if (po.numPizzas > 1) this.pizza2 = new Pizza(po.getPizza2().getSize(), po.getPizza2().getCheese(), po.getPizza2().getPepperoni(), po.getPizza2().getHam());
		if (po.numPizzas > 2) this.pizza3 = new Pizza(po.getPizza3().getSize(), po.getPizza3().getCheese(), po.getPizza3().getPepperoni(), po.getPizza3().getHam());
	}
	
	// Getter methods
	public Pizza getPizza1() { return this.pizza1; }
	public Pizza getPizza2() { return this.pizza2; }
	public Pizza getPizza3() { return this.pizza3; }
	public int getNumPizzas() { return this.numPizzas; }
	
	// Setter methods
	public void setPizza1(Pizza pizza1) { this.pizza1 = pizza1; }
	public void setPizza2(Pizza pizza2) { this.pizza2 = pizza2; }
	public void setPizza3(Pizza pizza3) { this.pizza3 = pizza3; }
	
	public void setNumPizzas(int num) {
		if (num >= 1 && num <= 3) {
			this.numPizzas = num;
		} else {
			System.out.println("Invalid number of pizzas.");
		}
	}
	
	public double calcTotal() {
		double total =  pizza1.calcCost();
		if (numPizzas >= 2) {
			total += pizza2.calcCost();
		} if (numPizzas == 3) {
			total += pizza3.calcCost();
		}
		return total;
	}
	
	public static void main(String[] args) {
		Pizza pizza1 = new Pizza("large", 1, 0, 1);
		Pizza pizza2 = new Pizza("medium", 2, 2, 0);
		PizzaOrder order1 = new PizzaOrder();
		order1.setNumPizzas(2);
		order1.setPizza1(pizza1);
		order1.setPizza2(pizza2);
		double total1 = order1.calcTotal();
		
		PizzaOrder order2 = new PizzaOrder(order1);
		order2.getPizza1().setCheese(3);
		double total2 = order2.calcTotal();
		double origTotal = order1.calcTotal();
		
		System.out.println("Total price for order 1: $"+total1);
		System.out.println("Total price for order 2: $"+total2);
		System.out.println("Total price for original order: $"+origTotal);
	}
	
}
