import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.math.BigInteger;

public class Solution {
	
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		
		int solution = solution();
		
		long time = System.currentTimeMillis() - start;
		
		System.out.println("Solution: " + solution);
		System.out.println("Runtime: " + (time/1000) + "." + (time%1000) + "s");
		
	}
	
	public static int solution() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(new File("src\\base_exp.txt")));
			String line;
			double[] max = new double[] {1.0, 0.0};
			int maxLine = -1;
			int i = 1;
			while ((line = reader.readLine()) != null) {
				String[] s = line.split(",");
				int base = Integer.parseInt(s[0]);
				int exp = Integer.parseInt(s[1]);
				double[] big = pow(base, exp);
				if (big[1] > max[1]) {
					max = big;
					maxLine = i;
				} else if (big[1] == max[1]) {
					if (big[0] > max[0]) {
						max = big;
						maxLine = i;
					}
				} else {
					
				}
				i++;
			}
			return maxLine;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public static double[] pow(int base, int exp) {
		String bin = Integer.toBinaryString(exp);
		double[] ret = new double[2];
		ret[0] = 1;
		ret[1] = 0;
		for (int i = 0; i < bin.length(); i++) {
			ret[0] = ret[0] * ret[0];
			ret[1] = ret[1] + ret[1];
			while (ret[0] > 10.0) {
				ret[0] /= 10;
				ret[1]++;
			}
			if (bin.charAt(i) == '1') {
				ret[0] *= base;
				while (ret[0] > 10) {
					ret[0] /= 10;
					ret[1]++;
				}
			}
		}
		return ret;
	}
	
}
