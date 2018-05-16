
public class Solution {
	
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		
		int solution = solution(1000000);
		
		long time = System.currentTimeMillis() - start;
		
		System.out.println("Solution: " + solution);
		System.out.println("Runtime: " + (time/1000) + "." + (time%1000) + "s");
		
	}
	
	public static int solution(int n) {
		int highest = 0;
		long highestIndex = 0;
		for (long i = 1; i < n; i++) {
			int count = 0;
			long x = i;
			while (x != 1) {
				if (x % 2 == 0)
					x = x/2;
				else 
					x = 3*x+1;
				count++;
			}
			if (count+1 > highest) {
				highest = count+1;
				highestIndex = i;
			}
		}
		return (int)highestIndex;
	}
	
}
