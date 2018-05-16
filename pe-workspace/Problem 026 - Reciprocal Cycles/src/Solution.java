import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
	
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		
		int solution = solution(1000);
		
		long time = System.currentTimeMillis() - start;
		
		System.out.println("Solution: " + solution);
		System.out.println("Runtime: " + (time/1000) + "." + (time%1000) + "s");
		
	}
	
	public static int solution(int n) {
		long max = 0;
		int maxIndex = -1;
		for (int i = 2; i < n; i++) {
			long per = period(i).longValue();
			if (per > max) {
				max = per;
				maxIndex = i;
			}
		}
		return maxIndex;
	}
	
	public static BigInteger period(int n) {
		ArrayList<BigInteger> divs = divisors(totient(n));
		for (int i = 0; i < divs.size(); i++) {
			if (BigInteger.TEN.modPow(divs.get(i), BigInteger.valueOf(n)).equals(BigInteger.ONE)) {
				return divs.get(i);
			}
		}
		return BigInteger.ZERO;
	}
	
	public static ArrayList<BigInteger> divisors(int n) {
		ArrayList<BigInteger> divs = new ArrayList<BigInteger>();
		if (n == 1) {
			divs.add(BigInteger.ONE);
			return divs;
		} else {
			divs.add(BigInteger.ONE);
			divs.add(BigInteger.valueOf(n));
		}
		for (int i = 2; i * i <= n; i++) {
			if (i * i == n) {
				divs.add(BigInteger.valueOf(i));
			} else if (n % i == 0) {
				divs.add(BigInteger.valueOf(i));
				divs.add(BigInteger.valueOf(n/i));
			}
		}
		Collections.sort(divs);
		return divs;
	}
	
	public static int totient(int n) {
		int result = n;
		int i = 2;
		while (i * i <= n) {
			if (n % i == 0) {
				while (n % i == 0) {
					n /= i;
				}
				result -= result / i;
			}
			i++;
		}
		if (n > 1) {
			result -= result / n;
		}
		return result;
	}
	
}
