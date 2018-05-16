
public class Solution {
	
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		
		int solution = solution(1000);
		
		long time = System.currentTimeMillis() - start;
		
		System.out.println("Solution: " + solution);
		System.out.println("Runtime: " + (time/1000) + "." + (time%1000) + "s");
		
	}
	
	public static int solution(int n) {
		for (int a = 1; a < n-2; a++) {
			for (int b = 1; a + b < n; b++) {
				int c = (int)(Math.sqrt(a*a+b*b)+0.5);
				if (c*c != a*a+b*b) continue;
				if (a+b+c == n) return a*b*c;
			}
		}
		return -1;
	}
	
}
