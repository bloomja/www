public class Solution {
	
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		
		long solution = solution();
		
		long time = System.currentTimeMillis() - start;
		
		System.out.println("Solution: " + solution);
		System.out.println("Runtime: " + (time/1000) + "." + (time%1000) + "s");
		
	}
	
	public static long solution() {
		
		int[] primes = Prime.sieveOfEratosthenes(100000000);
		long sum = 0;
		for (int p : primes) {
			if (p >= 5) {
				sum += S(p);
			}
		}
		return sum;
	}
	
	public static long S(int p) {
		long s = 0;
		if (p % 24 == 1) {
			s = (57*p-9)/24;
		} else if (p % 24 == 5) {
			s = (45*p-9)/24;
		} else if (p % 24 == 7) {
			s = (63*p-9)/24;
		} else if (p % 24 == 11) {
			s = (51*p-9)/24;
		} else if (p % 24 == 13) {
			s = (69*p-9)/24;
		} else if (p % 24 == 17) {
			s = (57*p-9)/24;
		} else if (p % 24 == 19) {
			s = (75*p-9)/24;
		} else {
			s = (63*p-9)/24;
		}
		return s % p;
	}
	
}
