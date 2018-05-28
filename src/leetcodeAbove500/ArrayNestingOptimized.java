package leetcodeAbove500;

public class ArrayNestingOptimized {
	public int arrayNesting(int[] nums) { // O(n) time, O(1) space
		if (nums == null || nums.length == 0) return 0;
        
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
           int size = 0;
            for (int j = i; nums[j] >= 0; size++) {
                int start = nums[j];
                nums[j] = -1;
                j = start;
            }
            ans = Math.max(ans, size);
        }
        return ans;
    }
}
