
public class Solution {
	
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		
		String solution = solution();
		
		long time = System.currentTimeMillis() - start;
		
		System.out.println("Solution: " + solution);
		System.out.println("Runtime: " + (time/1000) + "." + (time%1000) + "s");
		
	}
	
	public static String solution() {
		
		int[] spaces = new int[40];
		int total = 0;
		boolean double1 = false;
		boolean double2 = false;
		int pos = 0;
		for (int n = 0; n < 100000; n++) {
			
			int d1 = (int)(Math.random()*4)+1;
			int d2 = (int)(Math.random()*4)+1;
			
			if (d1 == d2) {
				if (double1) {
					if (double2) {
						pos = 10;
					} else {
						double2 = true;
					}
				} else {
					double1 = true;
				}
			} else {
				double1 = false;
				double2 = false;
			}
			
			pos = (pos+d1+d2) % 40;
			
			if (pos == 30) {
				pos = 10;
			} else if (pos == 2 || pos == 17 || pos == 33) {
				pos = drawCC(pos);
			} else if (pos == 7 || pos == 22 || pos == 36) {
				pos = drawCH(pos);
			}
			
			//if (d1 != d2 || (d1 == d2 && double1 && double2)) {
				spaces[pos]++;
				total++;
			//}
			
		}
		
		double[] top3 = new double[3];
		int[] top3spaces = new int[3];
		for (int i = 0; i < spaces.length; i++) {
			if ((double)spaces[i]/total > top3[0]) {
				top3[0] = (double)spaces[i]/total;
				top3spaces[0] = i;
			} else if ((double)spaces[i]/total > top3[1]) {
				top3[1] = (double)spaces[i]/total;
				top3spaces[1] = i;
			} else if ((double)spaces[i]/total > top3[2]) {
				top3[2] = (double)spaces[i]/total;
				top3spaces[2] = i;
			}
		}
		
		return ""+top3spaces[0]+""+top3spaces[1]+""+top3spaces[2]+"";
		
	}
	
	public static int drawCC(int pos) {
		double r = Math.random();
		if (r < 0.0625) return 0;
		if (r < 0.1250) return 10;
		return pos;
	}
	
	public static int drawCH(int pos) {
		double r = Math.random();
		if (r < 0.0625) return 0;
		if (r < 0.1250) return 10;
		if (r < 0.1875) return 11;
		if (r < 0.2500) return 24;
		if (r < 0.3125) return 39;
		if (r < 0.3750) return 5;
		if (r < 0.5000) {
			if (pos < 5 || pos >= 35) return 5;
			if (pos >= 5 && pos < 15) return 15;
			if (pos >= 15 && pos < 25) return 25;
			return 35;
		}
		if (r < 0.5625) {
			if (pos >= 12 && pos < 28) return 28;
			return 12;
		}
		if (r < 0.6250) return pos - 3;
		return pos;
	}
	
}
