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
		long ans = 0;
		for (int i = 1; i <= 1000; i++) {
			BigInteger b = BigInteger.valueOf(i);
			ans += Long.parseLong(b.modPow(b,BigInteger.valueOf(10000000000L)).toString());
		}
		return ans % 10000000000L;
	}
	
}
