
public class Solution {
	
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		long ans = solution(600851475143L);
		long time = System.currentTimeMillis() - start;
		
		System.out.println("Solution: " + ans);
		System.out.println("Runtime: " + (time/1000) + "." + (time%1000) + "s");
		
	}
	
	public static long solution(long n) {
		
		// Returns 0 because it has no prime factors.
		if (n < 2) return 0;
		
		long highest = n;
		long num = n;
		
		// This block takes care of 2, because it is a separate case.
		while (num % 2 == 0) {
			num /= 2;
			highest = 2;
		}
		// This checks if it is a power of 2
		if (num == 1) return 2;
		
		long factor = 3;
		// Since there can be at most one factor greater than the
		// square root of the number, if we try testing a number
		// greater than that, our factor must be what's left.
		while (factor <= Math.sqrt(n)) {
			// Keep dividing until you can't
			while (num % factor == 0) {
				num /= factor;
				highest = factor;
			}
			if (num == 1) return factor; // If we completely reduce it
			factor += 2;
		}
		if (factor > Math.sqrt(n)) {
			highest = num; // Sets what's left as the solution
		}
		
		return highest;
		
	}
	
}
