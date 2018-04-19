
public class Solution {
	
	public static void main(String[] args) {
		
		linearSolution(1000);
		boundedSolution(1000);
		
	}
	
	public static void boundedSolution(int n) {
		
		long startTime = System.currentTimeMillis();
		
		int sum = 0;
		int num3  = (n-1)/3;
		int num5  = (n-1)/5;
		int num15 = (n-1)/15;
		
		sum += ( 3 +  3 *  num3) *  num3 / 2;
		sum += ( 5 +  5 *  num5) *  num5 / 2;
		sum -= (15 + 15 * num15) * num15 / 2;
		
		long time = System.currentTimeMillis() - startTime;
		
		System.out.println("Bounded Solution: " + sum);
		System.out.println("Runtime: " + (time/1000) + "." + (time%1000) + "s");
		
	}
	
	public static void linearSolution(int n) {
		
		long startTime = System.currentTimeMillis();
		
		int sum = 0;
		
		for (int i = 0; i < n; i++) {
			if (i % 3 == 0 || i % 5 == 0) {
				sum += i;
			}
		}
		
		long time = System.currentTimeMillis() - startTime;
		
		System.out.println("Linear Solution: " + sum);
		System.out.println("Runtime: " + (time/1000) + "." + (time%1000) + "s");
		
	}
	
}
