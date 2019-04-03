import java.util.ArrayList;

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
		
		for (long n = 5; 3*n-1 < 1000000000; n += 2) {
			if ((3*n*n+2*n-1) % 4 == 0 && isSquare(3*n*n+2*n-1)) {
				sum += 3*n-1;
				System.out.println(n);
			} else if ((3*n*n-2*n-1) % 4 == 0 && isSquare(3*n*n-2*n-1)) {
				sum += 3*n+1;
				System.out.println(n);
			}
		}
		
		return sum;
	}
	
	public static boolean isSquare(long n) {
		double sqrt = Math.sqrt(n);
		long s_ = (long)sqrt;
		if (s_ * s_ == n) return true;
		if ((s_+1) * (s_+1) == n) return true;
		return false;
	}
	
}
