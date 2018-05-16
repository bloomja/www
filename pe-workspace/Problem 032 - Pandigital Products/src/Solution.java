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
		long sum = 0;
		ArrayList<Integer> repeats = new ArrayList<Integer>();
		for (int i = 1; i < 10000; i++) {
			j: for (int j = i; j < 10000; j++) {
				String panda = i + "" + j + "" + (i*j);
				if (panda.length() < 9) {
					continue;
				} else if (panda.length() > 9) {
					break;
				} else {
					for (int s = 0; s < panda.length(); s++) {
						for (int t = s + 1; t < panda.length(); t++) {
							if (panda.charAt(s) == '0' || 
									panda.charAt(t) == '0' || 
									panda.charAt(t) == panda.charAt(s)) {
								continue j;
							}
						}
					}
					if (!repeats.contains(i*j)) {
						sum += (i*j);
						repeats.add(i*j);
					}
				}
			}
		}
		return sum;
	}
	
}
