package leetcode;
/*
 * 11. Container With Most Water
 * Given n non-negative integers a1, a2, ..., an, 
 * where each represents a point at coordinate (i, ai). 
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). 
 * Find two lines, which together with x-axis forms a container, 
 * such that the container contains the most water.

  Note: You may not slant the container and n is at least 2.


 */
public class ContainerWithMostWaterTwoPointers {
	public int maxArea(int[] height) {
        if (height == null || height.length == 0) return 0;
        int length = height.length;
        int max = Integer.MIN_VALUE;
        int start = 0, end = length - 1;
        
        while (start < end) {
            max = Math.max((end - start) * Math.min(height[end], height[start]), max);
            if (height[end] > height[start])
                start++;
            else
                end--;
        }
        return max;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
