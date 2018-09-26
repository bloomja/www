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
		int[] primes = sieve(100000000);
		long sum = 1;
		for (int i = 0; i < primes.length; i++) {
			int n = primes[i] - 1;
			if (n % 4 != 2) continue;
			if (n % (primes[i]*primes[i]) == 0) continue;
			boolean good = true;
			for (int j = 1; j*j < n; j++) {
				if (n % j == 0) {
					if (!isPrime(primes, j + n/j)) {
						good = false;
						break;
					}
				}
			}
			if (good) {
				sum += n;
			}
		}
		return sum;
	}
	
	// Bianry Search for primes in array.
	public static boolean isPrime(int[] primes, int n) {
		int index = primes.length/2;
		int max = primes.length;
		int min = 0;
		while (true) {
			if (primes[index] > n) {
				if (primes[index-1] < n) return false;
				max = index;
				index = (min+index)/2;
			} else if (primes[index] < n) {
				if (primes[index+1] > n) return false;
				min = index;
				index = (index+max)/2;
			} else {
				return true;
			}
		}
	}
		
	public static int[] sieve(int n) {
		boolean[] b = new boolean[n];
		for (int i = 0; i < b.length; i++) {
			b[i] = true;
		}
		b[0] = false;
		b[1] = false;
		int count = 0;
		for (int i = 2; i < b.length; i++) {
			if (!b[i]) continue;
			for (int j = 2; i*j < b.length; j++) {
				b[i*j] = false;
			}
			count++;
		}
		int[] ret = new int[count];
		int i = 0;
		for (int j = 0; j < b.length; j++) {
			if (b[j]) {
				ret[i] = j;
				i++;
			}
		}
		return ret;
	}
	
}
