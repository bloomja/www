import java.math.BigInteger;

public class Solution {
	
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		
		long solution = solution();
		
		long time = System.currentTimeMillis() - start;
		
		System.out.println("Solution: " + solution);
		System.out.println("Runtime: " + (time/1000) + "." + (time%1000) + "s");
		
	}
	
	public static long solution() {
		long sum = 0;
		for (int k = 0; k < 3; k++) {
			long[][] OP = OP(k);
			long FIT = 0;
			for (int i = 0; i <= k; i++) {
				long power = 1;
				for (int j = 0; j < i; j++) {
					power *= (k+2);
				}
	//			System.out.println("FIT += " + (OP[OP.length-1-i]*power));
				if (OP[OP.length-1-i][0] != 0 && OP[OP.length-1-i][1] != 0) {
					FIT += OP[OP.length-1-i][0] * power / OP[OP.length-1-i][1];
				}
			}
			for (int i = 0; i < OP.length; i++) {
	//			System.out.print(OP[i]+"* x^"+(OP.length-i-1)+" + ");
			}
	//		System.out.println();
	//		System.out.println(FIT);
			sum += FIT;
		}
		return sum;
	}
	
	public static long[][] solveMat(long[][] nMat, long[][] dMat) {
		for (int col = 0; col < nMat.length; col++) {
			if (nMat[col][col] == 0) System.out.println("ZERO HERE");
			if (nMat[col][col] != dMat[col][col] && nMat[col][col] != 0) {
				long[] a = new long[] {nMat[col][col], dMat[col][col]};
				for (int i = 0; i < nMat[col].length; i++) {
					nMat[col][i] *= a[1];
					dMat[col][i] *= a[0];
				}
			}
			for (int row = 0; row < nMat.length; row++) {
				if (row == col) continue;
				long[] a = new long[] {nMat[row][col], dMat[row][col]};
				for (int i = 0; i < nMat[col].length; i++) {
					nMat[row][i] = nMat[row][i]*dMat[col][i]*a[1] - a[0]*nMat[col][i];
					dMat[row][i] = dMat[row][i]*a[1]*dMat[col][i];
				}
			}
		}
		long[][] ret = new long[nMat.length][2];
		for (int i = 0; i < nMat.length; i++) {
			ret[i] = new long[] {nMat[i][nMat[i].length-1],dMat[i][dMat.length-1]};
		}
		return ret;
	}
	
	public static long[][] OP(int degree) {
		BigInteger[][] matrix = new BigInteger[degree+1][degree+2];
		for (int row = 0; row < degree+1; row++) {
			for (int col = 0; col < degree+1; col++) {
				BigInteger power = BigInteger.ONE;
				for (int k = 0; k <= degree-1-col; k++) {
					power = power.multiply(BigInteger.valueOf(row+1));
				}
				matrix[row][col] = power;
			}
		}
		for (int i = 0; i <= degree; i++) {
			matrix[i][degree+1] = u(i+1);
		}
		long[][] nMat = new long[matrix.length][matrix[0].length];
		long[][] dMat = new long[matrix.length][matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) { 
				nMat[i][j] = matrix[i][j].longValue();
				dMat[i][j] = 1;
			}
		}
		return solveMat(nMat, dMat);
	}
	
	public static BigInteger u(int n) {
		return BigInteger.valueOf(n).multiply(BigInteger.valueOf(n).multiply(BigInteger.valueOf(n)));
	}
	
/*	public static BigInteger u(int n) {
		BigInteger x = BigInteger.valueOf(n);
		return BigInteger.ONE
				.subtract(x)
				.add(x.multiply(x))
				.subtract(x.multiply(x).multiply(x))
				.add(x.multiply(x).multiply(x).multiply(x))
				.subtract(x.multiply(x).multiply(x).multiply(x).multiply(x))
				.add(x.multiply(x).multiply(x).multiply(x).multiply(x).multiply(x))
				.subtract(x.multiply(x).multiply(x).multiply(x).multiply(x).multiply(x).multiply(x))
				.add(x.multiply(x).multiply(x).multiply(x).multiply(x).multiply(x).multiply(x).multiply(x))
				.subtract(x.multiply(x).multiply(x).multiply(x).multiply(x).multiply(x).multiply(x).multiply(x).multiply(x))
				.add(x.multiply(x).multiply(x).multiply(x).multiply(x).multiply(x).multiply(x).multiply(x).multiply(x).multiply(x));
	}*/
	
}
