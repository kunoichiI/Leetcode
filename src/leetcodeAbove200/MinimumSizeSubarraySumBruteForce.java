package leetcodeAbove200;
/*
 *  209. Minimum Size Subarray Sum
 *  Given an array of n positive integers and a positive integer s, 
 *  find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.

For example, given the array [2,3,1,2,4,3] and s = 7,
the subarray [4,3] has the minimal length under the problem constraint.
 */

public class MinimumSizeSubarraySumBruteForce { // O(n^3) time, O(1) space
	public static int minSubArrayLen(int s, int[] nums) {
		int ans = Integer.MAX_VALUE;
		
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums.length; j++) {
				int sum = 0;
				for (int k = i; k <= j; k++) {
					sum += nums[k];
				}
				if (sum >= s) {
					int len = j - i + 1;
					ans = Math.min(ans, len);
					break; // find the minimum length starting at index i, move to next i
				}	
			}
		}
		return ans == Integer.MAX_VALUE ? 0 : ans;
	}
	public static void main(String[] args) {
		int[] arr = { 2, 3, 1, 2, 4, 3 };
		System.out.println(minSubArrayLen(7, arr)); // 2
	}

}
