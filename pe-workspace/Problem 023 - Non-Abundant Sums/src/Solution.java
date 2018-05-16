
public class Solution {
	
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		
		long solution = solution(28123);
		
		long time = System.currentTimeMillis() - start;
		
		System.out.println("Solution: " + solution);
		System.out.println("Runtime: " + (time/1000) + "." + (time%1000) + "s");
		
	}
	
	public static long solution(int n) {
		boolean[] abundant = new boolean[n];
		for (int i = 0; i < n; i++) {
			abundant[i] = isAbundant(i+1);
		}
		boolean[] sumOf = new boolean[n];
		for (int i = 0; i < n; i++) {
			if (abundant[i]) {
				for (int j = 0; i+j+1 < n; j++) {
					if (abundant[j]) {
						sumOf[i+j+1] = true;
					}
				}
			}
		}
		long sum = 0;
		for (int i = 0; i < n; i++) {
			if (!sumOf[i]) {
				sum += i+1;
			}
		}
		return sum;
	}
	
	public static boolean isAbundant(int n) {
		int sum = 0;
		for (int i = 1; i <= Math.sqrt(n); i++) {
			if (i == Math.sqrt(n)) {
				sum += i;
			} else if (n % i == 0) {
				sum += i + n/i;
			}
		}
		return sum - n > n;
	}
	
}
