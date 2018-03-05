package leetcode;
// Optimal solution: time complexity O(n), space complexity O(1) ！！！
public class TrappingRainWaterTwoPointers {
	public static int trap(int[] height) {
		int left = 0, right = height.length - 1;
        int ans = 0;
        int left_max = 0, right_max = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= left_max) { 
                		left_max = height[left];
                }
                else {
                		ans += (left_max - height[left]);
                }
                left++;
            }
            else {
                if (height[right] >= right_max) {
                		right_max = height[right]; 
                }
                else {
                		ans += right_max - height[right];
                }
                right--;
            }
        }
        return ans;
	}
	public static void main(String[] args) {
		int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		System.out.println("Can trap this amount of rain water: " + trap(height)); // => 6
	}

		/*
		 * 在DP基础上进一步优化，用两个pointers代表max_left和max_right，在每一个index时两个值都可以被计算
		 * 第一个pointer从0开始，第二个从尾端，利用height【left】和height【right】的不同，比较出应该更新max_left
		 * 还是
		 */
}
