import java.util.ArrayList;

public class Solution {
	
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		
		int solution = solution(1000);
		
		long time = System.currentTimeMillis() - start;
		
		System.out.println("Solution: " + solution);
		System.out.println("Runtime: " + (time/1000) + "." + (time%1000) + "s");
		
	}
	
	public static int solution(int n) {
		ArrayList<Integer> digits = new ArrayList<Integer>();
		digits.add(2);
		for (int i = 1; i < n; i++) {
			int carry = 0;
			for (int j = 0; j < digits.size(); j++) {
				if (digits.get(j) < 5) {
					int dig = digits.remove(j);
					digits.add(j, dig*2 + carry);
					carry = 0;
				} else {
					int dig = digits.remove(j);
					digits.add(j, dig*2 - 10 + carry);
					carry = 1;
				}
			}
			if (carry != 0) {
				digits.add(carry);
			}
		}
		int sum = 0;
		for (int i : digits) {
			sum += i;
		}
		return sum;
	}
	
}
