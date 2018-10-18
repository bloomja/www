import java.math.BigInteger;
import java.util.ArrayList;

public class Math {
		
	/**
	 * @author Jonathan Bloom
	 * @param fraction the string representing the continued fraction
	 * @param n the index of the convergent being found
	 * @return array representing the numerator and denominator of the nth convergent of fraction, respectively.
	 * @since 10-9-2018
	 * @throws IllegalArgumentException
	 */
	public static long[] nthConvergentOfContinuedFraction(String fraction, int n) throws IllegalArgumentException {
		String[] s = fraction.substring(1,fraction.length()-1).replace(';', ',').split(",");
		long[] array;
		if (fraction.indexOf('(') < 0) {
			int m = 0;
			if (fraction.split(";")[1].length() > 1) {
				if (fraction.indexOf(",") < 0) {
					m = 1;
				} else {
					m = fraction.split(",").length;
				}
			}
			if (n > m) {
				throw new IllegalArgumentException("n cannot be larger than the length of the fraction.");
			} else {
				array = new long[s.length];
				for (int i = 0; i < array.length; i++) {
					array[i] = Long.parseLong(s[i]);
				}
			}
		} else {
			int start = -1;
			int period = -1;
			array = new long[n+1];
			for (int i = 0; i < n+1; i++) {
				if (i < s.length) {
					if (s[i].indexOf('(') >= 0) {
						start = i;
						period = s.length-start;
						if (s[i].indexOf(')') >= 0) {
							array[i] = Long.parseLong(s[i].substring(1,s[i].length()-1));
						} else {
							array[i] = Long.parseLong(s[i].substring(1));
						}
					} else if (s[i].indexOf(')') >= 0) {
						array[i] = Long.parseLong(s[i].substring(0, s[i].length()-1));
					} else {
						array[i] = Long.parseLong(s[i]);
					}
				} else {
					int index = i;
					while (!(index < s.length && index >= start)) {
						index -= period;
					}
					if (s[index].indexOf('(') >= 0) {
						if (s[index].indexOf(')') >= 0) {
							array[i] = Long.parseLong(s[index].substring(1, s[index].length()-1));
						} else {
							array[i] = Long.parseLong(s[index].substring(1));
						}
					} else if (s[index].indexOf(')') >= 0) {
						array[i] = Long.parseLong(s[index].substring(0,s[index].length()-1));
					} else {
						array[i] = Long.parseLong(s[index]);
					}
				}
			}
		}
		if (n == 0) {
			return new long[] {array[0],1};
		}
		long numerator = array[n];
		long denominator = 1;
		for (int i = n-1; i >= 0; i--) {
			long temp = numerator;
			numerator = denominator;
			denominator = temp;
			numerator += array[i] * denominator;
		}
		return new long[] {numerator, denominator};
	}
	
	/**
	 * @author Jonathan Bloom
	 * @param x the number to find the square root of
	 * @return The repeating continued fraction of sqrt(x) in the form [a0;(a1,a2,...,an)]
	 * @since 10-7-2018
	 */
	public static String continuedFractionOfSquareRoot(int x){
		double sqrt = java.lang.Math.sqrt(x);
		int a0 = (int)java.lang.Math.floor(sqrt);
		if (a0 == sqrt) {
			return "["+a0+";]";
		}
		ArrayList<Integer> array = new ArrayList<Integer>();
		ArrayList<Integer> barray = new ArrayList<Integer>();
		ArrayList<Integer> numerators = new ArrayList<Integer>();
		ArrayList<Integer> denominators = new ArrayList<Integer>();
		int a = a0;
		int b = 1;
		int n = a0;
		int d = x - a0*a0;
		while (true) {
			int nextA = (int)java.lang.Math.floor((b*sqrt+n)/d);
			int nextB = d*b;
			int nextN = -d*(n-nextA*d);
			int nextD = b*b*x-(n-nextA*d)*(n-nextA*d);
			a = nextA;
			b = nextB;
			n = nextN;
			d = nextD;
			if (n%b == 0 && d%b == 0) {
				n /= b;
				d /= b;
				b = 1;
			}
			if (a == 0 && b == 0 && n == 0 && d== 0) return "";
			if (array.size() > 0 && a == array.get(0) && b == barray.get(0) && n == numerators.get(0) && d == denominators.get(0)) {
				String ret = "["+a0+";(";
				for (int i = 0; i < array.size(); i++) {
					ret += array.get(i);
					if (i < array.size()-1) {
						ret += ",";
					}
				}
				ret += ")]";
				return ret;
			}
			array.add(a);
			barray.add(b);
			numerators.add(n);
			denominators.add(d);
		}
	}
	
}
