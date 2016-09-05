package leetcode;

//42. Trapping Rain Water  QuestionEditorial Solution  My Submissions
//Total Accepted: 78159
//Total Submissions: 231860
//Difficulty: Hard
//Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
//
//For example, 
//Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.

public class TrapRainWater {
	public int trap(int[] height) {
        if (height.length <= 2) return 0;
        int size = height.length;
        int[] left = new int[size];
        int[] right = new int[size];
        
        left[0] = height[0];
        for (int i = 1; i < size; i++) {
            left[i] = Math.max(left[i-1], height[i]);
        }
        
        right[size-1] = height[size-1];
        for (int i = size-2; i >= 0; i--) {
            right[i] = Math.max(right[i+1], height[i]);
        }
        
        int res = 0;
        
        for (int i = 0; i < size; i++) {
            res += Math.min(left[i], right[i]) - height[i];
        }
        return res;
    }
}
