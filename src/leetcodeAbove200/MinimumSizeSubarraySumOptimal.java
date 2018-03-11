package leetcodeAbove200;

public class MinimumSizeSubarraySumOptimal { // o(n) time, o(1) space
	public static int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        int ans = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= s) {
                ans = Math.min(ans, i + 1 - left);
                sum -= nums[left++];
            }
        }
        return ans != Integer.MAX_VALUE ? ans : 0;
    }
	public static void main(String[] args) {
		int[] arr = { 2, 3, 1, 2, 4, 3 };
		System.out.println(minSubArrayLen(7, arr)); // 2
	}
	
	/*
	 * 解题思路： 用一个指针left track左边的index，一个sum记录当前累加的和，
	 * 循环当前数列，当sum 大于等于s的时候，计算 i + 1 -left 并于最小长度进行比较，得到新的最小长度。
	 * 然后while循环里，当sum大于等于s的时候，left往右移懂，直到sum小于s，然后left到了新的index
	 * 如果往复，直到所有的元素都被遍历。输出ans
	 */

}
