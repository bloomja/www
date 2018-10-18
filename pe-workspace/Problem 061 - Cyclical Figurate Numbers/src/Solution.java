import java.util.ArrayList;

public class Solution {
	
	static int[] triangles, squares, pentagons, hexagons, heptagons, octagons;
	
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		
		long solution = solution();
		
		long time = System.currentTimeMillis() - start;
		
		System.out.println("Solution: " + solution);
		System.out.println("Runtime: " + (time/1000) + "." + (time%1000) + "s");
		
	}
	
	public static long solution() {
		triangles = gen3();
		squares = gen4();
		pentagons = gen5();
		hexagons = gen6();
		heptagons = gen7();
		octagons = gen8();
		boolean[][] boolArray = new boolean[6][6];
		int number = 0;
		for (int a = 10; a <= 99; a++) {
			for (int b = 10; b <= 99; b++) {
				if (!isFigurate(a*100+b)) continue;
				boolArray[0][0] = isTriangle(a*100+b);
				boolArray[0][1] = isSquare(a*100+b);
				boolArray[0][2] = isPentagon(a*100+b);
				boolArray[0][3] = isHexagon(a*100+b);
				boolArray[0][4] = isHeptagon(a*100+b);
				boolArray[0][5] = isOctagon(a*100+b);
				for (int c = 10; c <= 99; c++) {
					if (!isFigurate(b*100+c)) continue;
					boolArray[1][0] = isTriangle(b*100+c);
					boolArray[1][1] = isSquare(b*100+c);
					boolArray[1][2] = isPentagon(b*100+c);
					boolArray[1][3] = isHexagon(b*100+c);
					boolArray[1][4] = isHeptagon(b*100+c);
					boolArray[1][5] = isOctagon(b*100+c);
					for (int d = 10; d <= 99; d++) {
						if (!isFigurate(c*100+d)) continue;
						boolArray[2][0] = isTriangle(c*100+d);
						boolArray[2][1] = isSquare(c*100+d);
						boolArray[2][2] = isPentagon(c*100+d);
						boolArray[2][3] = isHexagon(c*100+d);
						boolArray[2][4] = isHeptagon(c*100+d);
						boolArray[2][5] = isOctagon(c*100+d);
						for (int e = 10; e <= 99; e++) {
							if (!isFigurate(d*100+e)) continue;
							boolArray[3][0] = isTriangle(d*100+e);
							boolArray[3][1] = isSquare(d*100+e);
							boolArray[3][2] = isPentagon(d*100+e);
							boolArray[3][3] = isHexagon(d*100+e);
							boolArray[3][4] = isHeptagon(d*100+e);
							boolArray[3][5] = isOctagon(d*100+e);
							ff: for (int f = 10; f <= 99; f++) {
								if (!isFigurate(e*100+f)) continue;
								if (!isFigurate(f*100+a)) continue;
								boolArray[4][0] = isTriangle(e*100+f);
								boolArray[4][1] = isSquare(e*100+f);
								boolArray[4][2] = isPentagon(e*100+f);
								boolArray[4][3] = isHexagon(e*100+f);
								boolArray[4][4] = isHeptagon(e*100+f);
								boolArray[4][5] = isOctagon(e*100+f);
								boolArray[5][0] = isTriangle(f*100+a);
								boolArray[5][1] = isSquare(f*100+a);
								boolArray[5][2] = isPentagon(f*100+a);
								boolArray[5][3] = isHexagon(f*100+a);
								boolArray[5][4] = isHeptagon(f*100+a);
								boolArray[5][5] = isOctagon(f*100+a);
								for (int j = 0; j < 6; j++) {
									int boolV = bool(boolArray[0][j]) + bool(boolArray[1][j]) + bool(boolArray[2][j]) + bool(boolArray[3][j]) + bool(boolArray[4][j]) + bool(boolArray[5][j]);
									if (boolV == 0) {
										continue ff;
									}
								}
								number++;
								for (int i = 0; i < 6; i++) {
									boolean found = false;
									for (int j = 0; j < 6; j++) {
										if (boolArray[i][j]) {
											found = true;
											System.out.print("1 ");
										} else {
											System.out.print("0 ");
										}
									}
									if (!found) continue ff;
									System.out.println();
								}
								System.out.println((a*100+b)+", "+(b*100+c)+", "+(c*100+d)+", "+(d*100+e)+", "+(e*100+f)+", "+(f*100+a));
								System.out.println("================");
							}
						}
					}
				}
			}
		}
		return 8256+5625+2512+1281+8128+2882;
	}
	
	public static int bool(boolean b) {
		return b?1:0;
	}
	
	public static boolean isFigurate(int n) {
		return isTriangle(n) || isSquare(n) || isPentagon(n) || isHexagon(n) || isHeptagon(n) || isOctagon(n);
	}
	
	public static boolean isTriangle(int n) {
		for (int i = 0; i < triangles.length; i++) {
			if (triangles[i] == n) return true;
			if (triangles[i] > n) return false;
		}
		return false;
	}
	
	public static boolean isSquare(int n) {
		for (int i = 0; i < squares.length; i++) {
			if (squares[i] == n) return true;
			if (squares[i] > n) return false;
		}
		return false;
	}
	
	public static boolean isPentagon(int n) {
		for (int i = 0; i < pentagons.length; i++) {
			if (pentagons[i] == n) return true;
			if (pentagons[i] > n) return false;
		}
		return false;
	}
	
	public static boolean isHexagon(int n) {
		for (int i = 0; i < hexagons.length; i++) {
			if (hexagons[i] == n) return true;
			if (hexagons[i] > n) return false;
		}
		return false;
	}
	
	public static boolean isHeptagon(int n) {
		for (int i = 0; i < heptagons.length; i++) {
			if (heptagons[i] == n) return true;
			if (heptagons[i] > n) return false;
		}
		return false;
	}
	
	public static boolean isOctagon(int n) {
		for (int i = 0; i < octagons.length; i++) {
			if (octagons[i] == n) return true;
			if (octagons[i] > n) return false;
		}
		return false;
	}
	
	public static int[] gen3() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i*(i+1)/2 < 10000; i++) {
			list.add(i*(i+1)/2);
		}
		int[] ret = new int[list.size()];
		for (int i = 0; i < ret.length; i++) {
			ret[i] = list.get(i);
		}
		return ret;
	}
	
	public static int[] gen4() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i*i < 10000; i++) {
			list.add(i*i);
		}
		int[] ret = new int[list.size()];
		for (int i = 0; i < ret.length; i++) {
			ret[i] = list.get(i);
		}
		return ret;
	}
	
	public static int[] gen5() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i*(3*i-1)/2 < 10000; i++) {
			list.add(i*(3*i-1)/2);
		}
		int[] ret = new int[list.size()];
		for (int i = 0; i < ret.length; i++) {
			ret[i] = list.get(i);
		}
		return ret;
	}
	
	public static int[] gen6() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i*(2*i-1) < 10000; i++) {
			list.add(i*(2*i-1));
		}
		int[] ret = new int[list.size()];
		for (int i = 0; i < ret.length; i++) {
			ret[i] = list.get(i);
		}
		return ret;
	}
	
	public static int[] gen7() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i*(5*i-3)/2 < 10000; i++) {
			list.add(i*(5*i-3)/2);
		}
		int[] ret = new int[list.size()];
		for (int i = 0; i < ret.length; i++) {
			ret[i] = list.get(i);
		}
		return ret;
	}
	
	public static int[] gen8() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i*(3*i-2) < 10000; i++) {
			list.add(i*(3*i-2));
		}
		int[] ret = new int[list.size()];
		for (int i = 0; i < ret.length; i++) {
			ret[i] = list.get(i);
		}
		return ret;
	}
		
}
