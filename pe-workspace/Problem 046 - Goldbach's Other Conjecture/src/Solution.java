
public class Solution {
	
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		
		int solution = solution();
		
		long time = System.currentTimeMillis() - start;
		
		System.out.println("Solution: " + solution);
		System.out.println("Runtime: " + (time/1000) + "." + (time%1000) + "s");
		
	}
	
	public static int solution() {
		int i = 9;
		w: while (true) {
			if (isPrime(i)) {
				i += 2;
				continue w;
			} else {
				for (int sq = 1; 2*sq*sq < i; sq++) {
					if (isPrime(i-2*sq*sq)) {
						i += 2;
						continue w;
					}
				}
				return i;
			}
		}
	}
	
	public static boolean isPrime(int n) {
		if (n < 2) return false;
		if (n == 2) return true;
		if (n % 2 == 0) return false;
		if (n == 3 || n == 5 || n == 7) return true;
		for (int i = 3; i * i <= n; i++) {
			if (n % i == 0) return false;
		}
		return true;
	}
	
}
