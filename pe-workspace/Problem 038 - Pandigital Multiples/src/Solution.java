
public class Solution {
	
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		
		String solution = solution();
		
		long time = System.currentTimeMillis() - start;
		
		System.out.println("Solution: " + solution);
		System.out.println("Runtime: " + (time/1000) + "." + (time%1000) + "s");
		
	}
	
	public static String solution() {
		i: for (int i = 9999; i > 0; i--) {
			int n = 2;
			String s = "";
			do {
				s = "";
				for (int j = 1; j <= n; j++) {
					s += i*j;
				}
				n++;
			} while (s.length() < 9);
			if (s.length() > 9) {
				continue i;
			} else {
				for (int j = 0; j < s.length(); j++) {
					for (int k = j+1; k < s.length(); k++) {
						if (s.charAt(j) == '0' ||
								s.charAt(k) == '0' ||
								s.charAt(j) == s.charAt(k)) {
							continue i;
						}
					}
				}
				return s;
			}
		}
		return "No solution found";
	}
	
}
