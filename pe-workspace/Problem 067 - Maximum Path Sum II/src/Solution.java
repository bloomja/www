import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Solution {
	
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		
		long solution = solution("src\\triangle.txt");
		
		long time = System.currentTimeMillis() - start;
		
		System.out.println("Solution: " + solution);
		System.out.println("Runtime: " + (time/1000) + "." + (time%1000) + "s");
		
	}
	
	public static long solution(String fileName) {
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader(new File(fileName)));
			String line;
			long[][] triangle = new long[100][100];
			int row = 0;
			while ((line = reader.readLine()) != null) {
				String[] split = line.split(" ");
				for (int i = 0; i < split.length; i++) {
					triangle[row][i] = Long.parseLong(split[i]);
				}
				row++;
			}
			
			long[][] partials = new long[100][100];
			for (int i = 0; i < triangle.length; i++) {
				for (int j = 0; j < triangle.length-i; j++) {
					if (i == 0) {
						partials[i][j] = triangle[triangle.length-1-i][j];
					} else {
						partials[i][j] = Math.max(
								triangle[triangle.length-1-i][j] + partials[i-1][j],
								triangle[triangle.length-1-i][j] + partials[i-1][j+1]);
					}
				}
			}
			return partials[99][0];
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
}
