
public class Solution {
	
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		
		int solution = solution();
		
		long time = System.currentTimeMillis() - start;
		
		System.out.println("Solution: " + solution);
		System.out.println("Runtime: " + (time/1000) + "." + (time%1000) + "s");
		
	}
	
	public static int solution() {
		double threeSevenths = 3.0/7.0;
		double max = 0;
		int maxNum = 0;
		for (int d = 2; d <= 1000000; d++) {
			double frac = 1.0/d;
			int num = (int)(threeSevenths/frac);
			if ((double)num/d > max && (double)num/d != threeSevenths) {
				max = (double)num/d;
				maxNum = num;
			}
		}
		return maxNum;
	}
	
}
