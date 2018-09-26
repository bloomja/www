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
		int count = 0;
		String[] lines = readFile("src\\poker.txt");
		for (int i = 0; i < lines.length; i++) {
			PokerHand p1 = new PokerHand(lines[i].substring(0,14).trim());
			PokerHand p2 = new PokerHand(lines[i].substring(15).trim());
			int[] s1 = p1.calculateStrength();
			int[] s2 = p2.calculateStrength();
			if (s1[0] > s2[0]) {
				count++;
			} else if (s1[0] == s2[0]) {
				for (int j = 1; j < s1.length; j++) {
					if (s1[j] > s2[j]) {
						count++;
						break;
					} else if (s1[j] < s2[j]) {
						break;
					}
				}
			}
		}
		return count;
	}
	
	public static String[] readFile(String fileName) {
		try {
			String[] hands = new String[1000];
			BufferedReader reader = new BufferedReader(new FileReader(new File(fileName)));
			String line;
			int i = 0;
			while ((line = reader.readLine()) != null) {
				hands[i] = line;
				i++;
			}
			return hands;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new String[] {};
	}
	
}
