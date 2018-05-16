
public class Solution {
	
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		
		long solution = solution(10000);
		
		long time = System.currentTimeMillis() - start;
		
		System.out.println("Solution: " + solution);
		System.out.println("Runtime: " + (time/1000) + "." + (time%1000) + "s");
		
	}
	
	public static long solution(int n) {
		long sum = 0;
		for (int i = 1; i < n; i++) {
			int d = divisorSum(i);
			if (d > i && divisorSum(d) == i) {
				sum += i + d;
			}
		}
		return sum;
	}
	
	public static int divisorSum(int n) {
		int sum = 0;
		for (int i = 1; i <= Math.sqrt(n); i++) {
			if (i == Math.sqrt(n)) {
				sum += i;
			} else if (n % i == 0) {
				sum += i + n/i;
			}
		}
		return sum - n;
	}
	
}
