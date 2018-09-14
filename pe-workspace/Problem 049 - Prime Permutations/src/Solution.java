import java.util.Arrays;

public class Solution {
	
	public static void main(String[] args) {

		long start = System.currentTimeMillis();
		
		String solution = solution();
		
		long time = System.currentTimeMillis() - start;
		
		System.out.println("Solution: " + solution);
		System.out.println("Runtime: " + (time/1000) + "." + (time%1000) + "s");
		
	}
	
	public static String solution() {
		for (int i = 1000; i < 10000; i++) {
			if (i == 1487) continue;
			for (int j = 1; i+j+j < 10000; j++) {
				if (isAnagram(""+i, ""+(i+j)) && isAnagram(""+i, ""+(i+j+j))) {
					if (isPrime(i) && isPrime(i+j) && isPrime(i+j+j)) {
						return i+""+(i+j)+""+(i+j+j);
					}
				}
			}
		}
		return "not found";
	}
	
	public static boolean isAnagram(String a, String b) {
		if (a.length() != b.length()) return false;
		char[] c = a.toCharArray();
        char[] d = b.toCharArray();
        Arrays.sort(c);
        Arrays.sort(d);
        if (new String(c).equals(new String(d))) return true;
        return false;
	}
	
	public static boolean isPrime(int n) {
		if (n <= 1) return false;
		if (n == 2) return true;
		if (n % 2 == 0) return false;
		for (int i = 3; i*i <= n; i+=2) {
			if (n % i == 0) return false;
		}
		return true;
	}
	
}
