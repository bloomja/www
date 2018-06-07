
public class Solution {
	
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		
		long solution = solution(1000000);
		
		long time = System.currentTimeMillis() - start;
		
		System.out.println("Solution: " + solution);
		System.out.println("Runtime: " + (time/1000) + "." + (time%1000) + "s");
		
	}
	
	public static long solution(int n) {
		long sum = 0;
		i: for (int i = 1; i < n; i++) {
			String dec = i + "";
			String bin = Integer.toBinaryString(i);
			for (int j = 0; j <= dec.length()/2; j++) {
				if (dec.charAt(j) != dec.charAt(dec.length()-j-1)) {
					continue i;
				}
			}
			for (int j = 0; j <= bin.length()/2; j++) {
				if (bin.charAt(j) != bin.charAt(bin.length()-j-1)) {
					continue i;
				}
			}
			sum += i;
		}
		return sum;
	}
	
}
