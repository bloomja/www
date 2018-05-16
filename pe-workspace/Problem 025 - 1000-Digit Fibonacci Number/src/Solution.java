import java.math.BigInteger;
import java.util.HashMap;

public class Solution {
	
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		
		int solution = solution(1000);
		
		long time = System.currentTimeMillis() - start;
		
		System.out.println("Solution: " + solution);
		System.out.println("Runtime: " + (time/1000) + "." + (time%1000) + "s");
		
	}
	
	public static int solution(int n) {
		HashMap<Integer, BigInteger> fibs = new HashMap<Integer, BigInteger>();
		int index = 3;
		fibs.put(3, BigInteger.valueOf(2));
		fibs.put(4, BigInteger.valueOf(3));
		fibs.put(5, BigInteger.valueOf(5));
		while (fibs.get(index).toString().length() < n) {
			fibs.put(2*index+1, fibs.get(index+0).multiply(fibs.get(index+0)).add(fibs.get(index+1).multiply(fibs.get(index+1))));
			fibs.put(2*index+3, fibs.get(index+1).multiply(fibs.get(index+1)).add(fibs.get(index+2).multiply(fibs.get(index+2))));
			fibs.put(2*index+2, fibs.get(2*index+3).subtract(fibs.get(2*index+1)));
			System.out.println(index + " @ " + fibs.get(index).toString().length() + ": " + fibs.get(index));
			index = 2*index + 1;
		}
		int aLen = fibs.get((index-1)/2).toString().length();
		int bLen = fibs.get(index).toString().length();
		if (n - aLen < bLen - n) {
			index = (index-1)/2+3;
			do {
				BigInteger x = fibs.get(index-2);
				BigInteger y = fibs.get(index-1);
				fibs.put(index, x.add(y));
				System.out.println(index + " @ " + fibs.get(index).toString().length() + ": " + fibs.get(index));
				index++;
			} while (fibs.get(index-1).toString().length() < n);
			return index-1;
		} else {
			index = index - 1;
			do {
				BigInteger x = fibs.get(index + 2);
				BigInteger y = fibs.get(index + 1);
				fibs.put(index, x.subtract(y));
				System.out.println(index + " @ " + fibs.get(index).toString().length() + ": " + fibs.get(index));
				index--;
			} while (fibs.get(index).toString().length() >= 1000);
			return index + 1;
		}
	}
	
}
