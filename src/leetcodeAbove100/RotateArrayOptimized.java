package leetcodeAbove100;
/* 189. Rotate Array
 Rotate an array of n elements to the right by k steps.

For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

Note:
Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.

Could you do it in-place with O(1) extra space? */
public class RotateArrayOptimized {
	 public static void rotate(int[] nums, int k) {
	        if (nums == null || k < 0 || nums.length == 0) return;
	        
	        if (k > nums.length)
	            k = k % nums.length;
	        
	        // length of the first part
	        int len = nums.length - k;
	        
	        reverse(nums, 0, len - 1);
	        reverse(nums, len, nums.length - 1);
	        reverse(nums, 0, nums.length - 1);
	    }
	    
	    private static void reverse(int[] nums, int start, int end) {
	        if (nums == null || nums.length == 0)
	            return;
	        
	        while (start < end) {
	            int temp = nums[start];
	            nums[start] = nums[end];
	            nums[end] = temp;
	            start++;
	            end--;
	        }
	        
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/*
	 * 解题思路，以K为临界点，reverse两端，然后reverse全部，得到需求。
	 * 注意这里有一个坑，k 大于arr 长度时，必须取modulo！！
	 */

}
