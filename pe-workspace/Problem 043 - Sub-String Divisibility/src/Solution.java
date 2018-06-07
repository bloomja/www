
public class Solution {
	
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		
		long solution = solution();
		
		long time = System.currentTimeMillis() - start;
		
		System.out.println("Solution: " + solution);
		System.out.println("Runtime: " + (time/1000) + "." + (time%1000) + "s");
		
	}
	
	// Shitty solution, I actually solved by hand; explanation later.
	public static long solution() {
		long sum = 0;
		for (int d10 = 0; d10 < 10; d10++) {
			for (int d9 = 0; d9 < 10; d9++) {
				if (d9 == d10) continue;
				for (int d8 = 0; d8 < 10; d8++) {
					if (d8 == d9 || d8 == d10) continue;
					if ((d8*100 + d9*10 + d10) % 17 != 0) continue;
					for (int d7 = 0; d7 < 10; d7++) {
						if (d7 == d8 || d7 == d9 || d7 == d10) continue;
						if ((d7*100 + d8*10 + d9) % 13 != 0) continue;
						for (int d6 = 0; d6 < 10; d6++) {
							if (d6 == d7 || d6 == d8 || d6 == d9 || d6 == d10) continue;
							if ((d6*100 + d7*10 + d8) % 11 != 0) continue;
							for (int d5 = 0; d5 < 10; d5++) {
								if (d5 == d6 || d5 == d7 || d5 == d8 || d5 == d9 || d5 == d10) continue;
								if ((d5*100 + d6*10 + d7) % 7 != 0) continue;
								for (int d4 = 0; d4 < 10; d4++) {
									if (d4 == d5 || d4 == d6 || d4 == d7 || d4 == d8 || d4 == d9 || d4 == d10) continue;
									if ((d4*100 + d5*10 + d6) % 5 != 0) continue;
									for (int d3 = 0; d3 < 10; d3++) {
										if (d3 == d4 || d3 == d5 || d3 == d6 || d3 == d7 || d3 == d8 || d3 == d9 || d3 == d10) continue;
										if ((d3*100 + d4*10 + d5) % 3 != 0) continue;
										for (int d2 = 0; d2 < 10; d2++) {
											if (d2 == d3 || d2 == d4 || d2 == d5 || d2 == d6 || d2 == d7 || d2 == d8 || d2 == d9 || d2 == d10) continue;
											if ((d2*100 + d3*10 + d4) % 2 != 0) continue;
											for (int d1 = 0; d1 < 10; d1++) {
												if (d1 == d2 || d1 == d3 || d1 == d4 || d1 == d5 || d1 == d6 || d1 == d7 || d1 == d8 || d1 == d9 || d1 == d10) continue;
												sum += Long.parseLong(d1+""+d2+""+d3+""+d4+""+d5+""+d6+""+d7+""+d8+""+d9+""+d10);
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return sum;
	}
	
}
