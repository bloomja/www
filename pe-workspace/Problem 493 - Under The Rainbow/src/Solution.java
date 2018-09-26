
public class Solution {
	
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		
		double solution = solution();
		
		long time = System.currentTimeMillis() - start;
		
		System.out.println("Solution: " + solution);
		System.out.println("Runtime: " + (time/1000) + "." + (time%1000) + "s");
		
	}
	
	public static double solution() {
		double sum = 0.0;
		for (int i = 2; i <= 7; i++) {
			double sum2 = 0.0;
			for (int j = 0; j <= i; j++) {
				sum2 += choose(10*(i-j),20)*choose(i,j)*Math.pow(-1,j);
			}
			sum += i*choose(7,i)*sum2;
		}
		return sum / choose(70,20);
	}
	
	public static double choose(int x, int y) {
		if (y < 0 || y > x) return 0;
		if (y > x/2) {
			y = x - y;
		}
	    double denominator = 1.0;
	    double numerator = 1.0;
	    for (int i = 1; i <= y; i++) {
	    	denominator *= i;
	        numerator *= (x + 1 - i);
	    }
	    return numerator / denominator;
	}
	
}
