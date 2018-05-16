import java.util.ArrayList;

public class Solution {
	
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		
		long solution = solution(100);
		
		long time = System.currentTimeMillis() - start;
		
		System.out.println("Solution: " + solution);
		System.out.println("Runtime: " + (time/1000) + "." + (time%1000) + "s");
		
	}
	
	public static long solution(int n) {
		ArrayList<Integer> product = new ArrayList<Integer>();
		product.add(1);
		for (int i = 1; i <= 100; i++) {
			int carry = 0;
			for (int j = 0; j < product.size(); j++) {
				int p = product.get(j) * i;
				product.remove(j);
				product.add(j, (p+carry)%10);
				carry = (p+carry)/10;
			}
			while (carry > 0) {
				product.add(carry % 10);
				carry /= 10;
			}
		}
		long sum = 0;
		for (int p : product) {
			sum += p;
		}
		return sum;
	}
	
}
