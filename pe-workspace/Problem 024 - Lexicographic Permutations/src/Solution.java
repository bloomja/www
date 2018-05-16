import java.util.ArrayList;

public class Solution {
	
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		
		String solution = solution(1000000);
		
		long time = System.currentTimeMillis() - start;
		
		System.out.println("Solution: " + solution);
		System.out.println("Runtime: " + (time/1000) + "." + (time%1000) + "s");
		
	}
	
	public static String solution(int n) {
		int target = n;
		String solution = "";
		ArrayList<Integer> available = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			available.add(i);
		}
		while (available.size() > 0) {
			long base = fact(available.size()-1);
			int i = 0;
			while (base * (i+1) < target) {
				i++;
			}
			solution += available.remove(i);
			target -= base * i;
		}
		return solution;
	}
	
	public static long fact(long n) {
		if (n <= 1) return 1;
		return n*fact(n-1);
	}
	
}
