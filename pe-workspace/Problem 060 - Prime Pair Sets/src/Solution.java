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
		long[] primes = sieve(1000000);
		int n = 10000;
		long minSum = Long.MAX_VALUE;
		for (int a = 0; primes[a] < n; a++) {
			for (int b = a+1; primes[b] < n; b++) {
				if (!concatable(primes, primes[a], primes[b])) continue;
				for (int c = b+1; primes[c] < n; c++) {
					if (!concatable(primes, primes[a], primes[c]) || !concatable(primes, primes[b], primes[c])) continue;
					for (int d = c+1; primes[d] < n; d++) {
						if (!concatable(primes, primes[a], primes[d]) || !concatable(primes, primes[b], primes[d]) || !concatable(primes, primes[c], primes[d])) continue;
						for (int e = d+1; primes[e] < n; e++) {
							if (!concatable(primes, primes[a], primes[e]) || !concatable(primes, primes[b], primes[e]) || !concatable(primes, primes[c], primes[e]) || !concatable(primes, primes[d], primes[e])) continue;
							if (primes[a]+primes[b]+primes[c]+primes[d]+primes[e] < minSum) {
								minSum = primes[a]+primes[b]+primes[c]+primes[d]+primes[e];
								return minSum;
							}
						}
					}
				}
			}
		}
		return minSum;
	}
	
	public static boolean concatable(long[] primes, long a, long b) {
		return (isPrime(primes, Long.parseLong(a+""+b)) && 
			isPrime(primes, Long.parseLong(b+""+a)));
	}
	
	public static boolean isPrime(long[] primes, long n) {
		if (n < 2) return false;
		if (n < 4) return true;
		if (n % 2 == 0) return false;
		if (n > primes[primes.length-1]) {
			for (int i = 3; i*i < n; i+=2) {
				if (n % i == 0) return false;
			}
			return true;
		}
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
		
	public static long[] sieve(int n) {
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
		long[] ret = new long[count];
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
