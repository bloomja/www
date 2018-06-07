
public class Solution {
	
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		
		long solution = solution();
		
		long time = System.currentTimeMillis() - start;
		
		System.out.println("Solution: " + solution);
		System.out.println("Runtime: " + (time/1000) + "." + (time%1000) + "s");
		
	}
	
	public static long solution() {
		long current = 7654321;
		while (! (isPalindrome(""+current) && isPrime(current))) {
			current--;
		}
		return current;
	}
	
	public static boolean isPalindrome(String n) {
		for (int i = 0; i < n.length(); i++) {
			if (n.charAt(i) - '0' > n.length() || n.charAt(i) == '0') return false;
		}
		for (int i = 0; i < n.length(); i++) {
			for (int j = i+1; j < n.length(); j++) {
				if (n.charAt(i) == n.charAt(j)) return false;
			}
		}
		return true;
	}
	
	public static boolean isPrime(long n) {
		if (n < 2) return false;
		if (n == 2) return true;
		if (n % 2 == 0) return false;
		if (n == 3 || n == 5 || n == 7) return true;
		for (int i = 3; i * i <= n; i += 2) {
			if (n % i == 0) return false;
		}
		return true;
	}
	
}
