
public class Solution {
	
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		
		long solution = solution();
		
		long time = System.currentTimeMillis() - start;
		
		System.out.println("Solution: " + solution);
		System.out.println("Runtime: " + (time/1000) + "." + (time%1000) + "s");
		
	}
	
	public static long solution() {
		int c = 0;
		for (int n = 23; n <= 100; n++) {
			for (int r = 1; r < n; r++) {
				double fact = 1.0;
				for (int i = 0; i < n-r; i++) {
					fact *= ((double)(n-i))/(n-r-i);
					if (fact >= 1000000) {
						c++;
						break;
					}
				}
			}
		}
		return c;
	}
	
}
