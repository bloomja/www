
public class Solution {
	
	static long[] red = new long[51];
	static long[] blue = new long[51];
	static long[] green = new long[51];
	
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		
		long solution = solution();
		
		long time = System.currentTimeMillis() - start;
		
		System.out.println("Solution: " + solution);
		System.out.println("Runtime: " + (time/1000) + "." + (time%1000) + "s");
		
	}
	
	public static long solution() {
		return red(50) + green(50) + blue(50);
	}
	
	public static long red(int n) {
		if (n <= 1) return 0;
		if (n == 2) return 1;
		if (red[n] != 0) return red[n];
		long sum = 0;
		for (int i = 1; i <= n-1; i++) {
			sum += 1 + red(n - i - 1);
		}
		red[n] = sum;
		return sum;
	}
	
	public static long green(int n) {
		if (n <= 2) return 0;
		if (n == 3) return 1;
		if (green[n] != 0) return green[n];
		long sum = 0;
		for (int i = 1; i <= n-2; i++) {
			sum += 1 + green(n - i - 2);
		}
		green[n] = sum;
		return sum;
	}
	
	public static long blue(int n) {
		if (n <= 3) return 0;
		if (n == 4) return 1;
		if (blue[n] != 0) return blue[n];
		long sum = 0;
		for (int i = 1; i <= n-3; i++) {
			sum += 1 + blue(n - i - 3);
		}
		blue[n] = sum;
		return sum;
	}
	
}
