
public class Solution {
	
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		
		long solution = solution();
		
		long time = System.currentTimeMillis() - start;
		
		System.out.println("Solution: " + solution);
		System.out.println("Runtime: " + (time/1000) + "." + (time%1000) + "s");
		
	}
	
	public static int solution() {
		int num = 1;
		int denom = 1;
		for (int n = 10; n < 100; n++) {
			for (int d = n + 1; d < 100; d++) {
				int n1 = n / 10;
				int n2 = n % 10;
				int d1 = d / 10;
				int d2 = d % 10;
				if (n2 == 0 && d2 == 0) {
					continue;
				} else if (n2 == d2 && ((double)n)/d == ((double)n1)/d1) {
					num *= n1;
					denom *= d1;
				} else if (n2 == d1 && ((double)n)/d == ((double)n1)/d2) {
					num *= n1;
					denom *= d2;
				} else if (n1 == d2 && ((double)n)/d == ((double)n2)/d1) {
					num *= n2;
					denom *= d1;
				} else if (n1 == d1 && ((double)n)/d == ((double)n2)/d2) {
					num *= n2;
					denom *= d2;
				}
			}
		}
		return reduce(num, denom)[1];
	}
	
	public static int[] reduce(int num, int denom) {
		int[] ret = {num, denom};
		for (int f = 2; f <= ret[0]; f++) {
			while (ret[0] % f == 0 && ret[1] % f == 0) {
				ret[0] /= f;
				ret[1] /= f;
			}
		}
		return ret;
	}
	
}
