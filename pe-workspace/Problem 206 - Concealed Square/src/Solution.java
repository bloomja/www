
public class Solution {
	
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		
		long solution = solution();
		
		long time = System.currentTimeMillis() - start;
		
		System.out.println("Solution: " + solution);
		System.out.println("Runtime: " + (time/1000) + "." + (time%1000) + "s");
		
	}
	
	public static long solution() {
		long i = 0;
		while (true) {
			i += 10;
			String s = i*i+"";
			while (s.length() < 19) {
				s = "0" + s;
			}
			if (s.charAt(18) == '0'
					&& s.charAt(16) == '9'
					&& s.charAt(14) == '8'
					&& s.charAt(12) == '7'
					&& s.charAt(10) == '6'
					&& s.charAt( 8) == '5'
					&& s.charAt( 6) == '4'
					&& s.charAt( 4) == '3'
					&& s.charAt( 2) == '2'
					&& s.charAt( 0) == '1') {
				return i;
			}
		}
	}
	
}
