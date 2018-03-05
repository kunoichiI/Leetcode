package leetcode;
// time complexity: O(n), space complexity : O(n)
public class TrappingRainWaterDynamicProgramming {
	public static int trap(int[] height) {
		if (height == null || height.length == 0) return 0;
        
        int len = height.length;
        int res = 0;
        
        // Dynamic Programming
        int[] max_left = new int[len];
        max_left[0] = height[0];
        for (int i = 1; i < len; i++) {
            max_left[i] = Math.max(max_left[i - 1], height[i]);
        }
        
        int[] max_right = new int[len];
        max_right[len - 1] = height[len - 1];
        for (int j = len - 2; j >= 0; j--) {
            max_right[j] = Math.max(max_right[j + 1], height[j]);
        }
        
        for (int idx = 0; idx < len; idx++) {
            res += Math.min(max_right[idx], max_left[idx]) - height[idx];
        }
        
        return res;
	}
	public static void main(String[] args) {
		int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		System.out.println("Can trap this amount of rain water: " + trap(height)); // => 6
	}
	/*
	 * 在Brute Force解法中，我们反复计算了当前index处的maxleft和maxright，所以DP方法用两个array存了每个index
	 * 处的maxleft和maxRight， 最后的计算方法和BF其实是一样的。
	 */
}
