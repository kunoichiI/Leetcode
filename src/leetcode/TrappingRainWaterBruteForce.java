package leetcode;
/* 42. Trapping Rain Water
Given n non-negative integers representing an elevation map where the width of each bar is 1, 
compute how much water it is able to trap after raining.

For example, 
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6. */
public class TrappingRainWaterBruteForce {
	public static int trap(int[] height) { // time complexity :O(n^2), space: O(1)
if (height == null || height.length == 0) return 0;
        
        int len = height.length;
        int res = 0;
        
        for (int i = 1; i < len - 1; i++) {
            int max_left = 0, max_right = 0;
            
            for (int j = i; j >= 0; j--) { // Search the left part for max bar size
                max_left = Math.max(max_left, height[j]);
            }
            
            for (int j = i; j < len; j++) { // Search the right part for max bar size
                max_right = Math.max(max_right, height[j]);
            }
            
            res += Math.min(max_left, max_right) - height[i];
        }
        return res;
	}
	public static void main(String[] args) {
		int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		System.out.println("Can trap this amount of rain water: " + trap(height)); // => 6
	}
	
	/*
	 * 解题思路：在每一个index处，可以trap的water数量为左右两边最大的bar高度取小，然后用这个数值减去当前bar高度
	 * 比如这个例子中，index=5时，当前bar高度是0， 左边最大bar是2， 右边是3，所以可以trap的雨水为Math.min（2，3） - 0 = 2
	 * 从index = 1 循环计算至 arr size - 2，因为最左和最右的block并不能trap water，得到相加的和res
	 */

}
