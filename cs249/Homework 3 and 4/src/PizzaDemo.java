
public class PizzaDemo {
	
	public static void main(String[] args) {
		Pizza pizza1 = new Pizza("large", 1, 0, 1);
		Pizza pizza2 = new Pizza("medium", 2, 2, 0);
		PizzaOrder order1 = new PizzaOrder();
		order1.setNumPizzas(2);
		order1.setPizza(0, pizza1);
		order1.setPizza(1, pizza2);
		double total1 = order1.calcTotal();
		
		PizzaOrder order2 = new PizzaOrder(order1);
		order2.getPizza(0).setCheese(3);
		double total2 = order2.calcTotal();
		double origTotal = order1.calcTotal();
		
		PizzaOrder order3 = new PizzaOrder();
		order3.setNumPizzas(5);
		order3.setPizza(0, new Pizza("large", 0, 0, 1));
		order3.setPizza(1, new Pizza("small", 1, 0, 1));
		order3.setPizza(2, new Pizza("medium", 1, 1, 0));
		order3.setPizza(3, new Pizza("medium", 2, 2, 0));
		order3.setPizza(4, new Pizza("large", 0, 1, 0));
		order3.setPizza(0, new Pizza("small", 1, 2, 0));
		double total3 = order3.calcTotal();
		
		System.out.println("Total price for order 1: $"+total1);
		System.out.println("Total price for order 2: $"+total2);
		System.out.println("Total price for original order: $"+origTotal);
		System.out.println("Total price for order 3: $"+total3);
	}
	
}
