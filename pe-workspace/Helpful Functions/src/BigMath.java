import java.math.BigInteger;

public class BigMath {
	
	/**
	 * @author Jonathan Bloom
	 * @param fraction the string representing the continued fraction
	 * @param n the index of the convergent being found
	 * @return array of BigInteger representing the numerator and denominator of the nth convergent of fraction, respectively.
	 * @since 10-9-2018
	 * @throws IllegalArgumentException
	 */
	public static BigInteger[] nthConvergentOfContinuedFraction(String fraction, int n) throws IllegalArgumentException {
		String[] s = fraction.substring(1,fraction.length()-1).replace(';', ',').split(",");
		BigInteger[] array;
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
				array = new BigInteger[s.length];
				for (int i = 0; i < array.length; i++) {
					array[i] = new BigInteger(s[i]);
				}
			}
		} else {
			int start = -1;
			int period = -1;
			array = new BigInteger[n+1];
			for (int i = 0; i < n+1; i++) {
				if (i < s.length) {
					if (s[i].indexOf('(') >= 0) {
						start = i;
						period = s.length-start;
						if (s[i].indexOf(')') >= 0) {
							array[i] = new BigInteger(s[i].substring(1,s[i].length()-1));
						} else {
							array[i] = new BigInteger(s[i].substring(1));
						}
					} else if (s[i].indexOf(')') >= 0) {
						array[i] = new BigInteger(s[i].substring(0, s[i].length()-1));
					} else {
						array[i] = new BigInteger(s[i]);
					}
				} else {
					int index = i;
					while (!(index < s.length && index >= start)) {
						index -= period;
					}
					if (s[index].indexOf('(') >= 0) {
						if (s[index].indexOf(')') >= 0) {
							array[i] = new BigInteger(s[index].substring(1, s[index].length()-1));
						} else {
							array[i] = new BigInteger(s[index].substring(1));
						}
					} else if (s[index].indexOf(')') >= 0) {
						array[i] = new BigInteger(s[index].substring(0,s[index].length()-1));
					} else {
						array[i] = new BigInteger(s[index]);
					}
				}
			}
		}
		if (n == 0) {
			return new BigInteger[] {array[0],BigInteger.ONE};
		}
		BigInteger numerator = array[n];
		BigInteger denominator = BigInteger.ONE;
		for (int i = n-1; i >= 0; i--) {
			BigInteger temp = new BigInteger(numerator.toString());
			numerator = denominator.add(BigInteger.ZERO);
			denominator = temp.add(BigInteger.ZERO);
			numerator = numerator.add(array[i].multiply(denominator));
		}
		return new BigInteger[] {numerator, denominator};
	}
	
}
