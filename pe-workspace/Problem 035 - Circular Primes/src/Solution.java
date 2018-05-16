
public class Solution {
	
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		
		long solution = solution(1000000);
		
		long time = System.currentTimeMillis() - start;
		
		System.out.println("Solution: " + solution);
		System.out.println("Runtime: " + (time/1000) + "." + (time%1000) + "s");
		
	}
	
	public static int solution(int n) {
		int count = 1;
		i: for (int i = 3; i < n; i += 2) {
			int[] digits = new int[] {(i/100000)%10, (i/10000)%10, (i/1000)%10, (i/100)%10, (i/10)%10, i%10};
			for (int d : digits) {
				if (d > 0 && d % 2 == 0) continue i;
			}
			if (circular(i)) {
				count++;
			}
		}
		return count;
	}
	
	public static boolean circular(int n) {
		for (int i = 0; i < (n + "").length(); i++) {
			String s = "";
			for (int j = 0; j < (n + "").length(); j++) {
				s += (n + "").charAt((i + j) % (n + "").length());
			}
			if (!isPrime(Integer.parseInt(s))) return false;
		}
		return true;
	}
	
	public static boolean isPrime(int n) {
		if (n < 2) return false;
		if (n == 2 || n == 3 || n == 5) return true;
		if (n % 2 == 0) return false;
		for (int i = 3; i < Math.sqrt(n) + 3; i += 2) {
			if (n % i == 0) return false;
		}
		return true;
	}
	
}
