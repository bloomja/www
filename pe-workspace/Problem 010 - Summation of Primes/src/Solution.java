import java.math.BigInteger;
import java.util.ArrayList;

public class Solution {
	
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		
		long solution = solution(2000000);
		
		long time = System.currentTimeMillis() - start;
		
		System.out.println("Solution: " + solution);
		System.out.println("Runtime: " + (time/1000) + "." + (time%1000) + "s");
		
	}
	
	public static long solution(int n) {
		boolean[] isPrime = new boolean[n/2-1];
		for (int i = 0; i < isPrime.length; i++) isPrime[i] = true;
		ArrayList<Integer> primes = new ArrayList<Integer>();
		for (int i = 0; 2*i+3 < n; i++) {
			if (isPrime[i]) {
				primes.add(2*i+3);
				for (int j = 1; i+(2*i+3)*j < n/2-1; j++) {
					isPrime[i+(2*i+3)*j] = false;
				}
			}
		}
		long sum = 2;
		for (int i : primes) {
			sum += i;
		}
		return sum;
	}
	
}
