import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Solution {
	
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		
		int solution = solution();
		
		long time = System.currentTimeMillis() - start;
		
		System.out.println("Solution: " + solution);
		System.out.println("Runtime: " + (time/1000) + "." + (time%1000) + "s");
		
	}
	
	public static int solution() {
		String[] words = readFile("src\\words.txt");
		int count = 0;
		for (String word : words) {
			int sum = 0;
			for (int i = 0; i < word.length(); i++) {
				if (word.charAt(i) == '"') continue;
				sum += word.charAt(i) - 'A' + 1;
			}
			if (isTriangle(sum)) {
				count++;
			}
		}
		return count;
	}
	
	public static boolean isTriangle(int n) {
		int t = 0;
		int i = 0;
		while (n > t) {
			i++;
			t += i;
			if (n == t) return true;
		}
		return false;
	}
	
	public static String[] readFile(String filename) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(new File(filename)));
			String line = reader.readLine();
			String[] ret = line.split(",");
			return ret;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new String[]{};
	}
	
}
