import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.math.BigInteger;

public class Solution {
	
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		
		String solution = solution("src/numbers.txt");
		
		long time = System.currentTimeMillis() - start;
		
		System.out.println("Solution: " + solution);
		System.out.println("Runtime: " + (time/1000) + "." + (time%1000) + "s");
		
	}
	
	public static String solution(String fileName) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(new File(fileName)));
			String line;
			BigInteger sum = BigInteger.ZERO;
			while ((line = reader.readLine()) != null) {
				sum = sum.add(new BigInteger(line));
			}
			return sum.toString().substring(0, 10);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "-1";
	}
	
}
