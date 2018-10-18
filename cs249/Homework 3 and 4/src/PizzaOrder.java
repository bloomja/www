
public class PizzaOrder {
	
	private Pizza[] pizzas;
	private int numPizzas;
	
	// Constructors
	public PizzaOrder() {
		this.numPizzas = 0;
		this.pizzas = new Pizza[] {};
	}
	
	public PizzaOrder(PizzaOrder po) {
		this.numPizzas = po.getNumPizzas();
		this.pizzas = new Pizza[this.numPizzas];
		for (int i = 0; i < this.numPizzas; i++) {
			if (po.getPizza(i) != null) {
				pizzas[i] = new Pizza(po.getPizza(i));
			}
		}
	}
	
	// Getter methods
	public Pizza getPizza(int index) { return this.pizzas[index]; }
	public int getNumPizzas() { return this.numPizzas; }
	
	// Setter methods
	public void setPizza(int index, Pizza pizza) {
		if (index >= this.numPizzas) {
			this.setNumPizzas(index+1);
		}
		this.pizzas[index] = new Pizza(pizza);
	}
	
	public void setNumPizzas(int num) {
		if (num == this.numPizzas) return;
		if (num < this.numPizzas) {
			this.numPizzas = num;
			Pizza[] pizzas = new Pizza[num];
			for (int i = 0; i < num; i++) {
				if (this.pizzas[i] != null) {
					pizzas[i] = new Pizza(this.pizzas[i]);
				}
			}
			this.pizzas = pizzas;
		} else {
			Pizza[] pizzas = new Pizza[num];
			for (int i = 0; i < this.pizzas.length; i++) {
				if (this.pizzas[i] != null) {
					pizzas[i] = new Pizza(this.pizzas[i]);
				}
			}
			this.pizzas = pizzas;
			this.numPizzas = num;
		}
	}
	
	// Other methods
	public double calcTotal() {
		double total = 0;
		for (int i = 0; i < this.numPizzas; i++) {
			if (this.pizzas[i] != null) {
				total += this.pizzas[i].calcCost();
			}
		}
		return total;
	}
	
}
