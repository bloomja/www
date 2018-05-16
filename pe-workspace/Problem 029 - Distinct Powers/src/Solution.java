import java.util.ArrayList;
import java.util.HashMap;

public class Solution {
	
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		
		int solution = solution(100);
		
		long time = System.currentTimeMillis() - start;
		
		System.out.println("Solution: " + solution);
		System.out.println("Runtime: " + (time/1000) + "." + (time%1000) + "s");
		
	}
	
	public static int solution(int n) {
		ArrayList<HashMap<Integer,Integer>> list = new ArrayList<HashMap<Integer,Integer>>();
		for (int i = 2; i <= n; i++) {
			for (int j = 2; j <= n; j++) {
				HashMap<Integer,Integer> current = factorize(i,j);
				if (!list.contains(current)) {
					list.add(current);
				}
			}
		}
		return list.size();
	}
	
	public static HashMap<Integer,Integer> factorize(int a, int b) {
		HashMap<Integer,Integer> ret = new HashMap<Integer,Integer>();
		int factor = 2;
		while (a > 1) {
			int exp = 0;
			while (a % factor == 0) {
				exp += b;
				a /= factor;
			}
			ret.put(factor,exp);
			factor++;
		}
		return ret;
	}
	
}
