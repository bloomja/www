import java.util.ArrayList;

public class MyMathClassDemo {
	
	public static void main(String[] args) {
		
		MyMathClass<Integer> m = new MyMathClass<Integer>();
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(4);
		list.add(9);
		list.add(11);
		list.add(12);
		list.add(17);
		list.add(5);
		list.add(8);
		list.add(12);
		list.add(14);
		
		double sigma = m.standardDeviation(list);
		System.out.println("The standard deviation of the list is: " + sigma);
		
	}
	
}
