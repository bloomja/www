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
		int count = 1;
		int n = 1;
		BigInteger b = BigInteger.valueOf(2);
		while (true) {
			boolean t = false;
			while (b.pow(n).toString().length() <= n) {
				if (b.pow(n).toString().length() == n) {
					t = true;
					count++;
				}
				b = b.add(BigInteger.ONE);
			}
			if (!t) return count;
			b = BigInteger.valueOf(2);
			n++;
		}
	}
	
}
