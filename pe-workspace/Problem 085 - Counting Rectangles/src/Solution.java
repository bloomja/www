
public class Solution {
	
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		
		long solution = solution();
		
		long time = System.currentTimeMillis() - start;
		
		System.out.println("Solution: " + solution);
		System.out.println("Runtime: " + (time/1000) + "." + (time%1000) + "s");
		
	}
	
	public static long solution() {
		
		int closestArea = -1;
		long closestDiff = 9999999;
		
		for (int m = 1; m < 200; m++) {
			for (int n = m; n < 200; n++) {
				long rect = rect(m, n);
				if (Math.abs(2000000 - rect) < closestDiff) {
					closestDiff = Math.abs(2000000 - rect);
					closestArea = m*n;
				}
			}
		}
		
		return closestArea;
		
	}
	
	public static long rect(int m, int n) {
		long total = 0;
		for (int j = 1; j <= m; j++) {
			for (int k = 1; k <= n; k++) {
				total += R(m, n, j, k);
			}
		}
		return total;
	}
	
	public static int R(int m, int n, int j, int k) {
		return (m - (j-1)) * (n - (k-1));
	}
	
}
