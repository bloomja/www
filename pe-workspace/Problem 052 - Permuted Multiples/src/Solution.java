import java.util.Arrays;

public class Solution {
	
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		
		long solution = solution();
		
		long time = System.currentTimeMillis() - start;
		
		System.out.println("Solution: " + solution);
		System.out.println("Runtime: " + (time/1000) + "." + (time%1000) + "s");
		
	}
	
	public static long solution() {
		int i = 1;
		while (true) {
			String a = i+"";
			String b = (2*i)+"";
			String c = (3*i)+"";
			String d = (4*i)+"";
			String e = (5*i)+"";
			String f = (6*i)+"";
			if (a.length() == f.length()) {
				char[] aa = a.toCharArray();
				char[] bb = b.toCharArray();
				char[] cc = c.toCharArray();
				char[] dd = d.toCharArray();
				char[] ee = e.toCharArray();
				char[] ff = f.toCharArray();
				Arrays.sort(aa);
				Arrays.sort(bb);
				Arrays.sort(cc);
				Arrays.sort(dd);
				Arrays.sort(ee);
				Arrays.sort(ff);
				if (new String(aa).equals(new String(bb))
						&& new String(bb).equals(new String(cc))
						&& new String(cc).equals(new String(dd))
						&& new String(dd).equals(new String(ee))
						&& new String(ee).equals(new String(ff))) {
					return i;
				}
			}
			i++;
		}
	}
	
}
