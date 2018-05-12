package leetcodeAbove200;

public class HouseRobberIIConstantSpaceDP {
	/* Very smart way to improve space!! */
	public int rob(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        
        return Math.max(robBasic(nums, 0, nums.length - 2), robBasic(nums, 1, nums.length - 1));
    }
                        
    private int robBasic(int[] nums, int start, int end) {
        int preMax = 0;
        int currMax = 0;
        
        for (int i = start; i <= end; i++) {
            int temp = currMax;
            currMax = Math.max(currMax, preMax + nums[i]);
            preMax = temp;
        }
        return currMax;
    }
}
