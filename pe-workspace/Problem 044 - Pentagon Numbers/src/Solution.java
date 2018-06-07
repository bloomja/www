import java.util.HashMap;

public class Solution {
	
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		
		long solution = solution();
		
		long time = System.currentTimeMillis() - start;
		
		System.out.println("Solution: " + solution);
		System.out.println("Runtime: " + (time/1000) + "." + (time%1000) + "s");
		
	}
	
	static int[] pentagons = new int[3000];
	
	public static long solution() {
		fillArray();
		int k = 2;
		int j = 1;
		long D = 0;
		long pk = pentagon(k);
		long pj = pentagon(j);
		while (true) {
			if (isPentagonal(pk - pj) && isPentagonal(pk + pj)) {
				return pk - pj;
			}
			j--;
			if (j == 0) {
				k++;
				j = k-1;
			}
			pk = pentagon(k);
			pj = pentagon(j);
		}
	}
	
	public static boolean isPentagonal(long n) {
		long p = 1;
		for (int i = 1; p < n; i++) {
			p = pentagon(i);
			if (p == n) return true;
		}
		return false;
	}

	public static long pentagon(int n) {
		if (n > 3000) {
			return n*(3*n-1)/2;
		} else {
			return pentagons[n-1];
		}
	}
	
	public static void fillArray() {
		for (int i = 1; i <= 3000; i++) {
			pentagons[i-1] = i*(3*i-1)/2;
		}
	}
	
}
