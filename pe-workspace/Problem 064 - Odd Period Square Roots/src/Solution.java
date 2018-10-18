
public class Solution {
	
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		
		int solution = solution();
		
		long time = System.currentTimeMillis() - start;
		
		System.out.println("Solution: " + solution);
		System.out.println("Runtime: " + (time/1000) + "." + (time%1000) + "s");
		
	}
	
	public static int solution() {
		int count = 0;
		for (int i = 1; i <= 10000; i++) {
			String s = Math.continuedFractionOfSquareRoot(i);
			if (s.indexOf('(') < 0) continue;
			int commas = 0;
			for (int j = 0; j < s.length(); j++) {
				if (s.charAt(j) == ',') commas++;
			}
			if ((commas + 1) % 2 == 1) {
				count++;
			}
		}
		return count;
	}
	
}
