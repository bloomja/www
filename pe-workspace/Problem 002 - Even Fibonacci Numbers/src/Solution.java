
public class Solution {
	
	public static void main(String[] args) {
		
		solution1(4000000);
		solution2(4000000);
		
	}
	
	public static void solution1(int n) {
		
		long start = System.currentTimeMillis();
		
		// initialize variables
		int sum = 0;
		int a = 1;
		int b = 1;
		
		// Loop until the Fibonacci number exceeds n (4000000)
		while (b < n) {
			if (b % 2 == 0) {
				sum += b; // Only add it if it's even
			}
			
			// Generate the next Fibonacci number
			int temp = a;
			a = b;
			b += temp;
		}
		
		long time = System.currentTimeMillis()-start;
		
		System.out.println("First Solution: " + sum);
		System.out.println("Runtime: " + (time/1000) + "." + (time%1000) + "s");
		
	}
	
	public static void solution2(int n) {
		
		long start = System.currentTimeMillis();
		
		// Sum starts at 2 because we're only adding the b values
		int sum = 2;
		int a = 2;
		int b = 8;
		
		// Same looping conditions
		while (b < n) {
			sum += b; // No need to check if it's even
			
			// Generate the next terms
			int temp = a;
			a = b;
			b = 4*b + temp;
		}
		
		long time = System.currentTimeMillis() - start;
		
		System.out.println("Second Solution: " + sum);
		System.out.println("Runtime: " + (time/1000) + "." + (time%1000) + "s");
		
	}
	
}
