
public class Solution {
	
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		
		long solution = solution(7);
		
		long time = System.currentTimeMillis() - start;
		
		System.out.println("Solution: " + solution);
		System.out.println("Runtime: " + (time/1000) + "." + (time%1000) + "s");
		
	}
	
	public static long solution(int n) {
		long[] factors = new long[n];
		int fin = 0;
		int index = 0;
		int number = 0;
		while (true) {
			number++;
			index += (""+number).length();
			if (index >= Math.pow(10, fin)) {
				int j = (""+number).length() - (index - (int) Math.pow(10, fin)) - 1;
				factors[fin] = (""+number).charAt(j) - '0';
				fin++;
				if (fin == n) {
					break;
				}
			}
		}
		long prod = 1;
		for (int i = 0; i < n; i++) {
			prod *= factors[i];
		}
		return prod;
	}
	
}
