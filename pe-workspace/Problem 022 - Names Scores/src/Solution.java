import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Solution {
	
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		
		long solution = solution("src/names.txt");
		
		long time = System.currentTimeMillis() - start;
		
		System.out.println("Solution: " + solution);
		System.out.println("Runtime: " + (time/1000) + "." + (time%1000) + "s");
		
	}
	
	public static long solution(String fileName) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(new File(fileName)));
			String line = reader.readLine();
			String[] names = line.split(",");
			names = sort(names);
			long sum = 0;
			for (int i = 0; i < names.length; i++) {
				sum += nameScore(names[i].substring(1, names[i].length()-1), i+1);
			}
			return sum;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public static long nameScore(String name, int pos) {
		long score = 0;
		for (int i = 0; i < name.length(); i++) {
			score += name.charAt(i) - 'A' + 1;
		}
		return score * pos;
	}
	
	public static String[] sort(String[] arr) {
		String[] ret = new String[arr.length];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j <= i; j++) {
				if (j == i) {
					ret[j] = arr[i];
					break;
				}
				if (ret[j].compareTo(arr[i]) >= 0) {
					for (int k = i; k > j; k--) {
						ret[k] = ret[k-1];
					}
					ret[j] = arr[i];
					break;
				}
			}
		}
		return ret;
	}

}
