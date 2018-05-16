
public class Solution {
	
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		
		int solution = solution(1001);
		
		long time = System.currentTimeMillis() - start;
		
		System.out.println("Solution: " + solution);
		System.out.println("Runtime: " + (time/1000) + "." + (time%1000) + "s");
		
	}
	
	public static int solution(int n) {
		if (n % 2 == 0) return 0;
		int sum = 1;
		for (int i = 1; i <= (n-1)/2; i++) {
			sum += 2*((2*i+1)*(2*i+1) + (2*i-1)*(2*i-1) + 2*i);
		}
		return sum;
	}
	
}
