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
		int c = 0;
		for (int i = 0; i < 10000; i++) {
			BigInteger l = BigInteger.valueOf(i);
			for (int j = 0; j < 50; j++) {
				l = l.add(reverse(l));
				if (isPalindrome(l)) break;
			}
			if (!isPalindrome(l)) c++;
		}
		return c;
	}
	
	public static BigInteger reverse(BigInteger b) {
		String s = b.toString();
		String r = "";
		for (int i = 0; i < s.length(); i++) {
			r += s.charAt(s.length()-1-i);
		}
		return new BigInteger(r);
	}
	
	public static boolean isPalindrome(BigInteger n) {
		String s = ""+n;
		for (int i = 0; i <= s.length()/2; i++) {
			if (s.charAt(i) != s.charAt(s.length()-1-i)) return false;
		}
		return true;
	}
	
}
