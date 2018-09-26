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
		ArrayList<ArrayList<Integer>> factors = factorize(1000000);
		double max = 0;
		int maxN = 0;
		for (int i = 2; i < factors.size(); i++) {
			double tot = i;
			for (int j = 0; j < factors.get(i).size(); j++) {
				tot *= 1-1.0/factors.get(i).get(j);
			}
			if (i / tot > max) {
				max = i / tot;
				maxN = i;
			}
		}
		return maxN;
	}
	
	public static ArrayList<ArrayList<Integer>> factorize(int n) {
		ArrayList<ArrayList<Integer>> factors = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < n; i++) {
			factors.add(new ArrayList<Integer>());
		}
		boolean[] b = new boolean[n];
		for (int i = 0; i < n; i++) {
			b[i] = true;
		}
		for (int i = 2; i < n; i++) {
			if (!b[i]) continue;
			factors.get(i).add(i);
			for (int j = 2; i*j < n; j++) {
				b[i*j] = false;
				factors.get(i*j).add(i);
			}
		}
		return factors;
	}
	
}
