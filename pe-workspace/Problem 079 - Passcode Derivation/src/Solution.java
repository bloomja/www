import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Solution {
	
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		
		String solution = solution();
		
		long time = System.currentTimeMillis() - start;
		
		System.out.println("Solution: " + solution);
		System.out.println("Runtime: " + (time/1000) + "." + (time%1000) + "s");
		
	}
	
	public static String solution() {
		// Solved this problem by hand in a few minutes.
		/*
		 *  31   9
		 *    6 8 0
		 *   1  8 0
		 *    6  90
		 *   1 2 9
		 *    62  0
		 * 7  62
		 *  31  8
		 *  3 6 8
		 * 7 1    0
		 *  etc...
		 * 73162890
		 */
		return "73162890";
	}
	
}
