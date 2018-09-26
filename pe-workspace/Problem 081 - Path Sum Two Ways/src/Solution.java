import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Solution {
	
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		
		long solution = solution();
		
		long time = System.currentTimeMillis() - start;
		
		System.out.println("Solution: " + solution);
		System.out.println("Runtime: " + (time/1000) + "." + (time%1000) + "s");
		
	}
	
	public static long solution() {
		long[][] mat = readFile("src\\matrix.txt");
		long[][] best = new long[80][80];
		for (int i = 0; i < best.length; i++) {
			for (int j = 0; j < best[i].length; j++) {
				if (i == 0 && j == 0) {
					best[i][j] = mat[i][j];
				} else if (i == 0) {
					best[i][j] = mat[i][j] + best[i][j-1];
				} else if (j == 0) {
					best[i][j] = mat[i][j] + best[i-1][j];
				} else {
					best[i][j] = mat[i][j] + Math.min(best[i][j-1], best[i-1][j]);
				}
			}
		}
		return best[79][79];
	}
	
	public static long[][] readFile(String fileName) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(new File(fileName)));
			String line;
			long[][] mat = new long[80][80];
			int i = 0;
			while ((line = reader.readLine()) != null) {
				String[] s = line.split(",");
				for (int j = 0; j < mat.length; j++) {
					mat[i][j] = Integer.parseInt(s[j]);
				}
				i++;
			}
			return mat;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
