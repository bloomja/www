
public class Solution {
	
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		
		long solution = solution(500);
		
		long time = System.currentTimeMillis() - start;
		
		System.out.println("Solution: " + solution);
		System.out.println("Runtime: " + (time/1000) + "." + (time%1000) + "s");
		
	}
	
	public static long solution(int divisors) {
		int i = 1;
		while (true) {
			if (numDivisors(triangle(i)) >= divisors)
				return triangle(i);
			i++;
		}
	}
	
	public static int numDivisors(int n) {
		int count = 0;
		for (int i = 1; i <= Math.sqrt(n); i++) {
			if (i == Math.sqrt(n)) count++;
			else {
				if (n % i == 0) count += 2;
			}
		}
		return count;
	}
	
	public static int triangle(int n) {
		return n*(n+1)/2;
	}
	
}
