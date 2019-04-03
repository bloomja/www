
public class Solution {
	
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		
		long solution = solution();
		
		long time = System.currentTimeMillis() - start;
		
		System.out.println("Solution: " + solution);
		System.out.println("Runtime: " + (time/1000) + "." + (time%1000) + "s");
		
	}
	
	public static long solution() {
		
		long count = 0;
		
		for (int i = 3; i*i-(i-1)*(i-1) <= 1000000; i++) {
			for (int j = i-2; j > 0 && i*i-j*j <= 1000000; j-=2) {
				if (i*i-j*j <= 1000000) {
					count++;
				}
			}
		}
		
		return count;
		
	}
	
}
