import java.io.BufferedReader;
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
		int total = 0;
		try {
			BufferedReader reader = new BufferedReader(new FileReader("src\\roman.txt"));
			String line;
			while ((line = reader.readLine()) != null) {
				total += line.length() - minimize(readRoman(line)).length();
			}
			reader.close();
			return total;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public static int readRoman(String s) {
		int sum = 0;
		for (int i = 0; i < s.length(); i++) {
			if (i != s.length()-1) {
				if (singleChar(s.charAt(i)) < singleChar(s.charAt(i+1))) {
					sum += singleChar(s.charAt(i+1)) - singleChar(s.charAt(i));
					i++;
				} else {
					sum += singleChar(s.charAt(i));
				}
			} else {
				sum += singleChar(s.charAt(i));
			}
		}
		return sum;
	}
	
	public static int singleChar(char c) {
		switch (c) {
		case 'I':
			return 1;
		case 'V':
			return 5;
		case 'X':
			return 10;
		case 'L':
			return 50;
		case 'C':
			return 100;
		case 'D':
			return 500;
		case 'M':
			return 1000;
		}
		return 0;
	}
	
	public static String minimize(int n) {
		String roman = "";
		while (n >= 1000) {
			roman += "M";
			n -= 1000;
		}
		if (n/100 == 9) {
			roman += "CM";
			n -= 900;
		} else if (n/100 == 4) {
			roman += "CD";
			n -= 400;
		} else if (n >= 500) {
			roman += "D";
			n -= 500;
		}
		while (n >= 100) {
			roman += "C";
			n -= 100;
		}
		if (n/10 == 9) {
			roman += "XC";
			n -= 90;
		} else if (n/10 == 4) {
			roman += "XL";
			n -= 40;
		} else if (n >= 50) {
			roman += "L";
			n -= 50;
		}
		while (n >= 10) {
			roman += "X";
			n -= 10;
		}
		if (n == 9) {
			roman += "IX";
			n -= 9;
		} else if (n == 4) {
			roman += "IV";
			n -= 4;
		} else if (n >= 5) {
			roman += "V";
			n -= 5;
		}
		while (n > 0) {
			roman += "I";
			n -= 1;
		}
		return roman;
	}
	
}
