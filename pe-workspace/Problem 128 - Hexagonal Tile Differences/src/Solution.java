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
		
		ArrayList<Long> list = new ArrayList<Long>();
		
		for (long n = 1; list.size() < 2000; n++) {
			if (isPrime(6*n+1) && isPrime(6*n-1) && isPrime(12*n+5)) {
				list.add(3*n*n-3*n+2);
			}
			if (isPrime(6*n-1) && isPrime(12*n-7) && isPrime(6*n+5)) {
				list.add(3*n*n+3*n+1);
			}
		}
		
		return list.get(1999);
		
	}
	
	public static boolean isPrime(long n) {
		if (n < 2) return false;
		if (n < 4) return true;
		if (n % 2 == 0) return false;
		for (int k = 3; k*k <= n; k+=2) {
			if (n % k == 0) return false;
		}
		return true;
	}
	
}
