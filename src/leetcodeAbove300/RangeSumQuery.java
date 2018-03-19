package leetcodeAbove300;
/*
 * 303. Range Sum Query - Immutable
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
	
	Example:
	Given nums = [-2, 0, 3, -5, 2, -1]
	
	sumRange(0, 2) -> 1
	sumRange(2, 5) -> -1
	sumRange(0, 5) -> -3
 */
public class RangeSumQuery {
	int sum;
    int[] arr;
    public RangeSumQuery(int[] nums) {
        arr = nums;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
    }
    
    public int sumRange(int i, int j) {
        if (i - 1 < 0)
            return arr[j];
        else if (j + 1 > arr.length)
            return arr[arr.length - 1] - arr[i - 1];
        else 
            return arr[j] - arr[i - 1];
    }
}
/*
 * 解题思路： 每一位进行叠加，i位等于nums[0] + nums[1] + ... + nums[i] (inclusive)
 * 这样sumRange（i，j）就等于 nums[j] - nums[i - 1], 注意判断边界情况。
 */
