import java.math.BigInteger;

public class Solution {
	
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		
		int solution = solution();
		
		long time = System.currentTimeMillis() - start;
		
		System.out.println("Solution: " + solution);
		System.out.println("Runtime: " + (time/1000) + "." + (time%1000) + "s");
		
	}
	
	public static int solution() {
		BigInteger maxX = BigInteger.ZERO;
		int D = -1;
		for (int n = 2; n <= 1000; n++) {
			if (((int)java.lang.Math.sqrt(n)) * ((int)java.lang.Math.sqrt(n)) == n) {
				continue;
			}
			int index = 0;
			String fraction = Math.continuedFractionOfSquareRoot(n);
			BigInteger[] convergent = BigMath.nthConvergentOfContinuedFraction(fraction, index);
			while (!convergent[0].multiply(convergent[0]).subtract(BigInteger.valueOf(n).multiply(convergent[1]).multiply(convergent[1])).equals(BigInteger.ONE)) {
				index++;
				convergent = BigMath.nthConvergentOfContinuedFraction(fraction, index);
			}
			if (convergent[0].compareTo(maxX) > 0) {
				maxX = convergent[0];
				D = n;
			}
		}
		return D;
	}
	
}
