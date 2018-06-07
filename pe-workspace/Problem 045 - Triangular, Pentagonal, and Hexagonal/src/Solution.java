
public class Solution {
	
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		
		long solution = solution();
		
		long time = System.currentTimeMillis() - start;
		
		System.out.println("Solution: " + solution);
		System.out.println("Runtime: " + (time/1000) + "." + (time%1000) + "s");
		
	}
	
	public static long solution() {
		int[] indices = {1,1,1};
		long[] nums = {0,1,1};
		while ((nums[0] <= 40755 || nums[1] <= 40755 || nums[2] <= 40755) || !(nums[0] == nums[1] && nums[1] == nums[2])) {
			if (nums[0] <= nums[1] && nums[0] <= nums[2]) {
				indices[0]++;
				nums[0] = triangle(indices[0]);
			} else if (nums[1] <= nums[2] && nums[1] <= nums[0]) {
				indices[1]++;
				nums[1] = pentagon(indices[1]);
			} else {
				indices[2]++;
				nums[2] = hexagon(indices[2]);
			}
		}
		return nums[0];
	}
	
	public static long triangle (long n) {
		return n*(n+1)/2;
	}
	
	public static long pentagon (long n) {
		return n*(3*n-1)/2;
	}
	
	public static long hexagon (long n) {
		return n*(2*n-1);
	}
	
}
