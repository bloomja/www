
public class InsertionSort {
	
	public static void sort (double[] a, int begin, int end) {
		if ((end - begin) >= 1) {
			int splitPoint = split(a, begin, end);
			sort(a, begin, splitPoint);
			sort(a, splitPoint + 1, end);
			join(a, begin, splitPoint, end);
		}
	}
	
	private static int split (double[] a, int begin, int end) {
		return end - 1;
	}
	
	private static void join (double[] a, int begin, int splitPoint, int end) {
		int index = end;
		if (a[end] <= a[begin]) {
			index = begin;
		} else if (a[end] >= a[splitPoint]) {
			index = end;
		} else {
			for (int i = begin; i < splitPoint; i++) {
				if (a[end] >= a[i] && a[end] <= a[i+1]) {
					index = i+1;
					break;
				}
			}
		}
		
		double temp = a[end];
		for (int i = end - 1; i >= index; i--) {
			a[i+1] = a[i];
		}
		a[index] = temp;
		
	}
	
}
