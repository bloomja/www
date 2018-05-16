
public class Solution {
	
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		
		long solution = solution();
		
		long time = System.currentTimeMillis() - start;
		
		System.out.println("Solution: " + solution);
		System.out.println("Runtime: " + (time/1000) + "." + (time%1000) + "s");
		
	}
	
	public static long solution() {
		long facts[] = new long[10];
		for (int i = 0; i < 10; i++) {
			facts[i] = factorial(i);
		}
		long sum = 0;
		for (int i = 10; i < 7*facts[9]; i++) {
			String s = i + "";
			String[] digits = s.split("");
			long fSum = 0;
			for (String d : digits) {
				fSum += facts[Integer.parseInt(d)];
			}
			if (fSum == i) {
				sum += i;
			}
		}
		return sum;
	}
	
	public static long factorial(int i) {
		if (i <= 1) return 1;
		return i * factorial(i-1);
	}
	
}
