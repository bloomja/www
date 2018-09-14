
public class Solution {
	
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		
		long solution = solution();
		
		long time = System.currentTimeMillis() - start;
		
		System.out.println("Solution: " + solution);
		System.out.println("Runtime: " + (time/1000) + "." + (time%1000) + "s");
		
	}
	
	public static long solution() {
		int max = 1000000;
		int[] primes = sieve(max);
		int[] sum = new int[primes.length];
		sum[0] = 2;
		for (int i = 1; i < primes.length; i++) {
			sum[i] = sum[i-1] + primes[i];
		}
		int n = 0;
		int ans = 0;
		for (int i = 0; i < primes.length; i++) {
			for (int j = i-n-1; j >= 0; j--) {
				if (sum[i]-sum[j] > max) break;
				if (isPrime(sum[i]-sum[j], primes)) {
					ans = sum[i] - sum[j];
					n = i-j;
				}
			}
		}
		return ans;
	}
	
	public static boolean isPrime(int n, int[] p) {
		for (int i : p) {
			if (i == n) return true;
		}
		return false;
	}
	
	public static int[] sieve(int n) {
		boolean[] b = new boolean[n];
		int c = 0;
		for (int i = 0; i < b.length; i++) {
			b[i] = true;
			c++;
		}
		b[0] = false; c--;
		b[1] = false; c--;
		for (int i = 2; i*i < b.length; i++) {
			if (b[i] == false) continue;
			else {
				for (int j = 2; i*j < b.length; j++) {
					if (b[i*j]) c--;
					b[i*j] = false;
				}
			}
		}
		int[] primes = new int[c];
		int j = 0;
		for (int i = 0; i < b.length; i++) {
			if (b[i]) {
				primes[j] = i;
				j++;
			}
		}
		return primes;
	}
	
}
