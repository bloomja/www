import java.util.ArrayList;

public class Solution {
	
	public static void main(String[] args) {

		long start = System.currentTimeMillis();
		
		long solution = solution();
		
		long time = System.currentTimeMillis() - start;
		
		System.out.println("Solution: " + solution);
		System.out.println("Runtime: " + (time/1000) + "." + (time%1000) + "s");
		
	}
	
	public static long solution() {
		int n = 2;
		while (true) {
			for (int i = 0; i < 4; i++) {
				if (!numFactors(4, n+i)) break;
				if (i == 3) return n;
			}
			n++;
		}
	}
	
	public static boolean numFactors(int num, int n) {
		int l = 0;
		int f = 2;
		while (n > 1) {
			if (n % f == 0) {
				l++;
				if (l >= num) return true;
			} while (n % f == 0) {
				n /= f;
			}
			f++;
		}
		return false;
	}
	
}
