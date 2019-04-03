
public class Prime {
	
	public static int[] sieveOfEratosthenes(int n) {
		boolean[] bArray = new boolean[n];
		for (int i = 0; i < n; i++) {
			bArray[i] = true;
		}
		bArray[0] = false;
		bArray[1] = false;
		int i = 2;
		while (i*i < n) {
			if (bArray[i]) {
				int k = i;
				while (i * k < n) {
					bArray[i*k] = false;
					k++;
				}
			}
			i++;
		}
		
		int len = 0;
		for (boolean b : bArray) {
			if (b) {
				len++;
			}
		}
		
		int[] ret = new int[len];
		int index = 0;
		for (int j = 0; j < n; j++) {
			if (bArray[j]) {
				ret[index] = j;
				index++;
			}
		}
		
		return ret;
	}
	
}
