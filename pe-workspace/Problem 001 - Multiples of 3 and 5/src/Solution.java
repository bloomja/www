
public class Solution {
	
	public static void main(String[] args) {
		
		long startTime = System.currentTimeMillis();
		
		int max = 1000;
		int sum = 0;
		
		for (int i = 0; i < max; i++) {
			if (i % 3 == 0 || i % 5 == 0) {
				sum += i;
			}
		}
		
		long time = System.currentTimeMillis() - startTime;
		
		System.out.println("Solution: " + sum);
		System.out.println("Runtime: " + (time/1000) + "." + (time%1000) + "s");
		
	}
	
}
