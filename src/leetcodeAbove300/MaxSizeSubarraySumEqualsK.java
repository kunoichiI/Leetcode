package leetcodeAbove300;
import java.util.*;
//LC 325
//Given an array nums and a target value k, find the maximum length of a subarray that sums to k. If there isn't one, return 0 instead.
//
//Example 1:
//Given nums = [1, -1, 5, -2, 3], k = 3,
//return 4. (because the subarray [1, -1, 5, -2] sums to 3 and is the longest)
//
//Example 2:
//Given nums = [-2, -1, 2, 1], k = 1,
//return 2. (because the subarray [-1, 2] sums to 1 and is the longest)
//
//Follow Up:
//Can you do it in O(n) time?
public class MaxSizeSubarraySumEqualsK {
	public static int maxSubArrayLen(int k, int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		
		Map<Integer, Integer> map = new HashMap<>();
		int maxLen = 0;
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (sum == k) {
				return Math.max(maxLen, i + 1); /* 
				sum是截止当前element的和，如果sum == k，
				则说明这已经是最大长度subarray， index i 加1 即为长度*/
			}
			
			int diff = sum - k; /* k = sum - diff, 说明diff index（exclusive）到sum index（inclusive）
			之间的和等于target */
			if (map.containsKey(diff)) {
				maxLen = Math.max(maxLen, i - map.get(diff));
			}
			if (!map.containsKey(diff)) {
				map.put(sum, i); /* 存入每一位index和 its 累积之和*/
			}
		}
		return maxLen;
	}
	
	public static void main(String[] args) {
		int[] nums1 = { 1, -1, 5, -2, 3 };
		int[] nums2 = { 1, 3, 5, -2, -1 };
		System.out.println(maxSubArrayLen(3, nums1)); //=> 4 [1, -1, 5, -2]
		System.out.println(maxSubArrayLen(3, nums2)); //=> 1 [3]
		System.out.println(maxSubArrayLen(0, nums2)); // => 0 , cannot find,return max = 0;
	}
}
