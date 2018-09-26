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
		long max = 0;
		for (BigInteger a = BigInteger.valueOf(0); !a.equals(BigInteger.valueOf(100)); a=a.add(BigInteger.ONE)) {
			for (int b = 0; b < 100; b++) {
				long val = digitalSum(a.pow(b).toString());
				if (val > max) {
					max = val;
				}
			}
		}
		return max;
	}
	
	public static long digitalSum(String s) {
		long l = 0;
		for (int i = 0; i < s.length(); i++) {
			l += Integer.parseInt(s.charAt(i)+"");
		}
		return l;
	}
	
}
