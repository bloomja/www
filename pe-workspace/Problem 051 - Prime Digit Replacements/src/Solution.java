
public class Solution {
	
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		
		long solution = solution();
		
		long time = System.currentTimeMillis() - start;
		
		System.out.println("Solution: " + solution);
		System.out.println("Runtime: " + (time/1000) + "." + (time%1000) + "s");
		
	}
	
	public static long solution() {
		long number = 100;
		String numString = number+"";
		while (true) {
			for (int b = 0; b < Math.pow(2, numString.length()-1); b++) {
				String bin = Integer.toBinaryString(b);
				while (bin.length() < numString.length()-1) bin = '0' + bin;
				String stars = "";
				for (int i = 0; i < bin.length(); i++) {
					if (bin.charAt(i) == '1') {
						stars += "*";
					} else {
						stars += numString.charAt(i);
					}
				}
				stars += numString.charAt(numString.length()-1);
				if (stars.indexOf('*') < 0 || stars.endsWith("2") || stars.endsWith("4") || stars.endsWith("6") || stars.endsWith("8") || stars.endsWith("0") || stars.endsWith("5")) {
					continue;
				}
				int[] r = numPrimes(stars);
				if (r[0] == 8) {
					return r[1];
				}
			}
			number++;
			numString = number+"";
		}
	}
	
	public static int[] numPrimes(String s) {
		int count = 0;
		int lowest = 0;
		for (int i = 0; i <= 9; i++) {
			if (i == 0 && s.charAt(0) == '*') continue;
			String num = "";
			for (int j = 0; j < s.length(); j++) {
				if (s.charAt(j) == '*') {
					num += i;
				} else {
					num += s.charAt(j);
				}
			}
			if (isPrime(Integer.parseInt(num))) {
				if (count == 0) {
					lowest = Integer.parseInt(num);
				}
				count++;
			}
		}
		return new int[] {count, lowest};
	}
	
	public static boolean isPrime(int n) {
		if (n < 2) return false;
		if (n <= 3) return true;
		if (n % 2 == 0) return false;
		int f = 3;
		while (f*f <= n) {
			if (n % f == 0) return false;
			f+=2;
		}
		return true;
	}
	
}
