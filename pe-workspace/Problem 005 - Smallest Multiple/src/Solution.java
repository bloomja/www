
public class Solution {
	
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		long ans = solution();
		long time = System.currentTimeMillis() - start;
		
		System.out.println("Solution: " + ans);
		System.out.println("Runtime: " + (time/1000) + "." + (time%1000) + "s");
		
	}
	
	public static long solution() {
		
		int[] primes = {2,3,5,7,11,13,17,19}; // All primes less than 20
		int[] exp    = {0,0,0,0, 0, 0, 0, 0}; // The highest exponent possible
		
		for (int i = 2; i <= 20; i++) {
			int num = i;
			int[] temp = {0,0,0,0, 0, 0, 0, 0};
			for (int j = 0; j < primes.length; j++) {
				while (num % primes[j] == 0) { // Find the highest exp for i
					num /= primes[j];
					temp[j]++;
				}
			}
			for (int j = 0; j < exp.length; j++) {
				if (temp[j] > exp[j]) { // If the exponent is higher than the highest recorded...
					exp[j] = temp[j]; // then save that exponent
				}
			}
		}
		
		long sum = 1;
		for (int i = 0; i < primes.length; i++) {
			sum *= Math.pow(primes[i], exp[i]); // Find the product of all the primes w/ exponents
		}
		return sum;
		
	}
	
}
