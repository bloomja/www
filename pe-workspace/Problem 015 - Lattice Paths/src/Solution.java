
public class Solution {
	
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		
		long solution = solution(20);
		
		long time = System.currentTimeMillis() - start;
		
		System.out.println("Solution: " + solution);
		System.out.println("Runtime: " + (time/1000) + "." + (time%1000) + "s");
		
	}
	
	public static long solution(int n) {
		long[][] numPaths = new long[n+1][n+1];
		for (int i = 0; i < n+1; i++) {
			for (int j = 0; j < n+1; j++) {
				if (i == 0 || j == 0) {
					numPaths[i][j] = 1;
				} else {
					numPaths[i][j] = numPaths[i-1][j] + numPaths[i][j-1];
				}
			}
		}
		return numPaths[n][n];
	}
	
}
