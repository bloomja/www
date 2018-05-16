public class Solution {
	
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		
		long solution = solution(1000);
		
		long time = System.currentTimeMillis() - start;
		
		System.out.println("Solution: " + solution);
		System.out.println("Runtime: " + (time/1000) + "." + (time%1000) + "s");
		
	}
	
	public static long solution(int n) {
		long sum = 0;
		for (int i = 1; i <= n; i++) {
			String num = toString(i);
			sum += num.length();
		}
		return sum;
	}
	
	public static String toString(int n) {
		if (n == 0) return "";
		else if (n == 1) return "one";
		else if (n == 2) return "two";
		else if (n == 3) return "three";
		else if (n == 4) return "four";
		else if (n == 5) return "five";
		else if (n == 6) return "six";
		else if (n == 7) return "seven";
		else if (n == 8) return "eight";
		else if (n == 9) return "nine";
		else if (n == 10) return "ten";
		else if (n == 11) return "eleven";
		else if (n == 12) return "twelve";
		else if (n == 13) return "thirteen";
		else if (n == 14) return "fourteen";
		else if (n == 15) return "fifteen";
		else if (n == 16) return "sixteen";
		else if (n == 17) return "seventeen";
		else if (n == 18) return "eighteen";
		else if (n == 19) return "nineteen";
		else if (n < 30) return "twenty" + toString(n-20);
		else if (n < 40) return "thirty" + toString(n-30);
		else if (n < 50) return "forty" + toString(n-40);
		else if (n < 60) return "fifty" + toString(n-50);
		else if (n < 70) return "sixty" + toString(n-60);
		else if (n < 80) return "seventy" + toString(n-70);
		else if (n < 90) return "eighty" + toString(n-80);
		else if (n < 100) return "ninety" + toString(n-90);
		else if (n == 1000) return "one" + "thousand";
		else if (n % 100 == 0) return toString(n/100) + "hundred";
		else if (n < 1000) return toString(n/100) + "hundred" + "and" + toString(n%100);
		else return "";
	}
	
}
