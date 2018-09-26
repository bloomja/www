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
		BigInteger num = BigInteger.valueOf(3);
		BigInteger denom = BigInteger.valueOf(2);
		int c = 0;
		for (int gen = 2; gen < 1000; gen++) {
			BigInteger[] frac = generateNext(num, denom);
			num = frac[0];
			denom = frac[1];
			if (num.toString().length() > denom.toString().length()) {
				c++;
			}
		}
		return c;
	}
	
	public static BigInteger[] generateNext(BigInteger num, BigInteger denom) {
		return new BigInteger[] {num.add(denom.multiply(BigInteger.valueOf(2))), num.add(denom)};
	}
	
}
