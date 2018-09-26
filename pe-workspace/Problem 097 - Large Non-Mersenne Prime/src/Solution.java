import java.math.BigInteger;

public class Solution {
	
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		
		String solution = solution();
		
		long time = System.currentTimeMillis() - start;
		
		System.out.println("Solution: " + solution);
		System.out.println("Runtime: " + (time/1000) + "." + (time%1000) + "s");
		
	}
	
	public static String solution() {
		BigInteger n = BigInteger.valueOf(7830457);
		BigInteger m = BigInteger.valueOf(10000000000L);
		BigInteger res = BigInteger.valueOf(2).modPow(n, m);
		res = res.multiply(BigInteger.valueOf(28433)).mod(m).add(BigInteger.ONE);
		return res.toString();
	}
	
}
