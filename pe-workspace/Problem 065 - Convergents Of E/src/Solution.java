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
		int[] array = new int[100];
		array[0] = 2;
		for (int k = 0; k < 33; k++) {
			array[3*k+1] = 1;
			array[3*k+2] = 2*(k+1);
			array[3*k+3] = 1;
		}
		BigInteger numerator = BigInteger.valueOf(array[99]);
		BigInteger denominator = BigInteger.ONE;
		for (int i = 98; i >= 0; i--) {
			BigInteger temp = numerator.add(BigInteger.ZERO);
			numerator = denominator.add(BigInteger.ZERO);
			denominator = temp.add(BigInteger.ZERO);
			numerator = numerator.add(denominator.multiply(BigInteger.valueOf(array[i])));
		}
		String s = numerator.toString();
		int sum = 0;
		for (int i = 0; i < s.length(); i++) {
			sum += Integer.parseInt(s.charAt(i)+"");
		}
		return sum;
	}
	
}
