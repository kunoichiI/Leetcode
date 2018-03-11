package leetcodeAbove100;
//152. Maximum Product Subarray
//Find the contiguous subarray within an array (containing at least one number) 
//which has the largest product.
//
//For example, given the array [2,3,-2,4],
//the contiguous subarray [2,3] has the largest product = 6.
public class MaximumProductSubarray {
	public static int maxProduct(int[] nums) {
		int res = nums[0];
        int curMax = nums[0], curMin = curMax;
        
        for (int i = 1; i < nums.length; i++) {
            int temp = curMax;
            curMax = Math.max(Math.max(curMax * nums[i], curMin * nums[i]), nums[i]);
            curMin = Math.min(Math.min(curMin * nums[i], temp * nums[i]), nums[i]);
            res = Math.max(res, curMax);
        }
        return res;
    }
	public static void main(String[] args) {
		int[] arr1 = { 2,3,-2,4 };
		int[] arr2 = { -2, 3, -4 };
		System.out.println(maxProduct(arr1)); // 6
		System.out.println(maxProduct(arr2)); // 24
	}
	/*
	 * 解题思路： 每次乘以下一个数值时都有可能产生最大或者最小值，所以需要用curMax和curMin进行记录每一动作产生的值
	 * 记得curMax要先用一个temp存起来，这样计算curMin的时候curMax还跟最初的curMax值一样。
	 * 最后返回res和curMax中较大的那一个。
	 */
}
