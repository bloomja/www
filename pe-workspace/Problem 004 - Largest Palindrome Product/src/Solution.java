
public class Solution {
	
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		int ans = solution();
		long time = System.currentTimeMillis() - start;
		
		System.out.println("Solution: " + ans);
		System.out.println("Runtime: " + (time/1000) + "." + (time%1000) + "s");
		
	}
	
	public static int solution() {
		
		// 999999 is the largest possible palindrome of 6 digits.
		int val = 999;
		int pal = makePalindrome("" + val);
		
		while (val > 99) {
			int sqrt = (int)Math.sqrt(pal);
			if (sqrt*sqrt == pal) return pal; // Just in case
			int i = 1; // We use i to check numbers in both directions of sqrt at the same time.
			// These are the conditions before we can rule that number out
			while (sqrt+i < 1000 && pal/(sqrt+i) > 99 &&
					sqrt-i > 99 && pal/(sqrt-i) < 1000) {
				// If either of these conditions are true, then
				// this number is the product of two 3 digit numbers.
				if (pal % (sqrt + i) == 0 ||
					pal % (sqrt - i) == 0) {
					return pal;
				}
				i++;
			}
			val--;
			pal = makePalindrome(""+val);
		}
		
		return 0;
		
	}
	
	// Helper function that takes a string, reverses it,
	// and appends it. Returns result as an integer.
	public static int makePalindrome(String prefix) {
		String postfix = "";
		for (int i = prefix.length()-1; i >= 0; i--) {
			postfix += prefix.charAt(i);
		}
		return Integer.parseInt(prefix + postfix);
	}
	
}
