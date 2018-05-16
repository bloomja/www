
public class Solution {
	
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		
		long solution = solution();
		
		long time = System.currentTimeMillis() - start;
		
		System.out.println("Solution: " + solution);
		System.out.println("Runtime: " + (time/1000) + "." + (time%1000) + "s");
		
	}
	
	public static long solution() {
		long sum = 0;
		for (int i = 10; i < 1000000; i++) {
			String s = "" + i;
			String[] split = s.split("");
			long j = 0;
			for (String str : split) {
				j += Math.pow(Integer.parseInt(str), 5);
			}
			if (i == j) {
				sum += i;
			}
		}
		return sum;
	}
	
}
