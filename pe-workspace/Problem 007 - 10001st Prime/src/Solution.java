
public class Solution {
	
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		
		int solution = solution(10001);
		
		long time = System.currentTimeMillis() - start;
		
		System.out.println("Solution: " + solution);
		System.out.println("Runtime: " + (time/1000) + "." + (time%1000) + "s");
		
	}
	
	public static int solution(int n) {
		int num = 1;
		for (int i = 3; num < n; i+=2) {
			if (isPrime(i)) {
				num++;
			}
			if (num == n) {
				return i;
			}
		}
		return -1;
	}
	
	public static boolean isPrime(int n) {
		if (n < 2 || n % 2 == 0) return false;
		if (n < 4) return true;
		int x = 3;
		while (x <= Math.sqrt(n) + 1) {
			if (n % x == 0) return false;
			x += 2;
		}
		return true;
	}
	
}
