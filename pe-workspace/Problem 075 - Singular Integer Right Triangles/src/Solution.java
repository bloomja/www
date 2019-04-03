import java.util.ArrayList;
import java.util.Collections;

public class Solution {
	
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		
		long solution = solution();
		
		long time = System.currentTimeMillis() - start;
		
		System.out.println("Solution: " + solution);
		System.out.println("Runtime: " + (time/1000) + "." + (time%1000) + "s");
		
	}
	
	public static long solution() {
		
		ArrayList<Integer[]> triples = new ArrayList<Integer[]>();
		
		for (int r = 2; r <= 1500000; r+=2) {
			int[] factors = factorize(r*r/2);
			for (int i = 0; i < factors.length/2; i++) {
				int s = factors[i];
				int t = factors[factors.length - i - 1];
				if (3*r+2*s+2*t > 1500000) continue;
				Integer[] triple = new Integer[] {3*r + 2*s + 2*t, r+s, r+t, r+s+t};
				triples.add(triple);
			}
		}
		
		int[] sorted = new int[triples.size()];
		int equalCount = 0;
		
		for (int i = 0; i < triples.size(); i++) {
			int perimeter = triples.get(i)[0];
			if (i == 0) {
				sorted[i] = perimeter;
			} else if (perimeter < sorted[0]) {
				for (int k = i; k > 0; k--) {
					sorted[k] = sorted[k-1];
				}
				sorted[0] = perimeter;
			} else if (perimeter > sorted[i-1]){
				sorted[i] = perimeter;
			} else {
				for (int j = 1; j < i; j++) {
					if (perimeter >= sorted[j-1] && perimeter <= sorted[j]) {
						equalCount++;
						for (int k = i; k > j; k--) {
							sorted[k] = sorted[k-1];
						}
						sorted[j] = perimeter;
					}
				}
			}
		}
		return sorted.length - equalCount;
		
	}
	
	public static int[] factorize(int r) {
		if (r == 1) return new int[]{1};
		ArrayList<Integer> factors = new ArrayList<Integer>();
		for (int i = 1; i*i <= r; i++) {
			if (i*i == r) {
				factors.add(i);
			} else if (r % i == 0) {
				factors.add(i);
				factors.add(r/i);
			}
		}
		Collections.sort(factors);
		int[] ret = new int[factors.size()];
		for (int i = 0; i < ret.length; i++) {
			ret[i] = factors.get(i);
		}
		return ret;
	}
	
}
