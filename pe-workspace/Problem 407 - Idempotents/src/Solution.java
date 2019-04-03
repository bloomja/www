
public class Solution {
	
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		
		long solution = solution();
		
		long time = System.currentTimeMillis() - start;
		
		System.out.println("Solution: " + solution);
		System.out.println("Runtime: " + (time/1000) + "." + (time%1000) + "s");
		
	}
	
	public static long solution() {
		long sum = 0;
		for (long n = 10000000; n >= 1; n--) {
			long j = n-1;
			while ((j*j) % n != j) {
				j--;
			}
			if (n % 1000 == 0) System.out.println("M("+n+") = "+j);
			sum += j;
		}
		return sum;
	}
	
}
