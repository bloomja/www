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
		String cipher = readCipherText("src\\cipher.txt");
		pass: for (int p = 0; p < 26*26*26; p++) {
			String password = ((char)('a'+((p/26/26)%26)))+""+((char)('a'+((p/26)%26)))+""+((char)('a'+(p%26)));
			while (password.length() < cipher.length()) {
				password += password;
			}
			String plain = "";
			for (int i = 0; i < cipher.length(); i++) {
				int c = ((int)(cipher.charAt(i))) ^ ((int)(password.charAt(i)));
				if (c < 32 || c >= 127 || (c > 90 && c < 97)) continue pass;
				plain += (char) c;
			}
			long sum = 0;
			for (int i = 0; i < plain.length(); i++) {
				sum += plain.charAt(i);
			}
			return sum;
		}
		return 0;
	}
	
	public static String readCipherText(String fileName) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(fileName));
			String line;
			String cipherText = "";
			while ((line = reader.readLine()) != null) {
				String[] s = line.split(",");
				for (String i : s) {
					cipherText += (char) Integer.parseInt(i);
				}
			}
			return cipherText;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
