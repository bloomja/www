import java.util.ArrayList;

public class Solution {
	
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		
		int solution = solution();
		
		long time = System.currentTimeMillis() - start;
		
		System.out.println("Solution: " + solution);
		System.out.println("Runtime: " + (time/1000) + "." + (time%1000) + "s");
		
	}
	
	public static int solution() {
		int count = 0;
		ArrayList<Integer> partition = new ArrayList<Integer>();
		partition.add(100);
		while (partition.size() < 100) {
			int sum = 0;
			for (int i = partition.size()-1; i >= 0; i--) {
				if (partition.get(i) == 1) {
					sum += partition.remove(i);
				} else {
					int num = partition.remove(i)-1;
					partition.add(i, num);
					sum++;
					int sum2 = 0;
					while (sum2 < sum) {
						partition.add(Math.min(sum-sum2, num));
						sum2 += Math.min(sum-sum2, num);
					}
					count++;
					break;
				}
			}
		}
		return count;
	}
	
}
