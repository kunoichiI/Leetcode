package leetcode;

import java.util.Arrays;

public class MaximumSubarrayOptimized {
	/*
	 * return an int array of its start index, widow length & sum value
	 * assume there's at least one positive value in this array
	 */
	public static int[] maxSubarray(int[] nums) {
		int[] res = new int[3];
		int bestStart = 0;
		int bestLength = 0;
		int maxSum = nums[0];
		
		int curStart = 0;
		int curLength = 0;
		int curSum = maxSum;
		
		for (int i = 1; i < nums.length; i++) {
			if (curSum < 0) {
				curStart = i;
				curLength = 1;
				curSum = nums[i];
			}
			else {
				curLength += 1;
				curSum += nums[i];
			}
			
			if (curSum > maxSum) {
				maxSum = curSum;
				//System.out.println("maxSum: " + maxSum);
				bestStart = curStart;
				bestLength = curLength;
				//System.out.println("curLength: " + curLength);
			}
		}
		res[0] = bestStart;
		res[1] = bestLength;
		res[2] = maxSum;
		return res;
	}
	public static void main(String[] args) {
		int[] array1 = { -2, -3, 4, -1, -2, 1, 5, -3 };
		int[] array2 = { -2, -1, -4, 168 };
		int[] array3 = { 2, 1, 4, 168 };
		
		System.out.println(Arrays.toString(maxSubarray(array1))); // [2, 5, 7]
		System.out.println(Arrays.toString(maxSubarray(array2))); // [3, 1, 168]
		System.out.println(Arrays.toString(maxSubarray(array3))); // [0, 3, 175]
	}

	/*
	 * 解题思路：移动窗口sliding window法，curSum是第一个数值，如果curSum是正数，增加窗口size
	 * curLength + 1，curSum += nums【i】，如果是负数，curLength等于1，curStart取当前index
	 * 每一次循环内，判断curSum和bestSum的大小，不断更新bestSum， bestLength和bestStart，直到循环结束。
	 */
}
