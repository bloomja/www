import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Solution {
	
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		
		long solution = solution("src/grid.txt", 20);
		
		long time = System.currentTimeMillis() - start;
		
		System.out.println("Solution: " + solution);
		System.out.println("Runtime: " + (time/1000) + "." + (time%1000) + "s");
		
	}
	
	public static long solution(String fileName, int size) {
		try {
			long[][] grid = new long[size][size];
			BufferedReader reader = new BufferedReader(new FileReader(new File(fileName)));
			String line;
			int k = 0;
			while ((line = reader.readLine()) != null) {
				String[] split = line.split(" ");
				for (int j = 0; j < split.length; j++) {
					grid[k][j] = Long.parseLong(split[j]);
				}
				k++;
			}
			
			long highest = 0;
			for (int i = 0; i < grid.length-3; i++) {
				for (int j = 0; j < grid.length-3; j++) {
					long horiz = 1;
					long vert = 1;
					long neg = 1;
					long pos = 1;
					for (int h = 0; h < 4; h++) {
						horiz *= grid[i][j+h];
						vert *= grid[i+h][j];
						neg *= grid[i+h][j+h];
						pos *= grid[size-1-i-h][j+h];
					}
					if (horiz > highest) highest = horiz;
					if (vert > highest) highest = vert;
					if (neg > highest) highest = neg;
					if (pos > highest) highest = pos;
				}
			}
			return highest;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
}
