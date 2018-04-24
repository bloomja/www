
public class Solution {
	
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		long ans = solution(100);
		long time = System.currentTimeMillis() - start;
		
		System.out.println("Solution: " + ans);
		System.out.println("Runtime: " + (time/1000) + "." + (time%1000) + "s");
		
	}
	
	public static long solution(int n) {
		
		// Find the sum of squares
		long sumOfSquares = 0;
		for (int i = 1; i <= n; i++) {
			sumOfSquares += i*i;
		}
		
		// Finds the square of the sum using
		// sum(n) = n*(n+1)/2
		long squareOfSum = n*n*(n+1)*(n+1)/4;
		
		
		return Math.abs(sumOfSquares-squareOfSum);
		
	}
	
}
