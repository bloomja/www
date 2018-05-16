
public class Solution {
	
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		
		long solution = solution(200);
		
		long time = System.currentTimeMillis() - start;
		
		System.out.println("Solution: " + solution);
		System.out.println("Runtime: " + (time/1000) + "." + (time%1000) + "s");
		
	}
	
	static int[] coins = {1,2,5,10,20,50,100,200};
	static int[][] values = new int[201][coins.length];
	
	public static int solution(int n) {
		values[0] = new int[] {1,0,0,0,0,0,0,0};
		for (int i = 1; i <= n; i++) {
			values[i] = numWays(i);
		}
		int sum = 0;
		for (int i : values[n]) {
			sum += i;
		}
		return sum;
	}
	
	public static int[] numWays(int n) {
		int[] ret = new int[coins.length];
		for (int i = 0; i < coins.length; i++) {
			if (n < coins[i]) {
				ret[i] = 0;
			} else {
				for (int j = 0; j <= i; j++) {
					ret[i] += values[n-coins[i]][j];
				}
			}
		}
		return ret;
	}
	
}
