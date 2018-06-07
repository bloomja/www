
public class Solution {
	
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		
		int solution = solution(1000);
		
		long time = System.currentTimeMillis() - start;
		
		System.out.println("Solution: " + solution);
		System.out.println("Runtime: " + (time/1000) + "." + (time%1000) + "s");
		
	}
	
	public static int solution(int n) {
		int maxPerim = 0;
		int maxValue = 0;
		for (int p = 12; p <= n; p++) {
			int val = 0;
			for (int a = 3; 3*a+3 <= p; a++) {
				for (int b = a+1; 2*b < p - a; b++) {
					int c = p - a - b;
					if (a*a + b*b == c*c) {
						val++;
					}
				}
			}
			if (val > maxValue) {
				maxPerim = p;
				maxValue = val;
			}
		}
		return maxPerim;
	}
	
}
