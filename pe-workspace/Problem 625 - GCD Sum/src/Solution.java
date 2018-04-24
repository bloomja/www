
public class Solution {
	
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		
		//System.out.println(G(100000000000L));
		
		
		for (int b = 1; b < 100; b++) {
			System.out.print("row("+b+"): ");
			for (int i = b+1; i <= b+b; i++) {
				System.out.print(gcd(i, i-b)+",");
			}
			System.out.println();
		}
		
		for (int i = 1; i < 100; i++) {
			System.out.println(i+": "+rowSum(i));
		}
		
		long time = System.currentTimeMillis()-start;
		System.out.println("Runtime: " + (time/1000) + "." + (time%1000) + "s");
		
		//System.out.println("Runtime: " + (time/1000) + "." + (time%1000) + "s");
		
	}
	
	public static long rowSum(long p) {
		if (p == 0) return 0;
		if (isPrime(p)) return 2*p-1;
		long sum = 0;
		for (long i = 1; i <= p; i++) {
			sum += gcd(p+i, i);
		}
		return sum;
	}
	
	public static long G(long N) {
		long sum = 0;
		for (int i = 1; i <= N; i++) {
			sum += rowSum(i);
		}
		return sum;
	}

	
	
	
	
	
	
	
	public static long gcd(long a, long b) {
		if (b == 0) return a;
		return gcd(b, a % b);
	}
	
	public static boolean isPrime(long p) {
		for (int i = 2; i < Math.sqrt(p)+1; i++) {
			if (p % i == 0) return false;
		}
		return true;
	}
	
}
