
public class Solution {
	
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		
		long solution = solution();
		
		long time = System.currentTimeMillis() - start;
		
		System.out.println("Solution: " + solution);
		System.out.println("Runtime: " + (time/1000) + "." + (time%1000) + "s");
		
	}
	
	public static long solution() {
		long[] u = new long[10];
		for (int i = 1; i <= 10; i++) {
			u[i-1] = u(i);
		}
		long sum = 1;
		for (int degree = 1; degree <= 10; degree++) {
			long[][] system = new long[degree+1][degree+1];
			for (int a = 0; a < system.length; a++) {
				for (int b = 0; b < system.length; b++) {
					system[a][b] = (long)Math.pow(a+1, b);
				}
			}
			for (long[] ia : system) {for (long i : ia) System.out.print(i+" ");System.out.println();}
		}
		return 0;
	}
	
	public static long u(long n) {
		return 1
				-n
				+n*n
				-n*n*n
				+n*n*n*n
				-n*n*n*n*n
				+n*n*n*n*n*n
				-n*n*n*n*n*n*n
				+n*n*n*n*n*n*n*n
				-n*n*n*n*n*n*n*n*n
				+n*n*n*n*n*n*n*n*n*n;
	}
	
}
