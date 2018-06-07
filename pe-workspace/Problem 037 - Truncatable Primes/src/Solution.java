
public class Solution {
	
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		
		long solution = solution(11);
		
		long time = System.currentTimeMillis() - start;
		
		System.out.println("Solution: " + solution);
		System.out.println("Runtime: " + (time/1000) + "." + (time%1000) + "s");
		
	}
	
	public static long solution(int n) {
		long sum = 0;
		int count = 0;
		int prime = 11;
		w: while (count < n) {
			for (int i = ("" + prime).length(); i > 0; i--) {
				if (!isPrime(Integer.parseInt((""+prime).substring(0,i)))) {
					prime += 2;
					continue w;
				}
			}
			for (int i = 0; i < (""+prime).length(); i++) {
				if (!isPrime(Integer.parseInt((""+prime).substring(i,(""+prime).length())))) {
					prime += 2;
					continue w;
				}
			}
			sum += prime;
			count++;
			prime += 2;
		}
		return sum;
	}
	
	public static boolean isPrime(int n) {
		if (n < 2) return false;
		if (n == 2 || n == 3 || n == 5 || n == 7) return true;
		if (n % 2 == 0) return false;
		for (int i = 3; i <= Math.sqrt(n); i += 2) {
			if (n % i == 0) return false;
		}
		return true;
	}
	
}
