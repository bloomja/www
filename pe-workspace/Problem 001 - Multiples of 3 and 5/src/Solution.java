
public class Solution {
	
	public static void main(String[] args) {
		
		// We'll check both solutions to see if they match up
		linearSolution(1000);
		boundedSolution(1000);
		
	}
	
	public static void linearSolution(int n) {
		
		long startTime = System.currentTimeMillis();
		
		int sum = 0;
		
		// Loop through all the values from 1 to n
		for (int i = 0; i < n; i++) {
			if (i % 3 == 0 || i % 5 == 0) {
				sum += i; // Only count a number towards the sum if it is divisible by 3 or 5
			}
		}
		
		long time = System.currentTimeMillis() - startTime;
		
		System.out.println("Linear Solution: " + sum);
		System.out.println("Runtime: " + (time/1000) + "." + (time%1000) + "s");
		
	}
	
	public static void boundedSolution(int n) {
		
		long startTime = System.currentTimeMillis();
		
		int sum = 0;
		int num3  = (n-1)/3; // This represents the number of multiples of 3 there are
		int num5  = (n-1)/5; // This represents the number of multiples of 5 there are
		int num15 = (n-1)/15; // This represents the number of multiples of 15 there are
		
		sum += (3 +  3*num3) *  num3/2; // This should be the sum of all multiples of 3
		sum += (5 +  5*num5) *  num5/2; // This should be the sum of all multiples of 5
		sum -= (15 + 15*num15) * num15/2; // This should be the sum of all multiples of 15
		
		long time = System.currentTimeMillis() - startTime;
		
		System.out.println("Bounded Solution: " + sum);
		System.out.println("Runtime: " + (time/1000) + "." + (time%1000) + "s");
		
	}
	
}
