
public class Solution {
	
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		
		int solution = solution(1000);
		
		long time = System.currentTimeMillis() - start;
		
		System.out.println("Solution: " + solution);
		System.out.println("Runtime: " + (time/1000) + "." + (time%1000) + "s");
		
	}
	
	public static int solution(int n) {
		int most = 0;
		int ans = 0;
		for (int a = -1*n+1; a < n; a++) {
			for (int b = 0; b <= n; b++) {
				int i = 0;
				while (isPrime(i*i + a*i + b)) {
					i++;
				}
				if (i > most) {
					most = i;
					ans = a*b;
				}
			}
		}
		return ans;
	}
	
	public static boolean isPrime(int n) {
		if (n < 2) return false;
		if (n % 2 == 0) return false;
		for (int i = 3; i * i <= n; i+=2) {
			if (n % i == 0) return false;
		}
		return true;
	}
	
}
