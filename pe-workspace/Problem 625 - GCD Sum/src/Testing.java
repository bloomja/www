
public class Testing {
	
	public static void main(String[] args) {
		
		int count = 0;
		for (long i = 1; i <= 100000000000L; i++) {
			if (!expGrtOne(i)) count++;
		}
		System.out.println("Percent solved: " + (count/10000.0));
		
	}
	
	public static boolean expGrtOne(long p) {
		if (p < 4) return false;
		if (p % 4 == 0) return true;
		for (int i = 3; i <= Math.sqrt(p) + 1; i+=2) {
			if (p % (i*i) == 0) return true;
		} return false;
	}
	
	public static boolean isPrime(int p) {
		if (p == 2) return true;
		if (p < 2 || p % 2 == 0) return false;
		for (int i = 3; i <= Math.sqrt(p)+1; i+=2) {
			if (p % i == 0) return false;
		}
		return true;
	}
	
}
