package leetcodeAbove200;

public class MinimumSizeSubarraySumBetterBruteForceOn2 { // o(n^2) time complexity, O(n) space
	// Still Time Limit Exceed ...
	public static int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        int ans = Integer.MAX_VALUE;
        int len = nums.length;
        int[] sum = new int[len];
        sum[0] = nums[0];
        for (int i = 1; i < len; i++) {
            sum[i] = nums[i] + sum[i - 1];
        }
        
        for (int j = 0; j < len; j++) {
            for (int k = j; k < len; k++) {
                int sumOfElements = sum[k] - sum[j] + nums[j];
                if (sumOfElements >= s){
                    int length = k - j + 1;
                    ans = Math.min(length, ans);
                    break;
                }
            }
        }
        return ans != Integer.MAX_VALUE ? ans : 0;
    }
	public static void main(String[] args) {
		int[] arr = { 2, 3, 1, 2, 4, 3 };
		System.out.println(minSubArrayLen(7, arr)); // 2
	}
	/*
	 * 解题思路： 这个比最原始的Brute Force要好，用一个一维数组记住了累加Sum，然后对每一位的累加Sum
	 * 求i到j的和变成了 Sum[j] - sum[i] + nums[i], break用来跳出每一次的for loop（index开始于i的min length找到）
	 * 最后看ans是不是更新了，没更新说明不存在这样的sum >= s, return 0 instead.
	 */
}
