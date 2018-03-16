package leetcodeAbove600;
/*
 * 628. Maximum Product of Three Numbers
 * Given an integer array, 
 * find three numbers whose product is maximum and output the maximum product.

	Example 1:
	Input: [1,2,3]
	Output: 6
	Example 2:
	Input: [1,2,3,4]
	Output: 24
	Note:
	The length of the given array will be in range [3,104] and all elements are in the range [-1000, 1000].
	Multiplication of any three numbers in the input won't exceed the range of 32-bit signed integer.
 */

public class MaximumProductOfThreeNumbers { // o(n) time, o(1) space. Optimal solution!
	public static int maximumProduct(int[] nums) {
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        
        for (int n : nums) {
            if (n <= min1) {
                min2 = min1;
                min1 = n;
            } else if (n <= min2) { // n lies between min1 & min2
                min2 = n;
            }
            
            if (n >= max1) { // n is greater than max1, max2 and max3
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (n >= max2) { // n is greater than max2 and smaller than max1
                max3 = max2;
                max2 = n;
            } else if (n >= max3) { // n is greater than max3 and smaller than max1 & max2
                max3 = n;
            }
        }
        return Math.max(min1 * min2 * max1, max1 * max2 * max3);
    }
	
	/*
	 *  解题思路：以上的循环一遍找到最大和最小值的解法非常棒！ 用区间法判断最大最小值
	 *  这是最佳的解法。也可以用Arrays.sort先sort array，然后用最后一句判断最大乘积。但时间复杂度就高了些
	 */

}
