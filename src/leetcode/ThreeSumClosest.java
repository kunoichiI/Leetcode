package leetcode;

import java.util.Arrays;

//16. 3Sum Closest  
//Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
//
//    For example, given array S = {-1 2 1 -4}, and target = 1.
//
//    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

public class ThreeSumClosest {
	public int threeSumClosest(int[] nums, int target) {
		if (nums == null || nums.length < 3) {
			return 0; //edge case
		}
		
		int min = Integer.MAX_VALUE;
		int val = 0;
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 2; i++) {
			int lo = i + 1;
			int hi = nums.length - 1;
			while (lo < hi) {
				int sum = nums[i] + nums[lo] + nums[hi];
				if (Math.abs(target - sum) < min) {
					min = Math.abs(target - sum);
					val = sum;
				}
			
				if (target == sum) {
					return val;
				}else if (target > sum) {
					lo++;
				}else {
					hi--;
				}
			}
		}
		return val;
	}
}
