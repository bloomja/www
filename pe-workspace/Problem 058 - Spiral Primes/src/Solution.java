import java.math.BigInteger;

public class Solution {
	
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		
		long solution = solution();
		
		long time = System.currentTimeMillis() - start;
		
		System.out.println("Solution: " + solution);
		System.out.println("Runtime: " + (time/1000) + "." + (time%1000) + "s");
		
	}
	
	public static long solution() {
		int n = 1;
		int p = 0;
		do {
			n += 2;
			int a = n*n-  (n-1);
			int b = n*n-2*(n-1);
			int c = n*n-3*(n-1);
			if (BigInteger.valueOf(a).isProbablePrime(1000)) p++;
			if (BigInteger.valueOf(b).isProbablePrime(1000)) p++;
			if (BigInteger.valueOf(c).isProbablePrime(1000)) p++;
		} while (p * 10 >= 4*(n+1)/2+1) ;
		return n+2;
	}
	
	public static int[] sieve(int n) {
		boolean[] b = new boolean[n];
		for (int i = 0; i < b.length; i++) {
			b[i] = true;
		}
		b[0] = false;
		b[1] = false;
		int c = 0;
		for (int i = 2; i < b.length; i++) {
			if (!b[i]) continue;
			else c++;
			for (int j = 2; i*j < b.length; j++) {
				b[i*j] = false;
			}
		}
		int[] primes = new int[c];
		int d = 0;
		for (int i = 0; i < b.length; i++) {
			if (b[i]) {
				primes[d] = i;
				d++;
			}
		}
		return primes;
	}
	
}
