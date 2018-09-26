import java.util.ArrayList;

public class Solution {
	
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		
		int solution = solution();
		
		long time = System.currentTimeMillis() - start;
		
		System.out.println("Solution: " + solution);
		System.out.println("Runtime: " + (time/1000) + "." + (time%1000) + "s");
		
	}
	
	public static int solution() {
		int[] good = new int[10000000]; // -1 for bad, 0 for unk, 1 for good.
		for (int i = 0; i < good.length; i++) {
			good[i] = 0;
		}
		good[1] = -1;
		good[89] = 1;
		for (int i = 1; i < 10000000; i++) {
			int n = i;
			ArrayList<Integer> list = new ArrayList<Integer>();
			list.add(n);
			while (good[n] == 0) {
				n = sum(n);
				list.add(n);
			}
			for (int j = 0; j < list.size(); j++) {
				good[list.get(j)] = good[n];
			}
		}
		int count = 0;
		for (int i = 0; i < good.length; i++) {
			if (good[i] == 1) {
				count++;
			}
		}
		return count;
	}
	
	public static String next(String n) {
		for (int i = n.length()-1; i >= 0; i--) {
			if (n.charAt(i) != '9') {
				String r = n.substring(0,i) + ((char)(n.charAt(i)+1));
				for (int j = i+1; j < n.length(); j++) {
					r += ((char)(n.charAt(i)+1));
				}
				return r;
			}
			if (i == 0) {
				String r = "1";
				for (int j = 0; j < n.length(); j++) {
					r += "1";
				}
				return r;
			}
		}
		return "";
	}
	
	public static int sum(int n) {
		String s = n+"";
		int sum = 0;
		for (int i = 0; i < s.length(); i++) {
			sum += (s.charAt(i)-'0') * (s.charAt(i)-'0');
		}
		return sum;
	}
	
}
