
public class Solution {
	
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		
		long solution = solution();
		
		long time = System.currentTimeMillis() - start;
		
		System.out.println("Solution: " + solution);
		System.out.println("Runtime: " + (time/1000) + "." + (time%1000) + "s");
		
	}
	
	public static int solution() {
		int count = 0;
		for (int year = 1901; year < 2001; year++) {
			for (int month = 1; month <= 12; month++) {
				int q = 1;
				int m = month <= 2 ? month + 12 : month;
				int K = month <= 2 ? (year-1) % 100 : year % 100;
				int J = month <= 2 ? (year-1) / 100 : year / 100;
				int h = (q + 13*(m+1)/5 + K + K/4 + J/4 + 5*J) % 7;
				if (h == 1) count++;
			}
		}
		return count;
	}
	
}
